SUMMARY = "C IOTA workshop"
DESCRIPTION = "Some simple examples to get you started on developing with IOTA using C."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
            git://github.com/bernardoaraujor/c-iota-workshop.git \
	    file://0001-add-yocto-toolchain-to-bazel-workshop-example.patch \
	    file://BUILD \
	    file://BUILD.yocto_compiler \
	    file://CROSSTOOL.tpl \
	    file://yocto_compiler_configure.bzl \
"

SRCREV = "${AUTOREV}"

DEPENDS += " bazel-native"

inherit bazel

S = "${WORKDIR}/git"

do_configure_append() {
    mkdir -p ${S}/third_party/toolchains/yocto/
    install -m 644 ${WORKDIR}/BUILD ${S}/third_party/toolchains/yocto/
    install -m 644 ${WORKDIR}/CROSSTOOL.tpl ${S}/third_party/toolchains/yocto/
    install -m 644 ${WORKDIR}/yocto_compiler_configure.bzl ${S}/third_party/toolchains/yocto/
    install -m 644 ${WORKDIR}/BUILD.yocto_compiler ${S}

    echo ${HOST_PREFIX}

    CT_NAME=$(echo ${HOST_PREFIX} | sed 's/.$//')
    echo ${CT_NAME}
    SED_COMMAND="s#%%CT_NAME%%#${CT_NAME}#g"
    SED_COMMAND="${SED_COMMAND}; s#%%WORKDIR%%#${WORKDIR}#g"
    SED_COMMAND="${SED_COMMAND}; s#%%YOCTO_COMPILER_PATH%%#${BAZEL_OUTPUTBASE_DIR}/external/yocto_compiler#g"

    sed -i "${SED_COMMAND}" ${S}/BUILD.yocto_compiler \
                            ${S}/third_party/toolchains/yocto/CROSSTOOL.tpl \
                            ${S}/WORKSPACE
}

do_compile(){
    unset CC
    ${S}/bazel build \
        -c opt \
        --cpu=armeabi \
        --subcommands --explain=${T}/explain.log \
        --verbose_explanations --verbose_failures \
        --crosstool_top=@local_config_yocto_compiler//:toolchain \
        --verbose_failures \
        --copt -DTF_LITE_DISABLE_X86_NEON \
	--strip=always \
        //examples:hello_world \
	//examples:send_hello \
	//examples:receive_hello \
	//examples:generate_address \
	//examples:check_balances \

    ${S}/bazel shutdown
}

do_install(){
    # install binaries
    install -m 0755 -d ${D}${bindir}

    install -m 0755 ${S}/bazel-bin/examples/hello_world ${D}${bindir}
    install -m 0755 ${S}/bazel-bin/examples/send_hello ${D}${bindir}
    install -m 0755 ${S}/bazel-bin/examples/receive_hello ${D}${bindir}
    install -m 0755 ${S}/bazel-bin/examples/generate_address ${D}${bindir}
    install -m 0755 ${S}/bazel-bin/examples/check_balances ${D}${bindir}

    # add iota_ prefix to binaries
    cd ${D}${bindir}
    for FILENAME in *; do mv $FILENAME iota_$FILENAME; done 
}

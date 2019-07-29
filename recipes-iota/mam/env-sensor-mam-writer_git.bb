SUMMARY = "IOTA Sensor MAM Demo."
DESCRIPTION = "An application which reads the env sensor data from a MAM channel."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
            git://github.com/iota-community/env-sensor-mam-reader.git;branch=json; \
	    file://0001-add-yocto-toolchain-to-bazel.patch \
	    file://0002-add-lm-linkopt.patch \
	    file://BUILD \
	    file://BUILD.yocto_compiler \
	    file://CROSSTOOL.tpl \
	    file://yocto_compiler_configure.bzl \
"

SRCREV = "${AUTOREV}"

DEPENDS += " bazel-native"

inherit bazel

S = "${WORKDIR}/git"

do_configure_append () {
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
        //app:app

    ${S}/bazel shutdown
}

do_install(){
    # install binary

    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/bazel-bin/app/app ${D}${bindir}   

    # rename binary
    mv ${D}${bindir}/app ${D}${bindir}/iota-env-sensor-mam-writer
}

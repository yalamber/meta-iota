SUMMARY = "A low level C implementation of IOTA largely inspired by the IRI."
DESCRIPTION = "cIRI allows users to become part of the IOTA network as both a transaction relay and network information provider through the easy-to-use API."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = " \
	    git://github.com/iotaledger/entangled;tag=mam-0.1.0;nobranch=1 \
	    file://0001-add-yocto-toolchain-to-bazel.patch \
	    file://0002-fix-tools-snapshot.bzl-checksums.patch \
	    file://0003-add-linkopt-to-ciri-BUILD.patch \
	    file://BUILD \
	    file://BUILD.yocto_compiler \
	    file://CROSSTOOL.tpl \
	    file://yocto_compiler_configure.bzl \
"

DEPENDS = "bazel-native"
RDEPENDS_${PN} = "sqlite3"

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
        //ciri:ciri

    ${S}/bazel shutdown
}

FILES_${PN} += "${libdir}"

do_install(){
    install -m 0755 -d ${D}${bindir}
    install -m 0755 -d ${D}${libdir}

    install -m 0755 ${S}/bazel-bin/ciri/ciri ${D}${bindir}
}

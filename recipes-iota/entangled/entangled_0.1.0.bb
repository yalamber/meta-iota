SUMMARY = "enTangle'd is an amalgamation of entangled IOTA projects."
DESCRIPTION = "enTangle'd is a monorepo containing all you need to get [IOTA] operating in C/C++. \
It contains IOTA components, models as well as cryptography primitives used in IOTA. \
\
This package exports IOTA enTangle'd libcclient.so, libcommon.so and libutils.so to other projects. \
"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = " \
            git://github.com/bernardoaraujor/entangled;branch=develop;name=entangled \
	    file://0001-add-yocto-toolchain-to-bazel.patch \
	    file://0002-add-linkopt-to-ciri-BUILD.patch \
	    file://0003-set-iota_rules-to-fork.patch \
	    file://BUILD \
	    file://BUILD.yocto_compiler \
	    file://CROSSTOOL.tpl \
	    file://yocto_compiler_configure.bzl \
	    git://github.com/iotaledger/snapshots.git;name=snapshots;destsuffix=snapshots \
"

SRCREV_entangled = "d42d48c19d35837c68add8bb579237944787050c"
SRCREV_snapshots = "${AUTOREV}"

DEPENDS += " bazel-native"

inherit bazel pkgconfig gettext

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
        //cclient/api:libcclient.so \
        //mam:libmam.so \
        //common:libcommon.so \
        //utils:libutils.so \

    ${S}/bazel shutdown
}

FILES_${PN} += "${libdir}"
FILES_${PN}-dev += "\
                    ${libdir}/libcclient.so \
                    ${libdir}/libmam.so \
                    ${libdir}/libcommon.so \
                    ${libdir}/libutils.so \
"

# TODO: find proper workaround for this
INSANE_SKIP_${PN}-dev += "dev-elf"

do_install(){
    # install libs

    install -m 0755 -d ${D}${libdir}

    install -m 0755 ${S}/bazel-bin/cclient/api/libcclient.so ${D}${libdir}
    install -m 0755 ${S}/bazel-bin/mam/libmam.so ${D}${libdir}
    install -m 0755 ${S}/bazel-bin/common/libcommon.so ${D}${libdir}
    install -m 0755 ${S}/bazel-bin/utils/libutils.so ${D}${libdir}

    ## install headers
    # copy a bunch of stuff (including headers)

    install -m 0755 -d ${D}${includedir}
    cp -r ${S}/cclient ${D}${includedir}
    cp -r ${S}/mam ${D}${includedir}
    cp -r ${S}/common ${D}${includedir}
    cp -r ${S}/utils ${D}${includedir}
    install -m 0644 ${S}/bazel-out/armeabi-opt/bin/utils/containers/hash/*.h ${D}${includedir}/utils/containers/hash

    ## install headers
    # delete everything that's not *.h
    find ${D}${includedir} -type f -not -name '*.h' -print0 | xargs -0 -I {} rm -r {}
}

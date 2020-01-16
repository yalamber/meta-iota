SUMMARY = "A low level C implementation of IOTA largely inspired by the IRI."
DESCRIPTION = "cIRI allows users to become part of the IOTA network as both a transaction relay and network information provider through the easy-to-use API."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = " \
            git://github.com/iotaledger/entangled;branch=develop;name=entangled \
	    file://0001-add-yocto-toolchain-to-bazel.patch \
	    file://0002-add-linkopt-to-ciri-BUILD.patch \
	    file://0003-remove-bazel_skylib-from-WORKSPACE.patch \
	    file://0004-remove-unused-definitions-from-WORKSPACE.patch \
	    file://0005-rm-docker-rules-from-ciri-BUILD.patch \
	    file://0006-set-iota_rules-to-fork.patch \
	    file://BUILD \
	    file://BUILD.yocto_compiler \
	    file://CROSSTOOL.tpl \
	    file://yocto_compiler_configure.bzl \
	    git://github.com/iotaledger/snapshots.git;name=snapshots;destsuffix=snapshots \
"

SRCREV_entangled = "ciri-0.1.0-alpha"
SRCREV_snapshots = "${AUTOREV}"

SRCREV_FORMAT = "entangled_snapshots"

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
        //ciri:ciri

    ${S}/bazel shutdown
}

FILES_${PN} += "${sysconfdir}/iota/config/conf.yml"
FILES_${PN} += "${sysconfdir}/iota/snapshots/*"
FILES_${PN} += "${sysconfdir}/iota/sql/*"

# IOTA Ledger snapshots
# if you want to overwrite the timestamp, set it at local.conf
SNAPSHOT_TIMESTAMP_MAINNET ?= "20190410"
SNAPSHOT_TIMESTAMP_TESTNET ?= "20180329"

do_install(){
    # install executable

    install -m 0755 -d ${D}${bindir}

    install -m 0755 ${S}/bazel-bin/ciri/ciri ${D}${bindir}

    # install snapshots

    install -m 0755 -d ${D}${sysconfdir}/iota/snapshots/mainnet
    install -m 0755 -d ${D}${sysconfdir}/iota/snapshots/testnet
    
    install -m 0644 ${WORKDIR}/snapshots/mainnet/${SNAPSHOT_TIMESTAMP_MAINNET}/snapshot.json ${D}${sysconfdir}/iota/snapshots/mainnet
    install -m 0644 ${WORKDIR}/snapshots/mainnet/${SNAPSHOT_TIMESTAMP_MAINNET}/snapshot.sig ${D}${sysconfdir}/iota/snapshots/mainnet
    install -m 0644 ${WORKDIR}/snapshots/mainnet/${SNAPSHOT_TIMESTAMP_MAINNET}/snapshot.txt ${D}${sysconfdir}/iota/snapshots/mainnet

    install -m 0644 ${WORKDIR}/snapshots/testnet/${SNAPSHOT_TIMESTAMP_TESTNET}/snapshot.json ${D}${sysconfdir}/iota/snapshots/testnet
    install -m 0644 ${WORKDIR}/snapshots/testnet/${SNAPSHOT_TIMESTAMP_TESTNET}/snapshot.txt ${D}${sysconfdir}/iota/snapshots/testnet

    # install sql schemas

    install -m 0755 -d ${D}${sysconfdir}/iota/sql

    install -m 0644 ${S}/common/storage/sql/sqlite3/spent-addresses-schema.sql ${D}${sysconfdir}/iota/sql
    install -m 0644 ${S}/common/storage/sql/sqlite3/tangle-schema.sql ${D}${sysconfdir}/iota/sql

    # install yaml config

    install -m 0755 -d ${D}${sysconfdir}/iota/config

    install -m 0644 ${S}/ciri/conf.example.yml ${D}${sysconfdir}/iota/config/conf.yml
}

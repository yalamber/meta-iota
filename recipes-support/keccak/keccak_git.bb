SUMMARY = "eXtended Keccak Code Package."
DESCRIPTION = "The eXtended Keccak Code Package (or the Xoodoo and Keccak Code Package, in both cases abbreviated as XKCP) gathers different free and open-source implementations of the Keccak sponge function family and closely related variants."
HOMEPAGE = "https://keccak.team/"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "git://github.com/XKCP/XKCP.git"
SRCREV = "87944d97ee18978aa0ea8486edbb7acb08a8564a"

PR = "r0"

S = "${WORKDIR}/git"

DEPENDS = "libxslt-native"

do_compile() {
    oe_runmake compact/libkeccak.a
}

do_install() {
    #install libkeccak.a

    install -d ${D}${libdir}
    install -m 0644 ${S}/bin/compact/libkeccak.a ${D}${libdir}

    ## install headers
    # copy a bunch of stuff (including headers)

    install -m 0755 -d ${D}${includedir}/keccak
    cp -r ${S}/lib/* ${D}${includedir}/keccak

    ## install headers
    # delete everything that's not *.h
    find ${D}${includedir}/keccak -type f -not -name '*.h' -print0 | xargs -0 -I {} rm -r {}

    ## install headers
    # place all headers in root keccak directory
    find ${D}${includedir}/keccak -type f -name '*.h' -print0 | xargs -0 -I {} cp {} ${D}${includedir}/keccak
}

BBCLASSEXTEND = "native nativesdk"

SUMMARY = "Cockpit plugins for Aero platform"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS = "cockpit"

SRCREV = "${AUTOREV}"
SRC_URI = "git://git@github.com/bernardoaraujor/honeycomb-cockpit-plugins/;protocol=https"

S = "${WORKDIR}/git"

do_configure() {
}

do_compile() {
}

do_install() {
    cd ${S}
    make V=1 DEST=${D} install
}

FILES_${PN} = "${datadir}"

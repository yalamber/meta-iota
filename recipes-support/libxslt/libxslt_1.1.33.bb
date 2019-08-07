SUMMARY = "XSLT transformation library."
HOMEPAGE = "https://xmlsoft.org/XSLT"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://Copyright;md5=0cd9a07afbeb24026c9b03aecfeba458"

SRC_URI = "git://github.com/GNOME/libxslt.git"
SRCREV = "v${PV}"

PR = "r0"

inherit autotools python3native

DEPENDS = "libxml2"

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native nativesdk"

FILES_${PN} = "${libdir} ${bindir}"

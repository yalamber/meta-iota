SUMMARY = "Protocol Buffers with small code size."
DESCRIPTION = "Nanopb is a plain-C implementation of Google's Protocol Buffers data format. It is targeted at 32 bit microcontrollers, but is also fit for other embedded systems with tight (<10 kB ROM, <1 kB RAM) memory constraints."
HOMEPAGE = "https://jpa.kapsi.fi/nanopb/"

LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Zlib;md5=87f239f408daca8a157858e192597633"

SRC_URI = "git://github.com/nanopb/nanopb.git;nobranch=1;tag=${PV}"

inherit cmake pythonnative

DEPENDS = "protobuf-native"
RDEPENDS_${PN}-native = "python-six-native python-protobuf-native"

S = "${WORKDIR}/git"

FILES_${PN} = "${libdir}/python2.7"

BBCLASSEXTEND = "native nativesdk"

FILES_${PN} += "${sysconfdir}/nanopb/"

do_compile_append(){
    cd ${S}/generator/proto
    oe_runmake
}

do_install_append(){
    install -m 0755 -d ${D}${sysconfdir}/nanopb/
    cp -r ${S}/generator ${D}${sysconfdir}/nanopb/

    install -m 0755 -d ${D}${includedir}
    install -m 0644 ${S}/*.h ${D}${includedir}
}

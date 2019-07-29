SUMMARY = "Protocol Buffers with small code size."
DESCRIPTION = "Nanopb is a plain-C implementation of Google's Protocol Buffers data format. It is targeted at 32 bit microcontrollers, but is also fit for other embedded systems with tight (<10 kB ROM, <1 kB RAM) memory constraints."
HOMEPAGE = "https://jpa.kapsi.fi/nanopb/"

LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Zlib;md5=87f239f408daca8a157858e192597633"

SRC_URI = "git://github.com/nanopb/nanopb.git;nobranch=1;tag=${PV}"

inherit cmake pythonnative

DEPENDS = "protobuf-native"

S = "${WORKDIR}/git"

FILES_${PN} = "${libdir}/python2.7"

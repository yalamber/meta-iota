SUMMARY = "Logging facility for C"
DESCRIPTION = "Logger is a simple logging facility for the C language. It is possible to output logging information to different output stream and to use different logging severities."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=69b7473cbfd6137e8663714c033adcfc"

SRC_URI = "git://github.com/embear/logger.git;nobranch=1"
SRCREV = "v${PV}"

PR = "r0"

S = "${WORKDIR}/git"

inherit cmake

do_install_append(){
    # install headers

    install -m 0755 -d ${D}${includedir}
    install -m 0644 ${S}/include/logger.h ${D}${includedir}

}

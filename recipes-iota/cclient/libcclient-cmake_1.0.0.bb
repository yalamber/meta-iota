SUMMARY = "IOTA CClient Library."
DESCRIPTION = "IOTA client library implementation in C"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = " \
            git:///home/bernardoaraujo/dev/entangled;protocol=file;branch=cmake_cclient \
            file://0001-add-YOCTO-option-to-CMakeLists.txt.patch \
"

SRCREV = "ca267a49bad4ce207620b3bdcb3fa0a30a501b67"

DEPENDS = "keccak uthash mbedtls logger http-parser cjson unity"

inherit cmake

EXTRA_OECMAKE = "-DYOCTO=ON -DCCLIENT_TEST=OFF"

S = "${WORKDIR}/git"

do_install_append(){
    mv ${D}${includedir}/entangled/* ${D}${includedir}
}

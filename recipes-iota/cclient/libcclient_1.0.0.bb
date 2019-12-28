SUMMARY = "IOTA CClient Library."
DESCRIPTION = "IOTA client library implementation in C"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = " \
            git://github.com/iotaledger/entangled.git;branch=develop \
            file://0001-add-YOCTO-option-to-CMakeLists.txt.patch \
"

SRCREV = "570b8da680967c4a0f8a054d9c024e2e5d21a991"

RDEPENDS_${PN}-dev = ""
DEPENDS = "keccak uthash mbedtls logger http-parser cjson"

inherit cmake

EXTRA_OECMAKE = "-DYOCTO=ON -DCCLIENT_TEST=OFF"

S = "${WORKDIR}/git"

# leaving the headers on /usr/include/entangled causes incompatibility with the includes
do_install_append(){
    mv ${D}${includedir}/entangled/* ${D}${includedir}
}

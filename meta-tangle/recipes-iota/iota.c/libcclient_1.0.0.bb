SUMMARY = "IOTA CClient Library."
DESCRIPTION = "IOTA client library implementation in C"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = " \
            git://github.com/iotaledger/iota.c.git;branch=master \
            file://0001-add-YOCTO-option-to-CMakeLists.patch \
"

SRCREV = "746901830780966e8b28e61e5151c018b6c5608f"

RDEPENDS_${PN}-dev = ""
DEPENDS = "libcommon keccak uthash mbedtls logger http-parser cjson"

inherit cmake

EXTRA_OECMAKE = "-DYOCTO=ON -DCCLIENT_TEST=OFF"

S = "${WORKDIR}/git"

SUMMARY = "IOTA Common functions and crypto implementations in C."
DESCRIPTION = "IOTA Common functions and crypto implementations in C "
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/iotaledger/iota_common.git;branch=master"
SRCREV = "487ee2f3a7192bba4c0179f11d774408c6484bc4"

RDEPENDS_${PN}-dev = ""
DEPENDS = "keccak uthash mbedtls logger http-parser cjson"

inherit cmake

EXTRA_OECMAKE = "-DYOCTO=ON "

S = "${WORKDIR}/git"

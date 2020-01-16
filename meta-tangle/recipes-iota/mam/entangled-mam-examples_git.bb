SUMMARY = "Masked Authentication Messaging (MAM) examples from enTangle'd repo "
DESCRIPTION = "Some simple examples to get you started on developing with IOTA MAM using C."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = " \
            git://github.com/bernardoaraujor/entangled-mam-examples.git \
"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = " libmam mbedtls uthash keccak logger"

do_install(){
    install -m 0755 -d ${D}${bindir}

    install -m 0755 ${S}/iota_mam_send_msg ${D}${bindir}
    install -m 0755 ${S}/iota_mam_send_packet ${D}${bindir}
    install -m 0755 ${S}/iota_mam_send_header ${D}${bindir}
    install -m 0755 ${S}/iota_mam_recv ${D}${bindir}
    install -m 0755 ${S}/iota_mam_ntru_key_exchange ${D}${bindir}
}

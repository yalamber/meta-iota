SUMMARY = "C IOTA workshop"
DESCRIPTION = "Some simple examples to get you started on developing with IOTA using C."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
            git://github.com/iota-community/c-iota-workshop.git \
"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = " libcclient"

do_compile(){
   ${CC} -I${S} ${CFLAGS} ${LDFLAGS} iota_client_service/client_service.c 
}

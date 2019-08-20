SUMMARY = "C IOTA workshop"
DESCRIPTION = "Some simple examples to get you started on developing with IOTA using C."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
            git://github.com/iota-community/c-iota-workshop.git \
"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = " libcclient uthash keccak logger"
RDEPENDS_${PN} = "libcclient"

do_compile(){
   ${CC} -I${S} ${CFLAGS} ${LDFLAGS} -o iota_c_hello_world examples/e01_hello_world.c iota_client_service/client_service.c -lcclient
}

do_install(){
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/iota_c_hello_world ${D}${bindir}
}

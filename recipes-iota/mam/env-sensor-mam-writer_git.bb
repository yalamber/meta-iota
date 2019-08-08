SUMMARY = "IOTA Sensor MAM Demo."
DESCRIPTION = "An application which reads the env sensor data from a MAM channel."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
            git://github.com/iota-community/env-sensor-mam-writer.git;branch=json; \
	    file://0002-fix-mam_api_bundle_write_header_on_endpoint.patch \
	    file://0003-fix-mam_api_bundle_write_header_on_channel.patch \
	    file://0004-fix-MAM_ENDPOINT_ID_TRYTE_SIZE.patch \
	    file://0005-fix-MAM_CHANNEL_ID_TRYTE_SIZE.patch \
"

SRCREV = "${AUTOREV}"

DEPENDS += " entangled mbedtls http-parser uthash keccak logger"

S = "${WORKDIR}/git"

#CFLAGS_prepend = "-I${S} "


do_compile(){
    ${CC} -c iota/common.c -lcclient -lmam
    ${CC} -c iota/send-common.c 
}

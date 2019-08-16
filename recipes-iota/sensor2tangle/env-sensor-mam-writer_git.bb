SUMMARY = "IOTA Sensor MAM Demo."
DESCRIPTION = "An application which reads the env sensor data from a MAM channel."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
            git://github.com/iota-community/env-sensor-mam-writer.git;branch=json; \
"

SRCREV = "${AUTOREV}"

DEPENDS += " mam mbedtls http-parser uthash keccak logger nanopb python-six-native python-protobuf-native nanopb-native"

inherit pythonnative

S = "${WORKDIR}/git"

do_configure(){
    protoc --plugin=${RECIPE_SYSROOT_NATIVE}/opt/nanopb/generator/protoc-gen-nanopb --nanopb_out=${S}/proto_compiled iota/proto/DataRequest.proto
    protoc --plugin=${RECIPE_SYSROOT_NATIVE}/opt/nanopb/generator/protoc-gen-nanopb --nanopb_out=${S}/proto_compiled iota/proto/DataResponse.proto
    protoc --plugin=${RECIPE_SYSROOT_NATIVE}/opt/nanopb/generator/protoc-gen-nanopb --nanopb_out=${S}/proto_compiled iota/proto/FeatureResponse.proto

    rm ${S}/proto_compiled/*.pb.*
    mv ${S}/proto_compiled/iota/proto/* ${S}/proto_compiled
}

do_compile(){
    ${CC} -c iota/common.c
    ${CC} -c iota/send-common.c
    ${CC} -c iota/send-header.c
    ${CC} -c iota/send-msg.c
    ${CC} -c iota/send-packet.c
    ${CC} -c iota/recv.c

    ${CC} -I${S} -c logging/logging.c

    ${CC} -I${S} -c encode/encode.c
}

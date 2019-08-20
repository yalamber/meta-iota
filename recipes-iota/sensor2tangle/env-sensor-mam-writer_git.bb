SUMMARY = "IOTA Sensor MAM Demo."
DESCRIPTION = "An application which reads the env sensor data from a MAM channel."
AUTHOR = "Philipp Blum <philipp.blum@iota.org>"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
            git://github.com/bernardoaraujor/env-sensor-mam-writer.git; \
"

SRCREV = "${AUTOREV}"

DEPENDS += " mam mbedtls http-parser uthash keccak logger nanopb python-six-native python-protobuf-native nanopb-native"

inherit pythonnative

S = "${WORKDIR}/git"

do_configure(){
    mkdir -p ${S}/proto_compiled

    protoc --plugin=${RECIPE_SYSROOT_NATIVE}/opt/nanopb/generator/protoc-gen-nanopb --nanopb_out=${S}/proto_compiled iota/proto/DataRequest.proto
    protoc --plugin=${RECIPE_SYSROOT_NATIVE}/opt/nanopb/generator/protoc-gen-nanopb --nanopb_out=${S}/proto_compiled iota/proto/DataResponse.proto
    protoc --plugin=${RECIPE_SYSROOT_NATIVE}/opt/nanopb/generator/protoc-gen-nanopb --nanopb_out=${S}/proto_compiled iota/proto/FeatureResponse.proto

    mv ${S}/proto_compiled/iota/proto/* ${S}/proto_compiled
    rm -r ${S}/proto_compiled/iota
}

do_compile(){
    ${CC} -c iota/common.c
    ${CC} -c iota/send-common.c
    ${CC} -c iota/send-header.c
    ${CC} -c iota/send-msg.c
    ${CC} -c iota/send-packet.c
    ${CC} -c iota/recv.c

    ${CC} -I${S} -c logging/logging.c

    ${CC} -I${S} ${CFLAGS} ${LDFLAGS} -c proto_compiled/DataRequest.pb.c -o DataRequest.pb.o
    ${AR} rcs libDataRequest.a DataRequest.pb.o

    ${CC} -I${S} ${CFLAGS} ${LDFLAGS} -c proto_compiled/DataResponse.pb.c -o DataResponse.pb.o
    ${AR} rcs libDataResponse.a DataResponse.pb.o

    ${CC} -I${S} ${CFLAGS} ${LDFLAGS} -c proto_compiled/FeatureResponse.pb.c -o FeatureResponse.pb.o
    ${AR} rcs libFeatureResponse.a FeatureResponse.pb.o

    ${CC} -I${S} -c encode/encode.c -L. -lDataRequest -lDataResponse -lFeatureResponse -lprotobuf-nanopb

    ${CC} -I${S} ${CFLAGS} ${LDFLAGS} -o env-sensor-mam-writer iota/common.c iota/send-common.c iota/send-header.c iota/send-msg.c iota/send-packet.c iota/recv.c logging/logging.c encode/encode.c encode/decode.c app/server-client.c -lmam -lcclient -lprotobuf-nanopb -lm -lpthread
}

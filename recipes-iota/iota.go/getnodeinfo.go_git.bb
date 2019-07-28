DESCRIPTION = "IOTA Go API Library Example "

SRC_URI = "git://github.com/bernardoaraujor/getnodeinfo-go.git;protocol=https;"
SRCREV = "${AUTOREV}"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "iota.go"

inherit go
GO_IMPORT = "github.com/bernardoaraujor/getnodeinfo-go"

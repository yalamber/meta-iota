SUMMARY = "Some simple examples to get you started on developing with IOTA using Go."
DESCRIPTION = "Simple examples interacting with the tangle using the iota.go client library."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# go-iota-workshop repository
SRC_URI = "git://github.com/bernardoaraujor/go-iota-workshop.git;protocol=https;name=go-iota-workshop;destsuffix=${PN}-${PV}/src/github.com/bernardoaraujor/go-iota-workshop"

# Go dependencies
SRC_URI += "\
	   git://github.com/davecgh/go-spew.git;protocol=https;name=go-spew;destsuffix=${PN}-${PV}/src/github.com/davecgh/go-spew \
	   git://github.com/pebbe/zmq4.git;protocol=https;name=zmq4;destsuffix=${PN}-${PV}/src/github.com/pebbe/zmq4 \
"

SRCREV_go-iota-workshop = "${AUTOREV}"
SRCREV_go-spew = "v1.1.1"
SRCREV_zmq4 = "v1.0.0"

DEPENDS = "iota.go libzmq"
RDEPENDS_${PN} = "ca-certificates"

inherit go pkgconfig
GO_IMPORT = "github.com/bernardoaraujor/go-iota-workshop"

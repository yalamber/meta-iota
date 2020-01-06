SUMMARY = ""
DESCRIPTION = ""

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/iotaledger/hive.go.git;protocol=https;name=hive.go;destsuffix=${PN}-${PV}/src/github.com/iotaledger/hive.go"

SRC_URI += "\
           git://.git;protocol=https;name=;destsuffix=${PN}-${PV}/src/ \
"

inherit go pkgconfig
GO_IMPORT = ""

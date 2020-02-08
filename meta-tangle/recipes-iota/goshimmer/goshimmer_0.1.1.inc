require goshimmer-common.inc

# Go dependencies
SRC_URI += "\
           git://github.com/dgryski/go-metro.git;protocol=https;name=go-metro;destsuffix=${PN}-${PV}/src/github.com/dgryski/go-metro \
"

SRCREV_goshimmer = "v${PV}"

# goshimmer deps
SRCREV_go-metro = "280f6062b5bc97ee9b9afe7f2ccb361e59845baa"


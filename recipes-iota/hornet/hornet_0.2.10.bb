SUMMARY = "HORNET is a lightweight alternative to IOTA's fullnode software IRI"
DESCRIPTION = "HORNET is a lightweight alternative to IOTA's fullnode software IRI. The main advantage is that it compiles to native code and does not need a Java Virtual Machine, which considerably decreases the amount of needed resources while significantly increasing the performance. This way, HORNET is easier to install and runs on low-end devices."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/gohornet/hornet.git;protocol=https;name=hornet;destsuffix=${PN}-${PV}/src/github.com/gohornet/hornet"

# Go dependencies
SRC_URI += "\
	   git://github.com/DataDog/zstd.git;protocol=https;name=zstd;destsuffix=${PN}-${PV}/src/github.com/DataDog/zstd;nobranch=1 \
	   git://github.com/dgraph-io/badger.git;protocol=https;name=badger;destsuffix=${PN}-${PV}/src/github.com/dgraph-io/badger/v2 \
           git://github.com/dgraph-io/ristretto.git;protocol=https;name=ristretto;destsuffix=${PN}-${PV}/src/github.com/dgraph-io/ristretto \
           git://github.com/dgryski/go-farm.git;protocol=https;name=go-farm;destsuffix=${PN}-${PV}/src/github.com/dgryski/go-farm \
           git://github.com/gin-contrib/gzip.git;protocol=https;name=gzip;destsuffix=${PN}-${PV}/src/github.com/gin-contrib/gzip \
           git://github.com/gin-gonic/gin.git;protocol=https;name=gin;destsuffix=${PN}-${PV}/src/github.com/gin-gonic/gin \
           git://github.com/go-zeromq/zmq4.git;protocol=https;name=zmq4;destsuffix=${PN}-${PV}/src/github.com/go-zeromq/zmq4 \
           git://github.com/gobuffalo/packr.git;protocol=https;name=packr;destsuffix=${PN}-${PV}/src/github.com/gobuffalo/packr \
           git://github.com/googollee/go-engine.io.git;protocol=https;name=go-engine.io;destsuffix=${PN}-${PV}/src/github.com/googollee/go-engine.io \
           git://github.com/googollee/go-socket.io.git;protocol=https;name=go-socket.io;destsuffix=${PN}-${PV}/src/github.com/googollee/go-socket.io \
           git://github.com/gorilla/websocket.git;protocol=https;name=websocket;destsuffix=${PN}-${PV}/src/github.com/gorilla/websocket \
           git://github.com/iotaledger/goshimmer.git;protocol=https;name=goshimmer;destsuffix=${PN}-${PV}/src/github.com/iotaledger/goshimmer \
           git://github.com/iotaledger/hive.go.git;protocol=https;name=hive.go;destsuffix=${PN}-${PV}/src/github.com/iotaledger/hive.go \
           git://github.com/labstack/echo.git;protocol=https;name=echo;destsuffix=${PN}-${PV}/src/github.com/labstack/echo \
           git://github.com/mitchellh/mapstructure.git;protocol=https;name=mapstructure;destsuffix=${PN}-${PV}/src/github.com/mitchellh/mapstructure \
           git://github.com/pkg/errors.git;protocol=https;name=errors;destsuffix=${PN}-${PV}/src/github.com/pkg/errors \
           git://github.com/shirou/gopsutil.git;protocol=https;name=gopsutil;destsuffix=${PN}-${PV}/src/github.com/shirou/gopsutil \
           git://github.com/spf13/pflag.git;protocol=https;name=pflag;destsuffix=${PN}-${PV}/src/github.com/spf13/pflag \
           git://github.com/valyala/fasttemplate.git;protocol=https;name=fasttemplate;destsuffix=${PN}-${PV}/src/github.com/valyala/fasttemplate \
           git://github.com/uber-go/atomic.git;protocol=https;name=atomic;destsuffix=${PN}-${PV}/src/go.uber.org/atomic \
           git://github.com/golang/net.git;protocol=https;name=net;destsuffix=${PN}-${PV}/src/golang.org/x/net \
	   git://github.com/golang/sys.git;protocol=https;name=sys;destsuffix=${PN}-${PV}/src/golang.org/x/sys \
"

SRCREV_hornet = "v${PV}"
SRCREV_zstd = "v1.4.4"
SRCREV_badger = "8b99eb433aa799029b2e4cecc3c6e9b19c527490"
SRCREV_ristretto = "99d1bbbf28e64530eb246be0568fc7709a35ebdd"
SRCREV_go-farm = "c2139c5d712b01d0410c2e51d4bdc588b4eb6ca3"
SRCREV_gzip = "v0.0.1"
SRCREV_gin = "v1.5.0"
SRCREV_zmq4 = "4bfbf6cedab76ace7f905253fc172ce6550d5e37"
SRCREV_packr = "v2.7.1"
SRCREV_go-engine.io = "798118fc0dd23e33a0e71a1f639f56c7dd74a172"
SRCREV_go-socket.io = "683f8725b6d08c272efcc5682bfd86e0a70d8123"
SRCREV_websocket = "v1.4.1"
SRCREV_goshimmer = "26e99d88bddbebd485aa01e6e2f9d503c890a56c"
SRCREV_hive.go = "317ae9a463c7e88a2c779aa581b99ed2a59b3094"
SRCREV_echo = "v3.3.10"
SRCREV_mapstructure = "v1.1.2"
SRCREV_errors = "v0.8.1"
SRCREV_gopsutil = "v2.19.11"
SRCREV_pflag = "v1.0.5"
SRCREV_fasttemplate = "v1.1.0"
SRCREV_atomic = "v1.5.1"
SRCREV_net = "1ddd1de85cb0337b623b740a609d35817d516a8d"
SRCREV_sys = "ce4227a45e2eb77e5c847278dcc6a626742e2945"

DEPENDS = "iota.go"
RDEPENDS_${PN} = "ca-certificates"

inherit go pkgconfig
GO_IMPORT = "github.com/gohornet/hornet"
GO_LINKSHARED = ""

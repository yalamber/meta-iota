require goshimmer-common.inc

# Go dependencies
SRC_URI += " \
        git://github.com/dgraph-io/badger.git;protocol=https;name=badger;destsuffix=${PN}-${PV}/src/github.com/dgraph-io/badger/v2;nobranch=1 \
        git://github.com/dgrijalva/jwt-go.git;protocol=https;name=jwt-go;destsuffix=${PN}-${PV}/src/github.com/dgrijalva/jwt-go \
        git://github.com/dgryski/go-farm.git;protocol=https;name=go-farm;destsuffix=${PN}-${PV}/src/github.com/dgryski/go-farm \
        git://github.com/gobuffalo/envy.git;protocol=https;name=envy;destsuffix=${PN}-${PV}/src/github.com/gobuffalo/envy \
        git://github.com/gobuffalo/logger.git;protocol=https;name=logger;destsuffix=${PN}-${PV}/src/github.com/gobuffalo/logger \
        git://github.com/gobuffalo/packr.git;protocol=https;name=packr;destsuffix=${PN}-${PV}/src/github.com/gobuffalo/packr \
        git://github.com/golang/protobuf.git;protocol=https;name=protobuf;destsuffix=${PN}-${PV}/src/github.com/golang/protobuf \
        git://github.com/googollee/go-engine.io.git;protocol=https;name=go-engine.io;destsuffix=${PN}-${PV}/src/github.com/googollee/go-engine.io \
        git://github.com/googollee/go-socket.io.git;protocol=https;name=go-socket.io;destsuffix=${PN}-${PV}/src/github.com/googollee/go-socket.io \
        git://github.com/gorilla/websocket.git;protocol=https;name=websocket;destsuffix=${PN}-${PV}/src/github.com/gorilla/websocket \
        git://github.com/iotaledger/hive.go.git;protocol=https;name=hive.go;destsuffix=${PN}-${PV}/src/github.com/iotaledger/hive.go \
        git://github.com/iotaledger/iota.go.git;protocol=https;name=iota.go;destsuffix=${PN}-${PV}/src/github.com/iotaledger/iota.go \
	git://github.com/kr/pretty.git;protocol=https;name=pretty;destsuffix=${PN}-${PV}/src/github.com/kr/prety;nobranch=1 \
	git://github.com/kr/text.git;protocol=https;name=krtext;destsuffix=${PN}-${PV}/src/github.com/kr/text;nobranch=1 \
        git://github.com/labstack/echo.git;protocol=https;name=echo;destsuffix=${PN}-${PV}/src/github.com/labstack/echo \
        git://github.com/labstack/gommon.git;protocol=https;name=gommon;destsuffix=${PN}-${PV}/src/github.com/labstack/gommon \
        git://github.com/magiconair/properties.git;protocol=https;name=properties;destsuffix=${PN}-${PV}/src/github.com/magiconair/properties \
        git://github.com/mattn/go-colorable.git;protocol=https;name=go-colorable;destsuffix=${PN}-${PV}/src/github.com/mattn/go-colorable \
        git://github.com/mattn/go-isatty.git;protocol=https;name=go-isatty;destsuffix=${PN}-${PV}/src/github.com/mattn/go-isatty \
	git://github.com/mr-tron/base58.git;protocol=https;name=base58;destsuffix=${PN}-${PV}/src/github.com/mr-tron/base58 \
	git://github.com/oasislabs/ed25519.git;protocol=https;name=ed25519;destsuffix=${PN}-${PV}/src/github.com/oasislabs/ed25519 \
	git://github.com/panjf2000/ants.git;protocol=https;name=ants;destsuffix=${PN}-${PV}/src/github.com/panjf2000/ants \
        git://github.com/pelletier/go-toml.git;protocol=https;name=go-toml;destsuffix=${PN}-${PV}/src/github.com/pelletier/go-toml \
        git://github.com/pkg/errors.git;protocol=https;name=errors;destsuffix=${PN}-${PV}/src/github.com/pkg/errors \
        git://github.com/rogpeppe/go-internal.git;protocol=https;name=go-internal;destsuffix=${PN}-${PV}/src/github.com/rogpeppe/go-internal \
	git://github.com/sergi/go-diff.git;protocol=https;name=go-diff;destsuffix=${PN}-${PV}/src/github.com/sergi/go-diff \
        git://github.com/spf13/afero.git;protocol=https;name=afero;destsuffix=${PN}-${PV}/src/github.com/spf13/afero \
        git://github.com/spf13/cast.git;protocol=https;name=cast;destsuffix=${PN}-${PV}/src/github.com/spf13/cast \
        git://github.com/spf13/jwalterweatherman.git;protocol=https;name=jwalterweatherman;destsuffix=${PN}-${PV}/src/github.com/spf13/jwalterweatherman \
        git://github.com/spf13/pflag.git;protocol=https;name=pflag;destsuffix=${PN}-${PV}/src/github.com/spf13/pflag \
        git://github.com/spf13/viper.git;protocol=https;name=viper;destsuffix=${PN}-${PV}/src/github.com/spf13/viper \
        git://github.com/stretchr/objx.git;protocol=https;name=objx;destsuffix=${PN}-${PV}/src/github.com/stretchr/objx \
        git://github.com/stretchr/testify.git;protocol=https;name=testify;destsuffix=${PN}-${PV}/src/github.com/stretchr/testify \
        git://github.com/valyala/fasttemplate.git;protocol=https;name=fasttemplate;destsuffix=${PN}-${PV}/src/github.com/valyala/fasttemplate \
        git://github.com/uber-go/atomic.git;protocol=https;name=atomic;destsuffix=${PN}-${PV}/src/go.uber.org/atomic \
        git://github.com/uber-go/zap.git;protocol=https;name=zap;destsuffix=${PN}-${PV}/src/go.uber.org/zap \
        git://github.com/golang/crypto.git;protocol=https;name=crypto;destsuffix=${PN}-${PV}/src/golang.org/x/crypto \
        git://github.com/golang/net.git;protocol=https;name=net;destsuffix=${PN}-${PV}/src/golang.org/x/net \
        git://github.com/golang/sys.git;protocol=https;name=sys;destsuffix=${PN}-${PV}/src/golang.org/x/sys \
        git://github.com/golang/text.git;protocol=https;name=text;destsuffix=${PN}-${PV}/src/golang.org/x/text \
        git://github.com/golang/tools.git;protocol=https;name=tools;destsuffix=${PN}-${PV}/src/golang.org/x/tools \
        git://github.com/go-ini/ini.git;protocol=https;name=ini.v1;destsuffix=${PN}-${PV}/src/gopkg.in/ini.v1 \
	git://github.com/src-d/go-git.git;protocol=https;name=go-git;destsuffix=${PN}-${PV}/src/gopkg.in/src-d/go-git.v4 \
        git://github.com/go-yaml/yaml.git;protocol=https;name=yaml;destsuffix=${PN}-${PV}/src/gopkg.in/yaml.v2;nobranch=1 \
        git://github.com/DataDog/zstd.git;protocol=https;name=zstd;destsuffix=${PN}-${PV}/src/github.com/DataDog/zstd;nobranch=1 \
        git://github.com/cespare/xxhash.git;protocol=https;name=xxhash;destsuffix=${PN}-${PV}/src/github.com/cespare/xxhash \
        git://github.com/dgraph-io/ristretto.git;protocol=https;name=ristretto;destsuffix=${PN}-${PV}/src/github.com/dgraph-io/ristretto \
        git://github.com/dustin/go-humanize.git;protocol=https;name=go-humanize;destsuffix=${PN}-${PV}/src/github.com/dustin/go-humanize \
        git://github.com/fsnotify/fsnotify.git;protocol=https;name=fsnotify;destsuffix=${PN}-${PV}/src/github.com/fsnotify/fsnotify \
        git://github.com/gobuffalo/here.git;protocol=https;name=here;destsuffix=${PN}-${PV}/src/github.com/gobuffalo/here \
        git://github.com/golang/snappy.git;protocol=https;name=snappy;destsuffix=${PN}-${PV}/src/github.com/golang/snappy \
        git://github.com/joho/godotenv.git;protocol=https;name=godotenv;destsuffix=${PN}-${PV}/src/github.com/joho/godotenv \
        git://github.com/sirupsen/logrus.git;protocol=https;name=logrus;destsuffix=${PN}-${PV}/src/github.com/sirupsen/logrus \
        git://github.com/valyala/bytebufferpool.git;protocol=https;name=bytebufferpool;destsuffix=${PN}-${PV}/src/github.com/valyala/bytebufferpool \
        git://github.com/uber-go/multierr.git;protocol=https;name=multierr;destsuffix=${PN}-${PV}/src/go.uber.org/multierr \
        git://github.com/gobuffalo/packd.git;protocol=https;name=packd;destsuffix=${PN}-${PV}/src/github.com/gobuffalo/packd \
        git://github.com/hashicorp/hcl.git;protocol=https;name=hcl;destsuffix=${PN}-${PV}/src/github.com/hashicorp/hcl \
        git://github.com/mitchellh/mapstructure.git;protocol=https;name=mapstructure;destsuffix=${PN}-${PV}/src/github.com/mitchellh/mapstructure \
        git://github.com/subosito/gotenv.git;protocol=https;name=gotenv;destsuffix=${PN}-${PV}/src/github.com/subosito/gotenv \
"

SRCREV_goshimmer = "v${PV}"

# goshimmer deps
SRCREV_badger = "v2.0.1"
SRCREV_jwt-go = "v3.2.0"
SRCREV_go-farm = "c2139c5d712b01d0410c2e51d4bdc588b4eb6ca3"
SRCREV_envy = "v1.8.0"
SRCREV_logger = "v1.0.3"
SRCREV_packr = "v2.7.1"
SRCREV_protobuf = "v1.3.2"
SRCREV_go-engine.io = "798118fc0dd23e33a0e71a1f639f56c7dd74a172"
SRCREV_go-socket.io = "683f8725b6d08c272efcc5682bfd86e0a70d8123"
SRCREV_websocket = "v1.4.1"
SRCREV_hive.go = "27b18f10f09ed800c8ed20569fed90d08bc43fea"
SRCREV_iota.go = "v1.0.0-beta.14"
SRCREV_pretty = "v0.2.0"
SRCREV_krtext = "v0.2.0"
SRCREV_echo = "v3.3.10"
SRCREV_gommon = "v0.3.0"
SRCREV_properties = "v1.8.1"
SRCREV_go-colorable = "v0.1.2"
SRCREV_go-isatty = "v0.0.11"
SRCREV_base58 = "v1.1.3"
SRCREV_ed25519 = "2893bee822a3d11493335c675ea15a3f3d842119"
SRCREV_ants = "v2.2.2"
SRCREV_go-toml = "v1.6.0"
SRCREV_errors = "v0.9.1"
SRCREV_go-internal = "v1.5.2"
SRCREV_go-diff = "v1.1.0"
SRCREV_afero = "v1.2.2"
SRCREV_cast = "v1.3.1"
SRCREV_jwalterweatherman = "v1.1.0"
SRCREV_pflag = "v1.0.5"
SRCREV_viper = "v1.6.1"
SRCREV_objx = "v0.2.0"
SRCREV_testify = "v1.4.0"
SRCREV_fasttemplate = "v1.1.0"
SRCREV_atomic = "v1.5.1"
SRCREV_zap = "v1.13.0"
SRCREV_crypto = "69ecbb4d6d5dab05e49161c6e77ea40a030884e1"
SRCREV_net = "c0dbc17a35534bf2e581d7a942408dc936316da4"
SRCREV_sys = "9fbb57f87de9ccfe3a99d4e3270ce8a926ebba4f"
SRCREV_text = "v0.3.2"
SRCREV_tools = "2f3ba24bd6e75104fb11be4edf062de340ffd1ab"
SRCREV_ini.v1 = "v1.51.1"
SRCREV_go-git = "v4.13.1"
SRCREV_yaml = "v2.2.7"

# badger deps
SRCREV_zstd = "v1.4.1"
SRCREV_xxhash = "v1.1.0"
SRCREV_ristretto = "c1f00be0418e1e647efe10e5f1c3930db33fec98"
SRCREV_go-humanize = "v1.0.0"
SRCREV_snappy = "v0.0.1"

# viper deps
SRCREV_fsnotify = "v1.4.7"
SRCREV_hcl = "v1.0.0"
SRCREV_mapstructure = "v1.1.2"
SRCREV_gotenv = "v1.2.0"

# envy deps
SRCREV_here = "v0.4.1"
SRCREV_godotenv = "v1.3.0"

# logger deps
SRCREV_logrus = "v1.4.2"

# fasttemplate deps
SRCREV_bytebufferpool = "v1.0.0"

# zap deps
SRCREV_multierr = "v1.3.0"

# packr deps
SRCREV_packd = "v0.3.0"

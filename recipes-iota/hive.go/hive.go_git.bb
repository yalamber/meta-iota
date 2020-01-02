SUMMARY = "A Go library containing data structures, various utils and abstractions which are used by both GoShimmer and Hornet."
DESCRIPTION = "A Go library containing data structures, various utils and abstractions which are used by both GoShimmer and Hornet."

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI = "git://github.com/iotaledger/hive.go.git;protocol=https;name=hive.go;destsuffix=${PN}-${PV}/src/github.com/iotaledger/hive.go"

SRC_URI += "\
           git://github.com/dgraph-io/badger.git;protocol=https;name=badger;destsuffix=${PN}-${PV}/src/github.com/dgraph-io/badger/v2 \
           git://github.com/google/open-location-code.git;protocol=https;name=open-location-code;destsuffix=${PN}-${PV}/src/github.com/google/open-location-code \
           git://github.com/panjf2000/ants.git;protocol=https;name=ants;destsuffix=${PN}-${PV}/src/github.com/panjf2000/ants/v2 \
           git://github.com/petermattis/goid.git;protocol=https;name=goid;destsuffix=${PN}-${PV}/src/github.com/petermattis/goid \
           git://github.com/pkg/errors.git;protocol=https;name=errors;destsuffix=${PN}-${PV}/src/github.com/pkg/errors \
           git://github.com/sasha-s/go-deadlock.git;protocol=https;name=go-deadlock;destsuffix=${PN}-${PV}/src/github.com/sasha-s/go-deadlock \
           git://github.com/spf13/afero.git;protocol=https;name=afero;destsuffix=${PN}-${PV}/src/github.com/spf13/afero \
           git://github.com/spf13/pflag.git;protocol=https;name=pflag;destsuffix=${PN}-${PV}/src/github.com/spf13/pflag \
           git://github.com/spf13/viper.git;protocol=https;name=viper;destsuffix=${PN}-${PV}/src/github.com/spf13/viper \
           git://github.com/stretchr/testify.git;protocol=https;name=testify;destsuffix=${PN}-${PV}/src/github.com/stretchr/testify \
           git://github.com/golang/crypto.git;protocol=https;name=crypto;destsuffix=${PN}-${PV}/src/golang.org/x/crypto \
           git://github.com/fsnotify/fsnotify.git;protocol=https;name=fsnotify;destsuffix=${PN}-${PV}/src/github.com/fsnotify/fsnotify \
           git://github.com/hashicorp/hcl.git;protocol=https;name=hcl;destsuffix=${PN}-${PV}/src/github.com/hashicorp/hcl \
           git://github.com/magiconair/properties.git;protocol=https;name=properties;destsuffix=${PN}-${PV}/src/github.com/magiconair/properties \
           git://github.com/mitchellh/mapstructure.git;protocol=https;name=mapstructure;destsuffix=${PN}-${PV}/src/github.com/mitchellh/mapstructure \
           git://github.com/pelletier/go-toml.git;protocol=https;name=go-toml;destsuffix=${PN}-${PV}/src/github.com/pelletier/go-toml \
           git://github.com/spf13/cast.git;protocol=https;name=cast;destsuffix=${PN}-${PV}/src/github.com/spf13/cast \
           git://github.com/spf13/jwalterweatherman.git;protocol=https;name=jwalterweatherman;destsuffix=${PN}-${PV}/src/github.com/spf13/jwalterweatherman \
           git://github.com/subosito/gotenv.git;protocol=https;name=gotenv;destsuffix=${PN}-${PV}/src/github.com/subosito/gotenv \
           git://github.com/go-yaml/yaml.git;protocol=https;name=yaml;destsuffix=${PN}-${PV}/src/gopkg.in/yaml.v2;nobranch=1 \
           git://github.com/DataDog/zstd.git;protocol=https;name=zstd;destsuffix=${PN}-${PV}/src/github.com/DataDog/zstd;nobranch=1 \
"

# deps from hive.go
SRCREV_hive.go = "317ae9a463c7e88a2c779aa581b99ed2a59b3094"
SRCREV_badger = "v2.0.0"
SRCREV_open-location-code = "119bc96a3a51707d169ec06e28b25c038546aea0"
SRCREV_ants = "v2.2.2"
SRCREV_goid = "b0b1615b78e5ee59739545bb38426383b2cda4c9"
SRCREV_errors = "v0.8.1"
SRCREV_go-deadlock = "v0.2.0"
SRCREV_afero = "v1.1.2"
SRCREV_pflag = "v1.0.5"
SRCREV_viper = "v1.5.0"
SRCREV_testify = "v1.4.0"
SRCREV_crypto = "38d8ce5564a5b71b2e3a00553993f1b9a7ae852f"

# deps from viper
SRCREV_fsnotify = "v1.4.7"
SRCREV_hcl = "v1.0.0"
SRCREV_properties = "v1.8.1"
SRCREV_mapstructure = "v1.1.2"
SRCREV_go-toml = "v1.2.0"
SRCREV_cast = "v1.3.0"
SRCREV_jwalterweatherman = "v1.0.0"
SRCREV_gotenv = "v1.2.0"
SRCREV_yaml = "v2.2.4"

# deps from badger
SRCREV_zstd = "v1.4.1"

DEPENDS = "iota.go"

inherit go pkgconfig
GO_IMPORT = "github.com/iotaledger/hive.go"

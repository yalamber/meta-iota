# Copyright (C) 2019 Bernardo Rodrigues <bernardoar@protonmail.com>

SUMMARY = "IOTA Go API Library"
DESCRIPTION = "This is the official Go client library, which allows you to do the following: \
    Create transactions \
    Sign transactions \
    Interact with an IRI node \
"
HOMEPAGE = "https://www.iota.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "\
	   git://github.com/iotaledger/iota.go.git;protocol=https;name=iota.go;destsuffix=${PN}-${PV}/src/github.com/iotaledger/iota.go \
	   git://github.com/golang/sys.git;protocol=https;name=sys;destsuffix=${PN}-${PV}/src/golang.org/x/sys \
	   git://github.com/golang/net.git;protocol=https;name=net;destsuffix=${PN}-${PV}/src/golang.org/x/net \
	   git://github.com/golang/sync.git;protocol=https;name=sync;destsuffix=${PN}-${PV}/src/golang.org/x/sync \
	   git://github.com/golang/text.git;protocol=https;name=text;destsuffix=${PN}-${PV}/src/golang.org/x/text \
           git://github.com/golang/protobuf.git;protocol=https;name=protobuf;destsuffix=${PN}-${PV}/src/github.com/golang/protobuf \
	   git://github.com/AndreasBriese/bbloom.git;protocol=https;name=bloom;destsuffix=${PN}-${PV}/src/github.com/AndreasBriese/bbloom \
	   git://github.com/apsdehal/go-logger.git;protocol=https;name=go-logger;destsuffix=${PN}-${PV}/src/github.com/apsdehal/go-logger \
	   git://github.com/beevik/ntp.git;protocol=https;name=ntp;destsuffix=${PN}-${PV}/src/github.com/beevik/ntp \
	   git://github.com/cespare/xxhash.git;protocol=https;name=xxhash;destsuffix=${PN}-${PV}/src/github.com/cespare/xxhash \
	   git://github.com/dgraph-io/badger.git;protocol=https;name=badger;destsuffix=${PN}-${PV}/src/github.com/dgraph-io/badger \
	   git://github.com/dgryski/go-farm.git;protocol=https;name=go-farm;destsuffix=${PN}-${PV}/src/github.com/dgryski/go-farm \
	   git://github.com/go-stack/stack.git;protocol=https;name=stack;destsuffix=${PN}-${PV}/src/github.com/go-stack/stack \
	   git://github.com/golang/snappy.git;protocol=https;name=snappy;destsuffix=${PN}-${PV}/src/github.com/golang/snappy \
	   git://github.com/onsi/ginkgo.git;protocol=https;name=ginkgo;destsuffix=${PN}-${PV}/src/github.com/onsi/ginkgo \
	   git://github.com/onsi/gomega.git;protocol=https;name=gomega;destsuffix=${PN}-${PV}/src/github.com/onsi/gomega \
	   git://github.com/pkg/errors.git;protocol=https;name=errors;destsuffix=${PN}-${PV}/src/github.com/pkg/errors \
	   git://github.com/stretchr/testify.git;protocol=https;name=testify;destsuffix=${PN}-${PV}/src/github.com/stretchr/testify \
	   git://github.com/xdg/scram.git;protocol=https;name=scram;destsuffix=${PN}-${PV}/src/github.com/xdg/scram \
	   git://github.com/xdg/stringprep.git;protocol=https;name=stringprep;destsuffix=${PN}-${PV}/src/github.com/xdg/stringprep \
	   git://github.com/mongodb/mongo-go-driver.git;protocol=https;name=mongo-driver;destsuffix=${PN}-${PV}/src/go.mongodb.org/mongo-driver \
	   git://github.com/golang/crypto.git;protocol=https;name=crypto;destsuffix=${PN}-${PV}/src/golang.org/x/crypto \
	   git://github.com/golang/sync.git;protocol=https;name=sync;destsuffix=${PN}-${PV}/src/golang.org/x/sync \
	   git://github.com/h2non/gock.git;protocol=https;name=gock;destsuffix=${PN}-${PV}/src/gopkg.in/h2non/gock.v1 \
           git://github.com/h2non/parth.git;protocol=https;name=parth;destsuffix=${PN}-${PV}/src/github.com/h2non/parth \
"

BETA_V = "7"

SRCREV_iota.go = "v${PV}-beta.${BETA_V}"
SRCREV_sys = "81d4e9dc473e5e8c933f2aaeba2a3d81efb9aed2"
SRCREV_net = "161cd47e91fd58ac17490ef4d742dc98bb4cf60e"
SRCREV_sync = "1d60e4601c6fd243af51cc01ddf169918a5407ca"
SRCREV_text = "v0.3.2"
SRCREV_protobuf = "v1.2.0"
SRCREV_bloom = "e2d15f34fcf99d5dbb871c820ec73f710fca9815"
SRCREV_go-logger = "f85330a4b532a6f1c69c6fd09566e79dd665e653"
SRCREV_ntp = "v0.2.0"
SRCREV_xxhash = "v1.1.0"
SRCREV_badger = "v1.5.4"
SRCREV_go-farm = "8198c7b169ec28630587aded52777c5e10a037c2"
SRCREV_stack = "v1.8.0"
SRCREV_snappy = "v0.0.1"
SRCREV_ginkgo = "v1.8.0"
SRCREV_gomega = "v1.5.0"
SRCREV_errors = "v0.8.1"
SRCREV_testify = "v1.3.0"
SRCREV_scram = "7eeb5667e42c09cb51bf7b7c28aea8c56767da90"
SRCREV_stringprep = "v1.0.0"
SRCREV_mongo-driver = "v1.0.0"
SRCREV_crypto = "38d8ce5564a5b71b2e3a00553993f1b9a7ae852f"
SRCREV_sync  = "e225da77a7e68af35c70ccbf71af2b83e6acac3c"
SRCREV_gock = "v1.0.14"
SRCREV_parth = "v2.0.1"

inherit go

GO_IMPORT = "github.com/iotaledger/iota.go"

do_compile_prepend(){
    rm -rf src/github.com/iotaledger/iota.go/units
}

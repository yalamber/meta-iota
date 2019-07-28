SUMMARY = "ZeroMQ core engine in C++"
DESCRIPTION = "The ZeroMQ lightweight messaging kernel is a library which extends the standard socket interfaces with features traditionally provided by specialised messaging middleware products. ZeroMQ sockets provide an abstraction of asynchronous message queues, multiple messaging patterns, message filtering (subscriptions), seamless access to multiple transport protocols and more."

LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

inherit cmake pkgconfig

SRC_URI = "git://github.com/zeromq/libzmq.git"
SRCREV = "v4.3.2"

S = "${WORKDIR}/git"

FILES_${PN} = "${datadir} ${bindir} ${libdir}"

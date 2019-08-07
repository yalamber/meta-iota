SUMMARY = "a hash table for C structures"
DESCRIPTION = "Any C structure can be stored in a hash table using uthash. Just add a UT_hash_handle to the structure and choose one or more fields in your structure to act as the key. Then use these macros to store, retrieve or delete items from the hash table."
HOMEPAGE = "https://troydhanson.github.io/uthash/"
LICENSE = "BSD-1-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a2513f7d2291df840527b76b2a8f9718"

SRC_URI = "git://github.com/troydhanson/uthash.git"
SRCREV = "v2.1.0"

PR = "r0"

S = "${WORKDIR}/git"

EXTRA_OEMAKE = "\
    'CFLAGS=${CFLAGS} -Wno-implicit-fallthrough' \
"

do_configure[noexec] = "1"

do_install() {
    install -d ${D}${includedir}
    install -m 0644 ${S}/src/*.h ${D}${includedir}
}

BBCLASSEXTEND = "native nativesdk"

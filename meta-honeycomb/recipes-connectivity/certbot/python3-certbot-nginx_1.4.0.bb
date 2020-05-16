SUMMARY = "Certbot is a free, open source software tool for automatically using Let’s Encrypt certificates on manually-administrated websites to enable HTTPS."
DESCRIPTION = "Certbot is a free, open source software tool for automatically using Let’s Encrypt certificates on manually-administrated websites to enable HTTPS."
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

inherit pypi setuptools3

RDEPENDS_${PN} = "python3-certbot"

SRC_URI[md5sum] = "2396464b29f839bbf3a7e05a4823e342"
SRC_URI[sha256sum] = "44a9f74dee7e2f8a32aafaf793280e8fcd4d50a9ffb7c5ed47a0bc591ce6ecca"


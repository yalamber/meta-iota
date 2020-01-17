SUMMARY = "Validation and data pipelines made easy!"
DESCRIPTION = "The Filters library provides an easy and readable way to create complex data validation and processing pipelines, including: \
 - Validating complex JSON structures in API requests or config files. \
 - Parsing timestamps and converting to UTC. \
 - Converting Unicode strings to NFC, normalizing line endings and removing unprintable characters. \
 - Decoding Base64, including URL-safe variants. \
And much more! \
The output from one filter can be “piped” into the input of another, enabling you to “chain” filters together to quickly and easily create complex data pipelines. \
"

HOMEPAGE = "https://pypi.org/project/phx-filters/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[md5sum] = "c7a9f2798b66385c63b0fc4069ffa004"
SRC_URI[sha256sum] = "ca8f8bef190cff0932b6c7e1c17b50aff825ba9f68cdf14d5b46a643788a2bca"

RDEPENDS_${PN} = "\
	${PYTHON_PN}-regex \
	${PYTHON_PN}-pytz \
	${PYTHON_PN}-dateutil \
	${PYTHON_PN}-phx-class-registry \
"

inherit pypi setuptools3

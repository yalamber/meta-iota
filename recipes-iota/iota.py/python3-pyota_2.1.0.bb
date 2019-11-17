SUMMARY = "PyOTA: The IOTA Python API Library "
DESCRIPTION = "This is the official Python library for the IOTA Core. It implements both the official API, as well as functionality such as signing, bundles, utilities and conversion."

HOMEPAGE = "https://pyota.readthedocs.io/en/latest/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PYPI_PACKAGE = "PyOTA"
SRC_URI[md5sum] = "ebbc883496c986bbfdb1dc503ee14459"

RDEPENDS_${PN} = "\
	${PYTHON_PN}-setuptools \
	${PYTHON_PN}-misc \
	${PYTHON_PN}-phx-filters \
        ${PYTHON_PN}-six \
        ${PYTHON_PN}-requests \
	${PYTHON_PN}-pysha3 \
        ${PYTHON_PN}-typing \
	${PYTHON_PN}-pycparser \
	${PYTHON_PN}-ipython \
	${PYTHON_PN}-pydoc \
"

inherit pypi setuptools3

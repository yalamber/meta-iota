# this recipe was borrowed from meta-jupyter
# it was originally written by Manjukumar H. Matha <manjukumar.harthikote-matha@xilinx.com> and Sai H. C. Kalluri <chandana.kalluri@xilinx.com>
# the original version can be found at:
# https://github.com/Xilinx/meta-jupyter

SUMMARY = "JEDI: An autocompletion tool for Python that can be used for text editors"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=10;endline=10;md5=8227180126797a0148f94f483f3e1489"

BBCLASSEXTEND = "native"
SRC_URI[sha256sum] = "571702b5bd167911fe9036e5039ba67f820d6502832285cde8c881ab2b2149fd"

RDEPENDS_${PN} += " \
	${PYTHON_PN}-parso \
	${PYTHON_PN}-logging \
	${PYTHON_PN}-pkgutil \
	"

# this recipe was borrowed from meta-jupyter
# it was originally written by Manjukumar H. Matha <manjukumar.harthikote-matha@xilinx.com> and Sai H. C. Kalluri <chandana.kalluri@xilinx.com>
# the original version can be found at:
# https://github.com/Xilinx/meta-jupyter

SUMMARY = "Object-oriented filesystem paths"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"

SRC_URI[md5sum] = "6c75bfde898b6c88627621a48ee8de14"
SRC_URI[sha256sum] = "ce9007df617ef6b7bd8a31cd2089ed0c1fed1f7c23cf2bf1ba140b3dd563175d"
BBCLASSEXTEND = "native"

RDEPENDS_${PN} += " \
	${PYTHON_PN}-six \
	${PYTHON_PN}-scandir \
	"

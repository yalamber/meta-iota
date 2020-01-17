# this recipe was borrowed from meta-jupyter
# it was originally written by Manjukumar H. Matha <manjukumar.harthikote-matha@xilinx.com> and Sai H. C. Kalluri <chandana.kalluri@xilinx.com>
# the original version can be found at:
# https://github.com/Xilinx/meta-jupyter

SUMMARY = "IPython: Productive Interactive Computing"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING.rst;md5=93ef43efbd25773bbce636bbad9d247f"

SRC_URI[sha256sum] = "6a9496209b76463f1dec126ab928919aaf1f55b38beb9219af3fe202f6bbdd12"

PYPI_PACKAGE_EXT = "tar.gz"
RDEPENDS_${PN} += " \
	${PYTHON_PN}-debugger \
	${PYTHON_PN}-typing \
	${PYTHON_PN}-pexpect \
	${PYTHON_PN}-jedi (>= 0.10) \
	${PYTHON_PN}-decorator \
	${PYTHON_PN}-pickleshare \
	${PYTHON_PN}-traitlets (>= 4.2) \
	${PYTHON_PN}-pygments \
	${PYTHON_PN}-backcall \
	"

BBCLASSEXTEND = "native"

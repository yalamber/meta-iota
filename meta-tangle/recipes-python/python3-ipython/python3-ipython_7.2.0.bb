# this recipe was borrowed from meta-jupyter
# it was originally written by Manjukumar H. Matha <manjukumar.harthikote-matha@xilinx.com> and Sai H. C. Kalluri <chandana.kalluri@xilinx.com>
# the original version can be found at:
# https://github.com/Xilinx/meta-jupyter

inherit pypi setuptools3
require python-ipython.inc
LIC_FILES_CHKSUM = "file://COPYING.rst;md5=59b20262b8663cdd094005bddf47af5f"

RDEPENDS_${PN} += " \
	${PYTHON_PN}-asyncio \
        ${PYTHON_PN}-prompt-toolkit (>=2.0.0) \
	"

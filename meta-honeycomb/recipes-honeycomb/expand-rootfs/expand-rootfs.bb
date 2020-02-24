SUMMARY = "Resize the root filesystem of a newly flashed image."
DESCRIPTION = "Resize the root filesystem of a newly flashed image."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
            file://expand_rootfs \
"

RDEPENDS_${PN} = " parted e2fsprogs-resize2fs lsb util-linux"

S = "${WORKDIR}"

do_install_prepend_rock64 (){
	sed -i 's/mmcblk0/mmcblk1/g' ${S}/expand_rootfs
}

do_install () {
	install -d -m 755 ${D}${bindir}
        install -m 644 ${S}/expand_rootfs ${D}${bindir}

	chmod +x ${D}${bindir}/expand_rootfs
}

FILES_${PN} = "${bindir}"

SUMMARY = "Create swap file."
DESCRIPTION = "Create swap file."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
            file://create_swapfile \
"

S = "${WORKDIR}"

do_install () {
	install -d -m 755 ${D}${bindir}
        install -m 644 ${S}/create_swapfile ${D}${bindir}

	chmod +x ${D}${bindir}/create_swapfile
}

FILES_${PN} = "${bindir}"

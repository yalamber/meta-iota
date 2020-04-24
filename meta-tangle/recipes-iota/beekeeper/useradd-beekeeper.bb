SUMMARY = "BeeKeeper User settings"
DESCRIPTION = "BeeKeeper User settings"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
            file://README \
            file://dot.profile \
"

S = "${WORKDIR}"

EXCLUDE_FROM_WORLD = "1"

inherit useradd

USERADD_PACKAGES = "${PN}"

USERADD_PARAM_${PN} = "-u 1008 -d /home/beekeeper -r -s /bin/bash -P 'pollen2honey' -g iota beekeeper"

GROUPADD_PARAM_${PN} = "-g 1008 iota"
GROUPADD_PARAP_${PN} = "-g 986 wheel"

do_install () {
	install -d -m 755 ${D}${datadir}/beekeeper

        install -d -m 755 ${D}/home/beekeeper
	install -p -m 644 README ${D}/home/beekeeper
        install -p -m 644 dot.profile ${D}/home/beekeeper/.profile

	chown -R beekeeper ${D}${datadir}/beekeeper
	chown -R beekeeper ${D}/home/beekeeper

	chgrp -R iota ${D}${datadir}/beekeeper
	chgrp -R iota ${D}/home/beekeeper
}

FILES_${PN} = "${exec_prefix}/* /home/*"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

pkg_postinst_ontarget_${PN}(){

    # add beekeeper to sudo group
    usermod -aG sudo beekeeper
    usermod -aG wheel beekeeper

    # set password expiry to 0
    chage -d 0 root
    chage -d 0 beekeeper
}

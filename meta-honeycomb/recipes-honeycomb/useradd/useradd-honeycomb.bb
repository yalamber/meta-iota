SUMMARY = "User settings for HoneyComb"
DESCRIPTION = "User settings for HoneyComb"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://README"

S = "${WORKDIR}"

EXCLUDE_FROM_WORLD = "1"

inherit useradd

# You must set USERADD_PACKAGES when you inherit useradd. This
# lists which output packages will include the user/group
# creation code.
USERADD_PACKAGES = "${PN}"

# You must also set USERADD_PARAM and/or GROUPADD_PARAM when
# you inherit useradd.
# USERADD_PARAM specifies command line options to pass to the 
# useradd command.

USERADD_PARAM_${PN} = "-u 1200 -d /home/beekeeper -r -s /bin/bash -P 'pollen2honey' beekeeper"

# GROUPADD_PARAM works the same way, which you set to the options
# you'd normally pass to the groupadd command.
GROUPADD_PARAM_${PN} = "-g 880 iota"

do_install () {
	install -d -m 755 ${D}${datadir}/beekeeper

        install -d -m 755 ${D}/home/beekeeper
	install -p -m 644 README ${D}/home/beekeeper

	# The new users and groups are created before the do_install
	# step, so you are now free to make use of them:
	chown -R beekeeper ${D}${datadir}/beekeeper
	chown -R beekeeper ${D}/home/beekeeper

	chgrp -R iota ${D}${datadir}/beekeeper
	chgrp -R iota ${D}/home/beekeeper
}

FILES_${PN} = "${exec_prefix}/* /home/*"

# Prevents do_package failures with:
# debugsources.list: No such file or directory:
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

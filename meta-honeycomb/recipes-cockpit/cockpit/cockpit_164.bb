# this recipe was borrowed and modified from meta-intel-aero
# the original version can be found at:
# https://github.com/intel-aero/meta-intel-aero/blob/master/recipes-cockpit/cockpit/cockpit_145.bb

SUMMARY = "Admin interface for Linux machines"
DESCRIPTION = "Cockpit makes it easy to administer your GNU/Linux servers via a web browser"

LICENSE = "LGPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI  = "file://cockpit.pam"
SRC_URI += "file://honeycomb"
SRC_URI += "file://vms-override.json"
SRC_URI += "file://apps-override.json"
SRC_URI += "https://github.com/cockpit-project/cockpit/releases/download/${PV}/cockpit-${PV}.tar.xz"
SRC_URI[md5sum] = "6f6a20333147cbe61c2b6468bf976bc9"
SRC_URI[sha256sum] = "e47575bd49d96381e0ff0849e5e5929e67a0c436a767aa0a68dbf9425200ce44"

inherit gettext pkgconfig autotools systemd distro_features_check

REQUIRED_DISTRO_FEATURES = "pam"

EXTRA_AUTORECONF = "-I tools"
EXTRA_OECONF = "--with-cockpit-user=root \
                --with-cockpit-group=root \
                --disable-ssh \
                --disable-doc \
               "

PACKAGECONFIG ?= ""
PACKAGECONFIG[pcp] = "--enable-pcp,--disable-pcp,pcp"

SYSTEMD_SERVICE_${PN} = "cockpit.socket"

# Avoid warnings "file XXX is owned by uid 1001, which is the same as the user running bitbake. This may be due to host contamination"
INSANE_SKIP_${PN} += "host-user-contaminated"

PACKAGES =+ "${PN}-bridge ${PN}-pcp ${PN}-docker ${PN}-ws ${PN}-system ${PN}-dashboard ${PN}-networkmanager"

FILES_${PN} += "${libdir}/firewalld \
                ${libdir}/security \
                ${libdir}/tmpfiles.d \
                ${datadir}/appdata \
                ${datadir}/metainfo \
                ${systemd_unitdir}/system/${PN}.socket \
                "

FILES_${PN}-pcp =+ "${libexecdir}/cockpit-pcp \
                    ${datadir}/cockpit/pcp \
                    ${localstatedir}/lib/pcp/config/pmlogconf/tools/cockpit \
                    "

FILES_${PN}-bridge =+ "${bindir}/cockpit-bridge \
                       ${datadir}/cockpit/base1 \
                       ${libexec}/cockpit-askpass \
                       "
FILES_${PN}-docker =+ "${datadir}/cockpit/docker "

FILES_${PN}-ws =+ "${libexecdir}/cockpit-session \
                   ${libexecdir}/cockpit-ws \
                   ${sbindir}/remotectl \
                   ${datadir}/cockpit/branding \
                   ${datadir}/cockpit/static \
                   "
FILES_${PN}-system =+ "${datadir}/cockpit/systemd \
                       ${datadir}/cockpit/users \
                       ${datadir}/cockpit/shell \
                       "

FILES_${PN}-dashboard =+ "${datadir}/cockpit/dashboard \
                          ${datadir}/cockpit/ssh \
                          ${libexecdir}/cockpit-ssh \
                          "

FILES_${PN}-networkmanager =+ "${datadir}/cockpit/networkmanager"

DEPENDS += "glib-2.0-native intltool-native"
DEPENDS += "systemd gettext gtk+ json-glib polkit krb5 libpam"
RDEPENDS_${PN} += " glib-networking"

do_install_append() {
    pkgdatadir=${datadir}/cockpit

    # fix up install location of these files
    cp -al ${D}${pkgdatadir}/dist/* ${D}/${pkgdatadir}
    rm -rf ${D}${pkgdatadir}/dist

    # remove unwanted artifacts
    rm -rf ${D}${pkgdatadir}/branding/{centos,debian,fedora,kubernetes,registry,rhel,ubuntu}

    rm -rf ${D}${pkgdatadir}/kdump
    rm -rf ${D}${pkgdatadir}/kubernetes
    rm -rf ${D}${pkgdatadir}/machines
    rm -rf ${D}${pkgdatadir}/ostree
    rm -rf ${D}${pkgdatadir}/packagekit
    rm -rf ${D}${pkgdatadir}/playground
    rm -rf ${D}${pkgdatadir}/realmd
    rm -rf ${D}${pkgdatadir}/selinux
    rm -rf ${D}${pkgdatadir}/sosreport
    rm -rf ${D}${pkgdatadir}/ssh
    rm -rf ${D}${pkgdatadir}/storaged
    rm -rf ${D}${pkgdatadir}/subscriptions
    rm -rf ${D}${pkgdatadir}/tuned

    chmod 4750 ${D}${libexecdir}/cockpit-session

    install -d "${D}${sysconfdir}/pam.d"
    install -p -m 644 ${WORKDIR}/cockpit.pam ${D}${sysconfdir}/pam.d/cockpit

    # install honeycombOS logo
    install -d ${D}${datadir}/cockpit/branding
    cp -r ${WORKDIR}/honeycomb ${D}${datadir}/cockpit/branding

    # disable TLS
    sed -i '7d' ${D}/lib/systemd/system/cockpit.service
    sed -i 's/cockpit-ws/cockpit-ws --no-tls/g' ${D}/lib/systemd/system/cockpit.service

    # apply overrides
    install -m 644 ${WORKDIR}/vms-override.json ${D}${datadir}/cockpit/ovirt/override.json
    install -m 644 ${WORKDIR}/apps-override.json ${D}${datadir}/cockpit/apps/override.json
}

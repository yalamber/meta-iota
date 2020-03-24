FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += " \
    file://eth.network \
    file://wlan.network \
"

FILES_${PN} += " \
    ${sysconfdir}/systemd/network/eth.network \
    ${sysconfdir}/systemd/network/wlan.network \
"

do_install_append() {

    if ["${MACHINE}" != "qemuarm64" -a "${MACHINE}" != "qemuarm" -a "${MACHINE}" != "qemux86-64" -a "${MACHINE}" != "qemux86"]; then
        install -d ${D}${sysconfdir}/systemd/network
        install -m 0644 ${WORKDIR}/eth.network ${D}${sysconfdir}/systemd/network
        install -m 0644 ${WORKDIR}/wlan.network ${D}${sysconfdir}/systemd/network
    fi

}

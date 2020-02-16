require ${PN}_${PV}.inc

inherit systemd

SRC_URI += " \
             file://goshimmer.service \
"

FILES_${PN} += " goshimmer.service"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "goshimmer.service"
SYSTEMD_AUTO_ENABLE = "disable"

do_install_append(){

    # create goshimmer directory in /etc
    install -m 0755 -d ${D}${sysconfdir}/goshimmer

    # populate config.json
    install -m 0644 ${WORKDIR}/${PN}-${PV}/src/github.com/iotaledger/goshimmer/config.json ${D}${sysconfdir}/goshimmer

    # check for distro because useradd-honeycomb.bb already creates these dir in /var
    if ["${DISTRO}" != "honeycomb"]; then
        install -m 0775 -d ${D}${localstatedir}/lib/goshimmer/db
    fi

    # create systemd directory
    install -m 0755 -d ${D}${systemd_system_unitdir}

    # populate systemd service file
    install -m 0755 ${WORKDIR}/goshimmer.service ${D}${systemd_system_unitdir}
}

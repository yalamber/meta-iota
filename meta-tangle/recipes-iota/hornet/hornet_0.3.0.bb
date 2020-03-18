require ${PN}_${PV}.inc

inherit systemd

SRC_URI += " \
           file://hornet.service \
"

FILES_${PN} += " hornet.service"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "hornet.service"
SYSTEMD_AUTO_ENABLE = "disable"

do_compile_prepend(){
    sed -i 's/000000000\ {/000000000\*0\.95\ {/g' ${S}/src/github.com/gohornet/hornet/packages/profile/profile.go
}

FILES_${PN} += " ${bin}/hornet_update_snapshot ${bin}/hornet_start"

do_install_append(){

    # create hornet directories in /etc
    install -m 0755 -d ${D}${sysconfdir}/hornet

    # create systemd directory
    install -m 0755 -d ${D}${systemd_system_unitdir}

    # fix snapshot path on config.json
    sed -i 's/\"latest-export.gz.bin\"/\"\/var\/lib\/hornet\/snapshot\/latest-export.gz.bin\"/g' ${WORKDIR}/${PN}-${PV}/src/github.com/gohornet/hornet/config.json

    # populate config.json and neighbors.json
    install -m 0644 ${WORKDIR}/${PN}-${PV}/src/github.com/gohornet/hornet/config.json ${D}${sysconfdir}/hornet
    install -m 0644 ${WORKDIR}/${PN}-${PV}/src/github.com/gohornet/hornet/neighbors.json ${D}${sysconfdir}/hornet

    # populate update_snapshot and start scripts
    install -m 0755 ${WORKDIR}/hornet_update_snapshot ${D}${bindir}
    install -m 0755 ${WORKDIR}/hornet_start ${D}${bindir}

    # populate systemd service file
    install -m 0755 ${WORKDIR}/hornet.service ${D}${systemd_system_unitdir}
}

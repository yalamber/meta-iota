require ${PN}_${PV}.inc

FILES_${PN} += " ${bin}/hornet_update_snapshot"

do_install_append(){

    # create hornet directories in /etc
    install -m 0755 -d ${D}${sysconfdir}/hornet/config
    install -m 0755 -d ${D}${sysconfdir}/hornet/snapshot

    sed -i 's/\"latest-export.gz.bin\"/\"\/etc\/hornet\/snapshot\/latest-export.gz.bin\"/g' ${WORKDIR}/${PN}-${PV}/src/github.com/gohornet/hornet/config.json

    # populate config.json and neighbors.json
    install -m 0644 ${WORKDIR}/${PN}-${PV}/src/github.com/gohornet/hornet/config.json ${D}${sysconfdir}/hornet/config
    install -m 0644 ${WORKDIR}/${PN}-${PV}/src/github.com/gohornet/hornet/neighbors.json ${D}${sysconfdir}/hornet/config

    # populate update_snapshot script
    install -m 0755 ${WORKDIR}/hornet_update_snapshot ${D}${bindir}
}

require ${PN}_${PV}.inc

do_compile_prepend(){
    sed -i 's/000000000\ {/000000000\*0\.95\ {/g' ${S}/src/github.com/gohornet/hornet/packages/profile/profile.go
}

FILES_${PN} += " ${bin}/hornet_update_snapshot"

do_install_append(){

    # create hornet directories in /etc
    install -m 0755 -d ${D}${sysconfdir}/hornet
    install -m 0755 -d ${D}${localstatedir}/lib/hornet

    sed -i 's/\"latest-export.gz.bin\"/\"\/var\/lib\/hornet\/latest-export.gz.bin\"/g' ${WORKDIR}/${PN}-${PV}/src/github.com/gohornet/hornet/config.json

    # populate config.json and neighbors.json
    install -m 0644 ${WORKDIR}/${PN}-${PV}/src/github.com/gohornet/hornet/config.json ${D}${sysconfdir}/hornet
    install -m 0644 ${WORKDIR}/${PN}-${PV}/src/github.com/gohornet/hornet/neighbors.json ${D}${sysconfdir}/hornet

    # populate update_snapshot script
    install -m 0755 ${WORKDIR}/hornet_update_snapshot ${D}${bindir}
}

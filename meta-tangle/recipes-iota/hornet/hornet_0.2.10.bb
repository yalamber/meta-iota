require ${PN}_${PV}.inc

do_compile_prepend(){
    sed -i 's/000000000\ {/000000000\*0\.95\ {/g' ${S}/src/github.com/gohornet/hornet/packages/profile/profile.go
}

FILES_${PN} += " ${bin}/hornet_update_snapshot"

do_install_append(){

    # create hornet directories in /etc
    install -m 0755 -d ${D}${sysconfdir}/hornet/config
    install -m 0755 -d ${D}${sysconfdir}/hornet/snapshot

    sed -i 's/\"latest-export.gz.bin\"/\"\/etc\/hornet\/snapshot\/latest-export.gz.bin\"/g' ${WORKDIR}/${PN}-${PV}/src/github.com/gohornet/hornet/config.json

    # populate config.json
    install -m 0644 ${WORKDIR}/${PN}-${PV}/src/github.com/gohornet/hornet/config.json ${D}${sysconfdir}/hornet/config

    # populate update_snapshot script
    install -m 0755 ${WORKDIR}/hornet_update_snapshot ${D}${bindir}
}

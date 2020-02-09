require ${PN}_${PV}.inc

do_install_append(){

    # create goshimmer directory in /etc
    install -m 0755 -d ${D}${sysconfdir}/goshimmer

    # populate config.json
    install -m 0644 ${WORKDIR}/${PN}-${PV}/src/github.com/iotaledger/goshimmer/config.json ${D}${sysconfdir}/goshimmer
}

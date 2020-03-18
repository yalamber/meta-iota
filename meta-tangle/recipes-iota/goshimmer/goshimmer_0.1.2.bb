require ${PN}_${PV}.inc

inherit systemd

SRC_URI += " \
             file://goshimmer.service \
"

FILES_${PN} += " goshimmer.service"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "goshimmer.service"
SYSTEMD_AUTO_ENABLE = "disable"

# avoid tests
PTEST_ENABLED="0"

# avoid cache disabling
export GOCACHE = "${B}/.cache"

do_compile_prepend(){

    # avoid tests
    rm -rf ${S}/src/github.com/iotaledger/goshimmer/packages/binary/tangle/model/transaction/test
}


do_install_append(){

    # create goshimmer directory in /etc
    install -m 0755 -d ${D}${sysconfdir}/goshimmer

    # populate config.json
    install -m 0644 ${WORKDIR}/${PN}-${PV}/src/github.com/iotaledger/goshimmer/config.json ${D}${sysconfdir}/goshimmer

    # remote dashboard enabled by default
    sed -i 's/127.0.0.1/0.0.0.0/g' ${D}${sysconfdir}/goshimmer/config.json

    # create systemd directory
    install -m 0755 -d ${D}${systemd_system_unitdir}

    # populate systemd service file
    install -m 0755 ${WORKDIR}/goshimmer.service ${D}${systemd_system_unitdir}
}

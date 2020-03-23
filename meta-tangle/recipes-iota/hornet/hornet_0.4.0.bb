require ${PN}_${PV}.inc

inherit systemd

RDEPENDS_${PN} = " systemd bash"

SRC_URI += " \
           file://hornet.service \
           file://hornet.env \
"

FILES_${PN} += " hornet.service"
CONFFILES_${PN} += " ${sysconfdir}/hornet/config.json \
                     ${sysconfdir}/hornet/neighbors.json \
                     ${sysconfdir}/hornet/mqtt_config.json \
                     ${sysconfdir}/hornet/config_comnet.json \
                     ${sysconfdir}/default/hornet \
"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "hornet.service"
SYSTEMD_AUTO_ENABLE = "disable"

# avoid cache disabling
export GOCACHE = "${B}/.cache"

do_install_append(){

    # create hornet directories in /etc
    install -m 0755 -d ${D}${sysconfdir}/hornet
    install -m 0755 -d ${D}${sysconfdir}/default

    # create systemd directory
    install -m 0755 -d ${D}${systemd_system_unitdir}

    # populate .json files
    install -m 0644 ${WORKDIR}/${PN}-${PV}/src/github.com/gohornet/hornet/config.json ${D}${sysconfdir}/hornet
    install -m 0644 ${WORKDIR}/${PN}-${PV}/src/github.com/gohornet/hornet/neighbors.json ${D}${sysconfdir}/hornet
    install -m 0644 ${WORKDIR}/${PN}-${PV}/src/github.com/gohornet/hornet/mqtt_config.json ${D}${sysconfdir}/hornet
install -m 0644 ${WORKDIR}/${PN}-${PV}/src/github.com/gohornet/hornet/config_comnet.json ${D}${sysconfdir}/hornet

    # populate systemd service file
    install -m 0755 ${WORKDIR}/hornet.service ${D}${systemd_system_unitdir}

    # populate environment file (for .deb)
    if ["${PACKAGE_CLASSES}" == "package_deb"]; then
        install -m 0755 ${WORKDIR}/hornet.env ${D}${sysconfdir}/default/hornet
    fi
}

pkg_postinst_ontarget_${PN}(){
OPTS=""

if [ -n "$D" ]; then
    OPTS="--root=$D"
fi

if type systemctl >/dev/null 2>/dev/null; then
	if [ -z "$D" ]; then
		systemctl daemon-reload
	fi

	# if hornet user doesn't exist, create it
	if [ ! $(getent passwd hornet) ]; then
		useradd --no-create-home --system hornet > /dev/null
	fi

	# if /var/lib/hornet doesn't exist, create it
	if [ ! -d /var/lib/hornet ]; then
		mkdir -p /var/lib/hornet/db
		mkdir -p /var/lib/hornet/snapshot
		chown -R hornet:hornet /var/lib/hornet
	fi

	systemctl $OPTS disable hornet.service

	if [ -z "$D" -a "disable" = "enable" ]; then
		systemctl --no-block restart hornet.service
	fi
fi
}

pkg_postrm_${PN}(){
OPTS=""

if [ -n "$D" ]; then
    OPTS="--root=$D"
fi

systemctl --system daemon-reload >/dev/null || true

case "$1" in
remove)
    rm -rf /var/lib/hornet/*
    ;;
purge)
    rm -rf /var/lib/hornet
    deluser hornet >/dev/null
    ;;
upgrade | failed-upgrade | abort-install | abort-upgrade | disappear) ;;

*)
    echo "postrm called with unknown argument \`$1'" >&2
    exit 1
    ;;
esac
}
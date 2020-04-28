require ${PN}_${PV}.inc

inherit systemd

RDEPENDS_${PN} += " wget systemd"

SRC_URI += " \
           file://hornet.service \
           file://hornet.env \
"

FILES_${PN} += " hornet.service"
CONFFILES_${PN} += " ${sysconfdir}/hornet/config.json \
                     ${sysconfdir}/hornet/neighbors.json \
                     ${sysconfdir}/default/hornet \
"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "hornet.service"
SYSTEMD_AUTO_ENABLE = "disable"

# avoid cache disabling
export GOCACHE = "${B}/.cache"

do_compile_prepend(){
    sed -i 's/000000000\ {/000000000\*0\.95\ {/g' ${S}/src/github.com/gohornet/hornet/packages/profile/profile.go
}

FILES_${PN} += " ${bin}/hornet_update_snapshot"

do_install_append(){

    # create hornet directories in /etc
    install -m 0755 -d ${D}${sysconfdir}/hornet
    install -m 0755 -d ${D}${sysconfdir}/default

    # create systemd directory
    install -m 0755 -d ${D}${systemd_system_unitdir}

    # populate config.json and neighbors.json
    install -m 0644 ${WORKDIR}/${PN}-${PV}/src/github.com/gohornet/hornet/config.json ${D}${sysconfdir}/hornet
    install -m 0644 ${WORKDIR}/${PN}-${PV}/src/github.com/gohornet/hornet/neighbors.json ${D}${sysconfdir}/hornet

    # populate update_snapshot script
    install -m 0755 ${WORKDIR}/hornet_update_snapshot ${D}${bindir}

    # populate systemd service file
    install -m 0755 ${WORKDIR}/hornet.service ${D}${systemd_system_unitdir}

    # populate environment file (for .deb)
    if ["${PACKAGE_CLASSES}" == "package_deb"]; then
        install -m 0755 ${WORKDIR}/hornet.env ${D}${sysconfdir}/default/hornet
    fi

    # install hornet helper scripts
    install -m 0755 ${WORKDIR}/hornet_clean_db ${D}${bindir}
    install -m 0755 ${WORKDIR}/hornet_dashboard_enable ${D}${bindir}
    install -m 0755 ${WORKDIR}/hornet_dashboard_disable ${D}${bindir}
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
		mkdir -p /var/lib/hornet
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


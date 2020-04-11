SUMMARY = "Add package feeds to honeycombOS."
DESCRIPTION = "Add package feeds to honeycombOS."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
            file://hornet_ppa_pubkey.txt \
"

DEPENDS = "hornet "

do_install(){

    # temporarily install ppa public key for aptitude
    install -d ${D}${sysconfdir}/tmp_package_feed
    install -m 0644 ${WORKDIR}/hornet_ppa_pubkey.txt ${D}${sysconfdir}/tmp_package_feed

}

pkg_postinst_ontarget_${PN}(){

    # inform aptitude about package feeds
    apt-key add /etc/tmp_package_feed/hornet_ppa_pubkey.txt
    echo "deb http://ppa.hornet.zone stable main" >> /etc/apt/sources.list.d/hornet.list
    rm -rf /etc/tmp_package_feed

}

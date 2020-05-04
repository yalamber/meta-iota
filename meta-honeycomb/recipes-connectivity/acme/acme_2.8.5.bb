SUMMARY = "A pure Unix shell script implementing ACME client protocol."
DESCRIPTION = "A pure Unix shell script implementing ACME client protocol."
LICENSE = "GPL-3.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI = "file://get_acme_sh"

#SRC_URI = "git://github.com/acmesh-official/acme.sh.git;protocol=https"
#SRCREV = "2.8.5"

#S = "${WORKDIR}/git"

RDEPENDS_${PN} = " bash openssl-bin cronie useradd-beekeeper"


do_install(){
#
#    # install acme.sh script to beekeeper's home
#    install -m 0755 ${S}/acme.sh ${D}/tmp

     install -d -m 755 ${D}${bindir}

     install -m 0755 ${WORKDIR}/get_acme_sh ${D}${bindir}/get_acme_sh
}

#pkg_postinst_ontarget_${PN}(){
#
#    cd /home/beekeeper
#    curl https://get.acme.sh | sh
#
#}

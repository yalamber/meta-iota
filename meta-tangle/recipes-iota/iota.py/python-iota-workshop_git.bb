SUMMARY = "Simple examples showing you how you can interact with the IOTA Tangle using Python "
DESCRIPTION = "Some simple examples to get you started on developing with IOTA using Python."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/iota-community/python-iota-workshop.git;protocol=https"
SRCREV = "${AUTOREV}"

RDEPENDS_${PN} = " python3-pyota python3-pyzmq"
#RDEPENDS_${PN} = "ca-certificates"

S = "${WORKDIR}/git"

do_install(){

    # add python3 shebang to scripts
    sed -i '1 i\#\!\/usr\/bin\/python3' ${S}/code/e01_hello_world.py
    sed -i '1 i\#\!\/usr\/bin\/python3' ${S}/code/e02_send_hello.py
    sed -i '1 i\#\!\/usr\/bin\/python3' ${S}/code/e03_receive_hello.py
    sed -i '1 i\#\!\/usr\/bin\/python3' ${S}/code/e04_generate_address.py
    sed -i '1 i\#\!\/usr\/bin\/python3' ${S}/code/e05_check_balance.py
    sed -i '1 i\#\!\/usr\/bin\/python3' ${S}/code/e06_send_tokens.py
    sed -i '1 i\#\!\/usr\/bin\/python3' ${S}/code/e07_send_data.py
    sed -i '1 i\#\!\/usr\/bin\/python3' ${S}/code/e08_receive_data.py
    sed -i '1 i\#\!\/usr\/bin\/python3' ${S}/code/e09_zmq_listen.py

    install -d ${D}${bindir}

    install -m 0755 ${S}/code/e01_hello_world.py ${D}${bindir}/iota_py_hello_world
    install -m 0755 ${S}/code/e02_send_hello.py ${D}${bindir}/iota_py_send_hello
    install -m 0755 ${S}/code/e03_receive_hello.py ${D}${bindir}/iota_py_receive_hello
    install -m 0755 ${S}/code/e04_generate_address.py ${D}${bindir}/iota_py_generate_address
    install -m 0755 ${S}/code/e05_check_balance.py ${D}${bindir}/iota_py_check_balance
    install -m 0755 ${S}/code/e06_send_tokens.py ${D}${bindir}/iota_py_send_tokens
    install -m 0755 ${S}/code/e07_send_data.py ${D}${bindir}/iota_py_send_data
    install -m 0755 ${S}/code/e08_receive_data.py ${D}${bindir}/iota_py_receive_data
    install -m 0755 ${S}/code/e09_zmq_listen.py ${D}${bindir}/iota_py_zmq_listen

}

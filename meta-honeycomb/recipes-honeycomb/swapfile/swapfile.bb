SUMMARY = "Set up a swapfile and add it to fstab at first boot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

do_install() {
    install -d -m 755 ${D}${localstatedir}

    dd if=/dev/urandom of=${D}${localstatedir}/swap bs=1024 count=1048576
    chmod 600 ${D}${localstatedir}/swap
}

# this will be executed on the board during first boot
pkg_postinst_ontarget_${PN}() {

    # Enable the swap file
    mkswap /var/swap
    swapon /var/swap

    # Add to fstab
    echo "/var/swap   none    swap    sw    0   0" | tee /etc/fstab -a
}

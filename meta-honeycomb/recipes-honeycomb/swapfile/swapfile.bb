SUMMARY = "Set up a swapfile and add it to fstab at first boot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "file://dummy_file"

# the recipe needs to install something, so let's install a dummy file
do_install() {
    install -d -m 755 ${D}${localstatedir}
    install -m 0644 ${WORKDIR}/dummy_file ${D}${localstatedir}/dummy_file
}

# this will be executed on the board during first boot
pkg_postinst_ontarget_${PN}() {
    SWAP_SIZE="1G"
    SWAP_PATH="/swapfile"

    fallocate -l $SWAP_SIZE $SWAP_PATH	# Allocate size
    chmod 600 $SWAP_PATH		# Set proper permission
    mkswap $SWAP_PATH			# Setup swap
    swapon $SWAP_PATH			# Enable swap

    # Add to fstab
    echo "$SWAP_PATH   none    swap    sw    0   0" | tee /etc/fstab -a
    
    # Remove dummy file
    rm /var/dummy_file
}


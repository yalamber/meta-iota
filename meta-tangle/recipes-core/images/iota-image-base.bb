require recipes-core/images/core-image-base.bb

# IOTA projects
IMAGE_INSTALL_append = " ciri c-iota-workshop"

# utils
IMAGE_INSTALL_append = " openssh sqlite3 wpa-supplicant openvpn curl ppp pptp-linux connman"

# image and distro features
IMAGE_FEATURES_append = " package-management"
DISTRO_FEATURES_append = " wifi systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"

# make room for snapshots
IMAGE_ROOTFS_SIZE ?= "2097152"

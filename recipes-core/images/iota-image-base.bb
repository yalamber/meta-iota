require recipes-core/images/core-image-minimal.bb

# IOTA projects
IMAGE_INSTALL_append = " ciri c-iota-workshop"

# utils
IMAGE_INSTALL_append = " openssh sqlite3 dhcpcd iptables wpa-supplicant python openvpn openssh curl"

# image and distro features
IMAGE_FEATURES_append = " package-management"
DISTRO_FEATURES_append = " wifi systemd"
VIRTUAL-RUNTIME_init_manager = "systemd"

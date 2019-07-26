require recipes-core/images/core-image-minimal.bb

IMAGE_INSTALL_append = " ciri getnodeinfo-go"

IMAGE_INSTALL_append = " openssh sqlite3 dhcpcd"
IMAGE_FEATURES_append = " package-management"

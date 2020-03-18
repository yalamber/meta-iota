DESCRIPTION = "A headless HoneyComb image"
LICENSE = "MIT"

require recipes-core/images/core-image-base.bb

IMAGE_FEATURES += " \
                   tools-debug \
                   tools-sdk \
                   ssh-server-dropbear \
                   package-management \
                   doc-pkgs \
"

IMAGE_INSTALL_append += "\
                          packagegroup-honeycomb-misc \
                          packagegroup-honeycomb-networking \
                          packagegroup-honeycomb-development \
                          packagegroup-honeycomb-iota \
"

# 2GB image size, unless explicitly set otherwise
IMAGE_ROOTFS_SIZE ?= "2097152"

DESCRIPTION = "A headless HoneyComb image"
LICENSE = "MIT"

require recipes-core/images/core-image-base.bb

IMAGE_FEATURES += " \
                   tools-debug \
                   tools-sdk \
                   ssh-server-dropbear \
                   package-management \
"

# 2GB image size, unless explicitly set otherwise
IMAGE_ROOTFS_SIZE ?= "2097152"

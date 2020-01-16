DESCRIPTION = "A headless HoneyComb image"
LICENSE = "MIT"

require recipes-core/images/core-image-base.bb

# 2GB image size, unless explicitly set otherwise
IMAGE_ROOTFS_SIZE ?= "2097152"

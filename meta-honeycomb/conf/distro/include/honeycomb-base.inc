require conf/distro/poky.conf

DISTRO = "honeycomb"
DISTRO_NAME = "IOTA HoneyComb"
DISTRO_VERSION = "0.1"

MAINTAINER = "Bernardo A. Rodrigues <bernardoaraujor@gmail.com>"

GOVERSION = "1.13%"

DISTRO_FEATURES += " \
                   systemd \
                   wifi \
                   tools-debug \
                   tools-sdk \
                   ssh-server-dropbear \
                   package-management \
"

# general installs
DISTRO_EXTRA_RDEPENDS = " \
                        sudo \
                        useradd-honeycomb \
                        dropbear \
                        wget \
                        curl \
                        git \
                        jq \
                        nano \
                        vim \
                        ca-certificates \
                        hornet \
"

VIRTUAL-RUNTIME_init_manager = "systemd"

PACKAGE_CLASSES = "package_deb"

INHERIT += "extrausers"
EXTRA_USERS_PARAMS = "usermod -P tangleisawesome root;"

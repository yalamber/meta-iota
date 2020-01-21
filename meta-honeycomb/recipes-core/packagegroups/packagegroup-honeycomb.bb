SUMMARY = "HoneyComb Package Group"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " packagegroup-honeycomb"

RDEPENDS_packagegroup-honeycomb = " \
                                 sudo \
                                 useradd-honeycomb \
                                 swapfile \
                                 util-linux-fallocate \
                                 net-tools \
                                 wpa-supplicant \
                                 python3 \
                                 openvpn \
                                 wget \
                                 curl \
                                 git \
                                 jq \
                                 nano \
                                 vim \
                                 ca-certificates \
                                 go \
                                 hornet \
"

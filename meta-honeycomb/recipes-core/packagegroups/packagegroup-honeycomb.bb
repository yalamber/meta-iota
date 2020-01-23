SUMMARY = "HoneyComb Package Group"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " packagegroup-honeycomb"

RDEPENDS_packagegroup-honeycomb = " \
                                 sudo \
                                 useradd-honeycomb \
                                 swapfile \
                                 net-tools \
                                 wpa-supplicant \
                                 python3 \
                                 go \
                                 go-runtime \
                                 openvpn \
                                 wget \
                                 curl \
                                 git \
                                 jq \
                                 nano \
                                 vim \
                                 ca-certificates \
                                 hornet \
"

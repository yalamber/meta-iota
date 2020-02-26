SUMMARY = "honeycomb Package Group"

inherit packagegroup

PROVIDES = "${PACKAGES}"
PACKAGES = " \
             packagegroup-honeycomb-misc \
             packagegroup-honeycomb-networking \
             packagegroup-honeycomb-development \
             packagegroup-honeycomb-iota \
"

RDEPENDS_packagegroup-honeycomb-misc = " \
                                       sudo \
                                       useradd-honeycomb \
                                       swapfile \
                                       expand-rootfs \
                                       screen \
                                       tmux \
                                       cronie \
                                       man-db \
                                       htop \
"

RDEPENDS_packagegroup-honeycomb-networking = " \
                                             net-tools \
                                             wpa-supplicant \
                                             openvpn \
                                             wget \
                                             curl \
                                             ca-certificates \
"

RDEPENDS_packagegroup-honeycomb-development += " \
                                        git \
                                        nano \
                                        vim \
                                        jq \
                                        python3 \
                                        python3-dev \
                                        python3-pip \
                                        python3-setuptools \
                                        python \
                                        python-dev \
                                        python-pip \
                                        python-setuptools \
                                        go \
                                        go-runtime \
"

RDEPENDS_packagegroup-honeycomb-iota = " \
                                       hornet \
"

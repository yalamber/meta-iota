SUMMARY = "Alternative regular expression module, to replace re."
DESCRIPTION = "This regex implementation is backwards-compatible with the standard ‘re’ module, but offers additional functionality."

HOMEPAGE = "https://pypi.org/project/regex/"
LICENSE = "Python-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Python-2.0;md5=a5c8025e305fb49e6d405769358851f6"

SRC_URI[md5sum] = "120d95c96d44185ee46666ba144de14d"
SRC_URI[sha256sum] = "720e34a539a76a1fedcebe4397290604cc2bdf6f81eca44adb9fb2ea071c0c69"

inherit pypi setuptools3

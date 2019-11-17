SUMMARY = "Factory+Registry pattern for Python classes."
DESCRIPTION = "At the intersection of the Registry and Factory patterns lies the ClassRegistry: \
 - Define global factories that generate new class instances based on configurable keys. \
 - Seamlessly create powerful service registries. \
 - Integrate with setuptools’s entry_points system to make your registries infinitely extensible by 3rd-party libraries! \
 - And more! \
"

HOMEPAGE = "https://pypi.org/project/class-registry/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[md5sum] = "58b669e9e5f312ea2fa0b0fd7c4752af"
SRC_URI[sha256sum] = "f11462ac410a8cda38c2b6a83b51a2390c7d9528baef591cb5b551b11aba2a92"

inherit pypi setuptools3

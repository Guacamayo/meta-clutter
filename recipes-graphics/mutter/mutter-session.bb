DESCRIPTION = "Simple test session for Mutter WM"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://mutter-session;endline=2;md5=d740449dea568696660a62fce0fb35bd"

SECTION = "x11"

RDEPENDS_${PN} = "mutter matchbox-terminal"

SRC_URI = "file://mutter-session"
S = "${WORKDIR}"

inherit update-alternatives

ALTERNATIVE_${PN} = "x-session-manager"
ALTERNATIVE_TARGET[x-session-manager] = "${bindir}/mutter-session"
ALTERNATIVE_PRIORITY = "100"

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/mutter-session ${D}/${bindir}
}

SECTION = "themes"
DESCRIPTION = "Gnome 3 standard themes"
LICENSE = "LGPLv2.1"
DEPENDS = "gtk+3 librsvg-native"

LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

SRC_URI = "git://git.gnome.org/${BPN};protocol=git;tag=${PV}"
S = "${WORKDIR}/git"

RDEPENDS_${PN} += "librsvg-gtk"

inherit autotools

EXTRA_OECONF += "--disable-gtk2-engine"

FILES_${PN} += "${datadir} ${libdir}"
FILES_${PN}-dbg += "${libdir}/*/*/*/.debug"
FILES_${PN}-dev += "${libdir}/*/*/*/*.la"
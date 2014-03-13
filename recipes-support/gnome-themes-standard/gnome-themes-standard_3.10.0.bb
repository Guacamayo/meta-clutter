SECTION = "themes"
DESCRIPTION = "Gnome 3 standard themes"
LICENSE = "LGPLv2.1"
DEPENDS = "gtk+3 librsvg-native librsvg"

LIC_FILES_CHKSUM = "file://COPYING;md5=2d5025d4aa3495befef8f17206a5b0a1"

inherit gnomebase gtk-icon-cache

GNOME_COMPRESS_TYPE = "xz"

SRC_URI[archive.md5sum] = "854209d213c8d6ab89c053a3f9077e57"
SRC_URI[archive.sha256sum] = "812c6cfc534fced921dc327b436e70020d8979529284bb59d72d6f37af1f4b38"

EXTRA_OECONF += "--disable-gtk2-engine"

FILES_${PN} += "${datadir} ${libdir}"
FILES_${PN}-dbg += "${libdir}/*/*/*/.debug"
FILES_${PN}-dev += "${libdir}/*/*/*/*.la"

RDEPENDS_${PN} += "librsvg-gtk"


SECTION = "x11/wm"
DESCRIPTION = "Gnome 3 window manager"
LICENSE = "GPLv2"
DEPENDS = "startup-notification gtk+3 clutter-1.0 gsettings-desktop-schemas gnome-desktop3 intltool upower"

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
SRC_URI[archive.md5sum] = "b234ee4d69f5fce4486a80fdaf4a4263"

CFLAGS += " -Wno-error=cast-align"

PACKAGES += "lib${PN} ${PN}-tools ${PN}-sample-plugin ${PN}-sample-plugin-dbg"

RDEPENDS_${PN} += "gsettings-desktop-schemas gnome-themes-standard"

inherit clutter update-alternatives gsettings gconf

ALTERNATIVE_${PN} = "x-window-manager"
ALTERNATIVE_TARGET[x-window-manager] = "${bindir}/mutter"
ALTERNATIVE_PRIORITY = "11"

EXTRA_OECONF += "--disable-introspection"

FILES_${PN} = "${bindir}/mutter ${datadir}"
FILES_${PN}-tools = "${bindir}/${PN}-*"
FILES_lib${PN} = "${libdir}/*.so.*"
FILES_${PN}-sample-plugin += "${libdir}/mutter/plugins/*.so"
FILES_${PN}-sample-plugin-dbg += "${libdir}/mutter/plugins/.debug/*"

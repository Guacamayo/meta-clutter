
SECTION = "x11/wm"
DESCRIPTION = "Gnome 3 window manager"
LICENSE = "GPLv2"
DEPENDS = "startup-notification gtk+3 clutter-1.0 gsettings-desktop-schemas intltool"

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

PACKAGES += "lib${PN} ${PN}-tools ${PN}-sample-plugin ${PN}-sample-plugin-dbg"

inherit clutter-tweaks update-alternatives gsettings gconf

ALTERNATIVE_${PN} = "x-window-manager"
ALTERNATIVE_TARGET[x-window-manager] = "${bindir}/mutter"
ALTERNATIVE_PRIORITY = "11"

EXTRA_OECONF += "--disable-introspection"

FILES_${PN} = "${bindir}/mutter ${datadir}"
FILES_${PN}-tools = "${bindir}/${PN}-*"
FILES_lib${PN} = "${libdir}/*.so.*"
FILES_${PN}-sample-plugin += "${libdir}/mutter/plugins/*.so"
FILES_${PN}-sample-plugin-dbg += "${libdir}/mutter/plugins/.debug/*"

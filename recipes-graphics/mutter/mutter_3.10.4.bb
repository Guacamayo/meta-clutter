SECTION = "x11/wm"
DESCRIPTION = "Gnome 3 window manager"
LICENSE = "GPLv2"
DEPENDS = "startup-notification gtk+3 clutter-1.0 gsettings-desktop-schemas intltool gnome-desktop3"

LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

CFLAGS += " -Wno-error=cast-align"

SRC_URI[archive.md5sum] = "e25602e010097aa44611da102c514c7c"
SRC_URI[archive.sha256sum] = "9159c40ea9f5c5e3d1e67cc12ebcbd6328a7b732274195b4e5bdacb3cb1771e6"

inherit clutter update-alternatives gsettings gconf

PACKAGES += "lib${PN} ${PN}-tools ${PN}-sample-plugin ${PN}-sample-plugin-dbg"

ALTERNATIVE_${PN} = "x-window-manager"
ALTERNATIVE_TARGET[x-window-manager] = "${bindir}/mutter"
ALTERNATIVE_PRIORITY = "11"

FILES_${PN} = "${bindir}/mutter ${datadir}"
FILES_${PN}-tools = "${bindir}/${PN}-*"
FILES_lib${PN} = "${libdir}/*.so.*"
FILES_${PN}-sample-plugin += "${libdir}/mutter/plugins/*.so"
FILES_${PN}-sample-plugin-dbg += "${libdir}/mutter/plugins/.debug/*"

RDEPENDS_${PN} += "gsettings-desktop-schemas gnome-themes-standard"

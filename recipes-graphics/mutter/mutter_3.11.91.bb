SECTION = "x11/wm"
DESCRIPTION = "Gnome 3 window manager"
LICENSE = "GPLv2"
DEPENDS = "startup-notification gtk+3 clutter-1.0 gsettings-desktop-schemas intltool"

LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI[archive.md5sum] = "4e2090204d7c35adde98aaeef3844d86"
SRC_URI[archive.sha256sum] = "1aa6a69b1f8c454e71d7c53916bca06b561d3792001a21d7230721d195d5dfa4"

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

DESCRIPTION = "Clutter graphics library"
HOMEPAGE = "http://www.clutter-project.org/"
LICENSE = "LGPLv2.1+"

inherit clutter-tweaks

SRC_URI += "file://enable_tests.patch"

STDDEPENDS = "gtk-doc-native pango glib-2.0 libxfixes json-glib atk \
	      udev libxkbcommon cogl-1.0"

STDDEPENDS_GLX = "virtual/libx11 libxi virtual/libgl"
STDDEPENDS_EGL = "virtual/egl"

STDRDEPENDS     = "xkeyboard-config"
STDRDEPENDS_EGL = ""
STDRDEPENDS_GLX = ""

AUTOTOOLS_AUXDIR = "${S}/build"

# Disable pretty much everything, override in platform specific set up
BASE_CONF = "--disable-gtk-doc			\
	     ${@get_fpu_setting(bb, d)}		\
             --disable-introspection	    	\
	     --disable-egl-backend		\
	     --disable-quartz-backend		\
	     --disable-win32-backend		\
	     --disable-x11-backend		\
	     --disable-gdk-backend		\
	     --disable-wayland-backend		\
	     --disable-wayland-compositor	\
	     --disable-cex100-backend		\
	     --disable-tslib-input		\
	     --disable-evdev-input		\
	    "

BASE_CONF_EGL = "--enable-egl-backend		\
		 --enable-evdev-input		\
		"

BASE_CONF_GLX = "--enable-x11-backend		\
		 --enable-evdev-input		\
		"

PACKAGES =+ "${PN}-examples"

# Default configuration, distros might want to override
DEPENDS        = "${STDDEPENDS} ${STDDEPENDS_GLX}"
RDEPENDS_${PN} = "${STDRDEPENDS} ${STDRDEPENDS_GLX}"
EXTRA_OECONF   = "${BASE_CONF} ${BASE_CONF_GLX}"

FILES_${PN}-examples = "${bindir}/test-* ${pkgdatadir}/redhand.png"

do_configure_prepend() {
        # Fix up some weirdness in the docs
        sed -i s:doc/reference/Makefile::g ${S}/configure.ac
        sed -i s:doc::g ${S}/Makefile.am

	# see https://bugzilla.gnome.org/show_bug.cgi?id=661128 for this
	touch -t 200001010000 po/clutter-1.0.pot

	# Disable DOLT
	sed -i -e 's/^DOLT//' ${S}/configure.ac
}

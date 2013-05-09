DESCRIPTION = "a modern 3D graphics API with associated utility APIs"
HOMEPAGE = "http://wiki.clutter-project.org/wiki/Cogl"
LICENSE = "LGPLv2.1+"

inherit clutter-tweaks

PACKAGES =+ "${PN}-examples"

AUTOTOOLS_AUXDIR = "${S}/build"

STDDEPENDS       = "gtk-doc-native pango glib-2.0 gdk-pixbuf"
STDDEPENDS_GL    = "virtual/libgl libdrm"
STDDEPENDS_KMS   = "libdrm virtual/egl"
STDDEPENDS_EGL   = "virtual/egl"
STDDEPENDS_GLES2 = "virtual/libgles2"
STDDEPENDS_X11   = "virtual/libx11 libxcomposite libxfixes libxi"

# This has to be explictly listed, because cogl dlopens the backends
STDRDEPENDS       = ""
STDRDEPENDS_GL    = "libgl"
STDRDEPENDS_GLES2 = "libgles2"

BASE_CONF = "--disable-introspection		\
	     --disable-gtk-doc			\
	     ${@get_fpu_setting(bb, d)}		\
	     --enable-examples-install		\
	     --enable-debug		 	\
	     --disable-gl			\
	     --disable-gles			\
	     --disable-gles2			\
	     --disable-glx			\
	    "

BASE_CONF_EGL_GL = "--enable-gl			\
		    --enable-kms-egl-platform	\
		   "

BASE_CONF_KMS_GLES = "--enable-gles2		\
		      --enable-kms-egl-platform	\
		     "

BASE_CONF_EGL_GLES = "--enable-gles2			\
		      --enable-null-egl-platform	\
		     "

BASE_CONF_X11_GLES = "--enable-gles2			\
		      --enable-xlib-egl-platform	\
		     "
BASE_CONF_X11_GL = "--enable-gl		\
		    --enable-glx	\
		   "

# Some standard machine specific configs, distros might want to override
DEPENDS             = "${STDDEPENDS} ${STDDEPENDS_X11} ${STDDEPENDS_GL}"
DEPENDS_beagleboard = "${STDDEPENDS} ${STDDEPENDS_GLES2} ${STDDEPENDS_EGL}"
DEPENDS_raspberrypi = "${STDDEPENDS} ${STDDEPENDS_GLES2} ${STDDEPENDS_EGL}"

RDEPENDS_${PN}             += "${STDRDEPENDS} ${STDRDEPENDS_GL}"
RDEPENDS_${PN}_beagleboard += "${STDRDEPENDS} ${STDRDEPENDS_GLES2}"
RDEPENDS_${PN}_raspberrypi += "${STDRDEPENDS} ${STDRDEPENDS_GLES2}"

EXTRA_OECONF             = "${BASE_CONF} ${BASE_CONF_X11_GL}"
EXTRA_OECONF_beagleboard = "${BASE_CONF} ${BASE_CONF_EGL_GLES}"
EXTRA_OECONF_raspberrypi = "${BASE_CONF} ${BASE_CONF_EGL_GLES}"

#Fix up some weirdness in the docs
do_configure_prepend() {
        sed -i s:doc/reference/Makefile::g ${S}/configure.ac
        sed -i s:doc::g ${S}/Makefile.am

	# Disable DOLT
	sed -i -e 's/^DOLT//' ${S}/configure.ac
}

FILES_${PN}-examples = "${bindir}/* ${datadir}/cogl/examples-data/*"


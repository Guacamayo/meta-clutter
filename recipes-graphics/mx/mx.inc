DESCRIPTION = "Clutter based widget library"
LICENSE = "LGPLv2.1"

DEPENDS = "clutter-1.14 dbus-glib gdk-pixbuf"

def get_verdir(v):
    import re
    m = re.match("^([0-9]+)\.([0-9]+)", v)
    return "%s.%s" % (m.group(1), m.group(2))

FILESPATH = "${FILE_DIRNAME}/mx-${PV}:${FILE_DIRNAME}/mx-${@get_verdir("${PV}")}:${FILE_DIRNAME}/mx"

SRC_URI = "http://source.clutter-project.org/sources/mx/${@get_verdir("${PV}")}/mx-${PV}.tar.xz"

inherit autotools pkgconfig gtk-doc gettext

EXTRA_OECONF = "--disable-introspection		\
	        --disable-gtk-doc		\
	        --disable-gtk-widgets		\
		--with-dbus			\
		--with-winsys=none		\
		--without-clutter-imcontext	\
		--without-clutter-gesture	\
		--without-startup-notification	\
		--without-glade			\
	       "


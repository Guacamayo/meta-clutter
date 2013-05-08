DESCRIPTION = "Clutter based widget library"
LICENSE = "LGPLv2.1"

DEPENDS = "clutter-1.0 dbus-glib gdk-pixbuf"

def get_mx_verdir(v):
    import re
    m = re.match("^([0-9]+)\.([0-9]+)", v)
    return "%s.%s" % (m.group(1), m.group(2))

VERBASE = "${@get_mx_verdir("${PV}")}"
FILESPATH = "${@base_set_filespath(["${FILE_DIRNAME}/${BP}", "${FILE_DIRNAME}/mx-${VERBASE}", "${FILE_DIRNAME}/${BPN}", "${FILE_DIRNAME}/files"], d)}"

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


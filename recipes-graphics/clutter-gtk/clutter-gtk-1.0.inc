DESCRIPTION = "ClutterGtk"
HOMEPAGE = "http://www.clutter-project.org/"
LICENSE = "LGPLv2+"

inherit clutter-tweaks

PACKAGES  =+ "${PN}-examples"

DEPENDS = "clutter-1.0 gtk+3"

EXTRA_OECONF += "--disable-introspection"

AUTOTOOLS_AUXDIR = "${S}/build"

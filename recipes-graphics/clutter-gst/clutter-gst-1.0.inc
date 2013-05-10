DESCRIPTION = "Clutter GStreamer"
HOMEPAGE = "http://www.clutter-project.org/"
LICENSE = "LGPLv2+"

inherit clutter-tweaks

SRC_URI += "file://enable-tests.patch"

PACKAGES  =+ "${PN}-examples"

DEPENDS = "gst-plugins-base gst-plugins-bad clutter-1.0"
RDEPENDS_${PN} += "gst-meta-base"

EXTRA_OECONF += "--disable-introspection"

FILES_${PN}          += "${libdir}/gstreamer-0.10/lib*.so"
FILES_${PN}-dev      += "${libdir}/gstreamer-0.10/*.la"
FILES_${PN}-dbg      += "${libdir}/gstreamer-0.10/.debug/lib*.so"
FILES_${PN}-examples  = "${bindir}/video-player ${bindir}/video-sink"

do_configure_prepend () {
       # Disable DOLT
       sed -i -e 's/^DOLT//' ${S}/configure.ac
}
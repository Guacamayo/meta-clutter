require mx.inc

DEFAULT_PREFERENCE = "-1"

SRCREV = "692f046da880ca7053dcacf3f34d3dd737f89470"
PV = "2.0.0+git${SRCPV}"

SRC_URI = "git://github.com/clutter-project/mx.git;protocol=git \
	   file://fix-build-dir.patch \
	   file://fix-test-includes.patch \
	  "
S = "${WORKDIR}/git"

LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=243b725d71bb5df4a1e5920b344b86ad \
                    file://mx/mx-widget.c;beginline=8;endline=20;md5=13bba3c973a72414a701e1e87b5ee879"

require clutter-gst-1.0.inc

SRC_URI += "file://clutter-1.14.patch		\
	    file://fix-for-no-gles1.patch	\
	   "

LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c \
                    file://clutter-gst/clutter-gst.h;beginline=1;endline=24;md5=95baacba194e814c110ea3bdf25ddbf4"

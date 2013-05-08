
require cogl-1.0.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

SRC_URI += "file://fix-kms-backend.patch"
SRC_URI_append_beagleboard = " file://beagleboard-glchar.patch"
SRC_URI_append_raspberrypi = " file://rpi.patch"

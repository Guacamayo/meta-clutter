DESCRIPTION = "Minimal image with Mutter as the WM"

IMAGE_FEATURES += "splash package-management ssh-server-dropbear"

LICENSE = "MIT"

inherit core-image

DESKTOP_PKGS ="		\
    mutter			\
    mutter-sample-plugin	\
    mutter-session		\
    liberation-fonts		\
    "

APP_PKGS ="			\
    matchbox-terminal		\
    "

TOOL_PKGS ="			\
    xwininfo			\
    xprop			\
    cogl-1.0-examples		\
    clutter-1.0-examples	\
    mesa-demos			\
    "

IMAGE_INSTALL += "			\
    packagegroup-core-x11-xserver	\
    packagegroup-core-x11-utils		\
    dbus				\
    xkeyboard-config			\
    settings-daemon			\
    ${DESKTOP_PKGS}			\
    ${APP_PKGS}				\
    ${TOOL_PKGS}			\
    "

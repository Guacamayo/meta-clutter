
def get_minor_dir(v):
    import re
    m = re.match("^([0-9]+)\.([0-9]+)", v)
    return "%s.%s" % (m.group(1), m.group(2))

def get_real_name(n):
    import re
    m = re.match("^([a-z]+(-[a-z]+)?)(-[0-9]+\.[0-9]+)?", n)
    return "%s" % (m.group(1))

VERMINOR = "${@get_minor_dir("${PV}")}"
REALNAME = "${@get_real_name("${BPN}")}"
FILESPATH = "${@base_set_filespath(["${FILE_DIRNAME}/${REALNAME}-${PV}", "${FILE_DIRNAME}/${REALNAME}-${VERMINOR}", "${FILE_DIRNAME}/${REALNAME}", "${FILE_DIRNAME}/files"], d)}"

def get_fpu_setting(bb, d):
    if d.getVar('TARGET_FPU', True) in [ 'soft' ]:
        return "--without-fpu"
    return ""

SRC_URI = "git://git.gnome.org/${REALNAME};protocol=git;tag=${PV}"
S = "${WORKDIR}/git"

inherit autotools pkgconfig gtk-doc gettext

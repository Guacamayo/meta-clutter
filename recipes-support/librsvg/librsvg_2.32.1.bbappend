
SSTATEPOSTINSTFUNCS_append_class_native = " librsvg_sstate_postinst"

librsvg_sstate_postinst() {
	if [ "${BB_CURRENTTASK}" = "populate_sysroot" -o "${BB_CURRENTTASK}" = "populate_sysroot_setscene" ]
	then
		gdk-pixbuf-query-loaders --update-cache
	fi
}


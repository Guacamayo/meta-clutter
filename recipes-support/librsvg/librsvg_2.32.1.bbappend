
SSTATEPOSTINSTFUNCS_class_native += "librsvg_sstate_postinst"

librsvg_sstate_postinst() {
	if [ "${BB_CURRENTTASK}" = "populate_sysroot" -o "${BB_CURRENTTASK}" = "populate_sysroot_setscene" ]
	then
		GDK_PIXBUF_MODULEDIR=${STAGING_LIBDIR_NATIVE}/gdk-pixbuf-2.0/2.10.0/loaders GDK_PIXBUF_MODULE_FILE=${STAGING_LIBDIR_NATIVE}/gdk-pixbuf-2.0/2.10.0/loaders.cache gdk-pixbuf-query-loaders --update-cache
	fi
}


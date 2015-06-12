// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons.a;

import android.widget.AdapterView;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import java.io.File;
import android.content.Context;
import android.app.AlertDialog;
import android.widget.AdapterView$OnItemClickListener;

public class b implements AdapterView$OnItemClickListener
{
    private final AlertDialog a;
    private d b;
    private a c;
    
    public b(final Context context, File d, final boolean b) {
        if (d == null) {
            d = com.ogqcorp.commons.a.a.d();
        }
        else {
            if (!d.exists()) {
                throw new IllegalArgumentException("startDirectory must exist.");
            }
            if (!d.isDirectory()) {
                throw new IllegalArgumentException("startDirectory must be a directory.");
            }
        }
        this.c = new a(d, b);
        final View inflate = LayoutInflater.from(context).inflate(g.fcd_dialog, (ViewGroup)null);
        final ListView listView = (ListView)inflate.findViewById(16908298);
        listView.setOnItemClickListener((AdapterView$OnItemClickListener)this);
        listView.setAdapter((ListAdapter)new c(this, context));
        (this.a = this.a(context, b)).setView(inflate, 0, 0, 0, 0);
    }
    
    private int a(final File file, final boolean b) {
        if (b) {
            if (file.isFile()) {
                return f.fcd_ic_file;
            }
            if (file.getName().equals("..")) {
                return f.fcd_ic_parent;
            }
            return f.fcd_ic_directory;
        }
        else {
            if (file.isFile()) {
                return f.fcd_ic_file_light;
            }
            if (file.getName().equals("..")) {
                return f.fcd_ic_parent_light;
            }
            return f.fcd_ic_directory_light;
        }
    }
    
    private AlertDialog a(final Context context, final boolean b) {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder(context);
        alertDialog$Builder.setTitle((CharSequence)this.b());
        alertDialog$Builder.setNegativeButton(17039360, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
                dialogInterface.cancel();
            }
        });
        if (!b) {
            alertDialog$Builder.setPositiveButton(17039370, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                public void onClick(final DialogInterface dialogInterface, final int n) {
                    if (com.ogqcorp.commons.a.b.this.b != null) {
                        com.ogqcorp.commons.a.b.this.b.a(com.ogqcorp.commons.a.b.this, com.ogqcorp.commons.a.b.this.c.a());
                    }
                }
            });
        }
        return alertDialog$Builder.create();
    }
    
    private String a(final File obj) {
        if (obj.getAbsolutePath().equals("/")) {
            return "/";
        }
        if (com.ogqcorp.commons.a.a.d().equals(obj)) {
            return "External Storage";
        }
        return obj.getName();
    }
    
    private String b() {
        return this.a(this.c.a());
    }
    
    public void a() {
        if (this.a != null) {
            this.a.show();
        }
    }
    
    public void a(final d b) {
        this.b = b;
    }
    
    public void onItemClick(final AdapterView<?> adapterView, final View view, final int n, final long n2) {
        final c c = (c)adapterView.getAdapter();
        final File file = (File)c.getItem(n);
        if (file.isFile()) {
            if (this.b != null) {
                this.b.a(this, file);
            }
            this.a.dismiss();
            return;
        }
        if (file.getName().equals("..")) {
            c.a();
            return;
        }
        c.a(file);
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons.a;

import android.os.Build$VERSION;
import java.util.Collections;
import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.os.Environment;
import java.util.List;
import java.io.File;
import java.util.Comparator;

final class a implements Comparator<File>
{
    private File a;
    private final boolean b;
    private List<File> c;
    
    public a(final File a, final boolean b) {
        this.a = a;
        this.b = b;
    }
    
    @SuppressLint({ "SdCardPath" })
    public static File d() {
        try {
            return Environment.getExternalStorageDirectory();
        }
        catch (Exception ex) {
            return new File("/sdcard");
        }
    }
    
    private List<File> e() {
        boolean b = true;
        final ArrayList<Object> list = new ArrayList<Object>();
        final File[] listFiles = this.a.listFiles();
        if (listFiles != null) {
            for (final File e : listFiles) {
                if (this.b == b || e.isDirectory() == b) {
                    list.add(e);
                }
            }
            Collections.sort(list, (Comparator<? super Object>)this);
        }
        if (Build$VERSION.SDK_INT >= 19 && d().equals(this.a)) {
            b = false;
        }
        if (this.a.getParentFile() != null && b) {
            list.add(0, new File(".."));
        }
        return (List<File>)list;
    }
    
    public int a(final File file, final File file2) {
        if (file.isDirectory() && !file2.isDirectory()) {
            return -1;
        }
        if (file2.isDirectory() && !file.isDirectory()) {
            return 1;
        }
        return file.getPath().compareToIgnoreCase(file2.getPath());
    }
    
    public File a() {
        return this.a;
    }
    
    public void a(final File a) {
        this.a = a;
        this.c = null;
    }
    
    public List<File> b() {
        if (this.c == null) {
            this.c = this.e();
        }
        return this.c;
    }
    
    public void c() {
        final File parentFile = this.a.getParentFile();
        if (parentFile != null) {
            this.a = parentFile;
            this.c = null;
        }
    }
}

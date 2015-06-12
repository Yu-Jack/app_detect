// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.system;

import org.a.a.a.b;
import java.util.Locale;
import android.annotation.SuppressLint;
import android.os.Environment;
import java.io.File;

public abstract class p
{
    @SuppressLint({ "SdCardPath" })
    public static File p() {
        try {
            return Environment.getExternalStorageDirectory();
        }
        catch (Exception ex) {
            return new File("/sdcard");
        }
    }
    
    protected abstract File a();
    
    protected File h(final int n) {
        return new File(this.a(), "/Cache/" + String.format(Locale.US, "%03d", n % 100));
    }
    
    public void m() {
        this.q();
        this.s();
        this.t();
    }
    
    public long n() {
        try {
            return b.g(this.r());
        }
        catch (IllegalArgumentException ex) {
            return 0L;
        }
    }
    
    public void o() {
        b.b(this.r());
        this.s();
        this.t();
    }
    
    protected void q() {
        this.a().mkdirs();
    }
    
    protected File r() {
        return new File(this.a(), "/Cache/");
    }
    
    protected void s() {
        int n = 0;
    Label_0017_Outer:
        while (true) {
            if (n >= 100) {
                return;
            }
            while (true) {
                try {
                    this.h(n).mkdirs();
                    ++n;
                    continue Label_0017_Outer;
                }
                catch (Exception ex) {
                    continue;
                }
                break;
            }
        }
    }
    
    protected void t() {
        try {
            new File(this.r(), "/.nomedia").createNewFile();
        }
        catch (Exception ex) {
            l.a(ex);
        }
    }
}

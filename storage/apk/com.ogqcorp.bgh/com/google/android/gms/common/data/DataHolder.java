// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.common.data;

import android.os.Parcel;
import android.util.Log;
import android.net.Uri;
import com.google.android.gms.internal.gz;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class DataHolder implements SafeParcelable
{
    public static final b CREATOR;
    private static final a l;
    Bundle a;
    int[] b;
    int c;
    boolean d;
    private final int e;
    private final String[] f;
    private final CursorWindow[] g;
    private final int h;
    private final Bundle i;
    private Object j;
    private boolean k;
    
    static {
        CREATOR = new b();
        l = new a((String)null) {};
    }
    
    DataHolder(final int e, final String[] f, final CursorWindow[] g, final int h, final Bundle i) {
        this.d = false;
        this.k = true;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    private void a(final String str, final int n) {
        if (this.a == null || !this.a.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        }
        if (this.h()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (n < 0 || n >= this.c) {
            throw new CursorIndexOutOfBoundsException(n, this.c);
        }
    }
    
    public int a(final int n) {
        int i = 0;
        gz.a(n >= 0 && n < this.c);
        while (i < this.b.length) {
            if (n < this.b[i]) {
                --i;
                break;
            }
            ++i;
        }
        if (i == this.b.length) {
            --i;
        }
        return i;
    }
    
    public long a(final String s, final int n, final int n2) {
        this.a(s, n);
        return this.g[n2].getLong(n, this.a.getInt(s));
    }
    
    public void a() {
        int i = 0;
        this.a = new Bundle();
        for (int j = 0; j < this.f.length; ++j) {
            this.a.putInt(this.f[j], j);
        }
        this.b = new int[this.g.length];
        int c = 0;
        while (i < this.g.length) {
            this.b[i] = c;
            c += this.g[i].getNumRows() - (c - this.g[i].getStartPosition());
            ++i;
        }
        this.c = c;
    }
    
    public boolean a(final String s) {
        return this.a.containsKey(s);
    }
    
    int b() {
        return this.e;
    }
    
    public int b(final String s, final int n, final int n2) {
        this.a(s, n);
        return this.g[n2].getInt(n, this.a.getInt(s));
    }
    
    public String c(final String s, final int n, final int n2) {
        this.a(s, n);
        return this.g[n2].getString(n, this.a.getInt(s));
    }
    
    String[] c() {
        return this.f;
    }
    
    public boolean d(final String s, final int n, final int n2) {
        this.a(s, n);
        return Long.valueOf(this.g[n2].getLong(n, this.a.getInt(s))) == 1L;
    }
    
    CursorWindow[] d() {
        return this.g;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public int e() {
        return this.h;
    }
    
    public byte[] e(final String s, final int n, final int n2) {
        this.a(s, n);
        return this.g[n2].getBlob(n, this.a.getInt(s));
    }
    
    public Uri f(final String s, final int n, final int n2) {
        final String c = this.c(s, n, n2);
        if (c == null) {
            return null;
        }
        return Uri.parse(c);
    }
    
    public Bundle f() {
        return this.i;
    }
    
    @Override
    protected void finalize() {
        try {
            if (this.k && this.g.length > 0 && !this.h()) {
                String str;
                if (this.j == null) {
                    str = "internal object: " + this.toString();
                }
                else {
                    str = this.j.toString();
                }
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call close() on all DataBuffer extending objects when you are done with them. (" + str + ")");
                this.i();
            }
        }
        finally {
            super.finalize();
        }
    }
    
    public int g() {
        return this.c;
    }
    
    public boolean g(final String s, final int n, final int n2) {
        this.a(s, n);
        return this.g[n2].isNull(n, this.a.getInt(s));
    }
    
    public boolean h() {
        synchronized (this) {
            return this.d;
        }
    }
    
    public void i() {
        synchronized (this) {
            if (!this.d) {
                this.d = true;
                for (int i = 0; i < this.g.length; ++i) {
                    this.g[i].close();
                }
            }
        }
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.common.data.b.a(this, parcel, n);
    }
}

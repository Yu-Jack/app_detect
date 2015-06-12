// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import org.json.JSONException;
import com.facebook.b.v;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import android.content.Context;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.Map;
import com.facebook.c.c;
import java.util.Iterator;
import android.os.Bundle;
import com.facebook.c.d;
import org.json.JSONArray;
import java.util.Collection;
import java.io.UnsupportedEncodingException;
import com.facebook.b.aj;
import java.util.ArrayList;
import com.facebook.b.a;
import java.util.List;

final class l
{
    private List a;
    private List b;
    private int c;
    private a d;
    private String e;
    private String f;
    private final int g;
    
    public l(final a d, final String e, final String f) {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.g = 1000;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    private static byte[] a(final String s) {
        try {
            return s.getBytes("UTF-8");
        }
        catch (UnsupportedEncodingException ex) {
            aj.a("Encoding exception: ", ex);
            return null;
        }
    }
    
    public final int a() {
        synchronized (this) {
            return this.a.size();
        }
    }
    
    public final int a(final Request request, final boolean b, final boolean b2, final boolean b3) {
        final int c;
        final JSONArray jsonArray;
        synchronized (this) {
            c = this.c;
            this.b.addAll(this.a);
            this.a.clear();
            jsonArray = new JSONArray();
            for (final f f : this.b) {
                if (b || !f.a()) {
                    jsonArray.put((Object)f.b());
                }
            }
            if (jsonArray.length() == 0) {
                return 0;
            }
        }
        // monitorexit(this)
        final c a = com.facebook.c.d.a();
        a.f();
        if (this.c > 0) {
            c;
            a.f();
        }
        if (b2) {
            aj.a(a, this.d, this.f, b3);
        }
        while (true) {
            try {
                aj.a(a, com.facebook.d.h);
                final String e = this.e;
                a.f();
                request.a(a);
                Bundle b4 = request.b();
                if (b4 == null) {
                    b4 = new Bundle();
                }
                final String string = jsonArray.toString();
                if (string != null) {
                    b4.putByteArray("custom_events_file", a(string));
                    request.a((Object)string);
                }
                request.a(b4);
                return jsonArray.length();
            }
            catch (Exception ex) {
                continue;
            }
            break;
        }
    }
    
    public final void a(final f f) {
        synchronized (this) {
            if (this.a.size() + this.b.size() >= 1000) {
                ++this.c;
            }
            else {
                this.a.add(f);
            }
        }
    }
    
    public final void a(final List list) {
        synchronized (this) {
            this.a.addAll(list);
        }
    }
    
    public final void a(final boolean b) {
        // monitorenter(this)
        Label_0020: {
            if (!b) {
                break Label_0020;
            }
            try {
                this.a.addAll(this.b);
                this.b.clear();
                this.c = 0;
            }
            finally {
            }
            // monitorexit(this)
        }
    }
    
    public final List b() {
        synchronized (this) {
            final List a = this.a;
            this.a = new ArrayList();
            return a;
        }
    }
}

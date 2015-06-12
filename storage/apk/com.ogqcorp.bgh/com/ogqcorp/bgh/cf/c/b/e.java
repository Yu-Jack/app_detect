// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.c.b;

import com.a.a.n;
import com.a.a.a.i;
import com.ogqcorp.bgh.cf.c.b.a.c;
import com.a.a.h;
import com.a.a.b;
import java.io.File;
import org.apache.http.client.HttpClient;
import com.a.a.a.f;
import android.net.http.AndroidHttpClient;
import com.a.a.a.j;
import android.os.Build$VERSION;
import android.content.Context;
import com.ogqcorp.bgh.cf.c.b.a.a;
import com.a.a.p;

public final class e
{
    private static e a;
    private p b;
    private a c;
    
    static {
        e.a = new e();
    }
    
    public static e a() {
        return e.a;
    }
    
    private String b(final Context context) {
        try {
            return "BGH/" + context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode + " (Android)";
        }
        catch (Exception ex) {
            return "BGH";
        }
    }
    
    private p c(final Context context) {
        final String b = this.b(context);
        i i;
        if (Build$VERSION.SDK_INT >= 9) {
            i = new j();
        }
        else {
            i = new f((HttpClient)AndroidHttpClient.newInstance(b));
        }
        final p p = new p(new g(this, new File(context.getCacheDir(), "cache_v")), new com.a.a.a.a(i));
        p.a();
        this.c = new a(p, new com.ogqcorp.bgh.cf.c.b.f((int)(Runtime.getRuntime().maxMemory() / 1024L) / 8));
        return p;
    }
    
    public void a(final Context context) {
        this.b = this.c(context);
    }
    
    public void a(final n<?> n) {
        this.b.a(n);
    }
    
    public void a(final com.ogqcorp.bgh.cf.c.b.a.g g, final String s) {
        g.a(s, this.c);
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import java.util.Map;
import java.util.Collection;
import java.util.ArrayList;
import android.content.Context;

public class b implements UncaughtExceptionHandler
{
    private final UncaughtExceptionHandler a;
    private final k b;
    private final Context c;
    private a d;
    
    public b(final k b, final UncaughtExceptionHandler a, final Context context) {
        if (b == null) {
            throw new NullPointerException("tracker cannot be null");
        }
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.a = a;
        this.b = b;
        this.d = new j(context, new ArrayList<String>());
        this.c = context.getApplicationContext();
        final StringBuilder append = new StringBuilder().append("ExceptionReporter created, original handler is ");
        String name;
        if (a == null) {
            name = "null";
        }
        else {
            name = a.getClass().getName();
        }
        p.c(append.append(name).toString());
    }
    
    @Override
    public void uncaughtException(final Thread thread, final Throwable t) {
        String a = "UncaughtException";
        if (this.d != null) {
            String name;
            if (thread != null) {
                name = thread.getName();
            }
            else {
                name = null;
            }
            a = this.d.a(name, t);
        }
        p.c("Tracking Exception: " + a);
        this.b.a(new g().a(a).a(true).a());
        com.google.android.gms.analytics.c.a(this.c).e();
        if (this.a != null) {
            p.c("Passing exception to original handler.");
            this.a.uncaughtException(thread, t);
        }
    }
}

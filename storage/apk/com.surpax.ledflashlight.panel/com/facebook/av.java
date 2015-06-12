// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.os.Handler;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.Executor;
import java.net.HttpURLConnection;
import java.lang.reflect.Method;
import android.annotation.TargetApi;
import android.os.AsyncTask;

@TargetApi(3)
public class av extends AsyncTask
{
    private static final String a;
    private static Method b;
    private final HttpURLConnection c;
    private final aw d;
    private Exception e;
    
    static {
        a = av.class.getCanonicalName();
        for (final Method b : AsyncTask.class.getMethods()) {
            if ("executeOnExecutor".equals(b.getName())) {
                final Class<?>[] parameterTypes = b.getParameterTypes();
                if (parameterTypes.length == 2 && parameterTypes[0] == Executor.class && parameterTypes[1].isArray()) {
                    av.b = b;
                    return;
                }
            }
        }
    }
    
    public av(final aw aw) {
        this(aw, (byte)0);
    }
    
    private av(final aw d, final byte b) {
        this.d = d;
        this.c = null;
    }
    
    private List b() {
        try {
            if (this.c == null) {
                return this.d.g();
            }
            return Request.a(this.c, this.d);
        }
        catch (Exception e) {
            this.e = e;
            return null;
        }
    }
    
    final av a() {
        try {
            if (av.b != null) {
                av.b.invoke(this, bq.b(), null);
                return this;
            }
            goto Label_0041;
        }
        catch (IllegalAccessException ex) {}
        catch (InvocationTargetException ex2) {
            goto Label_0041;
        }
    }
    
    protected void onPreExecute() {
        super.onPreExecute();
        if (this.d.c() == null) {
            this.d.a(new Handler());
        }
    }
    
    public String toString() {
        return "{RequestAsyncTask:  connection: " + this.c + ", requests: " + this.d + "}";
    }
}

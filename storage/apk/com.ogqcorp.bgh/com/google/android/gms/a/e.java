// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.a;

import android.os.IBinder;
import com.google.android.gms.common.g;
import com.google.android.gms.internal.gz;
import android.content.Context;

public abstract class e<T>
{
    private final String a;
    private T b;
    
    protected e(final String a) {
        this.a = a;
    }
    
    protected final T a(final Context context) {
        Label_0060: {
            if (this.b != null) {
                break Label_0060;
            }
            gz.a(context);
            final Context c = g.c(context);
            if (c == null) {
                throw new f("Could not get remote context.");
            }
            final ClassLoader classLoader = c.getClassLoader();
            try {
                this.b = this.a((IBinder)classLoader.loadClass(this.a).newInstance());
                return this.b;
            }
            catch (ClassNotFoundException ex) {
                throw new f("Could not load creator class.");
            }
            catch (InstantiationException ex2) {
                throw new f("Could not instantiate creator.");
            }
            catch (IllegalAccessException ex3) {
                throw new f("Could not access creator.");
            }
        }
    }
    
    protected abstract T a(final IBinder p0);
}

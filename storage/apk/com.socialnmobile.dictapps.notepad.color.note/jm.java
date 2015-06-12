import android.app.NotificationManager;
import java.lang.reflect.InvocationTargetException;
import android.util.Log;
import android.app.Notification;
import java.lang.reflect.Method;
import android.app.Service;

// 
// Decompiled by Procyon v0.5.29
// 

public final class jm
{
    private static final Class[] c;
    private static final Class[] d;
    private static final Class[] e;
    Service a;
    boolean b;
    private Method f;
    private Method g;
    private Method h;
    private Object[] i;
    private Object[] j;
    private Object[] k;
    
    static {
        c = new Class[] { Boolean.TYPE };
        d = new Class[] { Integer.TYPE, Notification.class };
        e = new Class[] { Boolean.TYPE };
    }
    
    public jm(final Service a) {
        this.i = new Object[1];
        this.j = new Object[2];
        this.k = new Object[1];
        this.b = false;
        this.a = a;
        try {
            this.g = a.getClass().getMethod("startForeground", (Class<?>[])jm.d);
            this.h = a.getClass().getMethod("stopForeground", (Class<?>[])jm.e);
        }
        catch (NoSuchMethodException ex) {
            this.h = null;
            this.g = null;
            try {
                this.f = a.getClass().getMethod("setForeground", (Class<?>[])jm.c);
            }
            catch (NoSuchMethodException ex2) {
                throw new IllegalStateException("OS doesn't have Service.startForeground OR Service.setForeground!");
            }
        }
    }
    
    private void a(final Method method, final Object[] args) {
        try {
            method.invoke(this.a, args);
        }
        catch (InvocationTargetException ex) {
            Log.w("ColorNote", "Unable to invoke method", (Throwable)ex);
        }
        catch (IllegalAccessException ex2) {
            Log.w("ColorNote", "Unable to invoke method", (Throwable)ex2);
        }
    }
    
    public final void a(final int n) {
        if (this.h != null) {
            this.k[0] = Boolean.TRUE;
            this.a(this.h, this.k);
            return;
        }
        ((NotificationManager)this.a.getSystemService("notification")).cancel(n);
        this.i[0] = Boolean.FALSE;
        this.a(this.f, this.i);
    }
    
    public final void a(final int i, final Notification notification) {
        if (this.g != null) {
            this.j[0] = i;
            this.j[1] = notification;
            this.a(this.g, this.j);
            return;
        }
        this.i[0] = Boolean.TRUE;
        this.a(this.f, this.i);
        ((NotificationManager)this.a.getSystemService("notification")).notify(i, notification);
    }
}

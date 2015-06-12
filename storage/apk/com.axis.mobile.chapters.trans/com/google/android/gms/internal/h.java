// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;

public abstract class h implements g
{
    protected MotionEvent jO;
    protected DisplayMetrics jP;
    protected m jQ;
    private n jR;
    
    protected h(final Context context, final m jq, final n jr) {
        this.jQ = jq;
        this.jR = jr;
        try {
            this.jP = context.getResources().getDisplayMetrics();
        }
        catch (UnsupportedOperationException ex) {
            this.jP = new DisplayMetrics();
            this.jP.density = 1.0f;
        }
    }
    
    private String a(final Context context, final String s, final boolean b, final boolean b2) {
        try {
            synchronized (this) {
                this.t();
                if (b) {
                    this.e(context);
                }
                else {
                    if (!b2) {
                        goto Label_0066;
                    }
                    this.d(context);
                }
                final byte[] u = this.u();
                // monitorexit(this)
                if (u.length == 0) {
                    return Integer.toString(5);
                }
                goto Label_0074;
            }
        }
        catch (NoSuchAlgorithmException ex) {
            return Integer.toString(7);
        }
        catch (UnsupportedEncodingException ex2) {
            return Integer.toString(7);
        }
        catch (IOException ex3) {
            return Integer.toString(3);
        }
    }
    
    private void t() {
        this.jR.reset();
    }
    
    private byte[] u() {
        return this.jR.A();
    }
    
    @Override
    public String a(final Context context) {
        return this.a(context, null, false, false);
    }
    
    @Override
    public String a(final Context context, final String s) {
        return this.a(context, s, true, false);
    }
    
    String a(byte[] u, final String s) {
        if (u.length > 239) {
            this.t();
            this.a(20, 1L);
            u = this.u();
        }
        byte[] array2;
        if (u.length < 239) {
            final byte[] array = new byte[239 - u.length];
            new SecureRandom().nextBytes(array);
            array2 = ByteBuffer.allocate(240).put((byte)u.length).put(u).put(array).array();
        }
        else {
            array2 = ByteBuffer.allocate(240).put((byte)u.length).put(u).array();
        }
        final MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(array2);
        final byte[] array3 = ByteBuffer.allocate(256).put(instance.digest()).put(array2).array();
        final byte[] array4 = new byte[256];
        new f().a(array3, array4);
        if (s != null && s.length() > 0) {
            this.a(s, array4);
        }
        return this.jQ.a(array4, true);
    }
    
    @Override
    public void a(final int n, final int n2, final int n3) {
        if (this.jO != null) {
            this.jO.recycle();
        }
        this.jO = MotionEvent.obtain(0L, (long)n3, 1, n * this.jP.density, n2 * this.jP.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }
    
    protected void a(final int n, final long n2) {
        this.jR.b(n, n2);
    }
    
    protected void a(final int n, final String s) {
        this.jR.b(n, s);
    }
    
    @Override
    public void a(final MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.jO != null) {
                this.jO.recycle();
            }
            this.jO = MotionEvent.obtain(motionEvent);
        }
    }
    
    void a(String substring, final byte[] array) {
        if (substring.length() > 32) {
            substring = substring.substring(0, 32);
        }
        new lx(substring.getBytes("UTF-8")).o(array);
    }
    
    @Override
    public String b(final Context context) {
        return this.a(context, null, false, true);
    }
    
    protected abstract void c(final Context p0);
    
    protected abstract void d(final Context p0);
    
    protected abstract void e(final Context p0);
}

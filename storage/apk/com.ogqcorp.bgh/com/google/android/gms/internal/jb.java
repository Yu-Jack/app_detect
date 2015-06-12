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

public abstract class jb implements ir
{
    protected MotionEvent a;
    protected DisplayMetrics b;
    protected ky c;
    private kz d;
    
    protected jb(final Context context, final ky c, final kz d) {
        this.c = c;
        this.d = d;
        try {
            this.b = context.getResources().getDisplayMetrics();
        }
        catch (UnsupportedOperationException ex) {
            this.b = new DisplayMetrics();
            this.b.density = 1.0f;
        }
    }
    
    private String a(final Context context, final String s, final boolean b) {
        try {
            synchronized (this) {
                this.a();
                if (b) {
                    this.c(context);
                }
                else {
                    this.b(context);
                }
                final byte[] b2 = this.b();
                // monitorexit(this)
                if (b2.length == 0) {
                    return Integer.toString(5);
                }
                goto Label_0061;
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
    
    private void a() {
        this.d.a();
    }
    
    private byte[] b() {
        return this.d.b();
    }
    
    @Override
    public String a(final Context context) {
        return this.a(context, null, false);
    }
    
    @Override
    public String a(final Context context, final String s) {
        return this.a(context, s, true);
    }
    
    String a(byte[] b, final String s) {
        if (b.length > 239) {
            this.a();
            this.a(20, 1L);
            b = this.b();
        }
        byte[] array2;
        if (b.length < 239) {
            final byte[] array = new byte[239 - b.length];
            new SecureRandom().nextBytes(array);
            array2 = ByteBuffer.allocate(240).put((byte)b.length).put(b).put(array).array();
        }
        else {
            array2 = ByteBuffer.allocate(240).put((byte)b.length).put(b).array();
        }
        final MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(array2);
        final byte[] array3 = ByteBuffer.allocate(256).put(instance.digest()).put(array2).array();
        final byte[] array4 = new byte[256];
        new ff().a(array3, array4);
        if (s != null && s.length() > 0) {
            this.a(s, array4);
        }
        return this.c.a(array4, true);
    }
    
    @Override
    public void a(final int n, final int n2, final int n3) {
        if (this.a != null) {
            this.a.recycle();
        }
        this.a = MotionEvent.obtain(0L, (long)n3, 1, n * this.b.density, n2 * this.b.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }
    
    protected void a(final int n, final long n2) {
        this.d.a(n, n2);
    }
    
    protected void a(final int n, final String s) {
        this.d.a(n, s);
    }
    
    @Override
    public void a(final MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.a != null) {
                this.a.recycle();
            }
            this.a = MotionEvent.obtain(motionEvent);
        }
    }
    
    void a(String substring, final byte[] array) {
        if (substring.length() > 32) {
            substring = substring.substring(0, 32);
        }
        new ko(substring.getBytes("UTF-8")).a(array);
    }
    
    protected abstract void b(final Context p0);
    
    protected abstract void c(final Context p0);
}

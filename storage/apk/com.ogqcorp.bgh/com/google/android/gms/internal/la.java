// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.security.InvalidAlgorithmParameterException;
import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.nio.ByteBuffer;
import java.security.SecureRandom;

public class la
{
    private final ky a;
    private final SecureRandom b;
    
    public la(final ky a, final SecureRandom b) {
        this.a = a;
        this.b = b;
    }
    
    static void a(final byte[] array) {
        for (int i = 0; i < array.length; ++i) {
            array[i] ^= 0x44;
        }
    }
    
    public byte[] a(final String s) {
        byte[] a;
        try {
            a = this.a.a(s, false);
            if (a.length != 32) {
                throw new lb(this);
            }
        }
        catch (IllegalArgumentException ex) {
            throw new lb(this, ex);
        }
        final ByteBuffer wrap = ByteBuffer.wrap(a, 4, 16);
        final byte[] dst = new byte[16];
        wrap.get(dst);
        a(dst);
        return dst;
    }
    
    public byte[] a(final byte[] array, final String s) {
        if (array.length != 16) {
            throw new lb(this);
        }
        try {
            if (this.a.a(s, false).length <= 16) {
                throw new lb(this);
            }
            goto Label_0059;
        }
        catch (NoSuchAlgorithmException ex) {
            throw new lb(this, ex);
        }
        catch (InvalidKeyException ex2) {
            throw new lb(this, ex2);
        }
        catch (IllegalBlockSizeException ex3) {
            throw new lb(this, ex3);
        }
        catch (NoSuchPaddingException ex4) {
            throw new lb(this, ex4);
        }
        catch (BadPaddingException ex5) {
            throw new lb(this, ex5);
        }
        catch (InvalidAlgorithmParameterException ex6) {
            throw new lb(this, ex6);
        }
        catch (IllegalArgumentException ex7) {
            throw new lb(this, ex7);
        }
    }
}

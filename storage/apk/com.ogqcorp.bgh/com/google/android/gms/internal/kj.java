// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.ads.b.b;
import com.google.android.gms.common.f;
import com.google.android.gms.ads.b.a;
import com.google.android.gms.common.e;
import java.io.IOException;
import android.content.Context;

public class kj extends jx
{
    private kj(final Context context, final ky ky, final kz kz) {
        super(context, ky, kz);
    }
    
    public static kj a(final String s, final Context context) {
        final er er = new er();
        jx.a(s, context, er);
        return new kj(context, er, new lc(239));
    }
    
    @Override
    protected void b(final Context context) {
        final long n = 1L;
        super.b(context);
        kl kl = null;
        try {
            final kl e;
            kl = (e = this.e(context));
            final boolean b = e.b();
            if (!b) {
                goto Label_0063;
            }
            final kj kj = this;
            final int n2 = 28;
            final long n3 = n;
            kj.a(n2, n3);
            final kl kl2 = kl;
            final String s = kl2.a();
            final String s3;
            final String s2 = s3 = s;
            if (s3 != null) {
                final kj kj2 = this;
                final int n4 = 30;
                final String s4 = s2;
                kj2.a(n4, s4);
            }
            return;
        }
        catch (IOException ex) {
            this.a(28, 1L);
            return;
        }
        catch (e e2) {}
        try {
            final kl e = kl;
            final boolean b = e.b();
            if (!b) {
                goto Label_0063;
            }
            final kj kj = this;
            final int n2 = 28;
            final long n3 = n;
            kj.a(n2, n3);
            final kl kl2 = kl;
            final String s = kl2.a();
            final String s3;
            final String s2 = s3 = s;
            if (s3 != null) {
                final kj kj2 = this;
                final int n4 = 30;
                final String s4 = s2;
                kj2.a(n4, s4);
            }
        }
        catch (IOException ex2) {}
    }
    
    kl e(final Context context) {
        int i = 0;
        b b = null;
        String a = null;
        Label_0157: {
            byte[] array;
            try {
                b = com.google.android.gms.ads.b.a.b(context);
                a = b.a();
                if (a == null || !a.matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) {
                    break Label_0157;
                }
                array = new byte[16];
                int n = 0;
                while (i < a.length()) {
                    if (i == 8 || i == 13 || i == 18 || i == 23) {
                        ++i;
                    }
                    array[n] = (byte)((Character.digit(a.charAt(i), 16) << 4) + Character.digit(a.charAt(i + 1), 16));
                    ++n;
                    i += 2;
                }
            }
            catch (f cause) {
                throw new IOException(cause);
            }
            final String a2 = this.c.a(array, true);
            return new kl(this, a2, b.b());
        }
        final String a2 = a;
        return new kl(this, a2, b.b());
    }
}

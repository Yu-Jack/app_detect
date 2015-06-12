// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.a;

import org.codehaus.jackson.p;
import org.codehaus.jackson.j;
import org.codehaus.jackson.a;
import org.codehaus.jackson.g.d;
import org.codehaus.jackson.b.g;
import org.codehaus.jackson.l;
import org.codehaus.jackson.k;

public abstract class e extends k
{
    protected e() {
    }
    
    protected e(final int n) {
        super(n);
    }
    
    protected static final String d(final int n) {
        final char c = (char)n;
        if (Character.isISOControl(c)) {
            return "(CTRL-CHAR, code " + n + ")";
        }
        if (n > 255) {
            return "'" + c + "' (code " + n + " / 0x" + Integer.toHexString(n) + ")";
        }
        return "'" + c + "' (code " + n + ")";
    }
    
    protected abstract void J();
    
    protected void T() {
        throw this.a("Unexpected end-of-String in base64 content");
    }
    
    protected void U() {
        this.c(" in " + this.b);
    }
    
    protected void V() {
        this.c(" in a value");
    }
    
    protected final void W() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }
    
    protected char a(final char c) {
        if (!this.a(l.f) && (c != '\'' || !this.a(l.d))) {
            this.d("Unrecognized character escape " + d(c));
            return c;
        }
        return c;
    }
    
    @Override
    public int a(final int n) {
        if (this.b != null) {
            switch (e$1.a[this.b.ordinal()]) {
                case 5:
                case 11: {
                    return this.t();
                }
                case 6: {
                    return 1;
                }
                case 7:
                case 8: {
                    return 0;
                }
                case 10: {
                    return g.a(this.k(), n);
                }
                case 9: {
                    final Object z = this.z();
                    if (z instanceof Number) {
                        return ((Number)z).intValue();
                    }
                    break;
                }
            }
        }
        return n;
    }
    
    @Override
    public long a(final long n) {
        if (this.b != null) {
            switch (e$1.a[this.b.ordinal()]) {
                case 5:
                case 11: {
                    return this.u();
                }
                case 6: {
                    return 1L;
                }
                case 7:
                case 8: {
                    return 0L;
                }
                case 10: {
                    return g.a(this.k(), n);
                }
                case 9: {
                    final Object z = this.z();
                    if (z instanceof Number) {
                        return ((Number)z).longValue();
                    }
                    break;
                }
            }
        }
        return n;
    }
    
    protected final void a(final String s, final Throwable t) {
        throw this.b(s, t);
    }
    
    protected void a(final String s, final d d, final a a) {
        final int length = s.length();
        int i = 0;
    Label_0037:
        while (i < length) {
            int index;
            char char1;
            while (true) {
                index = i + 1;
                char1 = s.charAt(i);
                if (index >= length) {
                    break Label_0037;
                }
                if (char1 > ' ') {
                    break;
                }
                i = index;
            }
            final int b = a.b(char1);
            if (b < 0) {
                this.a(a, char1, 0, null);
            }
            if (index >= length) {
                this.T();
            }
            final int index2 = index + 1;
            final char char2 = s.charAt(index);
            final int b2 = a.b(char2);
            if (b2 < 0) {
                this.a(a, char2, 1, null);
            }
            final int n = b2 | b << 6;
            if (index2 >= length) {
                if (!a.a()) {
                    d.a(n >> 4);
                    return;
                }
                this.T();
            }
            final int n2 = index2 + 1;
            final char char3 = s.charAt(index2);
            final int b3 = a.b(char3);
            if (b3 < 0) {
                if (b3 != -2) {
                    this.a(a, char3, 2, null);
                }
                if (n2 >= length) {
                    this.T();
                }
                i = n2 + 1;
                final char char4 = s.charAt(n2);
                if (!a.a(char4)) {
                    this.a(a, char4, 3, "expected padding character '" + a.b() + "'");
                }
                d.a(n >> 4);
            }
            else {
                final int n3 = b3 | n << 6;
                if (n2 >= length) {
                    if (!a.a()) {
                        d.b(n3 >> 2);
                        return;
                    }
                    this.T();
                }
                i = n2 + 1;
                final char char5 = s.charAt(n2);
                final int b4 = a.b(char5);
                if (b4 < 0) {
                    if (b4 != -2) {
                        this.a(a, char5, 3, null);
                    }
                    d.b(n3 >> 2);
                }
                else {
                    d.c(b4 | n3 << 6);
                }
            }
        }
    }
    
    protected void a(final a a, final char c, final int n, final String str) {
        String str2;
        if (c <= ' ') {
            str2 = "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (n + 1) + " of 4-char base64 unit: can only used between units";
        }
        else if (a.a(c)) {
            str2 = "Unexpected padding character ('" + a.b() + "') as character #" + (n + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        }
        else if (!Character.isDefined(c) || Character.isISOControl(c)) {
            str2 = "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content";
        }
        else {
            str2 = "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
        }
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        throw this.a(str2);
    }
    
    protected final j b(final String s, final Throwable t) {
        return new j(s, this.i(), t);
    }
    
    @Override
    public abstract p b();
    
    protected void b(final int n, final String str) {
        String str2 = "Unexpected character (" + d(n) + ")";
        if (str != null) {
            str2 = str2 + ": " + str;
        }
        this.d(str2);
    }
    
    protected void c(final int n) {
        this.d("Illegal character (" + d((char)n) + "): only regular white space (\\r, \\n, \\t) is allowed between tokens");
    }
    
    protected void c(final int n, final String str) {
        if (!this.a(l.e) || n >= 32) {
            this.d("Illegal unquoted character (" + d((char)n) + "): has to be escaped using backslash to be included in " + str);
        }
    }
    
    protected void c(final String str) {
        this.d("Unexpected end-of-input" + str);
    }
    
    @Override
    public k d() {
        if (this.b != p.b && this.b != p.d) {
            return this;
        }
        int n = 1;
        while (true) {
            final p b = this.b();
            if (b == null) {
                this.J();
                return this;
            }
            switch (e$1.a[b.ordinal()]) {
                default: {
                    continue;
                }
                case 1:
                case 2: {
                    ++n;
                    continue;
                }
                case 3:
                case 4: {
                    if (--n == 0) {
                        return this;
                    }
                    continue;
                }
            }
        }
    }
    
    protected final void d(final String s) {
        throw this.a(s);
    }
    
    @Override
    public abstract String k();
}

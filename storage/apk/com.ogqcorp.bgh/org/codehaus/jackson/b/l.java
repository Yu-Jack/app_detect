// 
// Decompiled by Procyon v0.5.29
// 

package org.codehaus.jackson.b;

import java.io.CharConversionException;
import java.io.InputStream;

public final class l extends a
{
    final boolean g;
    char h;
    int i;
    int j;
    
    public l(final c c, final InputStream inputStream, final byte[] array, final int n, final int n2, final boolean g) {
        super(c, inputStream, array, n, n2);
        this.h = '\0';
        this.i = 0;
        this.j = 0;
        this.g = g;
    }
    
    private void a(final int i, final int j) {
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i + ", needed " + j + ", at char #" + this.i + ", byte #" + (i + this.j) + ")");
    }
    
    private void a(final int i, final int n, final String str) {
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(i) + str + " at char #" + (n + this.i) + ", byte #" + (-1 + (this.j + this.d)) + ")");
    }
    
    private boolean a(final int e) {
        this.j += this.e - e;
        if (e > 0) {
            if (this.d > 0) {
                for (int i = 0; i < e; ++i) {
                    this.c[i] = this.c[i + this.d];
                }
                this.d = 0;
            }
            this.e = e;
        }
        else {
            this.d = 0;
            final int read = this.b.read(this.c);
            if (read < 1) {
                this.e = 0;
                if (read < 0) {
                    this.a();
                    return false;
                }
                this.b();
            }
            this.e = read;
        }
        while (this.e < 4) {
            final int read2 = this.b.read(this.c, this.e, this.c.length - this.e);
            if (read2 < 1) {
                if (read2 < 0) {
                    this.a();
                    this.a(this.e, 4);
                }
                this.b();
            }
            this.e += read2;
        }
        return true;
    }
    
    @Override
    public int read(final char[] array, final int n, int n2) {
        if (this.c == null) {
            n2 = -1;
        }
        else if (n2 >= 1) {
            if (n < 0 || n + n2 > array.length) {
                this.a(array, n, n2);
            }
            final int n3 = n2 + n;
            int i;
            if (this.h != '\0') {
                i = n + 1;
                array[n] = this.h;
                this.h = '\0';
            }
            else {
                final int n4 = this.e - this.d;
                if (n4 < 4 && !this.a(n4)) {
                    return -1;
                }
                i = n;
            }
        Label_0257:
            while (true) {
                while (i < n3) {
                    final int d = this.d;
                    int n5;
                    if (this.g) {
                        n5 = (this.c[d] << 24 | (0xFF & this.c[d + 1]) << 16 | (0xFF & this.c[d + 2]) << 8 | (0xFF & this.c[d + 3]));
                    }
                    else {
                        n5 = ((0xFF & this.c[d]) | (0xFF & this.c[d + 1]) << 8 | (0xFF & this.c[d + 2]) << 16 | this.c[d + 3] << 24);
                    }
                    this.d += 4;
                    int n7;
                    if (n5 > 65535) {
                        if (n5 > 1114111) {
                            this.a(n5, i - n, "(above " + Integer.toHexString(1114111) + ") ");
                        }
                        final int n6 = n5 - 65536;
                        n7 = i + 1;
                        array[i] = (char)(55296 + (n6 >> 10));
                        n5 = (0xDC00 | (n6 & 0x3FF));
                        if (n7 >= n3) {
                            this.h = (char)n5;
                            break Label_0257;
                        }
                    }
                    else {
                        n7 = i;
                    }
                    i = n7 + 1;
                    array[n7] = (char)n5;
                    if (this.d < this.e) {
                        continue;
                    }
                    n7 = i;
                    final int n8 = n7 - n;
                    this.i += n8;
                    return n8;
                }
                int n7 = i;
                continue Label_0257;
            }
        }
        return n2;
    }
}

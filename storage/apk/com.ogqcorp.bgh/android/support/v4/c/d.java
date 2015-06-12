// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.c;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import android.util.Log;
import java.io.Writer;

public class d extends Writer
{
    private final String a;
    private StringBuilder b;
    
    public d(final String a) {
        this.b = new StringBuilder(128);
        this.a = a;
    }
    
    private void a() {
        if (this.b.length() > 0) {
            Log.d(this.a, this.b.toString());
            this.b.delete(0, this.b.length());
        }
    }
    
    @Override
    public void close() {
        this.a();
    }
    
    @Override
    public void flush() {
        this.a();
    }
    
    @Override
    public void write(final char[] array, final int n, final int n2) {
        for (int i = 0; i < n2; ++i) {
            final char c = array[n + i];
            if (c == '\n') {
                this.a();
            }
            else {
                this.b.append(c);
            }
        }
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import java.io.OutputStream;
import org.json.JSONObject;
import java.io.IOException;
import com.facebook.ak;
import java.util.Date;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import com.facebook.bq;
import android.content.Context;
import java.util.concurrent.atomic.AtomicLong;
import java.io.File;
import java.io.FilenameFilter;

final class d
{
    private static final FilenameFilter a;
    private static final FilenameFilter b;
    
    static {
        a = new FilenameFilter() {
            @Override
            public final boolean accept(final File file, final String s) {
                return !s.startsWith("buffer");
            }
        };
        b = new FilenameFilter() {
            @Override
            public final boolean accept(final File file, final String s) {
                return s.startsWith("buffer");
            }
        };
    }
    
    static FilenameFilter a() {
        return d.a;
    }
    
    static void a(final File file) {
        final File[] listFiles = file.listFiles(d.b);
        if (listFiles != null) {
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                listFiles[i].delete();
            }
        }
    }
    
    static File b(final File parent) {
        return new File(parent, "buffer" + Long.valueOf(c.b.incrementAndGet()).toString());
    }
}

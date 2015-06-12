// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import java.util.UUID;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.io.File;
import android.content.Context;

public final class l
{
    private static String a;
    
    static {
        l.a = null;
    }
    
    public static String a(final Context context) {
        synchronized (l.class) {
            Label_0041: {
                if (l.a != null) {
                    break Label_0041;
                }
                final File file = new File(context.getFilesDir(), "INSTALLATION");
                try {
                    if (!file.exists()) {
                        b(file);
                    }
                    l.a = a(file);
                    return l.a;
                }
                catch (Exception ex) {
                    final String a = "ERROR";
                }
            }
        }
    }
    
    private static String a(final File file) {
        final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        final byte[] array = new byte[(int)randomAccessFile.length()];
        randomAccessFile.readFully(array);
        randomAccessFile.close();
        return new String(array);
    }
    
    private static void b(final File file) {
        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(UUID.randomUUID().toString().getBytes());
        fileOutputStream.close();
    }
}

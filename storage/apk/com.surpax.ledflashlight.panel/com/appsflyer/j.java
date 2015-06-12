// 
// Decompiled by Procyon v0.5.29
// 

package com.appsflyer;

import java.io.RandomAccessFile;
import java.util.UUID;
import java.io.FileOutputStream;
import java.io.File;
import android.content.Context;

public final class j
{
    private static String a;
    
    static {
        j.a = null;
    }
    
    public static String a(final Context context) {
        synchronized (j.class) {
            Label_0105: {
                if (j.a != null) {
                    break Label_0105;
                }
                final File file = new File(context.getFilesDir(), "AF_INSTALLATION");
                try {
                    if (!file.exists()) {
                        final FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(UUID.randomUUID().toString().getBytes());
                        fileOutputStream.close();
                    }
                    final RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
                    final byte[] array = new byte[(int)randomAccessFile.length()];
                    randomAccessFile.readFully(array);
                    randomAccessFile.close();
                    j.a = new String(array);
                    return j.a;
                }
                catch (Exception cause) {
                    throw new RuntimeException(cause);
                }
            }
        }
    }
}

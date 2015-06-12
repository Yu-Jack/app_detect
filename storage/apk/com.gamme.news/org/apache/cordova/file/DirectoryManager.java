// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.file;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;

public class DirectoryManager
{
    private static final String LOG_TAG = "DirectoryManager";
    
    private static File constructFilePaths(final String s, final String s2) {
        if (s2.startsWith(s)) {
            return new File(s2);
        }
        return new File(String.valueOf(s) + "/" + s2);
    }
    
    private static long freeSpaceCalculation(final String s) {
        final StatFs statFs = new StatFs(s);
        return statFs.getBlockSize() * statFs.getAvailableBlocks() / 1024L;
    }
    
    public static long getFreeDiskSpace(final boolean b) {
        long n;
        if (Environment.getExternalStorageState().equals("mounted")) {
            n = freeSpaceCalculation(Environment.getExternalStorageDirectory().getPath());
        }
        else {
            if (!b) {
                return -1L;
            }
            n = freeSpaceCalculation("/");
        }
        return n;
    }
    
    public static boolean testFileExists(final String s) {
        return testSaveLocationExists() && !s.equals("") && constructFilePaths(Environment.getExternalStorageDirectory().toString(), s).exists();
    }
    
    public static boolean testSaveLocationExists() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}

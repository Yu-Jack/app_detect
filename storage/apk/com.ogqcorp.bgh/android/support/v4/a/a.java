// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.a;

import android.os.Bundle;
import android.content.Intent;
import android.os.Environment;
import android.os.Build$VERSION;
import android.content.Context;
import java.io.File;

public class a
{
    private static final String DIR_ANDROID = "Android";
    private static final String DIR_CACHE = "cache";
    private static final String DIR_DATA = "data";
    private static final String DIR_FILES = "files";
    private static final String DIR_OBB = "obb";
    
    private static File buildPath(final File file, final String... array) {
        final int length = array.length;
        int i = 0;
        File parent = file;
        while (i < length) {
            final String s = array[i];
            File file2;
            if (parent == null) {
                file2 = new File(s);
            }
            else if (s != null) {
                file2 = new File(parent, s);
            }
            else {
                file2 = parent;
            }
            ++i;
            parent = file2;
        }
        return parent;
    }
    
    public static File[] getExternalCacheDirs(final Context context) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 19) {
            return e.a(context);
        }
        File file;
        if (sdk_INT >= 8) {
            file = b.a(context);
        }
        else {
            file = buildPath(Environment.getExternalStorageDirectory(), "Android", "data", context.getPackageName(), "cache");
        }
        return new File[] { file };
    }
    
    public static File[] getExternalFilesDirs(final Context context, final String s) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 19) {
            return e.a(context, s);
        }
        File file;
        if (sdk_INT >= 8) {
            file = b.a(context, s);
        }
        else {
            file = buildPath(Environment.getExternalStorageDirectory(), "Android", "data", context.getPackageName(), "files", s);
        }
        return new File[] { file };
    }
    
    public static File[] getObbDirs(final Context context) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 19) {
            return e.b(context);
        }
        File file;
        if (sdk_INT >= 11) {
            file = c.a(context);
        }
        else {
            file = buildPath(Environment.getExternalStorageDirectory(), "Android", "obb", context.getPackageName());
        }
        return new File[] { file };
    }
    
    public static boolean startActivities(final Context context, final Intent[] array) {
        return startActivities(context, array, null);
    }
    
    public static boolean startActivities(final Context context, final Intent[] array, final Bundle bundle) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 16) {
            d.a(context, array, bundle);
            return true;
        }
        if (sdk_INT >= 11) {
            c.a(context, array);
            return true;
        }
        return false;
    }
}

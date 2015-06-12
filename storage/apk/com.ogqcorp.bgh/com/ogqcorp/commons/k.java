// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import android.graphics.Matrix;
import org.a.a.a.d;
import java.io.OutputStream;
import java.io.FileOutputStream;
import android.graphics.Bitmap$CompressFormat;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Canvas;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory$Options;
import android.media.ExifInterface;
import java.io.File;

public final class k
{
    public static int a(final File file) {
        try {
            final int attributeInt = new ExifInterface(file.getPath()).getAttributeInt("Orientation", 1);
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt == 3) {
                return 180;
            }
            if (attributeInt == 8) {
                return 270;
            }
        }
        catch (Exception ex) {
            n.b(ex);
        }
        return 0;
    }
    
    public static int a(final File file, final int n, final int n2) {
    Label_0066_Outer:
        while (true) {
            int n3 = 0;
        Label_0066:
            while (true) {
                Label_0146: {
                    try {
                        final BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
                        bitmapFactory$Options.inJustDecodeBounds = true;
                        BitmapFactory.decodeFile(file.getAbsolutePath(), bitmapFactory$Options);
                        final int a = a(file);
                        if (a == 90 || a == 270) {
                            final int outWidth = bitmapFactory$Options.outWidth;
                            bitmapFactory$Options.outWidth = bitmapFactory$Options.outHeight;
                            bitmapFactory$Options.outHeight = outWidth;
                        }
                        break Label_0146;
                        // iftrue(Label_0152:, n2 != -1 && bitmapFactory$Options.outHeight / 2 < n2)
                        while (true) {
                            bitmapFactory$Options.outHeight /= 2;
                            n3 *= 2;
                            break Label_0066;
                            Label_0092: {
                                bitmapFactory$Options.outWidth /= 2;
                            }
                            continue Label_0066_Outer;
                        }
                        while (true) {
                            return n3;
                            continue;
                        }
                    }
                    // iftrue(Label_0092:, n == -1 || bitmapFactory$Options.outWidth / 2 >= n)
                    // iftrue(Label_0144:, n3 >= 1024)
                    catch (Exception ex) {
                        n.c(ex);
                    }
                    return 1;
                }
                n3 = 1;
                continue Label_0066;
            }
            Label_0144: {
                return 1;
            }
            Label_0152:
            return n3;
        }
    }
    
    public static Bitmap a(final Bitmap bitmap, final int n, final int n2, final int n3, final int n4, final Bitmap$Config bitmap$Config) {
        if (!bitmap.isMutable() && n == 0 && n2 == 0 && bitmap.getWidth() == n3 && bitmap.getHeight() == n4) {
            return bitmap;
        }
        final Bitmap bitmap2 = Bitmap.createBitmap(n3, n4, bitmap$Config);
        bitmap2.setDensity(0 + bitmap.getDensity());
        new Canvas(bitmap2).drawBitmap(bitmap, new Rect(n, n2, n + n3, n2 + n4), new Rect(0, 0, n3 + 0, n4 + 0), (Paint)null);
        return bitmap2;
    }
    
    public static Bitmap a(final Bitmap bitmap, final int n, final int n2, final Bitmap$Config bitmap$Config, final boolean b) {
        if (!bitmap.isMutable() && bitmap.getWidth() == n && bitmap.getHeight() == n2) {
            return bitmap;
        }
        final Bitmap bitmap2 = Bitmap.createBitmap(n, n2, bitmap$Config);
        bitmap2.setDensity(0 + bitmap.getDensity());
        final Canvas canvas = new Canvas(bitmap2);
        final Rect rect = new Rect(0, 0, 0 + bitmap.getWidth(), 0 + bitmap.getHeight());
        final Rect rect2 = new Rect(0, 0, n, n2);
        Paint paint;
        if (b) {
            paint = new Paint(2);
        }
        else {
            paint = null;
        }
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return bitmap2;
    }
    
    public static BitmapDrawable a(final File file, final Bitmap$Config bitmap$Config, final int n) {
        if (file != null) {
            final Bitmap b = b(file, bitmap$Config, n);
            if (b != null) {
                return new BitmapDrawable((Resources)null, b);
            }
        }
        return null;
    }
    
    public static void a(final Bitmap bitmap, final File file, final Bitmap$CompressFormat bitmap$CompressFormat, final int n) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            final Bitmap bitmap2 = bitmap;
            final Bitmap$CompressFormat bitmap$CompressFormat2 = bitmap$CompressFormat;
            final int n2 = n;
            final FileOutputStream fileOutputStream2 = fileOutputStream;
            bitmap2.compress(bitmap$CompressFormat2, n2, (OutputStream)fileOutputStream2);
            final FileOutputStream fileOutputStream3 = fileOutputStream;
            fileOutputStream3.flush();
            final FileOutputStream fileOutputStream4 = fileOutputStream;
            fileOutputStream4.close();
            final FileOutputStream fileOutputStream5 = fileOutputStream;
            d.a(fileOutputStream5);
            return;
        }
        finally {
            final Object o2;
            final Object o = o2;
            fileOutputStream = null;
        }
        while (true) {
            try {
                final Bitmap bitmap2 = bitmap;
                final Bitmap$CompressFormat bitmap$CompressFormat2 = bitmap$CompressFormat;
                final int n2 = n;
                final FileOutputStream fileOutputStream2 = fileOutputStream;
                bitmap2.compress(bitmap$CompressFormat2, n2, (OutputStream)fileOutputStream2);
                final FileOutputStream fileOutputStream3 = fileOutputStream;
                fileOutputStream3.flush();
                final FileOutputStream fileOutputStream4 = fileOutputStream;
                fileOutputStream4.close();
                final FileOutputStream fileOutputStream5 = fileOutputStream;
                d.a(fileOutputStream5);
                return;
                d.a(fileOutputStream);
                throw;
            }
            finally {
                continue;
            }
            break;
        }
    }
    
    public static Bitmap b(final File file, final Bitmap$Config inPreferredConfig, final int inSampleSize) {
        final BitmapFactory$Options bitmapFactory$Options = new BitmapFactory$Options();
        if (inPreferredConfig != null) {
            bitmapFactory$Options.inPreferredConfig = inPreferredConfig;
        }
        if (inSampleSize != -1) {
            bitmapFactory$Options.inSampleSize = inSampleSize;
        }
        final Bitmap decodeFile = BitmapFactory.decodeFile(file.getPath(), bitmapFactory$Options);
        final int a = a(file);
        if (a == 0) {
            return decodeFile;
        }
        final Matrix matrix = new Matrix();
        matrix.postRotate((float)a);
        final Bitmap bitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
        decodeFile.recycle();
        return bitmap;
    }
}

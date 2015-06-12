// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.widget.a;

import android.graphics.Matrix;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory$Options;
import android.graphics.Bitmap$CompressFormat;
import android.graphics.Bitmap;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Bitmap$Config;
import android.media.ExifInterface;
import java.io.File;

public final class c
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
            d.b(ex);
        }
        return 0;
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
    
    public static void a(final Bitmap p0, final File p1, final Bitmap$CompressFormat p2, final int p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/io/FileOutputStream;
        //     3: dup            
        //     4: aload_1        
        //     5: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //     8: astore          4
        //    10: aload_0        
        //    11: aload_2        
        //    12: iload_3        
        //    13: aload           4
        //    15: invokevirtual   android/graphics/Bitmap.compress:(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
        //    18: pop            
        //    19: aload           4
        //    21: invokevirtual   java/io/FileOutputStream.flush:()V
        //    24: aload           4
        //    26: invokevirtual   java/io/FileOutputStream.close:()V
        //    29: aload           4
        //    31: invokevirtual   java/io/FileOutputStream.close:()V
        //    34: return         
        //    35: astore          5
        //    37: aconst_null    
        //    38: astore          4
        //    40: aload           4
        //    42: invokevirtual   java/io/FileOutputStream.close:()V
        //    45: aload           5
        //    47: athrow         
        //    48: astore          8
        //    50: return         
        //    51: astore          6
        //    53: goto            45
        //    56: astore          5
        //    58: goto            40
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      10     35     40     Any
        //  10     29     56     61     Any
        //  29     34     48     51     Ljava/lang/Exception;
        //  40     45     51     56     Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0040:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:314)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:235)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:120)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static void a(final BitmapDrawable bitmapDrawable, final File file, final Bitmap$CompressFormat bitmap$CompressFormat, final int n) {
        a(bitmapDrawable.getBitmap(), file, bitmap$CompressFormat, n);
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

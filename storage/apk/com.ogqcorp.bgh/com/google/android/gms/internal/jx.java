// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import android.content.Context;
import java.lang.reflect.Method;

public abstract class jx extends jb
{
    static boolean d;
    private static Method e;
    private static Method f;
    private static Method g;
    private static Method h;
    private static Method i;
    private static Method j;
    private static String k;
    private static long l;
    private static la m;
    
    static {
        jx.l = 0L;
        jx.d = false;
    }
    
    protected jx(final Context context, final ky ky, final kz kz) {
        super(context, ky, kz);
    }
    
    static String a() {
        if (jx.k == null) {
            throw new jz();
        }
        return jx.k;
    }
    
    static String a(final Context context, final ky ky) {
        if (jx.g == null) {
            throw new jz();
        }
        try {
            if (jx.g.invoke(null, context) == null) {
                throw new jz();
            }
            goto Label_0057;
        }
        catch (IllegalAccessException ex) {
            throw new jz(ex);
        }
        catch (InvocationTargetException ex2) {
            throw new jz(ex2);
        }
    }
    
    static ArrayList<Long> a(final MotionEvent motionEvent, final DisplayMetrics displayMetrics) {
        if (jx.h == null || motionEvent == null) {
            throw new jz();
        }
        try {
            return (ArrayList<Long>)jx.h.invoke(null, motionEvent, displayMetrics);
        }
        catch (IllegalAccessException ex) {
            throw new jz(ex);
        }
        catch (InvocationTargetException ex2) {
            throw new jz(ex2);
        }
    }
    
    protected static void a(final String p0, final Context p1, final ky p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: ldc             Lcom/google/android/gms/internal/jx;.class
        //     2: monitorenter   
        //     3: getstatic       com/google/android/gms/internal/jx.d:Z
        //     6: istore          4
        //     8: iload           4
        //    10: ifne            46
        //    13: new             Lcom/google/android/gms/internal/la;
        //    16: dup            
        //    17: aload_2        
        //    18: aconst_null    
        //    19: invokespecial   com/google/android/gms/internal/la.<init>:(Lcom/google/android/gms/internal/ky;Ljava/security/SecureRandom;)V
        //    22: putstatic       com/google/android/gms/internal/jx.m:Lcom/google/android/gms/internal/la;
        //    25: aload_0        
        //    26: putstatic       com/google/android/gms/internal/jx.k:Ljava/lang/String;
        //    29: aload_1        
        //    30: invokestatic    com/google/android/gms/internal/jx.e:(Landroid/content/Context;)V
        //    33: invokestatic    com/google/android/gms/internal/jx.b:()Ljava/lang/Long;
        //    36: invokevirtual   java/lang/Long.longValue:()J
        //    39: putstatic       com/google/android/gms/internal/jx.l:J
        //    42: iconst_1       
        //    43: putstatic       com/google/android/gms/internal/jx.d:Z
        //    46: ldc             Lcom/google/android/gms/internal/jx;.class
        //    48: monitorexit    
        //    49: return         
        //    50: astore_3       
        //    51: ldc             Lcom/google/android/gms/internal/jx;.class
        //    53: monitorexit    
        //    54: aload_3        
        //    55: athrow         
        //    56: astore          6
        //    58: goto            46
        //    61: astore          5
        //    63: goto            46
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                     
        //  -----  -----  -----  -----  -----------------------------------------
        //  3      8      50     56     Any
        //  13     46     61     66     Lcom/google/android/gms/internal/jz;
        //  13     46     56     61     Ljava/lang/UnsupportedOperationException;
        //  13     46     50     56     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0046:
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
    
    static Long b() {
        if (jx.e == null) {
            throw new jz();
        }
        try {
            return (Long)jx.e.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException ex) {
            throw new jz(ex);
        }
        catch (InvocationTargetException ex2) {
            throw new jz(ex2);
        }
    }
    
    static String b(final Context context, final ky ky) {
        if (jx.j == null) {
            throw new jz();
        }
        try {
            if (jx.j.invoke(null, context) == null) {
                throw new jz();
            }
            goto Label_0057;
        }
        catch (IllegalAccessException ex) {
            throw new jz(ex);
        }
        catch (InvocationTargetException ex2) {
            throw new jz(ex2);
        }
    }
    
    private static String b(final byte[] array, final String s) {
        try {
            return new String(jx.m.a(array, s), "UTF-8");
        }
        catch (lb lb) {
            throw new jz(lb);
        }
        catch (UnsupportedEncodingException ex) {
            throw new jz(ex);
        }
    }
    
    static String c() {
        if (jx.f == null) {
            throw new jz();
        }
        try {
            return (String)jx.f.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException ex) {
            throw new jz(ex);
        }
        catch (InvocationTargetException ex2) {
            throw new jz(ex2);
        }
    }
    
    static String d(final Context context) {
        if (jx.i == null) {
            throw new jz();
        }
        String s;
        try {
            s = (String)jx.i.invoke(null, context);
            if (s == null) {
                throw new jz();
            }
        }
        catch (IllegalAccessException ex) {
            throw new jz(ex);
        }
        catch (InvocationTargetException ex2) {
            throw new jz(ex2);
        }
        return s;
    }
    
    private static void e(final Context context) {
        try {
            jx.m.a(jx.m.a(ld.a()), ld.b());
            File file = context.getCacheDir();
            if (file != null) {
                goto Label_0069;
            }
            file = context.getDir("dex", 0);
            if (file == null) {
                throw new jz();
            }
            goto Label_0069;
        }
        catch (FileNotFoundException ex) {
            throw new jz(ex);
        }
        catch (IOException ex2) {
            throw new jz(ex2);
        }
        catch (ClassNotFoundException ex3) {
            throw new jz(ex3);
        }
        catch (lb lb) {
            throw new jz(lb);
        }
        catch (NoSuchMethodException ex4) {
            throw new jz(ex4);
        }
        catch (NullPointerException ex5) {
            throw new jz(ex5);
        }
    }
    
    @Override
    protected void b(final Context p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: iconst_1       
        //     2: invokestatic    com/google/android/gms/internal/jx.c:()Ljava/lang/String;
        //     5: invokevirtual   com/google/android/gms/internal/jx.a:(ILjava/lang/String;)V
        //     8: aload_0        
        //     9: iconst_2       
        //    10: invokestatic    com/google/android/gms/internal/jx.a:()Ljava/lang/String;
        //    13: invokevirtual   com/google/android/gms/internal/jx.a:(ILjava/lang/String;)V
        //    16: aload_0        
        //    17: bipush          25
        //    19: invokestatic    com/google/android/gms/internal/jx.b:()Ljava/lang/Long;
        //    22: invokevirtual   java/lang/Long.longValue:()J
        //    25: invokevirtual   com/google/android/gms/internal/jx.a:(IJ)V
        //    28: aload_0        
        //    29: bipush          24
        //    31: aload_1        
        //    32: invokestatic    com/google/android/gms/internal/jx.d:(Landroid/content/Context;)Ljava/lang/String;
        //    35: invokevirtual   com/google/android/gms/internal/jx.a:(ILjava/lang/String;)V
        //    38: return         
        //    39: astore          6
        //    41: return         
        //    42: astore          5
        //    44: return         
        //    45: astore          4
        //    47: goto            28
        //    50: astore_3       
        //    51: goto            16
        //    54: astore_2       
        //    55: goto            8
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  0      8      54     58     Lcom/google/android/gms/internal/jz;
        //  0      8      39     42     Ljava/io/IOException;
        //  8      16     50     54     Lcom/google/android/gms/internal/jz;
        //  8      16     39     42     Ljava/io/IOException;
        //  16     28     45     50     Lcom/google/android/gms/internal/jz;
        //  16     28     39     42     Ljava/io/IOException;
        //  28     38     42     45     Lcom/google/android/gms/internal/jz;
        //  28     38     39     42     Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0008:
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
    
    @Override
    protected void c(final Context p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: iconst_2       
        //     2: invokestatic    com/google/android/gms/internal/jx.a:()Ljava/lang/String;
        //     5: invokevirtual   com/google/android/gms/internal/jx.a:(ILjava/lang/String;)V
        //     8: aload_0        
        //     9: iconst_1       
        //    10: invokestatic    com/google/android/gms/internal/jx.c:()Ljava/lang/String;
        //    13: invokevirtual   com/google/android/gms/internal/jx.a:(ILjava/lang/String;)V
        //    16: invokestatic    com/google/android/gms/internal/jx.b:()Ljava/lang/Long;
        //    19: invokevirtual   java/lang/Long.longValue:()J
        //    22: lstore          10
        //    24: aload_0        
        //    25: bipush          25
        //    27: lload           10
        //    29: invokevirtual   com/google/android/gms/internal/jx.a:(IJ)V
        //    32: getstatic       com/google/android/gms/internal/jx.l:J
        //    35: lconst_0       
        //    36: lcmp           
        //    37: ifeq            61
        //    40: aload_0        
        //    41: bipush          17
        //    43: lload           10
        //    45: getstatic       com/google/android/gms/internal/jx.l:J
        //    48: lsub           
        //    49: invokevirtual   com/google/android/gms/internal/jx.a:(IJ)V
        //    52: aload_0        
        //    53: bipush          23
        //    55: getstatic       com/google/android/gms/internal/jx.l:J
        //    58: invokevirtual   com/google/android/gms/internal/jx.a:(IJ)V
        //    61: aload_0        
        //    62: getfield        com/google/android/gms/internal/jx.a:Landroid/view/MotionEvent;
        //    65: aload_0        
        //    66: getfield        com/google/android/gms/internal/jx.b:Landroid/util/DisplayMetrics;
        //    69: invokestatic    com/google/android/gms/internal/jx.a:(Landroid/view/MotionEvent;Landroid/util/DisplayMetrics;)Ljava/util/ArrayList;
        //    72: astore          9
        //    74: aload_0        
        //    75: bipush          14
        //    77: aload           9
        //    79: iconst_0       
        //    80: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //    83: checkcast       Ljava/lang/Long;
        //    86: invokevirtual   java/lang/Long.longValue:()J
        //    89: invokevirtual   com/google/android/gms/internal/jx.a:(IJ)V
        //    92: aload_0        
        //    93: bipush          15
        //    95: aload           9
        //    97: iconst_1       
        //    98: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //   101: checkcast       Ljava/lang/Long;
        //   104: invokevirtual   java/lang/Long.longValue:()J
        //   107: invokevirtual   com/google/android/gms/internal/jx.a:(IJ)V
        //   110: aload           9
        //   112: invokevirtual   java/util/ArrayList.size:()I
        //   115: iconst_3       
        //   116: if_icmplt       137
        //   119: aload_0        
        //   120: bipush          16
        //   122: aload           9
        //   124: iconst_2       
        //   125: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //   128: checkcast       Ljava/lang/Long;
        //   131: invokevirtual   java/lang/Long.longValue:()J
        //   134: invokevirtual   com/google/android/gms/internal/jx.a:(IJ)V
        //   137: aload_0        
        //   138: bipush          27
        //   140: aload_1        
        //   141: aload_0        
        //   142: getfield        com/google/android/gms/internal/jx.c:Lcom/google/android/gms/internal/ky;
        //   145: invokestatic    com/google/android/gms/internal/jx.a:(Landroid/content/Context;Lcom/google/android/gms/internal/ky;)Ljava/lang/String;
        //   148: invokevirtual   com/google/android/gms/internal/jx.a:(ILjava/lang/String;)V
        //   151: aload_0        
        //   152: bipush          29
        //   154: aload_1        
        //   155: aload_0        
        //   156: getfield        com/google/android/gms/internal/jx.c:Lcom/google/android/gms/internal/ky;
        //   159: invokestatic    com/google/android/gms/internal/jx.b:(Landroid/content/Context;Lcom/google/android/gms/internal/ky;)Ljava/lang/String;
        //   162: invokevirtual   com/google/android/gms/internal/jx.a:(ILjava/lang/String;)V
        //   165: return         
        //   166: astore          8
        //   168: return         
        //   169: astore          7
        //   171: return         
        //   172: astore          6
        //   174: goto            151
        //   177: astore          5
        //   179: goto            137
        //   182: astore          4
        //   184: goto            61
        //   187: astore_3       
        //   188: goto            16
        //   191: astore_2       
        //   192: goto            8
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  0      8      191    195    Lcom/google/android/gms/internal/jz;
        //  0      8      166    169    Ljava/io/IOException;
        //  8      16     187    191    Lcom/google/android/gms/internal/jz;
        //  8      16     166    169    Ljava/io/IOException;
        //  16     61     182    187    Lcom/google/android/gms/internal/jz;
        //  16     61     166    169    Ljava/io/IOException;
        //  61     137    177    182    Lcom/google/android/gms/internal/jz;
        //  61     137    166    169    Ljava/io/IOException;
        //  137    151    172    177    Lcom/google/android/gms/internal/jz;
        //  137    151    166    169    Ljava/io/IOException;
        //  151    165    169    172    Lcom/google/android/gms/internal/jz;
        //  151    165    166    169    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0008:
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
}

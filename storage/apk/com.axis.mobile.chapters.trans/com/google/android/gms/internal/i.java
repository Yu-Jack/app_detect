// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.io.File;
import dalvik.system.DexClassLoader;
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

public abstract class i extends h
{
    private static Method jS;
    private static Method jT;
    private static Method jU;
    private static Method jV;
    private static Method jW;
    private static Method jX;
    private static Method jY;
    private static Method jZ;
    private static String ka;
    private static o kb;
    static boolean kc;
    private static long startTime;
    
    static {
        i.startTime = 0L;
        i.kc = false;
    }
    
    protected i(final Context context, final m m, final n n) {
        super(context, m, n);
    }
    
    static String a(final Context context, final m m) {
        if (i.jV == null) {
            throw new i$a();
        }
        try {
            if (i.jV.invoke(null, context) == null) {
                throw new i$a();
            }
            goto Label_0057;
        }
        catch (IllegalAccessException ex) {
            throw new i$a(ex);
        }
        catch (InvocationTargetException ex2) {
            throw new i$a(ex2);
        }
    }
    
    static ArrayList a(final MotionEvent motionEvent, final DisplayMetrics displayMetrics) {
        if (i.jW == null || motionEvent == null) {
            throw new i$a();
        }
        try {
            return (ArrayList)i.jW.invoke(null, motionEvent, displayMetrics);
        }
        catch (IllegalAccessException ex) {
            throw new i$a(ex);
        }
        catch (InvocationTargetException ex2) {
            throw new i$a(ex2);
        }
    }
    
    protected static void a(final String p0, final Context p1, final m p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: ldc             Lcom/google/android/gms/internal/i;.class
        //     2: monitorenter   
        //     3: getstatic       com/google/android/gms/internal/i.kc:Z
        //     6: istore          4
        //     8: iload           4
        //    10: ifne            46
        //    13: new             Lcom/google/android/gms/internal/o;
        //    16: dup            
        //    17: aload_2        
        //    18: aconst_null    
        //    19: invokespecial   com/google/android/gms/internal/o.<init>:(Lcom/google/android/gms/internal/m;Ljava/security/SecureRandom;)V
        //    22: putstatic       com/google/android/gms/internal/i.kb:Lcom/google/android/gms/internal/o;
        //    25: aload_0        
        //    26: putstatic       com/google/android/gms/internal/i.ka:Ljava/lang/String;
        //    29: aload_1        
        //    30: invokestatic    com/google/android/gms/internal/i.h:(Landroid/content/Context;)V
        //    33: invokestatic    com/google/android/gms/internal/i.w:()Ljava/lang/Long;
        //    36: invokevirtual   java/lang/Long.longValue:()J
        //    39: putstatic       com/google/android/gms/internal/i.startTime:J
        //    42: iconst_1       
        //    43: putstatic       com/google/android/gms/internal/i.kc:Z
        //    46: ldc             Lcom/google/android/gms/internal/i;.class
        //    48: monitorexit    
        //    49: return         
        //    50: astore_3       
        //    51: ldc             Lcom/google/android/gms/internal/i;.class
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
        //  13     46     61     66     Lcom/google/android/gms/internal/i$a;
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
    
    static String b(final Context context, final m m) {
        if (i.jY == null) {
            throw new i$a();
        }
        try {
            if (i.jY.invoke(null, context) == null) {
                throw new i$a();
            }
            goto Label_0057;
        }
        catch (IllegalAccessException ex) {
            throw new i$a(ex);
        }
        catch (InvocationTargetException ex2) {
            throw new i$a(ex2);
        }
    }
    
    private static String b(final byte[] array, final String s) {
        try {
            return new String(i.kb.c(array, s), "UTF-8");
        }
        catch (o$a o$a) {
            throw new i$a(o$a);
        }
        catch (UnsupportedEncodingException ex) {
            throw new i$a(ex);
        }
    }
    
    static String f(final Context context) {
        if (i.jX == null) {
            throw new i$a();
        }
        String s;
        try {
            s = (String)i.jX.invoke(null, context);
            if (s == null) {
                throw new i$a();
            }
        }
        catch (IllegalAccessException ex) {
            throw new i$a(ex);
        }
        catch (InvocationTargetException ex2) {
            throw new i$a(ex2);
        }
        return s;
    }
    
    static ArrayList g(final Context context) {
        if (i.jZ == null) {
            throw new i$a();
        }
        ArrayList list;
        try {
            list = (ArrayList)i.jZ.invoke(null, context);
            if (list == null || list.size() != 2) {
                throw new i$a();
            }
        }
        catch (IllegalAccessException ex) {
            throw new i$a(ex);
        }
        catch (InvocationTargetException ex2) {
            throw new i$a(ex2);
        }
        return list;
    }
    
    private static void h(final Context context) {
        byte[] b;
        try {
            b = i.kb.b(q.getKey());
            i.kb.c(b, q.B());
            File file = context.getCacheDir();
            if (file != null) {
                goto Label_0069;
            }
            file = context.getDir("dex", 0);
            if (file == null) {
                throw new i$a();
            }
            goto Label_0069;
        }
        catch (FileNotFoundException ex) {
            throw new i$a(ex);
        }
        catch (IOException ex2) {
            throw new i$a(ex2);
        }
        catch (ClassNotFoundException ex3) {
            throw new i$a(ex3);
        }
        catch (o$a o$a) {
            throw new i$a(o$a);
        }
        catch (NoSuchMethodException ex4) {
            throw new i$a(ex4);
        }
        catch (NullPointerException ex5) {
            throw new i$a(ex5);
        }
        try {
            final File file2;
            final File file3;
            final DexClassLoader dexClassLoader = new DexClassLoader(file2.getAbsolutePath(), file3.getAbsolutePath(), (String)null, context.getClassLoader());
            final Class loadClass = dexClassLoader.loadClass(b(b, q.C()));
            final Class loadClass2 = dexClassLoader.loadClass(b(b, q.O()));
            final Class loadClass3 = dexClassLoader.loadClass(b(b, q.I()));
            final Class loadClass4 = dexClassLoader.loadClass(b(b, q.G()));
            final Class loadClass5 = dexClassLoader.loadClass(b(b, q.Q()));
            final Class loadClass6 = dexClassLoader.loadClass(b(b, q.E()));
            final Class loadClass7 = dexClassLoader.loadClass(b(b, q.M()));
            final Class loadClass8 = dexClassLoader.loadClass(b(b, q.K()));
            i.jS = loadClass.getMethod(b(b, q.D()), (Class[])new Class[0]);
            i.jT = loadClass2.getMethod(b(b, q.P()), (Class[])new Class[0]);
            i.jU = loadClass3.getMethod(b(b, q.J()), (Class[])new Class[0]);
            i.jV = loadClass4.getMethod(b(b, q.H()), Context.class);
            i.jW = loadClass5.getMethod(b(b, q.R()), MotionEvent.class, DisplayMetrics.class);
            i.jX = loadClass6.getMethod(b(b, q.F()), Context.class);
            i.jY = loadClass7.getMethod(b(b, q.N()), Context.class);
            i.jZ = loadClass8.getMethod(b(b, q.L()), Context.class);
        }
        finally {}
    }
    
    static String v() {
        if (i.ka == null) {
            throw new i$a();
        }
        return i.ka;
    }
    
    static Long w() {
        if (i.jS == null) {
            throw new i$a();
        }
        try {
            return (Long)i.jS.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException ex) {
            throw new i$a(ex);
        }
        catch (InvocationTargetException ex2) {
            throw new i$a(ex2);
        }
    }
    
    static String x() {
        if (i.jU == null) {
            throw new i$a();
        }
        try {
            return (String)i.jU.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException ex) {
            throw new i$a(ex);
        }
        catch (InvocationTargetException ex2) {
            throw new i$a(ex2);
        }
    }
    
    static Long y() {
        if (i.jT == null) {
            throw new i$a();
        }
        try {
            return (Long)i.jT.invoke(null, new Object[0]);
        }
        catch (IllegalAccessException ex) {
            throw new i$a(ex);
        }
        catch (InvocationTargetException ex2) {
            throw new i$a(ex2);
        }
    }
    
    @Override
    protected void c(final Context p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: iconst_1       
        //     2: invokestatic    com/google/android/gms/internal/i.x:()Ljava/lang/String;
        //     5: invokevirtual   com/google/android/gms/internal/i.a:(ILjava/lang/String;)V
        //     8: aload_0        
        //     9: iconst_2       
        //    10: invokestatic    com/google/android/gms/internal/i.v:()Ljava/lang/String;
        //    13: invokevirtual   com/google/android/gms/internal/i.a:(ILjava/lang/String;)V
        //    16: aload_0        
        //    17: bipush          25
        //    19: invokestatic    com/google/android/gms/internal/i.w:()Ljava/lang/Long;
        //    22: invokevirtual   java/lang/Long.longValue:()J
        //    25: invokevirtual   com/google/android/gms/internal/i.a:(IJ)V
        //    28: aload_1        
        //    29: invokestatic    com/google/android/gms/internal/i.g:(Landroid/content/Context;)Ljava/util/ArrayList;
        //    32: astore          8
        //    34: aload_0        
        //    35: bipush          31
        //    37: aload           8
        //    39: iconst_0       
        //    40: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //    43: checkcast       Ljava/lang/Long;
        //    46: invokevirtual   java/lang/Long.longValue:()J
        //    49: invokevirtual   com/google/android/gms/internal/i.a:(IJ)V
        //    52: aload_0        
        //    53: bipush          32
        //    55: aload           8
        //    57: iconst_1       
        //    58: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //    61: checkcast       Ljava/lang/Long;
        //    64: invokevirtual   java/lang/Long.longValue:()J
        //    67: invokevirtual   com/google/android/gms/internal/i.a:(IJ)V
        //    70: aload_0        
        //    71: bipush          33
        //    73: invokestatic    com/google/android/gms/internal/i.y:()Ljava/lang/Long;
        //    76: invokevirtual   java/lang/Long.longValue:()J
        //    79: invokevirtual   com/google/android/gms/internal/i.a:(IJ)V
        //    82: return         
        //    83: astore          7
        //    85: return         
        //    86: astore          6
        //    88: return         
        //    89: astore          5
        //    91: goto            70
        //    94: astore          4
        //    96: goto            28
        //    99: astore_3       
        //   100: goto            16
        //   103: astore_2       
        //   104: goto            8
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                 
        //  -----  -----  -----  -----  -------------------------------------
        //  0      8      103    107    Lcom/google/android/gms/internal/i$a;
        //  0      8      83     86     Ljava/io/IOException;
        //  8      16     99     103    Lcom/google/android/gms/internal/i$a;
        //  8      16     83     86     Ljava/io/IOException;
        //  16     28     94     99     Lcom/google/android/gms/internal/i$a;
        //  16     28     83     86     Ljava/io/IOException;
        //  28     70     89     94     Lcom/google/android/gms/internal/i$a;
        //  28     70     83     86     Ljava/io/IOException;
        //  70     82     86     89     Lcom/google/android/gms/internal/i$a;
        //  70     82     83     86     Ljava/io/IOException;
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
    protected void e(final Context p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: iconst_2       
        //     2: invokestatic    com/google/android/gms/internal/i.v:()Ljava/lang/String;
        //     5: invokevirtual   com/google/android/gms/internal/i.a:(ILjava/lang/String;)V
        //     8: aload_0        
        //     9: iconst_1       
        //    10: invokestatic    com/google/android/gms/internal/i.x:()Ljava/lang/String;
        //    13: invokevirtual   com/google/android/gms/internal/i.a:(ILjava/lang/String;)V
        //    16: invokestatic    com/google/android/gms/internal/i.w:()Ljava/lang/Long;
        //    19: invokevirtual   java/lang/Long.longValue:()J
        //    22: lstore          10
        //    24: aload_0        
        //    25: bipush          25
        //    27: lload           10
        //    29: invokevirtual   com/google/android/gms/internal/i.a:(IJ)V
        //    32: getstatic       com/google/android/gms/internal/i.startTime:J
        //    35: lconst_0       
        //    36: lcmp           
        //    37: ifeq            61
        //    40: aload_0        
        //    41: bipush          17
        //    43: lload           10
        //    45: getstatic       com/google/android/gms/internal/i.startTime:J
        //    48: lsub           
        //    49: invokevirtual   com/google/android/gms/internal/i.a:(IJ)V
        //    52: aload_0        
        //    53: bipush          23
        //    55: getstatic       com/google/android/gms/internal/i.startTime:J
        //    58: invokevirtual   com/google/android/gms/internal/i.a:(IJ)V
        //    61: aload_0        
        //    62: getfield        com/google/android/gms/internal/i.jO:Landroid/view/MotionEvent;
        //    65: aload_0        
        //    66: getfield        com/google/android/gms/internal/i.jP:Landroid/util/DisplayMetrics;
        //    69: invokestatic    com/google/android/gms/internal/i.a:(Landroid/view/MotionEvent;Landroid/util/DisplayMetrics;)Ljava/util/ArrayList;
        //    72: astore          9
        //    74: aload_0        
        //    75: bipush          14
        //    77: aload           9
        //    79: iconst_0       
        //    80: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //    83: checkcast       Ljava/lang/Long;
        //    86: invokevirtual   java/lang/Long.longValue:()J
        //    89: invokevirtual   com/google/android/gms/internal/i.a:(IJ)V
        //    92: aload_0        
        //    93: bipush          15
        //    95: aload           9
        //    97: iconst_1       
        //    98: invokevirtual   java/util/ArrayList.get:(I)Ljava/lang/Object;
        //   101: checkcast       Ljava/lang/Long;
        //   104: invokevirtual   java/lang/Long.longValue:()J
        //   107: invokevirtual   com/google/android/gms/internal/i.a:(IJ)V
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
        //   134: invokevirtual   com/google/android/gms/internal/i.a:(IJ)V
        //   137: aload_0        
        //   138: bipush          27
        //   140: aload_1        
        //   141: aload_0        
        //   142: getfield        com/google/android/gms/internal/i.jQ:Lcom/google/android/gms/internal/m;
        //   145: invokestatic    com/google/android/gms/internal/i.a:(Landroid/content/Context;Lcom/google/android/gms/internal/m;)Ljava/lang/String;
        //   148: invokevirtual   com/google/android/gms/internal/i.a:(ILjava/lang/String;)V
        //   151: aload_0        
        //   152: bipush          29
        //   154: aload_1        
        //   155: aload_0        
        //   156: getfield        com/google/android/gms/internal/i.jQ:Lcom/google/android/gms/internal/m;
        //   159: invokestatic    com/google/android/gms/internal/i.b:(Landroid/content/Context;Lcom/google/android/gms/internal/m;)Ljava/lang/String;
        //   162: invokevirtual   com/google/android/gms/internal/i.a:(ILjava/lang/String;)V
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
        //  -----  -----  -----  -----  -------------------------------------
        //  0      8      191    195    Lcom/google/android/gms/internal/i$a;
        //  0      8      166    169    Ljava/io/IOException;
        //  8      16     187    191    Lcom/google/android/gms/internal/i$a;
        //  8      16     166    169    Ljava/io/IOException;
        //  16     61     182    187    Lcom/google/android/gms/internal/i$a;
        //  16     61     166    169    Ljava/io/IOException;
        //  61     137    177    182    Lcom/google/android/gms/internal/i$a;
        //  61     137    166    169    Ljava/io/IOException;
        //  137    151    172    177    Lcom/google/android/gms/internal/i$a;
        //  137    151    166    169    Ljava/io/IOException;
        //  151    165    169    172    Lcom/google/android/gms/internal/i$a;
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

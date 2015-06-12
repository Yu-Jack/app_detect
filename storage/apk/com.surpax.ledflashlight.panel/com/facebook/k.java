// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import android.content.Context;

final class k
{
    private static Object a;
    private Context b;
    private HashMap c;
    
    static {
        k.a = new Object();
    }
    
    private k(final Context b) {
        this.c = new HashMap();
        this.b = b;
    }
    
    public static k a(final Context p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: getstatic       com/facebook/k.a:Ljava/lang/Object;
        //     3: astore_1       
        //     4: aload_1        
        //     5: monitorenter   
        //     6: new             Lcom/facebook/k;
        //     9: dup            
        //    10: aload_0        
        //    11: invokespecial   com/facebook/k.<init>:(Landroid/content/Context;)V
        //    14: astore_2       
        //    15: new             Ljava/io/ObjectInputStream;
        //    18: dup            
        //    19: new             Ljava/io/BufferedInputStream;
        //    22: dup            
        //    23: aload_2        
        //    24: getfield        com/facebook/k.b:Landroid/content/Context;
        //    27: ldc             "AppEventsLogger.persistedevents"
        //    29: invokevirtual   android/content/Context.openFileInput:(Ljava/lang/String;)Ljava/io/FileInputStream;
        //    32: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //    35: invokespecial   java/io/ObjectInputStream.<init>:(Ljava/io/InputStream;)V
        //    38: astore_3       
        //    39: aload_3        
        //    40: invokevirtual   java/io/ObjectInputStream.readObject:()Ljava/lang/Object;
        //    43: checkcast       Ljava/util/HashMap;
        //    46: astore          10
        //    48: aload_2        
        //    49: getfield        com/facebook/k.b:Landroid/content/Context;
        //    52: ldc             "AppEventsLogger.persistedevents"
        //    54: invokevirtual   android/content/Context.getFileStreamPath:(Ljava/lang/String;)Ljava/io/File;
        //    57: invokevirtual   java/io/File.delete:()Z
        //    60: pop            
        //    61: aload_2        
        //    62: aload           10
        //    64: putfield        com/facebook/k.c:Ljava/util/HashMap;
        //    67: aload_3        
        //    68: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //    71: aload_1        
        //    72: monitorexit    
        //    73: aload_2        
        //    74: areturn        
        //    75: aload           5
        //    77: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //    80: goto            71
        //    83: astore          6
        //    85: aload_1        
        //    86: monitorexit    
        //    87: aload           6
        //    89: athrow         
        //    90: astore          13
        //    92: aconst_null    
        //    93: astore_3       
        //    94: aload           13
        //    96: astore          7
        //    98: invokestatic    com/facebook/d.d:()Ljava/lang/String;
        //   101: new             Ljava/lang/StringBuilder;
        //   104: dup            
        //   105: ldc             "Got unexpected exception: "
        //   107: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   110: aload           7
        //   112: invokevirtual   java/lang/Exception.toString:()Ljava/lang/String;
        //   115: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   118: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   121: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   124: pop            
        //   125: aload_3        
        //   126: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   129: goto            71
        //   132: aload_3        
        //   133: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   136: aload           8
        //   138: athrow         
        //   139: astore          8
        //   141: goto            132
        //   144: astore          7
        //   146: goto            98
        //   149: astore          4
        //   151: aload_3        
        //   152: astore          5
        //   154: goto            75
        //   157: astore          14
        //   159: aconst_null    
        //   160: astore          5
        //   162: goto            75
        //   165: astore          12
        //   167: aload           12
        //   169: astore          8
        //   171: aconst_null    
        //   172: astore_3       
        //   173: goto            132
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                           
        //  -----  -----  -----  -----  -------------------------------
        //  6      15     83     90     Any
        //  15     39     157    165    Ljava/io/FileNotFoundException;
        //  15     39     90     98     Ljava/lang/Exception;
        //  15     39     165    176    Any
        //  39     67     149    157    Ljava/io/FileNotFoundException;
        //  39     67     144    149    Ljava/lang/Exception;
        //  39     67     139    144    Any
        //  67     71     83     90     Any
        //  71     73     83     90     Any
        //  75     80     83     90     Any
        //  98     125    139    144    Any
        //  125    129    83     90     Any
        //  132    139    83     90     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 88, Size: 88
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3305)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:114)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
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
    
    public static void a(final Context context, final e e, final l l) {
        final HashMap<e, l> hashMap = new HashMap<e, l>();
        hashMap.put(e, l);
        a(context, hashMap);
    }
    
    private static void a(final Context p0, final Map p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: getstatic       com/facebook/k.a:Ljava/lang/Object;
        //     3: astore_2       
        //     4: aload_2        
        //     5: monitorenter   
        //     6: aload_0        
        //     7: invokestatic    com/facebook/k.a:(Landroid/content/Context;)Lcom/facebook/k;
        //    10: astore          4
        //    12: aload_1        
        //    13: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //    18: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //    23: astore          5
        //    25: aload           5
        //    27: invokeinterface java/util/Iterator.hasNext:()Z
        //    32: istore          6
        //    34: iload           6
        //    36: ifne            84
        //    39: new             Ljava/io/ObjectOutputStream;
        //    42: dup            
        //    43: new             Ljava/io/BufferedOutputStream;
        //    46: dup            
        //    47: aload           4
        //    49: getfield        com/facebook/k.b:Landroid/content/Context;
        //    52: ldc             "AppEventsLogger.persistedevents"
        //    54: iconst_0       
        //    55: invokevirtual   android/content/Context.openFileOutput:(Ljava/lang/String;I)Ljava/io/FileOutputStream;
        //    58: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    61: invokespecial   java/io/ObjectOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    64: astore          12
        //    66: aload           12
        //    68: aload           4
        //    70: getfield        com/facebook/k.c:Ljava/util/HashMap;
        //    73: invokevirtual   java/io/ObjectOutputStream.writeObject:(Ljava/lang/Object;)V
        //    76: aload           12
        //    78: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //    81: aload_2        
        //    82: monitorexit    
        //    83: return         
        //    84: aload           5
        //    86: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    91: checkcast       Ljava/util/Map$Entry;
        //    94: astore          7
        //    96: aload           7
        //    98: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   103: checkcast       Lcom/facebook/l;
        //   106: invokevirtual   com/facebook/l.b:()Ljava/util/List;
        //   109: astore          8
        //   111: aload           8
        //   113: invokeinterface java/util/List.size:()I
        //   118: ifeq            25
        //   121: aload           7
        //   123: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   128: checkcast       Lcom/facebook/e;
        //   131: astore          9
        //   133: aload           4
        //   135: getfield        com/facebook/k.c:Ljava/util/HashMap;
        //   138: aload           9
        //   140: invokevirtual   java/util/HashMap.containsKey:(Ljava/lang/Object;)Z
        //   143: ifne            164
        //   146: aload           4
        //   148: getfield        com/facebook/k.c:Ljava/util/HashMap;
        //   151: aload           9
        //   153: new             Ljava/util/ArrayList;
        //   156: dup            
        //   157: invokespecial   java/util/ArrayList.<init>:()V
        //   160: invokevirtual   java/util/HashMap.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   163: pop            
        //   164: aload           4
        //   166: getfield        com/facebook/k.c:Ljava/util/HashMap;
        //   169: aload           9
        //   171: invokevirtual   java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   174: checkcast       Ljava/util/List;
        //   177: aload           8
        //   179: invokeinterface java/util/List.addAll:(Ljava/util/Collection;)Z
        //   184: pop            
        //   185: goto            25
        //   188: astore_3       
        //   189: aload_2        
        //   190: monitorexit    
        //   191: aload_3        
        //   192: athrow         
        //   193: astore          13
        //   195: aconst_null    
        //   196: astore          12
        //   198: invokestatic    com/facebook/d.d:()Ljava/lang/String;
        //   201: new             Ljava/lang/StringBuilder;
        //   204: dup            
        //   205: ldc             "Got unexpected exception: "
        //   207: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   210: aload           13
        //   212: invokevirtual   java/lang/Exception.toString:()Ljava/lang/String;
        //   215: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   218: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   221: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   224: pop            
        //   225: aload           12
        //   227: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   230: goto            81
        //   233: aload           12
        //   235: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //   238: aload           14
        //   240: athrow         
        //   241: astore          14
        //   243: goto            233
        //   246: astore          13
        //   248: goto            198
        //   251: astore          14
        //   253: aconst_null    
        //   254: astore          12
        //   256: goto            233
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  6      25     188    193    Any
        //  25     34     188    193    Any
        //  39     66     193    198    Ljava/lang/Exception;
        //  39     66     251    259    Any
        //  66     76     246    251    Ljava/lang/Exception;
        //  66     76     241    246    Any
        //  76     81     188    193    Any
        //  81     83     188    193    Any
        //  84     164    188    193    Any
        //  164    185    188    193    Any
        //  198    225    241    246    Any
        //  225    230    188    193    Any
        //  233    241    188    193    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 109, Size: 109
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3305)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:114)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
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
    
    public final List a(final e key) {
        return this.c.get(key);
    }
    
    public final Set a() {
        return this.c.keySet();
    }
}

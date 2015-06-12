// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.widget;

final class ActivityChooserModel$HistoryLoader implements Runnable
{
    final /* synthetic */ ActivityChooserModel this$0;
    
    private ActivityChooserModel$HistoryLoader(final ActivityChooserModel this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void run() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader.this$0:Lcom/actionbarsherlock/widget/ActivityChooserModel;
        //     4: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$400:(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Landroid/content/Context;
        //     7: aload_0        
        //     8: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader.this$0:Lcom/actionbarsherlock/widget/ActivityChooserModel;
        //    11: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$300:(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
        //    14: invokevirtual   android/content/Context.openFileInput:(Ljava/lang/String;)Ljava/io/FileInputStream;
        //    17: astore_2       
        //    18: invokestatic    android/util/Xml.newPullParser:()Lorg/xmlpull/v1/XmlPullParser;
        //    21: astore          11
        //    23: aload           11
        //    25: aload_2        
        //    26: aconst_null    
        //    27: invokeinterface org/xmlpull/v1/XmlPullParser.setInput:(Ljava/io/InputStream;Ljava/lang/String;)V
        //    32: iconst_0       
        //    33: istore          12
        //    35: iload           12
        //    37: iconst_1       
        //    38: if_icmpeq       59
        //    41: iload           12
        //    43: iconst_2       
        //    44: if_icmpeq       59
        //    47: aload           11
        //    49: invokeinterface org/xmlpull/v1/XmlPullParser.next:()I
        //    54: istore          12
        //    56: goto            35
        //    59: ldc             "historical-records"
        //    61: aload           11
        //    63: invokeinterface org/xmlpull/v1/XmlPullParser.getName:()Ljava/lang/String;
        //    68: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    71: ifne            129
        //    74: new             Lorg/xmlpull/v1/XmlPullParserException;
        //    77: dup            
        //    78: ldc             "Share records file does not start with historical-records tag."
        //    80: invokespecial   org/xmlpull/v1/XmlPullParserException.<init>:(Ljava/lang/String;)V
        //    83: athrow         
        //    84: astore          8
        //    86: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$1100:()Ljava/lang/String;
        //    89: new             Ljava/lang/StringBuilder;
        //    92: dup            
        //    93: invokespecial   java/lang/StringBuilder.<init>:()V
        //    96: ldc             "Error reading historical recrod file: "
        //    98: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   101: aload_0        
        //   102: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader.this$0:Lcom/actionbarsherlock/widget/ActivityChooserModel;
        //   105: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$300:(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
        //   108: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   111: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   114: aload           8
        //   116: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   119: pop            
        //   120: aload_2        
        //   121: ifnull          128
        //   124: aload_2        
        //   125: invokevirtual   java/io/FileInputStream.close:()V
        //   128: return         
        //   129: new             Ljava/util/ArrayList;
        //   132: dup            
        //   133: invokespecial   java/util/ArrayList.<init>:()V
        //   136: astore          13
        //   138: aload           11
        //   140: invokeinterface org/xmlpull/v1/XmlPullParser.next:()I
        //   145: istore          14
        //   147: iload           14
        //   149: iconst_1       
        //   150: if_icmpne       227
        //   153: aload_0        
        //   154: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader.this$0:Lcom/actionbarsherlock/widget/ActivityChooserModel;
        //   157: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$500:(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/Object;
        //   160: astore          15
        //   162: aload           15
        //   164: monitorenter   
        //   165: new             Ljava/util/LinkedHashSet;
        //   168: dup            
        //   169: aload           13
        //   171: invokespecial   java/util/LinkedHashSet.<init>:(Ljava/util/Collection;)V
        //   174: astore          16
        //   176: aload_0        
        //   177: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader.this$0:Lcom/actionbarsherlock/widget/ActivityChooserModel;
        //   180: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$600:(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/util/List;
        //   183: astore          18
        //   185: iconst_m1      
        //   186: aload           18
        //   188: invokeinterface java/util/List.size:()I
        //   193: iadd           
        //   194: istore          19
        //   196: iload           19
        //   198: iflt            377
        //   201: aload           16
        //   203: aload           18
        //   205: iload           19
        //   207: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   212: checkcast       Lcom/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord;
        //   215: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //   220: pop            
        //   221: iinc            19, -1
        //   224: goto            196
        //   227: iload           14
        //   229: iconst_3       
        //   230: if_icmpeq       138
        //   233: iload           14
        //   235: iconst_4       
        //   236: if_icmpeq       138
        //   239: ldc             "historical-record"
        //   241: aload           11
        //   243: invokeinterface org/xmlpull/v1/XmlPullParser.getName:()Ljava/lang/String;
        //   248: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   251: ifne            312
        //   254: new             Lorg/xmlpull/v1/XmlPullParserException;
        //   257: dup            
        //   258: ldc             "Share records file not well-formed."
        //   260: invokespecial   org/xmlpull/v1/XmlPullParserException.<init>:(Ljava/lang/String;)V
        //   263: athrow         
        //   264: astore          5
        //   266: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$1100:()Ljava/lang/String;
        //   269: new             Ljava/lang/StringBuilder;
        //   272: dup            
        //   273: invokespecial   java/lang/StringBuilder.<init>:()V
        //   276: ldc             "Error reading historical recrod file: "
        //   278: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   281: aload_0        
        //   282: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader.this$0:Lcom/actionbarsherlock/widget/ActivityChooserModel;
        //   285: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$300:(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
        //   288: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   291: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   294: aload           5
        //   296: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   299: pop            
        //   300: aload_2        
        //   301: ifnull          128
        //   304: aload_2        
        //   305: invokevirtual   java/io/FileInputStream.close:()V
        //   308: return         
        //   309: astore          7
        //   311: return         
        //   312: aload           13
        //   314: new             Lcom/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord;
        //   317: dup            
        //   318: aload           11
        //   320: aconst_null    
        //   321: ldc             "activity"
        //   323: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   328: aload           11
        //   330: aconst_null    
        //   331: ldc             "time"
        //   333: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   338: invokestatic    java/lang/Long.parseLong:(Ljava/lang/String;)J
        //   341: aload           11
        //   343: aconst_null    
        //   344: ldc             "weight"
        //   346: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   351: invokestatic    java/lang/Float.parseFloat:(Ljava/lang/String;)F
        //   354: invokespecial   com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord.<init>:(Ljava/lang/String;JF)V
        //   357: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   362: pop            
        //   363: goto            138
        //   366: astore_3       
        //   367: aload_2        
        //   368: ifnull          375
        //   371: aload_2        
        //   372: invokevirtual   java/io/FileInputStream.close:()V
        //   375: aload_3        
        //   376: athrow         
        //   377: aload           18
        //   379: invokeinterface java/util/List.size:()I
        //   384: aload           16
        //   386: invokeinterface java/util/Set.size:()I
        //   391: if_icmpne       409
        //   394: aload           15
        //   396: monitorexit    
        //   397: aload_2        
        //   398: ifnull          128
        //   401: aload_2        
        //   402: invokevirtual   java/io/FileInputStream.close:()V
        //   405: return         
        //   406: astore          25
        //   408: return         
        //   409: aload           18
        //   411: invokeinterface java/util/List.clear:()V
        //   416: aload           18
        //   418: aload           16
        //   420: invokeinterface java/util/List.addAll:(Ljava/util/Collection;)Z
        //   425: pop            
        //   426: aload_0        
        //   427: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader.this$0:Lcom/actionbarsherlock/widget/ActivityChooserModel;
        //   430: iconst_1       
        //   431: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$702:(Lcom/actionbarsherlock/widget/ActivityChooserModel;Z)Z
        //   434: pop            
        //   435: aload_0        
        //   436: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader.this$0:Lcom/actionbarsherlock/widget/ActivityChooserModel;
        //   439: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$1000:(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Landroid/os/Handler;
        //   442: new             Lcom/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader$1;
        //   445: dup            
        //   446: aload_0        
        //   447: invokespecial   com/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader$1.<init>:(Lcom/actionbarsherlock/widget/ActivityChooserModel$HistoryLoader;)V
        //   450: invokevirtual   android/os/Handler.post:(Ljava/lang/Runnable;)Z
        //   453: pop            
        //   454: aload           15
        //   456: monitorexit    
        //   457: aload_2        
        //   458: ifnull          128
        //   461: aload_2        
        //   462: invokevirtual   java/io/FileInputStream.close:()V
        //   465: return         
        //   466: astore          24
        //   468: return         
        //   469: astore          17
        //   471: aload           15
        //   473: monitorexit    
        //   474: aload           17
        //   476: athrow         
        //   477: astore          10
        //   479: return         
        //   480: astore          4
        //   482: goto            375
        //   485: astore_1       
        //   486: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                   
        //  -----  -----  -----  -----  ---------------------------------------
        //  0      18     485    487    Ljava/io/FileNotFoundException;
        //  18     32     84     128    Lorg/xmlpull/v1/XmlPullParserException;
        //  18     32     264    312    Ljava/io/IOException;
        //  18     32     366    377    Any
        //  47     56     84     128    Lorg/xmlpull/v1/XmlPullParserException;
        //  47     56     264    312    Ljava/io/IOException;
        //  47     56     366    377    Any
        //  59     84     84     128    Lorg/xmlpull/v1/XmlPullParserException;
        //  59     84     264    312    Ljava/io/IOException;
        //  59     84     366    377    Any
        //  86     120    366    377    Any
        //  124    128    477    480    Ljava/io/IOException;
        //  129    138    84     128    Lorg/xmlpull/v1/XmlPullParserException;
        //  129    138    264    312    Ljava/io/IOException;
        //  129    138    366    377    Any
        //  138    147    84     128    Lorg/xmlpull/v1/XmlPullParserException;
        //  138    147    264    312    Ljava/io/IOException;
        //  138    147    366    377    Any
        //  153    165    84     128    Lorg/xmlpull/v1/XmlPullParserException;
        //  153    165    264    312    Ljava/io/IOException;
        //  153    165    366    377    Any
        //  165    196    469    477    Any
        //  201    221    469    477    Any
        //  239    264    84     128    Lorg/xmlpull/v1/XmlPullParserException;
        //  239    264    264    312    Ljava/io/IOException;
        //  239    264    366    377    Any
        //  266    300    366    377    Any
        //  304    308    309    312    Ljava/io/IOException;
        //  312    363    84     128    Lorg/xmlpull/v1/XmlPullParserException;
        //  312    363    264    312    Ljava/io/IOException;
        //  312    363    366    377    Any
        //  371    375    480    485    Ljava/io/IOException;
        //  377    397    469    477    Any
        //  401    405    406    409    Ljava/io/IOException;
        //  409    457    469    477    Any
        //  461    465    466    469    Ljava/io/IOException;
        //  471    474    469    477    Any
        //  474    477    84     128    Lorg/xmlpull/v1/XmlPullParserException;
        //  474    477    264    312    Ljava/io/IOException;
        //  474    477    366    377    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 217, Size: 217
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3305)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3419)
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
}

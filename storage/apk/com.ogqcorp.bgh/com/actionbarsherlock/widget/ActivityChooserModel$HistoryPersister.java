// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.widget;

final class ActivityChooserModel$HistoryPersister implements Runnable
{
    final /* synthetic */ ActivityChooserModel this$0;
    
    private ActivityChooserModel$HistoryPersister(final ActivityChooserModel this$0) {
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
        //     1: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister.this$0:Lcom/actionbarsherlock/widget/ActivityChooserModel;
        //     4: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$500:(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/Object;
        //     7: astore_1       
        //     8: aload_1        
        //     9: monitorenter   
        //    10: new             Ljava/util/ArrayList;
        //    13: dup            
        //    14: aload_0        
        //    15: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister.this$0:Lcom/actionbarsherlock/widget/ActivityChooserModel;
        //    18: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$600:(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/util/List;
        //    21: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //    24: astore_2       
        //    25: aload_1        
        //    26: monitorexit    
        //    27: aload_0        
        //    28: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister.this$0:Lcom/actionbarsherlock/widget/ActivityChooserModel;
        //    31: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$400:(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Landroid/content/Context;
        //    34: aload_0        
        //    35: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister.this$0:Lcom/actionbarsherlock/widget/ActivityChooserModel;
        //    38: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$300:(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
        //    41: iconst_0       
        //    42: invokevirtual   android/content/Context.openFileOutput:(Ljava/lang/String;I)Ljava/io/FileOutputStream;
        //    45: astore          6
        //    47: invokestatic    android/util/Xml.newSerializer:()Lorg/xmlpull/v1/XmlSerializer;
        //    50: astore          7
        //    52: aload           7
        //    54: aload           6
        //    56: aconst_null    
        //    57: invokeinterface org/xmlpull/v1/XmlSerializer.setOutput:(Ljava/io/OutputStream;Ljava/lang/String;)V
        //    62: aload           7
        //    64: ldc             "UTF-8"
        //    66: iconst_1       
        //    67: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //    70: invokeinterface org/xmlpull/v1/XmlSerializer.startDocument:(Ljava/lang/String;Ljava/lang/Boolean;)V
        //    75: aload           7
        //    77: aconst_null    
        //    78: ldc             "historical-records"
        //    80: invokeinterface org/xmlpull/v1/XmlSerializer.startTag:(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
        //    85: pop            
        //    86: aload_2        
        //    87: invokeinterface java/util/List.size:()I
        //    92: istore          20
        //    94: iconst_0       
        //    95: istore          21
        //    97: iload           21
        //    99: iload           20
        //   101: if_icmpge       243
        //   104: aload_2        
        //   105: iconst_0       
        //   106: invokeinterface java/util/List.remove:(I)Ljava/lang/Object;
        //   111: checkcast       Lcom/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord;
        //   114: astore          22
        //   116: aload           7
        //   118: aconst_null    
        //   119: ldc             "historical-record"
        //   121: invokeinterface org/xmlpull/v1/XmlSerializer.startTag:(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
        //   126: pop            
        //   127: aload           7
        //   129: aconst_null    
        //   130: ldc             "activity"
        //   132: aload           22
        //   134: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord.activity:Landroid/content/ComponentName;
        //   137: invokevirtual   android/content/ComponentName.flattenToString:()Ljava/lang/String;
        //   140: invokeinterface org/xmlpull/v1/XmlSerializer.attribute:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
        //   145: pop            
        //   146: aload           7
        //   148: aconst_null    
        //   149: ldc             "time"
        //   151: aload           22
        //   153: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord.time:J
        //   156: invokestatic    java/lang/String.valueOf:(J)Ljava/lang/String;
        //   159: invokeinterface org/xmlpull/v1/XmlSerializer.attribute:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
        //   164: pop            
        //   165: aload           7
        //   167: aconst_null    
        //   168: ldc             "weight"
        //   170: aload           22
        //   172: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoricalRecord.weight:F
        //   175: invokestatic    java/lang/String.valueOf:(F)Ljava/lang/String;
        //   178: invokeinterface org/xmlpull/v1/XmlSerializer.attribute:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
        //   183: pop            
        //   184: aload           7
        //   186: aconst_null    
        //   187: ldc             "historical-record"
        //   189: invokeinterface org/xmlpull/v1/XmlSerializer.endTag:(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
        //   194: pop            
        //   195: iinc            21, 1
        //   198: goto            97
        //   201: astore_3       
        //   202: aload_1        
        //   203: monitorexit    
        //   204: aload_3        
        //   205: athrow         
        //   206: astore          4
        //   208: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$1100:()Ljava/lang/String;
        //   211: new             Ljava/lang/StringBuilder;
        //   214: dup            
        //   215: invokespecial   java/lang/StringBuilder.<init>:()V
        //   218: ldc             "Error writing historical recrod file: "
        //   220: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   223: aload_0        
        //   224: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister.this$0:Lcom/actionbarsherlock/widget/ActivityChooserModel;
        //   227: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$300:(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
        //   230: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   233: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   236: aload           4
        //   238: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   241: pop            
        //   242: return         
        //   243: aload           7
        //   245: aconst_null    
        //   246: ldc             "historical-records"
        //   248: invokeinterface org/xmlpull/v1/XmlSerializer.endTag:(Ljava/lang/String;Ljava/lang/String;)Lorg/xmlpull/v1/XmlSerializer;
        //   253: pop            
        //   254: aload           7
        //   256: invokeinterface org/xmlpull/v1/XmlSerializer.endDocument:()V
        //   261: aload           6
        //   263: ifnull          242
        //   266: aload           6
        //   268: invokevirtual   java/io/FileOutputStream.close:()V
        //   271: return         
        //   272: astore          29
        //   274: return         
        //   275: astore          16
        //   277: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$1100:()Ljava/lang/String;
        //   280: new             Ljava/lang/StringBuilder;
        //   283: dup            
        //   284: invokespecial   java/lang/StringBuilder.<init>:()V
        //   287: ldc             "Error writing historical recrod file: "
        //   289: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   292: aload_0        
        //   293: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister.this$0:Lcom/actionbarsherlock/widget/ActivityChooserModel;
        //   296: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$300:(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
        //   299: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   302: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   305: aload           16
        //   307: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   310: pop            
        //   311: aload           6
        //   313: ifnull          242
        //   316: aload           6
        //   318: invokevirtual   java/io/FileOutputStream.close:()V
        //   321: return         
        //   322: astore          18
        //   324: return         
        //   325: astore          13
        //   327: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$1100:()Ljava/lang/String;
        //   330: new             Ljava/lang/StringBuilder;
        //   333: dup            
        //   334: invokespecial   java/lang/StringBuilder.<init>:()V
        //   337: ldc             "Error writing historical recrod file: "
        //   339: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   342: aload_0        
        //   343: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister.this$0:Lcom/actionbarsherlock/widget/ActivityChooserModel;
        //   346: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$300:(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
        //   349: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   352: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   355: aload           13
        //   357: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   360: pop            
        //   361: aload           6
        //   363: ifnull          242
        //   366: aload           6
        //   368: invokevirtual   java/io/FileOutputStream.close:()V
        //   371: return         
        //   372: astore          15
        //   374: return         
        //   375: astore          10
        //   377: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$1100:()Ljava/lang/String;
        //   380: new             Ljava/lang/StringBuilder;
        //   383: dup            
        //   384: invokespecial   java/lang/StringBuilder.<init>:()V
        //   387: ldc             "Error writing historical recrod file: "
        //   389: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   392: aload_0        
        //   393: getfield        com/actionbarsherlock/widget/ActivityChooserModel$HistoryPersister.this$0:Lcom/actionbarsherlock/widget/ActivityChooserModel;
        //   396: invokestatic    com/actionbarsherlock/widget/ActivityChooserModel.access$300:(Lcom/actionbarsherlock/widget/ActivityChooserModel;)Ljava/lang/String;
        //   399: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   402: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   405: aload           10
        //   407: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //   410: pop            
        //   411: aload           6
        //   413: ifnull          242
        //   416: aload           6
        //   418: invokevirtual   java/io/FileOutputStream.close:()V
        //   421: return         
        //   422: astore          12
        //   424: return         
        //   425: astore          8
        //   427: aload           6
        //   429: ifnull          437
        //   432: aload           6
        //   434: invokevirtual   java/io/FileOutputStream.close:()V
        //   437: aload           8
        //   439: athrow         
        //   440: astore          9
        //   442: goto            437
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  10     27     201    206    Any
        //  27     47     206    242    Ljava/io/FileNotFoundException;
        //  52     94     275    325    Ljava/lang/IllegalArgumentException;
        //  52     94     325    375    Ljava/lang/IllegalStateException;
        //  52     94     375    425    Ljava/io/IOException;
        //  52     94     425    445    Any
        //  104    195    275    325    Ljava/lang/IllegalArgumentException;
        //  104    195    325    375    Ljava/lang/IllegalStateException;
        //  104    195    375    425    Ljava/io/IOException;
        //  104    195    425    445    Any
        //  202    204    201    206    Any
        //  243    261    275    325    Ljava/lang/IllegalArgumentException;
        //  243    261    325    375    Ljava/lang/IllegalStateException;
        //  243    261    375    425    Ljava/io/IOException;
        //  243    261    425    445    Any
        //  266    271    272    275    Ljava/io/IOException;
        //  277    311    425    445    Any
        //  316    321    322    325    Ljava/io/IOException;
        //  327    361    425    445    Any
        //  366    371    372    375    Ljava/io/IOException;
        //  377    411    425    445    Any
        //  416    421    422    425    Ljava/io/IOException;
        //  432    437    440    445    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 199, Size: 199
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
}

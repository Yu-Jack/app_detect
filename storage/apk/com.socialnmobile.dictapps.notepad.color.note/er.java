import java.util.Map;
import java.io.File;
import java.util.List;

// 
// Decompiled by Procyon v0.5.29
// 

public class er
{
    private static final String a;
    private byte[] b;
    
    static {
        a = er.class.getSimpleName();
    }
    
    public er(final String p0, final String p1, final String p2, final boolean p3, final long p4, final long p5, final List p6, final File p7, final Map p8, final Map p9, final Map p10) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: invokespecial   java/lang/Object.<init>:()V
        //     4: aload_0        
        //     5: aconst_null    
        //     6: putfield        er.b:[B
        //     9: new             Lge;
        //    12: dup            
        //    13: invokespecial   ge.<init>:()V
        //    16: astore          14
        //    18: new             Ljava/io/ByteArrayOutputStream;
        //    21: dup            
        //    22: invokespecial   java/io/ByteArrayOutputStream.<init>:()V
        //    25: astore          15
        //    27: new             Ljava/security/DigestOutputStream;
        //    30: dup            
        //    31: aload           15
        //    33: aload           14
        //    35: invokespecial   java/security/DigestOutputStream.<init>:(Ljava/io/OutputStream;Ljava/security/MessageDigest;)V
        //    38: astore          16
        //    40: new             Ljava/io/DataOutputStream;
        //    43: dup            
        //    44: aload           16
        //    46: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    49: astore          17
        //    51: aload           17
        //    53: bipush          27
        //    55: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //    58: aload           17
        //    60: iconst_0       
        //    61: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //    64: aload           17
        //    66: lconst_0       
        //    67: invokevirtual   java/io/DataOutputStream.writeLong:(J)V
        //    70: aload           17
        //    72: iconst_0       
        //    73: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //    76: aload           17
        //    78: iconst_3       
        //    79: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //    82: aload           17
        //    84: invokestatic    eg.a:()I
        //    87: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //    90: aload           17
        //    92: invokestatic    java/lang/System.currentTimeMillis:()J
        //    95: invokevirtual   java/io/DataOutputStream.writeLong:(J)V
        //    98: aload           17
        //   100: aload_1        
        //   101: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   104: aload           17
        //   106: aload_2        
        //   107: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   110: aload           17
        //   112: iconst_1       
        //   113: aload           11
        //   115: invokeinterface java/util/Map.size:()I
        //   120: iadd           
        //   121: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   124: aload           17
        //   126: invokestatic    em.e:()I
        //   129: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   132: aload           17
        //   134: aload_3        
        //   135: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   138: aload           11
        //   140: invokeinterface java/util/Map.isEmpty:()Z
        //   145: ifne            267
        //   148: aload           11
        //   150: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //   155: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   160: astore          46
        //   162: aload           46
        //   164: invokeinterface java/util/Iterator.hasNext:()Z
        //   169: ifeq            267
        //   172: aload           46
        //   174: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   179: checkcast       Ljava/util/Map$Entry;
        //   182: astore          47
        //   184: aload           17
        //   186: aload           47
        //   188: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   193: checkcast       Lfu;
        //   196: getfield        fu.c:I
        //   199: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   202: aload           47
        //   204: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   209: checkcast       Ljava/nio/ByteBuffer;
        //   212: invokevirtual   java/nio/ByteBuffer.array:()[B
        //   215: astore          48
        //   217: aload           17
        //   219: aload           48
        //   221: arraylength    
        //   222: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   225: aload           17
        //   227: aload           48
        //   229: invokevirtual   java/io/DataOutputStream.write:([B)V
        //   232: goto            162
        //   235: astore          19
        //   237: aload           17
        //   239: astore          20
        //   241: getstatic       er.a:Ljava/lang/String;
        //   244: pop            
        //   245: ldc             "Error when generating report"
        //   247: aload           19
        //   249: invokestatic    gj.b:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   252: aload           20
        //   254: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   257: aconst_null    
        //   258: astore          22
        //   260: aload_0        
        //   261: aload           22
        //   263: putfield        er.b:[B
        //   266: return         
        //   267: aload           17
        //   269: iconst_0       
        //   270: invokevirtual   java/io/DataOutputStream.writeByte:(I)V
        //   273: aload           17
        //   275: iload           4
        //   277: invokevirtual   java/io/DataOutputStream.writeBoolean:(Z)V
        //   280: aload           17
        //   282: lload           5
        //   284: invokevirtual   java/io/DataOutputStream.writeLong:(J)V
        //   287: aload           17
        //   289: lload           7
        //   291: invokevirtual   java/io/DataOutputStream.writeLong:(J)V
        //   294: aload           17
        //   296: bipush          6
        //   298: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   301: aload           17
        //   303: ldc             "device.model"
        //   305: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   308: aload           17
        //   310: getstatic       android/os/Build.MODEL:Ljava/lang/String;
        //   313: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   316: aload           17
        //   318: ldc             "build.brand"
        //   320: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   323: aload           17
        //   325: getstatic       android/os/Build.BRAND:Ljava/lang/String;
        //   328: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   331: aload           17
        //   333: ldc             "build.id"
        //   335: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   338: aload           17
        //   340: getstatic       android/os/Build.ID:Ljava/lang/String;
        //   343: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   346: aload           17
        //   348: ldc             "version.release"
        //   350: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   353: aload           17
        //   355: getstatic       android/os/Build$VERSION.RELEASE:Ljava/lang/String;
        //   358: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   361: aload           17
        //   363: ldc             "build.device"
        //   365: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   368: aload           17
        //   370: getstatic       android/os/Build.DEVICE:Ljava/lang/String;
        //   373: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   376: aload           17
        //   378: ldc             "build.product"
        //   380: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   383: aload           17
        //   385: getstatic       android/os/Build.PRODUCT:Ljava/lang/String;
        //   388: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   391: aload           12
        //   393: ifnull          722
        //   396: aload           12
        //   398: invokeinterface java/util/Map.keySet:()Ljava/util/Set;
        //   403: invokeinterface java/util/Set.size:()I
        //   408: istore          23
        //   410: getstatic       er.a:Ljava/lang/String;
        //   413: pop            
        //   414: iconst_3       
        //   415: new             Ljava/lang/StringBuilder;
        //   418: dup            
        //   419: ldc             "refMapSize is:  "
        //   421: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   424: iload           23
        //   426: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   429: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   432: invokestatic    gj.a:(ILjava/lang/String;)V
        //   435: iload           23
        //   437: ifne            464
        //   440: new             Leo;
        //   443: dup            
        //   444: aload           10
        //   446: invokespecial   eo.<init>:(Ljava/io/File;)V
        //   449: invokevirtual   eo.a:()Ljava/util/Map;
        //   452: astore          12
        //   454: getstatic       er.a:Ljava/lang/String;
        //   457: pop            
        //   458: iconst_3       
        //   459: ldc             "after loading referrer file:  "
        //   461: invokestatic    gj.a:(ILjava/lang/String;)V
        //   464: aload           17
        //   466: iload           23
        //   468: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   471: aload           12
        //   473: ifnull          728
        //   476: getstatic       er.a:Ljava/lang/String;
        //   479: pop            
        //   480: iconst_3       
        //   481: ldc             "sending referrer values because it exists"
        //   483: invokestatic    gj.a:(ILjava/lang/String;)V
        //   486: aload           12
        //   488: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //   493: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   498: astore          27
        //   500: aload           27
        //   502: invokeinterface java/util/Iterator.hasNext:()Z
        //   507: ifeq            728
        //   510: aload           27
        //   512: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   517: checkcast       Ljava/util/Map$Entry;
        //   520: astore          40
        //   522: getstatic       er.a:Ljava/lang/String;
        //   525: pop            
        //   526: iconst_3       
        //   527: new             Ljava/lang/StringBuilder;
        //   530: dup            
        //   531: ldc             "Referrer Entry:  "
        //   533: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   536: aload           40
        //   538: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   543: checkcast       Ljava/lang/String;
        //   546: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   549: ldc             "="
        //   551: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   554: aload           40
        //   556: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   561: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   564: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   567: invokestatic    gj.a:(ILjava/lang/String;)V
        //   570: aload           17
        //   572: aload           40
        //   574: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   579: checkcast       Ljava/lang/String;
        //   582: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   585: getstatic       er.a:Ljava/lang/String;
        //   588: pop            
        //   589: iconst_3       
        //   590: new             Ljava/lang/StringBuilder;
        //   593: dup            
        //   594: ldc             "referrer key is :"
        //   596: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   599: aload           40
        //   601: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   606: checkcast       Ljava/lang/String;
        //   609: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   612: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   615: invokestatic    gj.a:(ILjava/lang/String;)V
        //   618: aload           17
        //   620: aload           40
        //   622: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   627: checkcast       Ljava/util/List;
        //   630: invokeinterface java/util/List.size:()I
        //   635: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   638: aload           40
        //   640: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   645: checkcast       Ljava/util/List;
        //   648: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //   653: astore          43
        //   655: aload           43
        //   657: invokeinterface java/util/Iterator.hasNext:()Z
        //   662: ifeq            500
        //   665: aload           43
        //   667: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   672: checkcast       Ljava/lang/String;
        //   675: astore          44
        //   677: aload           17
        //   679: aload           44
        //   681: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   684: getstatic       er.a:Ljava/lang/String;
        //   687: pop            
        //   688: iconst_3       
        //   689: new             Ljava/lang/StringBuilder;
        //   692: dup            
        //   693: ldc             "referrer value is :"
        //   695: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   698: aload           44
        //   700: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   703: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   706: invokestatic    gj.a:(ILjava/lang/String;)V
        //   709: goto            655
        //   712: astore          18
        //   714: aload           17
        //   716: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   719: aload           18
        //   721: athrow         
        //   722: iconst_0       
        //   723: istore          23
        //   725: goto            410
        //   728: aload           17
        //   730: iconst_0       
        //   731: invokevirtual   java/io/DataOutputStream.writeBoolean:(Z)V
        //   734: aload           13
        //   736: ifnull          1095
        //   739: aload           13
        //   741: invokeinterface java/util/Map.keySet:()Ljava/util/Set;
        //   746: invokeinterface java/util/Set.size:()I
        //   751: istore          28
        //   753: getstatic       er.a:Ljava/lang/String;
        //   756: pop            
        //   757: iconst_3       
        //   758: new             Ljava/lang/StringBuilder;
        //   761: dup            
        //   762: ldc             "optionsMapSize is:  "
        //   764: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   767: iload           28
        //   769: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   772: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   775: invokestatic    gj.a:(ILjava/lang/String;)V
        //   778: aload           17
        //   780: iload           28
        //   782: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   785: aload           13
        //   787: ifnull          978
        //   790: getstatic       er.a:Ljava/lang/String;
        //   793: pop            
        //   794: iconst_3       
        //   795: ldc             "sending launch options"
        //   797: invokestatic    gj.a:(ILjava/lang/String;)V
        //   800: aload           13
        //   802: invokeinterface java/util/Map.entrySet:()Ljava/util/Set;
        //   807: invokeinterface java/util/Set.iterator:()Ljava/util/Iterator;
        //   812: astore          31
        //   814: aload           31
        //   816: invokeinterface java/util/Iterator.hasNext:()Z
        //   821: ifeq            978
        //   824: aload           31
        //   826: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   831: checkcast       Ljava/util/Map$Entry;
        //   834: astore          35
        //   836: getstatic       er.a:Ljava/lang/String;
        //   839: pop            
        //   840: iconst_3       
        //   841: new             Ljava/lang/StringBuilder;
        //   844: dup            
        //   845: ldc             "Launch Options Key:  "
        //   847: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   850: aload           35
        //   852: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   857: checkcast       Ljava/lang/String;
        //   860: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   863: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   866: invokestatic    gj.a:(ILjava/lang/String;)V
        //   869: aload           17
        //   871: aload           35
        //   873: invokeinterface java/util/Map$Entry.getKey:()Ljava/lang/Object;
        //   878: checkcast       Ljava/lang/String;
        //   881: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   884: aload           17
        //   886: aload           35
        //   888: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   893: checkcast       Ljava/util/List;
        //   896: invokeinterface java/util/List.size:()I
        //   901: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   904: aload           35
        //   906: invokeinterface java/util/Map$Entry.getValue:()Ljava/lang/Object;
        //   911: checkcast       Ljava/util/List;
        //   914: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //   919: astore          37
        //   921: aload           37
        //   923: invokeinterface java/util/Iterator.hasNext:()Z
        //   928: ifeq            814
        //   931: aload           37
        //   933: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   938: checkcast       Ljava/lang/String;
        //   941: astore          38
        //   943: aload           17
        //   945: aload           38
        //   947: invokevirtual   java/io/DataOutputStream.writeUTF:(Ljava/lang/String;)V
        //   950: getstatic       er.a:Ljava/lang/String;
        //   953: pop            
        //   954: iconst_3       
        //   955: new             Ljava/lang/StringBuilder;
        //   958: dup            
        //   959: ldc             "Launch Options value is :"
        //   961: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   964: aload           38
        //   966: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   969: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   972: invokestatic    gj.a:(ILjava/lang/String;)V
        //   975: goto            921
        //   978: aload           9
        //   980: invokeinterface java/util/List.size:()I
        //   985: istore          32
        //   987: aload           17
        //   989: iload           32
        //   991: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   994: iconst_0       
        //   995: istore          33
        //   997: iload           33
        //   999: iload           32
        //  1001: if_icmpge       1030
        //  1004: aload           17
        //  1006: aload           9
        //  1008: iload           33
        //  1010: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //  1015: checkcast       Lff;
        //  1018: invokevirtual   ff.a:()[B
        //  1021: invokevirtual   java/io/DataOutputStream.write:([B)V
        //  1024: iinc            33, 1
        //  1027: goto            997
        //  1030: aload           16
        //  1032: iconst_0       
        //  1033: invokevirtual   java/security/DigestOutputStream.on:(Z)V
        //  1036: aload           17
        //  1038: aload           14
        //  1040: invokevirtual   ge.a:()[B
        //  1043: invokevirtual   java/io/DataOutputStream.write:([B)V
        //  1046: aload           17
        //  1048: invokevirtual   java/io/DataOutputStream.close:()V
        //  1051: aload           15
        //  1053: invokevirtual   java/io/ByteArrayOutputStream.toByteArray:()[B
        //  1056: astore          34
        //  1058: aload           34
        //  1060: astore          22
        //  1062: aload           17
        //  1064: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //  1067: goto            260
        //  1070: astore          18
        //  1072: aconst_null    
        //  1073: astore          17
        //  1075: goto            714
        //  1078: astore          18
        //  1080: aload           20
        //  1082: astore          17
        //  1084: goto            714
        //  1087: astore          19
        //  1089: aconst_null    
        //  1090: astore          20
        //  1092: goto            241
        //  1095: iconst_0       
        //  1096: istore          28
        //  1098: goto            753
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  9      51     1087   1095   Ljava/lang/Throwable;
        //  9      51     1070   1078   Any
        //  51     162    235    241    Ljava/lang/Throwable;
        //  51     162    712    714    Any
        //  162    232    235    241    Ljava/lang/Throwable;
        //  162    232    712    714    Any
        //  241    252    1078   1087   Any
        //  267    391    235    241    Ljava/lang/Throwable;
        //  267    391    712    714    Any
        //  396    410    235    241    Ljava/lang/Throwable;
        //  396    410    712    714    Any
        //  410    435    235    241    Ljava/lang/Throwable;
        //  410    435    712    714    Any
        //  440    464    235    241    Ljava/lang/Throwable;
        //  440    464    712    714    Any
        //  464    471    235    241    Ljava/lang/Throwable;
        //  464    471    712    714    Any
        //  476    500    235    241    Ljava/lang/Throwable;
        //  476    500    712    714    Any
        //  500    655    235    241    Ljava/lang/Throwable;
        //  500    655    712    714    Any
        //  655    709    235    241    Ljava/lang/Throwable;
        //  655    709    712    714    Any
        //  728    734    235    241    Ljava/lang/Throwable;
        //  728    734    712    714    Any
        //  739    753    235    241    Ljava/lang/Throwable;
        //  739    753    712    714    Any
        //  753    785    235    241    Ljava/lang/Throwable;
        //  753    785    712    714    Any
        //  790    814    235    241    Ljava/lang/Throwable;
        //  790    814    712    714    Any
        //  814    921    235    241    Ljava/lang/Throwable;
        //  814    921    712    714    Any
        //  921    975    235    241    Ljava/lang/Throwable;
        //  921    975    712    714    Any
        //  978    994    235    241    Ljava/lang/Throwable;
        //  978    994    712    714    Any
        //  1004   1024   235    241    Ljava/lang/Throwable;
        //  1004   1024   712    714    Any
        //  1030   1058   235    241    Ljava/lang/Throwable;
        //  1030   1058   712    714    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0241:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:692)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:529)
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
    
    public final byte[] a() {
        return this.b;
    }
}

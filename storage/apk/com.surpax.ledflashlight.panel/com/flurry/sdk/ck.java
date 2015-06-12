// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Iterator;
import android.text.TextUtils;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class ck
{
    private static final String a;
    
    static {
        a = null;
    }
    
    public static ci a(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: ifnonnull       6
        //     4: aconst_null    
        //     5: areturn        
        //     6: new             Ljava/io/StringReader;
        //     9: dup            
        //    10: aload_0        
        //    11: invokespecial   java/io/StringReader.<init>:(Ljava/lang/String;)V
        //    14: astore_1       
        //    15: invokestatic    android/util/Xml.newPullParser:()Lorg/xmlpull/v1/XmlPullParser;
        //    18: astore          5
        //    20: aload           5
        //    22: ldc             "http://xmlpull.org/v1/doc/features.html#process-namespaces"
        //    24: iconst_0       
        //    25: invokeinterface org/xmlpull/v1/XmlPullParser.setFeature:(Ljava/lang/String;Z)V
        //    30: aload           5
        //    32: aload_1        
        //    33: invokeinterface org/xmlpull/v1/XmlPullParser.setInput:(Ljava/io/Reader;)V
        //    38: aload           5
        //    40: invokeinterface org/xmlpull/v1/XmlPullParser.nextTag:()I
        //    45: pop            
        //    46: aload           5
        //    48: new             Lcom/flurry/sdk/ci$a;
        //    51: dup            
        //    52: invokespecial   com/flurry/sdk/ci$a.<init>:()V
        //    55: new             Ljava/util/ArrayList;
        //    58: dup            
        //    59: invokespecial   java/util/ArrayList.<init>:()V
        //    62: invokestatic    com/flurry/sdk/ck.a:(Lorg/xmlpull/v1/XmlPullParser;Lcom/flurry/sdk/ci$a;Ljava/util/List;)Lcom/flurry/sdk/ci;
        //    65: astore          7
        //    67: iconst_3       
        //    68: ldc             "VASTXmlParser"
        //    70: new             Ljava/lang/StringBuilder;
        //    73: dup            
        //    74: ldc             "Successfully parsed VAST XML: "
        //    76: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    79: aload_0        
        //    80: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    83: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    86: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //    89: aload_1        
        //    90: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    93: aload           7
        //    95: areturn        
        //    96: astore          9
        //    98: aconst_null    
        //    99: astore_1       
        //   100: aload           9
        //   102: astore_2       
        //   103: iconst_3       
        //   104: ldc             "VASTXmlParser"
        //   106: new             Ljava/lang/StringBuilder;
        //   109: dup            
        //   110: ldc             "Error parsing VAST XML: "
        //   112: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   115: aload_0        
        //   116: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   119: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   122: aload_2        
        //   123: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   126: new             Lcom/flurry/sdk/ci$a;
        //   129: dup            
        //   130: invokespecial   com/flurry/sdk/ci$a.<init>:()V
        //   133: invokevirtual   com/flurry/sdk/ci$a.a:()Lcom/flurry/sdk/ci$a;
        //   136: invokevirtual   com/flurry/sdk/ci$a.b:()Lcom/flurry/sdk/ci;
        //   139: astore          4
        //   141: aload_1        
        //   142: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   145: aload           4
        //   147: areturn        
        //   148: astore          8
        //   150: aconst_null    
        //   151: astore_1       
        //   152: aload           8
        //   154: astore_3       
        //   155: aload_1        
        //   156: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   159: aload_3        
        //   160: athrow         
        //   161: astore_3       
        //   162: goto            155
        //   165: astore_2       
        //   166: goto            103
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  6      15     96     103    Ljava/lang/Exception;
        //  6      15     148    155    Any
        //  15     89     165    169    Ljava/lang/Exception;
        //  15     89     161    165    Any
        //  103    141    161    165    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0103:
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
    
    private static ci a(final XmlPullParser xmlPullParser, final ci$a ci$a, final List list) {
        xmlPullParser.require(2, ck.a, "VAST");
        final String attributeValue = xmlPullParser.getAttributeValue(ck.a, "version");
        if (attributeValue != null) {
            while (true) {
                while (true) {
                    Label_0144: {
                        try {
                            final int round = Math.round(Float.parseFloat(attributeValue));
                            if (round > 0 && round <= 3) {
                                ci$a.a(round);
                                while (xmlPullParser.next() != 3) {
                                    if (xmlPullParser.getEventType() == 2) {
                                        if (!xmlPullParser.getName().equals("Ad")) {
                                            break Label_0144;
                                        }
                                        list.add(a(xmlPullParser, new cq$a()));
                                    }
                                }
                                break;
                            }
                            throw new Exception();
                        }
                        catch (NumberFormatException ex) {
                            eo.a(3, "VASTXmlParser", "Could not identify VAST version");
                            continue;
                        }
                        catch (Exception ex2) {
                            eo.a(3, "VASTXmlParser", "VAST version not supported");
                            continue;
                        }
                    }
                    b(xmlPullParser);
                    continue;
                }
            }
            ci$a.a(list);
            ci$a.a(a(list));
        }
        else {
            eo.a(3, "VASTXmlParser", "Could not identify VAST version");
        }
        return ci$a.b();
    }
    
    private static cq a(final XmlPullParser xmlPullParser, final cq$a cq$a) {
        while (true) {
            xmlPullParser.require(2, ck.a, "Ad");
            cq$a.a(xmlPullParser.getAttributeValue(ck.a, "id"));
            while (true) {
                String name = null;
                Label_0137: {
                    try {
                        cq$a.a(Integer.parseInt(xmlPullParser.getAttributeValue(ck.a, "sequence")));
                        while (xmlPullParser.next() != 3) {
                            if (xmlPullParser.getEventType() == 2) {
                                name = xmlPullParser.getName();
                                if (!name.equals("InLine")) {
                                    break Label_0137;
                                }
                                cq$a.a(a(xmlPullParser, new cs$a(), new cr$a(), new ArrayList(), new ArrayList()));
                            }
                        }
                        break;
                    }
                    catch (NumberFormatException ex) {
                        eo.a(3, "VASTXmlParser", "Could not identify Ad Sequence");
                        continue;
                    }
                    continue;
                }
                if (name.equals("Wrapper")) {
                    cq$a.a(a(xmlPullParser, new cs$a(), new cr$a(), new ArrayList(), new ArrayList(), new ArrayList()));
                    continue;
                }
                b(xmlPullParser);
                continue;
            }
        }
        return cq$a.a();
    }
    
    private static cs a(final XmlPullParser xmlPullParser, final cs$a cs$a, final cr$a cr$a, final List list, final List list2) {
        cs$a.a(cl.b);
        xmlPullParser.require(2, ck.a, "InLine");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                final String name = xmlPullParser.getName();
                if (name.equals("Creatives")) {
                    cs$a.d(a(xmlPullParser, new ArrayList()));
                }
                else if (name.equals("AdSystem")) {
                    cr$a.a(xmlPullParser.getAttributeValue(ck.a, "version"));
                    cr$a.b(a(xmlPullParser));
                    cs$a.a(cr$a.a());
                }
                else if (name.equals("AdTitle")) {
                    cs$a.a(a(xmlPullParser));
                }
                else if (name.equals("Impression")) {
                    a(list, a(xmlPullParser));
                }
                else if (name.equals("Error")) {
                    a(list2, a(xmlPullParser));
                }
                else {
                    b(xmlPullParser);
                }
            }
        }
        cs$a.b(list);
        cs$a.c(list2);
        return cs$a.a();
    }
    
    private static cs a(final XmlPullParser xmlPullParser, final cs$a cs$a, final cr$a cr$a, final List list, final List list2, final List list3) {
        cs$a.a(cl.c);
        xmlPullParser.require(2, ck.a, "Wrapper");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                final String name = xmlPullParser.getName();
                if (name.equals("Creatives")) {
                    cs$a.d(a(xmlPullParser, new ArrayList()));
                }
                else if (name.equals("AdSystem")) {
                    cr$a.a(xmlPullParser.getAttributeValue(ck.a, "version"));
                    cr$a.b(a(xmlPullParser));
                    cs$a.a(cr$a.a());
                }
                else if (name.equals("VASTAdTagURI")) {
                    a(list, a(xmlPullParser));
                }
                else if (name.equals("Impression")) {
                    a(list2, a(xmlPullParser));
                }
                else if (name.equals("Error")) {
                    a(list3, a(xmlPullParser));
                }
                else {
                    b(xmlPullParser);
                }
            }
        }
        cs$a.a(list);
        cs$a.b(list2);
        cs$a.c(list3);
        return cs$a.a();
    }
    
    private static ct a(final XmlPullParser xmlPullParser, final ct$a ct$a) {
        xmlPullParser.require(2, ck.a, "Creative");
        ct$a.a(xmlPullParser.getAttributeValue(ck.a, "id"));
        final String attributeValue = xmlPullParser.getAttributeValue(ck.a, "sequence");
    Label_0057:
        while (true) {
            if (attributeValue != null) {
                while (true) {
                    Label_0133: {
                        try {
                            ct$a.a(Math.round(Float.parseFloat(attributeValue)));
                            while (xmlPullParser.next() != 3) {
                                if (xmlPullParser.getEventType() == 2) {
                                    if (!xmlPullParser.getName().equals("Linear")) {
                                        break Label_0133;
                                    }
                                    ct$a.a(cm.b);
                                    ct$a.a(a(xmlPullParser, new cu$a()));
                                }
                            }
                            break;
                        }
                        catch (NumberFormatException ex) {
                            eo.a(3, "VASTXmlParser", "Could not identify Creative sequence");
                            continue Label_0057;
                        }
                        continue Label_0057;
                    }
                    b(xmlPullParser);
                    continue Label_0057;
                }
                return ct$a.a();
            }
            continue Label_0057;
        }
    }
    
    private static cu a(final XmlPullParser xmlPullParser, final cu$a cu$a) {
        xmlPullParser.require(2, ck.a, "Linear");
        final String attributeValue = xmlPullParser.getAttributeValue(ck.a, "skipoffset");
        if (attributeValue != null) {
            cu$a.b(cj.b(attributeValue));
        }
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                final String name = xmlPullParser.getName();
                if (name.equals("Duration")) {
                    cu$a.a(cj.b(a(xmlPullParser)));
                }
                else if (name.equals("TrackingEvents")) {
                    cu$a.a(a(xmlPullParser, new ds()));
                }
                else if (name.equals("VideoClicks")) {
                    cu$a.a(a(xmlPullParser, new HashMap()));
                }
                else if (name.equals("MediaFiles")) {
                    cu$a.a(cj.a(b(xmlPullParser, new ArrayList())));
                }
                else {
                    b(xmlPullParser);
                }
            }
        }
        return cu$a.a();
    }
    
    private static cv a(final XmlPullParser p0, final cv$a p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: iconst_2       
        //     2: getstatic       com/flurry/sdk/ck.a:Ljava/lang/String;
        //     5: ldc_w           "MediaFile"
        //     8: invokeinterface org/xmlpull/v1/XmlPullParser.require:(ILjava/lang/String;Ljava/lang/String;)V
        //    13: aload_1        
        //    14: aload_0        
        //    15: getstatic       com/flurry/sdk/ck.a:Ljava/lang/String;
        //    18: ldc             "id"
        //    20: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    25: invokevirtual   com/flurry/sdk/cv$a.a:(Ljava/lang/String;)Lcom/flurry/sdk/cv$a;
        //    28: pop            
        //    29: aload_1        
        //    30: aload_0        
        //    31: getstatic       com/flurry/sdk/ck.a:Ljava/lang/String;
        //    34: ldc_w           "type"
        //    37: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    42: invokevirtual   com/flurry/sdk/cv$a.d:(Ljava/lang/String;)Lcom/flurry/sdk/cv$a;
        //    45: pop            
        //    46: aload_1        
        //    47: aload_0        
        //    48: getstatic       com/flurry/sdk/ck.a:Ljava/lang/String;
        //    51: ldc_w           "apiFramework"
        //    54: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    59: invokevirtual   com/flurry/sdk/cv$a.b:(Ljava/lang/String;)Lcom/flurry/sdk/cv$a;
        //    62: pop            
        //    63: aload_1        
        //    64: aload_0        
        //    65: getstatic       com/flurry/sdk/ck.a:Ljava/lang/String;
        //    68: ldc_w           "delivery"
        //    71: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    76: invokestatic    com/flurry/sdk/cn.a:(Ljava/lang/String;)Lcom/flurry/sdk/cn;
        //    79: invokevirtual   com/flurry/sdk/cv$a.a:(Lcom/flurry/sdk/cn;)Lcom/flurry/sdk/cv$a;
        //    82: pop            
        //    83: aload_1        
        //    84: aload_0        
        //    85: getstatic       com/flurry/sdk/ck.a:Ljava/lang/String;
        //    88: ldc_w           "height"
        //    91: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //    96: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //    99: invokevirtual   com/flurry/sdk/cv$a.b:(I)Lcom/flurry/sdk/cv$a;
        //   102: pop            
        //   103: aload_1        
        //   104: aload_0        
        //   105: getstatic       com/flurry/sdk/ck.a:Ljava/lang/String;
        //   108: ldc_w           "width"
        //   111: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   116: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   119: invokevirtual   com/flurry/sdk/cv$a.c:(I)Lcom/flurry/sdk/cv$a;
        //   122: pop            
        //   123: aload_1        
        //   124: aload_0        
        //   125: getstatic       com/flurry/sdk/ck.a:Ljava/lang/String;
        //   128: ldc_w           "bitrate"
        //   131: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   136: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   139: invokevirtual   com/flurry/sdk/cv$a.a:(I)Lcom/flurry/sdk/cv$a;
        //   142: pop            
        //   143: aload_1        
        //   144: aload_0        
        //   145: getstatic       com/flurry/sdk/ck.a:Ljava/lang/String;
        //   148: ldc_w           "scalable"
        //   151: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   156: invokestatic    java/lang/Boolean.parseBoolean:(Ljava/lang/String;)Z
        //   159: invokevirtual   com/flurry/sdk/cv$a.b:(Z)Lcom/flurry/sdk/cv$a;
        //   162: pop            
        //   163: aload_1        
        //   164: aload_0        
        //   165: getstatic       com/flurry/sdk/ck.a:Ljava/lang/String;
        //   168: ldc_w           "maintainAspectRatio"
        //   171: invokeinterface org/xmlpull/v1/XmlPullParser.getAttributeValue:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   176: invokestatic    java/lang/Boolean.parseBoolean:(Ljava/lang/String;)Z
        //   179: invokevirtual   com/flurry/sdk/cv$a.a:(Z)Lcom/flurry/sdk/cv$a;
        //   182: pop            
        //   183: aload_1        
        //   184: aload_0        
        //   185: invokestatic    com/flurry/sdk/ck.a:(Lorg/xmlpull/v1/XmlPullParser;)Ljava/lang/String;
        //   188: invokevirtual   com/flurry/sdk/cv$a.c:(Ljava/lang/String;)Lcom/flurry/sdk/cv$a;
        //   191: pop            
        //   192: aload_1        
        //   193: invokevirtual   com/flurry/sdk/cv$a.a:()Lcom/flurry/sdk/cv;
        //   196: areturn        
        //   197: astore          6
        //   199: iconst_3       
        //   200: ldc             "VASTXmlParser"
        //   202: ldc_w           "Could not identify MediaFile height"
        //   205: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //   208: goto            103
        //   211: astore          7
        //   213: iconst_3       
        //   214: ldc             "VASTXmlParser"
        //   216: ldc_w           "Could not identify MediaFile width"
        //   219: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //   222: goto            123
        //   225: astore          8
        //   227: iconst_3       
        //   228: ldc             "VASTXmlParser"
        //   230: ldc_w           "Could not identify MediaFile bitRate"
        //   233: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //   236: goto            143
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  83     103    197    211    Ljava/lang/NumberFormatException;
        //  103    123    211    225    Ljava/lang/NumberFormatException;
        //  123    143    225    239    Ljava/lang/NumberFormatException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 100, Size: 100
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
    
    private static cw a(final XmlPullParser xmlPullParser, final cw$a cw$a) {
        xmlPullParser.require(2, ck.a, "Tracking");
        cw$a.a(co.a(xmlPullParser.getAttributeValue(ck.a, "event")));
        cw$a.a(a(xmlPullParser));
        return cw$a.a();
    }
    
    private static ds a(final XmlPullParser xmlPullParser, final ds ds) {
        xmlPullParser.require(2, ck.a, "TrackingEvents");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("Tracking")) {
                    final cw a = a(xmlPullParser, new cw$a());
                    if (TextUtils.isEmpty((CharSequence)a.b())) {
                        continue;
                    }
                    ds.a(a.a(), a.b());
                }
                else {
                    b(xmlPullParser);
                }
            }
        }
        return ds;
    }
    
    private static String a(final XmlPullParser xmlPullParser) {
        final int next = xmlPullParser.next();
        String trim = null;
        if (next == 4) {
            trim = xmlPullParser.getText().trim();
            xmlPullParser.nextTag();
        }
        return trim;
    }
    
    private static List a(final XmlPullParser xmlPullParser, final List list) {
        xmlPullParser.require(2, ck.a, "Creatives");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("Creative")) {
                    list.add(a(xmlPullParser, new ct$a()));
                }
                else {
                    b(xmlPullParser);
                }
            }
        }
        return list;
    }
    
    private static Map a(final XmlPullParser xmlPullParser, final Map map) {
        xmlPullParser.require(2, ck.a, "VideoClicks");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                final String name = xmlPullParser.getName();
                if (name.equals("ClickThrough")) {
                    map.put(cp.b, a(xmlPullParser));
                }
                else if (name.equals("ClickTracking")) {
                    map.put(cp.c, a(xmlPullParser));
                }
                else if (name.equals("CustomClick")) {
                    map.put(cp.d, a(xmlPullParser));
                }
                else {
                    b(xmlPullParser);
                }
            }
        }
        return map;
    }
    
    private static void a(final List list, final String s) {
        if (list != null && !TextUtils.isEmpty((CharSequence)s)) {
            list.add(s);
        }
    }
    
    public static boolean a(final List list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        final Iterator<cq> iterator = list.iterator();
        while (iterator.hasNext()) {
            final cs c = iterator.next().c();
            if (c == null || !cl.b.equals(c.a())) {
                return false;
            }
        }
        return true;
    }
    
    private static List b(final XmlPullParser xmlPullParser, final List list) {
        xmlPullParser.require(2, ck.a, "MediaFiles");
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("MediaFile")) {
                    list.add(a(xmlPullParser, new cv$a()));
                }
                else {
                    b(xmlPullParser);
                }
            }
        }
        return list;
    }
    
    private static void b(final XmlPullParser xmlPullParser) {
        if (xmlPullParser.getEventType() != 2) {
            throw new IllegalStateException();
        }
        int i = 1;
        while (i != 0) {
            switch (xmlPullParser.next()) {
                default: {
                    continue;
                }
                case 2: {
                    ++i;
                    continue;
                }
                case 3: {
                    --i;
                    continue;
                }
            }
        }
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal;

import android.app.Activity;
import com.actionbarsherlock.R$integer;
import android.util.DisplayMetrics;
import com.actionbarsherlock.R$bool;
import android.os.Build$VERSION;
import android.content.Context;

public final class ResourcesCompat
{
    private static final String TAG = "ResourcesCompat";
    
    public static boolean getResources_getBoolean(final Context context, final int i) {
        if (Build$VERSION.SDK_INT >= 14) {
            return context.getResources().getBoolean(i);
        }
        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        final float n = displayMetrics.widthPixels / displayMetrics.density;
        float n2 = displayMetrics.heightPixels / displayMetrics.density;
        if (n < n2) {
            n2 = n;
        }
        if (i == R$bool.abs__action_bar_embed_tabs) {
            return n >= 480.0f;
        }
        if (i == R$bool.abs__split_action_bar_is_narrow) {
            return n < 480.0f;
        }
        if (i == R$bool.abs__action_bar_expanded_action_views_exclusive) {
            return n2 < 600.0f;
        }
        if (i == R$bool.abs__config_allowActionMenuItemTextWithIcon) {
            return n >= 480.0f;
        }
        throw new IllegalArgumentException("Unknown boolean resource ID " + i);
    }
    
    public static int getResources_getInteger(final Context context, final int i) {
        if (Build$VERSION.SDK_INT >= 13) {
            return context.getResources().getInteger(i);
        }
        final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        final float n = displayMetrics.widthPixels / displayMetrics.density;
        if (i != R$integer.abs__max_action_buttons) {
            throw new IllegalArgumentException("Unknown integer resource ID " + i);
        }
        if (n >= 600.0f) {
            return 5;
        }
        if (n >= 500.0f) {
            return 4;
        }
        if (n >= 360.0f) {
            return 3;
        }
        return 2;
    }
    
    public static int loadLogoFromManifest(final Activity p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //     4: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //     7: astore          4
        //     9: aload_0        
        //    10: invokevirtual   android/app/Activity.getApplicationInfo:()Landroid/content/pm/ApplicationInfo;
        //    13: getfield        android/content/pm/ApplicationInfo.packageName:Ljava/lang/String;
        //    16: astore          5
        //    18: aload_0        
        //    19: aload           5
        //    21: iconst_0       
        //    22: invokevirtual   android/app/Activity.createPackageContext:(Ljava/lang/String;I)Landroid/content/Context;
        //    25: invokevirtual   android/content/Context.getAssets:()Landroid/content/res/AssetManager;
        //    28: ldc             "AndroidManifest.xml"
        //    30: invokevirtual   android/content/res/AssetManager.openXmlResourceParser:(Ljava/lang/String;)Landroid/content/res/XmlResourceParser;
        //    33: astore          6
        //    35: aload           6
        //    37: invokeinterface android/content/res/XmlResourceParser.getEventType:()I
        //    42: istore          7
        //    44: iload           7
        //    46: istore          8
        //    48: iconst_0       
        //    49: istore_3       
        //    50: iload           8
        //    52: iconst_1       
        //    53: if_icmpeq       292
        //    56: iload           8
        //    58: iconst_2       
        //    59: if_icmpne       326
        //    62: aload           6
        //    64: invokeinterface android/content/res/XmlResourceParser.getName:()Ljava/lang/String;
        //    69: astore          12
        //    71: ldc             "application"
        //    73: aload           12
        //    75: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    78: ifeq            157
        //    81: iconst_m1      
        //    82: aload           6
        //    84: invokeinterface android/content/res/XmlResourceParser.getAttributeCount:()I
        //    89: iadd           
        //    90: istore          19
        //    92: iload           19
        //    94: iflt            129
        //    97: ldc             "logo"
        //    99: aload           6
        //   101: iload           19
        //   103: invokeinterface android/content/res/XmlResourceParser.getAttributeName:(I)Ljava/lang/String;
        //   108: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   111: ifeq            151
        //   114: aload           6
        //   116: iload           19
        //   118: iconst_0       
        //   119: invokeinterface android/content/res/XmlResourceParser.getAttributeResourceValue:(II)I
        //   124: istore          20
        //   126: iload           20
        //   128: istore_3       
        //   129: iload_3        
        //   130: istore          9
        //   132: aload           6
        //   134: invokeinterface android/content/res/XmlResourceParser.nextToken:()I
        //   139: istore          11
        //   141: iload           9
        //   143: istore_3       
        //   144: iload           11
        //   146: istore          8
        //   148: goto            50
        //   151: iinc            19, -1
        //   154: goto            92
        //   157: ldc             "activity"
        //   159: aload           12
        //   161: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   164: ifeq            326
        //   167: iconst_m1      
        //   168: aload           6
        //   170: invokeinterface android/content/res/XmlResourceParser.getAttributeCount:()I
        //   175: iadd           
        //   176: istore          13
        //   178: iconst_0       
        //   179: istore          14
        //   181: aconst_null    
        //   182: astore          15
        //   184: aconst_null    
        //   185: astore          16
        //   187: iload           13
        //   189: iflt            287
        //   192: aload           6
        //   194: iload           13
        //   196: invokeinterface android/content/res/XmlResourceParser.getAttributeName:(I)Ljava/lang/String;
        //   201: astore          17
        //   203: ldc             "logo"
        //   205: aload           17
        //   207: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   210: ifeq            247
        //   213: aload           6
        //   215: iload           13
        //   217: iconst_0       
        //   218: invokeinterface android/content/res/XmlResourceParser.getAttributeResourceValue:(II)I
        //   223: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   226: astore          16
        //   228: aload           16
        //   230: ifnull          332
        //   233: aload           15
        //   235: ifnull          332
        //   238: aload           16
        //   240: invokevirtual   java/lang/Integer.intValue:()I
        //   243: istore_3       
        //   244: goto            332
        //   247: ldc             "name"
        //   249: aload           17
        //   251: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   254: ifeq            228
        //   257: aload           5
        //   259: aload           6
        //   261: iload           13
        //   263: invokeinterface android/content/res/XmlResourceParser.getAttributeValue:(I)Ljava/lang/String;
        //   268: invokestatic    com/actionbarsherlock/internal/ActionBarSherlockCompat.cleanActivityName:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   271: astore          15
        //   273: aload           4
        //   275: aload           15
        //   277: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   280: istore          18
        //   282: iload           18
        //   284: ifne            294
        //   287: iload           14
        //   289: ifeq            326
        //   292: iload_3        
        //   293: ireturn        
        //   294: iconst_1       
        //   295: istore          14
        //   297: goto            228
        //   300: astore_1       
        //   301: aload_1        
        //   302: astore_2       
        //   303: iconst_0       
        //   304: istore_3       
        //   305: aload_2        
        //   306: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   309: iload_3        
        //   310: ireturn        
        //   311: astore_2       
        //   312: goto            305
        //   315: astore          10
        //   317: iload           9
        //   319: istore_3       
        //   320: aload           10
        //   322: astore_2       
        //   323: goto            305
        //   326: iload_3        
        //   327: istore          9
        //   329: goto            132
        //   332: iinc            13, -1
        //   335: goto            187
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      44     300    305    Ljava/lang/Exception;
        //  62     92     311    315    Ljava/lang/Exception;
        //  97     126    311    315    Ljava/lang/Exception;
        //  132    141    315    326    Ljava/lang/Exception;
        //  157    178    311    315    Ljava/lang/Exception;
        //  192    228    311    315    Ljava/lang/Exception;
        //  238    244    311    315    Ljava/lang/Exception;
        //  247    282    311    315    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 152, Size: 152
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

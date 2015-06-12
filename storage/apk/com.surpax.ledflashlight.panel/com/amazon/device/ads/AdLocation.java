// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.location.Location;

class AdLocation
{
    private static final String LOG_TAG = "AdLocation";
    private static final float MAX_DISTANCE_IN_KILOMETERS = 3.0f;
    private int arcminutePrecision;
    private AdLocation$LocationAwareness locationAwareness;
    
    public AdLocation() {
        this.locationAwareness = AdLocation$LocationAwareness.LOCATION_AWARENESS_TRUNCATED;
        this.arcminutePrecision = 6;
    }
    
    private static double roundToArcminutes(final double n) {
        return Math.round(n * 60.0) / 60.0;
    }
    
    public Location getLocation() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: ldc             3.4028235E38
        //     2: fstore_1       
        //     3: invokestatic    com/amazon/device/ads/InternalAdRegistration.getInstance:()Lcom/amazon/device/ads/IInternalAdRegistration;
        //     6: invokeinterface com/amazon/device/ads/IInternalAdRegistration.getApplicationContext:()Landroid/content/Context;
        //    11: astore_2       
        //    12: aload_0        
        //    13: getfield        com/amazon/device/ads/AdLocation.locationAwareness:Lcom/amazon/device/ads/AdLocation$LocationAwareness;
        //    16: getstatic       com/amazon/device/ads/AdLocation$LocationAwareness.LOCATION_AWARENESS_DISABLED:Lcom/amazon/device/ads/AdLocation$LocationAwareness;
        //    19: if_acmpne       24
        //    22: aconst_null    
        //    23: areturn        
        //    24: aload_2        
        //    25: ldc             "location"
        //    27: invokevirtual   android/content/Context.getSystemService:(Ljava/lang/String;)Ljava/lang/Object;
        //    30: checkcast       Landroid/location/LocationManager;
        //    33: astore_3       
        //    34: aload_3        
        //    35: ldc             "gps"
        //    37: invokevirtual   android/location/LocationManager.getLastKnownLocation:(Ljava/lang/String;)Landroid/location/Location;
        //    40: astore          12
        //    42: aload           12
        //    44: astore          5
        //    46: aload_3        
        //    47: ldc             "network"
        //    49: invokevirtual   android/location/LocationManager.getLastKnownLocation:(Ljava/lang/String;)Landroid/location/Location;
        //    52: astore          10
        //    54: aload           10
        //    56: astore          7
        //    58: aload           5
        //    60: ifnonnull       68
        //    63: aload           7
        //    65: ifnull          22
        //    68: aload           5
        //    70: ifnull          350
        //    73: aload           7
        //    75: ifnull          350
        //    78: aload           5
        //    80: aload           7
        //    82: invokevirtual   android/location/Location.distanceTo:(Landroid/location/Location;)F
        //    85: ldc             1000.0
        //    87: fdiv           
        //    88: ldc             3.0
        //    90: fcmpg          
        //    91: ifgt            312
        //    94: aload           5
        //    96: invokevirtual   android/location/Location.hasAccuracy:()Z
        //    99: ifeq            292
        //   102: aload           5
        //   104: invokevirtual   android/location/Location.getAccuracy:()F
        //   107: fstore          8
        //   109: aload           7
        //   111: invokevirtual   android/location/Location.hasAccuracy:()Z
        //   114: ifeq            123
        //   117: aload           7
        //   119: invokevirtual   android/location/Location.getAccuracy:()F
        //   122: fstore_1       
        //   123: fload           8
        //   125: fload_1        
        //   126: fcmpg          
        //   127: ifge            298
        //   130: ldc             "AdLocation"
        //   132: ldc             "Setting lat/long using GPS determined by distance"
        //   134: invokestatic    com/amazon/device/ads/Log.d:(Ljava/lang/String;Ljava/lang/String;)V
        //   137: aload_0        
        //   138: getfield        com/amazon/device/ads/AdLocation.locationAwareness:Lcom/amazon/device/ads/AdLocation$LocationAwareness;
        //   141: getstatic       com/amazon/device/ads/AdLocation$LocationAwareness.LOCATION_AWARENESS_TRUNCATED:Lcom/amazon/device/ads/AdLocation$LocationAwareness;
        //   144: if_acmpne       229
        //   147: aload           5
        //   149: aload           5
        //   151: invokevirtual   android/location/Location.getLatitude:()D
        //   154: invokestatic    com/amazon/device/ads/AdLocation.roundToArcminutes:(D)D
        //   157: ldc2_w          10.0
        //   160: aload_0        
        //   161: getfield        com/amazon/device/ads/AdLocation.arcminutePrecision:I
        //   164: i2d            
        //   165: invokestatic    java/lang/Math.pow:(DD)D
        //   168: dmul           
        //   169: invokestatic    java/lang/Math.round:(D)J
        //   172: l2d            
        //   173: ldc2_w          10.0
        //   176: aload_0        
        //   177: getfield        com/amazon/device/ads/AdLocation.arcminutePrecision:I
        //   180: i2d            
        //   181: invokestatic    java/lang/Math.pow:(DD)D
        //   184: ddiv           
        //   185: invokevirtual   android/location/Location.setLatitude:(D)V
        //   188: aload           5
        //   190: aload           5
        //   192: invokevirtual   android/location/Location.getLongitude:()D
        //   195: invokestatic    com/amazon/device/ads/AdLocation.roundToArcminutes:(D)D
        //   198: ldc2_w          10.0
        //   201: aload_0        
        //   202: getfield        com/amazon/device/ads/AdLocation.arcminutePrecision:I
        //   205: i2d            
        //   206: invokestatic    java/lang/Math.pow:(DD)D
        //   209: dmul           
        //   210: invokestatic    java/lang/Math.round:(D)J
        //   213: l2d            
        //   214: ldc2_w          10.0
        //   217: aload_0        
        //   218: getfield        com/amazon/device/ads/AdLocation.arcminutePrecision:I
        //   221: i2d            
        //   222: invokestatic    java/lang/Math.pow:(DD)D
        //   225: ddiv           
        //   226: invokevirtual   android/location/Location.setLongitude:(D)V
        //   229: aload           5
        //   231: areturn        
        //   232: astore          11
        //   234: ldc             "AdLocation"
        //   236: ldc             "Failed to retrieve GPS location: No permissions to access GPS"
        //   238: invokestatic    com/amazon/device/ads/Log.d:(Ljava/lang/String;Ljava/lang/String;)V
        //   241: aconst_null    
        //   242: astore          5
        //   244: goto            46
        //   247: astore          4
        //   249: ldc             "AdLocation"
        //   251: ldc             "Failed to retrieve GPS location: No GPS found"
        //   253: invokestatic    com/amazon/device/ads/Log.d:(Ljava/lang/String;Ljava/lang/String;)V
        //   256: aconst_null    
        //   257: astore          5
        //   259: goto            46
        //   262: astore          9
        //   264: ldc             "AdLocation"
        //   266: ldc             "Failed to retrieve network location: No permissions to access network location"
        //   268: invokestatic    com/amazon/device/ads/Log.d:(Ljava/lang/String;Ljava/lang/String;)V
        //   271: aconst_null    
        //   272: astore          7
        //   274: goto            58
        //   277: astore          6
        //   279: ldc             "AdLocation"
        //   281: ldc             "Failed to retrieve network location: No network provider found"
        //   283: invokestatic    com/amazon/device/ads/Log.d:(Ljava/lang/String;Ljava/lang/String;)V
        //   286: aconst_null    
        //   287: astore          7
        //   289: goto            58
        //   292: fload_1        
        //   293: fstore          8
        //   295: goto            109
        //   298: ldc             "AdLocation"
        //   300: ldc             "Setting lat/long using network determined by distance"
        //   302: invokestatic    com/amazon/device/ads/Log.d:(Ljava/lang/String;Ljava/lang/String;)V
        //   305: aload           7
        //   307: astore          5
        //   309: goto            137
        //   312: aload           5
        //   314: invokevirtual   android/location/Location.getTime:()J
        //   317: aload           7
        //   319: invokevirtual   android/location/Location.getTime:()J
        //   322: lcmp           
        //   323: ifle            336
        //   326: ldc             "AdLocation"
        //   328: ldc             "Setting lat/long using GPS"
        //   330: invokestatic    com/amazon/device/ads/Log.d:(Ljava/lang/String;Ljava/lang/String;)V
        //   333: goto            137
        //   336: ldc             "AdLocation"
        //   338: ldc             "Setting lat/long using network"
        //   340: invokestatic    com/amazon/device/ads/Log.d:(Ljava/lang/String;Ljava/lang/String;)V
        //   343: aload           7
        //   345: astore          5
        //   347: goto            137
        //   350: aload           5
        //   352: ifnull          365
        //   355: ldc             "AdLocation"
        //   357: ldc             "Setting lat/long using GPS, not network"
        //   359: invokestatic    com/amazon/device/ads/Log.d:(Ljava/lang/String;Ljava/lang/String;)V
        //   362: goto            137
        //   365: ldc             "AdLocation"
        //   367: ldc             "Setting lat/long using network location, not GPS"
        //   369: invokestatic    com/amazon/device/ads/Log.d:(Ljava/lang/String;Ljava/lang/String;)V
        //   372: aload           7
        //   374: astore          5
        //   376: goto            137
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  34     42     232    247    Ljava/lang/SecurityException;
        //  34     42     247    262    Ljava/lang/IllegalArgumentException;
        //  46     54     262    277    Ljava/lang/SecurityException;
        //  46     54     277    292    Ljava/lang/IllegalArgumentException;
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
}

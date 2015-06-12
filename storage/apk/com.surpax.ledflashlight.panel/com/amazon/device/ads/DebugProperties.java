// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Hashtable;
import java.security.PrivateKey;
import java.security.Key;
import javax.crypto.Cipher;
import java.security.spec.KeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.KeyFactory;
import java.math.BigInteger;
import java.util.Properties;

class DebugProperties
{
    public static final String DEBUG_AAX_AD_HOSTNAME = "debug.aaxHostname";
    public static final String DEBUG_AAX_AD_PARAMS = "debug.aaxAdParams";
    public static final String DEBUG_AAX_CONFIG_HOSTNAME = "debug.aaxConfigHostname";
    public static final String DEBUG_AAX_CONFIG_PARAMS = "debug.aaxConfigParams";
    public static final String DEBUG_AAX_CONFIG_USE_SECURE = "debug.aaxConfigUseSecure";
    public static final String DEBUG_ADID = "debug.adid";
    public static final String DEBUG_AD_PREF_URL = "debug.adPrefURL";
    public static final String DEBUG_APPID = "debug.appid";
    public static final String DEBUG_CHANNEL = "debug.channel";
    public static final String DEBUG_CONFIG_FEATURE_USE_GPS_ADVERTISING_ID = "debug.fUseGPSAID";
    public static final String DEBUG_DINFO = "debug.dinfo";
    public static final String DEBUG_ECPM = "debug.ec";
    public static final String DEBUG_GEOLOC = "debug.geoloc";
    public static final String DEBUG_IDFA = "debug.idfa";
    public static final String DEBUG_LOGGING = "debug.logging";
    public static final String DEBUG_MADS_HOSTNAME = "debug.madsHostname";
    public static final String DEBUG_MADS_USE_SECURE = "debug.madsUseSecure";
    public static final String DEBUG_MD5UDID = "debug.md5udid";
    public static final String DEBUG_MXSZ = "debug.mxsz";
    public static final String DEBUG_NORETRYTTL = "debug.noRetryTTL";
    public static final String DEBUG_NORETRYTTL_MAX = "debug.noRetryTTLMax";
    public static final String DEBUG_ON = "debug.mode";
    public static final String DEBUG_OPT_OUT = "debug.optOut";
    public static final String DEBUG_PA = "debug.pa";
    public static final String DEBUG_PK = "debug.pk";
    public static final String DEBUG_PKG = "debug.pkg";
    public static final String DEBUG_PT = "debug.pt";
    public static final String DEBUG_SEND_GEO = "debug.sendGeo";
    public static final String DEBUG_SHA1UDID = "debug.sha1udid";
    public static final String DEBUG_SHOULD_FETCH_CONFIG = "debug.shouldFetchConfig";
    public static final String DEBUG_SHOULD_IDENTIFY_USER = "debug.shouldIdentifyUser";
    public static final String DEBUG_SHOULD_REGISTER_SIS = "debug.shouldRegisterSIS";
    public static final String DEBUG_SIS_DOMAIN = "debug.sisDomain";
    public static final String DEBUG_SIS_URL = "debug.sisURL";
    public static final String DEBUG_SIZE = "debug.size";
    public static final String DEBUG_SLOT = "debug.slot";
    public static final String DEBUG_SLOTS = "debug.slots";
    public static final String DEBUG_SLOT_ID = "debug.slotId";
    public static final String DEBUG_SP = "debug.sp";
    public static final String DEBUG_TEST = "debug.test";
    public static final String DEBUG_TLS_ENABLED = "debug.tlsEnabled";
    public static final String DEBUG_UA = "debug.ua";
    public static final String DEBUG_UI = "debug.ui";
    public static final String DEBUG_VER = "debug.ver";
    private static final String FILE_PREFIX = "/com.amazon.device.ads.debug";
    private static final String LOG_TAG;
    private static boolean debugModeOn;
    private static Properties debugProperties;
    private static final BigInteger privExponent;
    private static final BigInteger privModulus;
    
    static {
        LOG_TAG = DebugProperties.class.getSimpleName();
        privModulus = new BigInteger("22425945969293236512819607281747202268852113345956851069545419503178249900977203670147638322801582881051882957295768557918356441519366172126884608406316888515239296504501830280664879549133570276792155151832332847188532369002492210234019359186842709493620665119919750832332220777141369255943445578381285984064028865613478676828533273460580467686485184132743895959747097454385452868408957601246667523882372216446056029831689133478714597838700864119273209955182548633182248700235085802575904827859971001196599005060045450779595767759943984991630413046800554347791145167910883355627096118148593841261053098773337592734097");
        privExponent = new BigInteger("5599215006722084151841970702827860151139465197978118529242591197804380779249736540498127864809226859371835159226553869008622098243456195347852554241917744888762998133926842072150379542281041403163862165638226686887497980590930009552760406707269286898150890998325325890252103828011111664174475487114957696526157790937869377570600085450453371238028811033168218737171144699577236108423054506552958366535341910569552237227686862748056351625445281035713423043506793107235726047151346608576583081807969458368853010104969843563629579750936551771756389538574062221915919980316992216032119182896925094308799622409361028579777");
        DebugProperties.debugProperties = new Properties();
        DebugProperties.debugModeOn = false;
    }
    
    public static boolean containsDebugProperty(final String key) {
        return DebugProperties.debugModeOn && DebugProperties.debugProperties.containsKey(key);
    }
    
    protected static byte[] decrypt(final byte[] input) {
        try {
            final PrivateKey generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new RSAPrivateKeySpec(DebugProperties.privModulus, DebugProperties.privExponent));
            final Cipher instance = Cipher.getInstance("RSA");
            instance.init(2, generatePrivate);
            return instance.doFinal(input);
        }
        catch (Exception obj) {
            Log.d(DebugProperties.LOG_TAG, "Exception " + obj + " trying to decrypt debug file");
            return null;
        }
    }
    
    static void disableDebugging() {
        DebugProperties.debugModeOn = false;
    }
    
    static void enableDebugging() {
        DebugProperties.debugModeOn = true;
    }
    
    public static Boolean getDebugPropertyAsBoolean(final String key, final Boolean b) {
        if (DebugProperties.debugModeOn) {
            final String property = DebugProperties.debugProperties.getProperty(key);
            if (property != null) {
                try {
                    return Boolean.parseBoolean(property);
                }
                catch (NumberFormatException ex) {
                    Log.e(DebugProperties.LOG_TAG, "Unable to parse boolean debug property - property: %s, value: %s", key, property);
                    return b;
                }
            }
        }
        return b;
    }
    
    public static boolean getDebugPropertyAsBoolean(final String s, final boolean b) {
        return getDebugPropertyAsBoolean(s, Boolean.valueOf(b));
    }
    
    public static int getDebugPropertyAsInteger(final String s, final int i) {
        return getDebugPropertyAsInteger(s, Integer.valueOf(i));
    }
    
    public static Integer getDebugPropertyAsInteger(final String key, final Integer n) {
        if (DebugProperties.debugModeOn) {
            final String property = DebugProperties.debugProperties.getProperty(key);
            if (property != null) {
                try {
                    return Integer.parseInt(property);
                }
                catch (NumberFormatException ex) {
                    Log.e(DebugProperties.LOG_TAG, "Unable to parse integer debug property - property: %s, value: %s", key, property);
                    return n;
                }
            }
        }
        return n;
    }
    
    public static long getDebugPropertyAsLong(final String s, final long l) {
        return getDebugPropertyAsLong(s, Long.valueOf(l));
    }
    
    public static Long getDebugPropertyAsLong(final String key, final Long n) {
        if (DebugProperties.debugModeOn) {
            final String property = DebugProperties.debugProperties.getProperty(key);
            if (property != null) {
                try {
                    return Long.parseLong(property);
                }
                catch (NumberFormatException ex) {
                    Log.e(DebugProperties.LOG_TAG, "Unable to parse long debug property - property: %s, value: %s", key, property);
                    return n;
                }
            }
        }
        return n;
    }
    
    public static String getDebugPropertyAsString(final String key, final String defaultValue) {
        if (!DebugProperties.debugModeOn) {
            return defaultValue;
        }
        return DebugProperties.debugProperties.getProperty(key, defaultValue);
    }
    
    public static boolean isDebugModeOn() {
        return DebugProperties.debugModeOn;
    }
    
    public static void readDebugProperties() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: ldc_w           "mounted"
        //     3: invokestatic    android/os/Environment.getExternalStorageState:()Ljava/lang/String;
        //     6: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //     9: ifeq            59
        //    12: new             Ljava/io/File;
        //    15: dup            
        //    16: new             Ljava/lang/StringBuilder;
        //    19: dup            
        //    20: invokespecial   java/lang/StringBuilder.<init>:()V
        //    23: invokestatic    android/os/Environment.getExternalStorageDirectory:()Ljava/io/File;
        //    26: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    29: ldc             "/com.amazon.device.ads.debug"
        //    31: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    34: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    37: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //    40: astore_0       
        //    41: aload_0        
        //    42: invokevirtual   java/io/File.exists:()Z
        //    45: ifeq            59
        //    48: aload_0        
        //    49: invokevirtual   java/io/File.length:()J
        //    52: ldc2_w          2147483647
        //    55: lcmp           
        //    56: ifle            60
        //    59: return         
        //    60: iconst_0       
        //    61: istore_1       
        //    62: new             Ljava/io/BufferedInputStream;
        //    65: dup            
        //    66: new             Ljava/io/FileInputStream;
        //    69: dup            
        //    70: aload_0        
        //    71: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    74: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //    77: astore_2       
        //    78: aload_0        
        //    79: invokevirtual   java/io/File.length:()J
        //    82: l2i            
        //    83: newarray        B
        //    85: astore          5
        //    87: iload_1        
        //    88: aload           5
        //    90: arraylength    
        //    91: if_icmpge       121
        //    94: aload_2        
        //    95: aload           5
        //    97: iload_1        
        //    98: aload           5
        //   100: arraylength    
        //   101: iload_1        
        //   102: isub           
        //   103: invokevirtual   java/io/InputStream.read:([BII)I
        //   106: istore          8
        //   108: iload           8
        //   110: ifle            87
        //   113: iload_1        
        //   114: iload           8
        //   116: iadd           
        //   117: istore_1       
        //   118: goto            87
        //   121: aload           5
        //   123: invokestatic    com/amazon/device/ads/DebugProperties.decrypt:([B)[B
        //   126: astore          6
        //   128: aload           6
        //   130: ifnull          182
        //   133: new             Ljava/io/ByteArrayInputStream;
        //   136: dup            
        //   137: aload           6
        //   139: invokespecial   java/io/ByteArrayInputStream.<init>:([B)V
        //   142: astore          7
        //   144: getstatic       com/amazon/device/ads/DebugProperties.debugProperties:Ljava/util/Properties;
        //   147: invokevirtual   java/util/Properties.clear:()V
        //   150: getstatic       com/amazon/device/ads/DebugProperties.debugProperties:Ljava/util/Properties;
        //   153: aload           7
        //   155: invokevirtual   java/util/Properties.load:(Ljava/io/InputStream;)V
        //   158: getstatic       com/amazon/device/ads/DebugProperties.debugProperties:Ljava/util/Properties;
        //   161: ldc             "debug.mode"
        //   163: ldc_w           "false"
        //   166: invokevirtual   java/util/Properties.getProperty:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   169: ldc_w           "true"
        //   172: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   175: ifeq            182
        //   178: iconst_1       
        //   179: putstatic       com/amazon/device/ads/DebugProperties.debugModeOn:Z
        //   182: aload_2        
        //   183: invokevirtual   java/io/InputStream.close:()V
        //   186: return         
        //   187: aload_2        
        //   188: ifnull          195
        //   191: aload_2        
        //   192: invokevirtual   java/io/InputStream.close:()V
        //   195: aload_3        
        //   196: athrow         
        //   197: astore_3       
        //   198: goto            187
        //   201: astore          4
        //   203: return         
        //   204: astore_3       
        //   205: aconst_null    
        //   206: astore_2       
        //   207: goto            187
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  62     78     204    210    Any
        //  78     87     197    201    Any
        //  87     108    197    201    Any
        //  121    128    197    201    Any
        //  133    182    197    201    Any
        //  182    186    201    204    Ljava/lang/Exception;
        //  191    195    201    204    Ljava/lang/Exception;
        //  195    197    201    204    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0182:
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
    
    static void setDebugProperty(final String key, final String value) {
        ((Hashtable<String, String>)DebugProperties.debugProperties).put(key, value);
    }
}

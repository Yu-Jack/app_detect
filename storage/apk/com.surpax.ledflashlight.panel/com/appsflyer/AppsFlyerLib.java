// 
// Decompiled by Procyon v0.5.29
// 

package com.appsflyer;

import android.content.Intent;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Bundle;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.content.ContentResolver;
import android.net.Uri;
import android.content.BroadcastReceiver;

public class AppsFlyerLib extends BroadcastReceiver
{
    public static final Uri a;
    private static f b;
    
    static {
        a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
        AppsFlyerLib.b = null;
    }
    
    private static String a(final ContentResolver contentResolver) {
        final Cursor query = contentResolver.query(AppsFlyerLib.a, new String[] { "aid" }, (String)null, (String[])null, (String)null);
        if (query == null || !query.moveToFirst()) {
            return null;
        }
        try {
            final String string = query.getString(query.getColumnIndex("aid"));
            try {
                query.close();
                return string;
            }
            catch (Exception ex2) {
                return string;
            }
        }
        catch (Exception ex) {
            Log.w("AppsFlyer_1.5.2", (Throwable)ex);
            try {
                query.close();
                return null;
            }
            catch (Exception ex3) {
                return null;
            }
        }
        finally {
            try {
                query.close();
            }
            catch (Exception ex4) {}
        }
    }
    
    public static void a(final Context context) {
        String a = d.a().a(context);
        if (a == null) {
            a = "";
        }
        Executors.newScheduledThreadPool(1).schedule(new b(context, a, (byte)0), 5L, TimeUnit.MILLISECONDS);
        d.a().d();
    }
    
    public static void a(final String s) {
        d.a().a("AppsFlyerKey", s);
    }
    
    private static String b(final Context context, final String s) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("appsflyer-data", 0);
        if (sharedPreferences.contains("CACHED_CHANNEL")) {
            return sharedPreferences.getString("CACHED_CHANNEL", (String)null);
        }
        final SharedPreferences$Editor edit = sharedPreferences.edit();
        edit.putString("CACHED_CHANNEL", s);
        edit.commit();
        return s;
    }
    
    public static Map b(final Context context) {
        final SharedPreferences sharedPreferences = context.getSharedPreferences("appsflyer-data", 0);
        final String a = d.a().a(context);
        if (a != null && a.length() > 0 && a.contains("af_tranid")) {
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            final int index = a.indexOf(38);
            if (index >= 0 && a.length() > index + 1) {
                final String[] split = a.split("\\&");
                for (int length = split.length, i = 0; i < length; ++i) {
                    final String[] split2 = split[i].split("=");
                    final String s = split2[0];
                    String s2;
                    if (split2.length > 1) {
                        s2 = split2[1];
                    }
                    else {
                        s2 = "";
                    }
                    hashMap.put(s, s2);
                }
            }
            return hashMap;
        }
        final String string = sharedPreferences.getString("attributionId", (String)null);
        if (string != null && string.length() > 0) {
            return c(string);
        }
        throw new e();
    }
    
    private static void b(final Context p0, final String p1, final String p2, final String p3, final String p4) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: ldc             "AppsFlyer_1.5.2"
        //     2: new             Ljava/lang/StringBuilder;
        //     5: dup            
        //     6: ldc             "Start tracking package: "
        //     8: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    11: aload_0        
        //    12: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //    15: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    18: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    21: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //    24: pop            
        //    25: ldc             "collect data for server"
        //    27: ldc             ""
        //    29: aload_0        
        //    30: invokestatic    com/appsflyer/AppsFlyerLib.b:(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
        //    33: ldc             "AppsFlyer_1.5.2"
        //    35: ldc             "******* sendTrackingWithEvent: "
        //    37: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //    40: pop            
        //    41: ldc             "********* sendTrackingWithEvent: "
        //    43: aload_2        
        //    44: aload_0        
        //    45: invokestatic    com/appsflyer/AppsFlyerLib.b:(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
        //    48: aload_0        
        //    49: invokevirtual   android/content/Context.getPackageManager:()Landroid/content/pm/PackageManager;
        //    52: aload_0        
        //    53: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //    56: sipush          4096
        //    59: invokevirtual   android/content/pm/PackageManager.getPackageInfo:(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
        //    62: getfield        android/content/pm/PackageInfo.requestedPermissions:[Ljava/lang/String;
        //    65: invokestatic    java/util/Arrays.asList:([Ljava/lang/Object;)Ljava/util/List;
        //    68: astore          106
        //    70: aload           106
        //    72: ldc             "android.permission.INTERNET"
        //    74: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //    79: ifne            91
        //    82: ldc             "AppsFlyer_1.5.2"
        //    84: ldc_w           "Permission android.permission.INTERNET is missing in the AndroidManifest.xml"
        //    87: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //    90: pop            
        //    91: aload           106
        //    93: ldc_w           "android.permission.ACCESS_NETWORK_STATE"
        //    96: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //   101: ifne            113
        //   104: ldc             "AppsFlyer_1.5.2"
        //   106: ldc_w           "Permission android.permission.ACCESS_NETWORK_STATE is missing in the AndroidManifest.xml"
        //   109: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   112: pop            
        //   113: aload           106
        //   115: ldc_w           "android.permission.ACCESS_WIFI_STATE"
        //   118: invokeinterface java/util/List.contains:(Ljava/lang/Object;)Z
        //   123: ifne            135
        //   126: ldc             "AppsFlyer_1.5.2"
        //   128: ldc_w           "Permission android.permission.ACCESS_WIFI_STATE is missing in the AndroidManifest.xml"
        //   131: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   134: pop            
        //   135: new             Ljava/lang/StringBuilder;
        //   138: dup            
        //   139: invokespecial   java/lang/StringBuilder.<init>:()V
        //   142: astore          10
        //   144: aload           10
        //   146: ldc_w           "https://track.appsflyer.com/api/v2.3/androidevent?buildnumber=1.5.2&app_id="
        //   149: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   152: aload_0        
        //   153: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //   156: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   159: pop            
        //   160: new             Ljava/util/HashMap;
        //   163: dup            
        //   164: invokespecial   java/util/HashMap.<init>:()V
        //   167: astore          12
        //   169: aload           12
        //   171: ldc_w           "brand"
        //   174: getstatic       android/os/Build.BRAND:Ljava/lang/String;
        //   177: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   182: pop            
        //   183: aload           12
        //   185: ldc_w           "device"
        //   188: getstatic       android/os/Build.DEVICE:Ljava/lang/String;
        //   191: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   196: pop            
        //   197: aload           12
        //   199: ldc_w           "product"
        //   202: getstatic       android/os/Build.PRODUCT:Ljava/lang/String;
        //   205: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   210: pop            
        //   211: aload           12
        //   213: ldc_w           "sdk"
        //   216: getstatic       android/os/Build$VERSION.SDK_INT:I
        //   219: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //   222: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   227: pop            
        //   228: aload           12
        //   230: ldc_w           "model"
        //   233: getstatic       android/os/Build.MODEL:Ljava/lang/String;
        //   236: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   241: pop            
        //   242: aload           12
        //   244: ldc_w           "deviceType"
        //   247: getstatic       android/os/Build.TYPE:Ljava/lang/String;
        //   250: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   255: pop            
        //   256: aload_0        
        //   257: invokestatic    com/appsflyer/AppsFlyerLib.e:(Landroid/content/Context;)Ljava/lang/String;
        //   260: astore          19
        //   262: aload_0        
        //   263: aload           19
        //   265: invokestatic    com/appsflyer/AppsFlyerLib.b:(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
        //   268: astore          20
        //   270: aload           20
        //   272: ifnull          288
        //   275: aload           12
        //   277: ldc_w           "channel"
        //   280: aload           20
        //   282: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   287: pop            
        //   288: aload           20
        //   290: ifnull          1640
        //   293: aload           20
        //   295: aload           19
        //   297: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   300: ifeq            306
        //   303: goto            1640
        //   306: aload           12
        //   308: ldc_w           "af_latestchannel"
        //   311: aload           19
        //   313: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   318: pop            
        //   319: aload_1        
        //   320: ifnull          330
        //   323: aload_1        
        //   324: invokevirtual   java/lang/String.length:()I
        //   327: ifne            339
        //   330: invokestatic    com/appsflyer/d.a:()Lcom/appsflyer/d;
        //   333: ldc             "AppsFlyerKey"
        //   335: invokevirtual   com/appsflyer/d.a:(Ljava/lang/String;)Ljava/lang/String;
        //   338: astore_1       
        //   339: aload_1        
        //   340: ifnull          1391
        //   343: aload_1        
        //   344: invokevirtual   java/lang/String.length:()I
        //   347: ifle            1391
        //   350: aload           12
        //   352: ldc_w           "appsflyerKey"
        //   355: aload_1        
        //   356: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   361: pop            
        //   362: aload_1        
        //   363: invokevirtual   java/lang/String.length:()I
        //   366: bipush          8
        //   368: if_icmple       389
        //   371: aload           12
        //   373: ldc_w           "dkh"
        //   376: aload_1        
        //   377: iconst_0       
        //   378: bipush          8
        //   380: invokevirtual   java/lang/String.substring:(II)Ljava/lang/String;
        //   383: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   388: pop            
        //   389: invokestatic    com/appsflyer/d.a:()Lcom/appsflyer/d;
        //   392: ldc_w           "AppUserId"
        //   395: invokevirtual   com/appsflyer/d.a:(Ljava/lang/String;)Ljava/lang/String;
        //   398: astore          25
        //   400: aload           25
        //   402: ifnull          418
        //   405: aload           12
        //   407: ldc_w           "appUserId"
        //   410: aload           25
        //   412: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   417: pop            
        //   418: aload_2        
        //   419: ifnull          450
        //   422: aload_3        
        //   423: ifnull          450
        //   426: aload           12
        //   428: ldc_w           "eventName"
        //   431: aload_2        
        //   432: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   437: pop            
        //   438: aload           12
        //   440: ldc_w           "eventValue"
        //   443: aload_3        
        //   444: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   449: pop            
        //   450: invokestatic    com/appsflyer/d.a:()Lcom/appsflyer/d;
        //   453: ldc_w           "appid"
        //   456: invokevirtual   com/appsflyer/d.a:(Ljava/lang/String;)Ljava/lang/String;
        //   459: ifnull          482
        //   462: aload           12
        //   464: ldc_w           "appid"
        //   467: invokestatic    com/appsflyer/d.a:()Lcom/appsflyer/d;
        //   470: ldc_w           "appid"
        //   473: invokevirtual   com/appsflyer/d.a:(Ljava/lang/String;)Ljava/lang/String;
        //   476: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   481: pop            
        //   482: invokestatic    com/appsflyer/d.a:()Lcom/appsflyer/d;
        //   485: ldc_w           "currencyCode"
        //   488: invokevirtual   com/appsflyer/d.a:(Ljava/lang/String;)Ljava/lang/String;
        //   491: astore          27
        //   493: aload           27
        //   495: ifnull          550
        //   498: aload           27
        //   500: invokevirtual   java/lang/String.length:()I
        //   503: iconst_3       
        //   504: if_icmpeq       537
        //   507: ldc             "AppsFlyer_1.5.2"
        //   509: new             Ljava/lang/StringBuilder;
        //   512: dup            
        //   513: ldc_w           "WARNING:currency code should be 3 characters!!! '"
        //   516: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   519: aload           27
        //   521: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   524: ldc_w           "' is not a legal value."
        //   527: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   530: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   533: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   536: pop            
        //   537: aload           12
        //   539: ldc_w           "currency"
        //   542: aload           27
        //   544: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   549: pop            
        //   550: invokestatic    com/appsflyer/d.a:()Lcom/appsflyer/d;
        //   553: ldc_w           "IS_UPDATE"
        //   556: invokevirtual   com/appsflyer/d.a:(Ljava/lang/String;)Ljava/lang/String;
        //   559: astore          29
        //   561: aload           29
        //   563: ifnull          579
        //   566: aload           12
        //   568: ldc_w           "isUpdate"
        //   571: aload           29
        //   573: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   578: pop            
        //   579: aload           12
        //   581: ldc_w           "af_preinstalled"
        //   584: aload_0        
        //   585: invokestatic    com/appsflyer/AppsFlyerLib.f:(Landroid/content/Context;)Z
        //   588: invokestatic    java/lang/Boolean.toString:(Z)Ljava/lang/String;
        //   591: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   596: pop            
        //   597: aload_0        
        //   598: invokevirtual   android/content/Context.getContentResolver:()Landroid/content/ContentResolver;
        //   601: invokestatic    com/appsflyer/AppsFlyerLib.a:(Landroid/content/ContentResolver;)Ljava/lang/String;
        //   604: astore          32
        //   606: aload           32
        //   608: ifnull          624
        //   611: aload           12
        //   613: ldc_w           "fb"
        //   616: aload           32
        //   618: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   623: pop            
        //   624: invokestatic    com/appsflyer/d.a:()Lcom/appsflyer/d;
        //   627: ldc_w           "deviceTrackingDisabled"
        //   630: iconst_0       
        //   631: invokevirtual   com/appsflyer/d.a:(Ljava/lang/String;Z)Z
        //   634: ifeq            651
        //   637: aload           12
        //   639: ldc_w           "deviceTrackingDisabled"
        //   642: ldc_w           "true"
        //   645: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   650: pop            
        //   651: invokestatic    com/appsflyer/d.a:()Lcom/appsflyer/d;
        //   654: ldc_w           "collectIMEI"
        //   657: iconst_1       
        //   658: invokevirtual   com/appsflyer/d.a:(Ljava/lang/String;Z)Z
        //   661: istore          34
        //   663: iload           34
        //   665: ifeq            701
        //   668: aload_0        
        //   669: ldc_w           "phone"
        //   672: invokevirtual   android/content/Context.getSystemService:(Ljava/lang/String;)Ljava/lang/Object;
        //   675: checkcast       Landroid/telephony/TelephonyManager;
        //   678: invokevirtual   android/telephony/TelephonyManager.getDeviceId:()Ljava/lang/String;
        //   681: astore          97
        //   683: aload           97
        //   685: ifnull          701
        //   688: aload           12
        //   690: ldc_w           "imei"
        //   693: aload           97
        //   695: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   700: pop            
        //   701: invokestatic    com/appsflyer/d.a:()Lcom/appsflyer/d;
        //   704: ldc_w           "collectAndroidId"
        //   707: iconst_1       
        //   708: invokevirtual   com/appsflyer/d.a:(Ljava/lang/String;Z)Z
        //   711: istore          35
        //   713: iload           35
        //   715: ifeq            748
        //   718: aload_0        
        //   719: invokevirtual   android/content/Context.getContentResolver:()Landroid/content/ContentResolver;
        //   722: ldc_w           "android_id"
        //   725: invokestatic    android/provider/Settings$Secure.getString:(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
        //   728: astore          93
        //   730: aload           93
        //   732: ifnull          748
        //   735: aload           12
        //   737: ldc_w           "android_id"
        //   740: aload           93
        //   742: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   747: pop            
        //   748: aload_0        
        //   749: invokestatic    com/appsflyer/j.a:(Landroid/content/Context;)Ljava/lang/String;
        //   752: astore          90
        //   754: aload           90
        //   756: ifnull          772
        //   759: aload           12
        //   761: ldc_w           "uid"
        //   764: aload           90
        //   766: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   771: pop            
        //   772: aload           12
        //   774: ldc_w           "lang"
        //   777: invokestatic    java/util/Locale.getDefault:()Ljava/util/Locale;
        //   780: invokevirtual   java/util/Locale.getDisplayLanguage:()Ljava/lang/String;
        //   783: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   788: pop            
        //   789: aload_0        
        //   790: ldc_w           "phone"
        //   793: invokevirtual   android/content/Context.getSystemService:(Ljava/lang/String;)Ljava/lang/Object;
        //   796: checkcast       Landroid/telephony/TelephonyManager;
        //   799: astore          86
        //   801: aload           12
        //   803: ldc_w           "operator"
        //   806: aload           86
        //   808: invokevirtual   android/telephony/TelephonyManager.getSimOperatorName:()Ljava/lang/String;
        //   811: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   816: pop            
        //   817: aload           12
        //   819: ldc_w           "carrier"
        //   822: aload           86
        //   824: invokevirtual   android/telephony/TelephonyManager.getNetworkOperatorName:()Ljava/lang/String;
        //   827: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   832: pop            
        //   833: aload_0        
        //   834: ldc_w           "connectivity"
        //   837: invokevirtual   android/content/Context.getSystemService:(Ljava/lang/String;)Ljava/lang/Object;
        //   840: checkcast       Landroid/net/ConnectivityManager;
        //   843: astore          83
        //   845: aload           83
        //   847: iconst_1       
        //   848: invokevirtual   android/net/ConnectivityManager.getNetworkInfo:(I)Landroid/net/NetworkInfo;
        //   851: invokevirtual   android/net/NetworkInfo.isConnectedOrConnecting:()Z
        //   854: ifeq            1469
        //   857: ldc_w           "WIFI"
        //   860: astore          84
        //   862: aload           12
        //   864: ldc_w           "network"
        //   867: aload           84
        //   869: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   874: pop            
        //   875: invokestatic    com/appsflyer/d.a:()Lcom/appsflyer/d;
        //   878: ldc_w           "collectMAC"
        //   881: iconst_1       
        //   882: invokevirtual   com/appsflyer/d.a:(Ljava/lang/String;Z)Z
        //   885: istore          42
        //   887: iload           42
        //   889: ifeq            928
        //   892: aload_0        
        //   893: ldc_w           "wifi"
        //   896: invokevirtual   android/content/Context.getSystemService:(Ljava/lang/String;)Ljava/lang/Object;
        //   899: checkcast       Landroid/net/wifi/WifiManager;
        //   902: invokevirtual   android/net/wifi/WifiManager.getConnectionInfo:()Landroid/net/wifi/WifiInfo;
        //   905: invokevirtual   android/net/wifi/WifiInfo.getMacAddress:()Ljava/lang/String;
        //   908: astore          81
        //   910: aload           81
        //   912: ifnull          928
        //   915: aload           12
        //   917: ldc_w           "mac"
        //   920: aload           81
        //   922: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   927: pop            
        //   928: ldc_w           "com.google.android.gms.ads.identifier.AdvertisingIdClient"
        //   931: invokestatic    java/lang/Class.forName:(Ljava/lang/String;)Ljava/lang/Class;
        //   934: pop            
        //   935: aload_0        
        //   936: invokestatic    com/google/android/gms/ads/identifier/AdvertisingIdClient.getAdvertisingIdInfo:(Landroid/content/Context;)Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$Info;
        //   939: astore          76
        //   941: aload           12
        //   943: ldc_w           "advertiserId"
        //   946: aload           76
        //   948: invokevirtual   com/google/android/gms/ads/identifier/AdvertisingIdClient$Info.getId:()Ljava/lang/String;
        //   951: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   956: pop            
        //   957: aload           76
        //   959: invokevirtual   com/google/android/gms/ads/identifier/AdvertisingIdClient$Info.isLimitAdTrackingEnabled:()Z
        //   962: ifne            1653
        //   965: iconst_1       
        //   966: istore          78
        //   968: aload           12
        //   970: ldc_w           "advertiserIdEnabled"
        //   973: iload           78
        //   975: invokestatic    java/lang/Boolean.toString:(Z)Ljava/lang/String;
        //   978: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   983: pop            
        //   984: new             Ljava/text/SimpleDateFormat;
        //   987: dup            
        //   988: ldc_w           "yyyy-MM-dd_hhmmZ"
        //   991: invokespecial   java/text/SimpleDateFormat.<init>:(Ljava/lang/String;)V
        //   994: astore          45
        //   996: getstatic       android/os/Build$VERSION.SDK_INT:I
        //   999: istore          46
        //  1001: iload           46
        //  1003: bipush          9
        //  1005: if_icmplt       1046
        //  1008: aload           12
        //  1010: ldc_w           "installDate"
        //  1013: aload           45
        //  1015: new             Ljava/util/Date;
        //  1018: dup            
        //  1019: aload_0        
        //  1020: invokevirtual   android/content/Context.getPackageManager:()Landroid/content/pm/PackageManager;
        //  1023: aload_0        
        //  1024: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //  1027: iconst_0       
        //  1028: invokevirtual   android/content/pm/PackageManager.getPackageInfo:(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
        //  1031: getfield        android/content/pm/PackageInfo.firstInstallTime:J
        //  1034: invokespecial   java/util/Date.<init>:(J)V
        //  1037: invokevirtual   java/text/SimpleDateFormat.format:(Ljava/util/Date;)Ljava/lang/String;
        //  1040: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  1045: pop            
        //  1046: aload_0        
        //  1047: invokevirtual   android/content/Context.getPackageManager:()Landroid/content/pm/PackageManager;
        //  1050: aload_0        
        //  1051: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //  1054: iconst_0       
        //  1055: invokevirtual   android/content/pm/PackageManager.getPackageInfo:(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
        //  1058: astore          53
        //  1060: aload           12
        //  1062: ldc_w           "app_version_code"
        //  1065: aload           53
        //  1067: getfield        android/content/pm/PackageInfo.versionCode:I
        //  1070: invokestatic    java/lang/Integer.toString:(I)Ljava/lang/String;
        //  1073: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  1078: pop            
        //  1079: aload           12
        //  1081: ldc_w           "app_version_name"
        //  1084: aload           53
        //  1086: getfield        android/content/pm/PackageInfo.versionName:Ljava/lang/String;
        //  1089: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  1094: pop            
        //  1095: aload           53
        //  1097: getfield        android/content/pm/PackageInfo.firstInstallTime:J
        //  1100: lstore          56
        //  1102: aload           53
        //  1104: getfield        android/content/pm/PackageInfo.lastUpdateTime:J
        //  1107: lstore          58
        //  1109: aload           12
        //  1111: ldc_w           "date1"
        //  1114: aload           45
        //  1116: new             Ljava/util/Date;
        //  1119: dup            
        //  1120: lload           56
        //  1122: invokespecial   java/util/Date.<init>:(J)V
        //  1125: invokevirtual   java/text/SimpleDateFormat.format:(Ljava/util/Date;)Ljava/lang/String;
        //  1128: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  1133: pop            
        //  1134: aload           12
        //  1136: ldc_w           "date2"
        //  1139: aload           45
        //  1141: new             Ljava/util/Date;
        //  1144: dup            
        //  1145: lload           58
        //  1147: invokespecial   java/util/Date.<init>:(J)V
        //  1150: invokevirtual   java/text/SimpleDateFormat.format:(Ljava/util/Date;)Ljava/lang/String;
        //  1153: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  1158: pop            
        //  1159: aload_0        
        //  1160: ldc             "appsflyer-data"
        //  1162: iconst_0       
        //  1163: invokevirtual   android/content/Context.getSharedPreferences:(Ljava/lang/String;I)Landroid/content/SharedPreferences;
        //  1166: astore          62
        //  1168: aload           62
        //  1170: ldc_w           "appsFlyerFirstInstall"
        //  1173: aconst_null    
        //  1174: invokeinterface android/content/SharedPreferences.getString:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //  1179: astore          63
        //  1181: aload           63
        //  1183: ifnonnull       1254
        //  1186: aload           62
        //  1188: ldc_w           "appsFlyerCount"
        //  1191: iconst_1       
        //  1192: invokeinterface android/content/SharedPreferences.getInt:(Ljava/lang/String;I)I
        //  1197: iconst_2       
        //  1198: if_icmpge       1593
        //  1201: ldc             "AppsFlyer_1.5.2"
        //  1203: ldc_w           "AppsFlyer: first launch detected"
        //  1206: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //  1209: pop            
        //  1210: aload           45
        //  1212: new             Ljava/util/Date;
        //  1215: dup            
        //  1216: invokespecial   java/util/Date.<init>:()V
        //  1219: invokevirtual   java/text/SimpleDateFormat.format:(Ljava/util/Date;)Ljava/lang/String;
        //  1222: astore          63
        //  1224: aload           62
        //  1226: invokeinterface android/content/SharedPreferences.edit:()Landroid/content/SharedPreferences$Editor;
        //  1231: astore          64
        //  1233: aload           64
        //  1235: ldc_w           "appsFlyerFirstInstall"
        //  1238: aload           63
        //  1240: invokeinterface android/content/SharedPreferences$Editor.putString:(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;
        //  1245: pop            
        //  1246: aload           64
        //  1248: invokeinterface android/content/SharedPreferences$Editor.commit:()Z
        //  1253: pop            
        //  1254: ldc             "AppsFlyer_1.5.2"
        //  1256: new             Ljava/lang/StringBuilder;
        //  1259: dup            
        //  1260: ldc_w           "AppsFlyer: first launch date: "
        //  1263: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  1266: aload           63
        //  1268: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1271: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1274: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //  1277: pop            
        //  1278: aload           12
        //  1280: ldc_w           "firstLaunchDate"
        //  1283: aload           63
        //  1285: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  1290: pop            
        //  1291: aload           4
        //  1293: invokevirtual   java/lang/String.length:()I
        //  1296: ifle            1312
        //  1299: aload           12
        //  1301: ldc_w           "referrer"
        //  1304: aload           4
        //  1306: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  1311: pop            
        //  1312: aload_0        
        //  1313: ldc             "appsflyer-data"
        //  1315: iconst_0       
        //  1316: invokevirtual   android/content/Context.getSharedPreferences:(Ljava/lang/String;I)Landroid/content/SharedPreferences;
        //  1319: ldc             "attributionId"
        //  1321: aconst_null    
        //  1322: invokeinterface android/content/SharedPreferences.getString:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //  1327: astore          48
        //  1329: aload           48
        //  1331: ifnull          1355
        //  1334: aload           48
        //  1336: invokevirtual   java/lang/String.length:()I
        //  1339: ifle            1355
        //  1342: aload           12
        //  1344: ldc_w           "installAttribution"
        //  1347: aload           48
        //  1349: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //  1354: pop            
        //  1355: iconst_1       
        //  1356: invokestatic    java/util/concurrent/Executors.newScheduledThreadPool:(I)Ljava/util/concurrent/ScheduledExecutorService;
        //  1359: new             Lcom/appsflyer/c;
        //  1362: dup            
        //  1363: aload           10
        //  1365: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1368: aload           12
        //  1370: aload_0        
        //  1371: invokevirtual   android/content/Context.getApplicationContext:()Landroid/content/Context;
        //  1374: iconst_0       
        //  1375: invokespecial   com/appsflyer/c.<init>:(Ljava/lang/String;Ljava/util/Map;Landroid/content/Context;B)V
        //  1378: ldc2_w          100
        //  1381: getstatic       java/util/concurrent/TimeUnit.MILLISECONDS:Ljava/util/concurrent/TimeUnit;
        //  1384: invokeinterface java/util/concurrent/ScheduledExecutorService.schedule:(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
        //  1389: pop            
        //  1390: return         
        //  1391: ldc             "AppsFlyer_1.5.2"
        //  1393: ldc_w           "AppsFlyer dev key is missing!!! Please use  AppsFlyerLib.setAppsFlyerKey(...) to set it. "
        //  1396: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //  1399: pop            
        //  1400: ldc             "AppsFlyer_1.5.2"
        //  1402: ldc_w           "AppsFlyer will not track this event."
        //  1405: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //  1408: pop            
        //  1409: return         
        //  1410: astore          5
        //  1412: ldc             "AppsFlyer_1.5.2"
        //  1414: ldc             ""
        //  1416: aload           5
        //  1418: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
        //  1421: pop            
        //  1422: return         
        //  1423: astore          95
        //  1425: ldc             "AppsFlyer_1.5.2"
        //  1427: ldc_w           "WARNING:READ_PHONE_STATE is missing"
        //  1430: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //  1433: pop            
        //  1434: goto            701
        //  1437: astore          36
        //  1439: ldc             "AppsFlyer_1.5.2"
        //  1441: new             Ljava/lang/StringBuilder;
        //  1444: dup            
        //  1445: ldc_w           "ERROR:ERROR:could not get uid "
        //  1448: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  1451: aload           36
        //  1453: invokevirtual   java/lang/Exception.getMessage:()Ljava/lang/String;
        //  1456: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1459: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1462: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //  1465: pop            
        //  1466: goto            772
        //  1469: aload           83
        //  1471: iconst_0       
        //  1472: invokevirtual   android/net/ConnectivityManager.getNetworkInfo:(I)Landroid/net/NetworkInfo;
        //  1475: invokevirtual   android/net/NetworkInfo.isConnectedOrConnecting:()Z
        //  1478: ifeq            1489
        //  1481: ldc_w           "MOBILE"
        //  1484: astore          84
        //  1486: goto            862
        //  1489: ldc_w           "unkown"
        //  1492: astore          84
        //  1494: goto            862
        //  1497: astore          40
        //  1499: ldc             "AppsFlyer_1.5.2"
        //  1501: new             Ljava/lang/StringBuilder;
        //  1504: dup            
        //  1505: ldc_w           "checking network error "
        //  1508: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //  1511: aload           40
        //  1513: invokevirtual   java/lang/Exception.getMessage:()Ljava/lang/String;
        //  1516: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //  1519: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //  1522: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //  1525: pop            
        //  1526: goto            875
        //  1529: astore          73
        //  1531: ldc             "AppsFlyer_1.5.2"
        //  1533: ldc_w           "WARNING:Google Play services SDK is missing."
        //  1536: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //  1539: pop            
        //  1540: goto            984
        //  1543: astore          43
        //  1545: aload           43
        //  1547: invokevirtual   java/lang/Exception.getLocalizedMessage:()Ljava/lang/String;
        //  1550: ifnull          1579
        //  1553: ldc             "AppsFlyer_1.5.2"
        //  1555: aload           43
        //  1557: invokevirtual   java/lang/Exception.getLocalizedMessage:()Ljava/lang/String;
        //  1560: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //  1563: pop            
        //  1564: ldc_w           "Could not fetch advertiser id: "
        //  1567: aload           43
        //  1569: invokevirtual   java/lang/Exception.getLocalizedMessage:()Ljava/lang/String;
        //  1572: aload_0        
        //  1573: invokestatic    com/appsflyer/AppsFlyerLib.b:(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
        //  1576: goto            984
        //  1579: ldc             "AppsFlyer_1.5.2"
        //  1581: aload           43
        //  1583: invokevirtual   java/lang/Exception.toString:()Ljava/lang/String;
        //  1586: invokestatic    android/util/Log.i:(Ljava/lang/String;Ljava/lang/String;)I
        //  1589: pop            
        //  1590: goto            1564
        //  1593: ldc             ""
        //  1595: astore          63
        //  1597: goto            1224
        //  1600: astore          52
        //  1602: goto            1291
        //  1605: astore          47
        //  1607: goto            1291
        //  1610: astore          70
        //  1612: goto            1046
        //  1615: astore          80
        //  1617: goto            928
        //  1620: astore          39
        //  1622: goto            833
        //  1625: astore          38
        //  1627: goto            789
        //  1630: astore          92
        //  1632: goto            748
        //  1635: astore          9
        //  1637: goto            135
        //  1640: aload           20
        //  1642: ifnonnull       319
        //  1645: aload           19
        //  1647: ifnull          319
        //  1650: goto            306
        //  1653: iconst_0       
        //  1654: istore          78
        //  1656: goto            968
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                     
        //  -----  -----  -----  -----  ---------------------------------------------------------
        //  0      48     1410   1423   Ljava/lang/Throwable;
        //  48     91     1635   1640   Ljava/lang/Exception;
        //  48     91     1410   1423   Ljava/lang/Throwable;
        //  91     113    1635   1640   Ljava/lang/Exception;
        //  91     113    1410   1423   Ljava/lang/Throwable;
        //  113    135    1635   1640   Ljava/lang/Exception;
        //  113    135    1410   1423   Ljava/lang/Throwable;
        //  135    270    1410   1423   Ljava/lang/Throwable;
        //  275    288    1410   1423   Ljava/lang/Throwable;
        //  293    303    1410   1423   Ljava/lang/Throwable;
        //  306    319    1410   1423   Ljava/lang/Throwable;
        //  323    330    1410   1423   Ljava/lang/Throwable;
        //  330    339    1410   1423   Ljava/lang/Throwable;
        //  343    389    1410   1423   Ljava/lang/Throwable;
        //  389    400    1410   1423   Ljava/lang/Throwable;
        //  405    418    1410   1423   Ljava/lang/Throwable;
        //  426    450    1410   1423   Ljava/lang/Throwable;
        //  450    482    1410   1423   Ljava/lang/Throwable;
        //  482    493    1410   1423   Ljava/lang/Throwable;
        //  498    537    1410   1423   Ljava/lang/Throwable;
        //  537    550    1410   1423   Ljava/lang/Throwable;
        //  550    561    1410   1423   Ljava/lang/Throwable;
        //  566    579    1410   1423   Ljava/lang/Throwable;
        //  579    606    1410   1423   Ljava/lang/Throwable;
        //  611    624    1410   1423   Ljava/lang/Throwable;
        //  624    651    1410   1423   Ljava/lang/Throwable;
        //  651    663    1410   1423   Ljava/lang/Throwable;
        //  668    683    1423   1437   Ljava/lang/Exception;
        //  668    683    1410   1423   Ljava/lang/Throwable;
        //  688    701    1423   1437   Ljava/lang/Exception;
        //  688    701    1410   1423   Ljava/lang/Throwable;
        //  701    713    1410   1423   Ljava/lang/Throwable;
        //  718    730    1630   1635   Ljava/lang/Exception;
        //  718    730    1410   1423   Ljava/lang/Throwable;
        //  735    748    1630   1635   Ljava/lang/Exception;
        //  735    748    1410   1423   Ljava/lang/Throwable;
        //  748    754    1437   1469   Ljava/lang/Exception;
        //  748    754    1410   1423   Ljava/lang/Throwable;
        //  759    772    1437   1469   Ljava/lang/Exception;
        //  759    772    1410   1423   Ljava/lang/Throwable;
        //  772    789    1625   1630   Ljava/lang/Exception;
        //  772    789    1410   1423   Ljava/lang/Throwable;
        //  789    833    1620   1625   Ljava/lang/Exception;
        //  789    833    1410   1423   Ljava/lang/Throwable;
        //  833    857    1497   1529   Ljava/lang/Exception;
        //  833    857    1410   1423   Ljava/lang/Throwable;
        //  862    875    1497   1529   Ljava/lang/Exception;
        //  862    875    1410   1423   Ljava/lang/Throwable;
        //  875    887    1410   1423   Ljava/lang/Throwable;
        //  892    910    1615   1620   Ljava/lang/Exception;
        //  892    910    1410   1423   Ljava/lang/Throwable;
        //  915    928    1615   1620   Ljava/lang/Exception;
        //  915    928    1410   1423   Ljava/lang/Throwable;
        //  928    965    1529   1543   Ljava/lang/ClassNotFoundException;
        //  928    965    1543   1593   Ljava/lang/Exception;
        //  928    965    1410   1423   Ljava/lang/Throwable;
        //  968    984    1529   1543   Ljava/lang/ClassNotFoundException;
        //  968    984    1543   1593   Ljava/lang/Exception;
        //  968    984    1410   1423   Ljava/lang/Throwable;
        //  984    1001   1410   1423   Ljava/lang/Throwable;
        //  1008   1046   1610   1615   Ljava/lang/Exception;
        //  1008   1046   1410   1423   Ljava/lang/Throwable;
        //  1046   1181   1605   1610   Landroid/content/pm/PackageManager$NameNotFoundException;
        //  1046   1181   1600   1605   Ljava/lang/NoSuchFieldError;
        //  1046   1181   1410   1423   Ljava/lang/Throwable;
        //  1186   1224   1605   1610   Landroid/content/pm/PackageManager$NameNotFoundException;
        //  1186   1224   1600   1605   Ljava/lang/NoSuchFieldError;
        //  1186   1224   1410   1423   Ljava/lang/Throwable;
        //  1224   1254   1605   1610   Landroid/content/pm/PackageManager$NameNotFoundException;
        //  1224   1254   1600   1605   Ljava/lang/NoSuchFieldError;
        //  1224   1254   1410   1423   Ljava/lang/Throwable;
        //  1254   1291   1605   1610   Landroid/content/pm/PackageManager$NameNotFoundException;
        //  1254   1291   1600   1605   Ljava/lang/NoSuchFieldError;
        //  1254   1291   1410   1423   Ljava/lang/Throwable;
        //  1291   1312   1410   1423   Ljava/lang/Throwable;
        //  1312   1329   1410   1423   Ljava/lang/Throwable;
        //  1334   1355   1410   1423   Ljava/lang/Throwable;
        //  1355   1390   1410   1423   Ljava/lang/Throwable;
        //  1391   1409   1410   1423   Ljava/lang/Throwable;
        //  1425   1434   1410   1423   Ljava/lang/Throwable;
        //  1439   1466   1410   1423   Ljava/lang/Throwable;
        //  1469   1481   1497   1529   Ljava/lang/Exception;
        //  1469   1481   1410   1423   Ljava/lang/Throwable;
        //  1499   1526   1410   1423   Ljava/lang/Throwable;
        //  1531   1540   1410   1423   Ljava/lang/Throwable;
        //  1545   1564   1410   1423   Ljava/lang/Throwable;
        //  1564   1576   1410   1423   Ljava/lang/Throwable;
        //  1579   1590   1410   1423   Ljava/lang/Throwable;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0091:
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
    
    private static void b(final String str, final String str2, final Context context) {
        if (context != null && "com.appsflyer".equals(context.getPackageName())) {
            g.a().a(str + str2);
        }
    }
    
    public static String c(final Context context) {
        return j.a(context);
    }
    
    private static Map c(final String s) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        try {
            final JSONObject jsonObject = new JSONObject(s);
            final Iterator keys = jsonObject.keys();
            while (keys.hasNext()) {
                final String s2 = keys.next();
                hashMap.put(s2, jsonObject.getString(s2));
            }
        }
        catch (JSONException ex) {
            Log.w("AppsFlyer_1.5.2", (Throwable)ex);
            return null;
        }
        return hashMap;
    }
    
    private static String e(final Context context) {
        String a = d.a().a("channel");
        if (a == null) {
            String string = null;
            Label_0101: {
                try {
                    final Bundle metaData = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (metaData != null) {
                        final Object value = metaData.get("CHANNEL");
                        if (value != null) {
                            if (value instanceof String) {
                                string = (String)value;
                                break Label_0101;
                            }
                            string = value.toString();
                            break Label_0101;
                        }
                    }
                }
                catch (Exception ex) {
                    Log.e("AppsFlyer_1.5.2", "Could not load CHANNEL value", (Throwable)ex);
                    return a;
                }
                string = a;
            }
            a = string;
        }
        return a;
    }
    
    private static boolean f(final Context context) {
        try {
            final int n = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags & 0x1;
            boolean b = false;
            if (n != 0) {
                b = true;
            }
            return b;
        }
        catch (PackageManager$NameNotFoundException ex) {
            Log.e("AppsFlyer_1.5.2", "Could not check if app is pre installed", (Throwable)ex);
            return false;
        }
    }
    
    public void onReceive(final Context context, final Intent intent) {
        Log.i("AppsFlyer_1.5.2", "****** onReceive called *******");
        b("******* onReceive: ", "", context);
        d.a().b();
        final String stringExtra = intent.getStringExtra("referrer");
        Log.i("AppsFlyer_1.5.2", "referrer=" + stringExtra);
        if (stringExtra != null) {
            b("BroadcastReceiver got referrer: ", stringExtra, context);
            b("onRecieve called. refferer=", stringExtra, context);
            final SharedPreferences$Editor edit = context.getSharedPreferences("appsflyer-data", 0).edit();
            edit.putString("referrer", stringExtra);
            edit.commit();
            d.a().b(stringExtra);
            if (d.a().c()) {
                b(context, null, null, null, stringExtra);
            }
        }
    }
}

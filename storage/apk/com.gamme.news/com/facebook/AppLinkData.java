// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import java.util.Iterator;
import android.os.Parcelable;
import org.json.JSONArray;
import com.facebook.internal.Utility;
import org.json.JSONException;
import android.util.Log;
import android.content.Intent;
import com.facebook.internal.Validate;
import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import org.json.JSONObject;
import android.os.Bundle;

public class AppLinkData
{
    private static final String APPLINK_BRIDGE_ARGS_KEY = "bridge_args";
    private static final String APPLINK_METHOD_ARGS_KEY = "method_args";
    private static final String APPLINK_VERSION_KEY = "version";
    public static final String ARGUMENTS_NATIVE_CLASS_KEY = "com.facebook.platform.APPLINK_NATIVE_CLASS";
    public static final String ARGUMENTS_NATIVE_URL = "com.facebook.platform.APPLINK_NATIVE_URL";
    public static final String ARGUMENTS_REFERER_DATA_KEY = "referer_data";
    public static final String ARGUMENTS_TAPTIME_KEY = "com.facebook.platform.APPLINK_TAP_TIME_UTC";
    private static final String BRIDGE_ARGS_METHOD_KEY = "method";
    private static final String BUNDLE_AL_APPLINK_DATA_KEY = "al_applink_data";
    static final String BUNDLE_APPLINK_ARGS_KEY = "com.facebook.platform.APPLINK_ARGS";
    private static final String DEFERRED_APP_LINK_ARGS_FIELD = "applink_args";
    private static final String DEFERRED_APP_LINK_CLASS_FIELD = "applink_class";
    private static final String DEFERRED_APP_LINK_CLICK_TIME_FIELD = "click_time";
    private static final String DEFERRED_APP_LINK_EVENT = "DEFERRED_APP_LINK";
    private static final String DEFERRED_APP_LINK_PATH = "%s/activities";
    private static final String DEFERRED_APP_LINK_URL_FIELD = "applink_url";
    private static final String METHOD_ARGS_REF_KEY = "ref";
    private static final String METHOD_ARGS_TARGET_URL_KEY = "target_url";
    private static final String REFERER_DATA_REF_KEY = "fb_ref";
    private static final String TAG;
    private Bundle argumentBundle;
    private JSONObject arguments;
    private String ref;
    private Uri targetUri;
    
    static {
        TAG = AppLinkData.class.getCanonicalName();
    }
    
    public static AppLinkData createFromActivity(final Activity activity) {
        Validate.notNull(activity, "activity");
        final Intent intent = activity.getIntent();
        AppLinkData appLinkData;
        if (intent == null) {
            appLinkData = null;
        }
        else {
            appLinkData = createFromAlApplinkData(intent);
            if (appLinkData == null) {
                appLinkData = createFromJson(intent.getStringExtra("com.facebook.platform.APPLINK_ARGS"));
            }
            if (appLinkData == null) {
                return createFromUri(intent.getData());
            }
        }
        return appLinkData;
    }
    
    private static AppLinkData createFromAlApplinkData(final Intent intent) {
        final Bundle bundleExtra = intent.getBundleExtra("al_applink_data");
        AppLinkData appLinkData;
        if (bundleExtra == null) {
            appLinkData = null;
        }
        else {
            appLinkData = new AppLinkData();
            appLinkData.targetUri = intent.getData();
            if (appLinkData.targetUri == null) {
                final String string = bundleExtra.getString("target_url");
                if (string != null) {
                    appLinkData.targetUri = Uri.parse(string);
                }
            }
            appLinkData.argumentBundle = bundleExtra;
            appLinkData.arguments = null;
            final Bundle bundle = bundleExtra.getBundle("referer_data");
            if (bundle != null) {
                appLinkData.ref = bundle.getString("fb_ref");
                return appLinkData;
            }
        }
        return appLinkData;
    }
    
    private static AppLinkData createFromJson(final String s) {
        if (s == null) {
            return null;
        }
        try {
            final JSONObject jsonObject = new JSONObject(s);
            final String string = jsonObject.getString("version");
            if (!jsonObject.getJSONObject("bridge_args").getString("method").equals("applink") || !string.equals("2")) {
                goto Label_0160;
            }
            final AppLinkData appLinkData = new AppLinkData();
            appLinkData.arguments = jsonObject.getJSONObject("method_args");
            if (appLinkData.arguments.has("ref")) {
                appLinkData.ref = appLinkData.arguments.getString("ref");
                if (appLinkData.arguments.has("target_url")) {
                    appLinkData.targetUri = Uri.parse(appLinkData.arguments.getString("target_url"));
                }
                appLinkData.argumentBundle = toBundle(appLinkData.arguments);
                return appLinkData;
            }
            goto Label_0162;
        }
        catch (JSONException ex) {
            Log.d(AppLinkData.TAG, "Unable to parse AppLink JSON", (Throwable)ex);
        }
        catch (FacebookException ex2) {
            Log.d(AppLinkData.TAG, "Unable to parse AppLink JSON", (Throwable)ex2);
            goto Label_0160;
        }
    }
    
    private static AppLinkData createFromUri(final Uri targetUri) {
        if (targetUri == null) {
            return null;
        }
        final AppLinkData appLinkData = new AppLinkData();
        appLinkData.targetUri = targetUri;
        return appLinkData;
    }
    
    public static void fetchDeferredAppLinkData(final Context context, final CompletionHandler completionHandler) {
        fetchDeferredAppLinkData(context, null, completionHandler);
    }
    
    public static void fetchDeferredAppLinkData(final Context context, String metadataApplicationId, final CompletionHandler completionHandler) {
        Validate.notNull(context, "context");
        Validate.notNull(completionHandler, "completionHandler");
        if (metadataApplicationId == null) {
            metadataApplicationId = Utility.getMetadataApplicationId(context);
        }
        Validate.notNull(metadataApplicationId, "applicationId");
        Settings.getExecutor().execute(new Runnable() {
            private final /* synthetic */ Context val$applicationContext = context.getApplicationContext();
            
            @Override
            public void run() {
                fetchDeferredAppLinkFromServer(this.val$applicationContext, metadataApplicationId, completionHandler);
            }
        });
    }
    
    private static void fetchDeferredAppLinkFromServer(final Context p0, final String p1, final CompletionHandler p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: invokestatic    com/facebook/model/GraphObject$Factory.create:()Lcom/facebook/model/GraphObject;
        //     3: astore_3       
        //     4: aload_3        
        //     5: ldc             "event"
        //     7: ldc             "DEFERRED_APP_LINK"
        //     9: invokeinterface com/facebook/model/GraphObject.setProperty:(Ljava/lang/String;Ljava/lang/Object;)V
        //    14: aload_3        
        //    15: aload_0        
        //    16: invokestatic    com/facebook/internal/AttributionIdentifiers.getAttributionIdentifiers:(Landroid/content/Context;)Lcom/facebook/internal/AttributionIdentifiers;
        //    19: aload_0        
        //    20: aload_1        
        //    21: invokestatic    com/facebook/internal/Utility.getHashedDeviceAndAppID:(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
        //    24: aload_0        
        //    25: invokestatic    com/facebook/Settings.getLimitEventAndDataUsage:(Landroid/content/Context;)Z
        //    28: invokestatic    com/facebook/internal/Utility.setAppEventAttributionParameters:(Lcom/facebook/model/GraphObject;Lcom/facebook/internal/AttributionIdentifiers;Ljava/lang/String;Z)V
        //    31: aload_3        
        //    32: ldc_w           "application_package_name"
        //    35: aload_0        
        //    36: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //    39: invokeinterface com/facebook/model/GraphObject.setProperty:(Ljava/lang/String;Ljava/lang/Object;)V
        //    44: ldc             "%s/activities"
        //    46: iconst_1       
        //    47: anewarray       Ljava/lang/Object;
        //    50: dup            
        //    51: iconst_0       
        //    52: aload_1        
        //    53: aastore        
        //    54: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //    57: astore          4
        //    59: aconst_null    
        //    60: astore          5
        //    62: aconst_null    
        //    63: aload           4
        //    65: aload_3        
        //    66: aconst_null    
        //    67: invokestatic    com/facebook/Request.newPostRequest:(Lcom/facebook/Session;Ljava/lang/String;Lcom/facebook/model/GraphObject;Lcom/facebook/Request$Callback;)Lcom/facebook/Request;
        //    70: invokevirtual   com/facebook/Request.executeAndWait:()Lcom/facebook/Response;
        //    73: invokevirtual   com/facebook/Response.getGraphObject:()Lcom/facebook/model/GraphObject;
        //    76: astore          7
        //    78: aconst_null    
        //    79: astore          5
        //    81: aload           7
        //    83: ifnull          326
        //    86: aload           7
        //    88: invokeinterface com/facebook/model/GraphObject.getInnerJSONObject:()Lorg/json/JSONObject;
        //    93: astore          8
        //    95: aconst_null    
        //    96: astore          5
        //    98: aload           8
        //   100: ifnull          317
        //   103: aload           8
        //   105: ldc             "applink_args"
        //   107: invokevirtual   org/json/JSONObject.optString:(Ljava/lang/String;)Ljava/lang/String;
        //   110: astore          9
        //   112: aload           8
        //   114: ldc             "click_time"
        //   116: ldc2_w          -1
        //   119: invokevirtual   org/json/JSONObject.optLong:(Ljava/lang/String;J)J
        //   122: lstore          10
        //   124: aload           8
        //   126: ldc             "applink_class"
        //   128: invokevirtual   org/json/JSONObject.optString:(Ljava/lang/String;)Ljava/lang/String;
        //   131: astore          12
        //   133: aload           8
        //   135: ldc             "applink_url"
        //   137: invokevirtual   org/json/JSONObject.optString:(Ljava/lang/String;)Ljava/lang/String;
        //   140: astore          13
        //   142: aconst_null    
        //   143: astore          5
        //   145: aload           9
        //   147: ifnull          317
        //   150: aconst_null    
        //   151: astore          5
        //   153: aload           9
        //   155: ldc_w           ""
        //   158: if_acmpeq       317
        //   161: aload           9
        //   163: invokestatic    com/facebook/AppLinkData.createFromJson:(Ljava/lang/String;)Lcom/facebook/AppLinkData;
        //   166: astore          14
        //   168: aload           14
        //   170: astore          5
        //   172: lload           10
        //   174: ldc2_w          -1
        //   177: lcmp           
        //   178: ifeq            225
        //   181: aload           5
        //   183: getfield        com/facebook/AppLinkData.arguments:Lorg/json/JSONObject;
        //   186: ifnull          202
        //   189: aload           5
        //   191: getfield        com/facebook/AppLinkData.arguments:Lorg/json/JSONObject;
        //   194: ldc             "com.facebook.platform.APPLINK_TAP_TIME_UTC"
        //   196: lload           10
        //   198: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;J)Lorg/json/JSONObject;
        //   201: pop            
        //   202: aload           5
        //   204: getfield        com/facebook/AppLinkData.argumentBundle:Landroid/os/Bundle;
        //   207: ifnull          225
        //   210: aload           5
        //   212: getfield        com/facebook/AppLinkData.argumentBundle:Landroid/os/Bundle;
        //   215: ldc             "com.facebook.platform.APPLINK_TAP_TIME_UTC"
        //   217: lload           10
        //   219: invokestatic    java/lang/Long.toString:(J)Ljava/lang/String;
        //   222: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //   225: aload           12
        //   227: ifnull          271
        //   230: aload           5
        //   232: getfield        com/facebook/AppLinkData.arguments:Lorg/json/JSONObject;
        //   235: ifnull          251
        //   238: aload           5
        //   240: getfield        com/facebook/AppLinkData.arguments:Lorg/json/JSONObject;
        //   243: ldc             "com.facebook.platform.APPLINK_NATIVE_CLASS"
        //   245: aload           12
        //   247: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   250: pop            
        //   251: aload           5
        //   253: getfield        com/facebook/AppLinkData.argumentBundle:Landroid/os/Bundle;
        //   256: ifnull          271
        //   259: aload           5
        //   261: getfield        com/facebook/AppLinkData.argumentBundle:Landroid/os/Bundle;
        //   264: ldc             "com.facebook.platform.APPLINK_NATIVE_CLASS"
        //   266: aload           12
        //   268: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //   271: aload           13
        //   273: ifnull          317
        //   276: aload           5
        //   278: getfield        com/facebook/AppLinkData.arguments:Lorg/json/JSONObject;
        //   281: ifnull          297
        //   284: aload           5
        //   286: getfield        com/facebook/AppLinkData.arguments:Lorg/json/JSONObject;
        //   289: ldc             "com.facebook.platform.APPLINK_NATIVE_URL"
        //   291: aload           13
        //   293: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   296: pop            
        //   297: aload           5
        //   299: getfield        com/facebook/AppLinkData.argumentBundle:Landroid/os/Bundle;
        //   302: ifnull          317
        //   305: aload           5
        //   307: getfield        com/facebook/AppLinkData.argumentBundle:Landroid/os/Bundle;
        //   310: ldc             "com.facebook.platform.APPLINK_NATIVE_URL"
        //   312: aload           13
        //   314: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //   317: aload_2        
        //   318: aload           5
        //   320: invokeinterface com/facebook/AppLinkData$CompletionHandler.onDeferredAppLinkDataFetched:(Lcom/facebook/AppLinkData;)V
        //   325: return         
        //   326: aconst_null    
        //   327: astore          8
        //   329: goto            95
        //   332: astore          21
        //   334: getstatic       com/facebook/AppLinkData.TAG:Ljava/lang/String;
        //   337: ldc_w           "Unable to put tap time in AppLinkData.arguments"
        //   340: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   343: pop            
        //   344: goto            225
        //   347: astore          6
        //   349: getstatic       com/facebook/AppLinkData.TAG:Ljava/lang/String;
        //   352: ldc_w           "Unable to fetch deferred applink from server"
        //   355: invokestatic    com/facebook/internal/Utility.logd:(Ljava/lang/String;Ljava/lang/String;)V
        //   358: goto            317
        //   361: astore          18
        //   363: getstatic       com/facebook/AppLinkData.TAG:Ljava/lang/String;
        //   366: ldc_w           "Unable to put tap time in AppLinkData.arguments"
        //   369: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   372: pop            
        //   373: goto            271
        //   376: astore          15
        //   378: getstatic       com/facebook/AppLinkData.TAG:Ljava/lang/String;
        //   381: ldc_w           "Unable to put tap time in AppLinkData.arguments"
        //   384: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   387: pop            
        //   388: goto            317
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                    
        //  -----  -----  -----  -----  ------------------------
        //  62     78     347    361    Ljava/lang/Exception;
        //  86     95     347    361    Ljava/lang/Exception;
        //  103    142    347    361    Ljava/lang/Exception;
        //  161    168    347    361    Ljava/lang/Exception;
        //  181    202    332    347    Lorg/json/JSONException;
        //  181    202    347    361    Ljava/lang/Exception;
        //  202    225    332    347    Lorg/json/JSONException;
        //  202    225    347    361    Ljava/lang/Exception;
        //  230    251    361    376    Lorg/json/JSONException;
        //  230    251    347    361    Ljava/lang/Exception;
        //  251    271    361    376    Lorg/json/JSONException;
        //  251    271    347    361    Ljava/lang/Exception;
        //  276    297    376    391    Lorg/json/JSONException;
        //  276    297    347    361    Ljava/lang/Exception;
        //  297    317    376    391    Lorg/json/JSONException;
        //  297    317    347    361    Ljava/lang/Exception;
        //  334    344    347    361    Ljava/lang/Exception;
        //  363    373    347    361    Ljava/lang/Exception;
        //  378    388    347    361    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 171, Size: 171
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
    
    private static Bundle toBundle(final JSONObject jsonObject) throws JSONException {
        final Bundle bundle = new Bundle();
        final Iterator keys = jsonObject.keys();
        while (keys.hasNext()) {
            final String s = keys.next();
            final Object value = jsonObject.get(s);
            if (value instanceof JSONObject) {
                bundle.putBundle(s, toBundle((JSONObject)value));
            }
            else if (value instanceof JSONArray) {
                final JSONArray jsonArray = (JSONArray)value;
                if (jsonArray.length() == 0) {
                    bundle.putStringArray(s, new String[0]);
                }
                else {
                    final Object value2 = jsonArray.get(0);
                    if (value2 instanceof JSONObject) {
                        final Bundle[] array = new Bundle[jsonArray.length()];
                        for (int i = 0; i < jsonArray.length(); ++i) {
                            array[i] = toBundle(jsonArray.getJSONObject(i));
                        }
                        bundle.putParcelableArray(s, (Parcelable[])array);
                    }
                    else {
                        if (value2 instanceof JSONArray) {
                            throw new FacebookException("Nested arrays are not supported.");
                        }
                        final String[] array2 = new String[jsonArray.length()];
                        for (int j = 0; j < jsonArray.length(); ++j) {
                            array2[j] = jsonArray.get(j).toString();
                        }
                        bundle.putStringArray(s, array2);
                    }
                }
            }
            else {
                bundle.putString(s, value.toString());
            }
        }
        return bundle;
    }
    
    public Bundle getArgumentBundle() {
        return this.argumentBundle;
    }
    
    @Deprecated
    public JSONObject getArguments() {
        return this.arguments;
    }
    
    public String getRef() {
        return this.ref;
    }
    
    public Bundle getRefererData() {
        if (this.argumentBundle != null) {
            return this.argumentBundle.getBundle("referer_data");
        }
        return null;
    }
    
    public Uri getTargetUri() {
        return this.targetUri;
    }
    
    public interface CompletionHandler
    {
        void onDeferredAppLinkDataFetched(AppLinkData p0);
    }
}

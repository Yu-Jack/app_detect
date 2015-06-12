// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gcm;

import android.os.Handler;
import android.content.IntentFilter;
import android.content.SharedPreferences$Editor;
import android.content.BroadcastReceiver;
import java.sql.Timestamp;
import android.os.Parcelable;
import android.app.PendingIntent;
import android.content.SharedPreferences;
import java.util.Iterator;
import java.util.List;
import android.content.pm.ResolveInfo;
import android.util.Log;
import android.content.Intent;
import java.util.Set;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Build$VERSION;
import android.content.Context;

public final class GCMRegistrar
{
    private static final String BACKOFF_MS = "backoff_ms";
    private static final int DEFAULT_BACKOFF_MS = 3000;
    public static final long DEFAULT_ON_SERVER_LIFESPAN_MS = 604800000L;
    private static final String GSF_PACKAGE = "com.google.android.gsf";
    private static final String PREFERENCES = "com.google.android.gcm";
    private static final String PROPERTY_APP_VERSION = "appVersion";
    private static final String PROPERTY_ON_SERVER = "onServer";
    private static final String PROPERTY_ON_SERVER_EXPIRATION_TIME = "onServerExpirationTime";
    private static final String PROPERTY_ON_SERVER_LIFESPAN = "onServerLifeSpan";
    private static final String PROPERTY_REG_ID = "regId";
    private static final String TAG = "GCMRegistrar";
    private static GCMBroadcastReceiver sRetryReceiver;
    private static String sRetryReceiverClassName;
    
    private GCMRegistrar() {
        throw new UnsupportedOperationException();
    }
    
    public static void checkDevice(final Context context) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT < 8) {
            throw new UnsupportedOperationException("Device must be at least API Level 8 (instead of " + sdk_INT + ")");
        }
        final PackageManager packageManager = context.getPackageManager();
        try {
            packageManager.getPackageInfo("com.google.android.gsf", 0);
        }
        catch (PackageManager$NameNotFoundException ex) {
            throw new UnsupportedOperationException("Device does not have package com.google.android.gsf");
        }
    }
    
    public static void checkManifest(final Context p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: invokevirtual   android/content/Context.getPackageManager:()Landroid/content/pm/PackageManager;
        //     4: astore_1       
        //     5: aload_0        
        //     6: invokevirtual   android/content/Context.getPackageName:()Ljava/lang/String;
        //     9: astore_2       
        //    10: new             Ljava/lang/StringBuilder;
        //    13: dup            
        //    14: invokespecial   java/lang/StringBuilder.<init>:()V
        //    17: aload_2        
        //    18: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    21: ldc             ".permission.C2D_MESSAGE"
        //    23: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    26: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    29: astore_3       
        //    30: aload_1        
        //    31: aload_3        
        //    32: sipush          4096
        //    35: invokevirtual   android/content/pm/PackageManager.getPermissionInfo:(Ljava/lang/String;I)Landroid/content/pm/PermissionInfo;
        //    38: pop            
        //    39: aload_1        
        //    40: aload_2        
        //    41: iconst_2       
        //    42: invokevirtual   android/content/pm/PackageManager.getPackageInfo:(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
        //    45: astore          7
        //    47: aload           7
        //    49: getfield        android/content/pm/PackageInfo.receivers:[Landroid/content/pm/ActivityInfo;
        //    52: astore          8
        //    54: aload           8
        //    56: ifnull          65
        //    59: aload           8
        //    61: arraylength    
        //    62: ifne            150
        //    65: new             Ljava/lang/IllegalStateException;
        //    68: dup            
        //    69: new             Ljava/lang/StringBuilder;
        //    72: dup            
        //    73: invokespecial   java/lang/StringBuilder.<init>:()V
        //    76: ldc             "No receiver for package "
        //    78: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    81: aload_2        
        //    82: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    85: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    88: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //    91: athrow         
        //    92: astore          4
        //    94: new             Ljava/lang/IllegalStateException;
        //    97: dup            
        //    98: new             Ljava/lang/StringBuilder;
        //   101: dup            
        //   102: invokespecial   java/lang/StringBuilder.<init>:()V
        //   105: ldc             "Application does not define permission "
        //   107: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   110: aload_3        
        //   111: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   114: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   117: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   120: athrow         
        //   121: astore          6
        //   123: new             Ljava/lang/IllegalStateException;
        //   126: dup            
        //   127: new             Ljava/lang/StringBuilder;
        //   130: dup            
        //   131: invokespecial   java/lang/StringBuilder.<init>:()V
        //   134: ldc             "Could not get receivers for package "
        //   136: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   139: aload_2        
        //   140: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   143: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   146: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   149: athrow         
        //   150: ldc             "GCMRegistrar"
        //   152: iconst_2       
        //   153: invokestatic    android/util/Log.isLoggable:(Ljava/lang/String;I)Z
        //   156: ifeq            195
        //   159: ldc             "GCMRegistrar"
        //   161: new             Ljava/lang/StringBuilder;
        //   164: dup            
        //   165: invokespecial   java/lang/StringBuilder.<init>:()V
        //   168: ldc             "number of receivers for "
        //   170: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   173: aload_2        
        //   174: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   177: ldc             ": "
        //   179: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   182: aload           8
        //   184: arraylength    
        //   185: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   188: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   191: invokestatic    android/util/Log.v:(Ljava/lang/String;Ljava/lang/String;)I
        //   194: pop            
        //   195: new             Ljava/util/HashSet;
        //   198: dup            
        //   199: invokespecial   java/util/HashSet.<init>:()V
        //   202: astore          9
        //   204: aload           8
        //   206: arraylength    
        //   207: istore          10
        //   209: iconst_0       
        //   210: istore          11
        //   212: iload           11
        //   214: iload           10
        //   216: if_icmpge       258
        //   219: aload           8
        //   221: iload           11
        //   223: aaload         
        //   224: astore          12
        //   226: ldc             "com.google.android.c2dm.permission.SEND"
        //   228: aload           12
        //   230: getfield        android/content/pm/ActivityInfo.permission:Ljava/lang/String;
        //   233: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   236: ifeq            252
        //   239: aload           9
        //   241: aload           12
        //   243: getfield        android/content/pm/ActivityInfo.name:Ljava/lang/String;
        //   246: invokeinterface java/util/Set.add:(Ljava/lang/Object;)Z
        //   251: pop            
        //   252: iinc            11, 1
        //   255: goto            212
        //   258: aload           9
        //   260: invokeinterface java/util/Set.isEmpty:()Z
        //   265: ifeq            278
        //   268: new             Ljava/lang/IllegalStateException;
        //   271: dup            
        //   272: ldc             "No receiver allowed to receive com.google.android.c2dm.permission.SEND"
        //   274: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   277: athrow         
        //   278: aload_0        
        //   279: aload           9
        //   281: ldc             "com.google.android.c2dm.intent.REGISTRATION"
        //   283: invokestatic    com/google/android/gcm/GCMRegistrar.checkReceiver:(Landroid/content/Context;Ljava/util/Set;Ljava/lang/String;)V
        //   286: aload_0        
        //   287: aload           9
        //   289: ldc             "com.google.android.c2dm.intent.RECEIVE"
        //   291: invokestatic    com/google/android/gcm/GCMRegistrar.checkReceiver:(Landroid/content/Context;Ljava/util/Set;Ljava/lang/String;)V
        //   294: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                     
        //  -----  -----  -----  -----  ---------------------------------------------------------
        //  30     39     92     121    Landroid/content/pm/PackageManager$NameNotFoundException;
        //  39     47     121    150    Landroid/content/pm/PackageManager$NameNotFoundException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0065:
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
    
    private static void checkReceiver(final Context context, final Set<String> set, final String s) {
        final PackageManager packageManager = context.getPackageManager();
        final String packageName = context.getPackageName();
        final Intent intent = new Intent(s);
        intent.setPackage(packageName);
        final List queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 32);
        if (queryBroadcastReceivers.isEmpty()) {
            throw new IllegalStateException("No receivers for action " + s);
        }
        if (Log.isLoggable("GCMRegistrar", 2)) {
            Log.v("GCMRegistrar", "Found " + queryBroadcastReceivers.size() + " receivers for action " + s);
        }
        final Iterator<ResolveInfo> iterator = queryBroadcastReceivers.iterator();
        while (iterator.hasNext()) {
            final String name = iterator.next().activityInfo.name;
            if (!set.contains(name)) {
                throw new IllegalStateException("Receiver " + name + " is not set with permission " + "com.google.android.c2dm.permission.SEND");
            }
        }
    }
    
    static String clearRegistrationId(final Context context) {
        return setRegistrationId(context, "");
    }
    
    private static int getAppVersion(final Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        }
        catch (PackageManager$NameNotFoundException obj) {
            throw new RuntimeException("Coult not get package name: " + obj);
        }
    }
    
    static int getBackoff(final Context context) {
        return getGCMPreferences(context).getInt("backoff_ms", 3000);
    }
    
    static String getFlatSenderIds(final String... array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        final StringBuilder sb = new StringBuilder(array[0]);
        for (int i = 1; i < array.length; ++i) {
            sb.append(',').append(array[i]);
        }
        return sb.toString();
    }
    
    private static SharedPreferences getGCMPreferences(final Context context) {
        return context.getSharedPreferences("com.google.android.gcm", 0);
    }
    
    public static long getRegisterOnServerLifespan(final Context context) {
        return getGCMPreferences(context).getLong("onServerLifeSpan", 604800000L);
    }
    
    public static String getRegistrationId(final Context context) {
        final SharedPreferences gcmPreferences = getGCMPreferences(context);
        String string = gcmPreferences.getString("regId", "");
        final int int1 = gcmPreferences.getInt("appVersion", Integer.MIN_VALUE);
        final int appVersion = getAppVersion(context);
        if (int1 != Integer.MIN_VALUE && int1 != appVersion) {
            Log.v("GCMRegistrar", "App version changed from " + int1 + " to " + appVersion + "; resetting registration id");
            clearRegistrationId(context);
            string = "";
        }
        return string;
    }
    
    static void internalRegister(final Context context, final String... array) {
        final String flatSenderIds = getFlatSenderIds(array);
        Log.v("GCMRegistrar", "Registering app " + context.getPackageName() + " of senders " + flatSenderIds);
        final Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        intent.setPackage("com.google.android.gsf");
        intent.putExtra("app", (Parcelable)PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        intent.putExtra("sender", flatSenderIds);
        context.startService(intent);
    }
    
    static void internalUnregister(final Context context) {
        Log.v("GCMRegistrar", "Unregistering app " + context.getPackageName());
        final Intent intent = new Intent("com.google.android.c2dm.intent.UNREGISTER");
        intent.setPackage("com.google.android.gsf");
        intent.putExtra("app", (Parcelable)PendingIntent.getBroadcast(context, 0, new Intent(), 0));
        context.startService(intent);
    }
    
    public static boolean isRegistered(final Context context) {
        return getRegistrationId(context).length() > 0;
    }
    
    public static boolean isRegisteredOnServer(final Context context) {
        final SharedPreferences gcmPreferences = getGCMPreferences(context);
        boolean boolean1 = gcmPreferences.getBoolean("onServer", false);
        Log.v("GCMRegistrar", "Is registered on server: " + boolean1);
        if (boolean1) {
            final long long1 = gcmPreferences.getLong("onServerExpirationTime", -1L);
            if (System.currentTimeMillis() > long1) {
                Log.v("GCMRegistrar", "flag expired on: " + new Timestamp(long1));
                boolean1 = false;
            }
        }
        return boolean1;
    }
    
    public static void onDestroy(final Context context) {
        synchronized (GCMRegistrar.class) {
            if (GCMRegistrar.sRetryReceiver != null) {
                Log.v("GCMRegistrar", "Unregistering receiver");
                context.unregisterReceiver((BroadcastReceiver)GCMRegistrar.sRetryReceiver);
                GCMRegistrar.sRetryReceiver = null;
            }
        }
    }
    
    public static void register(final Context context, final String... array) {
        resetBackoff(context);
        internalRegister(context, array);
    }
    
    static void resetBackoff(final Context context) {
        Log.d("GCMRegistrar", "resetting backoff for " + context.getPackageName());
        setBackoff(context, 3000);
    }
    
    static void setBackoff(final Context context, final int n) {
        final SharedPreferences$Editor edit = getGCMPreferences(context).edit();
        edit.putInt("backoff_ms", n);
        edit.commit();
    }
    
    public static void setRegisterOnServerLifespan(final Context context, final long n) {
        final SharedPreferences$Editor edit = getGCMPreferences(context).edit();
        edit.putLong("onServerLifeSpan", n);
        edit.commit();
    }
    
    public static void setRegisteredOnServer(final Context context, final boolean b) {
        final SharedPreferences$Editor edit = getGCMPreferences(context).edit();
        edit.putBoolean("onServer", b);
        final long time = getRegisterOnServerLifespan(context) + System.currentTimeMillis();
        Log.v("GCMRegistrar", "Setting registeredOnServer status as " + b + " until " + new Timestamp(time));
        edit.putLong("onServerExpirationTime", time);
        edit.commit();
    }
    
    static String setRegistrationId(final Context context, final String s) {
        final SharedPreferences gcmPreferences = getGCMPreferences(context);
        final String string = gcmPreferences.getString("regId", "");
        final int appVersion = getAppVersion(context);
        Log.v("GCMRegistrar", "Saving regId on app version " + appVersion);
        final SharedPreferences$Editor edit = gcmPreferences.edit();
        edit.putString("regId", s);
        edit.putInt("appVersion", appVersion);
        edit.commit();
        return string;
    }
    
    static void setRetryBroadcastReceiver(final Context context) {
        synchronized (GCMRegistrar.class) {
            if (GCMRegistrar.sRetryReceiver == null) {
                if (GCMRegistrar.sRetryReceiverClassName == null) {
                    Log.e("GCMRegistrar", "internal error: retry receiver class not set yet");
                    GCMRegistrar.sRetryReceiver = new GCMBroadcastReceiver();
                }
                else {
                    try {
                        GCMRegistrar.sRetryReceiver = (GCMBroadcastReceiver)Class.forName(GCMRegistrar.sRetryReceiverClassName).newInstance();
                    }
                    catch (Exception ex) {
                        Log.e("GCMRegistrar", "Could not create instance of " + GCMRegistrar.sRetryReceiverClassName + ". Using " + GCMBroadcastReceiver.class.getName() + " directly.");
                        GCMRegistrar.sRetryReceiver = new GCMBroadcastReceiver();
                    }
                }
                final String packageName = context.getPackageName();
                final IntentFilter intentFilter = new IntentFilter("com.google.android.gcm.intent.RETRY");
                intentFilter.addCategory(packageName);
                final String string = packageName + ".permission.C2D_MESSAGE";
                Log.v("GCMRegistrar", "Registering receiver");
                context.registerReceiver((BroadcastReceiver)GCMRegistrar.sRetryReceiver, intentFilter, string, (Handler)null);
            }
        }
    }
    
    static void setRetryReceiverClassName(final String s) {
        Log.v("GCMRegistrar", "Setting the name of retry receiver class to " + s);
        GCMRegistrar.sRetryReceiverClassName = s;
    }
    
    public static void unregister(final Context context) {
        resetBackoff(context);
        internalUnregister(context);
    }
}

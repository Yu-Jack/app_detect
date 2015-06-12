// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gcm;

import android.os.PowerManager;
import android.app.PendingIntent;
import android.os.SystemClock;
import android.app.AlarmManager;
import android.content.Intent;
import android.content.Context;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import android.os.PowerManager$WakeLock;
import java.util.Random;
import android.app.IntentService;

public abstract class GCMBaseIntentService extends IntentService
{
    private static final String EXTRA_TOKEN = "token";
    private static final Object LOCK;
    private static final int MAX_BACKOFF_MS = 0;
    public static final String TAG = "GCMBaseIntentService";
    private static final String TOKEN;
    private static final String WAKELOCK_KEY = "GCM_LIB";
    private static int sCounter;
    private static final Random sRandom;
    private static PowerManager$WakeLock sWakeLock;
    private final String[] mSenderIds;
    
    static {
        LOCK = GCMBaseIntentService.class;
        GCMBaseIntentService.sCounter = 0;
        sRandom = new Random();
        TOKEN = Long.toBinaryString(GCMBaseIntentService.sRandom.nextLong());
    }
    
    protected GCMBaseIntentService() {
        this(getName("DynamicSenderIds"), null);
    }
    
    private GCMBaseIntentService(final String s, final String[] mSenderIds) {
        super(s);
        this.mSenderIds = mSenderIds;
    }
    
    protected GCMBaseIntentService(final String... array) {
        this(getName(array), array);
    }
    
    private static String getName(final String str) {
        final String string = "GCMIntentService-" + str + "-" + ++GCMBaseIntentService.sCounter;
        Log.v("GCMBaseIntentService", "Intent service name: " + string);
        return string;
    }
    
    private static String getName(final String[] array) {
        return getName(GCMRegistrar.getFlatSenderIds(array));
    }
    
    private void handleRegistration(final Context context, final Intent intent) {
        final String stringExtra = intent.getStringExtra("registration_id");
        final String stringExtra2 = intent.getStringExtra("error");
        final String stringExtra3 = intent.getStringExtra("unregistered");
        Log.d("GCMBaseIntentService", "handleRegistration: registrationId = " + stringExtra + ", error = " + stringExtra2 + ", unregistered = " + stringExtra3);
        if (stringExtra != null) {
            GCMRegistrar.resetBackoff(context);
            GCMRegistrar.setRegistrationId(context, stringExtra);
            this.onRegistered(context, stringExtra);
        }
        else {
            if (stringExtra3 != null) {
                GCMRegistrar.resetBackoff(context);
                this.onUnregistered(context, GCMRegistrar.clearRegistrationId(context));
                return;
            }
            Log.d("GCMBaseIntentService", "Registration error: " + stringExtra2);
            if (!"SERVICE_NOT_AVAILABLE".equals(stringExtra2)) {
                this.onError(context, stringExtra2);
                return;
            }
            if (!this.onRecoverableError(context, stringExtra2)) {
                Log.d("GCMBaseIntentService", "Not retrying failed operation");
                return;
            }
            final int backoff = GCMRegistrar.getBackoff(context);
            final int i = backoff / 2 + GCMBaseIntentService.sRandom.nextInt(backoff);
            Log.d("GCMBaseIntentService", "Scheduling registration retry, backoff = " + i + " (" + backoff + ")");
            final Intent intent2 = new Intent("com.google.android.gcm.intent.RETRY");
            intent2.putExtra("token", GCMBaseIntentService.TOKEN);
            ((AlarmManager)context.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + i, PendingIntent.getBroadcast(context, 0, intent2, 0));
            if (backoff < GCMBaseIntentService.MAX_BACKOFF_MS) {
                GCMRegistrar.setBackoff(context, backoff * 2);
            }
        }
    }
    
    static void runIntentInService(final Context context, final Intent intent, final String s) {
        synchronized (GCMBaseIntentService.LOCK) {
            if (GCMBaseIntentService.sWakeLock == null) {
                GCMBaseIntentService.sWakeLock = ((PowerManager)context.getSystemService("power")).newWakeLock(1, "GCM_LIB");
            }
            // monitorexit(GCMBaseIntentService.LOCK)
            Log.v("GCMBaseIntentService", "Acquiring wakelock");
            GCMBaseIntentService.sWakeLock.acquire();
            intent.setClassName(context, s);
            context.startService(intent);
        }
    }
    
    protected String[] getSenderIds(final Context context) {
        if (this.mSenderIds == null) {
            throw new IllegalStateException("sender id not set on constructor");
        }
        return this.mSenderIds;
    }
    
    protected void onDeletedMessages(final Context context, final int n) {
    }
    
    protected abstract void onError(final Context p0, final String p1);
    
    public final void onHandleIntent(final Intent p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: invokevirtual   com/google/android/gcm/GCMBaseIntentService.getApplicationContext:()Landroid/content/Context;
        //     4: astore          7
        //     6: aload_1        
        //     7: invokevirtual   android/content/Intent.getAction:()Ljava/lang/String;
        //    10: astore          8
        //    12: aload           8
        //    14: ldc_w           "com.google.android.c2dm.intent.REGISTRATION"
        //    17: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    20: ifeq            68
        //    23: aload           7
        //    25: invokestatic    com/google/android/gcm/GCMRegistrar.setRetryBroadcastReceiver:(Landroid/content/Context;)V
        //    28: aload_0        
        //    29: aload           7
        //    31: aload_1        
        //    32: invokespecial   com/google/android/gcm/GCMBaseIntentService.handleRegistration:(Landroid/content/Context;Landroid/content/Intent;)V
        //    35: getstatic       com/google/android/gcm/GCMBaseIntentService.LOCK:Ljava/lang/Object;
        //    38: astore          10
        //    40: aload           10
        //    42: monitorenter   
        //    43: getstatic       com/google/android/gcm/GCMBaseIntentService.sWakeLock:Landroid/os/PowerManager$WakeLock;
        //    46: ifnull          406
        //    49: ldc             "GCMBaseIntentService"
        //    51: ldc_w           "Releasing wakelock"
        //    54: invokestatic    android/util/Log.v:(Ljava/lang/String;Ljava/lang/String;)I
        //    57: pop            
        //    58: getstatic       com/google/android/gcm/GCMBaseIntentService.sWakeLock:Landroid/os/PowerManager$WakeLock;
        //    61: invokevirtual   android/os/PowerManager$WakeLock.release:()V
        //    64: aload           10
        //    66: monitorexit    
        //    67: return         
        //    68: aload           8
        //    70: ldc_w           "com.google.android.c2dm.intent.RECEIVE"
        //    73: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    76: ifeq            267
        //    79: aload_1        
        //    80: ldc_w           "message_type"
        //    83: invokevirtual   android/content/Intent.getStringExtra:(Ljava/lang/String;)Ljava/lang/String;
        //    86: astore          19
        //    88: aload           19
        //    90: ifnull          257
        //    93: aload           19
        //    95: ldc_w           "deleted_messages"
        //    98: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   101: ifeq            227
        //   104: aload_1        
        //   105: ldc_w           "total_deleted"
        //   108: invokevirtual   android/content/Intent.getStringExtra:(Ljava/lang/String;)Ljava/lang/String;
        //   111: astore          21
        //   113: aload           21
        //   115: ifnull          35
        //   118: aload           21
        //   120: invokestatic    java/lang/Integer.parseInt:(Ljava/lang/String;)I
        //   123: istore          24
        //   125: ldc             "GCMBaseIntentService"
        //   127: new             Ljava/lang/StringBuilder;
        //   130: dup            
        //   131: invokespecial   java/lang/StringBuilder.<init>:()V
        //   134: ldc_w           "Received deleted messages notification: "
        //   137: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   140: iload           24
        //   142: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   145: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   148: invokestatic    android/util/Log.v:(Ljava/lang/String;Ljava/lang/String;)I
        //   151: pop            
        //   152: aload_0        
        //   153: aload           7
        //   155: iload           24
        //   157: invokevirtual   com/google/android/gcm/GCMBaseIntentService.onDeletedMessages:(Landroid/content/Context;I)V
        //   160: goto            35
        //   163: astore          22
        //   165: ldc             "GCMBaseIntentService"
        //   167: new             Ljava/lang/StringBuilder;
        //   170: dup            
        //   171: invokespecial   java/lang/StringBuilder.<init>:()V
        //   174: ldc_w           "GCM returned invalid number of deleted messages: "
        //   177: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   180: aload           21
        //   182: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   185: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   188: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   191: pop            
        //   192: goto            35
        //   195: astore_2       
        //   196: getstatic       com/google/android/gcm/GCMBaseIntentService.LOCK:Ljava/lang/Object;
        //   199: astore_3       
        //   200: aload_3        
        //   201: monitorenter   
        //   202: getstatic       com/google/android/gcm/GCMBaseIntentService.sWakeLock:Landroid/os/PowerManager$WakeLock;
        //   205: ifnull          426
        //   208: ldc             "GCMBaseIntentService"
        //   210: ldc_w           "Releasing wakelock"
        //   213: invokestatic    android/util/Log.v:(Ljava/lang/String;Ljava/lang/String;)I
        //   216: pop            
        //   217: getstatic       com/google/android/gcm/GCMBaseIntentService.sWakeLock:Landroid/os/PowerManager$WakeLock;
        //   220: invokevirtual   android/os/PowerManager$WakeLock.release:()V
        //   223: aload_3        
        //   224: monitorexit    
        //   225: aload_2        
        //   226: athrow         
        //   227: ldc             "GCMBaseIntentService"
        //   229: new             Ljava/lang/StringBuilder;
        //   232: dup            
        //   233: invokespecial   java/lang/StringBuilder.<init>:()V
        //   236: ldc_w           "Received unknown special message: "
        //   239: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   242: aload           19
        //   244: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   247: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   250: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   253: pop            
        //   254: goto            35
        //   257: aload_0        
        //   258: aload           7
        //   260: aload_1        
        //   261: invokevirtual   com/google/android/gcm/GCMBaseIntentService.onMessage:(Landroid/content/Context;Landroid/content/Intent;)V
        //   264: goto            35
        //   267: aload           8
        //   269: ldc             "com.google.android.gcm.intent.RETRY"
        //   271: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   274: ifeq            35
        //   277: aload_1        
        //   278: ldc             "token"
        //   280: invokevirtual   android/content/Intent.getStringExtra:(Ljava/lang/String;)Ljava/lang/String;
        //   283: astore          9
        //   285: getstatic       com/google/android/gcm/GCMBaseIntentService.TOKEN:Ljava/lang/String;
        //   288: aload           9
        //   290: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   293: ifne            376
        //   296: ldc             "GCMBaseIntentService"
        //   298: new             Ljava/lang/StringBuilder;
        //   301: dup            
        //   302: invokespecial   java/lang/StringBuilder.<init>:()V
        //   305: ldc_w           "Received invalid token: "
        //   308: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   311: aload           9
        //   313: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   316: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   319: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   322: pop            
        //   323: getstatic       com/google/android/gcm/GCMBaseIntentService.LOCK:Ljava/lang/Object;
        //   326: astore          15
        //   328: aload           15
        //   330: monitorenter   
        //   331: getstatic       com/google/android/gcm/GCMBaseIntentService.sWakeLock:Landroid/os/PowerManager$WakeLock;
        //   334: ifnull          364
        //   337: ldc             "GCMBaseIntentService"
        //   339: ldc_w           "Releasing wakelock"
        //   342: invokestatic    android/util/Log.v:(Ljava/lang/String;Ljava/lang/String;)I
        //   345: pop            
        //   346: getstatic       com/google/android/gcm/GCMBaseIntentService.sWakeLock:Landroid/os/PowerManager$WakeLock;
        //   349: invokevirtual   android/os/PowerManager$WakeLock.release:()V
        //   352: aload           15
        //   354: monitorexit    
        //   355: return         
        //   356: astore          16
        //   358: aload           15
        //   360: monitorexit    
        //   361: aload           16
        //   363: athrow         
        //   364: ldc             "GCMBaseIntentService"
        //   366: ldc_w           "Wakelock reference is null"
        //   369: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   372: pop            
        //   373: goto            352
        //   376: aload           7
        //   378: invokestatic    com/google/android/gcm/GCMRegistrar.isRegistered:(Landroid/content/Context;)Z
        //   381: ifeq            392
        //   384: aload           7
        //   386: invokestatic    com/google/android/gcm/GCMRegistrar.internalUnregister:(Landroid/content/Context;)V
        //   389: goto            35
        //   392: aload           7
        //   394: aload_0        
        //   395: aload           7
        //   397: invokevirtual   com/google/android/gcm/GCMBaseIntentService.getSenderIds:(Landroid/content/Context;)[Ljava/lang/String;
        //   400: invokestatic    com/google/android/gcm/GCMRegistrar.internalRegister:(Landroid/content/Context;[Ljava/lang/String;)V
        //   403: goto            35
        //   406: ldc             "GCMBaseIntentService"
        //   408: ldc_w           "Wakelock reference is null"
        //   411: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   414: pop            
        //   415: goto            64
        //   418: astore          11
        //   420: aload           10
        //   422: monitorexit    
        //   423: aload           11
        //   425: athrow         
        //   426: ldc             "GCMBaseIntentService"
        //   428: ldc_w           "Wakelock reference is null"
        //   431: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   434: pop            
        //   435: goto            223
        //   438: astore          4
        //   440: aload_3        
        //   441: monitorexit    
        //   442: aload           4
        //   444: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  0      35     195    445    Any
        //  43     64     418    426    Any
        //  64     67     418    426    Any
        //  68     88     195    445    Any
        //  93     113    195    445    Any
        //  118    160    163    195    Ljava/lang/NumberFormatException;
        //  118    160    195    445    Any
        //  165    192    195    445    Any
        //  202    223    438    445    Any
        //  223    225    438    445    Any
        //  227    254    195    445    Any
        //  257    264    195    445    Any
        //  267    323    195    445    Any
        //  331    352    356    364    Any
        //  352    355    356    364    Any
        //  358    361    356    364    Any
        //  364    373    356    364    Any
        //  376    389    195    445    Any
        //  392    403    195    445    Any
        //  406    415    418    426    Any
        //  420    423    418    426    Any
        //  426    435    438    445    Any
        //  440    442    438    445    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0064:
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
    
    protected abstract void onMessage(final Context p0, final Intent p1);
    
    protected boolean onRecoverableError(final Context context, final String s) {
        return true;
    }
    
    protected abstract void onRegistered(final Context p0, final String p1);
    
    protected abstract void onUnregistered(final Context p0, final String p1);
}

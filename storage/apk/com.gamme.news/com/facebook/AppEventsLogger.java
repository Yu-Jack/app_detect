// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import org.json.JSONObject;
import java.io.Serializable;
import java.util.Currency;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONArray;
import com.facebook.internal.AttributionIdentifiers;
import android.os.Bundle;
import com.facebook.model.GraphObject;
import com.facebook.internal.Logger;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;
import java.util.Iterator;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import android.content.Context;

public class AppEventsLogger
{
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
    private static final int APP_ACTIVATE_SUPPRESSION_PERIOD_IN_SECONDS = 300;
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
    private static final int APP_SUPPORTS_ATTRIBUTION_ID_RECHECK_PERIOD_IN_SECONDS = 86400;
    private static final int FLUSH_PERIOD_IN_SECONDS = 60;
    private static final int NUM_LOG_EVENTS_TO_TRY_TO_FLUSH_AFTER = 100;
    private static final String TAG;
    private static Context applicationContext;
    private static FlushBehavior flushBehavior;
    private static Timer flushTimer;
    private static String hashedDeviceAndAppId;
    private static Map<String, EventSuppression> mapEventNameToSuppress;
    private static Map<String, Date> mapEventsToSuppressionTime;
    private static boolean requestInFlight;
    private static Map<AccessTokenAppIdPair, SessionEventsState> stateMap;
    private static Object staticLock;
    private static Timer supportsAttributionRecheckTimer;
    private final AccessTokenAppIdPair accessTokenAppId;
    private final Context context;
    
    static {
        TAG = AppEventsLogger.class.getCanonicalName();
        AppEventsLogger.stateMap = new ConcurrentHashMap<AccessTokenAppIdPair, SessionEventsState>();
        AppEventsLogger.flushBehavior = FlushBehavior.AUTO;
        AppEventsLogger.staticLock = new Object();
        AppEventsLogger.mapEventsToSuppressionTime = new HashMap<String, Date>();
        AppEventsLogger.mapEventNameToSuppress = new HashMap<String, EventSuppression>() {
            {
                this.put("fb_mobile_activate_app", new EventSuppression(300, SuppressionTimeoutBehavior.RESET_TIMEOUT_WHEN_LOG_ATTEMPTED));
            }
        };
    }
    
    private AppEventsLogger(final Context context, String metadataApplicationId, Session activeSession) {
        Validate.notNull(context, "context");
        this.context = context;
        if (activeSession == null) {
            activeSession = Session.getActiveSession();
        }
        Label_0081: {
            if (activeSession == null) {
                break Label_0081;
            }
            this.accessTokenAppId = new AccessTokenAppIdPair(activeSession);
        Label_0090_Outer:
            while (true) {
                synchronized (AppEventsLogger.staticLock) {
                    if (AppEventsLogger.hashedDeviceAndAppId == null) {
                        AppEventsLogger.hashedDeviceAndAppId = Utility.getHashedDeviceAndAppID(context, metadataApplicationId);
                    }
                    if (AppEventsLogger.applicationContext == null) {
                        AppEventsLogger.applicationContext = context.getApplicationContext();
                    }
                    initializeTimersIfNeeded();
                    return;
                    // iftrue(Label_0090:, metadataApplicationId != null)
                    while (true) {
                        Block_7: {
                            break Block_7;
                            this.accessTokenAppId = new AccessTokenAppIdPair(null, metadataApplicationId);
                            continue Label_0090_Outer;
                        }
                        metadataApplicationId = Utility.getMetadataApplicationId(context);
                        continue;
                    }
                }
            }
        }
    }
    
    private static int accumulatePersistedEvents() {
        final PersistedEvents andClearStore = PersistedEvents.readAndClearStore(AppEventsLogger.applicationContext);
        int n = 0;
        for (final AccessTokenAppIdPair accessTokenAppIdPair : andClearStore.keySet()) {
            final SessionEventsState sessionEventsState = getSessionEventsState(AppEventsLogger.applicationContext, accessTokenAppIdPair);
            final List<AppEvent> events = andClearStore.getEvents(accessTokenAppIdPair);
            sessionEventsState.accumulatePersistedEvents(events);
            n += events.size();
        }
        return n;
    }
    
    public static void activateApp(final Context context) {
        activateApp(context, Utility.getMetadataApplicationId(context));
    }
    
    public static void activateApp(final Context context, final String s) {
        if (context == null || s == null) {
            throw new IllegalArgumentException("Both context and applicationId must be non-null");
        }
        Settings.publishInstallAsync(context, s);
        new AppEventsLogger(context, s, null).logEvent("fb_mobile_activate_app");
    }
    
    private static FlushStatistics buildAndExecuteRequests(final FlushReason flushReason, final Set<AccessTokenAppIdPair> set) {
        final FlushStatistics flushStatistics = new FlushStatistics(null);
        final boolean limitEventAndDataUsage = Settings.getLimitEventAndDataUsage(AppEventsLogger.applicationContext);
        final ArrayList<Request> list = new ArrayList<Request>();
        for (final AccessTokenAppIdPair accessTokenAppIdPair : set) {
            final SessionEventsState sessionEventsState = getSessionEventsState(accessTokenAppIdPair);
            if (sessionEventsState != null) {
                final Request buildRequestForSession = buildRequestForSession(accessTokenAppIdPair, sessionEventsState, limitEventAndDataUsage, flushStatistics);
                if (buildRequestForSession == null) {
                    continue;
                }
                list.add(buildRequestForSession);
            }
        }
        if (list.size() > 0) {
            Logger.log(LoggingBehavior.APP_EVENTS, AppEventsLogger.TAG, "Flushing %d events due to %s.", flushStatistics.numEvents, flushReason.toString());
            final Iterator<Object> iterator2 = list.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().executeAndWait();
            }
            return flushStatistics;
        }
        return null;
    }
    
    private static Request buildRequestForSession(final AccessTokenAppIdPair accessTokenAppIdPair, final SessionEventsState sessionEventsState, final boolean b, final FlushStatistics flushStatistics) {
        final String applicationId = accessTokenAppIdPair.getApplicationId();
        final Utility.FetchedAppSettings queryAppSettings = Utility.queryAppSettings(applicationId, false);
        final Request postRequest = Request.newPostRequest(null, String.format("%s/activities", applicationId), null, null);
        Bundle parameters = postRequest.getParameters();
        if (parameters == null) {
            parameters = new Bundle();
        }
        parameters.putString("access_token", accessTokenAppIdPair.getAccessToken());
        postRequest.setParameters(parameters);
        final int populateRequest = sessionEventsState.populateRequest(postRequest, queryAppSettings.supportsImplicitLogging(), queryAppSettings.supportsAttribution(), b);
        if (populateRequest == 0) {
            return null;
        }
        flushStatistics.numEvents += populateRequest;
        postRequest.setCallback((Request.Callback)new Request.Callback() {
            @Override
            public void onCompleted(final Response response) {
                handleResponse(accessTokenAppIdPair, postRequest, response, sessionEventsState, flushStatistics);
            }
        });
        return postRequest;
    }
    
    static void eagerFlush() {
        if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
            flush(FlushReason.EAGER_FLUSHING_EVENT);
        }
    }
    
    private static void flush(final FlushReason flushReason) {
        Settings.getExecutor().execute(new Runnable() {
            @Override
            public void run() {
                flushAndWait(flushReason);
            }
        });
    }
    
    private static void flushAndWait(final FlushReason p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: getstatic       com/facebook/AppEventsLogger.staticLock:Ljava/lang/Object;
        //     3: astore_1       
        //     4: aload_1        
        //     5: monitorenter   
        //     6: getstatic       com/facebook/AppEventsLogger.requestInFlight:Z
        //     9: ifeq            15
        //    12: aload_1        
        //    13: monitorexit    
        //    14: return         
        //    15: iconst_1       
        //    16: putstatic       com/facebook/AppEventsLogger.requestInFlight:Z
        //    19: new             Ljava/util/HashSet;
        //    22: dup            
        //    23: getstatic       com/facebook/AppEventsLogger.stateMap:Ljava/util/Map;
        //    26: invokeinterface java/util/Map.keySet:()Ljava/util/Set;
        //    31: invokespecial   java/util/HashSet.<init>:(Ljava/util/Collection;)V
        //    34: astore_3       
        //    35: aload_1        
        //    36: monitorexit    
        //    37: invokestatic    com/facebook/AppEventsLogger.accumulatePersistedEvents:()I
        //    40: pop            
        //    41: aload_0        
        //    42: aload_3        
        //    43: invokestatic    com/facebook/AppEventsLogger.buildAndExecuteRequests:(Lcom/facebook/AppEventsLogger$FlushReason;Ljava/util/Set;)Lcom/facebook/AppEventsLogger$FlushStatistics;
        //    46: astore          14
        //    48: aload           14
        //    50: astore          7
        //    52: getstatic       com/facebook/AppEventsLogger.staticLock:Ljava/lang/Object;
        //    55: astore          8
        //    57: aload           8
        //    59: monitorenter   
        //    60: iconst_0       
        //    61: putstatic       com/facebook/AppEventsLogger.requestInFlight:Z
        //    64: aload           8
        //    66: monitorexit    
        //    67: aload           7
        //    69: ifnull          171
        //    72: new             Landroid/content/Intent;
        //    75: dup            
        //    76: ldc             "com.facebook.sdk.APP_EVENTS_FLUSHED"
        //    78: invokespecial   android/content/Intent.<init>:(Ljava/lang/String;)V
        //    81: astore          10
        //    83: aload           10
        //    85: ldc             "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED"
        //    87: aload           7
        //    89: getfield        com/facebook/AppEventsLogger$FlushStatistics.numEvents:I
        //    92: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;I)Landroid/content/Intent;
        //    95: pop            
        //    96: aload           10
        //    98: ldc             "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT"
        //   100: aload           7
        //   102: getfield        com/facebook/AppEventsLogger$FlushStatistics.result:Lcom/facebook/AppEventsLogger$FlushResult;
        //   105: invokevirtual   android/content/Intent.putExtra:(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
        //   108: pop            
        //   109: getstatic       com/facebook/AppEventsLogger.applicationContext:Landroid/content/Context;
        //   112: invokestatic    android/support/v4/content/LocalBroadcastManager.getInstance:(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;
        //   115: aload           10
        //   117: invokevirtual   android/support/v4/content/LocalBroadcastManager.sendBroadcast:(Landroid/content/Intent;)Z
        //   120: pop            
        //   121: return         
        //   122: astore_2       
        //   123: aload_1        
        //   124: monitorexit    
        //   125: aload_2        
        //   126: athrow         
        //   127: astore          5
        //   129: getstatic       com/facebook/AppEventsLogger.TAG:Ljava/lang/String;
        //   132: new             Ljava/lang/StringBuilder;
        //   135: dup            
        //   136: ldc_w           "Caught unexpected exception while flushing: "
        //   139: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   142: aload           5
        //   144: invokevirtual   java/lang/Exception.toString:()Ljava/lang/String;
        //   147: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   150: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   153: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   156: pop            
        //   157: aconst_null    
        //   158: astore          7
        //   160: goto            52
        //   163: astore          9
        //   165: aload           8
        //   167: monitorexit    
        //   168: aload           9
        //   170: athrow         
        //   171: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  6      14     122    127    Any
        //  15     37     122    127    Any
        //  41     48     127    163    Ljava/lang/Exception;
        //  60     67     163    171    Any
        //  123    125    122    127    Any
        //  165    168    163    171    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 86, Size: 86
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
    
    private static void flushIfNecessary() {
        synchronized (AppEventsLogger.staticLock) {
            if (getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY && getAccumulatedEventCount() > 100) {
                flush(FlushReason.EVENT_THRESHOLD);
            }
        }
    }
    
    private static int getAccumulatedEventCount() {
        final Object staticLock = AppEventsLogger.staticLock;
        // monitorenter(staticLock)
        int n = 0;
        try {
            final Iterator<SessionEventsState> iterator = AppEventsLogger.stateMap.values().iterator();
            while (iterator.hasNext()) {
                n += iterator.next().getAccumulatedEventCount();
            }
            return n;
        }
        finally {
        }
        // monitorexit(staticLock)
    }
    
    public static FlushBehavior getFlushBehavior() {
        synchronized (AppEventsLogger.staticLock) {
            return AppEventsLogger.flushBehavior;
        }
    }
    
    @Deprecated
    public static boolean getLimitEventUsage(final Context context) {
        return Settings.getLimitEventAndDataUsage(context);
    }
    
    private static SessionEventsState getSessionEventsState(final Context context, final AccessTokenAppIdPair accessTokenAppIdPair) {
        synchronized (AppEventsLogger.staticLock) {
            SessionEventsState sessionEventsState = AppEventsLogger.stateMap.get(accessTokenAppIdPair);
            if (sessionEventsState == null) {
                sessionEventsState = new SessionEventsState(AttributionIdentifiers.getAttributionIdentifiers(context), context.getPackageName(), AppEventsLogger.hashedDeviceAndAppId);
                AppEventsLogger.stateMap.put(accessTokenAppIdPair, sessionEventsState);
            }
            return sessionEventsState;
        }
    }
    
    private static SessionEventsState getSessionEventsState(final AccessTokenAppIdPair accessTokenAppIdPair) {
        synchronized (AppEventsLogger.staticLock) {
            return AppEventsLogger.stateMap.get(accessTokenAppIdPair);
        }
    }
    
    private static void handleResponse(final AccessTokenAppIdPair accessTokenAppIdPair, final Request request, final Response response, final SessionEventsState sessionEventsState, final FlushStatistics flushStatistics) {
        final FacebookRequestError error = response.getError();
        String format = "Success";
        FlushResult result = FlushResult.SUCCESS;
        while (true) {
            while (true) {
                Label_0040: {
                    if (error == null) {
                        break Label_0040;
                    }
                    if (error.getErrorCode() == -1) {
                        format = "Failed: No Connectivity";
                        result = FlushResult.NO_CONNECTIVITY;
                        break Label_0040;
                    }
                    Label_0185: {
                        break Label_0185;
                    Label_0136_Outer:
                        while (true) {
                            final String s = (String)request.getTag();
                            while (true) {
                            Label_0236:
                                while (true) {
                                    try {
                                        final String string = new JSONArray(s).toString(2);
                                        Logger.log(LoggingBehavior.APP_EVENTS, AppEventsLogger.TAG, "Flush completed\nParams: %s\n  Result: %s\n  Events JSON: %s", request.getGraphObject().toString(), format, string);
                                        if (error != null) {
                                            final boolean b = true;
                                            sessionEventsState.clearInFlightAndStats(b);
                                            if (result == FlushResult.NO_CONNECTIVITY) {
                                                PersistedEvents.persistEvents(AppEventsLogger.applicationContext, accessTokenAppIdPair, sessionEventsState);
                                            }
                                            if (result != FlushResult.SUCCESS && flushStatistics.result != FlushResult.NO_CONNECTIVITY) {
                                                flushStatistics.result = result;
                                            }
                                            return;
                                        }
                                        break Label_0236;
                                        format = String.format("Failed:\n  Response: %s\n  Error %s", response.toString(), error.toString());
                                        result = FlushResult.SERVER_ERROR;
                                        break;
                                    }
                                    catch (JSONException ex) {
                                        final String string = "<Can't encode events for debug logging>";
                                        continue Label_0136_Outer;
                                    }
                                    break;
                                }
                                final boolean b = false;
                                continue;
                            }
                        }
                    }
                }
                if (Settings.isLoggingBehaviorEnabled(LoggingBehavior.APP_EVENTS)) {
                    continue;
                }
                break;
            }
            continue;
        }
    }
    
    private static void initializeTimersIfNeeded() {
        synchronized (AppEventsLogger.staticLock) {
            if (AppEventsLogger.flushTimer != null) {
                return;
            }
            AppEventsLogger.flushTimer = new Timer();
            AppEventsLogger.supportsAttributionRecheckTimer = new Timer();
            // monitorexit(AppEventsLogger.staticLock)
            AppEventsLogger.flushTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (AppEventsLogger.getFlushBehavior() != FlushBehavior.EXPLICIT_ONLY) {
                        flushAndWait(FlushReason.TIMER);
                    }
                }
            }, 0L, 60000L);
            AppEventsLogger.supportsAttributionRecheckTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    while (true) {
                        final HashSet<String> set = new HashSet<String>();
                        while (true) {
                            final Iterator<Object> iterator2;
                            synchronized (AppEventsLogger.staticLock) {
                                final Iterator<AccessTokenAppIdPair> iterator = AppEventsLogger.stateMap.keySet().iterator();
                                while (iterator.hasNext()) {
                                    set.add(iterator.next().getApplicationId());
                                }
                                // monitorexit(AppEventsLogger.access$2())
                                iterator2 = set.iterator();
                                if (!iterator2.hasNext()) {
                                    return;
                                }
                            }
                            Utility.queryAppSettings(iterator2.next(), true);
                            continue;
                        }
                    }
                }
            }, 0L, 86400000L);
        }
    }
    
    private static void logEvent(final Context context, final AppEvent appEvent, final AccessTokenAppIdPair accessTokenAppIdPair) {
        if (shouldSuppressEvent(appEvent)) {
            return;
        }
        getSessionEventsState(context, accessTokenAppIdPair).addEvent(appEvent);
        flushIfNecessary();
    }
    
    private void logEvent(final String s, final Double n, final Bundle bundle, final boolean b) {
        logEvent(this.context, new AppEvent(s, n, bundle, b), this.accessTokenAppId);
    }
    
    public static AppEventsLogger newLogger(final Context context) {
        return new AppEventsLogger(context, null, null);
    }
    
    public static AppEventsLogger newLogger(final Context context, final Session session) {
        return new AppEventsLogger(context, null, session);
    }
    
    public static AppEventsLogger newLogger(final Context context, final String s) {
        return new AppEventsLogger(context, s, null);
    }
    
    public static AppEventsLogger newLogger(final Context context, final String s, final Session session) {
        return new AppEventsLogger(context, s, session);
    }
    
    private static void notifyDeveloperError(final String s) {
        Logger.log(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", s);
    }
    
    public static void onContextStop() {
        PersistedEvents.persistEvents(AppEventsLogger.applicationContext, AppEventsLogger.stateMap);
    }
    
    public static void setFlushBehavior(final FlushBehavior flushBehavior) {
        synchronized (AppEventsLogger.staticLock) {
            AppEventsLogger.flushBehavior = flushBehavior;
        }
    }
    
    @Deprecated
    public static void setLimitEventUsage(final Context context, final boolean b) {
        Settings.setLimitEventAndDataUsage(context, b);
    }
    
    private static boolean shouldSuppressEvent(final AppEvent appEvent) {
        final EventSuppression eventSuppression = AppEventsLogger.mapEventNameToSuppress.get(appEvent.getName());
        boolean b = false;
        if (eventSuppression != null) {
            final Date date = AppEventsLogger.mapEventsToSuppressionTime.get(appEvent.getName());
            if (date == null) {
                b = false;
            }
            else {
                final long n = lcmp(new Date().getTime() - date.getTime(), (long)(1000 * eventSuppression.getTimeoutPeriod()));
                b = false;
                if (n < 0) {
                    b = true;
                }
            }
            if (!b || eventSuppression.getBehavior() == SuppressionTimeoutBehavior.RESET_TIMEOUT_WHEN_LOG_ATTEMPTED) {
                AppEventsLogger.mapEventsToSuppressionTime.put(appEvent.getName(), new Date());
                return b;
            }
        }
        return b;
    }
    
    public void flush() {
        flush(FlushReason.EXPLICIT);
    }
    
    public String getApplicationId() {
        return this.accessTokenAppId.getApplicationId();
    }
    
    boolean isValidForSession(final Session session) {
        return this.accessTokenAppId.equals(new AccessTokenAppIdPair(session));
    }
    
    public void logEvent(final String s) {
        this.logEvent(s, null);
    }
    
    public void logEvent(final String s, final double n) {
        this.logEvent(s, n, null);
    }
    
    public void logEvent(final String s, final double d, final Bundle bundle) {
        this.logEvent(s, d, bundle, false);
    }
    
    public void logEvent(final String s, final Bundle bundle) {
        this.logEvent(s, null, bundle, false);
    }
    
    public void logPurchase(final BigDecimal bigDecimal, final Currency currency) {
        this.logPurchase(bigDecimal, currency, null);
    }
    
    public void logPurchase(final BigDecimal bigDecimal, final Currency currency, Bundle bundle) {
        if (bigDecimal == null) {
            notifyDeveloperError("purchaseAmount cannot be null");
            return;
        }
        if (currency == null) {
            notifyDeveloperError("currency cannot be null");
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("fb_currency", currency.getCurrencyCode());
        this.logEvent("fb_mobile_purchase", bigDecimal.doubleValue(), bundle);
        eagerFlush();
    }
    
    public void logSdkEvent(final String s, final Double n, final Bundle bundle) {
        this.logEvent(s, n, bundle, true);
    }
    
    private static class AccessTokenAppIdPair implements Serializable
    {
        private static final long serialVersionUID = 1L;
        private final String accessToken;
        private final String applicationId;
        
        AccessTokenAppIdPair(final Session session) {
            this(session.getAccessToken(), session.getApplicationId());
        }
        
        AccessTokenAppIdPair(String accessToken, final String applicationId) {
            if (Utility.isNullOrEmpty(accessToken)) {
                accessToken = null;
            }
            this.accessToken = accessToken;
            this.applicationId = applicationId;
        }
        
        private Object writeReplace() {
            return new SerializationProxyV1(this.accessToken, this.applicationId, null);
        }
        
        @Override
        public boolean equals(final Object o) {
            if (o instanceof AccessTokenAppIdPair) {
                final AccessTokenAppIdPair accessTokenAppIdPair = (AccessTokenAppIdPair)o;
                if (Utility.areObjectsEqual(accessTokenAppIdPair.accessToken, this.accessToken) && Utility.areObjectsEqual(accessTokenAppIdPair.applicationId, this.applicationId)) {
                    return true;
                }
            }
            return false;
        }
        
        String getAccessToken() {
            return this.accessToken;
        }
        
        String getApplicationId() {
            return this.applicationId;
        }
        
        @Override
        public int hashCode() {
            int hashCode;
            if (this.accessToken == null) {
                hashCode = 0;
            }
            else {
                hashCode = this.accessToken.hashCode();
            }
            final String applicationId = this.applicationId;
            int hashCode2 = 0;
            if (applicationId != null) {
                hashCode2 = this.applicationId.hashCode();
            }
            return hashCode ^ hashCode2;
        }
        
        private static class SerializationProxyV1 implements Serializable
        {
            private static final long serialVersionUID = -2488473066578201069L;
            private final String accessToken;
            private final String appId;
            
            private SerializationProxyV1(final String accessToken, final String appId) {
                this.accessToken = accessToken;
                this.appId = appId;
            }
            
            private Object readResolve() {
                return new AccessTokenAppIdPair(this.accessToken, this.appId);
            }
        }
    }
    
    static class AppEvent implements Serializable
    {
        private static final long serialVersionUID = 1L;
        private static final HashSet<String> validatedIdentifiers;
        private boolean isImplicit;
        private JSONObject jsonObject;
        private String name;
        
        static {
            validatedIdentifiers = new HashSet<String>();
        }
        
        public AppEvent(final String name, final Double n, final Bundle bundle, final boolean isImplicit) {
            while (true) {
                this.validateIdentifier(name);
                this.name = name;
                this.isImplicit = isImplicit;
                this.jsonObject = new JSONObject();
                while (true) {
                    String s = null;
                    Object value = null;
                    Label_0292: {
                        try {
                            this.jsonObject.put("_eventName", (Object)name);
                            this.jsonObject.put("_logTime", System.currentTimeMillis() / 1000L);
                            if (n != null) {
                                this.jsonObject.put("_valueToSum", (double)n);
                            }
                            if (this.isImplicit) {
                                this.jsonObject.put("_implicitlyLogged", (Object)"1");
                            }
                            final String appVersion = Settings.getAppVersion();
                            if (appVersion != null) {
                                this.jsonObject.put("_appVersion", (Object)appVersion);
                            }
                            if (bundle != null) {
                                final Iterator<String> iterator = bundle.keySet().iterator();
                                if (iterator.hasNext()) {
                                    s = iterator.next();
                                    this.validateIdentifier(s);
                                    value = bundle.get(s);
                                    if (!(value instanceof String) && !(value instanceof Number)) {
                                        throw new FacebookException(String.format("Parameter value '%s' for key '%s' should be a string or a numeric type.", value, s));
                                    }
                                    break Label_0292;
                                }
                            }
                            if (!this.isImplicit) {
                                Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "Created app event '%s'", this.jsonObject.toString());
                                return;
                            }
                            break;
                        }
                        catch (JSONException ex) {
                            Logger.log(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", ex.toString());
                            this.jsonObject = null;
                            return;
                        }
                    }
                    this.jsonObject.put(s, (Object)value.toString());
                    continue;
                }
            }
        }
        
        private AppEvent(final String s, final boolean isImplicit) throws JSONException {
            this.jsonObject = new JSONObject(s);
            this.isImplicit = isImplicit;
        }
        
        private void validateIdentifier(final String p0) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     0: aload_1        
            //     1: ifnull          20
            //     4: aload_1        
            //     5: invokevirtual   java/lang/String.length:()I
            //     8: ifeq            20
            //    11: aload_1        
            //    12: invokevirtual   java/lang/String.length:()I
            //    15: bipush          40
            //    17: if_icmple       58
            //    20: aload_1        
            //    21: ifnonnull       27
            //    24: ldc             "<None Provided>"
            //    26: astore_1       
            //    27: iconst_2       
            //    28: anewarray       Ljava/lang/Object;
            //    31: astore_2       
            //    32: aload_2        
            //    33: iconst_0       
            //    34: aload_1        
            //    35: aastore        
            //    36: aload_2        
            //    37: iconst_1       
            //    38: bipush          40
            //    40: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
            //    43: aastore        
            //    44: new             Lcom/facebook/FacebookException;
            //    47: dup            
            //    48: ldc             "Identifier '%s' must be less than %d characters"
            //    50: aload_2        
            //    51: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
            //    54: invokespecial   com/facebook/FacebookException.<init>:(Ljava/lang/String;)V
            //    57: athrow         
            //    58: getstatic       com/facebook/AppEventsLogger$AppEvent.validatedIdentifiers:Ljava/util/HashSet;
            //    61: astore_3       
            //    62: aload_3        
            //    63: monitorenter   
            //    64: getstatic       com/facebook/AppEventsLogger$AppEvent.validatedIdentifiers:Ljava/util/HashSet;
            //    67: aload_1        
            //    68: invokevirtual   java/util/HashSet.contains:(Ljava/lang/Object;)Z
            //    71: istore          5
            //    73: aload_3        
            //    74: monitorexit    
            //    75: iload           5
            //    77: ifne            108
            //    80: aload_1        
            //    81: ldc             "^[0-9a-zA-Z_]+[0-9a-zA-Z _-]*$"
            //    83: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
            //    86: ifeq            124
            //    89: getstatic       com/facebook/AppEventsLogger$AppEvent.validatedIdentifiers:Ljava/util/HashSet;
            //    92: astore          6
            //    94: aload           6
            //    96: monitorenter   
            //    97: getstatic       com/facebook/AppEventsLogger$AppEvent.validatedIdentifiers:Ljava/util/HashSet;
            //   100: aload_1        
            //   101: invokevirtual   java/util/HashSet.add:(Ljava/lang/Object;)Z
            //   104: pop            
            //   105: aload           6
            //   107: monitorexit    
            //   108: return         
            //   109: astore          4
            //   111: aload_3        
            //   112: monitorexit    
            //   113: aload           4
            //   115: athrow         
            //   116: astore          7
            //   118: aload           6
            //   120: monitorexit    
            //   121: aload           7
            //   123: athrow         
            //   124: new             Lcom/facebook/FacebookException;
            //   127: dup            
            //   128: ldc             "Skipping event named '%s' due to illegal name - must be under 40 chars and alphanumeric, _, - or space, and not start with a space or hyphen."
            //   130: iconst_1       
            //   131: anewarray       Ljava/lang/Object;
            //   134: dup            
            //   135: iconst_0       
            //   136: aload_1        
            //   137: aastore        
            //   138: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
            //   141: invokespecial   com/facebook/FacebookException.<init>:(Ljava/lang/String;)V
            //   144: athrow         
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type
            //  -----  -----  -----  -----  ----
            //  64     75     109    116    Any
            //  97     108    116    124    Any
            //  111    113    109    116    Any
            //  118    121    116    124    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0108:
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:556)
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
        
        private Object writeReplace() {
            return new SerializationProxyV1(this.jsonObject.toString(), this.isImplicit, null);
        }
        
        public boolean getIsImplicit() {
            return this.isImplicit;
        }
        
        public JSONObject getJSONObject() {
            return this.jsonObject;
        }
        
        public String getName() {
            return this.name;
        }
        
        @Override
        public String toString() {
            return String.format("\"%s\", implicit: %b, json: %s", this.jsonObject.optString("_eventName"), this.isImplicit, this.jsonObject.toString());
        }
        
        private static class SerializationProxyV1 implements Serializable
        {
            private static final long serialVersionUID = -2488473066578201069L;
            private final boolean isImplicit;
            private final String jsonString;
            
            private SerializationProxyV1(final String jsonString, final boolean isImplicit) {
                this.jsonString = jsonString;
                this.isImplicit = isImplicit;
            }
            
            private Object readResolve() throws JSONException {
                return new AppEvent(this.jsonString, this.isImplicit, null);
            }
        }
    }
    
    private static class EventSuppression
    {
        private SuppressionTimeoutBehavior behavior;
        private int timeoutPeriod;
        
        EventSuppression(final int timeoutPeriod, final SuppressionTimeoutBehavior behavior) {
            this.timeoutPeriod = timeoutPeriod;
            this.behavior = behavior;
        }
        
        SuppressionTimeoutBehavior getBehavior() {
            return this.behavior;
        }
        
        int getTimeoutPeriod() {
            return this.timeoutPeriod;
        }
    }
    
    public enum FlushBehavior
    {
        AUTO("AUTO", 0), 
        EXPLICIT_ONLY("EXPLICIT_ONLY", 1);
        
        private FlushBehavior(final String name, final int ordinal) {
        }
    }
    
    private enum FlushReason
    {
        EAGER_FLUSHING_EVENT("EAGER_FLUSHING_EVENT", 5), 
        EVENT_THRESHOLD("EVENT_THRESHOLD", 4), 
        EXPLICIT("EXPLICIT", 0), 
        PERSISTED_EVENTS("PERSISTED_EVENTS", 3), 
        SESSION_CHANGE("SESSION_CHANGE", 2), 
        TIMER("TIMER", 1);
        
        private FlushReason(final String name, final int ordinal) {
        }
    }
    
    private enum FlushResult
    {
        NO_CONNECTIVITY("NO_CONNECTIVITY", 2), 
        SERVER_ERROR("SERVER_ERROR", 1), 
        SUCCESS("SUCCESS", 0), 
        UNKNOWN_ERROR("UNKNOWN_ERROR", 3);
        
        private FlushResult(final String name, final int ordinal) {
        }
    }
    
    private static class FlushStatistics
    {
        public int numEvents;
        public FlushResult result;
        
        private FlushStatistics() {
            this.numEvents = 0;
            this.result = FlushResult.SUCCESS;
        }
    }
    
    static class PersistedEvents
    {
        static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
        private static Object staticLock;
        private Context context;
        private HashMap<AccessTokenAppIdPair, List<AppEvent>> persistedEvents;
        
        static {
            PersistedEvents.staticLock = new Object();
        }
        
        private PersistedEvents(final Context context) {
            this.persistedEvents = new HashMap<AccessTokenAppIdPair, List<AppEvent>>();
            this.context = context;
        }
        
        public static void persistEvents(final Context context, final AccessTokenAppIdPair accessTokenAppIdPair, final SessionEventsState sessionEventsState) {
            final HashMap<AccessTokenAppIdPair, SessionEventsState> hashMap = new HashMap<AccessTokenAppIdPair, SessionEventsState>();
            hashMap.put(accessTokenAppIdPair, sessionEventsState);
            persistEvents(context, hashMap);
        }
        
        public static void persistEvents(final Context context, final Map<AccessTokenAppIdPair, SessionEventsState> map) {
            synchronized (PersistedEvents.staticLock) {
                final PersistedEvents andClearStore = readAndClearStore(context);
                for (final Map.Entry<AccessTokenAppIdPair, SessionEventsState> entry : map.entrySet()) {
                    final List<AppEvent> eventsToPersist = entry.getValue().getEventsToPersist();
                    if (eventsToPersist.size() != 0) {
                        andClearStore.addEvents(entry.getKey(), eventsToPersist);
                    }
                }
                andClearStore.write();
            }
        }
        
        public static PersistedEvents readAndClearStore(final Context context) {
            synchronized (PersistedEvents.staticLock) {
                final PersistedEvents persistedEvents = new PersistedEvents(context);
                persistedEvents.readAndClearStore();
                return persistedEvents;
            }
        }
        
        private void readAndClearStore() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     0: aconst_null    
            //     1: astore_1       
            //     2: new             Ljava/io/ObjectInputStream;
            //     5: dup            
            //     6: new             Ljava/io/BufferedInputStream;
            //     9: dup            
            //    10: aload_0        
            //    11: getfield        com/facebook/AppEventsLogger$PersistedEvents.context:Landroid/content/Context;
            //    14: ldc             "AppEventsLogger.persistedevents"
            //    16: invokevirtual   android/content/Context.openFileInput:(Ljava/lang/String;)Ljava/io/FileInputStream;
            //    19: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
            //    22: invokespecial   java/io/ObjectInputStream.<init>:(Ljava/io/InputStream;)V
            //    25: astore_2       
            //    26: aload_2        
            //    27: invokevirtual   java/io/ObjectInputStream.readObject:()Ljava/lang/Object;
            //    30: checkcast       Ljava/util/HashMap;
            //    33: astore          7
            //    35: aload_0        
            //    36: getfield        com/facebook/AppEventsLogger$PersistedEvents.context:Landroid/content/Context;
            //    39: ldc             "AppEventsLogger.persistedevents"
            //    41: invokevirtual   android/content/Context.getFileStreamPath:(Ljava/lang/String;)Ljava/io/File;
            //    44: invokevirtual   java/io/File.delete:()Z
            //    47: pop            
            //    48: aload_0        
            //    49: aload           7
            //    51: putfield        com/facebook/AppEventsLogger$PersistedEvents.persistedEvents:Ljava/util/HashMap;
            //    54: aload_2        
            //    55: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
            //    58: return         
            //    59: astore          9
            //    61: aload_1        
            //    62: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
            //    65: return         
            //    66: astore          4
            //    68: invokestatic    com/facebook/AppEventsLogger.access$0:()Ljava/lang/String;
            //    71: new             Ljava/lang/StringBuilder;
            //    74: dup            
            //    75: ldc             "Got unexpected exception: "
            //    77: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
            //    80: aload           4
            //    82: invokevirtual   java/lang/Exception.toString:()Ljava/lang/String;
            //    85: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    88: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //    91: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
            //    94: pop            
            //    95: aload_1        
            //    96: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
            //    99: return         
            //   100: astore          5
            //   102: aload_1        
            //   103: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
            //   106: aload           5
            //   108: athrow         
            //   109: astore          5
            //   111: aload_2        
            //   112: astore_1       
            //   113: goto            102
            //   116: astore          4
            //   118: aload_2        
            //   119: astore_1       
            //   120: goto            68
            //   123: astore_3       
            //   124: aload_2        
            //   125: astore_1       
            //   126: goto            61
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                           
            //  -----  -----  -----  -----  -------------------------------
            //  2      26     59     61     Ljava/io/FileNotFoundException;
            //  2      26     66     68     Ljava/lang/Exception;
            //  2      26     100    102    Any
            //  26     54     123    129    Ljava/io/FileNotFoundException;
            //  26     54     116    123    Ljava/lang/Exception;
            //  26     54     109    116    Any
            //  68     95     100    102    Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0068:
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:556)
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
        
        private void write() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     0: aconst_null    
            //     1: astore_1       
            //     2: new             Ljava/io/ObjectOutputStream;
            //     5: dup            
            //     6: new             Ljava/io/BufferedOutputStream;
            //     9: dup            
            //    10: aload_0        
            //    11: getfield        com/facebook/AppEventsLogger$PersistedEvents.context:Landroid/content/Context;
            //    14: ldc             "AppEventsLogger.persistedevents"
            //    16: iconst_0       
            //    17: invokevirtual   android/content/Context.openFileOutput:(Ljava/lang/String;I)Ljava/io/FileOutputStream;
            //    20: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;)V
            //    23: invokespecial   java/io/ObjectOutputStream.<init>:(Ljava/io/OutputStream;)V
            //    26: astore_2       
            //    27: aload_2        
            //    28: aload_0        
            //    29: getfield        com/facebook/AppEventsLogger$PersistedEvents.persistedEvents:Ljava/util/HashMap;
            //    32: invokevirtual   java/io/ObjectOutputStream.writeObject:(Ljava/lang/Object;)V
            //    35: aload_2        
            //    36: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
            //    39: return         
            //    40: astore_3       
            //    41: invokestatic    com/facebook/AppEventsLogger.access$0:()Ljava/lang/String;
            //    44: new             Ljava/lang/StringBuilder;
            //    47: dup            
            //    48: ldc             "Got unexpected exception: "
            //    50: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
            //    53: aload_3        
            //    54: invokevirtual   java/lang/Exception.toString:()Ljava/lang/String;
            //    57: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //    60: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
            //    63: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
            //    66: pop            
            //    67: aload_1        
            //    68: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
            //    71: return         
            //    72: astore          4
            //    74: aload_1        
            //    75: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
            //    78: aload           4
            //    80: athrow         
            //    81: astore          4
            //    83: aload_2        
            //    84: astore_1       
            //    85: goto            74
            //    88: astore_3       
            //    89: aload_2        
            //    90: astore_1       
            //    91: goto            41
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                 
            //  -----  -----  -----  -----  ---------------------
            //  2      27     40     41     Ljava/lang/Exception;
            //  2      27     72     74     Any
            //  27     35     88     94     Ljava/lang/Exception;
            //  27     35     81     88     Any
            //  41     67     72     74     Any
            // 
            // The error that occurred was:
            // 
            // java.lang.IllegalStateException: Expression is linked from several locations: Label_0041:
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:556)
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
        
        public void addEvents(final AccessTokenAppIdPair key, final List<AppEvent> list) {
            if (!this.persistedEvents.containsKey(key)) {
                this.persistedEvents.put(key, new ArrayList<AppEvent>());
            }
            this.persistedEvents.get(key).addAll(list);
        }
        
        public List<AppEvent> getEvents(final AccessTokenAppIdPair key) {
            return this.persistedEvents.get(key);
        }
        
        public Set<AccessTokenAppIdPair> keySet() {
            return this.persistedEvents.keySet();
        }
    }
    
    static class SessionEventsState
    {
        public static final String ENCODED_EVENTS_KEY = "encoded_events";
        public static final String EVENT_COUNT_KEY = "event_count";
        public static final String NUM_SKIPPED_KEY = "num_skipped";
        private final int MAX_ACCUMULATED_LOG_EVENTS;
        private List<AppEvent> accumulatedEvents;
        private AttributionIdentifiers attributionIdentifiers;
        private String hashedDeviceAndAppId;
        private List<AppEvent> inFlightEvents;
        private int numSkippedEventsDueToFullBuffer;
        private String packageName;
        
        public SessionEventsState(final AttributionIdentifiers attributionIdentifiers, final String packageName, final String hashedDeviceAndAppId) {
            this.accumulatedEvents = new ArrayList<AppEvent>();
            this.inFlightEvents = new ArrayList<AppEvent>();
            this.MAX_ACCUMULATED_LOG_EVENTS = 1000;
            this.attributionIdentifiers = attributionIdentifiers;
            this.packageName = packageName;
            this.hashedDeviceAndAppId = hashedDeviceAndAppId;
        }
        
        private byte[] getStringAsByteArray(final String s) {
            try {
                return s.getBytes("UTF-8");
            }
            catch (UnsupportedEncodingException ex) {
                Utility.logd("Encoding exception: ", ex);
                return null;
            }
        }
        
        private void populateRequest(final Request request, final int i, final JSONArray jsonArray, final boolean b, final boolean b2) {
            final GraphObject create = GraphObject.Factory.create();
            create.setProperty("event", "CUSTOM_APP_EVENTS");
            if (this.numSkippedEventsDueToFullBuffer > 0) {
                create.setProperty("num_skipped_events", i);
            }
            if (b) {
                Utility.setAppEventAttributionParameters(create, this.attributionIdentifiers, this.hashedDeviceAndAppId, b2);
            }
            create.setProperty("application_package_name", this.packageName);
            request.setGraphObject(create);
            Bundle parameters = request.getParameters();
            if (parameters == null) {
                parameters = new Bundle();
            }
            final String string = jsonArray.toString();
            if (string != null) {
                parameters.putByteArray("custom_events_file", this.getStringAsByteArray(string));
                request.setTag(string);
            }
            request.setParameters(parameters);
        }
        
        public void accumulatePersistedEvents(final List<AppEvent> list) {
            synchronized (this) {
                this.accumulatedEvents.addAll(list);
            }
        }
        
        public void addEvent(final AppEvent appEvent) {
            synchronized (this) {
                if (this.accumulatedEvents.size() + this.inFlightEvents.size() >= 1000) {
                    ++this.numSkippedEventsDueToFullBuffer;
                }
                else {
                    this.accumulatedEvents.add(appEvent);
                }
            }
        }
        
        public void clearInFlightAndStats(final boolean b) {
            // monitorenter(this)
            Label_0020: {
                if (!b) {
                    break Label_0020;
                }
                try {
                    this.accumulatedEvents.addAll(this.inFlightEvents);
                    this.inFlightEvents.clear();
                    this.numSkippedEventsDueToFullBuffer = 0;
                }
                finally {
                }
                // monitorexit(this)
            }
        }
        
        public int getAccumulatedEventCount() {
            synchronized (this) {
                return this.accumulatedEvents.size();
            }
        }
        
        public List<AppEvent> getEventsToPersist() {
            synchronized (this) {
                final List<AppEvent> accumulatedEvents = this.accumulatedEvents;
                this.accumulatedEvents = new ArrayList<AppEvent>();
                return accumulatedEvents;
            }
        }
        
        public int populateRequest(final Request request, final boolean b, final boolean b2, final boolean b3) {
            final int numSkippedEventsDueToFullBuffer;
            final JSONArray jsonArray;
            synchronized (this) {
                numSkippedEventsDueToFullBuffer = this.numSkippedEventsDueToFullBuffer;
                this.inFlightEvents.addAll(this.accumulatedEvents);
                this.accumulatedEvents.clear();
                jsonArray = new JSONArray();
                for (final AppEvent appEvent : this.inFlightEvents) {
                    if (b || !appEvent.getIsImplicit()) {
                        jsonArray.put((Object)appEvent.getJSONObject());
                    }
                }
                if (jsonArray.length() == 0) {
                    return 0;
                }
            }
            // monitorexit(this)
            this.populateRequest(request, numSkippedEventsDueToFullBuffer, jsonArray, b2, b3);
            return jsonArray.length();
        }
    }
    
    private enum SuppressionTimeoutBehavior
    {
        RESET_TIMEOUT_WHEN_LOG_ATTEMPTED("RESET_TIMEOUT_WHEN_LOG_ATTEMPTED", 1), 
        RESET_TIMEOUT_WHEN_LOG_SUCCESSFUL("RESET_TIMEOUT_WHEN_LOG_SUCCESSFUL", 0);
        
        private SuppressionTimeoutBehavior(final String name, final int ordinal) {
        }
    }
}

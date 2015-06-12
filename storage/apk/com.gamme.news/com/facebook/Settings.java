// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import com.facebook.internal.Validate;
import android.os.Handler;
import android.os.Looper;
import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;
import com.facebook.model.GraphObject;
import com.facebook.internal.AttributionIdentifiers;
import java.net.HttpURLConnection;
import com.facebook.internal.Utility;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.Collections;
import java.util.Set;
import android.content.Context;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import android.database.Cursor;
import android.util.Log;
import android.content.ContentResolver;
import java.lang.reflect.Field;
import android.os.AsyncTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.Collection;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;
import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import android.net.Uri;

public final class Settings
{
    private static final String ANALYTICS_EVENT = "event";
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    private static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final Uri ATTRIBUTION_ID_CONTENT_URI;
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    private static final String AUTO_PUBLISH = "auto_publish";
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
    private static final int DEFAULT_CORE_POOL_SIZE = 5;
    private static final int DEFAULT_KEEP_ALIVE = 1;
    private static final int DEFAULT_MAXIMUM_POOL_SIZE = 128;
    private static final ThreadFactory DEFAULT_THREAD_FACTORY;
    private static final BlockingQueue<Runnable> DEFAULT_WORK_QUEUE;
    private static final String FACEBOOK_COM = "facebook.com";
    private static final Object LOCK;
    private static final String MOBILE_INSTALL_EVENT = "MOBILE_APP_INSTALL";
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    private static final String TAG;
    private static volatile String appClientToken;
    private static volatile String appVersion;
    private static volatile String applicationId;
    private static volatile boolean defaultsLoaded;
    private static volatile Executor executor;
    private static volatile String facebookDomain;
    private static final HashSet<LoggingBehavior> loggingBehaviors;
    private static AtomicLong onProgressThreshold;
    private static volatile boolean platformCompatibilityEnabled;
    private static volatile boolean shouldAutoPublishInstall;
    
    static {
        TAG = Settings.class.getCanonicalName();
        loggingBehaviors = new HashSet<LoggingBehavior>(Arrays.asList(LoggingBehavior.DEVELOPER_ERRORS));
        Settings.defaultsLoaded = false;
        Settings.facebookDomain = "facebook.com";
        Settings.onProgressThreshold = new AtomicLong(65536L);
        LOCK = new Object();
        ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
        DEFAULT_WORK_QUEUE = new LinkedBlockingQueue<Runnable>(10);
        DEFAULT_THREAD_FACTORY = new ThreadFactory() {
            private final AtomicInteger counter = new AtomicInteger(0);
            
            @Override
            public Thread newThread(final Runnable target) {
                return new Thread(target, "FacebookSdk #" + this.counter.incrementAndGet());
            }
        };
    }
    
    public static final void addLoggingBehavior(final LoggingBehavior e) {
        synchronized (Settings.loggingBehaviors) {
            Settings.loggingBehaviors.add(e);
        }
    }
    
    public static final void clearLoggingBehaviors() {
        synchronized (Settings.loggingBehaviors) {
            Settings.loggingBehaviors.clear();
        }
    }
    
    public static String getAppVersion() {
        return Settings.appVersion;
    }
    
    public static String getApplicationId() {
        return Settings.applicationId;
    }
    
    private static Executor getAsyncTaskExecutor() {
        Object o3 = null;
        Label_0026: {
            Field field;
            try {
                final Field field2;
                field = (field2 = AsyncTask.class.getField("THREAD_POOL_EXECUTOR"));
                final Object o = null;
                final Object o2 = field2.get(o);
                final Object o4;
                o3 = (o4 = o2);
                if (o4 == null) {
                    return null;
                }
                break Label_0026;
            }
            catch (NoSuchFieldException ex) {
                return null;
            }
            try {
                final Field field2 = field;
                final Object o = null;
                final Object o2 = field2.get(o);
                final Object o4;
                o3 = (o4 = o2);
                if (o4 == null) {
                    return null;
                }
            }
            catch (IllegalAccessException ex2) {
                return null;
            }
        }
        if (!(o3 instanceof Executor)) {
            return null;
        }
        return (Executor)o3;
    }
    
    public static String getAttributionId(final ContentResolver contentResolver) {
        try {
            final Cursor query = contentResolver.query(Settings.ATTRIBUTION_ID_CONTENT_URI, new String[] { "aid" }, (String)null, (String[])null, (String)null);
            if (query != null) {
                if (query.moveToFirst()) {
                    final String string = query.getString(query.getColumnIndex("aid"));
                    query.close();
                    return string;
                }
            }
        }
        catch (Exception ex) {
            Log.d(Settings.TAG, "Caught unexpected exception in getAttributionId(): " + ex.toString());
            return null;
        }
        return null;
    }
    
    public static String getClientToken() {
        return Settings.appClientToken;
    }
    
    public static Executor getExecutor() {
        synchronized (Settings.LOCK) {
            if (Settings.executor == null) {
                Executor asyncTaskExecutor = getAsyncTaskExecutor();
                if (asyncTaskExecutor == null) {
                    asyncTaskExecutor = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, Settings.DEFAULT_WORK_QUEUE, Settings.DEFAULT_THREAD_FACTORY);
                }
                Settings.executor = asyncTaskExecutor;
            }
            return Settings.executor;
        }
    }
    
    public static String getFacebookDomain() {
        return Settings.facebookDomain;
    }
    
    public static boolean getLimitEventAndDataUsage(final Context context) {
        return context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getBoolean("limitEventUsage", false);
    }
    
    public static final Set<LoggingBehavior> getLoggingBehaviors() {
        synchronized (Settings.loggingBehaviors) {
            return Collections.unmodifiableSet((Set<? extends LoggingBehavior>)new HashSet<LoggingBehavior>(Settings.loggingBehaviors));
        }
    }
    
    public static long getOnProgressThreshold() {
        return Settings.onProgressThreshold.get();
    }
    
    public static boolean getPlatformCompatibilityEnabled() {
        return Settings.platformCompatibilityEnabled;
    }
    
    public static String getSdkVersion() {
        return "3.15.0";
    }
    
    @Deprecated
    public static boolean getShouldAutoPublishInstall() {
        return Settings.shouldAutoPublishInstall;
    }
    
    public static final boolean isLoggingBehaviorEnabled(final LoggingBehavior o) {
        while (true) {
            synchronized (Settings.loggingBehaviors) {
                if (Settings.loggingBehaviors.contains(o)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    public static void loadDefaultsFromMetadata(final Context context) {
        Settings.defaultsLoaded = true;
        if (context != null) {
            try {
                final ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    if (Settings.applicationId == null) {
                        Settings.applicationId = applicationInfo.metaData.getString("com.facebook.sdk.ApplicationId");
                    }
                    if (Settings.appClientToken == null) {
                        Settings.appClientToken = applicationInfo.metaData.getString("com.facebook.sdk.ClientToken");
                    }
                }
            }
            catch (PackageManager$NameNotFoundException ex) {}
        }
    }
    
    static void loadDefaultsFromMetadataIfNeeded(final Context context) {
        if (!Settings.defaultsLoaded) {
            loadDefaultsFromMetadata(context);
        }
    }
    
    @Deprecated
    public static boolean publishInstallAndWait(final Context context, final String s) {
        final Response publishInstallAndWaitForResponse = publishInstallAndWaitForResponse(context, s);
        return publishInstallAndWaitForResponse != null && publishInstallAndWaitForResponse.getError() == null;
    }
    
    @Deprecated
    public static Response publishInstallAndWaitForResponse(final Context context, final String s) {
        return publishInstallAndWaitForResponse(context, s, false);
    }
    
    static Response publishInstallAndWaitForResponse(final Context context, final String s, final boolean b) {
        Label_0046: {
            if (context != null) {
                if (s != null) {
                    break Label_0046;
                }
            }
            try {
                throw new IllegalArgumentException("Both context and applicationId must be non-null");
            }
            catch (Exception ex) {
                Utility.logd("Facebook-publish", ex);
                return new Response(null, null, new FacebookRequestError(null, ex));
            }
        }
        final AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(context);
        final SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
        final String string = String.valueOf(s) + "ping";
        final String string2 = String.valueOf(s) + "json";
        final long long1 = sharedPreferences.getLong(string, 0L);
        final String string3 = sharedPreferences.getString(string2, (String)null);
        if (!b) {
            setShouldAutoPublishInstall(false);
        }
        final GraphObject create = GraphObject.Factory.create();
        create.setProperty("event", "MOBILE_APP_INSTALL");
        Utility.setAppEventAttributionParameters(create, attributionIdentifiers, Utility.getHashedDeviceAndAppID(context, s), getLimitEventAndDataUsage(context));
        create.setProperty("auto_publish", b);
        create.setProperty("application_package_name", context.getPackageName());
        final Request postRequest = Request.newPostRequest(null, String.format("%s/activities", s), create, null);
        Label_0304: {
            if (long1 == 0L) {
                break Label_0304;
            }
            GraphObject create2 = null;
            while (true) {
                if (string3 == null) {
                    break Label_0251;
                }
                try {
                    create2 = GraphObject.Factory.create(new JSONObject(string3));
                    if (create2 == null) {
                        return Response.createResponsesFromString("true", null, new RequestBatch(new Request[] { postRequest }), true).get(0);
                    }
                    return new Response(null, null, null, create2, true);
                    Label_0331: {
                        throw new FacebookException("Install attribution has been disabled on the server.");
                    }
                    // iftrue(Label_0353:, Utility.queryAppSettings(s, false).supportsAttribution())
                    // iftrue(Label_0331:, attributionIdentifiers.getAndroidAdvertiserId() != null || attributionIdentifiers.getAttributionId() != null)
                    throw new FacebookException("No attribution id available to send to server.");
                    // iftrue(Label_0426:, executeAndWait.getGraphObject() == null || executeAndWait.getGraphObject().getInnerJSONObject() == null)
                    SharedPreferences$Editor edit = null;
                    Response executeAndWait = null;
                Label_0426:
                    while (true) {
                        edit.putString(string2, executeAndWait.getGraphObject().getInnerJSONObject().toString());
                        break Label_0426;
                        Label_0353: {
                            executeAndWait = postRequest.executeAndWait();
                        }
                        edit = sharedPreferences.edit();
                        edit.putLong(string, System.currentTimeMillis());
                        continue;
                    }
                    edit.commit();
                    return executeAndWait;
                }
                catch (JSONException ex2) {
                    create2 = null;
                    continue;
                }
                break;
            }
        }
    }
    
    @Deprecated
    public static void publishInstallAsync(final Context context, final String s) {
        publishInstallAsync(context, s, null);
    }
    
    @Deprecated
    public static void publishInstallAsync(final Context context, final String s, final Request.Callback callback) {
        getExecutor().execute(new Runnable() {
            private final /* synthetic */ Context val$applicationContext = context.getApplicationContext();
            
            @Override
            public void run() {
                final Response publishInstallAndWaitForResponse = Settings.publishInstallAndWaitForResponse(this.val$applicationContext, s);
                if (callback != null) {
                    new Handler(Looper.getMainLooper()).post((Runnable)new Runnable() {
                        @Override
                        public void run() {
                            callback.onCompleted(publishInstallAndWaitForResponse);
                        }
                    });
                }
            }
        });
    }
    
    public static final void removeLoggingBehavior(final LoggingBehavior o) {
        synchronized (Settings.loggingBehaviors) {
            Settings.loggingBehaviors.remove(o);
        }
    }
    
    public static void setAppVersion(final String appVersion) {
        Settings.appVersion = appVersion;
    }
    
    public static void setApplicationId(final String applicationId) {
        Settings.applicationId = applicationId;
    }
    
    public static void setClientToken(final String appClientToken) {
        Settings.appClientToken = appClientToken;
    }
    
    public static void setExecutor(final Executor executor) {
        Validate.notNull(executor, "executor");
        synchronized (Settings.LOCK) {
            Settings.executor = executor;
        }
    }
    
    public static void setFacebookDomain(final String facebookDomain) {
        Settings.facebookDomain = facebookDomain;
    }
    
    public static void setLimitEventAndDataUsage(final Context context, final boolean b) {
        final SharedPreferences$Editor edit = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit();
        edit.putBoolean("limitEventUsage", b);
        edit.commit();
    }
    
    public static void setOnProgressThreshold(final long newValue) {
        Settings.onProgressThreshold.set(newValue);
    }
    
    public static void setPlatformCompatibilityEnabled(final boolean platformCompatibilityEnabled) {
        Settings.platformCompatibilityEnabled = platformCompatibilityEnabled;
    }
    
    @Deprecated
    public static void setShouldAutoPublishInstall(final boolean shouldAutoPublishInstall) {
        Settings.shouldAutoPublishInstall = shouldAutoPublishInstall;
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.internal;

import java.util.Collections;
import java.util.Arrays;
import java.io.InputStream;
import com.facebook.model.GraphObject;
import com.facebook.Session;
import com.facebook.Request;
import android.text.TextUtils;
import android.os.Parcelable;
import android.util.Log;
import java.util.HashSet;
import java.util.Collection;
import java.lang.reflect.InvocationTargetException;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import com.facebook.FacebookException;
import org.json.JSONTokener;
import java.lang.reflect.Method;
import com.facebook.Settings;
import android.provider.Settings$Secure;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import java.util.HashMap;
import org.json.JSONObject;
import java.io.IOException;
import java.io.Closeable;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.content.Context;
import java.util.Iterator;
import android.net.Uri$Builder;
import android.net.Uri;
import android.os.Bundle;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class Utility
{
    private static final String APPLICATION_FIELDS = "fields";
    private static final String[] APP_SETTING_FIELDS;
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 8192;
    private static final String HASH_ALGORITHM_MD5 = "MD5";
    private static final String HASH_ALGORITHM_SHA1 = "SHA-1";
    static final String LOG_TAG = "FacebookSDK";
    private static final String NUX_CONTENT = "gdpv4_nux_content";
    private static final String NUX_ENABLED = "gdpv4_nux_enabled";
    private static final String SUPPORTS_ATTRIBUTION = "supports_attribution";
    private static final String SUPPORTS_IMPLICIT_SDK_LOGGING = "supports_implicit_sdk_logging";
    private static final String URL_SCHEME = "https";
    private static Map<String, FetchedAppSettings> fetchedAppSettings;
    
    static {
        APP_SETTING_FIELDS = new String[] { "supports_attribution", "supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled" };
        Utility.fetchedAppSettings = new ConcurrentHashMap<String, FetchedAppSettings>();
    }
    
    public static <T> boolean areObjectsEqual(final T t, final T obj) {
        if (t == null) {
            return obj == null;
        }
        return t.equals(obj);
    }
    
    public static <T> ArrayList<T> arrayList(final T... array) {
        final ArrayList<T> list = new ArrayList<T>(array.length);
        for (int length = array.length, i = 0; i < length; ++i) {
            list.add(array[i]);
        }
        return list;
    }
    
    public static <T> List<T> asListNoNulls(final T... array) {
        final ArrayList<T> list = new ArrayList<T>();
        for (final T e : array) {
            if (e != null) {
                list.add(e);
            }
        }
        return list;
    }
    
    public static Uri buildUri(final String s, final String s2, final Bundle bundle) {
        final Uri$Builder uri$Builder = new Uri$Builder();
        uri$Builder.scheme("https");
        uri$Builder.authority(s);
        uri$Builder.path(s2);
        for (final String s3 : bundle.keySet()) {
            final Object value = bundle.get(s3);
            if (value instanceof String) {
                uri$Builder.appendQueryParameter(s3, (String)value);
            }
        }
        return uri$Builder.build();
    }
    
    public static void clearCaches(final Context context) {
        ImageDownloader.clearCache(context);
    }
    
    private static void clearCookiesForDomain(final Context context, final String s) {
        CookieSyncManager.createInstance(context).sync();
        final CookieManager instance = CookieManager.getInstance();
        final String cookie = instance.getCookie(s);
        if (cookie == null) {
            return;
        }
        final String[] split = cookie.split(";");
        for (int length = split.length, i = 0; i < length; ++i) {
            final String[] split2 = split[i].split("=");
            if (split2.length > 0) {
                instance.setCookie(s, String.valueOf(split2[0].trim()) + "=;expires=Sat, 1 Jan 2000 00:00:01 UTC;");
            }
        }
        instance.removeExpiredCookie();
    }
    
    public static void clearFacebookCookies(final Context context) {
        clearCookiesForDomain(context, "facebook.com");
        clearCookiesForDomain(context, ".facebook.com");
        clearCookiesForDomain(context, "https://facebook.com");
        clearCookiesForDomain(context, "https://.facebook.com");
    }
    
    public static void closeQuietly(final Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        }
        catch (IOException ex) {}
    }
    
    static Map<String, Object> convertJSONObjectToHashMap(final JSONObject jsonObject) {
        final HashMap<String, JSONObject> hashMap = (HashMap<String, JSONObject>)new HashMap<String, Object>();
        final JSONArray names = jsonObject.names();
        int i = 0;
        while (i < names.length()) {
            while (true) {
                try {
                    final String string = names.getString(i);
                    Object value = jsonObject.get(string);
                    if (value instanceof JSONObject) {
                        value = convertJSONObjectToHashMap((JSONObject)value);
                    }
                    hashMap.put(string, (JSONObject)value);
                    ++i;
                }
                catch (JSONException ex) {
                    continue;
                }
                break;
            }
        }
        return (Map<String, Object>)hashMap;
    }
    
    public static void deleteDirectory(final File file) {
        if (!file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            final File[] listFiles = file.listFiles();
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                deleteDirectory(listFiles[i]);
            }
        }
        file.delete();
    }
    
    public static void disconnectQuietly(final URLConnection urlConnection) {
        if (urlConnection instanceof HttpURLConnection) {
            ((HttpURLConnection)urlConnection).disconnect();
        }
    }
    
    public static String getHashedDeviceAndAppID(final Context context, final String str) {
        final String string = Settings$Secure.getString(context.getContentResolver(), "android_id");
        if (string == null) {
            return null;
        }
        return sha1hash(String.valueOf(string) + str);
    }
    
    public static String getMetadataApplicationId(final Context context) {
        Validate.notNull(context, "context");
        Settings.loadDefaultsFromMetadata(context);
        return Settings.getApplicationId();
    }
    
    public static Method getMethodQuietly(final Class<?> clazz, final String name, final Class<?>... parameterTypes) {
        try {
            return clazz.getMethod(name, parameterTypes);
        }
        catch (NoSuchMethodException ex) {
            return null;
        }
    }
    
    public static Method getMethodQuietly(final String className, final String s, final Class<?>... array) {
        try {
            return getMethodQuietly(Class.forName(className), s, array);
        }
        catch (ClassNotFoundException ex) {
            return null;
        }
    }
    
    public static Object getStringPropertyAsJSON(final JSONObject jsonObject, final String s, final String s2) throws JSONException {
        Object o = jsonObject.opt(s);
        if (o != null && o instanceof String) {
            o = new JSONTokener((String)o).nextValue();
        }
        if (o == null || o instanceof JSONObject || o instanceof JSONArray) {
            return o;
        }
        if (s2 != null) {
            final JSONObject jsonObject2 = new JSONObject();
            jsonObject2.putOpt(s2, o);
            return jsonObject2;
        }
        throw new FacebookException("Got an unexpected non-JSON object.");
    }
    
    private static String hashBytes(final MessageDigest messageDigest, final byte[] input) {
        messageDigest.update(input);
        final byte[] digest = messageDigest.digest();
        final StringBuilder sb = new StringBuilder();
        for (final byte b : digest) {
            sb.append(Integer.toHexString(0xF & b >> 4));
            sb.append(Integer.toHexString(0xF & b >> 0));
        }
        return sb.toString();
    }
    
    private static String hashWithAlgorithm(final String s, final String s2) {
        return hashWithAlgorithm(s, s2.getBytes());
    }
    
    private static String hashWithAlgorithm(final String algorithm, final byte[] array) {
        try {
            return hashBytes(MessageDigest.getInstance(algorithm), array);
        }
        catch (NoSuchAlgorithmException ex) {
            return null;
        }
    }
    
    public static Object invokeMethodQuietly(final Object obj, final Method method, final Object... args) {
        try {
            return method.invoke(obj, args);
        }
        catch (IllegalAccessException ex) {
            return null;
        }
        catch (InvocationTargetException ex2) {
            return null;
        }
    }
    
    public static boolean isNullOrEmpty(final String s) {
        return s == null || s.length() == 0;
    }
    
    public static <T> boolean isNullOrEmpty(final Collection<T> collection) {
        return collection == null || collection.size() == 0;
    }
    
    public static <T> boolean isSubset(final Collection<T> collection, final Collection<T> c) {
        if (c == null || c.size() == 0) {
            return collection == null || collection.size() == 0;
        }
        final HashSet set = new HashSet((Collection<? extends E>)c);
        final Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!set.contains(iterator.next())) {
                return false;
            }
        }
        return true;
    }
    
    public static void logd(final String s, final Exception ex) {
        if (s != null && ex != null) {
            Log.d(s, String.valueOf(ex.getClass().getSimpleName()) + ": " + ex.getMessage());
        }
    }
    
    public static void logd(final String s, final String s2) {
        if (s != null && s2 != null) {
            Log.d(s, s2);
        }
    }
    
    static String md5hash(final String s) {
        return hashWithAlgorithm("MD5", s);
    }
    
    public static void putObjectInBundle(final Bundle bundle, final String s, final Object o) {
        if (o instanceof String) {
            bundle.putString(s, (String)o);
            return;
        }
        if (o instanceof Parcelable) {
            bundle.putParcelable(s, (Parcelable)o);
            return;
        }
        if (o instanceof byte[]) {
            bundle.putByteArray(s, (byte[])o);
            return;
        }
        throw new FacebookException("attempted to add unsupported type to Bundle");
    }
    
    public static FetchedAppSettings queryAppSettings(final String s, final boolean b) {
        if (!b && Utility.fetchedAppSettings.containsKey(s)) {
            return Utility.fetchedAppSettings.get(s);
        }
        final Bundle parameters = new Bundle();
        parameters.putString("fields", TextUtils.join((CharSequence)",", (Object[])Utility.APP_SETTING_FIELDS));
        final Request graphPathRequest = Request.newGraphPathRequest(null, s, null);
        graphPathRequest.setParameters(parameters);
        final GraphObject graphObject = graphPathRequest.executeAndWait().getGraphObject();
        final FetchedAppSettings fetchedAppSettings = new FetchedAppSettings(safeGetBooleanFromResponse(graphObject, "supports_attribution"), safeGetBooleanFromResponse(graphObject, "supports_implicit_sdk_logging"), safeGetStringFromResponse(graphObject, "gdpv4_nux_content"), safeGetBooleanFromResponse(graphObject, "gdpv4_nux_enabled"), null);
        Utility.fetchedAppSettings.put(s, fetchedAppSettings);
        return fetchedAppSettings;
    }
    
    public static String readStreamToString(final InputStream p0) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: new             Ljava/io/BufferedInputStream;
        //     3: dup            
        //     4: aload_0        
        //     5: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //     8: astore_1       
        //     9: new             Ljava/io/InputStreamReader;
        //    12: dup            
        //    13: aload_1        
        //    14: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //    17: astore_2       
        //    18: new             Ljava/lang/StringBuilder;
        //    21: dup            
        //    22: invokespecial   java/lang/StringBuilder.<init>:()V
        //    25: astore_3       
        //    26: sipush          2048
        //    29: newarray        C
        //    31: astore          7
        //    33: aload_2        
        //    34: aload           7
        //    36: invokevirtual   java/io/InputStreamReader.read:([C)I
        //    39: istore          8
        //    41: iload           8
        //    43: iconst_m1      
        //    44: if_icmpne       64
        //    47: aload_3        
        //    48: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    51: astore          9
        //    53: aload_1        
        //    54: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
        //    57: aload_2        
        //    58: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
        //    61: aload           9
        //    63: areturn        
        //    64: aload_3        
        //    65: aload           7
        //    67: iconst_0       
        //    68: iload           8
        //    70: invokevirtual   java/lang/StringBuilder.append:([CII)Ljava/lang/StringBuilder;
        //    73: pop            
        //    74: goto            33
        //    77: astore          4
        //    79: aload_2        
        //    80: astore          5
        //    82: aload_1        
        //    83: astore          6
        //    85: aload           6
        //    87: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
        //    90: aload           5
        //    92: invokestatic    com/facebook/internal/Utility.closeQuietly:(Ljava/io/Closeable;)V
        //    95: aload           4
        //    97: athrow         
        //    98: astore          4
        //   100: aconst_null    
        //   101: astore          6
        //   103: aconst_null    
        //   104: astore          5
        //   106: goto            85
        //   109: astore          4
        //   111: aload_1        
        //   112: astore          6
        //   114: aconst_null    
        //   115: astore          5
        //   117: goto            85
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  0      9      98     109    Any
        //  9      18     109    120    Any
        //  18     33     77     85     Any
        //  33     41     77     85     Any
        //  47     53     77     85     Any
        //  64     74     77     85     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0033:
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
    
    private static boolean safeGetBooleanFromResponse(final GraphObject graphObject, final String s) {
        Object o = false;
        if (graphObject != null) {
            o = graphObject.getProperty(s);
        }
        Object value;
        if (!(o instanceof Boolean)) {
            value = false;
        }
        else {
            value = o;
        }
        return (boolean)value;
    }
    
    private static String safeGetStringFromResponse(final GraphObject graphObject, final String s) {
        Object property = "";
        if (graphObject != null) {
            property = graphObject.getProperty(s);
        }
        Object o;
        if (!(property instanceof String)) {
            o = "";
        }
        else {
            o = property;
        }
        return (String)o;
    }
    
    public static void setAppEventAttributionParameters(final GraphObject graphObject, final AttributionIdentifiers attributionIdentifiers, final String s, final boolean b) {
        if (attributionIdentifiers != null && attributionIdentifiers.getAttributionId() != null) {
            graphObject.setProperty("attribution", attributionIdentifiers.getAttributionId());
        }
        if (attributionIdentifiers != null && attributionIdentifiers.getAndroidAdvertiserId() != null) {
            graphObject.setProperty("advertiser_id", attributionIdentifiers.getAndroidAdvertiserId());
            graphObject.setProperty("advertiser_tracking_enabled", !attributionIdentifiers.isTrackingLimited());
        }
        else if (s != null) {
            graphObject.setProperty("advertiser_id", s);
        }
        boolean b2 = false;
        if (!b) {
            b2 = true;
        }
        graphObject.setProperty("application_tracking_enabled", b2);
    }
    
    static String sha1hash(final String s) {
        return hashWithAlgorithm("SHA-1", s);
    }
    
    static String sha1hash(final byte[] array) {
        return hashWithAlgorithm("SHA-1", array);
    }
    
    public static boolean stringsEqualOrEmpty(final String s, final String anObject) {
        final boolean empty = TextUtils.isEmpty((CharSequence)s);
        final boolean empty2 = TextUtils.isEmpty((CharSequence)anObject);
        return (empty && empty2) || (!empty && !empty2 && s.equals(anObject));
    }
    
    public static <T> Collection<T> unmodifiableCollection(final T... a) {
        return Collections.unmodifiableCollection((Collection<? extends T>)Arrays.asList(a));
    }
    
    public static class FetchedAppSettings
    {
        private String nuxContent;
        private boolean nuxEnabled;
        private boolean supportsAttribution;
        private boolean supportsImplicitLogging;
        
        private FetchedAppSettings(final boolean supportsAttribution, final boolean supportsImplicitLogging, final String nuxContent, final boolean nuxEnabled) {
            this.supportsAttribution = supportsAttribution;
            this.supportsImplicitLogging = supportsImplicitLogging;
            this.nuxContent = nuxContent;
            this.nuxEnabled = nuxEnabled;
        }
        
        public String getNuxContent() {
            return this.nuxContent;
        }
        
        public boolean getNuxEnabled() {
            return this.nuxEnabled;
        }
        
        public boolean supportsAttribution() {
            return this.supportsAttribution;
        }
        
        public boolean supportsImplicitLogging() {
            return this.supportsImplicitLogging;
        }
    }
}

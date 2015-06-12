// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import android.util.Log;
import java.io.IOException;
import java.io.Closeable;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.Collections;
import java.util.Arrays;
import java.util.Collection;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.io.InputStream;
import android.provider.Settings$Secure;
import com.facebook.bq;
import android.content.Context;
import com.facebook.ab;
import org.json.JSONArray;
import org.json.JSONTokener;
import org.json.JSONObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import com.facebook.c.c;
import com.facebook.Request;
import android.text.TextUtils;
import java.util.Iterator;
import android.net.Uri$Builder;
import android.net.Uri;
import android.os.Bundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public final class aj
{
    private static final String[] a;
    private static Map b;
    
    static {
        a = new String[] { "supports_attribution", "supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled" };
        aj.b = new ConcurrentHashMap();
    }
    
    public static Uri a(final String s, final String s2, final Bundle bundle) {
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
    
    public static ak a(final String s, final boolean b) {
        if (!b && aj.b.containsKey(s)) {
            return aj.b.get(s);
        }
        final Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join((CharSequence)",", (Object[])aj.a));
        final Request a = Request.a(s);
        a.a(bundle);
        final c b2 = a.f().b();
        final boolean a2 = a(b2);
        final boolean a3 = a(b2);
        Object e = "";
        if (b2 != null) {
            e = b2.e();
        }
        if (!(e instanceof String)) {
            e = "";
        }
        final ak ak = new ak(a2, a3, (String)e, a(b2), (byte)0);
        aj.b.put(s, ak);
        return ak;
    }
    
    public static Object a(final Object obj, final Method method, final Object... args) {
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
    
    public static Object a(final JSONObject jsonObject, final String s, final String s2) {
        final Object opt = jsonObject.opt(s);
        Object nextValue;
        if (opt != null && opt instanceof String) {
            nextValue = new JSONTokener((String)opt).nextValue();
        }
        else {
            nextValue = opt;
        }
        if (nextValue == null || nextValue instanceof JSONObject || nextValue instanceof JSONArray) {
            return nextValue;
        }
        if (s2 != null) {
            final JSONObject jsonObject2 = new JSONObject();
            jsonObject2.putOpt(s2, nextValue);
            return jsonObject2;
        }
        throw new ab("Got an unexpected non-JSON object.");
    }
    
    public static String a(final Context context) {
        al.a(context, "context");
        bq.b(context);
        return bq.h();
    }
    
    public static String a(final Context context, final String str) {
        final String string = Settings$Secure.getString(context.getContentResolver(), "android_id");
        if (string == null) {
            return null;
        }
        return b("SHA-1", String.valueOf(string) + str);
    }
    
    public static String a(final InputStream p0) {
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
        //    31: astore          6
        //    33: aload_2        
        //    34: aload           6
        //    36: invokevirtual   java/io/InputStreamReader.read:([C)I
        //    39: istore          7
        //    41: iload           7
        //    43: iconst_m1      
        //    44: if_icmpne       64
        //    47: aload_3        
        //    48: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    51: astore          8
        //    53: aload_1        
        //    54: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //    57: aload_2        
        //    58: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //    61: aload           8
        //    63: areturn        
        //    64: aload_3        
        //    65: aload           6
        //    67: iconst_0       
        //    68: iload           7
        //    70: invokevirtual   java/lang/StringBuilder.append:([CII)Ljava/lang/StringBuilder;
        //    73: pop            
        //    74: goto            33
        //    77: astore          4
        //    79: aload_1        
        //    80: astore          5
        //    82: aload           5
        //    84: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //    87: aload_2        
        //    88: invokestatic    com/facebook/b/aj.a:(Ljava/io/Closeable;)V
        //    91: aload           4
        //    93: athrow         
        //    94: astore          4
        //    96: aconst_null    
        //    97: astore_2       
        //    98: aconst_null    
        //    99: astore          5
        //   101: goto            82
        //   104: astore          4
        //   106: aload_1        
        //   107: astore          5
        //   109: aconst_null    
        //   110: astore_2       
        //   111: goto            82
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  0      9      94     104    Any
        //  9      18     104    114    Any
        //  18     33     77     82     Any
        //  33     41     77     82     Any
        //  47     53     77     82     Any
        //  64     74     77     82     Any
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
    
    private static String a(final String algorithm, final byte[] input) {
        while (true) {
            while (true) {
                byte[] digest;
                StringBuilder sb;
                int n;
                try {
                    final MessageDigest instance = MessageDigest.getInstance(algorithm);
                    instance.update(input);
                    digest = instance.digest();
                    sb = new StringBuilder();
                    final int length = digest.length;
                    n = 0;
                    if (n >= length) {
                        return sb.toString();
                    }
                }
                catch (NoSuchAlgorithmException ex) {
                    return null;
                }
                final byte b = digest[n];
                sb.append(Integer.toHexString(0xF & b >> 4));
                sb.append(Integer.toHexString(0xF & b >> 0));
                ++n;
                continue;
            }
        }
    }
    
    static String a(final byte[] array) {
        return a("SHA-1", array);
    }
    
    public static Method a(final Class clazz, final String name, final Class... parameterTypes) {
        try {
            return clazz.getMethod(name, (Class[])parameterTypes);
        }
        catch (NoSuchMethodException ex) {
            return null;
        }
    }
    
    public static Method a(final String className, final String s, final Class... array) {
        try {
            return a(Class.forName(className), s, array);
        }
        catch (ClassNotFoundException ex) {
            return null;
        }
    }
    
    public static Collection a(final Object... a) {
        return Collections.unmodifiableCollection((Collection<?>)Arrays.asList(a));
    }
    
    public static void a(final c c, final Context context) {
        final JSONArray jsonArray = new JSONArray();
        jsonArray.put((Object)"a1");
        final String packageName = context.getPackageName();
        int versionCode = -1;
        String versionName = "";
        while (true) {
            try {
                final PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
                versionCode = packageInfo.versionCode;
                versionName = packageInfo.versionName;
                jsonArray.put((Object)packageName);
                jsonArray.put(versionCode);
                jsonArray.put((Object)versionName);
                jsonArray.toString();
                c.f();
            }
            catch (PackageManager$NameNotFoundException ex) {
                continue;
            }
            break;
        }
    }
    
    public static void a(final c c, final a a, final String s, final boolean b) {
        if (a != null && a.a() != null) {
            a.a();
            c.f();
        }
        if (a != null && a.b() != null) {
            a.b();
            c.f();
            !a.c();
            c.f();
        }
        else if (s != null) {
            c.f();
        }
        boolean b2 = false;
        if (!b) {
            b2 = true;
        }
        b2;
        c.f();
    }
    
    public static void a(final Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        }
        catch (IOException ex) {}
    }
    
    public static void a(final String s, final Exception ex) {
        if (bq.a() && s != null && ex != null) {
            Log.d(s, String.valueOf(ex.getClass().getSimpleName()) + ": " + ex.getMessage());
        }
    }
    
    public static void a(final String s, final String s2) {
        if (bq.a() && s != null && s2 != null) {
            Log.d(s, s2);
        }
    }
    
    public static void a(final URLConnection urlConnection) {
        if (urlConnection instanceof HttpURLConnection) {
            ((HttpURLConnection)urlConnection).disconnect();
        }
    }
    
    private static boolean a(final c c) {
        Object o = false;
        if (c != null) {
            o = c.e();
        }
        if (!(o instanceof Boolean)) {
            o = false;
        }
        return (boolean)o;
    }
    
    public static boolean a(final Object o, final Object obj) {
        if (o == null) {
            return obj == null;
        }
        return o.equals(obj);
    }
    
    public static boolean a(final String s) {
        return s == null || s.length() == 0;
    }
    
    public static boolean a(final Collection collection) {
        return collection == null || collection.size() == 0;
    }
    
    public static boolean a(final Collection collection, final Collection c) {
        if (c == null || c.size() == 0) {
            return collection == null || collection.size() == 0;
        }
        final HashSet set = new HashSet(c);
        final Iterator<Object> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!set.contains(iterator.next())) {
                return false;
            }
        }
        return true;
    }
    
    static String b(final String s) {
        return b("MD5", s);
    }
    
    private static String b(final String s, final String s2) {
        return a(s, s2.getBytes());
    }
    
    public static List b(final Object... array) {
        final ArrayList<Object> list = new ArrayList<Object>();
        for (final Object e : array) {
            if (e != null) {
                list.add(e);
            }
        }
        return list;
    }
    
    public static void b(final Context context) {
        b(context, "facebook.com");
        b(context, ".facebook.com");
        b(context, "https://facebook.com");
        b(context, "https://.facebook.com");
    }
    
    private static void b(final Context context, final String s) {
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
    
    public static void c(final Context context) {
        k.a(context);
    }
    
    public static String d(final Context context) {
        if (context == null) {
            return "null";
        }
        if (context == context.getApplicationContext()) {
            return "unknown";
        }
        return context.getClass().getSimpleName();
    }
}

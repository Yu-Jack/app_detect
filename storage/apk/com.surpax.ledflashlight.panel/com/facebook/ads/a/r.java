// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.ads.a;

import java.io.IOException;
import java.io.Closeable;
import android.util.Log;
import com.facebook.ads.d;
import android.content.Context;
import java.util.Iterator;
import org.json.JSONException;
import java.util.Map;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONTokener;
import org.json.JSONObject;
import java.lang.reflect.Method;
import android.database.Cursor;
import android.content.ContentResolver;
import android.net.Uri;

public final class r
{
    private static final Uri a;
    
    static {
        a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    }
    
    public static s a(final ContentResolver contentResolver) {
        try {
            final Cursor query = contentResolver.query(r.a, new String[] { "aid", "androidid", "limit_tracking" }, (String)null, (String[])null, (String)null);
            if (query == null || !query.moveToFirst()) {
                return new s(null, null, false);
            }
            final String string = query.getString(query.getColumnIndex("aid"));
            final String string2 = query.getString(query.getColumnIndex("androidid"));
            final Boolean value = Boolean.valueOf(query.getString(query.getColumnIndex("limit_tracking")));
            query.close();
            return new s(string, string2, value);
        }
        catch (Exception ex) {
            return new s(null, null, false);
        }
    }
    
    public static Object a(final Object obj, final Method method, final Object... args) {
        try {
            return method.invoke(obj, args);
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    public static Object a(final JSONObject jsonObject, final String s) {
        Object o = jsonObject.opt(s);
        if (o != null && o instanceof String) {
            o = new JSONTokener((String)o).nextValue();
        }
        if (o != null && !(o instanceof JSONObject) && !(o instanceof JSONArray)) {
            throw new IllegalArgumentException(s);
        }
        return o;
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
        //    44: if_icmpeq       77
        //    47: aload_3        
        //    48: aload           6
        //    50: iconst_0       
        //    51: iload           7
        //    53: invokevirtual   java/lang/StringBuilder.append:([CII)Ljava/lang/StringBuilder;
        //    56: pop            
        //    57: goto            33
        //    60: astore          4
        //    62: aload_1        
        //    63: astore          5
        //    65: aload           5
        //    67: invokestatic    com/facebook/ads/a/r.a:(Ljava/io/Closeable;)V
        //    70: aload_2        
        //    71: invokestatic    com/facebook/ads/a/r.a:(Ljava/io/Closeable;)V
        //    74: aload           4
        //    76: athrow         
        //    77: aload_3        
        //    78: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    81: astore          9
        //    83: aload_1        
        //    84: invokestatic    com/facebook/ads/a/r.a:(Ljava/io/Closeable;)V
        //    87: aload_2        
        //    88: invokestatic    com/facebook/ads/a/r.a:(Ljava/io/Closeable;)V
        //    91: aload           9
        //    93: areturn        
        //    94: astore          4
        //    96: aconst_null    
        //    97: astore_2       
        //    98: aconst_null    
        //    99: astore          5
        //   101: goto            65
        //   104: astore          4
        //   106: aload_1        
        //   107: astore          5
        //   109: aconst_null    
        //   110: astore_2       
        //   111: goto            65
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  0      9      94     104    Any
        //  9      18     104    114    Any
        //  18     33     60     65     Any
        //  33     41     60     65     Any
        //  47     57     60     65     Any
        //  77     83     60     65     Any
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
    
    public static String a(final Map map) {
        final JSONObject jsonObject = new JSONObject();
        for (final Map.Entry<String, V> entry : map.entrySet()) {
            try {
                jsonObject.put((String)entry.getKey(), (Object)entry.getValue());
            }
            catch (JSONException ex) {
                ex.printStackTrace();
            }
        }
        return jsonObject.toString();
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
    
    public static void a(final Context context, final String str) {
        if (d.a(context)) {
            Log.d("FBAudienceNetworkLog", str + " (displayed for test ads only)");
        }
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
}

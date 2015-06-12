// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.util.Log;
import android.net.Uri$Builder;
import java.net.URLEncoder;
import android.text.TextUtils;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;
import com.facebook.c.h;
import java.util.regex.Matcher;
import android.os.Handler;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.net.URL;
import java.util.Map;
import java.util.HashSet;
import java.net.URLConnection;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Arrays;
import com.facebook.b.al;
import com.facebook.c.i;
import com.facebook.b.ad;
import android.os.Bundle;
import com.facebook.c.c;
import java.util.regex.Pattern;
import org.json.JSONObject;
import java.util.Iterator;
import java.util.Collection;
import org.json.JSONArray;
import android.graphics.Bitmap$CompressFormat;
import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.facebook.b.v;
import java.io.OutputStream;

final class au implements as
{
    private final OutputStream a;
    private final v b;
    private boolean c;
    
    public au(final OutputStream a, final v b) {
        this.c = true;
        this.a = a;
        this.b = b;
    }
    
    private void a() {
        this.b("--%s", "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
    }
    
    private void a(final String p0, final ParcelFileDescriptor p1, final String p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore          4
        //     3: aload_3        
        //     4: ifnonnull       10
        //     7: ldc             "content/unknown"
        //     9: astore_3       
        //    10: aload_0        
        //    11: aload_1        
        //    12: aload_1        
        //    13: aload_3        
        //    14: invokespecial   com/facebook/au.a:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //    17: aload_0        
        //    18: getfield        com/facebook/au.a:Ljava/io/OutputStream;
        //    21: instanceof      Lcom/facebook/an;
        //    24: ifeq            119
        //    27: aload_0        
        //    28: getfield        com/facebook/au.a:Ljava/io/OutputStream;
        //    31: checkcast       Lcom/facebook/an;
        //    34: aload_2        
        //    35: invokevirtual   android/os/ParcelFileDescriptor.getStatSize:()J
        //    38: invokevirtual   com/facebook/an.a:(J)V
        //    41: iconst_0       
        //    42: istore          10
        //    44: aload_0        
        //    45: ldc             ""
        //    47: iconst_0       
        //    48: anewarray       Ljava/lang/Object;
        //    51: invokespecial   com/facebook/au.b:(Ljava/lang/String;[Ljava/lang/Object;)V
        //    54: aload_0        
        //    55: invokespecial   com/facebook/au.a:()V
        //    58: aload_0        
        //    59: getfield        com/facebook/au.b:Lcom/facebook/b/v;
        //    62: ifnull          118
        //    65: aload_0        
        //    66: getfield        com/facebook/au.b:Lcom/facebook/b/v;
        //    69: astore          12
        //    71: new             Ljava/lang/StringBuilder;
        //    74: dup            
        //    75: ldc             "    "
        //    77: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    80: aload_1        
        //    81: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    84: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    87: astore          13
        //    89: iconst_1       
        //    90: anewarray       Ljava/lang/Object;
        //    93: astore          14
        //    95: aload           14
        //    97: iconst_0       
        //    98: iload           10
        //   100: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   103: aastore        
        //   104: aload           12
        //   106: aload           13
        //   108: ldc             "<Data: %d>"
        //   110: aload           14
        //   112: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   115: invokevirtual   com/facebook/b/v.a:(Ljava/lang/String;Ljava/lang/Object;)V
        //   118: return         
        //   119: new             Landroid/os/ParcelFileDescriptor$AutoCloseInputStream;
        //   122: dup            
        //   123: aload_2        
        //   124: invokespecial   android/os/ParcelFileDescriptor$AutoCloseInputStream.<init>:(Landroid/os/ParcelFileDescriptor;)V
        //   127: astore          5
        //   129: new             Ljava/io/BufferedInputStream;
        //   132: dup            
        //   133: aload           5
        //   135: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //   138: astore          6
        //   140: sipush          8192
        //   143: newarray        B
        //   145: astore          9
        //   147: iconst_0       
        //   148: istore          10
        //   150: aload           6
        //   152: aload           9
        //   154: invokevirtual   java/io/BufferedInputStream.read:([B)I
        //   157: istore          11
        //   159: iload           11
        //   161: iconst_m1      
        //   162: if_icmpne       178
        //   165: aload           6
        //   167: invokevirtual   java/io/BufferedInputStream.close:()V
        //   170: aload           5
        //   172: invokevirtual   android/os/ParcelFileDescriptor$AutoCloseInputStream.close:()V
        //   175: goto            44
        //   178: aload_0        
        //   179: getfield        com/facebook/au.a:Ljava/io/OutputStream;
        //   182: aload           9
        //   184: iconst_0       
        //   185: iload           11
        //   187: invokevirtual   java/io/OutputStream.write:([BII)V
        //   190: iload           10
        //   192: iload           11
        //   194: iadd           
        //   195: istore          10
        //   197: goto            150
        //   200: astore          7
        //   202: aconst_null    
        //   203: astore          8
        //   205: aload           8
        //   207: ifnull          215
        //   210: aload           8
        //   212: invokevirtual   java/io/BufferedInputStream.close:()V
        //   215: aload           4
        //   217: ifnull          225
        //   220: aload           4
        //   222: invokevirtual   android/os/ParcelFileDescriptor$AutoCloseInputStream.close:()V
        //   225: aload           7
        //   227: athrow         
        //   228: astore          7
        //   230: aload           5
        //   232: astore          4
        //   234: aconst_null    
        //   235: astore          8
        //   237: goto            205
        //   240: astore          7
        //   242: aload           6
        //   244: astore          8
        //   246: aload           5
        //   248: astore          4
        //   250: goto            205
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  119    129    200    205    Any
        //  129    140    228    240    Any
        //  140    147    240    253    Any
        //  150    159    240    253    Any
        //  178    190    240    253    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 122, Size: 122
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
    
    private void a(final String s, final String s2, final String s3) {
        this.a("Content-Disposition: form-data; name=\"%s\"", new Object[] { s });
        if (s2 != null) {
            this.a("; filename=\"%s\"", new Object[] { s2 });
        }
        this.b("", new Object[0]);
        if (s3 != null) {
            this.b("%s: %s", "Content-Type", s3);
        }
        this.b("", new Object[0]);
    }
    
    private void a(final String format, final Object... args) {
        if (this.c) {
            this.a.write("--".getBytes());
            this.a.write("3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f".getBytes());
            this.a.write("\r\n".getBytes());
            this.c = false;
        }
        this.a.write(String.format(format, args).getBytes());
    }
    
    private void b(final String s, final Object... array) {
        this.a(s, array);
        this.a("\r\n", new Object[0]);
    }
    
    public final void a(final String s, final Object o, final Request request) {
        if (this.a instanceof az) {
            ((az)this.a).a(request);
        }
        if (e(o)) {
            this.a(s, f(o));
        }
        else if (o instanceof Bitmap) {
            final Bitmap bitmap = (Bitmap)o;
            this.a(s, s, "image/png");
            bitmap.compress(Bitmap$CompressFormat.PNG, 100, this.a);
            this.b("", new Object[0]);
            this.a();
            if (this.b != null) {
                this.b.a("    " + s, (Object)"<Image>");
            }
        }
        else if (o instanceof byte[]) {
            final byte[] b = (byte[])o;
            this.a(s, s, "content/unknown");
            this.a.write(b);
            this.b("", new Object[0]);
            this.a();
            if (this.b != null) {
                this.b.a("    " + s, (Object)String.format("<Data: %d>", b.length));
            }
        }
        else {
            if (o instanceof ParcelFileDescriptor) {
                this.a(s, (ParcelFileDescriptor)o, null);
                return;
            }
            if (o instanceof Request$ParcelFileDescriptorWithMimeType) {
                final Request$ParcelFileDescriptorWithMimeType request$ParcelFileDescriptorWithMimeType = (Request$ParcelFileDescriptorWithMimeType)o;
                this.a(s, request$ParcelFileDescriptorWithMimeType.b(), request$ParcelFileDescriptorWithMimeType.a());
                return;
            }
            throw new IllegalArgumentException("value is not a supported type: String, Bitmap, byte[]");
        }
    }
    
    @Override
    public final void a(final String str, final String s) {
        this.a(str, (String)null, null);
        this.b("%s", s);
        this.a();
        if (this.b != null) {
            this.b.a("    " + str, (Object)s);
        }
    }
    
    public final void a(final String str, final JSONArray jsonArray, final Collection collection) {
        if (!(this.a instanceof az)) {
            this.a(str, jsonArray.toString());
        }
        else {
            final az az = (az)this.a;
            this.a(str, (String)null, null);
            this.a("[", new Object[0]);
            final Iterator<Request> iterator = collection.iterator();
            int n = 0;
            while (iterator.hasNext()) {
                final Request request = iterator.next();
                final JSONObject jsonObject = jsonArray.getJSONObject(n);
                az.a(request);
                if (n > 0) {
                    this.a(",%s", new Object[] { jsonObject.toString() });
                }
                else {
                    this.a("%s", new Object[] { jsonObject.toString() });
                }
                ++n;
            }
            this.a("]", new Object[0]);
            if (this.b != null) {
                this.b.a("    " + str, (Object)jsonArray.toString());
            }
        }
    }
}

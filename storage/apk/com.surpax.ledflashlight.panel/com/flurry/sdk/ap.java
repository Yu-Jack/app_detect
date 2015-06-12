// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Collections;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.File;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import java.util.List;
import java.net.URLConnection;
import com.flurry.android.impl.ads.FlurryAdModule;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Arrays;
import android.text.TextUtils;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;

public class ap implements ao$a
{
    private static final String b;
    private static final String[] c;
    private static ap d;
    ao a;
    private long e;
    private long f;
    private boolean g;
    private boolean h;
    private final dt i;
    
    static {
        b = ap.class.getSimpleName();
        c = new String[0];
    }
    
    ap() {
        this.i = new dt();
    }
    
    private ap$a a(ap$a a, final ar other) {
        if (a == null) {
            a = ap$a.a;
        }
        else if (other != null) {
            if (ar.g.equals(other)) {
                return ap$a.f;
            }
            if (ar.f.equals(other)) {
                if (!a.equals(ap$a.f)) {
                    return ap$a.e;
                }
            }
            else if (ar.a.equals(other) || ar.e.equals(other)) {
                if (!a.equals(ap$a.f) && !a.equals(ap$a.e)) {
                    return ap$a.c;
                }
            }
            else if (ar.b.equals(other) || ar.c.equals(other)) {
                if (ap$a.a.equals(a) || ap$a.d.equals(a)) {
                    return ap$a.b;
                }
            }
            else if (ar.d.equals(other) && ap$a.a.equals(a)) {
                return ap$a.d;
            }
        }
        return a;
    }
    
    public static ap a() {
        synchronized (ap.class) {
            if (ap.d == null) {
                ap.d = new ap();
            }
            return ap.d;
        }
    }
    
    private String a(final AdFrame adFrame, final String s) {
        if (adFrame != null && !TextUtils.isEmpty((CharSequence)s) && adFrame.d() != null) {
            final String a = this.a(adFrame.d().toString(), s);
            if (!TextUtils.isEmpty((CharSequence)a)) {
                return a;
            }
        }
        return null;
    }
    
    private String a(final String s, final String s2) {
        String s3;
        if (TextUtils.isEmpty((CharSequence)s) || TextUtils.isEmpty((CharSequence)s2)) {
            s3 = null;
        }
        else {
            while (true) {
                s3 = "";
                while (true) {
                    String s4 = null;
                    Label_0108: {
                        try {
                            final Iterator<String> iterator = Arrays.asList(s2.split("\\s*-\\s*")).iterator();
                            s4 = s;
                            while (iterator.hasNext()) {
                                final String string = new JSONObject(s4).getString((String)iterator.next());
                                if (TextUtils.isEmpty((CharSequence)string)) {
                                    break Label_0108;
                                }
                                final String s5 = string;
                                s4 = s5;
                                s3 = string;
                            }
                            break;
                        }
                        catch (JSONException ex) {
                            return null;
                        }
                    }
                    final String s5 = s4;
                    continue;
                }
            }
        }
        return s3;
    }
    
    private boolean a(final AdFrame adFrame) {
        if (adFrame != null) {
            if (FlurryAdModule.getInstance().b(adFrame.g().toString()) != null) {
                return true;
            }
            if (adFrame.b() == 3) {
                return true;
            }
        }
        return false;
    }
    
    private boolean a(final String str, final long n) {
        if (TextUtils.isEmpty((CharSequence)str)) {
            return false;
        }
        ay ay = com.flurry.sdk.ay.a;
        final String guessContentTypeFromName = URLConnection.guessContentTypeFromName(str);
        if (guessContentTypeFromName != null) {
            if (guessContentTypeFromName.startsWith("video")) {
                eo.a(3, ap.b, "Precaching: asset is a video: " + str);
                ay = com.flurry.sdk.ay.b;
            }
            else if (guessContentTypeFromName.startsWith("image")) {
                eo.a(3, ap.b, "Precaching: asset is an image: " + str);
                ay = com.flurry.sdk.ay.c;
            }
            else if (guessContentTypeFromName.startsWith("text")) {
                eo.a(3, ap.b, "Precaching: asset is text: " + str);
                ay = com.flurry.sdk.ay.d;
            }
            else {
                eo.a(5, ap.b, "Precaching: could not identify media type for asset: " + str);
            }
        }
        return this.a.a(str, ay, n);
    }
    
    private boolean a(final List list, final String s) {
        if (list == null) {
            return false;
        }
        if (TextUtils.isEmpty((CharSequence)s)) {
            return false;
        }
        final Iterator<CharSequence> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (s.equals(iterator.next().toString())) {
                return true;
            }
        }
        return false;
    }
    
    private String b(final AdFrame adFrame) {
        final ci b = FlurryAdModule.getInstance().b(adFrame.g().toString());
        if (b != null) {
            return b.f();
        }
        return null;
    }
    
    private String c(final AdFrame adFrame) {
        if (adFrame != null && adFrame.c() != null && adFrame.b() == 3) {
            return adFrame.c().toString();
        }
        return null;
    }
    
    private boolean c(final String s) {
        if (this.h && !TextUtils.isEmpty((CharSequence)s)) {
            eo.a(3, ap.b, "Precaching: Saving local asset for adUnit.");
            if (ar.d.equals(this.a.b(s))) {
                return this.e(s);
            }
        }
        return false;
    }
    
    private void d(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return;
        }
        this.a.b(s);
    }
    
    private boolean e(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_2       
        //     2: aload_1        
        //     3: invokestatic    android/text/TextUtils.isEmpty:(Ljava/lang/CharSequence;)Z
        //     6: ifeq            15
        //     9: iconst_0       
        //    10: istore          10
        //    12: iload           10
        //    14: ireturn        
        //    15: new             Ljava/io/File;
        //    18: dup            
        //    19: ldc             "fileStreamCacheDownloaderTmp"
        //    21: invokestatic    com/flurry/sdk/ce.b:(Ljava/lang/String;)Ljava/io/File;
        //    24: aload_0        
        //    25: aload_1        
        //    26: invokespecial   com/flurry/sdk/ap.f:(Ljava/lang/String;)Ljava/lang/String;
        //    29: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //    32: astore_3       
        //    33: aload_3        
        //    34: invokevirtual   java/io/File.exists:()Z
        //    37: istore          12
        //    39: iload           12
        //    41: ifeq            72
        //    44: aconst_null    
        //    45: astore          13
        //    47: aload_2        
        //    48: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    51: aload           13
        //    53: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    56: iconst_1       
        //    57: istore          10
        //    59: iload           10
        //    61: ifne            12
        //    64: aload_3        
        //    65: invokevirtual   java/io/File.delete:()Z
        //    68: pop            
        //    69: iload           10
        //    71: ireturn        
        //    72: aload_3        
        //    73: invokestatic    com/flurry/sdk/fd.a:(Ljava/io/File;)Z
        //    76: ifne            176
        //    79: new             Ljava/io/IOException;
        //    82: dup            
        //    83: new             Ljava/lang/StringBuilder;
        //    86: dup            
        //    87: ldc_w           "Precaching: Error creating directory to save tmp file:"
        //    90: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    93: aload_3        
        //    94: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //    97: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   100: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   103: invokespecial   java/io/IOException.<init>:(Ljava/lang/String;)V
        //   106: athrow         
        //   107: astore          8
        //   109: aconst_null    
        //   110: astore          7
        //   112: aload           8
        //   114: astore          9
        //   116: aconst_null    
        //   117: astore          6
        //   119: bipush          6
        //   121: getstatic       com/flurry/sdk/ap.b:Ljava/lang/String;
        //   124: new             Ljava/lang/StringBuilder;
        //   127: dup            
        //   128: ldc_w           "Precaching: Error saving temp file for url:"
        //   131: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   134: aload_1        
        //   135: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   138: ldc_w           " "
        //   141: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   144: aload           9
        //   146: invokevirtual   java/io/IOException.getMessage:()Ljava/lang/String;
        //   149: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   152: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   155: aload           9
        //   157: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   160: aload           6
        //   162: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   165: aload           7
        //   167: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   170: iconst_0       
        //   171: istore          10
        //   173: goto            59
        //   176: new             Ljava/io/FileOutputStream;
        //   179: dup            
        //   180: aload_3        
        //   181: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //   184: astore          13
        //   186: aload_0        
        //   187: getfield        com/flurry/sdk/ap.a:Lcom/flurry/sdk/ao;
        //   190: aload_1        
        //   191: invokevirtual   com/flurry/sdk/ao.c:(Ljava/lang/String;)Lcom/flurry/sdk/aw$b;
        //   194: astore          16
        //   196: aload           16
        //   198: astore_2       
        //   199: aload_2        
        //   200: ifnull          253
        //   203: aload_2        
        //   204: invokevirtual   com/flurry/sdk/aw$b.a:()Ljava/io/InputStream;
        //   207: aload           13
        //   209: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/InputStream;Ljava/io/OutputStream;)J
        //   212: pop2           
        //   213: iconst_3       
        //   214: getstatic       com/flurry/sdk/ap.b:Ljava/lang/String;
        //   217: new             Ljava/lang/StringBuilder;
        //   220: dup            
        //   221: ldc_w           "Precaching: Temp asset "
        //   224: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   227: aload_1        
        //   228: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   231: ldc_w           " saved to :"
        //   234: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   237: aload_3        
        //   238: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //   241: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   244: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   247: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //   250: goto            47
        //   253: iconst_3       
        //   254: getstatic       com/flurry/sdk/ap.b:Ljava/lang/String;
        //   257: new             Ljava/lang/StringBuilder;
        //   260: dup            
        //   261: ldc_w           "Precaching: Temp asset not saved.  Could not open cache reader: "
        //   264: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //   267: aload_1        
        //   268: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   271: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   274: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //   277: goto            47
        //   280: astore          17
        //   282: aload           13
        //   284: astore          7
        //   286: aload_2        
        //   287: astore          6
        //   289: aload           17
        //   291: astore          5
        //   293: aload           6
        //   295: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   298: aload           7
        //   300: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   303: aload           5
        //   305: athrow         
        //   306: astore          4
        //   308: aload           4
        //   310: astore          5
        //   312: aconst_null    
        //   313: astore          6
        //   315: aconst_null    
        //   316: astore          7
        //   318: goto            293
        //   321: astore          15
        //   323: aload           13
        //   325: astore          7
        //   327: aload           15
        //   329: astore          5
        //   331: aconst_null    
        //   332: astore          6
        //   334: goto            293
        //   337: astore          5
        //   339: goto            293
        //   342: astore          14
        //   344: aload           13
        //   346: astore          7
        //   348: aload           14
        //   350: astore          9
        //   352: aconst_null    
        //   353: astore          6
        //   355: goto            119
        //   358: astore          18
        //   360: aload           13
        //   362: astore          7
        //   364: aload_2        
        //   365: astore          6
        //   367: aload           18
        //   369: astore          9
        //   371: goto            119
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  33     39     107    119    Ljava/io/IOException;
        //  33     39     306    321    Any
        //  72     107    107    119    Ljava/io/IOException;
        //  72     107    306    321    Any
        //  119    160    337    342    Any
        //  176    186    107    119    Ljava/io/IOException;
        //  176    186    306    321    Any
        //  186    196    342    358    Ljava/io/IOException;
        //  186    196    321    337    Any
        //  203    250    358    374    Ljava/io/IOException;
        //  203    250    280    293    Any
        //  253    277    358    374    Ljava/io/IOException;
        //  253    277    280    293    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0119:
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
    
    private String f(final String s) {
        return ce.c(s);
    }
    
    private boolean g(final AdUnit adUnit) {
        if (adUnit == null) {
            return false;
        }
        final Iterator<AdFrame> iterator = adUnit.d().iterator();
        while (iterator.hasNext()) {
            if (this.a(iterator.next())) {
                return true;
            }
        }
        return false;
    }
    
    private void h(final AdUnit adUnit) {
        if (this.h && adUnit != null) {
            for (final AdFrame adFrame : adUnit.d()) {
                if (!ap$c.a.equals(ap$c.a(adFrame.h())) && this.a(adFrame)) {
                    final List j = adFrame.j();
                    final List k = adFrame.k();
                    if (j != null && j.size() > 0) {
                        final Iterator<CharSequence> iterator2 = j.iterator();
                        while (iterator2.hasNext()) {
                            this.d(iterator2.next().toString());
                        }
                    }
                    else {
                        final String b = this.b(adFrame);
                        if (!TextUtils.isEmpty((CharSequence)b) && !this.a(k, b)) {
                            this.d(b);
                        }
                        final String c = this.c(adFrame);
                        if (!TextUtils.isEmpty((CharSequence)c) && !this.a(k, c)) {
                            this.d(c);
                        }
                        final String[] c2 = ap.c;
                        for (int length = c2.length, i = 0; i < length; ++i) {
                            final String a = this.a(adFrame, c2[i]);
                            if (!TextUtils.isEmpty((CharSequence)a) && !this.a(k, a)) {
                                this.d(a);
                            }
                        }
                    }
                }
            }
        }
    }
    
    private List i() {
        synchronized (this.i) {
            return this.i.a();
        }
    }
    
    private void j() {
        try {
            final File b = ce.b("fileStreamCacheDownloaderTmp");
            eo.a(3, ap.b, "Precaching: Cleaning temp asset directory: " + b);
            fd.b(b);
        }
        catch (Exception ex) {
            eo.a(6, ap.b, "Precaching: Error cleaning temp asset directory: " + ex.getMessage(), ex);
        }
    }
    
    public File a(final String s) {
        if (this.h && !TextUtils.isEmpty((CharSequence)s)) {
            final File file = new File(ce.b("fileStreamCacheDownloaderTmp"), this.f(s));
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }
    
    public void a(final long e, final long f) {
        synchronized (this) {
            if (!this.g) {
                eo.a(3, ap.b, "Precaching: Initializing AssetCacheManager.");
                this.e = e;
                this.f = f;
                this.g = true;
            }
        }
    }
    
    public void a(final ap$b ap$b) {
        synchronized (this.i) {
            this.i.a(ap$b);
        }
    }
    
    public void a(final InputStream inputStream) {
        if (!this.g) {
            return;
        }
        this.a.a(inputStream);
    }
    
    public void a(final OutputStream outputStream) {
        if (!this.g) {
            return;
        }
        this.a.a(outputStream);
    }
    
    @Override
    public void a(final String s, final ar ar) {
        try {
            final Iterator<ap$b> iterator = this.i().iterator();
            while (iterator.hasNext()) {
                iterator.next().a(s, ar);
            }
        }
        catch (Throwable t) {
            eo.a(6, ap.b, "", t);
        }
    }
    
    public void a(final String s, final List list) {
        if (this.h && list != null) {
            eo.a(3, ap.b, "Handling ad response");
            if (!TextUtils.isEmpty((CharSequence)s)) {
                this.b(s, list);
                return;
            }
            int n;
            if (this.f == 0L) {
                n = 5;
            }
            else {
                n = (int)(this.e / this.f);
            }
            final Iterator<AdUnit> iterator = list.iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                final int n3 = n2 + this.e(iterator.next());
                if (n3 >= n) {
                    break;
                }
                n2 = n3;
            }
        }
    }
    
    public boolean a(final AdUnit adUnit) {
        if (!this.h) {
            return false;
        }
        if (adUnit == null) {
            return false;
        }
        if (!this.g(adUnit)) {
            return false;
        }
        final Iterator<AdFrame> iterator = adUnit.d().iterator();
        while (iterator.hasNext()) {
            final ap$c a = ap$c.a(iterator.next().h());
            if (ap$c.b.equals(a) || ap$c.c.equals(a)) {
                return true;
            }
        }
        return false;
    }
    
    public void b(final String s) {
        if (!this.h) {
            return;
        }
        this.a.a(s);
    }
    
    public void b(final String s, final List list) {
        if (this.h && list != null && !TextUtils.isEmpty((CharSequence)s)) {
            for (int i = -1 + list.size(); i >= 0; --i) {
                this.h(list.get(i));
            }
            final Iterator<AdUnit> iterator = list.iterator();
            int n = 0;
            while (iterator.hasNext()) {
                int n2;
                if (this.e(iterator.next()) > 0) {
                    n2 = 1;
                }
                else {
                    n2 = 0;
                }
                final int n3 = n2 + n;
                if (n3 >= 2) {
                    break;
                }
                n = n3;
            }
        }
    }
    
    public boolean b() {
        return this.g;
    }
    
    public boolean b(final AdUnit adUnit) {
        if (!this.h) {
            return false;
        }
        if (adUnit == null) {
            return false;
        }
        if (!this.g(adUnit)) {
            return false;
        }
        final Iterator<AdFrame> iterator = adUnit.d().iterator();
        while (iterator.hasNext()) {
            final ap$c a = ap$c.a(iterator.next().h());
            if (this.g(adUnit) && ap$c.b.equals(a)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean b(final ap$b ap$b) {
        synchronized (this.i) {
            return this.i.b(ap$b);
        }
    }
    
    public ap$a c(final AdUnit adUnit) {
        ap$a ap$a;
        if (!this.h) {
            ap$a = com.flurry.sdk.ap$a.f;
        }
        else {
            if (adUnit == null) {
                return com.flurry.sdk.ap$a.d;
            }
            if (!this.g(adUnit)) {
                return com.flurry.sdk.ap$a.d;
            }
            final ap$a a = com.flurry.sdk.ap$a.a;
            final Iterator<AdFrame> iterator = (Iterator<AdFrame>)adUnit.d().iterator();
            ap$a = a;
            while (iterator.hasNext()) {
                final AdFrame adFrame = iterator.next();
                if (this.a(adFrame)) {
                    final String b = this.b(adFrame);
                    if (!TextUtils.isEmpty((CharSequence)b)) {
                        ap$a = this.a(ap$a, this.a.b(b));
                    }
                    final String c = this.c(adFrame);
                    if (!TextUtils.isEmpty((CharSequence)c)) {
                        ap$a = this.a(ap$a, this.a.b(c));
                    }
                    final String[] c2 = ap.c;
                    for (int length = c2.length, i = 0; i < length; ++i) {
                        final String a2 = this.a(adFrame, c2[i]);
                        if (!TextUtils.isEmpty((CharSequence)a2)) {
                            ap$a = this.a(ap$a, this.a.b(a2));
                        }
                    }
                }
            }
        }
        return ap$a;
    }
    
    public void c() {
        synchronized (this) {
            if (this.g && !this.h) {
                eo.a(3, ap.b, "Precaching: Starting AssetCacheManager.");
                (this.a = new ao("fileStreamCacheDownloader", this.e, this.f, false)).a(this);
                this.a.a();
                this.h = true;
            }
        }
    }
    
    public void d() {
        synchronized (this) {
            if (this.h) {
                eo.a(3, ap.b, "Precaching: Stopping AssetCacheManager.");
                this.a.b();
                this.h = false;
            }
        }
    }
    
    public boolean d(final AdUnit adUnit) {
        if (!this.h) {
            return false;
        }
        if (adUnit == null) {
            return false;
        }
        eo.a(3, ap.b, "Precaching: Saving local assets for adUnit.");
        this.j();
        for (final AdFrame adFrame : adUnit.d()) {
            if (this.a(adFrame)) {
                final String b = this.b(adFrame);
                if (!TextUtils.isEmpty((CharSequence)b) && !this.c(b)) {
                    return false;
                }
                final String c = this.c(adFrame);
                if (!TextUtils.isEmpty((CharSequence)c) && !this.c(c)) {
                    return false;
                }
                final String[] c2 = ap.c;
                for (int length = c2.length, i = 0; i < length; ++i) {
                    final String a = this.a(adFrame, c2[i]);
                    if (!TextUtils.isEmpty((CharSequence)a) && !this.c(a)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public int e(final AdUnit adUnit) {
        if (this.h && adUnit != null) {
            final Iterator<AdFrame> iterator = (Iterator<AdFrame>)adUnit.d().iterator();
            int n = 0;
            while (iterator.hasNext()) {
                final AdFrame adFrame = iterator.next();
                if (!ap$c.a.equals(ap$c.a(adFrame.h())) && this.a(adFrame)) {
                    final List j = adFrame.j();
                    final List k = adFrame.k();
                    final long longValue = adFrame.i();
                    if (j != null && j.size() > 0) {
                        final Iterator<CharSequence> iterator2 = j.iterator();
                        while (iterator2.hasNext()) {
                            if (this.a(iterator2.next().toString(), longValue)) {
                                ++n;
                            }
                        }
                    }
                    else {
                        final String b = this.b(adFrame);
                        if (!TextUtils.isEmpty((CharSequence)b) && !this.a(k, b) && this.a(b, longValue)) {
                            ++n;
                        }
                        final String c = this.c(adFrame);
                        if (!TextUtils.isEmpty((CharSequence)c) && !this.a(k, c) && this.a(c, longValue)) {
                            ++n;
                        }
                        final String[] c2 = ap.c;
                        for (int length = c2.length, i = 0; i < length; ++i) {
                            final String a = this.a(adFrame, c2[i]);
                            if (!TextUtils.isEmpty((CharSequence)a) && !this.a(k, a) && this.a(a, longValue)) {
                                ++n;
                            }
                        }
                    }
                }
            }
            return n;
        }
        return 0;
    }
    
    public void e() {
        synchronized (this) {
            if (this.h) {
                eo.a(3, ap.b, "Precaching: Pausing AssetCacheManager.");
                this.a.c();
            }
        }
    }
    
    public void f() {
        synchronized (this) {
            if (this.h) {
                eo.a(3, ap.b, "Precaching: Resuming AssetCacheManager.");
                this.a.d();
            }
        }
    }
    
    public void f(final AdUnit adUnit) {
        if (this.h && adUnit != null) {
            for (final AdFrame adFrame : adUnit.d()) {
                if (!ap$c.a.equals(ap$c.a(adFrame.h())) && this.a(adFrame)) {
                    final List j = adFrame.j();
                    final List k = adFrame.k();
                    adFrame.i();
                    if (j != null && j.size() > 0) {
                        final Iterator<CharSequence> iterator2 = j.iterator();
                        while (iterator2.hasNext()) {
                            this.b(iterator2.next().toString());
                        }
                    }
                    else {
                        final String b = this.b(adFrame);
                        if (!TextUtils.isEmpty((CharSequence)b) && !this.a(k, b)) {
                            this.b(b.toString());
                        }
                        final String c = this.c(adFrame);
                        if (!TextUtils.isEmpty((CharSequence)c) && !this.a(k, c)) {
                            this.b(c.toString());
                        }
                        final String[] c2 = ap.c;
                        for (int length = c2.length, i = 0; i < length; ++i) {
                            final String a = this.a(adFrame, c2[i]);
                            if (!TextUtils.isEmpty((CharSequence)a) && !this.a(k, a)) {
                                this.b(a.toString());
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void g() {
        if (!this.h) {
            return;
        }
        this.a.e();
    }
    
    public List h() {
        if (!this.h) {
            return Collections.emptyList();
        }
        return this.a.h();
    }
}

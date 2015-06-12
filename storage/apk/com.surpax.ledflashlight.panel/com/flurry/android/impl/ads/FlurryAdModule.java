// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.android.impl.ads;

import com.flurry.android.FlurryAgent;
import android.os.SystemClock;
import com.flurry.android.impl.ads.avro.protocol.v10.Location;
import com.flurry.sdk.cx;
import com.flurry.sdk.dl;
import com.flurry.sdk.dv;
import com.flurry.sdk.dz;
import com.flurry.sdk.am;
import com.flurry.sdk.cp;
import com.flurry.sdk.co;
import com.flurry.sdk.cg;
import com.flurry.sdk.dj;
import com.flurry.sdk.du$a;
import com.flurry.android.FlurryAdListener;
import android.os.Bundle;
import com.flurry.sdk.g;
import com.flurry.sdk.n$e;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import android.app.Activity;
import com.flurry.sdk.fe;
import com.flurry.android.impl.ads.avro.protocol.v10.Callback;
import com.flurry.sdk.a;
import com.flurry.sdk.l;
import com.flurry.sdk.ci;
import com.flurry.sdk.c;
import com.flurry.sdk.j;
import com.flurry.sdk.ai;
import com.flurry.sdk.ad;
import com.flurry.sdk.q;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.sdk.ah;
import com.flurry.android.FlurryAdSize;
import android.view.ViewGroup;
import android.content.Context;
import android.content.Intent;
import com.flurry.sdk.ev;
import com.flurry.sdk.ev$a;
import com.flurry.sdk.x;
import com.flurry.android.impl.ads.avro.protocol.v10.FrequencyCapInfo;
import java.util.Iterator;
import com.flurry.sdk.dr;
import java.nio.ByteBuffer;
import com.flurry.android.impl.ads.avro.protocol.v10.AdReportedId;
import com.flurry.sdk.ff;
import com.flurry.sdk.do;
import android.app.KeyguardManager;
import com.flurry.sdk.dn;
import android.text.TextUtils;
import com.flurry.sdk.eo;
import com.flurry.sdk.cd;
import com.flurry.android.impl.ads.avro.protocol.v10.SdkLogRequest;
import com.flurry.sdk.p;
import com.flurry.sdk.o;
import android.os.Build;
import android.os.Build$VERSION;
import java.util.Collection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import com.flurry.android.ICustomAdNetworkHandler;
import com.flurry.sdk.ap;
import com.flurry.sdk.y;
import java.util.TreeMap;
import com.flurry.sdk.t;
import com.flurry.sdk.u;
import com.flurry.sdk.r;
import com.flurry.sdk.s;
import com.flurry.sdk.ac;
import java.util.Set;
import java.util.Map;
import java.lang.ref.WeakReference;
import com.flurry.sdk.ak;
import com.flurry.sdk.k;
import com.flurry.sdk.e;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import java.util.List;
import com.flurry.sdk.et;
import com.flurry.sdk.du;
import com.flurry.sdk.ae;

public class FlurryAdModule implements ae, du, et
{
    private static FlurryAdModule L;
    private static List p;
    private static final String q;
    private AdUnit A;
    private e B;
    private AdUnit C;
    private final k D;
    private final ak E;
    private WeakReference F;
    private CharSequence G;
    private final List H;
    private final List I;
    private final Map J;
    private final Set K;
    private boolean M;
    private ac N;
    private s O;
    private r P;
    private u Q;
    private t R;
    volatile Map a;
    volatile TreeMap b;
    long c;
    long d;
    long e;
    y f;
    ap g;
    public ICustomAdNetworkHandler h;
    int i;
    volatile Map j;
    volatile Map k;
    volatile Map l;
    volatile List m;
    volatile boolean n;
    Map o;
    private File r;
    private File s;
    private File t;
    private String u;
    private String v;
    private String w;
    private volatile String x;
    private volatile String y;
    private e z;
    
    static {
        q = FlurryAdModule.class.getSimpleName();
    }
    
    public FlurryAdModule() {
        this.r = null;
        this.s = null;
        this.t = null;
        this.x = null;
        this.y = null;
        this.F = new WeakReference(null);
        this.f = com.flurry.sdk.y.a();
        this.g = ap.a();
        this.Q = new u(this);
        this.R = new t(this);
        this.I = new ArrayList();
        this.j = new HashMap();
        this.k = new HashMap();
        this.l = new HashMap();
        this.m = new ArrayList();
        this.n = false;
        final HashMap<String, String> m = new HashMap<String, String>();
        m.put("playVideo", "directOpen");
        m.put("open", "directOpen");
        m.put("expand", "doExpand");
        m.put("collapse", "doCollapse");
        this.J = Collections.unmodifiableMap((Map<?, ?>)m);
        final HashSet<Object> s = new HashSet<Object>();
        s.addAll(Arrays.asList("notifyUser", "nextFrame", "closeAd", "expandAd", "collapseAd", "verifyURL"));
        this.K = Collections.unmodifiableSet((Set<?>)s);
        this.P = new r(this);
        FlurryAdModule.p = Arrays.asList(0, 1, 2, 3, 4, 5);
        this.u = Build$VERSION.RELEASE;
        this.v = Build.DEVICE;
        this.a = new HashMap();
        this.D = new o();
        this.E = new p();
        this.H = new ArrayList();
        this.b = new TreeMap();
    }
    
    private SdkLogRequest a(final List list) {
        final List a = cd.a(list);
        if (a.isEmpty()) {
            eo.a(3, FlurryAdModule.q, "List of adLogs is empty");
            return null;
        }
        final String j = this.j();
        if (TextUtils.isEmpty((CharSequence)j)) {
            eo.a(3, FlurryAdModule.q, "ApiKey is null.");
            return null;
        }
        final SdkLogRequest a2 = SdkLogRequest.b().a(j).a(this.E()).b(a).a(false).a(System.currentTimeMillis()).b(Integer.toString(dn.a().b())).a();
        eo.a(3, FlurryAdModule.q, "Got ad log request:" + a2.toString());
        return a2;
    }
    
    private void ad() {
        synchronized (this) {
            final SdkLogRequest a = this.a(this.I);
            this.I.clear();
            this.O.a(a, this.D(), this.j(), new StringBuilder().append(dn.a().b()).toString());
        }
    }
    
    private void ae() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_1       
        //     2: aload_0        
        //     3: monitorenter   
        //     4: iconst_4       
        //     5: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //     8: ldc_w           "Saving AdLog data."
        //    11: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //    14: aload_0        
        //    15: getfield        com/flurry/android/impl/ads/FlurryAdModule.r:Ljava/io/File;
        //    18: invokestatic    com/flurry/sdk/fd.a:(Ljava/io/File;)Z
        //    21: istore          8
        //    23: iload           8
        //    25: ifne            39
        //    28: aconst_null    
        //    29: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    32: aconst_null    
        //    33: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    36: aload_0        
        //    37: monitorexit    
        //    38: return         
        //    39: new             Ljava/io/FileOutputStream;
        //    42: dup            
        //    43: aload_0        
        //    44: getfield        com/flurry/android/impl/ads/FlurryAdModule.r:Ljava/io/File;
        //    47: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //    50: astore          5
        //    52: new             Ljava/io/DataOutputStream;
        //    55: dup            
        //    56: aload           5
        //    58: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    61: astore          7
        //    63: aload_0        
        //    64: getfield        com/flurry/android/impl/ads/FlurryAdModule.I:Ljava/util/List;
        //    67: aload           7
        //    69: invokestatic    com/flurry/sdk/d.a:(Ljava/util/List;Ljava/io/DataOutput;)V
        //    72: aload           7
        //    74: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    77: aload           5
        //    79: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    82: goto            36
        //    85: astore_2       
        //    86: aload_0        
        //    87: monitorexit    
        //    88: aload_2        
        //    89: athrow         
        //    90: astore          6
        //    92: aconst_null    
        //    93: astore          7
        //    95: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //    98: ldc_w           "Error saving AdLog data."
        //   101: aload           6
        //   103: invokestatic    com/flurry/sdk/eo.b:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   106: aload           7
        //   108: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   111: aload_1        
        //   112: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   115: goto            36
        //   118: aload           4
        //   120: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   123: aload           5
        //   125: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   128: aload_3        
        //   129: athrow         
        //   130: astore_3       
        //   131: aconst_null    
        //   132: astore          4
        //   134: goto            118
        //   137: astore_3       
        //   138: aload           7
        //   140: astore          4
        //   142: goto            118
        //   145: astore_3       
        //   146: aload_1        
        //   147: astore          5
        //   149: aload           7
        //   151: astore          4
        //   153: goto            118
        //   156: astore          6
        //   158: aload           5
        //   160: astore_1       
        //   161: aconst_null    
        //   162: astore          7
        //   164: goto            95
        //   167: astore          6
        //   169: aload           5
        //   171: astore_1       
        //   172: goto            95
        //   175: astore_3       
        //   176: aconst_null    
        //   177: astore          4
        //   179: aconst_null    
        //   180: astore          5
        //   182: goto            118
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  4      14     85     90     Any
        //  14     23     90     95     Ljava/lang/Exception;
        //  14     23     175    185    Any
        //  28     36     85     90     Any
        //  39     52     90     95     Ljava/lang/Exception;
        //  39     52     175    185    Any
        //  52     63     156    167    Ljava/lang/Exception;
        //  52     63     130    137    Any
        //  63     72     167    175    Ljava/lang/Exception;
        //  63     72     137    145    Any
        //  72     82     85     90     Any
        //  95     106    145    156    Any
        //  106    115    85     90     Any
        //  118    130    85     90     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 94, Size: 94
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
    
    private void af() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aconst_null    
        //     1: astore_1       
        //     2: aload_0        
        //     3: monitorenter   
        //     4: iconst_4       
        //     5: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //     8: ldc_w           "Loading AdLog data."
        //    11: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //    14: aload_0        
        //    15: getfield        com/flurry/android/impl/ads/FlurryAdModule.r:Ljava/io/File;
        //    18: invokevirtual   java/io/File.exists:()Z
        //    21: istore_3       
        //    22: iload_3        
        //    23: ifeq            152
        //    26: new             Ljava/io/FileInputStream;
        //    29: dup            
        //    30: aload_0        
        //    31: getfield        com/flurry/android/impl/ads/FlurryAdModule.r:Ljava/io/File;
        //    34: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    37: astore          4
        //    39: new             Ljava/io/DataInputStream;
        //    42: dup            
        //    43: aload           4
        //    45: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    48: astore          5
        //    50: aload_0        
        //    51: getfield        com/flurry/android/impl/ads/FlurryAdModule.I:Ljava/util/List;
        //    54: aload           5
        //    56: invokestatic    com/flurry/sdk/d.a:(Ljava/io/DataInput;)Ljava/util/List;
        //    59: invokeinterface java/util/List.addAll:(Ljava/util/Collection;)Z
        //    64: pop            
        //    65: iconst_1       
        //    66: istore          8
        //    68: aload           5
        //    70: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    73: aload           4
        //    75: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    78: iload           8
        //    80: ifne            101
        //    83: iconst_3       
        //    84: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //    87: ldc_w           "Deleting AdLog file."
        //    90: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //    93: aload_0        
        //    94: getfield        com/flurry/android/impl/ads/FlurryAdModule.r:Ljava/io/File;
        //    97: invokevirtual   java/io/File.delete:()Z
        //   100: pop            
        //   101: aload_0        
        //   102: monitorexit    
        //   103: return         
        //   104: astore          6
        //   106: aconst_null    
        //   107: astore          5
        //   109: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //   112: ldc_w           "Error loading AdLog data."
        //   115: aload           6
        //   117: invokestatic    com/flurry/sdk/eo.b:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   120: aload           5
        //   122: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   125: aload_1        
        //   126: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   129: iconst_0       
        //   130: istore          8
        //   132: goto            78
        //   135: aload           5
        //   137: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   140: aload_1        
        //   141: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   144: aload           7
        //   146: athrow         
        //   147: astore_2       
        //   148: aload_0        
        //   149: monitorexit    
        //   150: aload_2        
        //   151: athrow         
        //   152: iconst_3       
        //   153: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //   156: ldc_w           "AdLogs cache file doesn't exist."
        //   159: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //   162: goto            101
        //   165: astore          7
        //   167: aload           4
        //   169: astore_1       
        //   170: aconst_null    
        //   171: astore          5
        //   173: goto            135
        //   176: astore          7
        //   178: aload           4
        //   180: astore_1       
        //   181: goto            135
        //   184: astore          7
        //   186: goto            135
        //   189: astore          6
        //   191: aload           4
        //   193: astore_1       
        //   194: aconst_null    
        //   195: astore          5
        //   197: goto            109
        //   200: astore          6
        //   202: aload           4
        //   204: astore_1       
        //   205: goto            109
        //   208: astore          7
        //   210: aconst_null    
        //   211: astore          5
        //   213: aconst_null    
        //   214: astore_1       
        //   215: goto            135
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  4      22     147    152    Any
        //  26     39     104    109    Ljava/lang/Exception;
        //  26     39     208    218    Any
        //  39     50     189    200    Ljava/lang/Exception;
        //  39     50     165    176    Any
        //  50     65     200    208    Ljava/lang/Exception;
        //  50     65     176    184    Any
        //  68     78     147    152    Any
        //  83     101    147    152    Any
        //  109    120    184    189    Any
        //  120    129    147    152    Any
        //  135    147    147    152    Any
        //  152    162    147    152    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 108, Size: 108
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
    
    public static FlurryAdModule getInstance() {
        synchronized (FlurryAdModule.class) {
            if (FlurryAdModule.L == null) {
                FlurryAdModule.L = new FlurryAdModule();
            }
            return FlurryAdModule.L;
        }
    }
    
    public static boolean i() {
        return ((KeyguardManager)do.a().b().getSystemService("keyguard")).inKeyguardRestrictedInputMode();
    }
    
    public void A() {
        this.o = null;
    }
    
    public Map B() {
        final Map z = this.z();
        if (this.N != null) {
            final String a = this.N.a();
            if (!TextUtils.isEmpty((CharSequence)a)) {
                z.put("appCloudUserId", a);
            }
        }
        return z;
    }
    
    public void C() {
        synchronized (this) {
            this.b(new ff() {
                @Override
                public void a() {
                    FlurryAdModule.this.ad();
                }
            });
        }
    }
    
    public String D() {
        return this.x() + "/v2/postAdLog.do";
    }
    
    public List E() {
        final ArrayList<AdReportedId> list = new ArrayList<AdReportedId>();
        for (final Map.Entry<K, ByteBuffer> entry : dn.a().l().entrySet()) {
            list.add(AdReportedId.b().a(entry.getValue()).a(((dr)entry.getKey()).d).a());
        }
        return list;
    }
    
    public List F() {
        final ArrayList<FrequencyCapInfo> list = new ArrayList<FrequencyCapInfo>();
        for (final x x : this.f.c()) {
            list.add(FrequencyCapInfo.b().a(x.b()).b(x.h()).b(x.e()).c(x.f()).d(x.g()).a(x.i()).a(x.c()).a());
        }
        return list;
    }
    
    public void G() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: monitorenter   
        //     2: iconst_4       
        //     3: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //     6: ldc_w           "Saving FreqCap data."
        //     9: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //    12: aload_0        
        //    13: getfield        com/flurry/android/impl/ads/FlurryAdModule.f:Lcom/flurry/sdk/y;
        //    16: invokevirtual   com/flurry/sdk/y.d:()V
        //    19: aload_0        
        //    20: getfield        com/flurry/android/impl/ads/FlurryAdModule.s:Ljava/io/File;
        //    23: invokestatic    com/flurry/sdk/fd.a:(Ljava/io/File;)Z
        //    26: istore          7
        //    28: iload           7
        //    30: ifne            44
        //    33: aconst_null    
        //    34: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    37: aconst_null    
        //    38: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    41: aload_0        
        //    42: monitorexit    
        //    43: return         
        //    44: new             Ljava/io/FileOutputStream;
        //    47: dup            
        //    48: aload_0        
        //    49: getfield        com/flurry/android/impl/ads/FlurryAdModule.s:Ljava/io/File;
        //    52: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //    55: astore          6
        //    57: new             Ljava/io/DataOutputStream;
        //    60: dup            
        //    61: aload           6
        //    63: invokespecial   java/io/DataOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    66: astore_3       
        //    67: aload_0        
        //    68: getfield        com/flurry/android/impl/ads/FlurryAdModule.f:Lcom/flurry/sdk/y;
        //    71: invokevirtual   com/flurry/sdk/y.c:()Ljava/util/List;
        //    74: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //    79: astore          8
        //    81: aload           8
        //    83: invokeinterface java/util/Iterator.hasNext:()Z
        //    88: ifeq            149
        //    91: aload           8
        //    93: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    98: checkcast       Lcom/flurry/sdk/x;
        //   101: astore          9
        //   103: aload_3        
        //   104: iconst_1       
        //   105: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   108: aload           9
        //   110: aload_3        
        //   111: invokevirtual   com/flurry/sdk/x.a:(Ljava/io/DataOutput;)V
        //   114: goto            81
        //   117: astore_2       
        //   118: aload           6
        //   120: astore          4
        //   122: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //   125: ldc_w           "Error saving FreqCap data."
        //   128: aload_2        
        //   129: invokestatic    com/flurry/sdk/eo.b:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   132: aload_3        
        //   133: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   136: aload           4
        //   138: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   141: goto            41
        //   144: astore_1       
        //   145: aload_0        
        //   146: monitorexit    
        //   147: aload_1        
        //   148: athrow         
        //   149: aload_3        
        //   150: iconst_0       
        //   151: invokevirtual   java/io/DataOutputStream.writeShort:(I)V
        //   154: aload_3        
        //   155: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   158: aload           6
        //   160: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   163: goto            41
        //   166: aload_3        
        //   167: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   170: aload           6
        //   172: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   175: aload           5
        //   177: athrow         
        //   178: astore          5
        //   180: aconst_null    
        //   181: astore_3       
        //   182: goto            166
        //   185: astore          5
        //   187: goto            166
        //   190: astore          5
        //   192: aload           4
        //   194: astore          6
        //   196: goto            166
        //   199: astore_2       
        //   200: aconst_null    
        //   201: astore_3       
        //   202: aconst_null    
        //   203: astore          4
        //   205: goto            122
        //   208: astore_2       
        //   209: aload           6
        //   211: astore          4
        //   213: aconst_null    
        //   214: astore_3       
        //   215: goto            122
        //   218: astore          5
        //   220: aconst_null    
        //   221: astore_3       
        //   222: aconst_null    
        //   223: astore          6
        //   225: goto            166
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  2      19     144    149    Any
        //  19     28     199    208    Ljava/lang/Exception;
        //  19     28     218    228    Any
        //  33     41     144    149    Any
        //  44     57     199    208    Ljava/lang/Exception;
        //  44     57     218    228    Any
        //  57     67     208    218    Ljava/lang/Exception;
        //  57     67     178    185    Any
        //  67     81     117    122    Ljava/lang/Exception;
        //  67     81     185    190    Any
        //  81     114    117    122    Ljava/lang/Exception;
        //  81     114    185    190    Any
        //  122    132    190    199    Any
        //  132    141    144    149    Any
        //  149    154    117    122    Ljava/lang/Exception;
        //  149    154    185    190    Any
        //  154    163    144    149    Any
        //  166    178    144    149    Any
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
    
    void H() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: monitorenter   
        //     2: iconst_4       
        //     3: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //     6: ldc_w           "Loading FreqCap data."
        //     9: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //    12: aload_0        
        //    13: getfield        com/flurry/android/impl/ads/FlurryAdModule.s:Ljava/io/File;
        //    16: invokevirtual   java/io/File.exists:()Z
        //    19: istore_2       
        //    20: iload_2        
        //    21: ifeq            167
        //    24: new             Ljava/io/FileInputStream;
        //    27: dup            
        //    28: aload_0        
        //    29: getfield        com/flurry/android/impl/ads/FlurryAdModule.s:Ljava/io/File;
        //    32: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    35: astore_3       
        //    36: new             Ljava/io/DataInputStream;
        //    39: dup            
        //    40: aload_3        
        //    41: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    44: astore          4
        //    46: aload           4
        //    48: invokevirtual   java/io/DataInputStream.readShort:()S
        //    51: ifeq            128
        //    54: aload_0        
        //    55: getfield        com/flurry/android/impl/ads/FlurryAdModule.f:Lcom/flurry/sdk/y;
        //    58: new             Lcom/flurry/sdk/x;
        //    61: dup            
        //    62: aload           4
        //    64: invokespecial   com/flurry/sdk/x.<init>:(Ljava/io/DataInput;)V
        //    67: invokevirtual   com/flurry/sdk/y.a:(Lcom/flurry/sdk/x;)V
        //    70: goto            46
        //    73: astore          6
        //    75: aload_3        
        //    76: astore          7
        //    78: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //    81: ldc_w           "Error loading FreqCap data."
        //    84: aload           6
        //    86: invokestatic    com/flurry/sdk/eo.b:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //    89: aload           4
        //    91: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    94: aload           7
        //    96: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    99: iconst_0       
        //   100: istore          8
        //   102: iload           8
        //   104: ifne            125
        //   107: iconst_3       
        //   108: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //   111: ldc_w           "Deleting FreqCap file."
        //   114: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //   117: aload_0        
        //   118: getfield        com/flurry/android/impl/ads/FlurryAdModule.s:Ljava/io/File;
        //   121: invokevirtual   java/io/File.delete:()Z
        //   124: pop            
        //   125: aload_0        
        //   126: monitorexit    
        //   127: return         
        //   128: iconst_1       
        //   129: istore          8
        //   131: aload           4
        //   133: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   136: aload_3        
        //   137: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   140: goto            102
        //   143: astore_1       
        //   144: aload_0        
        //   145: monitorexit    
        //   146: aload_1        
        //   147: athrow         
        //   148: astore          5
        //   150: aconst_null    
        //   151: astore          4
        //   153: aconst_null    
        //   154: astore_3       
        //   155: aload           4
        //   157: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   160: aload_3        
        //   161: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   164: aload           5
        //   166: athrow         
        //   167: iconst_3       
        //   168: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //   171: ldc_w           "FreqCap file doesn't exist."
        //   174: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //   177: goto            125
        //   180: astore          5
        //   182: aconst_null    
        //   183: astore          4
        //   185: goto            155
        //   188: astore          5
        //   190: goto            155
        //   193: astore          5
        //   195: aload           7
        //   197: astore_3       
        //   198: goto            155
        //   201: astore          6
        //   203: aconst_null    
        //   204: astore          4
        //   206: aconst_null    
        //   207: astore          7
        //   209: goto            78
        //   212: astore          6
        //   214: aload_3        
        //   215: astore          7
        //   217: aconst_null    
        //   218: astore          4
        //   220: goto            78
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  2      20     143    148    Any
        //  24     36     201    212    Ljava/lang/Exception;
        //  24     36     148    155    Any
        //  36     46     212    223    Ljava/lang/Exception;
        //  36     46     180    188    Any
        //  46     70     73     78     Ljava/lang/Exception;
        //  46     70     188    193    Any
        //  78     89     193    201    Any
        //  89     99     143    148    Any
        //  107    125    143    148    Any
        //  131    140    143    148    Any
        //  155    167    143    148    Any
        //  167    177    143    148    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 110, Size: 110
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
    
    public void I() {
        synchronized (this) {
            this.g.c();
        }
    }
    
    public void J() {
        synchronized (this) {
            this.g.d();
        }
    }
    
    public void K() {
        synchronized (this) {
            this.g.e();
        }
    }
    
    public void L() {
        synchronized (this) {
            this.g.f();
        }
    }
    
    public void M() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: monitorenter   
        //     2: invokestatic    com/flurry/sdk/ap.a:()Lcom/flurry/sdk/ap;
        //     5: invokevirtual   com/flurry/sdk/ap.b:()Z
        //     8: istore_2       
        //     9: iload_2        
        //    10: ifne            16
        //    13: aload_0        
        //    14: monitorexit    
        //    15: return         
        //    16: iconst_4       
        //    17: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //    20: ldc_w           "Saving CachedAsset data."
        //    23: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //    26: aload_0        
        //    27: getfield        com/flurry/android/impl/ads/FlurryAdModule.t:Ljava/io/File;
        //    30: invokestatic    com/flurry/sdk/fd.a:(Ljava/io/File;)Z
        //    33: istore          6
        //    35: iload           6
        //    37: ifne            52
        //    40: aconst_null    
        //    41: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    44: goto            13
        //    47: astore_1       
        //    48: aload_0        
        //    49: monitorexit    
        //    50: aload_1        
        //    51: athrow         
        //    52: new             Ljava/io/FileOutputStream;
        //    55: dup            
        //    56: aload_0        
        //    57: getfield        com/flurry/android/impl/ads/FlurryAdModule.t:Ljava/io/File;
        //    60: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
        //    63: astore          4
        //    65: invokestatic    com/flurry/sdk/ap.a:()Lcom/flurry/sdk/ap;
        //    68: aload           4
        //    70: invokevirtual   com/flurry/sdk/ap.a:(Ljava/io/OutputStream;)V
        //    73: aload           4
        //    75: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    78: goto            13
        //    81: astore          5
        //    83: aconst_null    
        //    84: astore          4
        //    86: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //    89: ldc_w           "Error saving CachedAsset data."
        //    92: aload           5
        //    94: invokestatic    com/flurry/sdk/eo.b:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //    97: aload           4
        //    99: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   102: goto            13
        //   105: aload           4
        //   107: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   110: aload_3        
        //   111: athrow         
        //   112: astore_3       
        //   113: goto            105
        //   116: astore          5
        //   118: goto            86
        //   121: astore_3       
        //   122: aconst_null    
        //   123: astore          4
        //   125: goto            105
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  2      9      47     52     Any
        //  16     26     47     52     Any
        //  26     35     81     86     Ljava/lang/Exception;
        //  26     35     121    128    Any
        //  40     44     47     52     Any
        //  52     65     81     86     Ljava/lang/Exception;
        //  52     65     121    128    Any
        //  65     73     116    121    Ljava/lang/Exception;
        //  65     73     112    116    Any
        //  73     78     47     52     Any
        //  86     97     112    116    Any
        //  97     102    47     52     Any
        //  105    112    47     52     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0086:
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
    
    void N() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: monitorenter   
        //     2: invokestatic    com/flurry/sdk/ap.a:()Lcom/flurry/sdk/ap;
        //     5: invokevirtual   com/flurry/sdk/ap.b:()Z
        //     8: istore_2       
        //     9: iload_2        
        //    10: ifne            16
        //    13: aload_0        
        //    14: monitorexit    
        //    15: return         
        //    16: iconst_4       
        //    17: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //    20: ldc_w           "Loading CachedAsset data."
        //    23: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //    26: aload_0        
        //    27: getfield        com/flurry/android/impl/ads/FlurryAdModule.t:Ljava/io/File;
        //    30: invokevirtual   java/io/File.exists:()Z
        //    33: istore_3       
        //    34: iload_3        
        //    35: ifeq            145
        //    38: new             Ljava/io/FileInputStream;
        //    41: dup            
        //    42: aload_0        
        //    43: getfield        com/flurry/android/impl/ads/FlurryAdModule.t:Ljava/io/File;
        //    46: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    49: astore          4
        //    51: invokestatic    com/flurry/sdk/ap.a:()Lcom/flurry/sdk/ap;
        //    54: aload           4
        //    56: invokevirtual   com/flurry/sdk/ap.a:(Ljava/io/InputStream;)V
        //    59: iconst_1       
        //    60: istore          7
        //    62: aconst_null    
        //    63: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    66: aload           4
        //    68: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //    71: iload           7
        //    73: ifne            13
        //    76: iconst_3       
        //    77: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //    80: ldc_w           "Deleting CachedAsset file."
        //    83: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //    86: aload_0        
        //    87: getfield        com/flurry/android/impl/ads/FlurryAdModule.t:Ljava/io/File;
        //    90: invokevirtual   java/io/File.delete:()Z
        //    93: pop            
        //    94: goto            13
        //    97: astore_1       
        //    98: aload_0        
        //    99: monitorexit    
        //   100: aload_1        
        //   101: athrow         
        //   102: astore          5
        //   104: aconst_null    
        //   105: astore          4
        //   107: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //   110: ldc_w           "Error loading CachedAsset data."
        //   113: aload           5
        //   115: invokestatic    com/flurry/sdk/eo.b:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
        //   118: aconst_null    
        //   119: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   122: aload           4
        //   124: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   127: iconst_0       
        //   128: istore          7
        //   130: goto            71
        //   133: aconst_null    
        //   134: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   137: aload           4
        //   139: invokestatic    com/flurry/sdk/fe.a:(Ljava/io/Closeable;)V
        //   142: aload           6
        //   144: athrow         
        //   145: iconst_3       
        //   146: getstatic       com/flurry/android/impl/ads/FlurryAdModule.q:Ljava/lang/String;
        //   149: ldc_w           "CachedAsset file doesn't exist."
        //   152: invokestatic    com/flurry/sdk/eo.a:(ILjava/lang/String;Ljava/lang/String;)V
        //   155: goto            13
        //   158: astore          6
        //   160: goto            133
        //   163: astore          5
        //   165: goto            107
        //   168: astore          6
        //   170: aconst_null    
        //   171: astore          4
        //   173: goto            133
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  2      9      97     102    Any
        //  16     34     97     102    Any
        //  38     51     102    107    Ljava/lang/Exception;
        //  38     51     168    176    Any
        //  51     59     163    168    Ljava/lang/Exception;
        //  51     59     158    163    Any
        //  62     71     97     102    Any
        //  76     94     97     102    Any
        //  107    118    158    163    Any
        //  118    127    97     102    Any
        //  133    145    97     102    Any
        //  145    155    97     102    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 84, Size: 84
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
    
    public e O() {
        return this.a(this.a((String)null), "unfilled", true, null);
    }
    
    public e P() {
        return this.z;
    }
    
    public AdUnit Q() {
        return this.A;
    }
    
    public e R() {
        return this.B;
    }
    
    public AdUnit S() {
        return this.C;
    }
    
    public ev$a T() {
        return ev.a().e();
    }
    
    public boolean U() {
        return this.G != null && this.G.length() > 0;
    }
    
    public CharSequence V() {
        return this.G;
    }
    
    public y W() {
        return this.f;
    }
    
    public List X() {
        return FlurryAdModule.p;
    }
    
    public boolean Y() {
        return this.n;
    }
    
    public String Z() {
        return this.u;
    }
    
    Intent a(final Intent intent) {
        if (intent == null) {
            return null;
        }
        return (Intent)intent.getParcelableExtra("targetIntent");
    }
    
    public ah a(final Context context, final AdUnit adUnit, final String s, final ViewGroup viewGroup, final FlurryAdSize flurryAdSize) {
        if (adUnit != null) {
            final List d = adUnit.d();
            if (d != null && !d.isEmpty()) {
                final AdFrame adFrame = d.get(0);
                final String string = adFrame.e().e().toString();
                final String string2 = adFrame.g().toString();
                final e e = this.j.get(string2);
                e a;
                if (e == null) {
                    a = this.a(string2);
                }
                else {
                    a = e;
                }
                this.a(new q("filled", Collections.emptyMap(), context, adUnit, a, 0), this.P, 1);
                if (string.equals("takeover")) {
                    eo.a(3, FlurryAdModule.q, "prepareAd: first frame of AdUnit is a takeover");
                    return new ai(this, adUnit, a);
                }
                eo.a(3, FlurryAdModule.q, "prepareAd: first frame of AdUnit is a banner");
                return new j(this, adUnit, a);
            }
        }
        return null;
    }
    
    c a(final String s, final boolean b, final Map map) {
        synchronized (this) {
            return new c(s, b, this.o(), map);
        }
    }
    
    public ci a(final String s, final ci ci) {
        synchronized (this.k) {
            return this.k.put(s, ci);
        }
    }
    
    public e a(final e e, final String str, final boolean b, final Map obj) {
        synchronized (this) {
            eo.a(3, FlurryAdModule.q, "changeAdState(" + e + ", " + str + ", " + b + ", " + obj + ")");
            synchronized (e) {
                if (!this.I.contains(e)) {
                    this.I.add(e);
                    eo.a(3, FlurryAdModule.q, "changeAdState added adLog = " + e);
                }
                e.a(this.a(str, b, obj));
                return e;
            }
        }
    }
    
    public e a(final String s) {
        synchronized (this) {
            e e = this.j.get(s);
            if (e == null) {
                e = new e(this.h(), s, this.o());
                if (this.I.size() < 32767) {
                    this.I.add(e);
                    this.j.put(e.b(), e);
                }
            }
            return e;
        }
    }
    
    public l a(final Context context, final ViewGroup viewGroup, final String s) {
        return this.Q.a(this, context, viewGroup, s);
    }
    
    public r a() {
        return this.P;
    }
    
    public List a(final AdFrame adFrame, final q q) {
        final ArrayList<a> list = new ArrayList<a>();
        final List f = adFrame.f();
        final String a = q.a;
        for (final Callback callback : f) {
            if (callback.b().toString().equals(a)) {
                for (final CharSequence charSequence : callback.c()) {
                    final HashMap hashMap = new HashMap();
                    String string = charSequence.toString();
                    final int index = string.indexOf(63);
                    if (index != -1) {
                        final String substring = string.substring(0, index);
                        String s = string.substring(index + 1);
                        if (s.contains("%{eventParams}")) {
                            s = s.replace("%{eventParams}", "");
                            hashMap.putAll(q.b);
                        }
                        hashMap.putAll(fe.f(s));
                        string = substring;
                    }
                    list.add(new a(string, hashMap, q));
                }
            }
        }
        return list;
    }
    
    public void a(final long n, final long n2) {
        synchronized (this) {
            if (!this.g.b()) {
                final Context b = do.a().b();
                eo.a(3, FlurryAdModule.q, "Precaching: initing from FlurryAdModule");
                this.g.a(n, n2);
                this.g.c();
                this.t = b.getFileStreamPath(this.v());
                this.b(new ff() {
                    @Override
                    public void a() {
                        FlurryAdModule.this.N();
                    }
                });
            }
        }
    }
    
    void a(final Activity activity) {
        int n = 1;
        if (n == this.H.size()) {
            final Activity activity2 = this.H.get(0);
            int adFrameIndex;
            AdUnit adUnit2;
            if (activity2 instanceof FlurryFullscreenTakeoverActivity) {
                final FlurryFullscreenTakeoverActivity flurryFullscreenTakeoverActivity = (FlurryFullscreenTakeoverActivity)activity2;
                final AdUnit adUnit = flurryFullscreenTakeoverActivity.getAdUnit();
                final g adUnityView = flurryFullscreenTakeoverActivity.getAdUnityView();
                if (adUnityView != null) {
                    adFrameIndex = adUnityView.getAdFrameIndex();
                    adUnit2 = adUnit;
                }
                else {
                    adFrameIndex = -1;
                    adUnit2 = adUnit;
                }
            }
            else {
                adFrameIndex = -1;
                adUnit2 = null;
            }
            if (adUnit2 != null && (adUnit2.e() != n || adFrameIndex > 0)) {
                if (activity != null && activity instanceof FlurryFullscreenTakeoverActivity) {
                    int n2;
                    if (((FlurryFullscreenTakeoverActivity)activity).getResult() != n$e.b) {
                        n2 = n;
                    }
                    else {
                        n2 = 0;
                    }
                    n = n2;
                }
                if (n != 0) {
                    activity2.finish();
                }
            }
        }
    }
    
    public void a(final Activity activity, final Bundle bundle) {
        if (activity != null) {
            this.H.add(activity);
            final Intent intent = activity.getIntent();
            final String b = this.b(intent);
            this.a((Context)activity, b);
            if (this.a(intent) != null) {
                final FlurryAdListener ac = this.ac();
                eo.a(3, FlurryAdModule.q, "Firing onApplicationExit, listener=" + ac);
                if (ac != null) {
                    do.a().a(new ff() {
                        @Override
                        public void a() {
                            ac.onApplicationExit(b);
                        }
                    });
                }
            }
        }
    }
    
    @Override
    public void a(final Activity activity, final du$a du$a) {
        this.Q.a(activity, du$a);
    }
    
    public void a(final Context context, final AdUnit adUnit, final ah ah) {
        if ("takeover".equals(adUnit.d().get(0).e().e().toString())) {
            this.K();
        }
        this.a(new q("requested", Collections.emptyMap(), context, ah.c(), this.j.get(adUnit.d().get(0).g().toString()), 0), this.P, 0);
    }
    
    public void a(final Context context, final String s) {
        ++this.i;
        if (1 == this.i) {
            final FlurryAdListener ac = this.ac();
            eo.a(3, FlurryAdModule.q, "Firing onAdOpened, listener=" + ac);
            if (ac != null) {
                do.a().a(new ff() {
                    @Override
                    public void a() {
                        ac.onAdOpened(s);
                    }
                });
            }
        }
    }
    
    public void a(final FlurryAdListener referent) {
        this.F = new WeakReference((T)referent);
    }
    
    public void a(final ICustomAdNetworkHandler h) {
        this.h = h;
    }
    
    public void a(final AdUnit a) {
        this.A = a;
    }
    
    @Override
    public void a(final dj dj) {
        this.C();
    }
    
    @Override
    public void a(final dj dj, final Context context) {
        this.N = new ac();
        if (this.O == null) {
            this.O = new s();
        }
        this.c = dj.m();
        this.d = dj.n();
        this.e = 0L;
        this.w = cg.a(context);
    }
    
    public void a(final e z) {
        this.z = z;
    }
    
    public void a(final ff ff) {
        do.a().a(ff);
    }
    
    @Override
    public void a(final q q, final ad ad, final int n) {
        int n2 = 1;
        eo.a(3, FlurryAdModule.q, "onEvent:event=" + q.a + ",params=" + q.b);
        this.a(q.a, n2);
        final List a = this.a(q.b(), q);
        if (a.isEmpty()) {
            for (final Map.Entry<String, V> entry : this.J.entrySet()) {
                if (entry.getKey().equals(q.a)) {
                    a.add(new a((String)entry.getValue(), q.b, q));
                }
            }
        }
        if (q.a.equals("sendUrlStatusResult")) {
            eo.a(3, FlurryAdModule.q, "sendUrlStatusResult event");
            a.add(new a("logEvent", q.b, q));
        }
        if (q.a.equals("adWillClose")) {
            final ci ci = this.k.get(q.b().g().toString());
            if (ci != null) {
                final List a2 = ci.a(co.q);
                if (a2 != null) {
                    for (final String str : a2) {
                        if (str != null) {
                            eo.a(3, FlurryAdModule.q, "Close Tracking URL: " + str);
                            for (final a a3 : a) {
                                if ("logEvent".equals(a3.a)) {
                                    this.P.b(a3, str);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (q.a.equals("renderFailed")) {
            boolean b = q.b.remove("binding_3rd_party") != null && n2;
            if (q.c.d().get(0).b() == 4) {
                b = (n2 != 0);
            }
            Label_0528: {
                if (q.b.remove("preRender") != null || (b ? 1 : 0) == n2) {
                    final Iterator<a> iterator4 = a.iterator();
                    while (true) {
                        while (iterator4.hasNext()) {
                            if ("nextAdUnit".equals(iterator4.next().a)) {
                                final boolean b2 = false;
                                if (!b2) {
                                    break Label_0528;
                                }
                                final FlurryAdListener ac = this.ac();
                                eo.a(3, FlurryAdModule.q, "Firing spaceDidFailToReceiveAd, listener=" + ac);
                                if (ac != null) {
                                    do.a().a(new ff() {
                                        @Override
                                        public void a() {
                                            ac.spaceDidFailToReceiveAd(q.c.b().toString());
                                        }
                                    });
                                }
                                break Label_0528;
                            }
                        }
                        final boolean b2 = n2 != 0;
                        continue;
                    }
                }
                final FlurryAdListener ac2 = this.ac();
                eo.a(3, FlurryAdModule.q, "Firing renderFailed, listener=" + ac2);
                if (ac2 != null) {
                    do.a().a(new ff() {
                        @Override
                        public void a() {
                            ac2.onRenderFailed(q.c.b().toString());
                        }
                    });
                }
            }
            final ci ci2 = this.k.get(q.b().g().toString());
            if (ci2 != null) {
                final List g = ci2.g();
                if (g != null) {
                    for (final String str2 : g) {
                        if (str2 != null) {
                            eo.a(3, FlurryAdModule.q, "Error Tracking URL: " + str2);
                            for (final a a4 : a) {
                                if ("logEvent".equals(a4.a)) {
                                    this.P.b(a4, str2);
                                }
                            }
                        }
                    }
                }
            }
            this.a((Activity)null);
            this.d(q.b().g().toString());
            ap.a().f(q.c);
            this.L();
            this.b(new ff() {
                @Override
                public void a() {
                    final String string = q.c.b().toString();
                    FlurryAdModule.this.g.b(string, FlurryAdModule.this.Q.e(string));
                }
            });
        }
        if (q.a.equals("clicked")) {
            final FlurryAdListener ac3 = this.ac();
            eo.a(3, FlurryAdModule.q, "Firing onAdClicked, listener=" + ac3);
            if (ac3 != null) {
                do.a().a(new ff() {
                    @Override
                    public void a() {
                        ac3.onAdClicked(q.c.b().toString());
                    }
                });
            }
            final ci ci3 = this.k.get(q.b().g().toString());
            if (ci3 != null) {
                final am c = this.c(q.b().g().toString());
                final String a5 = ci3.a(cp.b);
                if (a5 != null) {
                    c.g(n2 != 0);
                    this.P.a(q.a(), a5, n2 != 0, q.c, q.b().g().toString());
                }
                if (c.f()) {
                    return;
                }
                c.e(n2 != 0);
                final String a6 = ci3.a(cp.c);
                if (a6 != null) {
                    eo.a(3, FlurryAdModule.q, "ClickThrough Tracking URL: " + a6);
                    for (final a a7 : a) {
                        if ("logEvent".equals(a7.a)) {
                            this.P.b(a7, a6);
                        }
                    }
                }
            }
        }
        if (q.a.equals("videoStart")) {
            final ci ci4 = this.k.get(q.b().g().toString());
            if (ci4 != null) {
                final List h = ci4.h();
                if (h != null) {
                    for (final String str3 : h) {
                        if (str3 != null) {
                            eo.a(3, FlurryAdModule.q, "Impression Tracking URL: " + str3);
                            for (final a a8 : a) {
                                if ("logEvent".equals(a8.a)) {
                                    this.P.b(a8, str3);
                                }
                            }
                        }
                    }
                }
            }
            this.c(q.b().g().toString()).a(n2 != 0);
        }
        if (q.a.equals("videoFirstQuartile")) {
            final ci ci5 = this.k.get(q.b().g().toString());
            if (ci5 != null) {
                final List a9 = ci5.a(co.e);
                if (a9 != null) {
                    for (final String str4 : a9) {
                        if (str4 != null) {
                            eo.a(3, FlurryAdModule.q, "First Quartile Tracking URL: " + str4);
                            for (final a a10 : a) {
                                if ("logEvent".equals(a10.a)) {
                                    this.P.b(a10, str4);
                                }
                            }
                        }
                    }
                }
            }
            this.c(q.b().g().toString()).b(n2 != 0);
        }
        if (q.a.equals("videoMidpoint")) {
            final ci ci6 = this.k.get(q.b().g().toString());
            if (ci6 != null) {
                final List a11 = ci6.a(co.d);
                if (a11 != null) {
                    for (final String str5 : a11) {
                        if (str5 != null) {
                            eo.a(3, FlurryAdModule.q, "Midpoint Tracking URL: " + str5);
                            for (final a a12 : a) {
                                if ("logEvent".equals(a12.a)) {
                                    this.P.b(a12, str5);
                                }
                            }
                        }
                    }
                }
            }
            this.c(q.b().g().toString()).c(n2 != 0);
        }
        if (q.a.equals("videoThirdQuartile")) {
            final ci ci7 = this.k.get(q.b().g().toString());
            if (ci7 != null) {
                final List a13 = ci7.a(co.f);
                if (a13 != null) {
                    for (final String str6 : a13) {
                        if (str6 != null) {
                            eo.a(3, FlurryAdModule.q, "Third Quartile Tracking URL: " + str6);
                            for (final a a14 : a) {
                                if ("logEvent".equals(a14.a)) {
                                    this.P.b(a14, str6);
                                }
                            }
                        }
                    }
                }
            }
            this.c(q.b().g().toString()).d(n2 != 0);
        }
        if (q.a.equals("videoCompleted")) {
            if (q.c.n()) {
                eo.a(3, FlurryAdModule.q, "Ad unit is rewardable, onVideoCompleted listener will fire");
                final FlurryAdListener ac4 = this.ac();
                eo.a(3, FlurryAdModule.q, "Firing onVideoCompleted, listener=" + ac4);
                if (ac4 != null) {
                    do.a().a(new ff() {
                        @Override
                        public void a() {
                            ac4.onVideoCompleted(q.c.b().toString());
                        }
                    });
                }
            }
            else {
                eo.a(3, FlurryAdModule.q, "Ad unit is not rewardable, onVideoCompleted listener will not fire");
            }
            final ci ci8 = this.k.get(q.b().g().toString());
            if (ci8 != null) {
                final List a15 = ci8.a(co.g);
                if (a15 != null) {
                    for (final String str7 : a15) {
                        if (str7 != null) {
                            eo.a(3, FlurryAdModule.q, "Complete Tracking URL: " + str7);
                            for (final a a16 : a) {
                                if ("logEvent".equals(a16.a)) {
                                    this.P.b(a16, str7);
                                }
                            }
                        }
                    }
                }
            }
        }
        Label_2338: {
            if (q.a.equals("adWillClose") || q.a.equals("videoCompleted") || q.a.equals("userConfirmed")) {
                final Iterator<a> iterator18 = a.iterator();
                while (true) {
                    while (iterator18.hasNext()) {
                        if (this.K.contains(iterator18.next().a)) {
                            if (n2 == 0) {
                                a.add(0, new a("closeAd", Collections.emptyMap(), q));
                            }
                            if (n2 == 0 || q.a.equals("videoCompleted") || q.a.equals("userConfirmed")) {
                                this.d(q.b().g().toString());
                                this.L();
                                this.b(new ff() {
                                    @Override
                                    public void a() {
                                        final String string = q.c.b().toString();
                                        FlurryAdModule.this.g.b(string, FlurryAdModule.this.Q.e(string));
                                    }
                                });
                            }
                            break Label_2338;
                        }
                    }
                    n2 = 0;
                    continue;
                }
            }
        }
        final Iterator<a> iterator19 = a.iterator();
        a a17 = null;
        while (iterator19.hasNext()) {
            final a a18 = iterator19.next();
            a a19;
            if (a18.a.equals("logEvent")) {
                a18.b.put("__sendToServer", "true");
                a19 = a18;
            }
            else {
                a19 = a17;
            }
            if (a18.a.equals("loadAdComponents")) {
                for (final Map.Entry<String, V> entry2 : a18.c.b.entrySet()) {
                    a18.b.put(entry2.getKey().toString(), ((String)entry2.getValue()).toString());
                }
            }
            eo.c(FlurryAdModule.q, a18.toString());
            ad.a(a18, this, n + 1);
            a17 = a19;
        }
        if (a17 == null) {
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("__sendToServer", "false");
            final a a20 = new a("logEvent", hashMap, q);
            ad.a(a20, this, n + 1);
            eo.c(FlurryAdModule.q, a20.toString());
        }
    }
    
    public void a(final String s, int i) {
        synchronized (this.b) {
            final Integer n = this.b.get(s);
            final TreeMap b = this.b;
            if (n != null) {
                i += n;
            }
            b.put(s, i);
        }
    }
    
    public void a(final String s, final CharSequence g) {
        this.G = g;
        this.Q.d(s);
    }
    
    public void a(final String s, final List list) {
        synchronized (this) {
            this.b(new ff() {
                @Override
                public void a() {
                    FlurryAdModule.this.Q.a(s, list);
                }
            });
            this.b(new ff() {
                @Override
                public void a() {
                    FlurryAdModule.this.g.a(s, list);
                }
            });
        }
    }
    
    public void a(final String s, final List list, final int n) {
        this.e().a(s, list, n);
    }
    
    public void a(final Map map) {
        if (map != null && map.size() > 0) {
            for (final Map.Entry<Object, V> entry : map.entrySet()) {
                if (entry.getKey() != null && entry.getValue() != null) {
                    this.a.put(entry.getKey(), entry.getValue());
                }
                else {
                    eo.d(FlurryAdModule.q, "User cookie keys and values may not be null.");
                }
            }
        }
    }
    
    public void a(final boolean n) {
        this.n = n;
    }
    
    public String aa() {
        return this.v;
    }
    
    public String ab() {
        return this.w;
    }
    
    public FlurryAdListener ac() {
        return (FlurryAdListener)this.F.get();
    }
    
    public ci b(final String s) {
        synchronized (this.k) {
            return this.k.get(s);
        }
    }
    
    public k b() {
        return this.D;
    }
    
    String b(final Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra("adSpaceName");
    }
    
    public void b(final Activity activity) {
        if (activity == null) {
            return;
        }
        this.b((Context)activity, this.b(activity.getIntent()));
        this.H.remove(activity);
        this.a(activity);
    }
    
    public void b(final Context context, final String s) {
        --this.i;
        if (this.i == 0) {
            final FlurryAdListener ac = this.ac();
            eo.a(3, FlurryAdModule.q, "Firing onAdClosed, listener=" + ac);
            if (ac != null) {
                do.a().a(new ff() {
                    @Override
                    public void a() {
                        ac.onAdClosed(s);
                    }
                });
            }
        }
    }
    
    public void b(final AdUnit c) {
        this.C = c;
    }
    
    @Override
    public void b(final dj dj, final Context context) {
        this.f();
        dz.a().c();
        this.f.d();
        this.b(new ff() {
            @Override
            public void a() {
                FlurryAdModule.this.R.a();
            }
        });
        this.b(new ff() {
            @Override
            public void a() {
                FlurryAdModule.this.I();
            }
        });
    }
    
    public void b(final e b) {
        this.B = b;
    }
    
    public void b(final ff ff) {
        do.a().c(ff);
    }
    
    public void b(final Map o) {
        int n;
        if (o == this.o || (o != null && o.equals(this.o))) {
            n = 1;
        }
        else {
            n = 0;
        }
        this.o = o;
        if (n != 0) {
            this.Q.b();
        }
    }
    
    public ak c() {
        return this.E;
    }
    
    public am c(final String s) {
        synchronized (this.l) {
            am am = this.l.get(s);
            if (am == null) {
                am = new am();
                this.l.put(s, am);
            }
            return am;
        }
    }
    
    @Override
    public void c(final dj dj, final Context context) {
        dz.a().d();
        if (!dv.a().b()) {
            this.a(new ff() {
                @Override
                public void a() {
                    FlurryAdModule.this.Q.a(context);
                }
            });
        }
        if (dl.a().b() == 0) {
            this.Q.a();
            this.R.b();
            this.b(new ff() {
                @Override
                public void a() {
                    FlurryAdModule.this.J();
                }
            });
        }
        this.b(new ff() {
            @Override
            public void a() {
                FlurryAdModule.this.ae();
            }
        });
        this.b(new ff() {
            @Override
            public void a() {
                FlurryAdModule.this.G();
            }
        });
        this.b(new ff() {
            @Override
            public void a() {
                FlurryAdModule.this.M();
            }
        });
    }
    
    public u d() {
        return this.Q;
    }
    
    public void d(final String s) {
        synchronized (this.l) {
            this.l.remove(s);
        }
    }
    
    public t e() {
        return this.R;
    }
    
    public void e(final String x) {
        this.x = x;
    }
    
    public void f() {
        while (true) {
            synchronized (this) {
                if (this.M) {
                    return;
                }
                if (dl.a().c() == null) {
                    throw new RuntimeException("Flurry Session wasn't started");
                }
            }
            final Context b = do.a().b();
            dv.a().a(this);
            this.r = b.getFileStreamPath(this.t());
            this.s = b.getFileStreamPath(this.u());
            this.P.a();
            this.b(new ff() {
                @Override
                public void a() {
                    FlurryAdModule.this.af();
                }
            });
            this.b(new ff() {
                @Override
                public void a() {
                    FlurryAdModule.this.H();
                }
            });
            this.M = true;
        }
    }
    
    public void f(final String y) {
        this.y = y;
    }
    
    public void g(final String s) {
        this.L();
        this.b(new ff() {
            @Override
            public void a() {
                FlurryAdModule.this.g.b(s, FlurryAdModule.this.Q.e(s));
            }
        });
    }
    
    public boolean g() {
        return this.i != 0;
    }
    
    public long h() {
        return this.c;
    }
    
    public String j() {
        return dn.a().h();
    }
    
    public List k() {
        final ArrayList<String> list = new ArrayList<String>();
        final HashMap b = cx.a().b();
        if (b != null && !b.isEmpty()) {
            final Iterator<String> iterator = b.keySet().iterator();
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
        }
        return list;
    }
    
    public String l() {
        return dn.a().i();
    }
    
    public String m() {
        return dn.a().j();
    }
    
    public Location n() {
        final android.location.Location f = dz.a().f();
        float n;
        float n2;
        if (f != null) {
            n = (float)f.getLatitude();
            n2 = (float)f.getLongitude();
        }
        else {
            n2 = 0.0f;
            n = 0.0f;
        }
        return Location.b().a(n).b(n2).a();
    }
    
    public long o() {
        synchronized (this) {
            long n = SystemClock.elapsedRealtime() - this.d;
            if (n <= this.e) {
                n = 1L + this.e;
                this.e = n;
            }
            return this.e = n;
        }
    }
    
    public void p() {
        eo.a(3, FlurryAdModule.q, "========== PRINT COUNTERS ==========");
        synchronized (this.b) {
            for (final Map.Entry<String, V> entry : this.b.entrySet()) {
                eo.a(3, FlurryAdModule.q, entry.getKey() + " " + entry.getValue());
            }
        }
        // monitorexit(treeMap)
        eo.a(3, FlurryAdModule.q, "========== END PRINT COUNTERS ==========");
    }
    
    public ICustomAdNetworkHandler q() {
        return this.h;
    }
    
    public boolean r() {
        return this.o != null;
    }
    
    public Map s() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        for (final Map.Entry<String, V> entry : this.o.entrySet()) {
            String s = entry.getKey();
            String s2 = (String)entry.getValue();
            if (s == null) {
                s = "";
            }
            if (s2 == null) {
                s2 = "";
            }
            hashMap.put(s, s2);
        }
        return hashMap;
    }
    
    String t() {
        return ".flurryadlog." + Integer.toString(this.j().hashCode(), 16);
    }
    
    String u() {
        return ".flurryfreqcap." + Integer.toString(this.j().hashCode(), 16);
    }
    
    String v() {
        return ".flurrycachedasset." + Integer.toString(this.j().hashCode(), 16);
    }
    
    public String w() {
        if (this.x != null) {
            return this.x + "/v10/getAds.do";
        }
        if (FlurryAgent.getUseHttps()) {
            return "https://ads.flurry.com/v10/getAds.do";
        }
        return "http://ads.flurry.com/v10/getAds.do";
    }
    
    String x() {
        if (this.y != null) {
            return this.y;
        }
        if (FlurryAgent.getUseHttps()) {
            return "https://adlog.flurry.com";
        }
        return "http://adlog.flurry.com";
    }
    
    public void y() {
        this.a.clear();
    }
    
    public Map z() {
        return this.a;
    }
}

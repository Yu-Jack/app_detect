// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.support.v4.app.Fragment;
import java.util.HashMap;
import java.util.UUID;
import java.util.Collections;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v4.content.e;
import org.json.JSONException;
import org.json.JSONObject;
import com.facebook.b.ae;
import android.util.Log;
import java.util.Iterator;
import com.facebook.c.h;
import java.util.Map;
import com.facebook.c.c;
import com.facebook.c.b;
import android.os.Looper;
import java.util.ArrayList;
import com.facebook.b.al;
import com.facebook.b.aj;
import java.util.HashSet;
import android.os.Handler;
import java.util.List;
import android.os.Bundle;
import java.util.Date;
import java.util.Set;
import android.content.Context;
import java.io.Serializable;

public class bc implements Serializable
{
    public static final String a;
    private static final Object b;
    private static bc c;
    private static volatile Context d;
    private static final Set e;
    private static /* synthetic */ int[] t;
    private String f;
    private bo g;
    private a h;
    private Date i;
    private bd j;
    private m k;
    private volatile Bundle l;
    private final List m;
    private Handler n;
    private be o;
    private final Object p;
    private bs q;
    private volatile bk r;
    private d s;
    
    static {
        a = bc.class.getCanonicalName();
        b = new Object();
        e = new HashSet() {
            {
                this.add("ads_management");
                this.add("create_event");
                this.add("rsvp_event");
            }
        };
    }
    
    bc(final Context context, final String s, final bs bs) {
        this(context, s, bs, (byte)0);
    }
    
    private bc(Context d, String a, bs q, final byte b) {
        this.i = new Date(0L);
        this.p = new Object();
        if (d != null && a == null) {
            a = aj.a(d);
        }
        al.a((Object)a, "applicationId");
        if (d != null && bc.d == null) {
            final Context applicationContext = d.getApplicationContext();
            if (applicationContext != null) {
                d = applicationContext;
            }
            bc.d = d;
        }
        if (q == null) {
            q = new br(bc.d);
        }
        this.f = a;
        this.q = q;
        this.g = bo.a;
        this.j = null;
        this.m = new ArrayList();
        this.n = new Handler(Looper.getMainLooper());
        final Bundle a2 = q.a();
        int n;
        if (a2 == null) {
            n = 0;
        }
        else {
            final String string = a2.getString("com.facebook.TokenCachingStrategy.Token");
            if (string == null || string.length() == 0) {
                n = 0;
            }
            else if (a2.getLong("com.facebook.TokenCachingStrategy.ExpirationDate", 0L) == 0L) {
                n = 0;
            }
            else {
                n = 1;
            }
        }
        if (n != 0) {
            final Date a3 = bs.a(a2, "com.facebook.TokenCachingStrategy.ExpirationDate");
            final Date when = new Date();
            if (a3 != null && !a3.before(when)) {
                this.h = com.facebook.a.a(a2);
                this.g = bo.b;
                return;
            }
            q.b();
        }
        this.h = com.facebook.a.f();
    }
    
    public static bc a(final Context context) {
        final bc a = new bf(context).a();
        if (bo.b.equals(a.b())) {
            a(a);
            a.a((bg)null);
            return a;
        }
        return null;
    }
    
    static bh a(final bb bb) {
        if (bb.a() != null) {
            return null;
        }
        final b b = (b)bb.a(b.class);
        if (b == null) {
            return null;
        }
        final h a = b.a();
        if (a == null || a.size() == 0) {
            return null;
        }
        final ArrayList list = new ArrayList<String>(a.size());
        final ArrayList list2 = new ArrayList<String>(a.size());
        final c c = a.get(0);
        if (c.e() != null) {
            for (final c c2 : a) {
                final String s = (String)c2.e();
                if (!s.equals("installed")) {
                    final String s2 = (String)c2.e();
                    if (s2.equals("granted")) {
                        list.add(s);
                    }
                    else {
                        if (!s2.equals("declined")) {
                            continue;
                        }
                        list2.add(s);
                    }
                }
            }
        }
        else {
            for (final Map.Entry<String, V> entry : c.c().entrySet()) {
                if (!entry.getKey().equals("installed") && (int)entry.getValue() == 1) {
                    list.add((String)entry.getKey());
                }
            }
        }
        return new bh(list, list2);
    }
    
    private void a(final a a) {
        if (a != null && this.q != null) {
            this.q.a(a.g());
        }
    }
    
    public static final void a(final bc c) {
        synchronized (bc.b) {
            if (c != bc.c) {
                final bc c2 = bc.c;
                if (c2 != null) {
                    c2.m();
                }
                bc.c = c;
                if (c2 != null) {
                    a("com.facebook.sdk.ACTIVE_SESSION_UNSET");
                }
                if (c != null) {
                    a("com.facebook.sdk.ACTIVE_SESSION_SET");
                    if (c.a()) {
                        a("com.facebook.sdk.ACTIVE_SESSION_OPENED");
                    }
                }
            }
        }
    }
    
    private void a(final bg p0, final ae p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_1        
        //     1: ifnull          14
        //     4: aload_1        
        //     5: invokevirtual   com/facebook/bd.d:()Ljava/util/List;
        //     8: invokestatic    com/facebook/b/aj.a:(Ljava/util/Collection;)Z
        //    11: ifeq            35
        //    14: getstatic       com/facebook/b/ae.b:Lcom/facebook/b/ae;
        //    17: aload_2        
        //    18: invokevirtual   com/facebook/b/ae.equals:(Ljava/lang/Object;)Z
        //    21: ifeq            56
        //    24: new             Lcom/facebook/ab;
        //    27: dup            
        //    28: ldc_w           "Cannot request publish or manage authorization with no permissions."
        //    31: invokespecial   com/facebook/ab.<init>:(Ljava/lang/String;)V
        //    34: athrow         
        //    35: aload_1        
        //    36: invokevirtual   com/facebook/bd.d:()Ljava/util/List;
        //    39: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //    44: astore          33
        //    46: aload           33
        //    48: invokeinterface java/util/Iterator.hasNext:()Z
        //    53: ifne            136
        //    56: aload_1        
        //    57: ifnull          270
        //    60: aload_1        
        //    61: invokestatic    com/facebook/bd.c:(Lcom/facebook/bd;)Z
        //    64: ifne            270
        //    67: new             Landroid/content/Intent;
        //    70: dup            
        //    71: invokespecial   android/content/Intent.<init>:()V
        //    74: astore          30
        //    76: aload           30
        //    78: getstatic       com/facebook/bc.d:Landroid/content/Context;
        //    81: ldc_w           Lcom/facebook/LoginActivity;.class
        //    84: invokevirtual   android/content/Intent.setClass:(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
        //    87: pop            
        //    88: aload           30
        //    90: invokestatic    com/facebook/bc.a:(Landroid/content/Intent;)Z
        //    93: ifne            270
        //    96: iconst_2       
        //    97: anewarray       Ljava/lang/Object;
        //   100: astore          32
        //   102: aload           32
        //   104: iconst_0       
        //   105: aload_1        
        //   106: invokevirtual   com/facebook/bd.b:()Lcom/facebook/bn;
        //   109: aastore        
        //   110: aload           32
        //   112: iconst_1       
        //   113: ldc_w           Lcom/facebook/LoginActivity;.class
        //   116: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //   119: aastore        
        //   120: new             Lcom/facebook/ab;
        //   123: dup            
        //   124: ldc_w           "Cannot use SessionLoginBehavior %s when %s is not declared as an activity in AndroidManifest.xml"
        //   127: aload           32
        //   129: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   132: invokespecial   com/facebook/ab.<init>:(Ljava/lang/String;)V
        //   135: athrow         
        //   136: aload           33
        //   138: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   143: checkcast       Ljava/lang/String;
        //   146: astore          34
        //   148: aload           34
        //   150: ifnull          229
        //   153: aload           34
        //   155: ldc_w           "publish"
        //   158: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   161: ifne            188
        //   164: aload           34
        //   166: ldc_w           "manage"
        //   169: invokevirtual   java/lang/String.startsWith:(Ljava/lang/String;)Z
        //   172: ifne            188
        //   175: getstatic       com/facebook/bc.e:Ljava/util/Set;
        //   178: aload           34
        //   180: invokeinterface java/util/Set.contains:(Ljava/lang/Object;)Z
        //   185: ifeq            229
        //   188: iconst_1       
        //   189: istore          35
        //   191: iload           35
        //   193: ifeq            235
        //   196: getstatic       com/facebook/b/ae.a:Lcom/facebook/b/ae;
        //   199: aload_2        
        //   200: invokevirtual   com/facebook/b/ae.equals:(Ljava/lang/Object;)Z
        //   203: ifeq            46
        //   206: new             Lcom/facebook/ab;
        //   209: dup            
        //   210: ldc_w           "Cannot pass a publish or manage permission (%s) to a request for read authorization"
        //   213: iconst_1       
        //   214: anewarray       Ljava/lang/Object;
        //   217: dup            
        //   218: iconst_0       
        //   219: aload           34
        //   221: aastore        
        //   222: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   225: invokespecial   com/facebook/ab.<init>:(Ljava/lang/String;)V
        //   228: athrow         
        //   229: iconst_0       
        //   230: istore          35
        //   232: goto            191
        //   235: getstatic       com/facebook/b/ae.b:Lcom/facebook/b/ae;
        //   238: aload_2        
        //   239: invokevirtual   com/facebook/b/ae.equals:(Ljava/lang/Object;)Z
        //   242: ifeq            46
        //   245: getstatic       com/facebook/bc.a:Ljava/lang/String;
        //   248: ldc_w           "Should not pass a read permission (%s) to a request for publish or manage authorization"
        //   251: iconst_1       
        //   252: anewarray       Ljava/lang/Object;
        //   255: dup            
        //   256: iconst_0       
        //   257: aload           34
        //   259: aastore        
        //   260: invokestatic    java/lang/String.format:(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   263: invokestatic    android/util/Log.w:(Ljava/lang/String;Ljava/lang/String;)I
        //   266: pop            
        //   267: goto            46
        //   270: aload_0        
        //   271: getfield        com/facebook/bc.p:Ljava/lang/Object;
        //   274: astore_3       
        //   275: aload_3        
        //   276: monitorenter   
        //   277: aload_0        
        //   278: getfield        com/facebook/bc.j:Lcom/facebook/bd;
        //   281: ifnull          309
        //   284: aload_0        
        //   285: aload_0        
        //   286: getfield        com/facebook/bc.g:Lcom/facebook/bo;
        //   289: aload_0        
        //   290: getfield        com/facebook/bc.g:Lcom/facebook/bo;
        //   293: new             Ljava/lang/UnsupportedOperationException;
        //   296: dup            
        //   297: ldc_w           "Session: an attempt was made to open a session that has a pending request."
        //   300: invokespecial   java/lang/UnsupportedOperationException.<init>:(Ljava/lang/String;)V
        //   303: invokespecial   com/facebook/bc.a:(Lcom/facebook/bo;Lcom/facebook/bo;Ljava/lang/Exception;)V
        //   306: aload_3        
        //   307: monitorexit    
        //   308: return         
        //   309: aload_0        
        //   310: getfield        com/facebook/bc.g:Lcom/facebook/bo;
        //   313: astore          5
        //   315: invokestatic    com/facebook/bc.o:()[I
        //   318: aload_0        
        //   319: getfield        com/facebook/bc.g:Lcom/facebook/bo;
        //   322: invokevirtual   com/facebook/bo.ordinal:()I
        //   325: iaload         
        //   326: tableswitch {
        //                2: 366
        //                3: 885
        //          default: 348
        //        }
        //   348: new             Ljava/lang/UnsupportedOperationException;
        //   351: dup            
        //   352: ldc_w           "Session: an attempt was made to open an already opened session."
        //   355: invokespecial   java/lang/UnsupportedOperationException.<init>:(Ljava/lang/String;)V
        //   358: athrow         
        //   359: astore          4
        //   361: aload_3        
        //   362: monitorexit    
        //   363: aload           4
        //   365: athrow         
        //   366: getstatic       com/facebook/bo.c:Lcom/facebook/bo;
        //   369: astore          6
        //   371: aload_0        
        //   372: aload           6
        //   374: putfield        com/facebook/bc.g:Lcom/facebook/bo;
        //   377: aload_1        
        //   378: ifnonnull       392
        //   381: new             Ljava/lang/IllegalArgumentException;
        //   384: dup            
        //   385: ldc_w           "openRequest cannot be null when opening a new Session"
        //   388: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   391: athrow         
        //   392: aload_0        
        //   393: aload_1        
        //   394: putfield        com/facebook/bc.j:Lcom/facebook/bd;
        //   397: aload_1        
        //   398: ifnull          409
        //   401: aload_0        
        //   402: aload_1        
        //   403: invokevirtual   com/facebook/bg.a:()Lcom/facebook/bj;
        //   406: invokevirtual   com/facebook/bc.a:(Lcom/facebook/bj;)V
        //   409: aload_0        
        //   410: aload           5
        //   412: aload           6
        //   414: aconst_null    
        //   415: invokespecial   com/facebook/bc.a:(Lcom/facebook/bo;Lcom/facebook/bo;Ljava/lang/Exception;)V
        //   418: aload_3        
        //   419: monitorexit    
        //   420: aload           6
        //   422: getstatic       com/facebook/bo.c:Lcom/facebook/bo;
        //   425: if_acmpne       990
        //   428: aload_1        
        //   429: aload_0        
        //   430: getfield        com/facebook/bc.f:Ljava/lang/String;
        //   433: invokevirtual   com/facebook/bd.a:(Ljava/lang/String;)V
        //   436: aload_0        
        //   437: monitorenter   
        //   438: aload_0        
        //   439: getfield        com/facebook/bc.o:Lcom/facebook/be;
        //   442: ifnonnull       984
        //   445: invokestatic    com/facebook/bq.d:()Z
        //   448: ifeq            984
        //   451: aload_0        
        //   452: getfield        com/facebook/bc.f:Ljava/lang/String;
        //   455: astore          29
        //   457: aload           29
        //   459: ifnull          984
        //   462: new             Lcom/facebook/be;
        //   465: dup            
        //   466: aload_0        
        //   467: aload           29
        //   469: getstatic       com/facebook/bc.d:Landroid/content/Context;
        //   472: invokespecial   com/facebook/be.<init>:(Lcom/facebook/bc;Ljava/lang/String;Landroid/content/Context;)V
        //   475: astore          8
        //   477: aload_0        
        //   478: aload           8
        //   480: putfield        com/facebook/bc.o:Lcom/facebook/be;
        //   483: aload_0        
        //   484: monitorexit    
        //   485: aload           8
        //   487: ifnull          500
        //   490: aload           8
        //   492: iconst_0       
        //   493: anewarray       Ljava/lang/Void;
        //   496: invokevirtual   com/facebook/be.execute:([Ljava/lang/Object;)Landroid/os/AsyncTask;
        //   499: pop            
        //   500: aload_0        
        //   501: getfield        com/facebook/bc.j:Lcom/facebook/bd;
        //   504: invokevirtual   com/facebook/bd.f:()Ljava/lang/String;
        //   507: invokestatic    com/facebook/m.a:(Ljava/lang/String;)Landroid/os/Bundle;
        //   510: astore          9
        //   512: aload           9
        //   514: ldc_w           "1_timestamp_ms"
        //   517: invokestatic    java/lang/System.currentTimeMillis:()J
        //   520: invokevirtual   android/os/Bundle.putLong:(Ljava/lang/String;J)V
        //   523: new             Lorg/json/JSONObject;
        //   526: dup            
        //   527: invokespecial   org/json/JSONObject.<init>:()V
        //   530: astore          10
        //   532: aload           10
        //   534: ldc_w           "login_behavior"
        //   537: aload_0        
        //   538: getfield        com/facebook/bc.j:Lcom/facebook/bd;
        //   541: invokestatic    com/facebook/bd.d:(Lcom/facebook/bd;)Lcom/facebook/bn;
        //   544: invokevirtual   com/facebook/bn.toString:()Ljava/lang/String;
        //   547: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   550: pop            
        //   551: aload           10
        //   553: ldc_w           "request_code"
        //   556: aload_0        
        //   557: getfield        com/facebook/bc.j:Lcom/facebook/bd;
        //   560: invokestatic    com/facebook/bd.e:(Lcom/facebook/bd;)I
        //   563: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;I)Lorg/json/JSONObject;
        //   566: pop            
        //   567: aload           10
        //   569: ldc_w           "is_legacy"
        //   572: aload_0        
        //   573: getfield        com/facebook/bc.j:Lcom/facebook/bd;
        //   576: invokestatic    com/facebook/bd.c:(Lcom/facebook/bd;)Z
        //   579: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Z)Lorg/json/JSONObject;
        //   582: pop            
        //   583: aload           10
        //   585: ldc_w           "permissions"
        //   588: ldc_w           ","
        //   591: aload_0        
        //   592: getfield        com/facebook/bc.j:Lcom/facebook/bd;
        //   595: invokestatic    com/facebook/bd.f:(Lcom/facebook/bd;)Ljava/util/List;
        //   598: invokestatic    android/text/TextUtils.join:(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
        //   601: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   604: pop            
        //   605: aload           10
        //   607: ldc_w           "default_audience"
        //   610: aload_0        
        //   611: getfield        com/facebook/bc.j:Lcom/facebook/bd;
        //   614: invokestatic    com/facebook/bd.g:(Lcom/facebook/bd;)Lcom/facebook/bm;
        //   617: invokevirtual   com/facebook/bm.toString:()Ljava/lang/String;
        //   620: invokevirtual   org/json/JSONObject.put:(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
        //   623: pop            
        //   624: aload           9
        //   626: ldc_w           "6_extras"
        //   629: aload           10
        //   631: invokevirtual   org/json/JSONObject.toString:()Ljava/lang/String;
        //   634: invokevirtual   android/os/Bundle.putString:(Ljava/lang/String;Ljava/lang/String;)V
        //   637: aload_0        
        //   638: invokespecial   com/facebook/bc.n:()Lcom/facebook/d;
        //   641: ldc_w           "fb_mobile_login_start"
        //   644: aload           9
        //   646: invokevirtual   com/facebook/d.b:(Ljava/lang/String;Landroid/os/Bundle;)V
        //   649: aload_1        
        //   650: invokestatic    com/facebook/bc.a:(Lcom/facebook/bd;)Z
        //   653: istore          12
        //   655: aload_0        
        //   656: getfield        com/facebook/bc.j:Lcom/facebook/bd;
        //   659: invokestatic    com/facebook/bd.b:(Lcom/facebook/bd;)Ljava/util/Map;
        //   662: astore          13
        //   664: iload           12
        //   666: ifeq            960
        //   669: ldc_w           "1"
        //   672: astore          14
        //   674: aload           13
        //   676: ldc_w           "try_login_activity"
        //   679: aload           14
        //   681: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   686: pop            
        //   687: iload           12
        //   689: ifne            977
        //   692: aload_1        
        //   693: invokestatic    com/facebook/bd.c:(Lcom/facebook/bd;)Z
        //   696: ifeq            977
        //   699: aload_0        
        //   700: getfield        com/facebook/bc.j:Lcom/facebook/bd;
        //   703: invokestatic    com/facebook/bd.b:(Lcom/facebook/bd;)Ljava/util/Map;
        //   706: ldc_w           "try_legacy"
        //   709: ldc_w           "1"
        //   712: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   717: pop            
        //   718: aload_0        
        //   719: new             Lcom/facebook/m;
        //   722: dup            
        //   723: invokespecial   com/facebook/m.<init>:()V
        //   726: putfield        com/facebook/bc.k:Lcom/facebook/m;
        //   729: aload_0        
        //   730: getfield        com/facebook/bc.k:Lcom/facebook/m;
        //   733: new             Lcom/facebook/bc$2;
        //   736: dup            
        //   737: aload_0        
        //   738: invokespecial   com/facebook/bc$2.<init>:(Lcom/facebook/bc;)V
        //   741: putfield        com/facebook/m.e:Lcom/facebook/u;
        //   744: aload_0        
        //   745: getfield        com/facebook/bc.k:Lcom/facebook/m;
        //   748: astore          22
        //   750: aload           22
        //   752: getstatic       com/facebook/bc.d:Landroid/content/Context;
        //   755: putfield        com/facebook/m.c:Landroid/content/Context;
        //   758: aload           22
        //   760: aconst_null    
        //   761: putfield        com/facebook/m.d:Lcom/facebook/x;
        //   764: aload_0        
        //   765: getfield        com/facebook/bc.k:Lcom/facebook/m;
        //   768: aload_1        
        //   769: invokevirtual   com/facebook/bd.g:()Lcom/facebook/p;
        //   772: invokevirtual   com/facebook/m.a:(Lcom/facebook/p;)V
        //   775: iconst_1       
        //   776: istore          16
        //   778: iload           16
        //   780: ifne            990
        //   783: aload_0        
        //   784: getfield        com/facebook/bc.p:Ljava/lang/Object;
        //   787: astore          17
        //   789: aload           17
        //   791: monitorenter   
        //   792: aload_0        
        //   793: getfield        com/facebook/bc.g:Lcom/facebook/bo;
        //   796: astore          19
        //   798: invokestatic    com/facebook/bc.o:()[I
        //   801: aload_0        
        //   802: getfield        com/facebook/bc.g:Lcom/facebook/bo;
        //   805: invokevirtual   com/facebook/bo.ordinal:()I
        //   808: iaload         
        //   809: tableswitch {
        //               12: 968
        //               13: 968
        //          default: 832
        //        }
        //   832: aload_0        
        //   833: getstatic       com/facebook/bo.f:Lcom/facebook/bo;
        //   836: putfield        com/facebook/bc.g:Lcom/facebook/bo;
        //   839: new             Lcom/facebook/ab;
        //   842: dup            
        //   843: ldc_w           "Log in attempt failed: LoginActivity could not be started, and not legacy request"
        //   846: invokespecial   com/facebook/ab.<init>:(Ljava/lang/String;)V
        //   849: astore          20
        //   851: aload_0        
        //   852: getstatic       com/facebook/w.c:Lcom/facebook/w;
        //   855: aconst_null    
        //   856: aload           20
        //   858: invokespecial   com/facebook/bc.a:(Lcom/facebook/w;Ljava/util/Map;Ljava/lang/Exception;)V
        //   861: aload_0        
        //   862: aload           19
        //   864: aload_0        
        //   865: getfield        com/facebook/bc.g:Lcom/facebook/bo;
        //   868: aload           20
        //   870: invokespecial   com/facebook/bc.a:(Lcom/facebook/bo;Lcom/facebook/bo;Ljava/lang/Exception;)V
        //   873: aload           17
        //   875: monitorexit    
        //   876: return         
        //   877: astore          18
        //   879: aload           17
        //   881: monitorexit    
        //   882: aload           18
        //   884: athrow         
        //   885: aload_1        
        //   886: ifnull          918
        //   889: aload_1        
        //   890: invokevirtual   com/facebook/bg.d:()Ljava/util/List;
        //   893: invokestatic    com/facebook/b/aj.a:(Ljava/util/Collection;)Z
        //   896: ifne            918
        //   899: aload_1        
        //   900: invokevirtual   com/facebook/bg.d:()Ljava/util/List;
        //   903: aload_0        
        //   904: invokespecial   com/facebook/bc.l:()Ljava/util/List;
        //   907: invokestatic    com/facebook/b/aj.a:(Ljava/util/Collection;Ljava/util/Collection;)Z
        //   910: ifne            918
        //   913: aload_0        
        //   914: aload_1        
        //   915: putfield        com/facebook/bc.j:Lcom/facebook/bd;
        //   918: aload_0        
        //   919: getfield        com/facebook/bc.j:Lcom/facebook/bd;
        //   922: ifnonnull       939
        //   925: getstatic       com/facebook/bo.d:Lcom/facebook/bo;
        //   928: astore          6
        //   930: aload_0        
        //   931: aload           6
        //   933: putfield        com/facebook/bc.g:Lcom/facebook/bo;
        //   936: goto            397
        //   939: getstatic       com/facebook/bo.c:Lcom/facebook/bo;
        //   942: astore          6
        //   944: aload_0        
        //   945: aload           6
        //   947: putfield        com/facebook/bc.g:Lcom/facebook/bo;
        //   950: goto            397
        //   953: astore          7
        //   955: aload_0        
        //   956: monitorexit    
        //   957: aload           7
        //   959: athrow         
        //   960: ldc_w           "0"
        //   963: astore          14
        //   965: goto            674
        //   968: aload           17
        //   970: monitorexit    
        //   971: return         
        //   972: astore          11
        //   974: goto            637
        //   977: iload           12
        //   979: istore          16
        //   981: goto            778
        //   984: aconst_null    
        //   985: astore          8
        //   987: goto            483
        //   990: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                    
        //  -----  -----  -----  -----  ------------------------
        //  277    308    359    366    Any
        //  309    348    359    366    Any
        //  348    359    359    366    Any
        //  366    377    359    366    Any
        //  381    392    359    366    Any
        //  392    397    359    366    Any
        //  401    409    359    366    Any
        //  409    420    359    366    Any
        //  438    457    953    960    Any
        //  462    483    953    960    Any
        //  483    485    953    960    Any
        //  523    637    972    977    Lorg/json/JSONException;
        //  792    832    877    885    Any
        //  832    876    877    885    Any
        //  889    918    359    366    Any
        //  918    936    359    366    Any
        //  939    950    359    366    Any
        //  968    971    877    885    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0637:
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
    
    private void a(final bo bo, final bo bo2, final Exception ex) {
        if (bo != bo2 || bo == bo.e || ex != null) {
            if (bo2.b()) {
                this.h = com.facebook.a.f();
            }
            b(this.n, new Runnable() {
                @Override
                public final void run() {
                    synchronized (bc.this.m) {
                        final Iterator<bj> iterator = bc.this.m.iterator();
                        while (iterator.hasNext()) {
                            b(bc.this.n, new Runnable() {
                                private final /* synthetic */ bj b = iterator.next();
                                
                                @Override
                                public final void run() {
                                    this.b.a(bc.this, bo2, ex);
                                }
                            });
                        }
                    }
                }
            });
            if (this == bc.c && bo.a() != bo2.a()) {
                if (bo2.a()) {
                    a("com.facebook.sdk.ACTIVE_SESSION_OPENED");
                    return;
                }
                a("com.facebook.sdk.ACTIVE_SESSION_CLOSED");
            }
        }
    }
    
    private void a(final w w, final Map map, final Exception ex) {
        Bundle a2 = null;
        Label_0040: {
            if (this.j != null) {
                final Bundle a = com.facebook.m.a(this.j.f());
                if (w != null) {
                    a.putString("2_result", w.a());
                }
                if (ex != null && ex.getMessage() != null) {
                    a.putString("5_error_message", ex.getMessage());
                }
                final boolean empty = this.j.k.isEmpty();
                JSONObject jsonObject = null;
                if (!empty) {
                    jsonObject = new JSONObject(this.j.k);
                }
                while (true) {
                Label_0274:
                    while (true) {
                        if (map == null) {
                            break Label_0202;
                        }
                        if (jsonObject != null) {
                            break Label_0274;
                        }
                        final JSONObject jsonObject2 = new JSONObject();
                        try {
                            for (final Map.Entry<String, V> entry : map.entrySet()) {
                                jsonObject2.put((String)entry.getKey(), (Object)entry.getValue());
                            }
                            jsonObject = jsonObject2;
                            if (jsonObject != null) {
                                a.putString("6_extras", jsonObject.toString());
                            }
                            a2 = a;
                            break Label_0040;
                        }
                        catch (JSONException ex2) {
                            jsonObject = jsonObject2;
                            continue;
                        }
                        break;
                    }
                    final JSONObject jsonObject2 = jsonObject;
                    continue;
                }
            }
            a2 = com.facebook.m.a("");
            a2.putString("2_result", w.c.a());
            a2.putString("5_error_message", "Unexpected call to logAuthorizationComplete with null pendingAuthorizationRequest.");
        }
        a2.putLong("1_timestamp_ms", System.currentTimeMillis());
        this.n().b("fb_mobile_login_complete", a2);
    }
    
    private static void a(final String s) {
        android.support.v4.content.e.a(bc.d).a(new Intent(s));
    }
    
    private static boolean a(final Intent intent) {
        return bc.d.getPackageManager().resolveActivity(intent, 0) != null;
    }
    
    private static boolean a(final bd bd) {
        final Intent intent = new Intent();
        intent.setClass(bc.d, (Class)LoginActivity.class);
        intent.setAction(bd.b().toString());
        intent.putExtras(LoginActivity.a(bd.g()));
        if (!a(intent)) {
            return false;
        }
        try {
            bd.e().a(intent, bd.c());
            return true;
        }
        catch (ActivityNotFoundException ex) {
            return false;
        }
    }
    
    private static boolean a(final Object o, final Object obj) {
        if (o == null) {
            return obj == null;
        }
        return o.equals(obj);
    }
    
    private static void b(final Handler handler, final Runnable runnable) {
        if (handler != null) {
            handler.post(runnable);
            return;
        }
        bq.b().execute(runnable);
    }
    
    public static final bc f() {
        synchronized (bc.b) {
            return bc.c;
        }
    }
    
    static Context g() {
        return bc.d;
    }
    
    private Date k() {
        synchronized (this.p) {
            Date b;
            if (this.h == null) {
                b = null;
            }
            else {
                b = this.h.b();
            }
            return b;
        }
    }
    
    private List l() {
        synchronized (this.p) {
            List c;
            if (this.h == null) {
                c = null;
            }
            else {
                c = this.h.c();
            }
            return c;
        }
    }
    
    private void m() {
        while (true) {
            final bo g;
            Label_0093: {
                synchronized (this.p) {
                    g = this.g;
                    switch (o()[this.g.ordinal()]) {
                        case 1:
                        case 3: {
                            this.a(g, this.g = bo.f, new ab("Log in attempt aborted."));
                            break;
                        }
                        case 2:
                        case 4:
                        case 5: {
                            break Label_0093;
                        }
                    }
                    return;
                }
            }
            this.a(g, this.g = bo.g, null);
        }
    }
    
    private d n() {
        synchronized (this.p) {
            if (this.s == null) {
                this.s = com.facebook.d.a(bc.d, this.f);
            }
            return this.s;
        }
    }
    
    private static /* synthetic */ int[] o() {
        final int[] t = bc.t;
        if (t != null) {
            return t;
        }
        final int[] t2 = new int[bo.values().length];
        while (true) {
            try {
                t2[bo.g.ordinal()] = 7;
                try {
                    t2[bo.f.ordinal()] = 6;
                    try {
                        t2[bo.a.ordinal()] = 1;
                        try {
                            t2[bo.b.ordinal()] = 2;
                            try {
                                t2[bo.d.ordinal()] = 4;
                                try {
                                    t2[bo.e.ordinal()] = 5;
                                    try {
                                        t2[bo.c.ordinal()] = 3;
                                        return bc.t = t2;
                                    }
                                    catch (NoSuchFieldError noSuchFieldError) {}
                                }
                                catch (NoSuchFieldError noSuchFieldError2) {}
                            }
                            catch (NoSuchFieldError noSuchFieldError3) {}
                        }
                        catch (NoSuchFieldError noSuchFieldError4) {}
                    }
                    catch (NoSuchFieldError noSuchFieldError5) {}
                }
                catch (NoSuchFieldError noSuchFieldError6) {}
            }
            catch (NoSuchFieldError noSuchFieldError7) {
                continue;
            }
            break;
        }
    }
    
    final void a(final Bundle bundle) {
        synchronized (this.p) {
            final bo g = this.g;
            switch (o()[this.g.ordinal()]) {
                default: {
                    Log.d(bc.a, "refreshToken ignored in state " + this.g);
                }
                case 4: {
                    this.a(g, this.g = bo.e, null);
                }
                case 5: {
                    this.h = com.facebook.a.a(this.h, bundle);
                    if (this.q != null) {
                        this.q.a(this.h.g());
                    }
                }
            }
        }
    }
    
    public final void a(final bg bg) {
        this.a(bg, ae.a);
    }
    
    public final void a(final bj bj) {
        final List m = this.m;
        // monitorenter(m)
        if (bj == null) {
            return;
        }
        try {
            if (!this.m.contains(bj)) {
                this.m.add(bj);
            }
        }
        finally {
        }
        // monitorexit(m)
    }
    
    final void a(final Date i) {
        this.i = i;
    }
    
    public final boolean a() {
        synchronized (this.p) {
            return this.g.a();
        }
    }
    
    public final bo b() {
        synchronized (this.p) {
            return this.g;
        }
    }
    
    public final void b(final bg bg) {
        this.a(bg, ae.b);
    }
    
    public final void b(final bj bj) {
        synchronized (this.m) {
            this.m.remove(bj);
        }
    }
    
    public final String c() {
        return this.f;
    }
    
    public final String d() {
        synchronized (this.p) {
            String a;
            if (this.h == null) {
                a = null;
            }
            else {
                a = this.h.a();
            }
            return a;
        }
    }
    
    public final void e() {
        if (this.q != null) {
            this.q.b();
        }
        aj.b(bc.d);
        aj.c(bc.d);
        this.m();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof bc) {
            final bc bc = (bc)o;
            if (a(bc.f, this.f) && a(bc.l, this.l) && a(bc.g, this.g) && a(bc.k(), this.k())) {
                return true;
            }
        }
        return false;
    }
    
    final void h() {
        final bk r = this.r;
        int n = 0;
        Label_0068: {
            if (r == null) {
                break Label_0068;
            }
            bk r2;
            bk r3;
            boolean a;
            Date date;
            long n2;
            boolean a2;
            long n3;
            Block_6_Outer:Block_8_Outer:
            while (true) {
                if (n == 0) {
                    return;
                }
                synchronized (this.p) {
                    r2 = this.r;
                    r3 = null;
                    if (r2 == null) {
                        r3 = new bk(this);
                        this.r = r3;
                    }
                    // monitorexit(this.p)
                    if (r3 != null) {
                        r3.a();
                    }
                    return;
                    // iftrue(Label_0011:, !a)
                    // iftrue(Label_0011:, n2 <= 0)
                    // iftrue(Label_0011:, !a2)
                    // iftrue(Label_0011:, n3 <= 0)
                Block_9:
                    while (true) {
                    Block_7:
                        while (true) {
                            a = this.h.d().a();
                            n = 0;
                            break Block_7;
                            n2 = lcmp(date.getTime() - this.h.e().getTime(), 86400000L);
                            n = 0;
                            break Block_9;
                            date = new Date();
                            a2 = this.g.a();
                            n = 0;
                            continue Block_8_Outer;
                        }
                        n3 = lcmp(date.getTime() - this.i.getTime(), 3600000L);
                        n = 0;
                        continue;
                    }
                    n = 1;
                    continue Block_6_Outer;
                }
                break;
            }
        }
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    final a i() {
        return this.h;
    }
    
    @Override
    public String toString() {
        final StringBuilder append = new StringBuilder("{Session state:").append(this.g).append(", token:");
        Serializable h;
        if (this.h == null) {
            h = "null";
        }
        else {
            h = this.h;
        }
        final StringBuilder append2 = append.append(h).append(", appId:");
        String f;
        if (this.f == null) {
            f = "null";
        }
        else {
            f = this.f;
        }
        return append2.append(f).append("}").toString();
    }
}

import java.util.Iterator;
import java.util.Collections;
import android.os.SystemClock;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Collection;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import android.text.TextUtils;
import android.os.HandlerThread;
import java.util.ArrayList;
import java.util.HashMap;
import android.content.Context;
import java.io.File;
import android.os.Handler;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

// 
// Decompiled by Procyon v0.5.29
// 

public class fh implements fp, ft
{
    private static final String a;
    private static AtomicInteger b;
    private static AtomicInteger c;
    private long A;
    private Map B;
    private List C;
    private boolean D;
    private int E;
    private List F;
    private int G;
    private Map H;
    private Map I;
    private final Handler J;
    private fn K;
    private fl L;
    private int M;
    private boolean N;
    private File d;
    private File e;
    private volatile boolean f;
    private String g;
    private String h;
    private List i;
    private Map j;
    private boolean k;
    private long l;
    private List m;
    private String n;
    private long o;
    private long p;
    private long q;
    private long r;
    private String s;
    private String t;
    private byte u;
    private int v;
    private boolean w;
    private String x;
    private byte y;
    private long z;
    
    static {
        a = fh.class.getSimpleName();
        fh.b = new AtomicInteger(0);
        fh.c = new AtomicInteger(0);
    }
    
    public fh(final Context context, final String s, final fl l) {
        this.d = null;
        this.e = null;
        this.f = false;
        this.j = new HashMap();
        this.m = new ArrayList();
        this.s = "";
        this.t = "";
        this.u = -1;
        this.B = new HashMap();
        this.C = new ArrayList();
        this.F = new ArrayList();
        this.N = false;
        final String a = fh.a;
        gj.a(4, "Initializing new Flurry session");
        final HandlerThread handlerThread = new HandlerThread("FlurryAgentSession_" + s);
        handlerThread.start();
        this.J = new Handler(handlerThread.getLooper());
        if (TextUtils.isEmpty((CharSequence)this.n)) {
            this.a(new fj(this));
        }
        this.K = new fn(this);
        this.L = l;
        this.g = s;
        this.d = context.getFileStreamPath(".flurryagent." + Integer.toString(this.g.hashCode(), 16));
        this.e = context.getFileStreamPath(".flurryinstallreceiver.");
        this.h = gb.a();
        this.q = -1L;
        this.v = 0;
        this.t = TimeZone.getDefault().getID();
        this.s = Locale.getDefault().getLanguage() + "_" + Locale.getDefault().getCountry();
        this.B = new HashMap();
        this.C = new ArrayList();
        this.D = true;
        this.F = new ArrayList();
        this.E = 0;
        this.G = 0;
        fh.b.set(0);
        fh.c.set(0);
        final fs a2 = fr.a();
        this.y = (byte)a2.a("Gender");
        a2.a("Gender", this);
        final String a3 = fh.a;
        gj.a(4, "initSettings, Gender = " + this.y);
        this.x = (String)a2.a("UserId");
        a2.a("UserId", this);
        final String a4 = fh.a;
        gj.a(4, "initSettings, UserId = " + this.x);
        this.w = (boolean)a2.a("LogEvents");
        a2.a("LogEvents", this);
        final String a5 = fh.a;
        gj.a(4, "initSettings, LogEvents = " + this.w);
        this.z = (long)a2.a("Age");
        a2.a("Age", this);
        final String a6 = fh.a;
        gj.a(4, "initSettings, BirthDate = " + this.z);
        this.A = (long)a2.a("ContinueSessionMillis");
        a2.a("ContinueSessionMillis", this);
        final String a7 = fh.a;
        gj.a(4, "initSettings, ContinueSessionMillis = " + this.A);
    }
    
    private void a(final gm gm) {
        this.J.post((Runnable)gm);
    }
    
    private ff g() {
        synchronized (this) {
            final fg fg = new fg();
            fg.a = this.h;
            fg.b = this.o;
            fg.c = this.q;
            fg.d = this.r;
            fg.e = this.s;
            fg.f = this.t;
            fg.g = this.u;
            Label_0191: {
                if (this.x != null) {
                    break Label_0191;
                }
                String x = "";
                while (true) {
                    fg.h = x;
                    em.a();
                    fg.i = em.f();
                    fg.j = this.G;
                    fg.k = this.y;
                    fg.l = this.z;
                    fg.m = this.C;
                    fg.p = this.B;
                    fg.o = this.F;
                    fg.n = this.v;
                    fg.q = this.D;
                    try {
                        final ff ff = new ff(fg);
                        if (ff == null) {
                            final String a = fh.a;
                            gj.a(6, "New session report wasn't created");
                        }
                        return ff;
                        x = this.x;
                    }
                    catch (IOException ex) {
                        ex.printStackTrace();
                        final ff ff = null;
                    }
                }
            }
        }
    }
    
    private void h() {
        try {
            final String a = fh.a;
            gj.a(3, "generating agent report");
            final er er = new er(this.g, this.h, this.n, this.k, this.l, this.o, this.m, this.e, this.j, this.H, this.I);
            this.i = new ArrayList(this.m);
            if (er.a() != null) {
                final String a2 = fh.a;
                gj.a(3, "generated report of size " + er.a().length + " with " + this.m.size() + " reports.");
                final byte[] a3 = er.a();
                final es g = em.a().g();
                final StringBuilder sb = new StringBuilder();
                em.a();
                g.a(a3, this.g, sb.append(em.b()).toString());
                this.m.removeAll(this.i);
                this.i = null;
                this.i();
                return;
            }
            final String a4 = fh.a;
            gj.a(6, "Error generating report");
        }
        catch (Throwable t) {
            final String a5 = fh.a;
            gj.b("", t);
        }
    }
    
    private void i() {
        // monitorenter(this)
        try {
            if (!gf.a(this.d)) {
                final String a = fh.a;
                gj.a(6, "ERROR! CREATE PARENT DIR DIDN'T PROCCEED");
            }
            else {
                try {
                    final DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.d));
                    final fm fm = new fm();
                    fm.a(this.k);
                    fm.a(this.l);
                    fm.a(this.m);
                    fm.a(dataOutputStream, this.g, this.n);
                }
                catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                catch (IOException ex2) {
                    ex2.printStackTrace();
                }
            }
        }
        finally {}
    }
    
    private void j() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: monitorenter   
        //     2: aload_0        
        //     3: getfield        fh.d:Ljava/io/File;
        //     6: invokevirtual   java/io/File.exists:()Z
        //     9: ifeq            281
        //    12: getstatic       fh.a:Ljava/lang/String;
        //    15: pop            
        //    16: iconst_4       
        //    17: new             Ljava/lang/StringBuilder;
        //    20: dup            
        //    21: ldc_w           "loading persistent data: "
        //    24: invokespecial   java/lang/StringBuilder.<init>:(Ljava/lang/String;)V
        //    27: aload_0        
        //    28: getfield        fh.d:Ljava/io/File;
        //    31: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
        //    34: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    37: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    40: invokestatic    gj.a:(ILjava/lang/String;)V
        //    43: new             Ljava/io/DataInputStream;
        //    46: dup            
        //    47: new             Ljava/io/FileInputStream;
        //    50: dup            
        //    51: aload_0        
        //    52: getfield        fh.d:Ljava/io/File;
        //    55: invokespecial   java/io/FileInputStream.<init>:(Ljava/io/File;)V
        //    58: invokespecial   java/io/DataInputStream.<init>:(Ljava/io/InputStream;)V
        //    61: astore          4
        //    63: new             Lfm;
        //    66: dup            
        //    67: invokespecial   fm.<init>:()V
        //    70: astore          5
        //    72: aload_0        
        //    73: aload           5
        //    75: aload           4
        //    77: aload_0        
        //    78: getfield        fh.g:Ljava/lang/String;
        //    81: invokevirtual   fm.a:(Ljava/io/DataInputStream;Ljava/lang/String;)Z
        //    84: putfield        fh.f:Z
        //    87: aload_0        
        //    88: getfield        fh.f:Z
        //    91: ifeq            121
        //    94: aload_0        
        //    95: aload           5
        //    97: invokevirtual   fm.a:()Z
        //   100: putfield        fh.k:Z
        //   103: aload_0        
        //   104: aload           5
        //   106: invokevirtual   fm.c:()J
        //   109: putfield        fh.l:J
        //   112: aload_0        
        //   113: aload           5
        //   115: invokevirtual   fm.b:()Ljava/util/List;
        //   118: putfield        fh.m:Ljava/util/List;
        //   121: aload           4
        //   123: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   126: aload_0        
        //   127: getfield        fh.f:Z
        //   130: ifne            154
        //   133: aload_0        
        //   134: getfield        fh.d:Ljava/io/File;
        //   137: invokevirtual   java/io/File.delete:()Z
        //   140: ifeq            250
        //   143: getstatic       fh.a:Ljava/lang/String;
        //   146: pop            
        //   147: iconst_3       
        //   148: ldc_w           "Deleted persistence file"
        //   151: invokestatic    gj.a:(ILjava/lang/String;)V
        //   154: aload_0        
        //   155: getfield        fh.f:Z
        //   158: ifne            179
        //   161: aload_0        
        //   162: iconst_0       
        //   163: putfield        fh.k:Z
        //   166: aload_0        
        //   167: aload_0        
        //   168: getfield        fh.o:J
        //   171: putfield        fh.l:J
        //   174: aload_0        
        //   175: iconst_1       
        //   176: putfield        fh.f:Z
        //   179: aload_0        
        //   180: new             Leo;
        //   183: dup            
        //   184: aload_0        
        //   185: getfield        fh.e:Ljava/io/File;
        //   188: invokespecial   eo.<init>:(Ljava/io/File;)V
        //   191: invokevirtual   eo.a:()Ljava/util/Map;
        //   194: putfield        fh.H:Ljava/util/Map;
        //   197: aload_0        
        //   198: monitorexit    
        //   199: return         
        //   200: astore          13
        //   202: aload           13
        //   204: invokevirtual   java/io/IOException.printStackTrace:()V
        //   207: goto            121
        //   210: astore          7
        //   212: getstatic       fh.a:Ljava/lang/String;
        //   215: pop            
        //   216: ldc_w           "Error when loading persistent file"
        //   219: aload           7
        //   221: invokestatic    gj.b:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   224: aload           4
        //   226: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   229: goto            126
        //   232: astore_1       
        //   233: aload_0        
        //   234: monitorexit    
        //   235: aload_1        
        //   236: athrow         
        //   237: astore          6
        //   239: aconst_null    
        //   240: astore          4
        //   242: aload           4
        //   244: invokestatic    gl.a:(Ljava/io/Closeable;)V
        //   247: aload           6
        //   249: athrow         
        //   250: getstatic       fh.a:Ljava/lang/String;
        //   253: pop            
        //   254: bipush          6
        //   256: ldc_w           "Cannot delete persistence file"
        //   259: invokestatic    gj.a:(ILjava/lang/String;)V
        //   262: goto            154
        //   265: astore          9
        //   267: getstatic       fh.a:Ljava/lang/String;
        //   270: pop            
        //   271: ldc             ""
        //   273: aload           9
        //   275: invokestatic    gj.b:(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   278: goto            154
        //   281: getstatic       fh.a:Ljava/lang/String;
        //   284: pop            
        //   285: iconst_4       
        //   286: ldc_w           "Agent cache file doesn't exist."
        //   289: invokestatic    gj.a:(ILjava/lang/String;)V
        //   292: goto            154
        //   295: astore          6
        //   297: goto            242
        //   300: astore          7
        //   302: aconst_null    
        //   303: astore          4
        //   305: goto            212
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  2      43     232    237    Any
        //  43     63     300    308    Ljava/lang/Throwable;
        //  43     63     237    242    Any
        //  63     121    200    210    Ljava/io/IOException;
        //  63     121    210    212    Ljava/lang/Throwable;
        //  63     121    295    300    Any
        //  121    126    232    237    Any
        //  126    154    265    281    Ljava/lang/Throwable;
        //  126    154    232    237    Any
        //  154    179    232    237    Any
        //  179    197    232    237    Any
        //  202    207    210    212    Ljava/lang/Throwable;
        //  202    207    295    300    Any
        //  212    224    295    300    Any
        //  224    229    232    237    Any
        //  242    250    232    237    Any
        //  250    262    265    281    Ljava/lang/Throwable;
        //  250    262    232    237    Any
        //  267    278    232    237    Any
        //  281    292    232    237    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 142, Size: 142
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
    
    public final void a() {
        this.k = true;
    }
    
    @Override
    public final void a(final String s, final Object o) {
        if (s.equals("Gender")) {
            this.y = (byte)o;
            final String a = fh.a;
            gj.a(4, "onSettingUpdate, Gender = " + this.y);
            return;
        }
        if (s.equals("UserId")) {
            this.x = (String)o;
            final String a2 = fh.a;
            gj.a(4, "onSettingUpdate, UserId = " + this.x);
            return;
        }
        if (s.equals("LogEvents")) {
            this.w = (boolean)o;
            final String a3 = fh.a;
            gj.a(4, "onSettingUpdate, LogEvents = " + this.w);
            return;
        }
        if (s.equals("Age")) {
            this.z = (long)o;
            final String a4 = fh.a;
            gj.a(4, "onSettingUpdate, Birthdate = " + this.z);
            return;
        }
        if (s.equals("ContinueSessionMillis")) {
            this.A = (long)o;
            final String a5 = fh.a;
            gj.a(4, "onSettingUpdate, ContinueSessionMillis = " + this.A);
            return;
        }
        final String a6 = fh.a;
        gj.a(6, "onSettingUpdate internal error!");
    }
    
    public final void a(final String s, final String s2, final String s3, final Throwable t) {
        while (true) {
            boolean b = false;
        Label_0169:
            while (true) {
                Label_0163: {
                    synchronized (this) {
                        if (this.F == null) {
                            final String a = fh.a;
                            gj.a(6, "onError called before onStartSession.  Error: " + s);
                        }
                        else {
                            if (s == null || !"uncaught".equals(s)) {
                                break Label_0163;
                            }
                            b = true;
                            ++this.v;
                            if (this.F.size() >= 50) {
                                break Label_0169;
                            }
                            final ep ep = new ep(fh.c.incrementAndGet(), Long.valueOf(System.currentTimeMillis()), s, s2, s3, t);
                            this.F.add(ep);
                            final String a2 = fh.a;
                            gj.a(3, "Error logged: " + ep.a);
                        }
                        return;
                    }
                }
                b = false;
                continue;
            }
            if (b) {
                for (int i = 0; i < this.F.size(); ++i) {
                    final ep ep2 = this.F.get(i);
                    if (ep2.a != null && !"uncaught".equals(ep2.a)) {
                        this.F.set(i, new ep(fh.c.incrementAndGet(), Long.valueOf(System.currentTimeMillis()), s, s2, s3, t));
                        return;
                    }
                }
                return;
            }
            final String a3 = fh.a;
            gj.a(3, "Max errors logged. No more errors logged.");
        }
    }
    
    public final void a(final String str, final Map map) {
    Label_0193_Outer:
        while (true) {
            while (true) {
                Label_0390: {
                    Label_0382: {
                        long n = 0L;
                        String a2 = null;
                        Map<Object, Object> emptyMap = null;
                    Label_0288:
                        while (true) {
                            final en en;
                            Label_0273: {
                                Label_0244: {
                                    synchronized (this) {
                                        if (this.C == null) {
                                            final String a = fh.a;
                                            gj.a(6, "onEvent called before onStartSession.  Event: " + str);
                                        }
                                        else {
                                            n = SystemClock.elapsedRealtime() - this.p;
                                            a2 = gl.a(str);
                                            if (a2.length() != 0) {
                                                en = this.B.get(a2);
                                                if (en != null) {
                                                    break Label_0273;
                                                }
                                                if (this.B.size() >= 100) {
                                                    break Label_0244;
                                                }
                                                final en en2 = new en();
                                                en2.a = 1;
                                                this.B.put(a2, en2);
                                                final String a3 = fh.a;
                                                gj.a(3, "Event count incremented: " + a2);
                                                if (!this.w || this.C.size() >= 1000 || this.E >= 160000) {
                                                    break Label_0382;
                                                }
                                                if (map != null) {
                                                    break Label_0390;
                                                }
                                                emptyMap = Collections.emptyMap();
                                                if (emptyMap.size() <= 10) {
                                                    break Label_0288;
                                                }
                                                final String a4 = fh.a;
                                                gj.a(5, "MaxEventParams exceeded: " + emptyMap.size());
                                            }
                                        }
                                        return;
                                    }
                                }
                                final String a5 = fh.a;
                                gj.a(5, "Too many different events. Event not counted: " + a2);
                                continue Label_0193_Outer;
                            }
                            ++en.a;
                            continue Label_0193_Outer;
                        }
                        final eq eq = new eq(fh.b.incrementAndGet(), a2, emptyMap, n);
                        if (eq.a().length + this.E <= 160000) {
                            this.C.add(eq);
                            this.E += eq.a().length;
                            return;
                        }
                        this.E = 160000;
                        this.D = false;
                        final String a6 = fh.a;
                        gj.a(5, "Event Log size exceeded. No more event details logged.");
                        return;
                    }
                    this.D = false;
                    return;
                }
                Map<Object, Object> emptyMap = (Map<Object, Object>)map;
                continue;
            }
        }
    }
    
    public final void a(final Map i) {
        this.I = i;
    }
    
    public final void b() {
        if (this.K.b()) {
            this.K.a();
        }
        ++this.M;
        if (!this.N) {
            final String a = fh.a;
            gj.a(5, "Start session");
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            this.o = System.currentTimeMillis();
            this.p = elapsedRealtime;
            this.a(new fi(this));
            this.N = true;
        }
        else {
            final String a2 = fh.a;
            gj.a(5, "Continuing previous session");
            if (!this.m.isEmpty()) {
                this.m.remove(-1 + this.m.size());
            }
        }
    }
    
    public final void c() {
        final String a = fh.a;
        gj.a(5, "Trying to end session");
        if (this.N) {
            if (this.M > 0) {
                --this.M;
            }
            if (this.M == 0) {
                this.K.a(this.A);
            }
        }
    }
    
    public final void d() {
        if (!this.N) {
            return;
        }
        final String a = fh.a;
        gj.a(5, "Ending session");
        this.M = 0;
        if (this.K.b()) {
            this.K.a();
        }
        this.q = SystemClock.elapsedRealtime() - this.p;
        final long q = this.q;
        for (final eq eq : this.C) {
            if (eq.c && !eq.d) {
                eq.d = true;
                eq.e = q - eq.b;
                gj.a(3, "Ended event '" + eq.a + "' (" + eq.b + ") after " + eq.e + "ms");
            }
        }
        this.a(new fk(this, fq.a.b));
        if (this.L != null) {
            this.L.a(this.g);
        }
        fr.a().b("Gender", this);
        fr.a().b("UserId", this);
        fr.a().b("Age", this);
        fr.a().b("LogEvents", this);
        fr.a().b("ContinueSessionMillis", this);
        this.J.getLooper().quit();
    }
    
    public final String e() {
        return this.g;
    }
    
    @Override
    public final void f() {
        if (this.M != 0) {
            final String a = fh.a;
            gj.a(6, "Error! Session with apiKey = " + this.g + " was ended while getSessionCount() is not 0");
        }
        this.d();
    }
}

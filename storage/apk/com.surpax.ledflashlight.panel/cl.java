import com.nuance.nmsp.client.sdk.oem.k;
import com.nuance.nmdp.speechkit.recognitionresult.b;
import java.util.LinkedList;
import java.util.List;

// 
// Decompiled by Procyon v0.5.29
// 

public class cl implements bh, ce, ch
{
    private static final be a;
    private static byte[] l;
    private final String b;
    private final long c;
    private final List d;
    private int e;
    private long f;
    private boolean g;
    private ci h;
    private bf i;
    private cd j;
    private int k;
    
    static {
        a = dh.a(cl.class);
        cl.l = new byte[16];
    }
    
    public cl(final String b, final long c, final int n, final String s, final String s2, final String s3, final bf i, final cd j) {
        this.d = new LinkedList();
        this.e = 0;
        this.f = 0L;
        this.g = false;
        this.j = null;
        this.k = 1;
        this.b = b;
        this.c = c;
        this.j = j;
        this.i = i;
        while (true) {
            Label_0219: {
                if (s != null && s.length() != 0) {
                    break Label_0219;
                }
                final String b2 = bi.b();
                while (true) {
                    try {
                        this.h = cp.a(b2, "CLIENT", "2.0", n, this, "CLIENT").a("UniqueID", s2).a("ApplicationID", s3).a("client_hardware_model", com.nuance.nmdp.speechkit.recognitionresult.b.h()).a("client_hardware_submodel", com.nuance.nmdp.speechkit.recognitionresult.b.i()).a("client_os_type", com.nuance.nmdp.speechkit.recognitionresult.b.j()).a("client_os_version", com.nuance.nmdp.speechkit.recognitionresult.b.k()).a("client_sdk_release", "NMSP 5.0 client SDK - build 009").a();
                        final bf k = this.i;
                        final bg bg = new bg((byte)17, null);
                        final Thread currentThread = Thread.currentThread();
                        this.i.a();
                        k.a(bg, this, currentThread);
                        return;
                    }
                    catch (cj cj) {
                        continue;
                    }
                    break;
                }
            }
            final String b2 = s;
            continue;
        }
    }
    
    private void b(final int n) {
        while (this.d.size() > 0) {
            final Object object = this.d.get(0);
            if (n < object.a) {
                break;
            }
            this.f -= object.b.length;
            this.d.remove(0);
            --this.e;
            this.d();
        }
    }
    
    private void d() {
        if (this.g) {
            if (cl.a.b()) {
                cl.a.b("trySendingLogs() _sessionConnected:" + this.g + ", _outstandingEvents:" + this.e + ", _events.size()" + this.d.size());
            }
            while (this.e < 5 && this.e < this.d.size()) {
                final Object object = this.d.get(this.e);
                if (cl.a.b()) {
                    cl.a.b("bcpLog, packet len [" + object.b.length + "]");
                }
                final bf i = this.i;
                final bg bg = new bg((byte)18, new Object[] { object });
                final Thread currentThread = Thread.currentThread();
                this.i.a();
                i.a(bg, this, currentThread);
                ++this.e;
            }
        }
    }
    
    private void e() {
        final k k = new k();
        if (this.b != null && k.a(this.b, bd.a)) {
            if (k.b() <= 2147483647L) {
                final long b = k.b();
                long n = 0L;
                final int size = this.d.size();
                while (true) {
                    while (n < b) {
                        final byte[] array = { 0 };
                        int n2;
                        if (k.a(array, array.length) != array.length) {
                            n2 = 1;
                        }
                        else {
                            final long n3 = n + array.length;
                            final byte[] array2 = new byte[array[0]];
                            if (k.a(array2, array2.length) != array2.length) {
                                n2 = 1;
                            }
                            else {
                                final long n4 = n3 + array2.length;
                                int n5;
                                if (array2.length == 1) {
                                    n5 = (0xFF & array2[0]);
                                }
                                else if (array2.length == 2) {
                                    n5 = ((0xFF & array2[1]) << 8) + (0xFF & array2[0]);
                                }
                                else if (array2.length == 3) {
                                    n5 = ((0xFF & array2[2]) << 16) + ((0xFF & array2[1]) << 8) + (0xFF & array2[0]);
                                }
                                else {
                                    n5 = ((0xFF & array2[3]) << 24) + ((0xFF & array2[2]) << 16) + ((0xFF & array2[1]) << 8) + (0xFF & array2[0]);
                                }
                                final byte[] b2 = new byte[n5];
                                if (k.a(b2, b2.length) == b2.length) {
                                    final Object object = new Object() {
                                        public int a;
                                        public byte[] b;
                                    };
                                    object.b = b2;
                                    this.f += b2.length;
                                    this.d.add(object);
                                    n = n4 + b2.length;
                                    continue;
                                }
                                n2 = 1;
                            }
                        }
                        k.a();
                        if (n2 != 0) {
                            k.c();
                            if (cl.a.e()) {
                                cl.a.e("handleLoadFile() failed!!!");
                            }
                        }
                        else if (cl.a.c()) {
                            cl.a.c("handleLoadFile() " + (this.d.size() - size) + " events are loaded");
                        }
                        this.f();
                        return;
                    }
                    int n2 = 0;
                    continue;
                }
            }
            if (cl.a.e()) {
                cl.a.e("calllog file too big (" + k.b() + " > 2147483647)!!!");
            }
            k.a();
        }
        else if (cl.a.c()) {
            cl.a.c("handleLoadFile() cannot open + file:" + this.b);
        }
    }
    
    private void f() {
        if (this.f > this.c) {
            final int size = this.d.size();
            while (this.f > this.c) {
                this.f -= ((byte[])this.d.remove(0)).length;
            }
            if (cl.a.c()) {
                cl.a.c("trimEventsList() " + (size - this.d.size()) + " events are removed due to size limit (" + this.c + ")");
            }
        }
    }
    
    @Override
    public final void a() {
        if (cl.a.b()) {
            cl.a.b("socketOpened()");
        }
    }
    
    public final void a(final int n) {
        if (cl.a.b()) {
            cl.a.b("bcpLogResponse requestId = " + n);
        }
        final bf i = this.i;
        final bg bg = new bg((byte)19, new Object[] { new Integer(n) });
        final Thread currentThread = Thread.currentThread();
        this.i.a();
        i.a(bg, this, currentThread);
    }
    
    @Override
    public final void a(final bs bs, final byte[] array) {
    }
    
    public final void a(final cs cs, final cq cq) {
        final bf i = this.i;
        final bg bg = new bg((byte)20, new Object[] { cs, cq });
        final Thread currentThread = Thread.currentThread();
        this.i.a();
        i.a(bg, this, currentThread);
    }
    
    final void a(final cs cs, final cr cr) {
        final bf i = this.i;
        final bg bg = new bg((byte)16, new Object[] { cs, cr });
        final Thread currentThread = Thread.currentThread();
        this.i.a();
        i.a(bg, this, currentThread);
    }
    
    @Override
    public final void a(final Object o, final Object o2) {
        final bg bg = (bg)o;
        switch (bg.a) {
            case 20: {
                final Object[] array = (Object[])bg.b;
                final cs cs = (cs)array[0];
                final cq cq = (cq)array[1];
                cs.c();
                if (cq == null) {
                    break;
                }
                if (cs instanceof cn) {
                    cq.a(((cn)cs).b());
                    return;
                }
                cq.a(null);
            }
            case 16: {
                final cs cs2 = (cs)((Object[])bg.b)[0];
                final Object object = new Object() {
                    public int a;
                    public byte[] b;
                };
                object.b = cs2.f();
                if (this.f < this.c) {
                    new StringBuilder().append(cs2.b.b()).append(cs2.d);
                    this.d.add(object);
                    this.f += object.b.length;
                    this.d();
                    return;
                }
                break;
            }
            case 17: {
                this.e();
            }
            case 18: {
                final Object object2 = (cl$1)((Object[])bg.b)[0];
                object2.a = this.k++;
                final byte[] array2 = new byte[25 + object2.b.length];
                array2[0] = 0;
                bu.a(object2.a, array2, 1);
                final byte[] a = br.a(array2, cl.l);
                bu.a(object2.b.length, a, 21);
                System.arraycopy(object2.b, 0, a, 25, object2.b.length);
                this.j.a(br.a((byte)2, (byte)34, (short)2640, a), 1, "SEND_BCP_LOG");
            }
            case 19: {
                this.b((int)((Object[])bg.b)[0]);
            }
        }
    }
    
    @Override
    public final void a(final String str) {
        if (str.startsWith("SEND_BCP_LOG") && cl.a.b()) {
            cl.a.b("onMsgSent(" + str + ")");
        }
    }
    
    @Override
    public final void a(final short i, final short j) {
        if (cl.a.b()) {
            cl.a.b("socketClosed() reason [" + i + "] subReason [" + j + "]");
        }
        this.g = false;
    }
    
    public final ci b() {
        return this.h;
    }
    
    @Override
    public final void b(final String str) {
        if (str.startsWith("SEND_BCP_LOG")) {
            if (cl.a.b()) {
                cl.a.b("onMsgNotSent(" + str + ")");
            }
            final Object object = this.d.remove(0);
            this.f -= object.b.length;
            --this.e;
            this.d.add(this.e, object);
            this.d();
        }
    }
    
    @Override
    public final ck c(final String str) {
        if (cl.a.b()) {
            cl.a.b("openSession(" + str + ")");
        }
        if (((co)this.h).a != null) {
            throw new cg("Application session already opened.");
        }
        final cn a = (cn)cp.a((cs)this.h, "APP_REMOTEEVENT", null).a(new cr());
        final cp a2 = cp.a(a, str);
        ((co)this.h).a = a;
        return a2;
    }
    
    public final void c() {
        this.g = true;
        this.d();
    }
}

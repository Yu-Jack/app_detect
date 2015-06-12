import com.nuance.nmsp.client.sdk.oem.q;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Vector;
import java.util.Queue;

// 
// Decompiled by Procyon v0.5.29
// 

public class cd implements bh, bk, bn, bo, bp
{
    private static be c;
    private ce A;
    private ci B;
    private cp C;
    private Queue D;
    private Queue E;
    protected byte a;
    public byte[] b;
    private bq d;
    private int e;
    private bq f;
    private int g;
    private bq h;
    private String i;
    private short j;
    private Vector k;
    private boolean l;
    private Vector m;
    private bf n;
    private Object o;
    private bs p;
    private short q;
    private short r;
    private String s;
    private String t;
    private byte[] u;
    private bj v;
    private String w;
    private int x;
    private short y;
    private short z;
    
    static {
        cd.c = dh.a(cd.class);
    }
    
    public cd(final String s, final short n, final String s2, final byte[] u, final String t, final ce a, final Vector k, final bf n2) {
        this.e = 30;
        this.g = 50;
        this.i = null;
        this.j = 0;
        this.l = false;
        this.m = null;
        this.n = null;
        this.p = null;
        this.q = 0;
        this.r = 9;
        this.s = "Not specified";
        this.t = "Not specified";
        this.u = null;
        this.v = null;
        this.w = "";
        this.C = null;
        this.D = new LinkedList();
        this.E = new LinkedList();
        this.i = s;
        this.j = n;
        this.s = s2;
        this.u = u;
        this.t = t;
        this.A = a;
        if (k != null) {
            this.k = k;
        }
        else {
            this.k = new Vector();
        }
        this.n = n2;
        if (cd.c.b()) {
            cd.c.b("XMode() server: " + s + " port: " + n);
        }
        final Enumeration<df> elements = k.elements();
        while (elements.hasMoreElements()) {
            final df obj = elements.nextElement();
            if (cd.c.b()) {
                cd.c.b("XMode() " + obj.d() + " : " + obj.a() + " = " + new String(obj.b()));
            }
            if (obj.d() == dg.a) {
                if (obj.a().equals("IdleSessionTimeout")) {
                    final int int1 = Integer.parseInt(new String(obj.b()));
                    if (int1 <= 0) {
                        continue;
                    }
                    this.g = int1;
                }
                else if (obj.a().equals("ConnectionTimeout")) {
                    this.e = Integer.parseInt(new String(obj.b()));
                }
                else {
                    if (!obj.a().equals("SSL_Socket_Enable") && !obj.a().equals("SSL_Cert_Summary") && !obj.a().equals("SSL_Cert_Data") && !obj.a().equals("SSL_SelfSigned_Cert")) {
                        continue;
                    }
                    if (obj.a().equals("SSL_Socket_Enable") && (new String(obj.b()).equals("TRUE") || new String(obj.b()).equals("true"))) {
                        this.l = true;
                    }
                    if (this.m == null) {
                        this.m = new Vector();
                    }
                    this.m.addElement(obj);
                }
            }
        }
        this.a = 3;
    }
    
    private void a(final byte b, final Object o) {
        try {
            final bf n = this.n;
            final bg bg = new bg(b, o);
            final Thread currentThread = Thread.currentThread();
            this.n.a();
            n.a(bg, this, currentThread);
        }
        catch (Exception ex) {
            if (cd.c.e()) {
                cd.c.e("XMode.sendCmdMsg() " + ex.getMessage());
            }
        }
    }
    
    private void a(final bs bs, final byte[] array) {
        if (cd.c.b()) {
            cd.c.b("XMode.parseXModeMsg() protocol: " + bs.a + " cmd: " + bs.b);
        }
        switch (bs.a) {
            default: {
                if (cd.c.e()) {
                    cd.c.e("XMode.parseXModeMsg() unknown protocol: " + Integer.toHexString(bs.a));
                }
            }
            case 15: {}
            case 3: {
                switch (bs.b) {
                    case 257: {
                        this.n.a(this.f);
                        if (this.C != null) {
                            this.C.a();
                            this.C = null;
                        }
                        System.arraycopy(array, 0, this.b = new byte[16], 0, 16);
                        final bf n = this.n;
                        final byte[] b = this.b;
                        final bj v = this.v;
                        final Object o = this.o;
                        final byte[] b2 = this.b;
                        if (this.B != null) {
                            final cl cl = ((cs)this.B).c;
                            if (cl != null) {
                                cl.c();
                            }
                        }
                        this.w = be.b(this.b);
                        final be c = cd.c;
                        final String w = this.w;
                        c.f();
                        try {
                            if (cd.c.b()) {
                                cd.c.b("Received COP_Connected " + this.w);
                            }
                            this.a((byte)10, null);
                            cd.c.g();
                            this.a("SocketOpened");
                            this.h = new bq() {
                                @Override
                                public final void run() {
                                    try {
                                        cd.this.q = 3;
                                        if (cd.c.e()) {
                                            cd.c.e("Session Idle for too long, longer than [" + cd.this.g + "] (initiated from XMode.parseCopConnected)");
                                        }
                                        cd.this.a = 2;
                                        cd.this.a((byte)4, null);
                                    }
                                    catch (Exception ex) {
                                        if (cd.c.e()) {
                                            cd.c.e("XMode.parseXModeMsg() " + ex.getClass().getName() + " " + ex.getMessage());
                                        }
                                    }
                                }
                            };
                            this.n.a(this.h, 1000 * this.g);
                            break;
                        }
                        finally {
                            cd.c.g();
                        }
                    }
                    case 258: {
                        this.x = bu.b(array, 0);
                        this.a((byte)8, null);
                        break;
                    }
                    case 512: {
                        if (this.h != null) {
                            this.n.a(this.h);
                        }
                        this.r = bu.a(array, 0);
                        this.a = 2;
                        this.q = 6;
                        if (cd.c.d()) {
                            cd.c.d("XMode.parseXModeMsgCopDisconnect() Received COP DISCONNECT. ");
                        }
                        this.a((byte)4, null);
                        break;
                    }
                    case 768: {
                        final short a = bu.a(array, 0);
                        bu.b(array, 2);
                        this.q = 7;
                        this.r = a;
                        this.a = 2;
                        if (cd.c.e()) {
                            cd.c.e("XMode.parseXModeMsgCopConnectFailed() COP CONNECT failure. ");
                        }
                        this.a((byte)4, null);
                        break;
                    }
                }
                this.A.a(bs, array);
            }
            case 2: {
                if (this.h != null && this.n.a(this.h)) {
                    this.h = new bq() {
                        @Override
                        public final void run() {
                            try {
                                cd.this.q = 3;
                                if (cd.c.e()) {
                                    cd.c.e("Session Idle for too long, longer than [" + cd.this.g + "] (initiated from XMode.parseBcp)");
                                }
                                cd.this.a = 2;
                                cd.this.a((byte)4, null);
                            }
                            catch (Exception ex) {
                                if (cd.c.e()) {
                                    cd.c.e("XMode.parseXModeMsg() " + ex.getClass().getName() + " " + ex.getMessage());
                                }
                            }
                        }
                    };
                    this.n.a(this.h, 1000 * this.g);
                }
                if (bs.b != 2641) {
                    this.A.a(bs, array);
                    return;
                }
                final int b3 = bu.b(array, 17);
                final short a2 = bu.a(array, 21);
                final cl cl2 = ((cs)this.B).c;
                if (a2 == 0 || a2 == 1 || a2 == 3) {
                    cl2.a(b3);
                    return;
                }
                if (cd.c.e()) {
                    cd.c.e("XMode.parseXModeMsgBcpLogResponse() XMODE_BCP_LOG_WRITE_ERROR. ");
                }
            }
            case 1: {
                if (this.h != null && this.n.a(this.h)) {
                    this.h = new bq() {
                        @Override
                        public final void run() {
                            try {
                                cd.this.q = 3;
                                if (cd.c.e()) {
                                    cd.c.e("Session Idle for too long, longer than [" + cd.this.g + "] (initiated from XMode.parseVap)");
                                }
                                cd.this.a = 2;
                                cd.this.a((byte)4, null);
                            }
                            catch (Exception ex) {
                                if (cd.c.e()) {
                                    cd.c.e("XMode.parseXModeMsg() " + ex.getClass().getName() + " " + ex.getMessage());
                                }
                            }
                        }
                    };
                    this.n.a(this.h, 1000 * this.g);
                }
                this.A.a(bs, array);
            }
        }
    }
    
    private void a(final String s) {
        if (this.B != null) {
            this.B.a(s).a();
        }
    }
    
    @Override
    public final void a() {
        if (cd.c.b()) {
            cd.c.b("XMode.closeSocketCallback() " + this.w);
        }
        this.a = 3;
        if (this.d != null) {
            this.n.a(this.d);
            this.d = null;
        }
        if (this.h != null) {
            this.n.a(this.h);
            this.h = null;
        }
        if (this.o != null) {
            this.A.a(this.q, this.r);
        }
        if (this.B != null) {
            final cl cl = ((cs)this.B).c;
            if (cl != null) {
                cl.a(this.q, this.r);
            }
        }
        this.o = null;
        this.v = null;
        this.b = null;
        this.w = "";
    }
    
    public final void a(final int i) {
        if (cd.c.b()) {
            cd.c.b("XMode.startStreaming() audio id: " + i);
        }
        if (this.a != 1) {
            return;
        }
        final byte[] array = new byte[6];
        bu.a(i, array, 0);
        bu.a(this.y, array, 4);
        this.a(br.a((byte)1, (byte)18, (short)257, array), 3, "SEND_VAP_RECORD_BEGIN");
    }
    
    @Override
    public final void a(final bm bm, final Object o) {
        if (cd.c.b()) {
            cd.c.b("XMode.openSocketCallback() ");
        }
        if (bm == bm.a) {
            this.o = o;
            if (this.a != 0) {
                this.a = 2;
                this.v.a(this.o);
                return;
            }
            if (this.B != null) {
                this.a((byte)13, null);
                return;
            }
            this.a((byte)7, null);
        }
        else {
            if (bm == bm.b) {
                if (cd.c.e()) {
                    cd.c.e("XMode.openSocketCallback() NETWORK_ERROR");
                }
                this.a = 3;
                this.q = 4;
                this.A.a(this.q, this.r);
                this.o = null;
                this.v = null;
                this.b = null;
                this.w = "";
                return;
            }
            if (bm == bm.c) {
                this.q = 4;
                if (cd.c.e()) {
                    cd.c.e("XMode.openSocketCallback() NETWORK_MEMORY_ERROR");
                }
            }
        }
    }
    
    @Override
    public final void a(final bm bm, final Object o, final int n, final int n2, final Object o2) {
        int i = 0;
        final String s = (String)((cf)o2).b;
        if (bm == bm.a && n == n2) {
            if (s.equals("SEND_COP_CONNECT")) {
                this.a((byte)5, null);
            }
            else if (s.equals("SEND_COP_DISCONNECT")) {
                this.v.a(o);
            }
            this.a((byte)11, s);
            this.D.remove(o2);
            if (this.D.size() == 0 && this.E.size() > 0) {
                this.a((byte)14, null);
            }
        }
        else if (bm == bm.b) {
            if (this.q != 1 && this.q != 3) {
                this.q = 8;
                if (cd.c.e()) {
                    cd.c.e("XMode.writeSocketCallback() NETWORK_ERROR");
                }
            }
            this.a((byte)12, s);
            this.D.remove(o2);
            if (this.D.size() == 0) {
                while (i < this.E.size()) {
                    this.a((byte)12, this.E.remove().b);
                    ++i;
                }
            }
        }
        else if (bm == bm.c) {
            if (this.q != 1 && this.q != 3) {
                this.q = 8;
                if (cd.c.e()) {
                    cd.c.e("XMode.writeSocketCallback() NETWORK_MEMORY_ERROR");
                }
            }
            this.a((byte)12, s);
            this.D.remove(o2);
            if (this.D.size() == 0) {
                while (i < this.E.size()) {
                    this.a((byte)12, this.E.remove().b);
                    ++i;
                }
            }
        }
    }
    
    @Override
    public final void a(final bm bm, final Object o, final byte[] array, final int n, final int n2, final Object o2) {
        final String s = (String)o2;
        if (cd.c.b()) {
            cd.c.b("Read callback");
        }
        if (cd.c.a()) {
            cd.c.a(array);
        }
        if (bm == bm.a) {
            if (s.equals("READ_XMODE_HEADER")) {
                if (n2 == 0) {
                    this.d = new bq() {
                        @Override
                        public final void run() {
                            try {
                                cd.this.a((byte)5, null);
                            }
                            catch (Exception ex) {
                                if (cd.c.e()) {
                                    cd.c.e("XMode.readSocketCallback() " + ex.getClass().getName() + " " + ex.getMessage());
                                }
                            }
                        }
                    };
                    this.n.a(this.d, 20L);
                }
                else if (n2 == n) {
                    this.p = new bs(array);
                    if (this.p.c == 0) {
                        this.a(this.p, null);
                        this.a((byte)5, null);
                        return;
                    }
                    if (this.p.c > 512000 || this.p.c < 0) {
                        this.v.b(o);
                        this.a((byte)5, null);
                        return;
                    }
                    this.a((byte)6, null);
                }
                else if (cd.c.e()) {
                    cd.c.e("----***---- readSocketCallback fatal error in readSocketCallback NET_CONTEXT_READ_XMODE_HEADER bytesRead:[" + n2 + "] bufferLen:[" + n + "]");
                }
            }
            else if (s.equals("READ_XMODE_PAYLOAD")) {
                if (n2 == 0) {
                    if (cd.c.b()) {
                        cd.c.b(Integer.toHexString(this.p.b) + " payload not read bytesRead is 0");
                    }
                    this.d = new bq() {
                        @Override
                        public final void run() {
                            try {
                                cd.this.a((byte)6, null);
                            }
                            catch (Exception ex) {
                                if (cd.c.e()) {
                                    cd.c.e("XMode.readSocketCallback() " + ex.getClass().getName() + " " + ex.getMessage());
                                }
                            }
                        }
                    };
                    this.n.a(this.d, 20L);
                    return;
                }
                if (n2 == n) {
                    if (this.p.c <= n) {
                        this.a(this.p, array);
                    }
                    this.a((byte)5, null);
                    return;
                }
                if (cd.c.e()) {
                    cd.c.e("----***---- readSocketCallback fatal error in readSocketCallback NET_CONTEXT_READ_XMODE_PAYLOAD bytesRead:[" + n2 + "] bufferLen:[" + n + "]");
                }
            }
        }
        else {
            if (bm == bm.b) {
                if (this.q != 1 && this.q != 3 && this.q != 6) {
                    this.q = 8;
                    if (cd.c.e()) {
                        cd.c.e("XMode.readSocketCallback() NETWORK_ERROR");
                    }
                }
                this.a((byte)4, null);
                return;
            }
            if (bm == bm.c && this.q != 1 && this.q != 3) {
                this.q = 8;
                if (cd.c.e()) {
                    cd.c.e("XMode.readSocketCallback() NETWORK_MEMORY_ERROR");
                }
            }
        }
    }
    
    public final void a(final ci ci) {
        if (ci != null) {
            this.B = ci.a("NMSPSocket").a();
        }
    }
    
    @Override
    public final void a(final Object o, final Object o2) {
        final bg bg = (bg)o;
        switch (bg.a) {
            case 1: {
                if (cd.c.b()) {
                    cd.c.b("XMode.handleMessage() CMD_CONNECT");
                }
                if (this.a == 0) {
                    this.a((byte)3, null);
                    return;
                }
                this.A.a(this.q, this.r);
            }
            case 3: {
                if (cd.c.b()) {
                    cd.c.b("XMode.handleMessage() CMD_OPEN_SOCKET");
                }
                if (this.a != 0) {
                    this.A.a(this.q, this.r);
                    return;
                }
                this.v = new q(this.n);
                if (this.l) {
                    this.v.a(this.i, this.j, this.m, this, this);
                    return;
                }
                this.v.a(this.i, this.j, this, this);
            }
            case 7: {
                if (cd.c.b()) {
                    cd.c.b("XMode.handleMessage() CMD_COP_CONNECT");
                }
                if (this.a == 0) {
                    final String str = (String)bg.b;
                    final StringBuilder append = new StringBuilder("<?xml version=\"1.0\"?><cc><s></s><t>7</t><b>20091023</b><tsc>").append(this.y).append("</tsc><fsc>").append(this.z).append("</fsc><nmaid>").append(this.s).append("</nmaid><uid>").append(this.t).append("</uid>");
                    String string;
                    if (str != null) {
                        string = "<rootlog>" + str + "</rootlog>";
                    }
                    else {
                        string = "";
                    }
                    final String string2 = append.append(string).toString();
                    final Enumeration<df> elements = (Enumeration<df>)this.k.elements();
                    String str2 = string2;
                    int n = 0;
                Label_0520_Outer:
                    while (elements.hasMoreElements()) {
                        final df df = elements.nextElement();
                        while (true) {
                            Label_1343: {
                                if (df.d() != dg.b) {
                                    break Label_1343;
                                }
                                str2 = str2 + "<nmsp p=\"" + df.a() + "\" v=\"" + bx.a(new String(df.b())) + "\"/>";
                                if (!df.a().equals("Ping_IntervalSecs")) {
                                    break Label_1343;
                                }
                                final String s = str2;
                                final int n2 = 1;
                                final String str3 = s;
                                String string3;
                                if (df.d() == dg.c) {
                                    string3 = str3 + "<app p=\"" + df.a() + "\" v=\"" + bx.a(new String(df.b())) + "\"/>";
                                }
                                else {
                                    string3 = str3;
                                }
                                n = n2;
                                str2 = string3;
                                continue Label_0520_Outer;
                            }
                            final String s2 = str2;
                            final int n2 = n;
                            final String str3 = s2;
                            continue;
                        }
                    }
                    if (n == 0) {
                        str2 += "<nmsp p=\"Ping_IntervalSecs\" v=\"0\"/>";
                    }
                    final byte[] bytes = (str2 + "</cc>").getBytes();
                    final int length = bytes.length;
                    final int n3 = 1 + (length + 4);
                    final byte[] array = new byte[n3];
                    bu.a(n3 - 4, array, 0);
                    array[4] = 0;
                    System.arraycopy(bytes, 0, array, 5, length);
                    this.a(br.a((byte)3, (byte)23, (short)256, array), 3, "SEND_COP_CONNECT");
                    this.f = new bq() {
                        @Override
                        public final void run() {
                            try {
                                if (cd.c.e()) {
                                    cd.c.e("XMode.handleSendCopConnect() COP CONNECT timed out. ");
                                }
                                if (cd.this.C != null) {
                                    cd.this.C.b();
                                    cd.this.C = null;
                                }
                                cd.this.a((byte)9, null);
                            }
                            catch (Exception ex) {
                                if (cd.c.e()) {
                                    cd.c.e("XMode.handleSendCopConnect() " + ex.getClass().getName() + " " + ex.getMessage());
                                }
                            }
                        }
                    };
                    this.n.a(this.f, 1000 * this.e);
                    this.a = 1;
                    this.A.a();
                    return;
                }
                break;
            }
            case 5: {
                if (this.v != null && this.o != null) {
                    this.v.a(this.o, bl.a, new byte[8], 8, this, "READ_XMODE_HEADER");
                    return;
                }
                break;
            }
            case 6: {
                if (this.p.c <= 0 || this.p.c > 512000) {
                    break;
                }
                final byte[] array2 = new byte[this.p.c];
                if (this.v != null && this.o != null) {
                    this.v.a(this.o, bl.a, array2, array2.length, this, "READ_XMODE_PAYLOAD");
                    return;
                }
                break;
            }
            case 2: {
                if (cd.c.b()) {
                    cd.c.b("XMode.handleMessage() CMD_DISCONNECT");
                }
                final byte[] array3 = new byte[2];
                bu.a((short)0, array3, 0);
                final byte[] a = br.a((byte)3, (byte)23, (short)512, array3);
                this.v.b(this.o);
                this.a(a, 3, "SEND_COP_DISCONNECT");
            }
            case 4: {
                if (cd.c.b()) {
                    cd.c.b("XMode.handleMessage() CMD_CLOSE_SOCKET");
                }
                if (this.v != null && this.o != null) {
                    this.v.a(this.o);
                    return;
                }
                break;
            }
            case 8: {
                if (cd.c.b()) {
                    cd.c.b("XMode.handleMessage() CMD_COP_PING_RESPONSE");
                }
                final byte[] array4 = new byte[8];
                bu.a(this.x, array4, 0);
                bu.a(0, array4, 4);
                this.a(br.a((byte)3, (byte)23, (short)259, array4), 3, "SEND_COP_PING_RESPONSE");
            }
            case 9: {
                if (cd.c.b()) {
                    cd.c.b("XMode.handleMessage() CMD_COP_CONNECT_TIMED_OUT");
                }
                if (this.a == 1) {
                    this.a = 2;
                    this.q = 5;
                    if (cd.c.e()) {
                        cd.c.e("XMode.handleCopConnectTimeout() COP CONNECT timed out. ");
                    }
                    this.a((byte)4, null);
                    return;
                }
                break;
            }
            case 10: {
                if (cd.c.b()) {
                    cd.c.b("XMode.handleMessage() CMD_COP_CONFIRM");
                }
                final byte[] b = bi.b(this.u, this.b);
                final byte[] array5 = new byte[4 + b.length];
                bu.a(b.length, array5, 0);
                System.arraycopy(b, 0, array5, 4, b.length);
                this.a(br.a((byte)3, (byte)23, (short)262, array5), 3, "SEND_COP_CONFIRM");
            }
            case 11: {
                this.A.a((String)bg.b);
            }
            case 12: {
                this.A.b((String)bg.b);
            }
            case 13: {
                if (cd.c.b()) {
                    cd.c.b("XMode.handleMessage() CMD_GENERATE_COP_REF_ID");
                }
                this.C = cp.a((cs)((cs)this.B).e(), "NMSP_GATEWAY", new cq() {
                    @Override
                    public final void a(final String s) {
                        cd.this.a((byte)7, s);
                    }
                });
            }
            case 14: {
                if (cd.c.b()) {
                    cd.c.b("XMode.handleMessage() CMD_SEND_LOW_PRIORITY_MSG");
                }
                this.a(null, 2, null);
            }
        }
    }
    
    public final void a(final short n, final short z) {
        if (cd.c.b()) {
            cd.c.b("XMode.connect() codec: " + z);
        }
        if (this.a != 1 && this.a != 0) {
            if (this.a == 2) {
                if (this.d != null) {
                    this.n.a(this.d);
                }
                if (this.h != null) {
                    this.n.a(this.h);
                }
                this.a("OpenSocket");
                this.o = null;
                this.v = null;
                this.b = null;
                this.w = "";
                this.y = n;
                this.z = z;
                this.a = 0;
                this.a((byte)1, null);
            }
            else if (this.a == 3) {
                this.a("OpenSocket");
                this.y = n;
                this.z = z;
                this.a = 0;
                this.a((byte)1, null);
            }
        }
    }
    
    public final void a(final byte[] array, final int i) {
        if (cd.c.b()) {
            cd.c.b("XMode.sendVapRecordMsg() audio id: " + i);
        }
        if (this.a != 1) {
            return;
        }
        final int length = array.length;
        final byte[] array2 = new byte[length + 8];
        bu.a(i, array2, 0);
        bu.a(length, array2, 4);
        System.arraycopy(array, 0, array2, 8, length);
        this.a(br.a((byte)1, (byte)18, (short)513, array2), 3, "SEND_VAP_RECORD");
    }
    
    public final void a(final byte[] array, final int n, final Object obj) {
        if (cd.c.b()) {
            cd.c.b("XMode.sendXModeMsg() " + obj + ", buffer.length:" + array.length);
        }
        if (this.h != null && this.n.a(this.h)) {
            this.h = new bq() {
                @Override
                public final void run() {
                    try {
                        cd.this.q = 3;
                        if (cd.c.e()) {
                            cd.c.e("Session Idle for too long, longer than [" + cd.this.g + "] ()");
                        }
                        cd.this.a = 2;
                        cd.this.a((byte)4, null);
                    }
                    catch (Exception ex) {
                        if (cd.c.e()) {
                            cd.c.e("XMode.sendXModeMsg() " + ex.getClass().getName() + " " + ex.getMessage());
                        }
                    }
                }
            };
            this.n.a(this.h, 1000 * this.g);
        }
        if (this.v != null && this.o != null) {
            if (n != 3 && n != 2 && (this.D.size() != 0 || this.E.size() != 0)) {
                this.E.add(new cf(array, obj));
                return;
            }
            byte[] a;
            cf cf2;
            if (n == 2) {
                final cf cf = this.E.remove();
                a = cf.a;
                cf2 = cf;
            }
            else {
                cf2 = new cf(null, obj);
                a = array;
            }
            this.D.add(cf2);
            this.v.a(this.o, a, a.length, this, cf2);
        }
        else if (n == 1) {
            this.E.add(new cf(array, obj));
        }
    }
    
    public final void b() {
        if (cd.c.b()) {
            cd.c.b("XMode.disconnect() state:" + this.a + ", socket:" + this.o);
        }
        if (this.a == 3) {
            this.q = 1;
            this.A.a(this.q, this.r);
        }
        else if (this.a != 2) {
            if (this.a == 0) {
                this.a("CloseSocket");
                this.q = 1;
                this.a = 2;
                if (this.o != null) {
                    this.v.a(this.o);
                }
            }
            else if (this.a == 1) {
                this.a = 2;
                this.q = 1;
                this.a((byte)2, null);
            }
        }
    }
    
    public final void b(final int i) {
        if (cd.c.b()) {
            cd.c.b("XMode.sendVapRecordEnd() audio id: " + i);
        }
        if (this.a != 1) {
            return;
        }
        final byte[] array = new byte[4];
        bu.a(i, array, 0);
        this.a(br.a((byte)1, (byte)18, (short)256, array), 3, "SEND_VAP_RECORD_END");
    }
}

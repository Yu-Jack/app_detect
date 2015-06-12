import java.util.List;
import java.util.Iterator;
import java.io.IOException;
import java.io.Closeable;
import java.util.Map;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;

// 
// Decompiled by Procyon v0.5.29
// 

public class ff
{
    private static final String b;
    byte[] a;
    
    static {
        b = ff.class.getSimpleName();
    }
    
    public ff(final fg fg) {
        while (true) {
        Label_0403:
            while (true) {
                int n2 = 0;
                int v = 0;
                try {
                    final ByteArrayOutputStream out = new ByteArrayOutputStream();
                    DataOutputStream dataOutputStream = new DataOutputStream(out);
                    Map p;
                    DataOutputStream dataOutputStream2;
                    String b;
                    final Throwable t;
                    List o;
                    int n;
                    List m;
                    Iterator<eq> iterator2;
                    int n3;
                    String b2;
                    Block_13_Outer:Label_0470_Outer:
                    while (true) {
                        Label_0305: {
                            try {
                                dataOutputStream.writeShort(1);
                                dataOutputStream.writeUTF(fg.a);
                                dataOutputStream.writeLong(fg.b);
                                dataOutputStream.writeLong(fg.c);
                                dataOutputStream.writeLong(fg.d);
                                dataOutputStream.writeUTF(fg.e);
                                dataOutputStream.writeUTF(fg.f);
                                dataOutputStream.writeByte(fg.g);
                                dataOutputStream.writeUTF(fg.h);
                                if (fg.i != null) {
                                    break Block_13_Outer;
                                }
                                dataOutputStream.writeBoolean(false);
                                dataOutputStream.writeInt(fg.j);
                                dataOutputStream.writeByte(-1);
                                dataOutputStream.writeByte(-1);
                                dataOutputStream.writeByte(fg.k);
                                if (fg.l == null) {
                                    dataOutputStream.writeBoolean(false);
                                    p = fg.p;
                                    dataOutputStream.writeShort(p.size());
                                    for (final Map.Entry<String, V> entry : p.entrySet()) {
                                        dataOutputStream.writeUTF(entry.getKey());
                                        dataOutputStream.writeInt(((en)entry.getValue()).a);
                                    }
                                    break Label_0305;
                                }
                                break Label_0305;
                            }
                            catch (IOException ex) {
                                dataOutputStream2 = dataOutputStream;
                                try {
                                    b = ff.b;
                                    gj.b("", ex);
                                    throw ex;
                                }
                                finally {
                                    dataOutputStream = dataOutputStream2;
                                }
                                gl.a(dataOutputStream);
                                throw t;
                                // iftrue(Label_0502:, n >= v)
                                // iftrue(Label_0453:, n2 >= o.size())
                                // iftrue(Label_0380:, !iterator2.hasNext())
                                // iftrue(Label_0545:, n3 <= 160000)
                            Label_0350:
                                while (true) {
                                Block_10:
                                    while (true) {
                                    Label_0470:
                                        while (true) {
                                            while (true) {
                                                dataOutputStream.write(o.get(n).a());
                                                ++n;
                                                break Label_0470;
                                                m = fg.m;
                                                dataOutputStream.writeShort(m.size());
                                                iterator2 = m.iterator();
                                                break Label_0350;
                                                Label_0380: {
                                                    dataOutputStream.writeBoolean(fg.q);
                                                }
                                                o = fg.o;
                                                n2 = 0;
                                                v = 0;
                                                n3 = 0;
                                                break Label_0403;
                                                continue Label_0470_Outer;
                                            }
                                            Label_0502: {
                                                dataOutputStream.writeShort(0);
                                            }
                                            dataOutputStream.writeShort(0);
                                            this.a = out.toByteArray();
                                            gl.a(dataOutputStream);
                                            return;
                                            b2 = ff.b;
                                            gj.a(5, "Error Log size exceeded. No more event details logged.");
                                            Label_0453: {
                                                break Label_0453;
                                                break Label_0470;
                                                break Block_10;
                                            }
                                            dataOutputStream.writeInt(fg.n);
                                            dataOutputStream.writeShort(v);
                                            n = 0;
                                            continue Label_0470;
                                        }
                                        n3 += o.get(n2).a().length;
                                        continue;
                                    }
                                    dataOutputStream.write(iterator2.next().a());
                                    continue Label_0350;
                                }
                                dataOutputStream.writeBoolean(true);
                                dataOutputStream.writeLong(fg.l);
                                continue Block_13_Outer;
                                dataOutputStream.writeBoolean(true);
                                dataOutputStream.writeDouble(a(fg.i.getLatitude()));
                                dataOutputStream.writeDouble(a(fg.i.getLongitude()));
                                dataOutputStream.writeFloat(fg.i.getAccuracy());
                            }
                        }
                        break;
                    }
                }
                catch (IOException ex2) {}
                Label_0545: {
                    ++v;
                }
                ++n2;
                continue Label_0403;
            }
        }
    }
    
    public ff(final byte[] a) {
        this.a = a;
    }
    
    private static double a(final double n) {
        return Math.round(n * 1000.0) / 1000.0;
    }
    
    public final byte[] a() {
        return this.a;
    }
}

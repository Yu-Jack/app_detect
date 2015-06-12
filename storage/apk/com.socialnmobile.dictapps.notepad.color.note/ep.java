import java.io.IOException;
import java.io.Closeable;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ep
{
    String a;
    private int b;
    private long c;
    private String d;
    private String e;
    private Throwable f;
    
    public ep(final int b, final long c, final String a, final String d, final String e, final Throwable f) {
        this.b = b;
        this.c = c;
        this.a = a;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public final byte[] a() {
    Label_0304_Outer:
        while (true) {
            while (true) {
                try {
                    final ByteArrayOutputStream out = new ByteArrayOutputStream();
                    final DataOutputStream dataOutputStream = new DataOutputStream(out);
                    Label_0290: {
                        try {
                            dataOutputStream.writeShort(this.b);
                            dataOutputStream.writeLong(this.c);
                            dataOutputStream.writeUTF(this.a);
                            dataOutputStream.writeUTF(this.d);
                            dataOutputStream.writeUTF(this.e);
                            if (this.f != null) {
                                if (this.a == "uncaught") {
                                    dataOutputStream.writeByte(3);
                                }
                                else {
                                    dataOutputStream.writeByte(2);
                                }
                                dataOutputStream.writeByte(2);
                                final StringBuilder sb = new StringBuilder("");
                                final String property = System.getProperty("line.separator");
                                final StackTraceElement[] stackTrace = this.f.getStackTrace();
                                for (int length = stackTrace.length, i = 0; i < length; ++i) {
                                    sb.append(stackTrace[i]);
                                    sb.append(property);
                                }
                                break Label_0290;
                            }
                            break Label_0290;
                        }
                        catch (IOException ex) {
                            final byte[] array = new byte[0];
                            gl.a(dataOutputStream);
                            return array;
                            while (true) {
                                final StringBuilder sb;
                                StackTraceElement[] stackTrace2 = null;
                                int n = 0;
                                sb.append(stackTrace2[n]);
                                final String property;
                                sb.append(property);
                                ++n;
                                Label_0218: {
                                    break Label_0218;
                                    while (true) {
                                        dataOutputStream.flush();
                                        final byte[] byteArray = out.toByteArray();
                                        gl.a(dataOutputStream);
                                        return byteArray;
                                        sb.append(property);
                                        sb.append("Caused by: ");
                                        stackTrace2 = this.f.getCause().getStackTrace();
                                        final int length2 = stackTrace2.length;
                                        n = 0;
                                        break Label_0218;
                                        final byte[] bytes;
                                        Label_0250: {
                                            bytes = sb.toString().getBytes();
                                        }
                                        dataOutputStream.writeInt(bytes.length);
                                        dataOutputStream.write(bytes);
                                        continue Label_0304_Outer;
                                        dataOutputStream.writeByte(1);
                                        dataOutputStream.writeByte(0);
                                        continue Label_0304_Outer;
                                    }
                                }
                                continue Label_0304_Outer;
                            }
                        }
                        // iftrue(Label_0250:, this.f.getCause() == null)
                        // iftrue(Label_0250:, n >= length2)
                    }
                    gl.a(dataOutputStream);
                    throw;
                }
                catch (IOException ex2) {
                    continue Label_0304_Outer;
                }
                finally {
                    final Throwable t2;
                    final Throwable t = t2;
                    final DataOutputStream dataOutputStream = null;
                    continue;
                }
                break;
            }
            break;
        }
    }
}

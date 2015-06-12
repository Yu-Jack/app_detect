// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.io.IOException;
import java.io.Closeable;
import java.io.OutputStream;
import java.io.DataOutputStream;
import java.io.ByteArrayOutputStream;

public final class da
{
    private int a;
    private long b;
    private String c;
    private String d;
    private String e;
    private Throwable f;
    
    public da(final int a, final long b, final String c, final String d, final String e, final Throwable f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public final int a() {
        return this.b().length;
    }
    
    public final byte[] b() {
        ByteArrayOutputStream out;
        DataOutputStream dataOutputStream;
        StringBuilder sb;
        String property;
        StackTraceElement[] stackTrace;
        byte[] array;
        byte[] byteArray;
        StackTraceElement[] stackTrace2;
        int n;
        int length2;
        byte[] bytes;
        Throwable t = null;
        final Throwable t2;
        Block_8_Outer:Label_0304_Outer:
        while (true) {
            while (true) {
                try {
                    out = new ByteArrayOutputStream();
                    dataOutputStream = new DataOutputStream(out);
                    Label_0290: {
                        try {
                            dataOutputStream.writeShort(this.a);
                            dataOutputStream.writeLong(this.b);
                            dataOutputStream.writeUTF(this.c);
                            dataOutputStream.writeUTF(this.d);
                            dataOutputStream.writeUTF(this.e);
                            if (this.f != null) {
                                if (this.c == "uncaught") {
                                    dataOutputStream.writeByte(3);
                                }
                                else {
                                    dataOutputStream.writeByte(2);
                                }
                                dataOutputStream.writeByte(2);
                                sb = new StringBuilder("");
                                property = System.getProperty("line.separator");
                                stackTrace = this.f.getStackTrace();
                                for (int length = stackTrace.length, i = 0; i < length; ++i) {
                                    sb.append(stackTrace[i]);
                                    sb.append(property);
                                }
                                break Label_0290;
                            }
                            break Label_0290;
                        }
                        catch (IOException ex) {
                            array = new byte[0];
                            fe.a(dataOutputStream);
                            return array;
                            // iftrue(Label_0250:, this.f.getCause() == null)
                            while (true) {
                            Label_0218:
                                while (true) {
                                    dataOutputStream.flush();
                                    byteArray = out.toByteArray();
                                    fe.a(dataOutputStream);
                                    return byteArray;
                                    sb.append(stackTrace2[n]);
                                    sb.append(property);
                                    ++n;
                                    break Label_0218;
                                    sb.append(property);
                                    sb.append("Caused by: ");
                                    stackTrace2 = this.f.getCause().getStackTrace();
                                    length2 = stackTrace2.length;
                                    n = 0;
                                    break Label_0218;
                                    dataOutputStream.writeByte(1);
                                    dataOutputStream.writeByte(0);
                                    continue Block_8_Outer;
                                    Label_0250: {
                                        bytes = sb.toString().getBytes();
                                    }
                                    dataOutputStream.writeInt(bytes.length);
                                    dataOutputStream.write(bytes);
                                    continue Block_8_Outer;
                                }
                                continue Label_0304_Outer;
                            }
                        }
                        // iftrue(Label_0250:, n >= length2)
                    }
                    fe.a(dataOutputStream);
                    throw t;
                }
                catch (IOException ex2) {
                    continue Label_0304_Outer;
                }
                finally {
                    t = t2;
                    dataOutputStream = null;
                    continue;
                }
                break;
            }
            break;
        }
    }
    
    public final String c() {
        return this.c;
    }
}

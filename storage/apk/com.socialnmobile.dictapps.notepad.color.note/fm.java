import java.io.Closeable;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.io.IOException;
import java.io.DataInputStream;
import java.util.List;

// 
// Decompiled by Procyon v0.5.29
// 

public class fm
{
    private static final String a;
    private boolean b;
    private List c;
    private long d;
    
    static {
        a = fm.class.getSimpleName();
    }
    
    public fm() {
        this.d = -1L;
    }
    
    private static String a(String string) {
        if (string != null && string.length() > 4) {
            final StringBuilder sb = new StringBuilder();
            for (int i = 0; i < -4 + string.length(); ++i) {
                sb.append('*');
            }
            sb.append(string.substring(-4 + string.length()));
            string = sb.toString();
        }
        return string;
    }
    
    private boolean a(final String anObject, final DataInputStream dataInputStream) {
        final int unsignedShort = dataInputStream.readUnsignedShort();
        final String a = fm.a;
        gj.a(3, "File version: " + unsignedShort);
        if (unsignedShort > 2) {
            final String a2 = fm.a;
            gj.a(6, "Unknown agent file version: " + unsignedShort);
            throw new IOException("Unknown agent file version: " + unsignedShort);
        }
        if (unsignedShort < 2) {
            final String a3 = fm.a;
            gj.a(5, "Deleting old file version: " + unsignedShort);
            return false;
        }
        final String utf = dataInputStream.readUTF();
        final String a4 = fm.a;
        gj.a(3, "Loading API key: " + a(anObject));
        if (utf.equals(anObject)) {
            final ArrayList<ff> c = new ArrayList<ff>();
            dataInputStream.readUTF();
            final boolean boolean1 = dataInputStream.readBoolean();
            final long long1 = dataInputStream.readLong();
            final String a5 = fm.a;
            gj.a(3, "Loading session reports");
            int i = 0;
            while (true) {
                final int unsignedShort2 = dataInputStream.readUnsignedShort();
                if (unsignedShort2 == 0) {
                    break;
                }
                final byte[] b = new byte[unsignedShort2];
                dataInputStream.readFully(b);
                c.add(0, new ff(b));
                final String a6 = fm.a;
                final StringBuilder sb = new StringBuilder("Session report added: ");
                ++i;
                gj.a(3, sb.append(i).toString());
            }
            final String a7 = fm.a;
            gj.a(3, "Persistent file loaded");
            this.b = boolean1;
            this.d = long1;
            this.c = c;
            return true;
        }
        final String a8 = fm.a;
        gj.a(3, "Api keys do not match, old: " + a(anObject) + ", new: " + a(utf));
        return false;
    }
    
    public final void a(final long d) {
        this.d = d;
    }
    
    public final void a(final DataOutputStream dataOutputStream, final String str, final String str2) {
        try {
            dataOutputStream.writeShort(46586);
            dataOutputStream.writeShort(2);
            dataOutputStream.writeUTF(str);
            dataOutputStream.writeUTF(str2);
            dataOutputStream.writeBoolean(this.b);
            dataOutputStream.writeLong(this.d);
            for (int i = -1 + this.c.size(); i >= 0; --i) {
                final byte[] a = this.c.get(i).a();
                final int length = a.length;
                if (length + 2 + dataOutputStream.size() > 50000) {
                    final String a2 = fm.a;
                    gj.a(6, "discarded sessions: " + i);
                    break;
                }
                dataOutputStream.writeShort(length);
                dataOutputStream.write(a);
            }
            dataOutputStream.writeShort(0);
        }
        catch (Throwable t) {
            final String a3 = fm.a;
            gj.b("", t);
            throw new IOException(t.getMessage());
        }
        finally {
            gl.a(dataOutputStream);
        }
    }
    
    public final void a(final List c) {
        this.c = c;
    }
    
    public final void a(final boolean b) {
        this.b = b;
    }
    
    public final boolean a() {
        return this.b;
    }
    
    public final boolean a(final DataInputStream dataInputStream, final String s) {
        try {
            final int unsignedShort = dataInputStream.readUnsignedShort();
            final String a = fm.a;
            gj.a(4, "Magic: " + unsignedShort);
            boolean a2;
            if (unsignedShort == 46586) {
                a2 = this.a(s, dataInputStream);
            }
            else {
                final String a3 = fm.a;
                gj.a(3, "Unexpected file type");
                a2 = false;
            }
            return a2;
        }
        catch (Throwable t) {
            final String a4 = fm.a;
            gj.b("Error when loading persistent file", t);
            throw new IOException(t.getMessage());
        }
        finally {
            gl.a(dataInputStream);
        }
    }
    
    public final List b() {
        return this.c;
    }
    
    public final long c() {
        return this.d;
    }
}

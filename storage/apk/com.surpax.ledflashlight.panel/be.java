import java.io.UnsupportedEncodingException;

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class be
{
    private static String[] a;
    
    static {
        be.a = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
    }
    
    private static String a(final byte b) {
        return be.a[(byte)(0xF & (byte)((byte)(b & 0xF0) >>> 4))] + be.a[(byte)(b & 0xF)];
    }
    
    public static String b(final byte[] array) {
        if (array == null) {
            return "";
        }
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 16; ++i) {
            sb.append(a(array[i]));
            if (i == 3 || i == 5 || i == 7 || i == 9) {
                sb.append("-");
            }
        }
        return sb.toString().toLowerCase();
    }
    
    private static String[] c(final byte[] array) {
        int n = array.length / 8;
        if (array.length % 8 != 0) {
            ++n;
        }
        String[] array2 = null;
    Label_0039_Outer:
        while (true) {
            array2 = new String[n];
            while (true) {
                String s;
                int n2;
                int index;
                char[] value = null;
                while (true) {
                    try {
                        s = new String(array, "ISO-8859-1");
                        n2 = 0;
                        index = 0;
                        if (n2 >= n) {
                            break;
                        }
                        value = new char[41];
                        for (int i = 0; i < value.length; ++i) {
                            value[i] = ' ';
                        }
                    }
                    catch (UnsupportedEncodingException ex) {
                        s = new String(array);
                        continue Label_0039_Outer;
                    }
                    break;
                }
                for (int n3 = 0; n3 < 8 && index < array.length; ++index, ++n3) {
                    final String a = a(array[index]);
                    value[n3 * 3] = a.charAt(0);
                    value[1 + n3 * 3] = a.charAt(1);
                    value[26 + (n3 << 1)] = s.charAt(index);
                }
                array2[n2] = new String(value);
                ++n2;
                continue;
            }
        }
        return array2;
    }
    
    public abstract void a(final Object p0);
    
    public abstract void a(final Object p0, final Throwable p1);
    
    public final void a(final byte[] array) {
        if (this.a()) {
            this.a("Buffer dump:");
            final String[] c = c(array);
            for (int i = 0; i < c.length; ++i) {
                this.a(c[i]);
            }
        }
    }
    
    public abstract boolean a();
    
    public abstract void b(final Object p0);
    
    public abstract boolean b();
    
    public abstract void c(final Object p0);
    
    public abstract boolean c();
    
    public abstract void d(final Object p0);
    
    public abstract boolean d();
    
    public abstract void e(final Object p0);
    
    public abstract boolean e();
    
    public abstract void f();
    
    public abstract void g();
}

// 
// Decompiled by Procyon v0.5.29
// 

public class bx
{
    private static final be a;
    
    static {
        a = dh.a(bx.class);
    }
    
    public static String a(final String s) {
        if (bx.a.a()) {
            bx.a.a("Escaping XML reserved tokens (&, <, >, \" and ') of: " + s);
        }
        int i = 0;
        final StringBuffer sb = new StringBuffer(s);
        while (i < sb.length()) {
            final char char1 = sb.charAt(i);
            if (char1 == '&') {
                final int offset = i + 1;
                sb.insert(offset, "amp;");
                i = offset + 4;
            }
            else if (char1 == '<') {
                sb.deleteCharAt(i);
                sb.insert(i, "&lt;");
                i += 4;
            }
            else if (char1 == '>') {
                sb.deleteCharAt(i);
                sb.insert(i, "&gt;");
                i += 4;
            }
            else if (char1 == '\"') {
                sb.deleteCharAt(i);
                sb.insert(i, "&quot;");
                i += 6;
            }
            else if (char1 == '\'') {
                sb.deleteCharAt(i);
                sb.insert(i, "&apos;");
                i += 6;
            }
            else {
                ++i;
            }
        }
        final String string = sb.toString();
        if (bx.a.a()) {
            bx.a.a("Final output: " + string);
        }
        return string;
    }
    
    public static boolean a() {
        return false;
    }
    
    public static boolean a(final am am) {
        final short a = am.a();
        return a == am.d.a() || a == am.e.a() || a == am.f.a() || a == am.g.a();
    }
    
    public static boolean b() {
        return false;
    }
    
    public static boolean b(final am am) {
        final short a = am.a();
        return a == am.a.a() || a == am.c.a() || a == am.b.a();
    }
    
    public static am c(final am am) {
        am am2;
        if (am == am.b || am == am.c) {
            am2 = am.a;
        }
        else if (am == am.e || am == am.f || am == am.h || am == am.g) {
            am2 = am.d;
        }
        else {
            am2 = am;
        }
        if (bx.a.c()) {
            bx.a.c("adjustCodecForBluetooth() " + am.a() + " -> " + am2.a());
        }
        return am2;
    }
}

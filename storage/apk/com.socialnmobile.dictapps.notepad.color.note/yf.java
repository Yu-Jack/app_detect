import java.util.ArrayList;
import java.util.Iterator;
import android.text.SpannableStringBuilder;

// 
// Decompiled by Procyon v0.5.29
// 

public final class yf extends yg
{
    public static CharSequence a(final String s) {
        final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (final jx jx : b(s)) {
            spannableStringBuilder.append((CharSequence)"\u2022");
            if (jx.a()) {
                spannableStringBuilder.append(gw.a(jx.a));
            }
            else {
                spannableStringBuilder.append((CharSequence)jx.a);
            }
            spannableStringBuilder.append('\n');
        }
        return (CharSequence)spannableStringBuilder;
    }
    
    public static String a(final ArrayList list) {
        final StringBuffer sb = new StringBuffer();
        for (final jx jx : list) {
            sb.append("[");
            if (jx.a()) {
                sb.append("V");
            }
            else {
                sb.append(" ");
            }
            sb.append("] ");
            sb.append(String.valueOf(jx.a) + "\n");
        }
        return sb.toString();
    }
    
    public static ArrayList b(final String s) {
        final ArrayList<jx> list = new ArrayList<jx>();
        if (s.trim().equals("")) {
            return list;
        }
        final String[] split = s.split("\n\\[");
        split[0] = split[0].substring(1);
        for (final String s2 : split) {
            if (s2.length() >= 3) {
                list.add(new jx(s2.substring(3).trim(), s2.charAt(0) == 'V'));
            }
        }
        return list;
    }
    
    @Override
    public final int a(final uy uy, final uy uy2) {
        if (((tw)uy2.c.d.c()).a >= ((tw)uy.c.d.c()).a) {
            return 3;
        }
        return 2;
    }
}

import android.text.util.Linkify$MatchFilter;

// 
// Decompiled by Procyon v0.5.29
// 

public final class yl implements Linkify$MatchFilter
{
    public final boolean acceptMatch(final CharSequence charSequence, int i, final int n) {
        char c = ' ';
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (i < n) {
            final char char1 = charSequence.charAt(i);
            if (Character.isDigit(char1)) {
                ++n4;
                n2 = 0;
            }
            else if (char1 == '-' || char1 == ' ' || char1 == '.') {
                if (char1 != ' ') {
                    if (c == ' ') {
                        c = char1;
                    }
                    else if (c != char1) {
                        return false;
                    }
                }
                ++n2;
                final boolean b = false;
                if (n2 > 1) {
                    return b;
                }
                n3 = 1;
            }
            ++i;
        }
        boolean b = false;
        if (n4 < 5) {
            return b;
        }
        b = false;
        if (n4 > 15) {
            return b;
        }
        b = false;
        if (n3 != 0) {
            b = true;
            return b;
        }
        return b;
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package a.a.a.c;

public final class d
{
    public static boolean a(final CharSequence charSequence) {
        if (charSequence != null) {
            for (int i = 0; i < charSequence.length(); ++i) {
                final boolean whitespace = Character.isWhitespace(charSequence.charAt(i));
                final boolean b = false;
                if (!whitespace) {
                    return b;
                }
            }
            return true;
        }
        return true;
    }
}

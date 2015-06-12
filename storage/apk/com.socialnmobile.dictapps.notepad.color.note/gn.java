import android.text.TextUtils;
import java.util.List;

// 
// Decompiled by Procyon v0.5.29
// 

public final class gn
{
    private static int a;
    private final int b;
    private final long c;
    private final String d;
    private List e;
    
    static {
        gn.a = 1;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this != o) {
            if (!(o instanceof gn)) {
                return false;
            }
            final gn gn = (gn)o;
            if (this.b != gn.b || this.c != gn.c || !TextUtils.equals((CharSequence)this.d, (CharSequence)gn.d) || (this.e != gn.e && (this.e == null || !this.e.equals(gn.e)))) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        int n = (int)(0x11 | this.b | this.c);
        if (this.d != null) {
            n |= this.d.hashCode();
        }
        if (this.e != null) {
            n |= this.e.hashCode();
        }
        return n;
    }
}

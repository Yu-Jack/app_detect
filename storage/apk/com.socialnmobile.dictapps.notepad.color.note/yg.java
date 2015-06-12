// 
// Decompiled by Procyon v0.5.29
// 

public abstract class yg
{
    public static int c(final String s) {
        if (s != null && (s.startsWith("[ ]") || s.startsWith("[V]"))) {
            return 16;
        }
        return 0;
    }
    
    public abstract int a(final uy p0, final uy p1);
}

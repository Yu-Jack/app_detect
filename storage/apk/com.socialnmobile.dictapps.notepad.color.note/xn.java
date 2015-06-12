import java.util.Arrays;

// 
// Decompiled by Procyon v0.5.29
// 

public final class xn extends Exception
{
    private static final long serialVersionUID = -1031309747423635409L;
    final int a;
    public final String b;
    public final Object c;
    
    private xn(final int n, final String s, final Object c) {
        super(String.valueOf(n) + " " + s);
        this.a = n;
        this.b = s;
        this.c = c;
    }
    
    public static xn a(final xj xj) {
        return new xn(xj.c("code").intValue(), xj.d("message"), xj.get("data"));
    }
    
    public final int a() {
        return this.a;
    }
    
    public final Object b() {
        return this.c;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        try {
            final xn xn = (xn)o;
            return Arrays.deepEquals(new Object[] { this.getClass(), this.a, this.b, this.c }, new Object[] { xn.getClass(), xn.a, xn.b, xn.c });
        }
        catch (RuntimeException ex) {
            return false;
        }
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

public final class xs extends xj
{
    private xs(final xj xj) {
        super(xj);
    }
    
    private xn b() {
        final xj j = this.j("error");
        if (j != null) {
            try {
                return xn.a(j);
            }
            catch (xg xg) {
                throw new xq(xg);
            }
            catch (xh xh) {
                throw new xq(xh);
            }
        }
        return null;
    }
    
    public static xs k(final String s) {
        final xj a = xj.a(s);
        a.h("jsonrpc");
        try {
            a.b("id");
            final xj xj = a;
            final String s2 = "result";
            xj.b(s2);
            final xj xj2 = a;
            final xs xs = new xs(xj2);
            return xs;
        }
        catch (xg xg) {
            throw new ux(xg);
        }
        try {
            final xj xj = a;
            final String s2 = "result";
            xj.b(s2);
            final xj xj2 = a;
            final xs xs2;
            final xs xs = xs2 = new xs(xj2);
            return xs2;
        }
        catch (xg xg3) {
            try {
                a.f("error");
                return new xs(a);
            }
            catch (xg xg2) {
                throw new ux(xg2);
            }
        }
    }
    
    public final Object a() {
        try {
            return this.b("result");
        }
        catch (xg xg) {
            final xn b = this.b();
            if (b != null) {
                throw b;
            }
            throw new xq("not null expected: error");
        }
    }
}

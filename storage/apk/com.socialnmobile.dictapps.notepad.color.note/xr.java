// 
// Decompiled by Procyon v0.5.29
// 

public class xr extends xj
{
    private xr(final String s) {
        this.a("jsonrpc", "2.0");
        this.a("method", s);
        this.a("id", (Object)null);
    }
    
    public xr(final String s, final xj xj) {
        this(s);
        this.a("params", xj);
    }
}

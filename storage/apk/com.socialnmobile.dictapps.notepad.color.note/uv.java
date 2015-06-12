// 
// Decompiled by Procyon v0.5.29
// 

public class uv extends vo
{
    public static final uv a;
    public static final uv b;
    public static final uv c;
    public static final uv d;
    final String e;
    
    static {
        a = new uv("access_token", "expires_in", null, "refresh_token");
        b = new uv("access_token", "expires_in", "expires_at", "refresh_token");
        c = new uv("accesstoken", "expiresin", null, "refreshtoken");
        d = new uw();
    }
    
    public uv(final String s, final String s2, final String s3, final String e) {
        super(s, s2, s3);
        this.e = e;
    }
    
    public String c(final xj xj) {
        return xj.h(this.e);
    }
}

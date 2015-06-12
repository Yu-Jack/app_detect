import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKey;

// 
// Decompiled by Procyon v0.5.29
// 

public final class up extends uo
{
    public static final up a;
    
    static {
        a = new up();
    }
    
    @Override
    public final String a() {
        return "AES128_CBC_PKCS5";
    }
    
    @Override
    public final SecretKey a(final vc vc) {
        return new SecretKeySpec(vc.a(), "AES");
    }
}

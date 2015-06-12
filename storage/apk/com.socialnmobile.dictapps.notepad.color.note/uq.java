import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKey;

// 
// Decompiled by Procyon v0.5.29
// 

public final class uq extends uo
{
    public static final uq a;
    
    static {
        a = new uq();
    }
    
    @Override
    public final String a() {
        return "AES256_CBC_PKCS5";
    }
    
    @Override
    public final SecretKey a(final vc vc) {
        return new SecretKeySpec(vc.b(), "AES");
    }
}

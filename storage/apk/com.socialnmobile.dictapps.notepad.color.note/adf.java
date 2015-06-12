import java.util.UUID;

// 
// Decompiled by Procyon v0.5.29
// 

public final class adf extends acx
{
    public static final adf a;
    
    static {
        a = new adf();
    }
    
    private static UUID b(final String s) {
        try {
            return UUID.fromString(s);
        }
        catch (IllegalArgumentException ex) {
            throw new ux("invalid UUID: " + s, ex);
        }
    }
}

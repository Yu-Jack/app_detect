// 
// Decompiled by Procyon v0.5.29
// 

public final class rx
{
    sh a;
    uc b;
    
    public rx() {
        this.a = new sh(0L, null, null, null, null, 0, null);
    }
    
    public rx(final sh a, final uc b) {
        if (a == null) {
            throw new IllegalArgumentException("account is null");
        }
        this.a = a;
        if (b == null) {
            throw new IllegalArgumentException("device is null");
        }
        this.b = b;
    }
}

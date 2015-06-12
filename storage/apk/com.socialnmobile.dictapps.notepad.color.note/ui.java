// 
// Decompiled by Procyon v0.5.29
// 

public final class ui extends tt
{
    public final String a;
    public String b;
    
    public ui(final String s) {
        this(s, null);
    }
    
    public ui(final String a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this != o) {
            if (o == null) {
                return false;
            }
            if (this.getClass() != o.getClass()) {
                return false;
            }
            final ui ui = (ui)o;
            if (this.a == null) {
                if (ui.a != null) {
                    return false;
                }
            }
            else if (!this.a.equals(ui.a)) {
                return false;
            }
            if (this.b == null) {
                if (ui.b != null) {
                    return false;
                }
            }
            else if (!this.b.equals(ui.b)) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public final int hashCode() {
        int hashCode;
        if (this.a == null) {
            hashCode = 0;
        }
        else {
            hashCode = this.a.hashCode();
        }
        final int n = 31 * (hashCode + 31);
        final String b = this.b;
        int hashCode2 = 0;
        if (b != null) {
            hashCode2 = this.b.hashCode();
        }
        return n + hashCode2;
    }
    
    @Override
    public final String toString() {
        return "EmailCredential [email=" + this.a + ", password=" + this.b + "]";
    }
}

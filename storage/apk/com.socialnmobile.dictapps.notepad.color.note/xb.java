// 
// Decompiled by Procyon v0.5.29
// 

public final class xb extends xj
{
    public xb(final int i, final int j, final int k, final int l, final int m) {
        this.a("account_notes", i);
        this.a("successful_checkins", j);
        this.a("successful_checkouts", k);
        this.a("conflicts", l);
        this.a("bad_notes", m);
    }
    
    public final int a() {
        return this.g("account_notes").intValue();
    }
    
    public final int b() {
        return this.g("successful_checkouts").intValue();
    }
}

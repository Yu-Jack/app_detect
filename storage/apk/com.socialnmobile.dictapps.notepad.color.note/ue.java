// 
// Decompiled by Procyon v0.5.29
// 

public final class ue extends adi
{
    public final tk a;
    public final ti b;
    
    public ue() {
        this.a = new tk();
        this.b = new ti();
    }
    
    public final uc a(final xj xj) {
        final tw tw = (tw)xj.a("created", tw.d);
        final tw tw2 = (tw)xj.a("last_synced", tw.d);
        final String d = xj.d("state");
        int n;
        if (d.equals("active")) {
            n = 0;
        }
        else if (d.equals("logout")) {
            n = 1;
        }
        else if (d.equals("wipeout-pending")) {
            n = 2;
        }
        else {
            if (!d.equals("wipeout-complete")) {
                throw new IllegalArgumentException("invalid DeviceState.state" + d);
            }
            n = 3;
        }
        return new uc(tw, tw2, n, (tj)xj.b("authentication", this.a), (th)xj.a("token", this.b));
    }
    
    public final void a(final uc uc, final xj xj) {
        final int c = uc.c;
        String s;
        if (c == 0) {
            s = "active";
        }
        else if (c == 1) {
            s = "logout";
        }
        else if (c == 2) {
            s = "wipeout-pending";
        }
        else {
            if (c != 3) {
                throw new IllegalArgumentException("invalid DeviceState.state: " + c);
            }
            s = "wipeout-complete";
        }
        xj.a("created", uc.a, tw.d);
        xj.a("last_synced", uc.b, tw.d);
        xj.a("state", s);
        xj.a("authentication", uc.d, this.a);
        xj.a("token", uc.e, this.b);
    }
}

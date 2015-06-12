import java.util.UUID;

// 
// Decompiled by Procyon v0.5.29
// 

public final class xw extends xr
{
    public xw(final UUID uuid, final xj xj, final long l, final xj xj2, final UUID uuid2, final tw tw, final xj xj3, final long i, final xi xi, final xi xi2) {
        final xj xj4 = new xj();
        xj4.a("apiversion", "1.1");
        xj4.a("account_id", l);
        xj4.a("device", xj2);
        xj4.a("session_id", uuid.toString());
        xj4.a("client_id", uuid2, adf.a);
        xj4.a("repository_built", tw, tw.d);
        xj4.a("identities_etags", xj3);
        xj4.a("checkout", i);
        xj4.a("checkin", xi);
        xj4.a("properties", xj);
        if (xi2 != null && xi2.size() > 0) {
            xj4.a("indications", xi2);
        }
        super("sync", xj4);
    }
}

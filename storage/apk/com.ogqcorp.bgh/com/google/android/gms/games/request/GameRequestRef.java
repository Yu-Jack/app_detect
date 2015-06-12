// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.request;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.games.Game;
import com.google.android.gms.common.data.d;

public final class GameRequestRef extends d implements GameRequest
{
    private final int c;
    
    @Override
    public int a(final String anObject) {
        for (int i = this.b; i < this.b + this.c; ++i) {
            final int a = this.a.a(i);
            if (this.a.c("recipient_external_player_id", i, a).equals(anObject)) {
                return this.a.b("recipient_status", i, a);
            }
        }
        return -1;
    }
    
    public GameRequest b() {
        return new GameRequestEntity(this);
    }
    
    @Override
    public String d() {
        return this.e("external_request_id");
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public Game e() {
        return new GameRef(this.a, this.b);
    }
    
    @Override
    public boolean equals(final Object o) {
        return GameRequestEntity.a(this, o);
    }
    
    @Override
    public Player f() {
        return new PlayerRef(this.a, this.b, "sender_");
    }
    
    @Override
    public byte[] h() {
        return this.f("data");
    }
    
    @Override
    public int hashCode() {
        return GameRequestEntity.a(this);
    }
    
    @Override
    public int i() {
        return this.c("type");
    }
    
    @Override
    public long j() {
        return this.b("creation_timestamp");
    }
    
    @Override
    public long k() {
        return this.b("expiration_timestamp");
    }
    
    @Override
    public int l() {
        return this.c("status");
    }
    
    @Override
    public List<Player> n() {
        final ArrayList<PlayerRef> list = (ArrayList<PlayerRef>)new ArrayList<Player>(this.c);
        for (int i = 0; i < this.c; ++i) {
            list.add(new PlayerRef(this.a, i + this.b, "recipient_"));
        }
        return (List<Player>)list;
    }
    
    @Override
    public String toString() {
        return GameRequestEntity.b(this);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        ((GameRequestEntity)this.b()).writeToParcel(parcel, n);
    }
}

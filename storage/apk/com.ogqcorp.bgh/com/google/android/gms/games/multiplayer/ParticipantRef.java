// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.games.Player;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.PlayerRef;
import com.google.android.gms.common.data.d;

public final class ParticipantRef extends d implements Participant
{
    private final PlayerRef c;
    
    public ParticipantRef(final DataHolder dataHolder, final int n) {
        super(dataHolder, n);
        this.c = new PlayerRef(dataHolder, n);
    }
    
    @Override
    public int b() {
        return this.c("player_status");
    }
    
    @Override
    public String c() {
        return this.e("client_address");
    }
    
    @Override
    public int d() {
        return this.c("capabilities");
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean e() {
        return this.c("connected") > 0;
    }
    
    @Override
    public boolean equals(final Object o) {
        return ParticipantEntity.a(this, o);
    }
    
    @Override
    public String f() {
        if (this.h("external_player_id")) {
            return this.e("default_display_name");
        }
        return this.c.c();
    }
    
    @Override
    public Uri g() {
        if (this.h("external_player_id")) {
            return this.g("default_display_image_uri");
        }
        return this.c.d();
    }
    
    @Override
    public String h() {
        if (this.h("external_player_id")) {
            return this.e("default_display_image_url");
        }
        return this.c.e();
    }
    
    @Override
    public int hashCode() {
        return ParticipantEntity.a(this);
    }
    
    @Override
    public Uri i() {
        if (this.h("external_player_id")) {
            return this.g("default_display_hi_res_image_uri");
        }
        return this.c.f();
    }
    
    @Override
    public String j() {
        if (this.h("external_player_id")) {
            return this.e("default_display_hi_res_image_url");
        }
        return this.c.g();
    }
    
    @Override
    public String k() {
        return this.e("external_participant_id");
    }
    
    @Override
    public Player l() {
        if (this.h("external_player_id")) {
            return null;
        }
        return this.c;
    }
    
    @Override
    public ParticipantResult m() {
        if (this.h("result_type")) {
            return null;
        }
        return new ParticipantResult(this.k(), this.c("result_type"), this.c("placing"));
    }
    
    public Participant n() {
        return new ParticipantEntity(this);
    }
    
    @Override
    public String toString() {
        return ParticipantEntity.b(this);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        ((ParticipantEntity)this.n()).writeToParcel(parcel, n);
    }
}

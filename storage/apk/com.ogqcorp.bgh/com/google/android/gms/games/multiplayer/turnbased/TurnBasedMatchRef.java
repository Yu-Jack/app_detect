// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Parcel;
import android.os.Bundle;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;
import com.google.android.gms.games.Game;
import com.google.android.gms.common.data.d;

public final class TurnBasedMatchRef extends d implements TurnBasedMatch
{
    private final Game c;
    private final int d;
    
    @Override
    public Game b() {
        return this.c;
    }
    
    @Override
    public String c() {
        return this.e("external_match_id");
    }
    
    @Override
    public String d() {
        return this.e("creator_external");
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public long e() {
        return this.b("creation_timestamp");
    }
    
    @Override
    public boolean equals(final Object o) {
        return TurnBasedMatchEntity.a(this, o);
    }
    
    @Override
    public int f() {
        return this.c("status");
    }
    
    @Override
    public int g() {
        return this.c("user_match_status");
    }
    
    @Override
    public String h() {
        return this.e("description");
    }
    
    @Override
    public int hashCode() {
        return TurnBasedMatchEntity.a(this);
    }
    
    @Override
    public int i() {
        return this.c("variant");
    }
    
    @Override
    public String j() {
        return this.e("last_updater_external");
    }
    
    @Override
    public long k() {
        return this.b("last_updated_timestamp");
    }
    
    public ArrayList<Participant> l() {
        final ArrayList<ParticipantRef> list = (ArrayList<ParticipantRef>)new ArrayList<Participant>(this.d);
        for (int i = 0; i < this.d; ++i) {
            list.add(new ParticipantRef(this.a, i + this.b));
        }
        return (ArrayList<Participant>)list;
    }
    
    @Override
    public String m() {
        return this.e("pending_participant_external");
    }
    
    @Override
    public byte[] n() {
        return this.f("data");
    }
    
    @Override
    public int o() {
        return this.c("version");
    }
    
    @Override
    public String p() {
        return this.e("rematch_id");
    }
    
    @Override
    public byte[] q() {
        return this.f("previous_match_data");
    }
    
    @Override
    public int r() {
        return this.c("match_number");
    }
    
    @Override
    public Bundle s() {
        if (!this.d("has_automatch_criteria")) {
            return null;
        }
        return com.google.android.gms.games.multiplayer.turnbased.a.a(this.c("automatch_min_players"), this.c("automatch_max_players"), this.b("automatch_bit_mask"));
    }
    
    @Override
    public int t() {
        if (!this.d("has_automatch_criteria")) {
            return 0;
        }
        return this.c("automatch_max_players");
    }
    
    @Override
    public String toString() {
        return TurnBasedMatchEntity.b(this);
    }
    
    @Override
    public boolean u() {
        return this.d("upsync_required");
    }
    
    @Override
    public String v() {
        return this.e("description_participant_id");
    }
    
    public TurnBasedMatch w() {
        return new TurnBasedMatchEntity(this);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        ((TurnBasedMatchEntity)this.w()).writeToParcel(parcel, n);
    }
}

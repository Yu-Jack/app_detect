// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import com.google.android.gms.games.multiplayer.ParticipantRef;
import com.google.android.gms.games.multiplayer.Participant;
import java.util.ArrayList;
import android.os.Bundle;
import com.google.android.gms.common.data.d;

public final class RoomRef extends d implements Room
{
    private final int c;
    
    @Override
    public String b() {
        return this.e("external_match_id");
    }
    
    @Override
    public String c() {
        return this.e("creator_external");
    }
    
    @Override
    public long d() {
        return this.b("creation_timestamp");
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public int e() {
        return this.c("status");
    }
    
    @Override
    public boolean equals(final Object o) {
        return RoomEntity.a(this, o);
    }
    
    @Override
    public String f() {
        return this.e("description");
    }
    
    @Override
    public int g() {
        return this.c("variant");
    }
    
    @Override
    public Bundle h() {
        if (!this.d("has_automatch_criteria")) {
            return null;
        }
        return com.google.android.gms.games.multiplayer.realtime.a.a(this.c("automatch_min_players"), this.c("automatch_max_players"), this.b("automatch_bit_mask"));
    }
    
    @Override
    public int hashCode() {
        return RoomEntity.a(this);
    }
    
    @Override
    public int i() {
        return this.c("automatch_wait_estimate_sec");
    }
    
    public Room j() {
        return new RoomEntity(this);
    }
    
    public ArrayList<Participant> l() {
        final ArrayList<ParticipantRef> list = (ArrayList<ParticipantRef>)new ArrayList<Participant>(this.c);
        for (int i = 0; i < this.c; ++i) {
            list.add(new ParticipantRef(this.a, i + this.b));
        }
        return (ArrayList<Participant>)list;
    }
    
    @Override
    public String toString() {
        return RoomEntity.b(this);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        ((RoomEntity)this.j()).writeToParcel(parcel, n);
    }
}

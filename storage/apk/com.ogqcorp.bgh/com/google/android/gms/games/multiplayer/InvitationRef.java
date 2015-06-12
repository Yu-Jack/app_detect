// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import java.util.ArrayList;
import com.google.android.gms.games.Game;
import com.google.android.gms.common.data.d;

public final class InvitationRef extends d implements Invitation
{
    private final Game c;
    private final ParticipantRef d;
    private final ArrayList<Participant> e;
    
    public Invitation b() {
        return new InvitationEntity(this);
    }
    
    @Override
    public Game d() {
        return this.c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public String e() {
        return this.e("external_invitation_id");
    }
    
    @Override
    public boolean equals(final Object o) {
        return InvitationEntity.a(this, o);
    }
    
    @Override
    public Participant f() {
        return this.d;
    }
    
    @Override
    public long g() {
        return Math.max(this.b("creation_timestamp"), this.b("last_modified_timestamp"));
    }
    
    @Override
    public int h() {
        return this.c("type");
    }
    
    @Override
    public int hashCode() {
        return InvitationEntity.a(this);
    }
    
    @Override
    public int i() {
        return this.c("variant");
    }
    
    @Override
    public int j() {
        if (!this.d("has_automatch_criteria")) {
            return 0;
        }
        return this.c("automatch_max_players");
    }
    
    public ArrayList<Participant> l() {
        return this.e;
    }
    
    @Override
    public String toString() {
        return InvitationEntity.b(this);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        ((InvitationEntity)this.b()).writeToParcel(parcel, n);
    }
}

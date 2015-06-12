// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.c;
import android.os.Parcel;
import java.util.Collection;
import com.google.android.gms.games.Game;
import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.gz;
import java.util.ArrayList;
import com.google.android.gms.games.GameEntity;
import android.os.Parcelable$Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class InvitationEntity extends GamesDowngradeableSafeParcel implements Invitation
{
    public static final Parcelable$Creator<InvitationEntity> CREATOR;
    private final int a;
    private final GameEntity b;
    private final String c;
    private final long d;
    private final int e;
    private final ParticipantEntity f;
    private final ArrayList<ParticipantEntity> g;
    private final int h;
    private final int i;
    
    static {
        CREATOR = (Parcelable$Creator)new a();
    }
    
    InvitationEntity(final int a, final GameEntity b, final String c, final long d, final int e, final ParticipantEntity f, final ArrayList<ParticipantEntity> g, final int h, final int i) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    InvitationEntity(final Invitation invitation) {
        this.a = 2;
        this.b = new GameEntity(invitation.d());
        this.c = invitation.e();
        this.d = invitation.g();
        this.e = invitation.h();
        this.h = invitation.i();
        this.i = invitation.j();
        final String k = invitation.f().k();
        Object o = null;
        final ArrayList<Participant> l = invitation.l();
        final int size = l.size();
        this.g = new ArrayList<ParticipantEntity>(size);
        for (int i = 0; i < size; ++i) {
            final Participant participant = l.get(i);
            if (participant.k().equals(k)) {
                o = participant;
            }
            this.g.add(((c<ParticipantEntity>)participant).a());
        }
        gz.a(o, "Must have a valid inviter!");
        this.f = ((c<ParticipantEntity>)o).a();
    }
    
    static int a(final Invitation invitation) {
        return gw.a(invitation.d(), invitation.e(), invitation.g(), invitation.h(), invitation.f(), invitation.l(), invitation.i(), invitation.j());
    }
    
    static boolean a(final Invitation invitation, final Object o) {
        boolean b = true;
        if (!(o instanceof Invitation)) {
            b = false;
        }
        else if (invitation != o) {
            final Invitation invitation2 = (Invitation)o;
            if (!gw.a(invitation2.d(), invitation.d()) || !gw.a(invitation2.e(), invitation.e()) || !gw.a((Object)invitation2.g(), invitation.g()) || !gw.a((Object)invitation2.h(), invitation.h()) || !gw.a(invitation2.f(), invitation.f()) || !gw.a(invitation2.l(), invitation.l()) || !gw.a((Object)invitation2.i(), invitation.i()) || !gw.a((Object)invitation2.j(), invitation.j())) {
                return false;
            }
        }
        return b;
    }
    
    static String b(final Invitation invitation) {
        return gw.a(invitation).a("Game", invitation.d()).a("InvitationId", invitation.e()).a("CreationTimestamp", invitation.g()).a("InvitationType", invitation.h()).a("Inviter", invitation.f()).a("Participants", invitation.l()).a("Variant", invitation.i()).a("AvailableAutoMatchSlots", invitation.j()).toString();
    }
    
    public int b() {
        return this.a;
    }
    
    public Invitation c() {
        return this;
    }
    
    @Override
    public Game d() {
        return this.b;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public String e() {
        return this.c;
    }
    
    @Override
    public boolean equals(final Object o) {
        return a(this, o);
    }
    
    @Override
    public Participant f() {
        return this.f;
    }
    
    @Override
    public long g() {
        return this.d;
    }
    
    @Override
    public int h() {
        return this.e;
    }
    
    @Override
    public int hashCode() {
        return a(this);
    }
    
    @Override
    public int i() {
        return this.h;
    }
    
    @Override
    public int j() {
        return this.i;
    }
    
    public ArrayList<Participant> l() {
        return new ArrayList<Participant>(this.g);
    }
    
    @Override
    public String toString() {
        return b(this);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (!this.C()) {
            com.google.android.gms.games.multiplayer.b.a(this, parcel, n);
        }
        else {
            this.b.writeToParcel(parcel, n);
            parcel.writeString(this.c);
            parcel.writeLong(this.d);
            parcel.writeInt(this.e);
            this.f.writeToParcel(parcel, n);
            final int size = this.g.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; ++i) {
                this.g.get(i).writeToParcel(parcel, n);
            }
        }
    }
}

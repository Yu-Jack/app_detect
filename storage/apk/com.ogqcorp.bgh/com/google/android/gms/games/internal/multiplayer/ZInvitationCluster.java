// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.internal.multiplayer;

import android.os.Parcel;
import com.google.android.gms.internal.gw;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.Game;
import java.util.Collection;
import com.google.android.gms.internal.fw;
import com.google.android.gms.games.multiplayer.InvitationEntity;
import java.util.ArrayList;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ZInvitationCluster implements SafeParcelable, Invitation
{
    public static final a CREATOR;
    private final int a;
    private final ArrayList<InvitationEntity> b;
    
    static {
        CREATOR = new a();
    }
    
    ZInvitationCluster(final int a, final ArrayList<InvitationEntity> b) {
        this.a = a;
        this.b = b;
        this.m();
    }
    
    private void m() {
        fw.a(!this.b.isEmpty());
        final InvitationEntity invitationEntity = this.b.get(0);
        for (int size = this.b.size(), i = 1; i < size; ++i) {
            fw.a(invitationEntity.f().equals(this.b.get(i).f()), "All the invitations must be from the same inviter");
        }
    }
    
    public int b() {
        return this.a;
    }
    
    public ArrayList<Invitation> c() {
        return new ArrayList<Invitation>(this.b);
    }
    
    @Override
    public Game d() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public String e() {
        return this.b.get(0).e();
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof ZInvitationCluster)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        final ZInvitationCluster zInvitationCluster = (ZInvitationCluster)o;
        if (zInvitationCluster.b.size() != this.b.size()) {
            return false;
        }
        for (int size = this.b.size(), i = 0; i < size; ++i) {
            if (!this.b.get(i).equals(zInvitationCluster.b.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public Participant f() {
        return this.b.get(0).f();
    }
    
    @Override
    public long g() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
    
    @Override
    public int h() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
    
    @Override
    public int hashCode() {
        return gw.a(this.b.toArray());
    }
    
    @Override
    public int i() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
    
    @Override
    public int j() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
    
    public Invitation k() {
        return this;
    }
    
    public ArrayList<Participant> l() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.games.internal.multiplayer.a.a(this, parcel, n);
    }
}

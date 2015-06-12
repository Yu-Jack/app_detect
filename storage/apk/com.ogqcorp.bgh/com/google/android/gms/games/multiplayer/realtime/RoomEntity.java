// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import java.util.Collection;
import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.gw;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class RoomEntity extends GamesDowngradeableSafeParcel implements Room
{
    public static final Parcelable$Creator<RoomEntity> CREATOR;
    private final int a;
    private final String b;
    private final String c;
    private final long d;
    private final int e;
    private final String f;
    private final int g;
    private final Bundle h;
    private final ArrayList<ParticipantEntity> i;
    private final int j;
    
    static {
        CREATOR = (Parcelable$Creator)new b();
    }
    
    RoomEntity(final int a, final String b, final String c, final long d, final int e, final String f, final int g, final Bundle h, final ArrayList<ParticipantEntity> i, final int j) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
    }
    
    public RoomEntity(final Room room) {
        this.a = 2;
        this.b = room.b();
        this.c = room.c();
        this.d = room.d();
        this.e = room.e();
        this.f = room.f();
        this.g = room.g();
        this.h = room.h();
        final ArrayList<Participant> l = room.l();
        final int size = l.size();
        this.i = new ArrayList<ParticipantEntity>(size);
        for (int i = 0; i < size; ++i) {
            this.i.add((ParticipantEntity)l.get(i).a());
        }
        this.j = room.i();
    }
    
    static int a(final Room room) {
        return gw.a(room.b(), room.c(), room.d(), room.e(), room.f(), room.g(), room.h(), room.l(), room.i());
    }
    
    static boolean a(final Room room, final Object o) {
        boolean b = true;
        if (!(o instanceof Room)) {
            b = false;
        }
        else if (room != o) {
            final Room room2 = (Room)o;
            if (!gw.a(room2.b(), room.b()) || !gw.a(room2.c(), room.c()) || !gw.a((Object)room2.d(), room.d()) || !gw.a((Object)room2.e(), room.e()) || !gw.a(room2.f(), room.f()) || !gw.a((Object)room2.g(), room.g()) || !gw.a(room2.h(), room.h()) || !gw.a(room2.l(), room.l()) || !gw.a((Object)room2.i(), room.i())) {
                return false;
            }
        }
        return b;
    }
    
    static String b(final Room room) {
        return gw.a(room).a("RoomId", room.b()).a("CreatorId", room.c()).a("CreationTimestamp", room.d()).a("RoomStatus", room.e()).a("Description", room.f()).a("Variant", room.g()).a("AutoMatchCriteria", room.h()).a("Participants", room.l()).a("AutoMatchWaitEstimateSeconds", room.i()).toString();
    }
    
    @Override
    public String b() {
        return this.b;
    }
    
    @Override
    public String c() {
        return this.c;
    }
    
    @Override
    public long d() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public int e() {
        return this.e;
    }
    
    @Override
    public boolean equals(final Object o) {
        return a(this, o);
    }
    
    @Override
    public String f() {
        return this.f;
    }
    
    @Override
    public int g() {
        return this.g;
    }
    
    @Override
    public Bundle h() {
        return this.h;
    }
    
    @Override
    public int hashCode() {
        return a(this);
    }
    
    @Override
    public int i() {
        return this.j;
    }
    
    public int j() {
        return this.a;
    }
    
    public Room k() {
        return this;
    }
    
    public ArrayList<Participant> l() {
        return new ArrayList<Participant>(this.i);
    }
    
    @Override
    public String toString() {
        return b(this);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (!this.C()) {
            com.google.android.gms.games.multiplayer.realtime.c.a(this, parcel, n);
        }
        else {
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            parcel.writeLong(this.d);
            parcel.writeInt(this.e);
            parcel.writeString(this.f);
            parcel.writeInt(this.g);
            parcel.writeBundle(this.h);
            final int size = this.i.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; ++i) {
                this.i.get(i).writeToParcel(parcel, n);
            }
        }
    }
}

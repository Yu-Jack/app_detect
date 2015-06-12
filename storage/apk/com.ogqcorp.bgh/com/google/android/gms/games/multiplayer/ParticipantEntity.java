// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.gw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import android.net.Uri;
import android.os.Parcelable$Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class ParticipantEntity extends GamesDowngradeableSafeParcel implements Participant
{
    public static final Parcelable$Creator<ParticipantEntity> CREATOR;
    private final int a;
    private final String b;
    private final String c;
    private final Uri d;
    private final Uri e;
    private final int f;
    private final String g;
    private final boolean h;
    private final PlayerEntity i;
    private final int j;
    private final ParticipantResult k;
    private final String l;
    private final String m;
    
    static {
        CREATOR = (Parcelable$Creator)new com.google.android.gms.games.multiplayer.c();
    }
    
    ParticipantEntity(final int a, final String b, final String c, final Uri d, final Uri e, final int f, final String g, final boolean h, final PlayerEntity i, final int j, final ParticipantResult k, final String l, final String m) {
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
        this.k = k;
        this.l = l;
        this.m = m;
    }
    
    public ParticipantEntity(final Participant participant) {
        this.a = 3;
        this.b = participant.k();
        this.c = participant.f();
        this.d = participant.g();
        this.e = participant.i();
        this.f = participant.b();
        this.g = participant.c();
        this.h = participant.e();
        final Player l = participant.l();
        PlayerEntity i;
        if (l == null) {
            i = null;
        }
        else {
            i = new PlayerEntity(l);
        }
        this.i = i;
        this.j = participant.d();
        this.k = participant.m();
        this.l = participant.h();
        this.m = participant.j();
    }
    
    static int a(final Participant participant) {
        return gw.a(participant.l(), participant.b(), participant.c(), participant.e(), participant.f(), participant.g(), participant.i(), participant.d(), participant.m(), participant.k());
    }
    
    static boolean a(final Participant participant, final Object o) {
        boolean b = true;
        if (!(o instanceof Participant)) {
            b = false;
        }
        else if (participant != o) {
            final Participant participant2 = (Participant)o;
            if (!gw.a(participant2.l(), participant.l()) || !gw.a((Object)participant2.b(), participant.b()) || !gw.a(participant2.c(), participant.c()) || !gw.a((Object)participant2.e(), participant.e()) || !gw.a(participant2.f(), participant.f()) || !gw.a(participant2.g(), participant.g()) || !gw.a(participant2.i(), participant.i()) || !gw.a((Object)participant2.d(), participant.d()) || !gw.a(participant2.m(), participant.m()) || !gw.a(participant2.k(), participant.k())) {
                return false;
            }
        }
        return b;
    }
    
    static String b(final Participant participant) {
        return gw.a(participant).a("ParticipantId", participant.k()).a("Player", participant.l()).a("Status", participant.b()).a("ClientAddress", participant.c()).a("ConnectedToRoom", participant.e()).a("DisplayName", participant.f()).a("IconImage", participant.g()).a("IconImageUrl", participant.h()).a("HiResImage", participant.i()).a("HiResImageUrl", participant.j()).a("Capabilities", participant.d()).a("Result", participant.m()).toString();
    }
    
    @Override
    public int b() {
        return this.f;
    }
    
    @Override
    public String c() {
        return this.g;
    }
    
    @Override
    public int d() {
        return this.j;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean e() {
        return this.h;
    }
    
    @Override
    public boolean equals(final Object o) {
        return a(this, o);
    }
    
    @Override
    public String f() {
        if (this.i == null) {
            return this.c;
        }
        return this.i.c();
    }
    
    @Override
    public Uri g() {
        if (this.i == null) {
            return this.d;
        }
        return this.i.d();
    }
    
    @Override
    public String h() {
        if (this.i == null) {
            return this.l;
        }
        return this.i.e();
    }
    
    @Override
    public int hashCode() {
        return a(this);
    }
    
    @Override
    public Uri i() {
        if (this.i == null) {
            return this.e;
        }
        return this.i.f();
    }
    
    @Override
    public String j() {
        if (this.i == null) {
            return this.m;
        }
        return this.i.g();
    }
    
    @Override
    public String k() {
        return this.b;
    }
    
    @Override
    public Player l() {
        return this.i;
    }
    
    @Override
    public ParticipantResult m() {
        return this.k;
    }
    
    public int n() {
        return this.a;
    }
    
    public Participant o() {
        return this;
    }
    
    @Override
    public String toString() {
        return b(this);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (!this.C()) {
            com.google.android.gms.games.multiplayer.d.a(this, parcel, n);
        }
        else {
            parcel.writeString(this.b);
            parcel.writeString(this.c);
            String string;
            if (this.d == null) {
                string = null;
            }
            else {
                string = this.d.toString();
            }
            parcel.writeString(string);
            final Uri e = this.e;
            String string2 = null;
            if (e != null) {
                string2 = this.e.toString();
            }
            parcel.writeString(string2);
            parcel.writeInt(this.f);
            parcel.writeString(this.g);
            int n2;
            if (this.h) {
                n2 = 1;
            }
            else {
                n2 = 0;
            }
            parcel.writeInt(n2);
            final PlayerEntity i = this.i;
            int n3 = 0;
            if (i != null) {
                n3 = 1;
            }
            parcel.writeInt(n3);
            if (this.i != null) {
                this.i.writeToParcel(parcel, n);
            }
        }
    }
}

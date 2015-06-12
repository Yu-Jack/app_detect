// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Parcel;
import java.util.Collection;
import com.google.android.gms.games.Game;
import com.google.android.gms.internal.gw;
import com.google.android.gms.games.multiplayer.Participant;
import android.os.Bundle;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class TurnBasedMatchEntity implements SafeParcelable, TurnBasedMatch
{
    public static final b CREATOR;
    private final int b;
    private final GameEntity c;
    private final String d;
    private final String e;
    private final long f;
    private final String g;
    private final long h;
    private final String i;
    private final int j;
    private final int k;
    private final int l;
    private final byte[] m;
    private final ArrayList<ParticipantEntity> n;
    private final String o;
    private final byte[] p;
    private final int q;
    private final Bundle r;
    private final int s;
    private final boolean t;
    private final String u;
    private final String v;
    
    static {
        CREATOR = new b();
    }
    
    TurnBasedMatchEntity(final int b, final GameEntity c, final String d, final String e, final long f, final String g, final long h, final String i, final int j, final int k, final int l, final byte[] m, final ArrayList<ParticipantEntity> n, final String o, final byte[] p21, final int q, final Bundle r, final int s, final boolean t, final String u, final String v) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.s = s;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
        this.o = o;
        this.p = p21;
        this.q = q;
        this.r = r;
        this.t = t;
        this.u = u;
        this.v = v;
    }
    
    public TurnBasedMatchEntity(final TurnBasedMatch turnBasedMatch) {
        this.b = 2;
        this.c = new GameEntity(turnBasedMatch.b());
        this.d = turnBasedMatch.c();
        this.e = turnBasedMatch.d();
        this.f = turnBasedMatch.e();
        this.g = turnBasedMatch.j();
        this.h = turnBasedMatch.k();
        this.i = turnBasedMatch.m();
        this.j = turnBasedMatch.f();
        this.s = turnBasedMatch.g();
        this.k = turnBasedMatch.i();
        this.l = turnBasedMatch.o();
        this.o = turnBasedMatch.p();
        this.q = turnBasedMatch.r();
        this.r = turnBasedMatch.s();
        this.t = turnBasedMatch.u();
        this.u = turnBasedMatch.h();
        this.v = turnBasedMatch.v();
        final byte[] n = turnBasedMatch.n();
        if (n == null) {
            this.m = null;
        }
        else {
            System.arraycopy(n, 0, this.m = new byte[n.length], 0, n.length);
        }
        final byte[] q = turnBasedMatch.q();
        if (q == null) {
            this.p = null;
        }
        else {
            System.arraycopy(q, 0, this.p = new byte[q.length], 0, q.length);
        }
        final ArrayList<Participant> l = turnBasedMatch.l();
        final int size = l.size();
        this.n = new ArrayList<ParticipantEntity>(size);
        for (int i = 0; i < size; ++i) {
            this.n.add((ParticipantEntity)l.get(i).a());
        }
    }
    
    static int a(final TurnBasedMatch turnBasedMatch) {
        return gw.a(turnBasedMatch.b(), turnBasedMatch.c(), turnBasedMatch.d(), turnBasedMatch.e(), turnBasedMatch.j(), turnBasedMatch.k(), turnBasedMatch.m(), turnBasedMatch.f(), turnBasedMatch.g(), turnBasedMatch.h(), turnBasedMatch.i(), turnBasedMatch.o(), turnBasedMatch.l(), turnBasedMatch.p(), turnBasedMatch.r(), turnBasedMatch.s(), turnBasedMatch.t(), turnBasedMatch.u());
    }
    
    static boolean a(final TurnBasedMatch turnBasedMatch, final Object o) {
        boolean b = true;
        if (!(o instanceof TurnBasedMatch)) {
            b = false;
        }
        else if (turnBasedMatch != o) {
            final TurnBasedMatch turnBasedMatch2 = (TurnBasedMatch)o;
            if (!gw.a(turnBasedMatch2.b(), turnBasedMatch.b()) || !gw.a(turnBasedMatch2.c(), turnBasedMatch.c()) || !gw.a(turnBasedMatch2.d(), turnBasedMatch.d()) || !gw.a((Object)turnBasedMatch2.e(), turnBasedMatch.e()) || !gw.a(turnBasedMatch2.j(), turnBasedMatch.j()) || !gw.a((Object)turnBasedMatch2.k(), turnBasedMatch.k()) || !gw.a(turnBasedMatch2.m(), turnBasedMatch.m()) || !gw.a((Object)turnBasedMatch2.f(), turnBasedMatch.f()) || !gw.a((Object)turnBasedMatch2.g(), turnBasedMatch.g()) || !gw.a(turnBasedMatch2.h(), turnBasedMatch.h()) || !gw.a((Object)turnBasedMatch2.i(), turnBasedMatch.i()) || !gw.a((Object)turnBasedMatch2.o(), turnBasedMatch.o()) || !gw.a(turnBasedMatch2.l(), turnBasedMatch.l()) || !gw.a(turnBasedMatch2.p(), turnBasedMatch.p()) || !gw.a((Object)turnBasedMatch2.r(), turnBasedMatch.r()) || !gw.a(turnBasedMatch2.s(), turnBasedMatch.s()) || !gw.a((Object)turnBasedMatch2.t(), turnBasedMatch.t()) || !gw.a((Object)turnBasedMatch2.u(), turnBasedMatch.u())) {
                return false;
            }
        }
        return b;
    }
    
    static String b(final TurnBasedMatch turnBasedMatch) {
        return gw.a(turnBasedMatch).a("Game", turnBasedMatch.b()).a("MatchId", turnBasedMatch.c()).a("CreatorId", turnBasedMatch.d()).a("CreationTimestamp", turnBasedMatch.e()).a("LastUpdaterId", turnBasedMatch.j()).a("LastUpdatedTimestamp", turnBasedMatch.k()).a("PendingParticipantId", turnBasedMatch.m()).a("MatchStatus", turnBasedMatch.f()).a("TurnStatus", turnBasedMatch.g()).a("Description", turnBasedMatch.h()).a("Variant", turnBasedMatch.i()).a("Data", turnBasedMatch.n()).a("Version", turnBasedMatch.o()).a("Participants", turnBasedMatch.l()).a("RematchId", turnBasedMatch.p()).a("PreviousData", turnBasedMatch.q()).a("MatchNumber", turnBasedMatch.r()).a("AutoMatchCriteria", turnBasedMatch.s()).a("AvailableAutoMatchSlots", turnBasedMatch.t()).a("LocallyModified", turnBasedMatch.u()).a("DescriptionParticipantId", turnBasedMatch.v()).toString();
    }
    
    @Override
    public Game b() {
        return this.c;
    }
    
    @Override
    public String c() {
        return this.d;
    }
    
    @Override
    public String d() {
        return this.e;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public long e() {
        return this.f;
    }
    
    @Override
    public boolean equals(final Object o) {
        return a(this, o);
    }
    
    @Override
    public int f() {
        return this.j;
    }
    
    @Override
    public int g() {
        return this.s;
    }
    
    @Override
    public String h() {
        return this.u;
    }
    
    @Override
    public int hashCode() {
        return a(this);
    }
    
    @Override
    public int i() {
        return this.k;
    }
    
    @Override
    public String j() {
        return this.g;
    }
    
    @Override
    public long k() {
        return this.h;
    }
    
    public ArrayList<Participant> l() {
        return new ArrayList<Participant>(this.n);
    }
    
    @Override
    public String m() {
        return this.i;
    }
    
    @Override
    public byte[] n() {
        return this.m;
    }
    
    @Override
    public int o() {
        return this.l;
    }
    
    @Override
    public String p() {
        return this.o;
    }
    
    @Override
    public byte[] q() {
        return this.p;
    }
    
    @Override
    public int r() {
        return this.q;
    }
    
    @Override
    public Bundle s() {
        return this.r;
    }
    
    @Override
    public int t() {
        if (this.r == null) {
            return 0;
        }
        return this.r.getInt("max_automatch_players");
    }
    
    @Override
    public String toString() {
        return b(this);
    }
    
    @Override
    public boolean u() {
        return this.t;
    }
    
    @Override
    public String v() {
        return this.v;
    }
    
    public int w() {
        return this.b;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.games.multiplayer.turnbased.b.a(this, parcel, n);
    }
    
    public TurnBasedMatch x() {
        return this;
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.gw;
import android.net.Uri;
import android.os.Parcelable$Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class GameEntity extends GamesDowngradeableSafeParcel implements Game
{
    public static final Parcelable$Creator<GameEntity> CREATOR;
    private final int a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final Uri h;
    private final Uri i;
    private final Uri j;
    private final boolean k;
    private final boolean l;
    private final String m;
    private final int n;
    private final int o;
    private final int p;
    private final boolean q;
    private final boolean r;
    private final String s;
    private final String t;
    private final String u;
    private final boolean v;
    private final boolean w;
    
    static {
        CREATOR = (Parcelable$Creator)new a();
    }
    
    GameEntity(final int a, final String b, final String c, final String d, final String e, final String f, final String g, final Uri h, final Uri i, final Uri j, final boolean k, final boolean l, final String m, final int n, final int o, final int p23, final boolean q, final boolean r, final String s, final String t, final String u, final boolean v, final boolean w) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.s = s;
        this.i = i;
        this.t = t;
        this.j = j;
        this.u = u;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
        this.o = o;
        this.p = p23;
        this.q = q;
        this.r = r;
        this.v = v;
        this.w = w;
    }
    
    public GameEntity(final Game game) {
        this.a = 3;
        this.b = game.b();
        this.d = game.d();
        this.e = game.e();
        this.f = game.f();
        this.g = game.g();
        this.c = game.c();
        this.h = game.h();
        this.s = game.i();
        this.i = game.j();
        this.t = game.k();
        this.j = game.l();
        this.u = game.m();
        this.k = game.n();
        this.l = game.q();
        this.m = game.r();
        this.n = game.s();
        this.o = game.t();
        this.p = game.u();
        this.q = game.v();
        this.r = game.w();
        this.v = game.o();
        this.w = game.p();
    }
    
    static int a(final Game game) {
        return gw.a(game.b(), game.c(), game.d(), game.e(), game.f(), game.g(), game.h(), game.j(), game.l(), game.n(), game.q(), game.r(), game.s(), game.t(), game.u(), game.v(), game.w(), game.o(), game.p());
    }
    
    static boolean a(final Game game, final Object o) {
        boolean b = true;
        if (!(o instanceof Game)) {
            b = false;
        }
        else if (game != o) {
            final Game game2 = (Game)o;
            if (!gw.a(game2.b(), game.b()) || !gw.a(game2.c(), game.c()) || !gw.a(game2.d(), game.d()) || !gw.a(game2.e(), game.e()) || !gw.a(game2.f(), game.f()) || !gw.a(game2.g(), game.g()) || !gw.a(game2.h(), game.h()) || !gw.a(game2.j(), game.j()) || !gw.a(game2.l(), game.l()) || !gw.a((Object)game2.n(), game.n()) || !gw.a((Object)game2.q(), game.q()) || !gw.a(game2.r(), game.r()) || !gw.a((Object)game2.s(), game.s()) || !gw.a((Object)game2.t(), game.t()) || !gw.a((Object)game2.u(), game.u()) || !gw.a((Object)game2.v(), game.v()) || !gw.a((Object)game2.w(), game.w() && gw.a((Object)game2.o(), game.o()) && gw.a((Object)game2.p(), game.p()) && b)) {
                return false;
            }
        }
        return b;
    }
    
    static String b(final Game game) {
        return gw.a(game).a("ApplicationId", game.b()).a("DisplayName", game.c()).a("PrimaryCategory", game.d()).a("SecondaryCategory", game.e()).a("Description", game.f()).a("DeveloperName", game.g()).a("IconImageUri", game.h()).a("IconImageUrl", game.i()).a("HiResImageUri", game.j()).a("HiResImageUrl", game.k()).a("FeaturedImageUri", game.l()).a("FeaturedImageUrl", game.m()).a("PlayEnabledGame", game.n()).a("InstanceInstalled", game.q()).a("InstancePackageName", game.r()).a("AchievementTotalCount", game.t()).a("LeaderboardCount", game.u()).a("RealTimeMultiplayerEnabled", game.v()).a("TurnBasedMultiplayerEnabled", game.w()).toString();
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
    public String d() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public String e() {
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
    public String g() {
        return this.g;
    }
    
    @Override
    public Uri h() {
        return this.h;
    }
    
    @Override
    public int hashCode() {
        return a(this);
    }
    
    @Override
    public String i() {
        return this.s;
    }
    
    @Override
    public Uri j() {
        return this.i;
    }
    
    @Override
    public String k() {
        return this.t;
    }
    
    @Override
    public Uri l() {
        return this.j;
    }
    
    @Override
    public String m() {
        return this.u;
    }
    
    @Override
    public boolean n() {
        return this.k;
    }
    
    @Override
    public boolean o() {
        return this.v;
    }
    
    @Override
    public boolean p() {
        return this.w;
    }
    
    @Override
    public boolean q() {
        return this.l;
    }
    
    @Override
    public String r() {
        return this.m;
    }
    
    @Override
    public int s() {
        return this.n;
    }
    
    @Override
    public int t() {
        return this.o;
    }
    
    @Override
    public String toString() {
        return b(this);
    }
    
    @Override
    public int u() {
        return this.p;
    }
    
    @Override
    public boolean v() {
        return this.q;
    }
    
    @Override
    public boolean w() {
        return this.r;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        int n2 = 1;
        if (!this.C()) {
            com.google.android.gms.games.b.a(this, parcel, n);
            return;
        }
        parcel.writeString(this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        String string;
        if (this.h == null) {
            string = null;
        }
        else {
            string = this.h.toString();
        }
        parcel.writeString(string);
        String string2;
        if (this.i == null) {
            string2 = null;
        }
        else {
            string2 = this.i.toString();
        }
        parcel.writeString(string2);
        final Uri j = this.j;
        String string3 = null;
        if (j != null) {
            string3 = this.j.toString();
        }
        parcel.writeString(string3);
        int n3;
        if (this.k) {
            n3 = n2;
        }
        else {
            n3 = 0;
        }
        parcel.writeInt(n3);
        if (!this.l) {
            n2 = 0;
        }
        parcel.writeInt(n2);
        parcel.writeString(this.m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o);
        parcel.writeInt(this.p);
    }
    
    public int x() {
        return this.a;
    }
    
    public Game y() {
        return this;
    }
}

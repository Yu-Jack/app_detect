// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import java.util.Collection;
import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.gw;
import com.google.android.gms.games.Game;
import java.util.ArrayList;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class ExtendedGameEntity extends GamesDowngradeableSafeParcel implements ExtendedGame
{
    public static final b CREATOR;
    private final int a;
    private final GameEntity b;
    private final int c;
    private final boolean d;
    private final int e;
    private final long f;
    private final long g;
    private final String h;
    private final long i;
    private final String j;
    private final ArrayList<GameBadgeEntity> k;
    
    static {
        CREATOR = new a();
    }
    
    ExtendedGameEntity(final int a, final GameEntity b, final int c, final boolean d, final int e, final long f, final long g, final String h, final long i, final String j, final ArrayList<GameBadgeEntity> k) {
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
    }
    
    public ExtendedGameEntity(final ExtendedGame extendedGame) {
        this.a = 1;
        final Game b = extendedGame.b();
        GameEntity b2;
        if (b == null) {
            b2 = null;
        }
        else {
            b2 = new GameEntity(b);
        }
        this.b = b2;
        this.c = extendedGame.d();
        this.d = extendedGame.e();
        this.e = extendedGame.f();
        this.f = extendedGame.g();
        this.g = extendedGame.h();
        this.h = extendedGame.i();
        this.i = extendedGame.j();
        this.j = extendedGame.k();
        final ArrayList<GameBadge> c = extendedGame.c();
        final int size = c.size();
        this.k = new ArrayList<GameBadgeEntity>(size);
        for (int i = 0; i < size; ++i) {
            this.k.add((GameBadgeEntity)c.get(i).a());
        }
    }
    
    static int a(final ExtendedGame extendedGame) {
        return gw.a(extendedGame.b(), extendedGame.d(), extendedGame.e(), extendedGame.f(), extendedGame.g(), extendedGame.h(), extendedGame.i(), extendedGame.j(), extendedGame.k());
    }
    
    static boolean a(final ExtendedGame extendedGame, final Object o) {
        boolean b = true;
        if (!(o instanceof ExtendedGame)) {
            b = false;
        }
        else if (extendedGame != o) {
            final ExtendedGame extendedGame2 = (ExtendedGame)o;
            if (!gw.a(extendedGame2.b(), extendedGame.b()) || !gw.a((Object)extendedGame2.d(), extendedGame.d()) || !gw.a((Object)extendedGame2.e(), extendedGame.e()) || !gw.a((Object)extendedGame2.f(), extendedGame.f()) || !gw.a((Object)extendedGame2.g(), extendedGame.g()) || !gw.a((Object)extendedGame2.h(), extendedGame.h()) || !gw.a(extendedGame2.i(), extendedGame.i()) || !gw.a((Object)extendedGame2.j(), extendedGame.j()) || !gw.a(extendedGame2.k(), extendedGame.k())) {
                return false;
            }
        }
        return b;
    }
    
    static String b(final ExtendedGame extendedGame) {
        return gw.a(extendedGame).a("Game", extendedGame.b()).a("Availability", extendedGame.d()).a("Owned", extendedGame.e()).a("AchievementUnlockedCount", extendedGame.f()).a("LastPlayedServerTimestamp", extendedGame.g()).a("PriceMicros", extendedGame.h()).a("FormattedPrice", extendedGame.i()).a("FullPriceMicros", extendedGame.j()).a("FormattedFullPrice", extendedGame.k()).toString();
    }
    
    @Override
    public ArrayList<GameBadge> c() {
        return new ArrayList<GameBadge>(this.k);
    }
    
    @Override
    public int d() {
        return this.c;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean e() {
        return this.d;
    }
    
    @Override
    public boolean equals(final Object o) {
        return a(this, o);
    }
    
    @Override
    public int f() {
        return this.e;
    }
    
    @Override
    public long g() {
        return this.f;
    }
    
    @Override
    public long h() {
        return this.g;
    }
    
    @Override
    public int hashCode() {
        return a(this);
    }
    
    @Override
    public String i() {
        return this.h;
    }
    
    @Override
    public long j() {
        return this.i;
    }
    
    @Override
    public String k() {
        return this.j;
    }
    
    public int l() {
        return this.a;
    }
    
    public GameEntity m() {
        return this.b;
    }
    
    public ExtendedGame n() {
        return this;
    }
    
    @Override
    public String toString() {
        return b(this);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        int i = 0;
        if (!this.C()) {
            com.google.android.gms.games.internal.game.b.a(this, parcel, n);
        }
        else {
            this.b.writeToParcel(parcel, n);
            parcel.writeInt(this.c);
            int n2;
            if (this.d) {
                n2 = 1;
            }
            else {
                n2 = 0;
            }
            parcel.writeInt(n2);
            parcel.writeInt(this.e);
            parcel.writeLong(this.f);
            parcel.writeLong(this.g);
            parcel.writeString(this.h);
            parcel.writeLong(this.i);
            parcel.writeString(this.j);
            final int size = this.k.size();
            parcel.writeInt(size);
            while (i < size) {
                this.k.get(i).writeToParcel(parcel, n);
                ++i;
            }
        }
    }
}

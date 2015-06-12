// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import java.util.ArrayList;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import com.google.android.gms.common.data.d;

public class ExtendedGameRef extends d implements ExtendedGame
{
    private final GameRef c;
    private final int d;
    
    @Override
    public Game b() {
        return this.c;
    }
    
    @Override
    public ArrayList<GameBadge> c() {
        int i = 0;
        if (this.a.c("badge_title", this.b, this.a.a(this.b)) == null) {
            return new ArrayList<GameBadge>(0);
        }
        final ArrayList<GameBadgeRef> list = (ArrayList<GameBadgeRef>)new ArrayList<GameBadge>(this.d);
        while (i < this.d) {
            list.add(new GameBadgeRef(this.a, i + this.b));
            ++i;
        }
        return (ArrayList<GameBadge>)list;
    }
    
    @Override
    public int d() {
        return this.c("availability");
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public boolean e() {
        return this.d("owned");
    }
    
    @Override
    public boolean equals(final Object o) {
        return ExtendedGameEntity.a(this, o);
    }
    
    @Override
    public int f() {
        return this.c("achievement_unlocked_count");
    }
    
    @Override
    public long g() {
        return this.b("last_played_server_time");
    }
    
    @Override
    public long h() {
        return this.b("price_micros");
    }
    
    @Override
    public int hashCode() {
        return ExtendedGameEntity.a(this);
    }
    
    @Override
    public String i() {
        return this.e("formatted_price");
    }
    
    @Override
    public long j() {
        return this.b("full_price_micros");
    }
    
    @Override
    public String k() {
        return this.e("formatted_full_price");
    }
    
    public ExtendedGame l() {
        return new ExtendedGameEntity(this);
    }
    
    @Override
    public String toString() {
        return ExtendedGameEntity.b(this);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        ((ExtendedGameEntity)this.l()).writeToParcel(parcel, n);
    }
}

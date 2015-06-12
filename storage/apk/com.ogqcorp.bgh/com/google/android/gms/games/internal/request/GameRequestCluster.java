// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import java.util.List;
import com.google.android.gms.internal.gw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.Game;
import java.util.Collection;
import com.google.android.gms.internal.fw;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GameRequestCluster implements SafeParcelable, GameRequest
{
    public static final a CREATOR;
    private final int a;
    private final ArrayList<GameRequestEntity> b;
    
    static {
        CREATOR = new a();
    }
    
    GameRequestCluster(final int a, final ArrayList<GameRequestEntity> b) {
        this.a = a;
        this.b = b;
        this.o();
    }
    
    private void o() {
        fw.a(!this.b.isEmpty());
        final GameRequestEntity gameRequestEntity = this.b.get(0);
        for (int size = this.b.size(), i = 1; i < size; ++i) {
            final GameRequestEntity gameRequestEntity2 = this.b.get(i);
            fw.a(gameRequestEntity.i() == gameRequestEntity2.i(), "All the requests must be of the same type");
            fw.a(gameRequestEntity.f().equals(gameRequestEntity2.f()), "All the requests must be from the same sender");
        }
    }
    
    @Override
    public int a(final String s) {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
    
    public int b() {
        return this.a;
    }
    
    public ArrayList<GameRequest> c() {
        return new ArrayList<GameRequest>(this.b);
    }
    
    @Override
    public String d() {
        return this.b.get(0).d();
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public Game e() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof GameRequestCluster)) {
            return false;
        }
        if (this == o) {
            return true;
        }
        final GameRequestCluster gameRequestCluster = (GameRequestCluster)o;
        if (gameRequestCluster.b.size() != this.b.size()) {
            return false;
        }
        for (int size = this.b.size(), i = 0; i < size; ++i) {
            if (!this.b.get(i).equals(gameRequestCluster.b.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public Player f() {
        return this.b.get(0).f();
    }
    
    public ArrayList<Player> g() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
    
    @Override
    public byte[] h() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
    
    @Override
    public int hashCode() {
        return gw.a(this.b.toArray());
    }
    
    @Override
    public int i() {
        return this.b.get(0).i();
    }
    
    @Override
    public long j() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
    
    @Override
    public long k() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
    
    @Override
    public int l() {
        throw new UnsupportedOperationException("Method not supported on a cluster");
    }
    
    public GameRequest m() {
        return this;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.games.internal.request.a.a(this, parcel, n);
    }
}

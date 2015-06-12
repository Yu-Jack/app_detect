// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.request;

import android.os.Parcel;
import java.util.Collection;
import com.google.android.gms.games.Game;
import java.util.Arrays;
import com.google.android.gms.internal.gw;
import java.util.List;
import com.google.android.gms.games.Player;
import android.os.Bundle;
import java.util.ArrayList;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class GameRequestEntity implements SafeParcelable, GameRequest
{
    public static final a CREATOR;
    private final int a;
    private final GameEntity b;
    private final PlayerEntity c;
    private final byte[] d;
    private final String e;
    private final ArrayList<PlayerEntity> f;
    private final int g;
    private final long h;
    private final long i;
    private final Bundle j;
    private final int k;
    
    static {
        CREATOR = new a();
    }
    
    GameRequestEntity(final int a, final GameEntity b, final PlayerEntity c, final byte[] d, final String e, final ArrayList<PlayerEntity> f, final int g, final long h, final long i, final Bundle j, final int k) {
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
    
    public GameRequestEntity(final GameRequest gameRequest) {
        this.a = 2;
        this.b = new GameEntity(gameRequest.e());
        this.c = new PlayerEntity(gameRequest.f());
        this.e = gameRequest.d();
        this.g = gameRequest.i();
        this.h = gameRequest.j();
        this.i = gameRequest.k();
        this.k = gameRequest.l();
        final byte[] h = gameRequest.h();
        if (h == null) {
            this.d = null;
        }
        else {
            System.arraycopy(h, 0, this.d = new byte[h.length], 0, h.length);
        }
        final List<Player> n = gameRequest.n();
        final int size = n.size();
        this.f = new ArrayList<PlayerEntity>(size);
        this.j = new Bundle();
        for (int i = 0; i < size; ++i) {
            final Player player = n.get(i).a();
            final String b = player.b();
            this.f.add((PlayerEntity)player);
            this.j.putInt(b, gameRequest.a(b));
        }
    }
    
    static int a(final GameRequest gameRequest) {
        return gw.a(gameRequest.e(), gameRequest.n(), gameRequest.d(), gameRequest.f(), c(gameRequest), gameRequest.i(), gameRequest.j(), gameRequest.k());
    }
    
    static boolean a(final GameRequest gameRequest, final Object o) {
        boolean b = true;
        if (!(o instanceof GameRequest)) {
            b = false;
        }
        else if (gameRequest != o) {
            final GameRequest gameRequest2 = (GameRequest)o;
            if (!gw.a(gameRequest2.e(), gameRequest.e()) || !gw.a(gameRequest2.n(), gameRequest.n()) || !gw.a(gameRequest2.d(), gameRequest.d()) || !gw.a(gameRequest2.f(), gameRequest.f()) || !Arrays.equals(c(gameRequest2), c(gameRequest)) || !gw.a((Object)gameRequest2.i(), gameRequest.i()) || !gw.a((Object)gameRequest2.j(), gameRequest.j()) || !gw.a((Object)gameRequest2.k(), gameRequest.k())) {
                return false;
            }
        }
        return b;
    }
    
    static String b(final GameRequest gameRequest) {
        return gw.a(gameRequest).a("Game", gameRequest.e()).a("Sender", gameRequest.f()).a("Recipients", gameRequest.n()).a("Data", gameRequest.h()).a("RequestId", gameRequest.d()).a("Type", gameRequest.i()).a("CreationTimestamp", gameRequest.j()).a("ExpirationTimestamp", gameRequest.k()).toString();
    }
    
    private static int[] c(final GameRequest gameRequest) {
        final List<Player> n = gameRequest.n();
        final int size = n.size();
        final int[] array = new int[size];
        for (int i = 0; i < size; ++i) {
            array[i] = gameRequest.a(n.get(i).b());
        }
        return array;
    }
    
    @Override
    public int a(final String s) {
        return this.j.getInt(s, 0);
    }
    
    public int b() {
        return this.a;
    }
    
    public Bundle c() {
        return this.j;
    }
    
    @Override
    public String d() {
        return this.e;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public Game e() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        return a(this, o);
    }
    
    @Override
    public Player f() {
        return this.c;
    }
    
    public GameRequest g() {
        return this;
    }
    
    @Override
    public byte[] h() {
        return this.d;
    }
    
    @Override
    public int hashCode() {
        return a(this);
    }
    
    @Override
    public int i() {
        return this.g;
    }
    
    @Override
    public long j() {
        return this.h;
    }
    
    @Override
    public long k() {
        return this.i;
    }
    
    @Override
    public int l() {
        return this.k;
    }
    
    @Override
    public List<Player> n() {
        return new ArrayList<Player>(this.f);
    }
    
    @Override
    public String toString() {
        return b(this);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        com.google.android.gms.games.request.a.a(this, parcel, n);
    }
}

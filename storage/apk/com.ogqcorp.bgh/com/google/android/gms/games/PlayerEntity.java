// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.internal.fe;
import com.google.android.gms.internal.gw;
import com.google.android.gms.internal.fw;
import android.net.Uri;
import android.os.Parcelable$Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player
{
    public static final Parcelable$Creator<PlayerEntity> CREATOR;
    private final int a;
    private final String b;
    private final String c;
    private final Uri d;
    private final Uri e;
    private final long f;
    private final int g;
    private final long h;
    private final String i;
    private final String j;
    
    static {
        CREATOR = (Parcelable$Creator)new com.google.android.gms.games.c();
    }
    
    PlayerEntity(final int a, final String b, final String c, final Uri d, final Uri e, final long f, final int g, final long h, final String i, final String j) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.i = i;
        this.e = e;
        this.j = j;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    public PlayerEntity(final Player player) {
        this.a = 4;
        this.b = player.b();
        this.c = player.c();
        this.d = player.d();
        this.i = player.e();
        this.e = player.f();
        this.j = player.g();
        this.f = player.h();
        this.g = player.j();
        this.h = player.i();
        fw.a((Object)this.b);
        fw.a((Object)this.c);
        fw.a(this.f > 0L);
    }
    
    static int a(final Player player) {
        return gw.a(player.b(), player.c(), player.d(), player.f(), player.h());
    }
    
    static boolean a(final Player player, final Object o) {
        boolean b = true;
        if (!(o instanceof Player)) {
            b = false;
        }
        else if (player != o) {
            final Player player2 = (Player)o;
            if (!gw.a(player2.b(), player.b()) || !gw.a(player2.c(), player.c()) || !gw.a(player2.d(), player.d()) || !gw.a(player2.f(), player.f()) || !gw.a((Object)player2.h(), player.h())) {
                return false;
            }
        }
        return b;
    }
    
    static String b(final Player player) {
        return gw.a(player).a("PlayerId", player.b()).a("DisplayName", player.c()).a("IconImageUri", player.d()).a("IconImageUrl", player.e()).a("HiResImageUri", player.f()).a("HiResImageUrl", player.g()).a("RetrievedTimestamp", player.h()).toString();
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
    public Uri d() {
        return this.d;
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public String e() {
        return this.i;
    }
    
    @Override
    public boolean equals(final Object o) {
        return a(this, o);
    }
    
    @Override
    public Uri f() {
        return this.e;
    }
    
    @Override
    public String g() {
        return this.j;
    }
    
    @Override
    public long h() {
        return this.f;
    }
    
    @Override
    public int hashCode() {
        return a(this);
    }
    
    @Override
    public long i() {
        return this.h;
    }
    
    @Override
    public int j() {
        return this.g;
    }
    
    public int k() {
        return this.a;
    }
    
    public Player l() {
        return this;
    }
    
    @Override
    public String toString() {
        return b(this);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        if (!this.C()) {
            com.google.android.gms.games.d.a(this, parcel, n);
            return;
        }
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
        parcel.writeLong(this.f);
    }
}

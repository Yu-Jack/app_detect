// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games;

import android.os.Parcel;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class PlayerRef extends d implements Player
{
    private final e c;
    
    public PlayerRef(final DataHolder dataHolder, final int n) {
        this(dataHolder, n, null);
    }
    
    public PlayerRef(final DataHolder dataHolder, final int n, final String s) {
        super(dataHolder, n);
        this.c = new e(s);
    }
    
    @Override
    public String b() {
        return this.e(this.c.a);
    }
    
    @Override
    public String c() {
        return this.e(this.c.b);
    }
    
    @Override
    public Uri d() {
        return this.g(this.c.c);
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public String e() {
        return this.e(this.c.d);
    }
    
    @Override
    public boolean equals(final Object o) {
        return PlayerEntity.a(this, o);
    }
    
    @Override
    public Uri f() {
        return this.g(this.c.e);
    }
    
    @Override
    public String g() {
        return this.e(this.c.f);
    }
    
    @Override
    public long h() {
        return this.b(this.c.g);
    }
    
    @Override
    public int hashCode() {
        return PlayerEntity.a(this);
    }
    
    @Override
    public long i() {
        if (!this.a_(this.c.i)) {
            return -1L;
        }
        return this.b(this.c.i);
    }
    
    @Override
    public int j() {
        return this.c(this.c.h);
    }
    
    public Player k() {
        return new PlayerEntity(this);
    }
    
    @Override
    public String toString() {
        return PlayerEntity.b(this);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        ((PlayerEntity)this.k()).writeToParcel(parcel, n);
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.internal.game;

import android.os.Parcel;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class GameBadgeRef extends d implements GameBadge
{
    GameBadgeRef(final DataHolder dataHolder, final int n) {
        super(dataHolder, n);
    }
    
    @Override
    public int b() {
        return this.c("badge_type");
    }
    
    @Override
    public String c() {
        return this.e("badge_title");
    }
    
    @Override
    public String d() {
        return this.e("badge_description");
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public Uri e() {
        return this.g("badge_icon_image_uri");
    }
    
    @Override
    public boolean equals(final Object o) {
        return GameBadgeEntity.a(this, o);
    }
    
    public GameBadge f() {
        return new GameBadgeEntity(this);
    }
    
    @Override
    public int hashCode() {
        return GameBadgeEntity.a(this);
    }
    
    @Override
    public String toString() {
        return GameBadgeEntity.b(this);
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        ((GameBadgeEntity)this.f()).writeToParcel(parcel, n);
    }
}

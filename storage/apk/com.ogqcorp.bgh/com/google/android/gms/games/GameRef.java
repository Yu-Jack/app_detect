// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games;

import android.os.Parcel;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class GameRef extends d implements Game
{
    public GameRef(final DataHolder dataHolder, final int n) {
        super(dataHolder, n);
    }
    
    @Override
    public String b() {
        return this.e("external_game_id");
    }
    
    @Override
    public String c() {
        return this.e("display_name");
    }
    
    @Override
    public String d() {
        return this.e("primary_category");
    }
    
    public int describeContents() {
        return 0;
    }
    
    @Override
    public String e() {
        return this.e("secondary_category");
    }
    
    @Override
    public boolean equals(final Object o) {
        return GameEntity.a(this, o);
    }
    
    @Override
    public String f() {
        return this.e("game_description");
    }
    
    @Override
    public String g() {
        return this.e("developer_name");
    }
    
    @Override
    public Uri h() {
        return this.g("game_icon_image_uri");
    }
    
    @Override
    public int hashCode() {
        return GameEntity.a(this);
    }
    
    @Override
    public String i() {
        return this.e("game_icon_image_url");
    }
    
    @Override
    public Uri j() {
        return this.g("game_hi_res_image_uri");
    }
    
    @Override
    public String k() {
        return this.e("game_hi_res_image_url");
    }
    
    @Override
    public Uri l() {
        return this.g("featured_image_uri");
    }
    
    @Override
    public String m() {
        return this.e("featured_image_url");
    }
    
    @Override
    public boolean n() {
        return this.d("play_enabled_game");
    }
    
    @Override
    public boolean o() {
        return this.d("muted");
    }
    
    @Override
    public boolean p() {
        return this.d("identity_sharing_confirmed");
    }
    
    @Override
    public boolean q() {
        return this.c("installed") > 0;
    }
    
    @Override
    public String r() {
        return this.e("package_name");
    }
    
    @Override
    public int s() {
        return this.c("gameplay_acl_status");
    }
    
    @Override
    public int t() {
        return this.c("achievement_total_count");
    }
    
    @Override
    public String toString() {
        return GameEntity.b(this);
    }
    
    @Override
    public int u() {
        return this.c("leaderboard_count");
    }
    
    @Override
    public boolean v() {
        return this.c("real_time_support") > 0;
    }
    
    @Override
    public boolean w() {
        return this.c("turn_based_support") > 0;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        ((GameEntity)this.x()).writeToParcel(parcel, n);
    }
    
    public Game x() {
        return new GameEntity(this);
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games;

import android.text.TextUtils;

final class e
{
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    
    public e(final String str) {
        if (TextUtils.isEmpty((CharSequence)str)) {
            this.a = "external_player_id";
            this.b = "profile_name";
            this.c = "profile_icon_image_uri";
            this.d = "profile_icon_image_url";
            this.e = "profile_hi_res_image_uri";
            this.f = "profile_hi_res_image_url";
            this.g = "last_updated";
            this.h = "is_in_circles";
            this.i = "played_with_timestamp";
            return;
        }
        this.a = str + "external_player_id";
        this.b = str + "profile_name";
        this.c = str + "profile_icon_image_uri";
        this.d = str + "profile_icon_image_url";
        this.e = str + "profile_hi_res_image_uri";
        this.f = str + "profile_hi_res_image_url";
        this.g = str + "last_updated";
        this.h = str + "is_in_circles";
        this.i = str + "played_with_timestamp";
    }
}

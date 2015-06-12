// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import android.text.TextUtils;

class Hit
{
    private final long mHitId;
    private String mHitString;
    private final long mHitTime;
    private String mHitUrlScheme;
    
    Hit(final String mHitString, final long mHitId, final long mHitTime) {
        this.mHitUrlScheme = "https:";
        this.mHitString = mHitString;
        this.mHitId = mHitId;
        this.mHitTime = mHitTime;
    }
    
    long getHitId() {
        return this.mHitId;
    }
    
    String getHitParams() {
        return this.mHitString;
    }
    
    long getHitTime() {
        return this.mHitTime;
    }
    
    String getHitUrlScheme() {
        return this.mHitUrlScheme;
    }
    
    void setHitString(final String mHitString) {
        this.mHitString = mHitString;
    }
    
    void setHitUrl(final String s) {
        if (s != null && !TextUtils.isEmpty((CharSequence)s.trim()) && s.toLowerCase().startsWith("http:")) {
            this.mHitUrlScheme = "http:";
        }
    }
}

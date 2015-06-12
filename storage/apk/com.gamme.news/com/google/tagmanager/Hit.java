// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.text.TextUtils;

class Hit
{
    private final long mHitFirstDispatchTime;
    private final long mHitId;
    private final long mHitTime;
    private String mHitUrl;
    
    Hit(final long mHitId, final long mHitTime) {
        this.mHitId = mHitId;
        this.mHitTime = mHitTime;
        this.mHitFirstDispatchTime = 0L;
    }
    
    Hit(final long mHitId, final long mHitTime, final long mHitFirstDispatchTime) {
        this.mHitId = mHitId;
        this.mHitTime = mHitTime;
        this.mHitFirstDispatchTime = mHitFirstDispatchTime;
    }
    
    long getHitFirstDispatchTime() {
        return this.mHitFirstDispatchTime;
    }
    
    long getHitId() {
        return this.mHitId;
    }
    
    long getHitTime() {
        return this.mHitTime;
    }
    
    String getHitUrl() {
        return this.mHitUrl;
    }
    
    void setHitUrl(final String mHitUrl) {
        if (mHitUrl == null || TextUtils.isEmpty((CharSequence)mHitUrl.trim())) {
            return;
        }
        this.mHitUrl = mHitUrl;
    }
}

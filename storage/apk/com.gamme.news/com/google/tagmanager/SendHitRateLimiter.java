// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;

class SendHitRateLimiter implements RateLimiter
{
    private long mLastTrackTime;
    private final int mMaxTokens;
    private final long mMillisecondsPerToken;
    private final Object mTokenLock;
    private double mTokens;
    
    public SendHitRateLimiter() {
        this(60, 2000L);
    }
    
    public SendHitRateLimiter(final int mMaxTokens, final long mMillisecondsPerToken) {
        this.mTokenLock = new Object();
        this.mMaxTokens = mMaxTokens;
        this.mTokens = this.mMaxTokens;
        this.mMillisecondsPerToken = mMillisecondsPerToken;
    }
    
    @VisibleForTesting
    void setLastTrackTime(final long mLastTrackTime) {
        this.mLastTrackTime = mLastTrackTime;
    }
    
    @VisibleForTesting
    void setTokensAvailable(final long n) {
        this.mTokens = n;
    }
    
    @Override
    public boolean tokenAvailable() {
        synchronized (this.mTokenLock) {
            final long currentTimeMillis = System.currentTimeMillis();
            if (this.mTokens < this.mMaxTokens) {
                final double n = (currentTimeMillis - this.mLastTrackTime) / this.mMillisecondsPerToken;
                if (n > 0.0) {
                    this.mTokens = Math.min(this.mMaxTokens, n + this.mTokens);
                }
            }
            this.mLastTrackTime = currentTimeMillis;
            if (this.mTokens >= 1.0) {
                --this.mTokens;
                return true;
            }
            Log.w("No more tokens available.");
            return false;
        }
    }
}

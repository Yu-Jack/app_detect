// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import android.content.Context;

class DelayedHitSender implements HitSender
{
    private static DelayedHitSender sInstance;
    private static final Object sInstanceLock;
    private RateLimiter mRateLimiter;
    private HitSendingThread mSendingThread;
    private String mWrapperQueryParameter;
    private String mWrapperUrl;
    
    static {
        sInstanceLock = new Object();
    }
    
    private DelayedHitSender(final Context context) {
        this(HitSendingThreadImpl.getInstance(context), new SendHitRateLimiter());
    }
    
    DelayedHitSender(final HitSendingThread mSendingThread, final RateLimiter mRateLimiter) {
        this.mSendingThread = mSendingThread;
        this.mRateLimiter = mRateLimiter;
    }
    
    public static HitSender getInstance(final Context context) {
        synchronized (DelayedHitSender.sInstanceLock) {
            if (DelayedHitSender.sInstance == null) {
                DelayedHitSender.sInstance = new DelayedHitSender(context);
            }
            return DelayedHitSender.sInstance;
        }
    }
    
    @Override
    public boolean sendHit(String string) {
        if (!this.mRateLimiter.tokenAvailable()) {
            Log.w("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
            return false;
        }
        Label_0099: {
            if (this.mWrapperUrl == null || this.mWrapperQueryParameter == null) {
                break Label_0099;
            }
            try {
                string = this.mWrapperUrl + "?" + this.mWrapperQueryParameter + "=" + URLEncoder.encode(string, "UTF-8");
                Log.v("Sending wrapped url hit: " + string);
                this.mSendingThread.sendHit(string);
                return true;
            }
            catch (UnsupportedEncodingException ex) {
                Log.w("Error wrapping URL for testing.", ex);
                return false;
            }
        }
    }
    
    @Override
    public void setUrlWrapModeForTesting(final String mWrapperUrl, final String mWrapperQueryParameter) {
        this.mWrapperUrl = mWrapperUrl;
        this.mWrapperQueryParameter = mWrapperQueryParameter;
    }
}

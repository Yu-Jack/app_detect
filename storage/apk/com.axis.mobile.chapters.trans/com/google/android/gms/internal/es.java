// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import android.content.Context;

public final class es extends em
{
    private final String lr;
    private final Context mContext;
    private final String qY;
    
    public es(final Context mContext, final String lr, final String qy) {
        this.mContext = mContext;
        this.lr = lr;
        this.qY = qy;
    }
    
    @Override
    public void bh() {
        try {
            eu.C("Pinging URL: " + this.qY);
            final HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(this.qY).openConnection();
            try {
                eo.a(this.mContext, this.lr, true, httpURLConnection);
                final int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode >= 300) {
                    eu.D("Received non-success response code " + responseCode + " from pinging URL: " + this.qY);
                }
            }
            finally {
                httpURLConnection.disconnect();
            }
        }
        catch (IndexOutOfBoundsException ex) {
            eu.D("Error while parsing ping URL: " + this.qY + ". " + ex.getMessage());
        }
        catch (IOException ex2) {
            eu.D("Error while pinging URL: " + this.qY + ". " + ex2.getMessage());
        }
    }
    
    @Override
    public void onStop() {
    }
}

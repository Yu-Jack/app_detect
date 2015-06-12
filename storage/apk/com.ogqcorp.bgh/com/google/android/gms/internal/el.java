// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;
import android.content.Context;

public final class el extends ed
{
    private final String a;
    private final Context b;
    private final String c;
    
    public el(final Context b, final String a, final String c) {
        this.b = b;
        this.a = a;
        this.c = c;
    }
    
    @Override
    public void a() {
        try {
            en.d("Pinging URL: " + this.c);
            final HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(this.c).openConnection();
            try {
                eg.a(this.b, this.a, true, httpURLConnection);
                final int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode >= 300) {
                    en.e("Received non-success response code " + responseCode + " from pinging URL: " + this.c);
                }
            }
            finally {
                httpURLConnection.disconnect();
            }
        }
        catch (IndexOutOfBoundsException ex) {
            en.e("Error while parsing ping URL: " + this.c + ". " + ex.getMessage());
        }
        catch (IOException ex2) {
            en.e("Error while pinging URL: " + this.c + ". " + ex2.getMessage());
        }
    }
    
    @Override
    public void b() {
    }
}

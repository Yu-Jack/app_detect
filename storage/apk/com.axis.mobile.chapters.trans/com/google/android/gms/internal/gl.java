// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.cast.LaunchOptions;
import android.os.IInterface;

public interface gl extends IInterface
{
    void a(double p0, double p1, boolean p2);
    
    void a(String p0, LaunchOptions p1);
    
    void a(String p0, String p1, long p2);
    
    void a(String p0, byte[] p1, long p2);
    
    void a(boolean p0, double p1, boolean p2);
    
    void am(String p0);
    
    void an(String p0);
    
    void ao(String p0);
    
    void disconnect();
    
    void e(String p0, boolean p1);
    
    void eg();
    
    void ep();
    
    void h(String p0, String p1);
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.dynamic.d;
import android.os.IInterface;

public interface bu extends IInterface
{
    void a(d p0, ai p1, String p2, bv p3);
    
    void a(d p0, ai p1, String p2, String p3, bv p4);
    
    void a(d p0, al p1, ai p2, String p3, bv p4);
    
    void a(d p0, al p1, ai p2, String p3, String p4, bv p5);
    
    void destroy();
    
    d getView();
    
    void pause();
    
    void resume();
    
    void showInterstitial();
}

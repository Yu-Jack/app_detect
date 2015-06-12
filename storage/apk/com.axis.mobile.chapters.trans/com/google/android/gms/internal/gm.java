// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.cast.ApplicationMetadata;
import android.os.IInterface;

public interface gm extends IInterface
{
    void T(int p0);
    
    void U(int p0);
    
    void V(int p0);
    
    void W(int p0);
    
    void a(ApplicationMetadata p0, String p1, String p2, boolean p3);
    
    void a(String p0, double p1, boolean p2);
    
    void a(String p0, long p1);
    
    void a(String p0, long p1, int p2);
    
    void b(ge p0);
    
    void b(gj p0);
    
    void b(String p0, byte[] p1);
    
    void g(String p0, String p1);
    
    void onApplicationDisconnected(int p0);
}

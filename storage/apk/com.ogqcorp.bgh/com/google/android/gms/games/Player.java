// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games;

import android.net.Uri;
import com.google.android.gms.common.data.c;
import android.os.Parcelable;

public interface Player extends Parcelable, c<Player>
{
    String b();
    
    String c();
    
    Uri d();
    
    @Deprecated
    String e();
    
    Uri f();
    
    @Deprecated
    String g();
    
    long h();
    
    long i();
    
    int j();
}

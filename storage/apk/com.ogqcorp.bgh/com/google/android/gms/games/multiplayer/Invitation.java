// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer;

import com.google.android.gms.games.Game;
import com.google.android.gms.common.data.c;
import android.os.Parcelable;

public interface Invitation extends Parcelable, c<Invitation>, f
{
    Game d();
    
    String e();
    
    Participant f();
    
    long g();
    
    int h();
    
    int i();
    
    int j();
}

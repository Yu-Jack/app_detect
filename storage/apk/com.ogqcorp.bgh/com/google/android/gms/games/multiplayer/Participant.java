// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer;

import com.google.android.gms.games.Player;
import android.net.Uri;
import com.google.android.gms.common.data.c;
import android.os.Parcelable;

public interface Participant extends Parcelable, c<Participant>
{
    int b();
    
    String c();
    
    int d();
    
    boolean e();
    
    String f();
    
    Uri g();
    
    @Deprecated
    String h();
    
    Uri i();
    
    @Deprecated
    String j();
    
    String k();
    
    Player l();
    
    ParticipantResult m();
}

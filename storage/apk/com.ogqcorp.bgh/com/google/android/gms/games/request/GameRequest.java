// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.request;

import java.util.List;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.Game;
import com.google.android.gms.common.data.c;
import android.os.Parcelable;

public interface GameRequest extends Parcelable, c<GameRequest>
{
    int a(String p0);
    
    String d();
    
    Game e();
    
    Player f();
    
    byte[] h();
    
    int i();
    
    long j();
    
    long k();
    
    int l();
    
    List<Player> n();
}

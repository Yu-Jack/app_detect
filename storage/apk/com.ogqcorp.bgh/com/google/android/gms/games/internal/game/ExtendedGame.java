// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.internal.game;

import java.util.ArrayList;
import com.google.android.gms.games.Game;
import com.google.android.gms.common.data.c;
import android.os.Parcelable;

public interface ExtendedGame extends Parcelable, c<ExtendedGame>
{
    Game b();
    
    ArrayList<GameBadge> c();
    
    int d();
    
    boolean e();
    
    int f();
    
    long g();
    
    long h();
    
    String i();
    
    long j();
    
    String k();
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.multiplayer.f;
import com.google.android.gms.common.data.c;
import android.os.Parcelable;

public interface TurnBasedMatch extends Parcelable, c<TurnBasedMatch>, f
{
    public static final int[] a_ = { 0, 1, 2, 3 };
    
    Game b();
    
    String c();
    
    String d();
    
    long e();
    
    int f();
    
    int g();
    
    String h();
    
    int i();
    
    String j();
    
    long k();
    
    String m();
    
    byte[] n();
    
    int o();
    
    String p();
    
    byte[] q();
    
    int r();
    
    Bundle s();
    
    int t();
    
    boolean u();
    
    String v();
}

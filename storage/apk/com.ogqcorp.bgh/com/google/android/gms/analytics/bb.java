// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import java.util.List;
import java.util.Map;
import android.content.Intent;
import com.google.android.gms.internal.ef;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Timer;
import java.util.Queue;
import android.content.Context;
import java.util.TimerTask;

class bb extends TimerTask
{
    final /* synthetic */ aw a;
    
    private bb(final aw a) {
        this.a = a;
    }
    
    @Override
    public void run() {
        this.a.k();
    }
}

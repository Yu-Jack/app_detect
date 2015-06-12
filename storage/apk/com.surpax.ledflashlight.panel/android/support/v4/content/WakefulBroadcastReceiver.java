// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.content;

import android.util.SparseArray;
import android.content.BroadcastReceiver;

public abstract class WakefulBroadcastReceiver extends BroadcastReceiver
{
    private static final SparseArray a;
    private static int b;
    
    static {
        a = new SparseArray();
        WakefulBroadcastReceiver.b = 1;
    }
}

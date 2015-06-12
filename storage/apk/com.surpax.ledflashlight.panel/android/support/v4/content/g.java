// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

final class g
{
    final IntentFilter a;
    final BroadcastReceiver b;
    boolean c;
    
    g(final IntentFilter a, final BroadcastReceiver b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("Receiver{");
        sb.append(this.b);
        sb.append(" filter=");
        sb.append(this.a);
        sb.append("}");
        return sb.toString();
    }
}

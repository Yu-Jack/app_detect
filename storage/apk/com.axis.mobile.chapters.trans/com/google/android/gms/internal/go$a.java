// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import org.json.JSONArray;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.cast.MediaInfo;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import android.os.Looper;
import java.util.concurrent.TimeUnit;
import android.os.Handler;
import com.google.android.gms.cast.MediaStatus;
import java.util.List;
import java.util.Iterator;
import android.os.SystemClock;

class go$a implements Runnable
{
    final /* synthetic */ go CI;
    
    private go$a(final go ci) {
        this.CI = ci;
    }
    
    @Override
    public void run() {
        boolean b = false;
        this.CI.CH = false;
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final Iterator<gr> iterator = (Iterator<gr>)this.CI.CF.iterator();
        while (iterator.hasNext()) {
            iterator.next().d(elapsedRealtime, 3);
        }
        while (true) {
            while (true) {
                boolean b2 = false;
                Label_0135: {
                    synchronized (gr.CN) {
                        final Iterator iterator2 = this.CI.CF.iterator();
                        if (!iterator2.hasNext()) {
                            // monitorexit(gr.CN)
                            this.CI.z(b);
                            return;
                        }
                        if (iterator2.next().ev()) {
                            b2 = true;
                            break Label_0135;
                        }
                    }
                    b2 = b;
                }
                b = b2;
                continue;
            }
        }
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.List;

class NoopDispatcher implements Dispatcher
{
    @Override
    public void close() {
    }
    
    @Override
    public int dispatchHits(final List<Hit> list) {
        int min;
        if (list == null) {
            min = 0;
        }
        else {
            min = Math.min(list.size(), 40);
            if (Log.isVerbose()) {
                Log.v("Hits not actually being sent as dispatch is false...");
                for (int i = 0; i < min; ++i) {
                    String postProcessHit;
                    if (TextUtils.isEmpty((CharSequence)list.get(i).getHitParams())) {
                        postProcessHit = "";
                    }
                    else {
                        postProcessHit = HitBuilder.postProcessHit(list.get(i), System.currentTimeMillis());
                    }
                    String str;
                    if (TextUtils.isEmpty((CharSequence)postProcessHit)) {
                        str = "Hit couldn't be read, wouldn't be sent:";
                    }
                    else if (postProcessHit.length() <= 2036) {
                        str = "GET would be sent:";
                    }
                    else if (postProcessHit.length() > 8192) {
                        str = "Would be too big:";
                    }
                    else {
                        str = "POST would be sent:";
                    }
                    Log.v(str + postProcessHit);
                }
            }
        }
        return min;
    }
    
    @Override
    public boolean okToDispatch() {
        return true;
    }
    
    @Override
    public void overrideHostUrl(final String s) {
    }
}

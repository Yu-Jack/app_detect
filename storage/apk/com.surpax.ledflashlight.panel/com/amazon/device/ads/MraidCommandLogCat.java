// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

class MraidCommandLogCat extends MraidCommand
{
    private static final String MRAID_LOG_TAG = "MRAIDLog";
    
    MraidCommandLogCat(final Map map, final MraidView mraidView) {
        super(map, mraidView);
    }
    
    @Override
    void execute() {
        final int intFromParamsForKey = this.getIntFromParamsForKey("level");
        final String stringFromParamsForKey = this.getStringFromParamsForKey("log");
        if (intFromParamsForKey == -1 || stringFromParamsForKey == null || stringFromParamsForKey.length() == 0) {
            return;
        }
        switch (intFromParamsForKey) {
            default: {
                Log.i("MRAIDLog", stringFromParamsForKey);
            }
            case 3: {
                Log.d("MRAIDLog", stringFromParamsForKey);
            }
            case 2: {
                Log.v("MRAIDLog", stringFromParamsForKey);
            }
            case 5: {
                Log.w("MRAIDLog", stringFromParamsForKey);
            }
            case 6: {
                Log.e("MRAIDLog", stringFromParamsForKey);
            }
        }
    }
}

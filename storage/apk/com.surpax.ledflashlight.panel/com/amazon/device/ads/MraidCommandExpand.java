// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

class MraidCommandExpand extends MraidCommand
{
    MraidCommandExpand(final Map map, final MraidView mraidView) {
        super(map, mraidView);
    }
    
    @Override
    void execute() {
        int n = this.getIntFromParamsForKey("w");
        int n2 = this.getIntFromParamsForKey("h");
        final String stringFromParamsForKey = this.getStringFromParamsForKey("url");
        final boolean booleanFromParamsForKey = this.getBooleanFromParamsForKey("shouldUseCustomClose");
        final boolean booleanFromParamsForKey2 = this.getBooleanFromParamsForKey("lockOrientation");
        if (n <= 0) {
            n = this.mView.getDisplayController().mScreenWidth;
        }
        if (n2 <= 0) {
            n2 = this.mView.getDisplayController().mScreenHeight;
        }
        this.mView.getDisplayController().expand(stringFromParamsForKey, n, n2, booleanFromParamsForKey, booleanFromParamsForKey2);
    }
}

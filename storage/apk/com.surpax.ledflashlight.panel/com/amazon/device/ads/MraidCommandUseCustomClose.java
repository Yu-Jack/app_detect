// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

class MraidCommandUseCustomClose extends MraidCommand
{
    MraidCommandUseCustomClose(final Map map, final MraidView mraidView) {
        super(map, mraidView);
    }
    
    @Override
    void execute() {
        this.mView.getDisplayController().useCustomClose(this.getBooleanFromParamsForKey("shouldUseCustomClose"));
    }
}

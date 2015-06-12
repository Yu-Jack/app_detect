// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

class MraidCommandClose extends MraidCommand
{
    MraidCommandClose(final Map map, final MraidView mraidView) {
        super(map, mraidView);
    }
    
    @Override
    void execute() {
        this.mView.getDisplayController().close();
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;

class MraidCommandPlayVideo extends MraidCommand
{
    MraidCommandPlayVideo(final Map map, final MraidView mraidView) {
        super(map, mraidView);
    }
    
    @Override
    void execute() {
        final Integer[] intArrayFromParamsForKey = this.getIntArrayFromParamsForKey("position");
        Controller$Dimensions controller$Dimensions2;
        if (intArrayFromParamsForKey[0] != -1) {
            final Controller$Dimensions controller$Dimensions = new Controller$Dimensions();
            controller$Dimensions.y = intArrayFromParamsForKey[0];
            controller$Dimensions.x = intArrayFromParamsForKey[1];
            controller$Dimensions.width = intArrayFromParamsForKey[2];
            controller$Dimensions.height = intArrayFromParamsForKey[3];
            controller$Dimensions2 = controller$Dimensions;
        }
        else {
            controller$Dimensions2 = null;
        }
        final String stringFromParamsForKey = this.getStringFromParamsForKey("url");
        final Controller$PlayerProperties controller$PlayerProperties = new Controller$PlayerProperties();
        controller$PlayerProperties.setProperties(this.getBooleanFromParamsForKey("audioMuted"), this.getBooleanFromParamsForKey("autoPlay"), this.getBooleanFromParamsForKey("controls"), true, this.getBooleanFromParamsForKey("loop"), this.getStringFromParamsForKey("startStyle"), this.getStringFromParamsForKey("stopStyle"));
        this.mView.getDisplayController().playVideo(stringFromParamsForKey, controller$Dimensions2, controller$PlayerProperties);
    }
}

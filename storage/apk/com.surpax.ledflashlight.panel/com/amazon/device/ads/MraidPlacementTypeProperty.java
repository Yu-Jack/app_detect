// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Locale;

class MraidPlacementTypeProperty extends MraidProperty
{
    private final MraidView$PlacementType mPlacementType;
    
    MraidPlacementTypeProperty(final MraidView$PlacementType mPlacementType) {
        this.mPlacementType = mPlacementType;
    }
    
    public static MraidPlacementTypeProperty createWithType(final MraidView$PlacementType mraidView$PlacementType) {
        return new MraidPlacementTypeProperty(mraidView$PlacementType);
    }
    
    @Override
    public String toJsonPair() {
        return "placementType: '" + this.mPlacementType.toString().toLowerCase(Locale.US) + "'";
    }
}

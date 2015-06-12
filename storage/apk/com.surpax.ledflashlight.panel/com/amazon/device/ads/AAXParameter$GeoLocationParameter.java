// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Map;
import android.location.Location;

class AAXParameter$GeoLocationParameter extends AAXParameter$StringParameter
{
    AAXParameter$GeoLocationParameter() {
        super("geoloc", "debug.geoloc");
    }
    
    @Override
    protected String getDerivedValue(final AAXParameter$ParameterData aaxParameter$ParameterData) {
        if (Configuration.getInstance().getBoolean(Configuration$ConfigOption.SEND_GEO) && aaxParameter$ParameterData.adRequest.getAdTargetingOptions().isGeoLocationEnabled()) {
            final Location location = new AdLocation().getLocation();
            if (location != null) {
                return location.getLatitude() + "," + location.getLongitude();
            }
        }
        return null;
    }
}

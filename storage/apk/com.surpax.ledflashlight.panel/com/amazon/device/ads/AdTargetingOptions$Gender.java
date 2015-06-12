// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

public enum AdTargetingOptions$Gender
{
    FEMALE("FEMALE", 2, "female"), 
    MALE("MALE", 1, "male"), 
    UNKNOWN("UNKNOWN", 0, "unknown");
    
    final String gender;
    
    private AdTargetingOptions$Gender(final String name, final int ordinal, final String gender) {
        this.gender = gender;
    }
}

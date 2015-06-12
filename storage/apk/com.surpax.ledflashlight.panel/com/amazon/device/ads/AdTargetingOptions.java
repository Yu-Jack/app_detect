// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.HashMap;
import java.util.Map;

public class AdTargetingOptions
{
    private static final String LOGTAG;
    private Map advanced;
    private int age;
    private boolean enableGeoTargeting;
    private long floorPrice;
    
    static {
        LOGTAG = AdTargetingOptions.class.getSimpleName();
    }
    
    public AdTargetingOptions() {
        this.age = Integer.MIN_VALUE;
        this.floorPrice = Long.MIN_VALUE;
        this.enableGeoTargeting = false;
        this.advanced = new HashMap();
    }
    
    public boolean containsAdvancedOption(final String s) {
        return this.advanced.containsKey(s);
    }
    
    public AdTargetingOptions enableGeoLocation(final boolean enableGeoTargeting) {
        this.enableGeoTargeting = enableGeoTargeting;
        return this;
    }
    
    public String getAdvancedOption(final String s) {
        return this.advanced.get(s);
    }
    
    public int getAge() {
        return this.age;
    }
    
    HashMap getCopyOfAdvancedOptions() {
        return new HashMap(this.advanced);
    }
    
    public long getFloorPrice() {
        return this.floorPrice;
    }
    
    public AdTargetingOptions$Gender getGender() {
        return AdTargetingOptions$Gender.UNKNOWN;
    }
    
    boolean hasAge() {
        return this.age >= 0;
    }
    
    boolean hasFloorPrice() {
        return this.floorPrice > -1L;
    }
    
    public boolean isGeoLocationEnabled() {
        return this.enableGeoTargeting;
    }
    
    public AdTargetingOptions setAdvancedOption(final String s, final String s2) {
        if (Utils.isNullOrWhiteSpace(s)) {
            throw new IllegalArgumentException("Option Key must not be null or empty string");
        }
        if (s2 != null) {
            this.advanced.put(s, s2);
            return this;
        }
        this.advanced.remove(s);
        return this;
    }
    
    public AdTargetingOptions setAge(final int age) {
        this.age = age;
        return this;
    }
    
    public AdTargetingOptions setFloorPrice(final long floorPrice) {
        this.floorPrice = floorPrice;
        return this;
    }
    
    public AdTargetingOptions setGender(final AdTargetingOptions$Gender adTargetingOptions$Gender) {
        Log.d(AdTargetingOptions.LOGTAG, "Gender information has been deprecated and is no longer used for targeting.");
        return this;
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.Map;
import java.util.List;

class eb
{
    private final List qS;
    private final List qT;
    private final String qU;
    private final String qV;
    private final String qW;
    private final String qX;
    private final String qY;
    private final boolean qZ;
    private final int ra;
    
    public eb(final Map map) {
        this.qY = map.get("url");
        this.qV = map.get("base_uri");
        this.qW = map.get("post_parameters");
        this.qZ = parseBoolean(map.get("drt_include"));
        this.qU = map.get("activation_overlay_url");
        this.qT = this.t(map.get("check_packages"));
        this.ra = this.parseInt(map.get("request_id"));
        this.qX = map.get("type");
        this.qS = this.t(map.get("errors"));
    }
    
    private static boolean parseBoolean(final String s) {
        return s != null && (s.equals("1") || s.equals("true"));
    }
    
    private int parseInt(final String s) {
        if (s == null) {
            return 0;
        }
        return Integer.parseInt(s);
    }
    
    private List t(final String s) {
        if (s == null) {
            return null;
        }
        return Arrays.asList(s.split(","));
    }
    
    public boolean bA() {
        return this.qZ;
    }
    
    public List by() {
        return this.qS;
    }
    
    public String bz() {
        return this.qW;
    }
    
    public String getType() {
        return this.qX;
    }
    
    public String getUrl() {
        return this.qY;
    }
}

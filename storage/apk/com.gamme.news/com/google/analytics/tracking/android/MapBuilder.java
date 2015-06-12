// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class MapBuilder
{
    private Map<String, String> map;
    
    public MapBuilder() {
        this.map = new HashMap<String, String>();
    }
    
    static String booleanToString(final Boolean b) {
        if (b == null) {
            return null;
        }
        if (b) {
            return "1";
        }
        return "0";
    }
    
    public static MapBuilder createAppView() {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_APP_VIEW);
        final MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.set("&t", "appview");
        return mapBuilder;
    }
    
    public static MapBuilder createEvent(final String s, final String s2, final String s3, final Long n) {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_EVENT);
        final MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.set("&t", "event");
        mapBuilder.set("&ec", s);
        mapBuilder.set("&ea", s2);
        mapBuilder.set("&el", s3);
        String string;
        if (n == null) {
            string = null;
        }
        else {
            string = Long.toString(n);
        }
        mapBuilder.set("&ev", string);
        return mapBuilder;
    }
    
    public static MapBuilder createException(final String s, final Boolean b) {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_EXCEPTION);
        final MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.set("&t", "exception");
        mapBuilder.set("&exd", s);
        mapBuilder.set("&exf", booleanToString(b));
        return mapBuilder;
    }
    
    public static MapBuilder createItem(final String s, final String s2, final String s3, final String s4, final Double n, final Long n2, final String s5) {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_ITEM);
        final MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.set("&t", "item");
        mapBuilder.set("&ti", s);
        mapBuilder.set("&ic", s3);
        mapBuilder.set("&in", s2);
        mapBuilder.set("&iv", s4);
        String string;
        if (n == null) {
            string = null;
        }
        else {
            string = Double.toString(n);
        }
        mapBuilder.set("&ip", string);
        String string2 = null;
        if (n2 != null) {
            string2 = Long.toString(n2);
        }
        mapBuilder.set("&iq", string2);
        mapBuilder.set("&cu", s5);
        return mapBuilder;
    }
    
    public static MapBuilder createSocial(final String s, final String s2, final String s3) {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_SOCIAL);
        final MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.set("&t", "social");
        mapBuilder.set("&sn", s);
        mapBuilder.set("&sa", s2);
        mapBuilder.set("&st", s3);
        return mapBuilder;
    }
    
    public static MapBuilder createTiming(final String s, final Long n, final String s2, final String s3) {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_TIMING);
        final MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.set("&t", "timing");
        mapBuilder.set("&utc", s);
        String string = null;
        if (n != null) {
            string = Long.toString(n);
        }
        mapBuilder.set("&utt", string);
        mapBuilder.set("&utv", s2);
        mapBuilder.set("&utl", s3);
        return mapBuilder;
    }
    
    public static MapBuilder createTransaction(final String s, final String s2, final Double n, final Double n2, final Double n3, final String s3) {
        GAUsage.getInstance().setUsage(GAUsage.Field.CONSTRUCT_TRANSACTION);
        final MapBuilder mapBuilder = new MapBuilder();
        mapBuilder.set("&t", "transaction");
        mapBuilder.set("&ti", s);
        mapBuilder.set("&ta", s2);
        String string;
        if (n == null) {
            string = null;
        }
        else {
            string = Double.toString(n);
        }
        mapBuilder.set("&tr", string);
        String string2;
        if (n2 == null) {
            string2 = null;
        }
        else {
            string2 = Double.toString(n2);
        }
        mapBuilder.set("&tt", string2);
        String string3 = null;
        if (n3 != null) {
            string3 = Double.toString(n3);
        }
        mapBuilder.set("&ts", string3);
        mapBuilder.set("&cu", s3);
        return mapBuilder;
    }
    
    public Map<String, String> build() {
        return new HashMap<String, String>(this.map);
    }
    
    public String get(final String s) {
        GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_GET);
        return this.map.get(s);
    }
    
    public MapBuilder set(final String s, final String s2) {
        GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_SET);
        if (s != null) {
            this.map.put(s, s2);
            return this;
        }
        Log.w(" MapBuilder.set() called with a null paramName.");
        return this;
    }
    
    public MapBuilder setAll(final Map<String, String> m) {
        GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_SET_ALL);
        if (m == null) {
            return this;
        }
        this.map.putAll(new HashMap<String, String>(m));
        return this;
    }
    
    public MapBuilder setCampaignParamsFromUrl(final String s) {
        GAUsage.getInstance().setUsage(GAUsage.Field.MAP_BUILDER_SET_CAMPAIGN_PARAMS);
        final String filterCampaign = Utils.filterCampaign(s);
        if (TextUtils.isEmpty((CharSequence)filterCampaign)) {
            return this;
        }
        final Map<String, String> urlParameters = Utils.parseURLParameters(filterCampaign);
        this.set("&cc", urlParameters.get("utm_content"));
        this.set("&cm", urlParameters.get("utm_medium"));
        this.set("&cn", urlParameters.get("utm_campaign"));
        this.set("&cs", urlParameters.get("utm_source"));
        this.set("&ck", urlParameters.get("utm_term"));
        this.set("&ci", urlParameters.get("utm_id"));
        this.set("&gclid", urlParameters.get("gclid"));
        this.set("&dclid", urlParameters.get("dclid"));
        this.set("&gmob_t", urlParameters.get("gmob_t"));
        return this;
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Iterator;
import java.util.Set;
import java.util.HashMap;

class AppEvent
{
    private final String eventName;
    private final HashMap properties;
    private final long timestamp;
    
    protected AppEvent(final String s) {
        this(s, -1L);
    }
    
    public AppEvent(final String eventName, final long timestamp) {
        this.eventName = eventName;
        this.timestamp = timestamp;
        this.properties = new HashMap();
    }
    
    public static AppEvent createAppEventWithTimestamp(final AppEvent appEvent, final long n) {
        return new AppEvent(appEvent.eventName, n);
    }
    
    public String getEventName() {
        return this.eventName;
    }
    
    public String getProperty(final String key) {
        return this.properties.get(key);
    }
    
    public Set getPropertyEntries() {
        return this.properties.entrySet();
    }
    
    public long getTimestamp() {
        return this.timestamp;
    }
    
    public AppEvent setProperty(final String key, final String value) {
        this.properties.put(key, value);
        return this;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(65);
        sb.append("Application Event {Name: ");
        sb.append(this.eventName);
        sb.append(", Timestamp: ");
        sb.append(this.timestamp);
        for (final String s : this.properties.keySet()) {
            sb.append(", ");
            sb.append(s);
            sb.append(": ");
            sb.append((String)this.properties.get(s));
        }
        sb.append("}");
        return sb.toString();
    }
}

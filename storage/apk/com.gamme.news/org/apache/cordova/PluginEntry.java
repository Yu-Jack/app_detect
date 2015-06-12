// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import java.util.List;

public class PluginEntry
{
    public boolean onload;
    public CordovaPlugin plugin;
    public String pluginClass;
    public String service;
    private List<String> urlFilters;
    
    public PluginEntry(final String s, final String s2, final boolean b) {
        this(s, s2, b, null, null);
    }
    
    public PluginEntry(final String service, final String pluginClass, final boolean onload, final List<String> urlFilters) {
        this.service = service;
        this.pluginClass = pluginClass;
        this.onload = onload;
        this.urlFilters = urlFilters;
        this.plugin = null;
    }
    
    private PluginEntry(final String service, final String pluginClass, final boolean onload, final CordovaPlugin plugin, final List<String> urlFilters) {
        this.service = service;
        this.pluginClass = pluginClass;
        this.onload = onload;
        this.urlFilters = urlFilters;
        this.plugin = plugin;
    }
    
    public PluginEntry(final String s, final CordovaPlugin cordovaPlugin) {
        this(s, cordovaPlugin.getClass().getName(), true, cordovaPlugin, null);
    }
    
    public List<String> getUrlFilters() {
        return this.urlFilters;
    }
}

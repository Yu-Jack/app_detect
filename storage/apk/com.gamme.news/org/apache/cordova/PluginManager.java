// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import android.net.Uri;
import android.content.Intent;
import java.util.Iterator;
import org.json.JSONException;
import android.util.Log;
import android.os.Debug;
import java.util.List;
import java.util.HashMap;

public class PluginManager
{
    private static final int SLOW_EXEC_WARNING_THRESHOLD;
    private static String TAG;
    private final CordovaWebView app;
    private final CordovaInterface ctx;
    private final HashMap<String, PluginEntry> entryMap;
    private final HashMap<String, CordovaPlugin> pluginMap;
    protected HashMap<String, List<String>> urlMap;
    
    static {
        PluginManager.TAG = "PluginManager";
        int slow_EXEC_WARNING_THRESHOLD;
        if (Debug.isDebuggerConnected()) {
            slow_EXEC_WARNING_THRESHOLD = 60;
        }
        else {
            slow_EXEC_WARNING_THRESHOLD = 16;
        }
        SLOW_EXEC_WARNING_THRESHOLD = slow_EXEC_WARNING_THRESHOLD;
    }
    
    PluginManager(final CordovaWebView cordovaWebView, final CordovaInterface cordovaInterface) {
        this(cordovaWebView, cordovaInterface, null);
    }
    
    PluginManager(final CordovaWebView app, final CordovaInterface ctx, List<PluginEntry> pluginEntries) {
        this.pluginMap = new HashMap<String, CordovaPlugin>();
        this.entryMap = new HashMap<String, PluginEntry>();
        this.urlMap = new HashMap<String, List<String>>();
        this.ctx = ctx;
        this.app = app;
        if (pluginEntries == null) {
            final ConfigXmlParser configXmlParser = new ConfigXmlParser();
            configXmlParser.parse(this.ctx.getActivity());
            pluginEntries = configXmlParser.getPluginEntries();
        }
        this.setPluginEntries(pluginEntries);
    }
    
    private CordovaPlugin instantiatePlugin(final String str) {
        Class<?> forName = null;
        while (true) {
            while (true) {
                Label_0100: {
                    if (str == null) {
                        break Label_0100;
                    }
                    try {
                        final boolean equals = "".equals(str);
                        forName = null;
                        if (!equals) {
                            forName = Class.forName(str);
                        }
                        break Label_0100;
                        return (CordovaPlugin)forName.newInstance();
                        final boolean b2;
                        final boolean b = b2 & CordovaPlugin.class.isAssignableFrom(forName);
                        cordovaPlugin = null;
                        // iftrue(Label_0056:, !b)
                        return (CordovaPlugin)forName.newInstance();
                        b2 = false;
                        continue;
                        Label_0056: {
                            return cordovaPlugin;
                        }
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                        System.out.println("Error adding plugin " + str + ".");
                        return null;
                    }
                }
                if (forName != null) {
                    final boolean b2 = true;
                    continue;
                }
                break;
            }
            continue;
        }
    }
    
    public void addService(final String s, final String s2) {
        this.addService(new PluginEntry(s, s2, false));
    }
    
    public void addService(final PluginEntry value) {
        this.entryMap.put(value.service, value);
        final List<String> urlFilters = value.getUrlFilters();
        if (urlFilters != null) {
            this.urlMap.put(value.service, urlFilters);
        }
        if (value.plugin != null) {
            value.plugin.privateInitialize(this.ctx, this.app, this.app.getPreferences());
            this.pluginMap.put(value.service, value.plugin);
        }
    }
    
    @Deprecated
    public void clearPluginObjects() {
        this.pluginMap.clear();
    }
    
    public void exec(final String s, final String str, final String s2, final String s3) {
        final CordovaPlugin plugin = this.getPlugin(s);
        if (plugin == null) {
            Log.d(PluginManager.TAG, "exec() call to unknown plugin: " + s);
            this.app.sendPluginResult(new PluginResult(PluginResult.Status.CLASS_NOT_FOUND_EXCEPTION), s2);
        }
        else {
            final CallbackContext callbackContext = new CallbackContext(s2, this.app);
            try {
                final long currentTimeMillis = System.currentTimeMillis();
                final boolean execute = plugin.execute(str, s3, callbackContext);
                final long lng = System.currentTimeMillis() - currentTimeMillis;
                if (lng > PluginManager.SLOW_EXEC_WARNING_THRESHOLD) {
                    Log.w(PluginManager.TAG, "THREAD WARNING: exec() call to " + s + "." + str + " blocked the main thread for " + lng + "ms. Plugin should use CordovaInterface.getThreadPool().");
                }
                if (!execute) {
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.INVALID_ACTION));
                }
            }
            catch (JSONException ex2) {
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
            }
            catch (Exception ex) {
                Log.e(PluginManager.TAG, "Uncaught exception from plugin", (Throwable)ex);
                callbackContext.error(ex.getMessage());
            }
        }
    }
    
    @Deprecated
    public void exec(final String s, final String s2, final String s3, final String s4, final boolean b) {
        this.exec(s, s2, s3, s4);
    }
    
    public CordovaPlugin getPlugin(final String key) {
        CordovaPlugin value = this.pluginMap.get(key);
        if (value == null) {
            final PluginEntry pluginEntry = this.entryMap.get(key);
            if (pluginEntry == null) {
                return null;
            }
            if (pluginEntry.plugin != null) {
                value = pluginEntry.plugin;
            }
            else {
                value = this.instantiatePlugin(pluginEntry.pluginClass);
            }
            value.privateInitialize(this.ctx, this.app, this.app.getPreferences());
            this.pluginMap.put(key, value);
        }
        return value;
    }
    
    public void init() {
        LOG.d(PluginManager.TAG, "init()");
        this.onPause(false);
        this.onDestroy();
        this.pluginMap.clear();
        this.startupPlugins();
    }
    
    @Deprecated
    public void loadPlugins() {
    }
    
    public void onDestroy() {
        final Iterator<CordovaPlugin> iterator = this.pluginMap.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onDestroy();
        }
    }
    
    public void onNewIntent(final Intent intent) {
        final Iterator<CordovaPlugin> iterator = this.pluginMap.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onNewIntent(intent);
        }
    }
    
    public boolean onOverrideUrlLoading(final String s) {
        for (final PluginEntry pluginEntry : this.entryMap.values()) {
            final List<String> list = this.urlMap.get(pluginEntry.service);
            if (list != null) {
                final Iterator<String> iterator2 = list.iterator();
                while (iterator2.hasNext()) {
                    if (s.startsWith(iterator2.next())) {
                        return this.getPlugin(pluginEntry.service).onOverrideUrlLoading(s);
                    }
                }
            }
            else {
                final CordovaPlugin cordovaPlugin = this.pluginMap.get(pluginEntry.service);
                if (cordovaPlugin != null && cordovaPlugin.onOverrideUrlLoading(s)) {
                    return true;
                }
                continue;
            }
        }
        return false;
    }
    
    public void onPause(final boolean b) {
        final Iterator<CordovaPlugin> iterator = this.pluginMap.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onPause(b);
        }
    }
    
    public void onReset() {
        final Iterator<CordovaPlugin> iterator = this.pluginMap.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onReset();
        }
    }
    
    public void onResume(final boolean b) {
        final Iterator<CordovaPlugin> iterator = this.pluginMap.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().onResume(b);
        }
    }
    
    public Object postMessage(final String s, final Object o) {
        final Object onMessage = this.ctx.onMessage(s, o);
        if (onMessage != null) {
            return onMessage;
        }
        final Iterator<CordovaPlugin> iterator = this.pluginMap.values().iterator();
        while (iterator.hasNext()) {
            final Object onMessage2 = iterator.next().onMessage(s, o);
            if (onMessage2 != null) {
                return onMessage2;
            }
        }
        return null;
    }
    
    Uri remapUri(final Uri uri) {
        final Iterator<CordovaPlugin> iterator = this.pluginMap.values().iterator();
        while (iterator.hasNext()) {
            final Uri remapUri = iterator.next().remapUri(uri);
            if (remapUri != null) {
                return remapUri;
            }
        }
        return null;
    }
    
    public void setPluginEntries(final List<PluginEntry> list) {
        this.onPause(false);
        this.onDestroy();
        this.pluginMap.clear();
        this.urlMap.clear();
        final Iterator<PluginEntry> iterator = list.iterator();
        while (iterator.hasNext()) {
            this.addService(iterator.next());
        }
    }
    
    @Deprecated
    public void startupPlugins() {
        for (final PluginEntry pluginEntry : this.entryMap.values()) {
            if (pluginEntry.onload) {
                this.getPlugin(pluginEntry.service);
            }
        }
    }
}

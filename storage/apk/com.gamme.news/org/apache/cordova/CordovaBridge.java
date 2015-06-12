// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import org.json.JSONArray;
import org.json.JSONException;
import android.util.Log;

public class CordovaBridge
{
    private static final String LOG_TAG = "CordovaBridge";
    private volatile int expectedBridgeSecret;
    private NativeToJsMessageQueue jsMessageQueue;
    private String loadedUrl;
    private PluginManager pluginManager;
    
    public CordovaBridge(final PluginManager pluginManager, final NativeToJsMessageQueue jsMessageQueue) {
        this.expectedBridgeSecret = -1;
        this.pluginManager = pluginManager;
        this.jsMessageQueue = jsMessageQueue;
    }
    
    private boolean verifySecret(final String s, final int n) throws IllegalAccessException {
        if (!this.jsMessageQueue.isBridgeEnabled()) {
            if (n == -1) {
                Log.d("CordovaBridge", String.valueOf(s) + " call made before bridge was enabled.");
            }
            else {
                Log.d("CordovaBridge", "Ignoring " + s + " from previous page load.");
            }
            return false;
        }
        if (this.expectedBridgeSecret < 0 || n != this.expectedBridgeSecret) {
            throw new IllegalAccessException();
        }
        return true;
    }
    
    void clearBridgeSecret() {
        this.expectedBridgeSecret = -1;
    }
    
    int generateBridgeSecret() {
        return this.expectedBridgeSecret = (int)(2.147483647E9 * Math.random());
    }
    
    public NativeToJsMessageQueue getMessageQueue() {
        return this.jsMessageQueue;
    }
    
    public String jsExec(final int n, final String s, final String s2, final String s3, final String s4) throws JSONException, IllegalAccessException {
        if (!this.verifySecret("exec()", n)) {
            return null;
        }
        if (s4 == null) {
            return "@Null arguments.";
        }
        this.jsMessageQueue.setPaused(true);
        try {
            CordovaResourceApi.jsThread = Thread.currentThread();
            this.pluginManager.exec(s, s2, s3, s4);
            return this.jsMessageQueue.popAndEncode(false);
        }
        catch (Throwable t) {
            t.printStackTrace();
            return "";
        }
        finally {
            this.jsMessageQueue.setPaused(false);
        }
    }
    
    public String jsRetrieveJsMessages(final int n, final boolean b) throws IllegalAccessException {
        if (!this.verifySecret("retrieveJsMessages()", n)) {
            return null;
        }
        return this.jsMessageQueue.popAndEncode(b);
    }
    
    public void jsSetNativeToJsBridgeMode(final int n, final int bridgeMode) throws IllegalAccessException {
        if (!this.verifySecret("setNativeToJsBridgeMode()", n)) {
            return;
        }
        this.jsMessageQueue.setBridgeMode(bridgeMode);
    }
    
    public String promptOnJsPrompt(final String s, final String s2, final String s3) {
        Label_0098: {
            if (s3 == null || s3.length() <= 3 || !s3.startsWith("gap:")) {
                break Label_0098;
            }
            try {
                final JSONArray jsonArray = new JSONArray(s3.substring(4));
                String s4 = this.jsExec(jsonArray.getInt(0), jsonArray.getString(1), jsonArray.getString(2), jsonArray.getString(3), s2);
                if (s4 == null) {
                    s4 = "";
                }
                return s4;
            }
            catch (JSONException ex) {
                ex.printStackTrace();
            }
            catch (IllegalAccessException ex2) {
                ex2.printStackTrace();
                goto Label_0085;
            }
        }
        if (s3 != null && s3.startsWith("gap_bridge_mode:")) {
            try {
                this.jsSetNativeToJsBridgeMode(Integer.parseInt(s3.substring(16)), Integer.parseInt(s2));
                return "";
            }
            catch (NumberFormatException ex3) {
                ex3.printStackTrace();
                return "";
            }
            catch (IllegalAccessException ex4) {
                ex4.printStackTrace();
                return "";
            }
        }
        if (s3 != null && s3.startsWith("gap_poll:")) {
            final int int1 = Integer.parseInt(s3.substring(9));
            try {
                final String s4 = this.jsRetrieveJsMessages(int1, "1".equals(s2));
                if (s4 == null) {
                    return "";
                }
                return s4;
            }
            catch (IllegalAccessException ex5) {
                ex5.printStackTrace();
                return "";
            }
        }
        if (s3 == null || !s3.startsWith("gap_init:")) {
            return null;
        }
        if (s.startsWith("file:") || (s.startsWith("http") && this.loadedUrl.startsWith(s))) {
            this.jsMessageQueue.setBridgeMode(Integer.parseInt(s3.substring(9)));
            return new StringBuilder().append(this.generateBridgeSecret()).toString();
        }
        Log.e("CordovaBridge", "gap_init called from restricted origin: " + s);
        return "";
    }
    
    public void reset(final String loadedUrl) {
        this.jsMessageQueue.reset();
        this.clearBridgeSecret();
        this.loadedUrl = loadedUrl;
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import android.os.Handler;
import java.lang.reflect.Field;
import java.io.Serializable;
import android.os.Message;
import android.webkit.WebView;
import java.lang.reflect.Method;
import java.util.Iterator;
import android.util.Log;
import java.util.LinkedList;

public class NativeToJsMessageQueue
{
    static final boolean DISABLE_EXEC_CHAINING = false;
    private static final boolean FORCE_ENCODE_USING_EVAL = false;
    private static final String LOG_TAG = "JsMessageQueue";
    private static int MAX_PAYLOAD_SIZE;
    private BridgeMode activeBridgeMode;
    private final CordovaInterface cordova;
    private boolean paused;
    private final LinkedList<JsMessage> queue;
    private final BridgeMode[] registeredListeners;
    private final CordovaWebView webView;
    
    static {
        NativeToJsMessageQueue.MAX_PAYLOAD_SIZE = 524288000;
    }
    
    public NativeToJsMessageQueue(final CordovaWebView webView, final CordovaInterface cordova) {
        this.queue = new LinkedList<JsMessage>();
        this.cordova = cordova;
        this.webView = webView;
        (this.registeredListeners = new BridgeMode[4])[0] = (BridgeMode)new PollingBridgeMode((PollingBridgeMode)null);
        this.registeredListeners[1] = (BridgeMode)new LoadUrlBridgeMode((LoadUrlBridgeMode)null);
        this.registeredListeners[2] = (BridgeMode)new OnlineEventsBridgeMode((OnlineEventsBridgeMode)null);
        this.registeredListeners[3] = (BridgeMode)new PrivateApiBridgeMode((PrivateApiBridgeMode)null);
        this.reset();
    }
    
    private int calculatePackedMessageLength(final JsMessage jsMessage) {
        final int calculateEncodedLength = jsMessage.calculateEncodedLength();
        return 1 + (calculateEncodedLength + String.valueOf(calculateEncodedLength).length());
    }
    
    private void enqueueMessage(final JsMessage e) {
        synchronized (this) {
            if (this.activeBridgeMode == null) {
                Log.d("JsMessageQueue", "Dropping Native->JS message due to disabled bridge");
                return;
            }
            this.queue.add(e);
            if (!this.paused) {
                this.activeBridgeMode.onNativeToJsMessageAvailable();
            }
        }
    }
    
    private void packMessage(final JsMessage jsMessage, final StringBuilder sb) {
        sb.append(jsMessage.calculateEncodedLength()).append(' ');
        jsMessage.encodeAsMessage(sb);
    }
    
    private String popAndEncodeAsJs() {
        int n = 0;
        int n2 = 0;
        Iterator<JsMessage> iterator = null;
        int n3 = 0;
        int n4;
        StringBuilder sb = null;
        int n5 = 0;
        int n6;
        int n7;
        JsMessage jsMessage;
        Label_0053_Outer:Label_0061_Outer:
        while (true) {
            while (true) {
                Label_0266:Label_0099_Outer:
                while (true) {
                    Label_0260: {
                        while (true) {
                            Label_0238: {
                                while (true) {
                                Label_0039_Outer:
                                    while (true) {
                                        while (true) {
                                            Label_0122: {
                                                synchronized (this) {
                                                    if (this.queue.size() == 0) {
                                                        return null;
                                                    }
                                                    n = 0;
                                                    n2 = 0;
                                                    iterator = this.queue.iterator();
                                                    if (iterator.hasNext()) {
                                                        break Label_0122;
                                                    }
                                                    if (n2 != this.queue.size()) {
                                                        break Label_0260;
                                                    }
                                                    n3 = 1;
                                                    if (n3 == 0) {
                                                        break Label_0266;
                                                    }
                                                    n4 = 0;
                                                    sb = new StringBuilder(n4 + n);
                                                    n5 = 0;
                                                    if (n5 < n2) {
                                                        break Label_0039_Outer;
                                                    }
                                                    if (n3 == 0) {
                                                        sb.append("window.setTimeout(function(){cordova.require('cordova/plugin/android/polling').pollOnce();},0);");
                                                    }
                                                    break Label_0238;
                                                    // iftrue(Label_0224:, n6 < n2)
                                                    return sb.toString();
                                                }
                                            }
                                            n7 = 50 + iterator.next().calculateEncodedLength();
                                            if (n2 > 0 && n + n7 > NativeToJsMessageQueue.MAX_PAYLOAD_SIZE && NativeToJsMessageQueue.MAX_PAYLOAD_SIZE > 0) {
                                                continue Label_0053_Outer;
                                            }
                                            break;
                                        }
                                        n += n7;
                                        ++n2;
                                        continue Label_0039_Outer;
                                    }
                                    jsMessage = this.queue.removeFirst();
                                    if (n3 != 0 && n5 + 1 == n2) {
                                        jsMessage.encodeAsJsMessage(sb);
                                    }
                                    else {
                                        sb.append("try{");
                                        jsMessage.encodeAsJsMessage(sb);
                                        sb.append("}finally{");
                                    }
                                    ++n5;
                                    continue Label_0099_Outer;
                                }
                                Label_0224: {
                                    sb.append('}');
                                }
                                ++n6;
                                continue;
                            }
                            if (n3 != 0) {
                                n6 = 1;
                                continue;
                            }
                            n6 = 0;
                            continue;
                        }
                    }
                    n3 = 0;
                    continue Label_0061_Outer;
                }
                n4 = 100;
                continue;
            }
        }
    }
    
    public void addJavaScript(final String s) {
        this.enqueueMessage(new JsMessage(s));
    }
    
    public void addPluginResult(final PluginResult pluginResult, final String s) {
        if (s == null) {
            Log.e("JsMessageQueue", "Got plugin result with no callbackId", new Throwable());
        }
        else {
            boolean b;
            if (pluginResult.getStatus() == PluginResult.Status.NO_RESULT.ordinal()) {
                b = true;
            }
            else {
                b = false;
            }
            final boolean keepCallback = pluginResult.getKeepCallback();
            if (!b || !keepCallback) {
                this.enqueueMessage(new JsMessage(pluginResult, s));
            }
        }
    }
    
    public boolean isBridgeEnabled() {
        return this.activeBridgeMode != null;
    }
    
    public String popAndEncode(final boolean b) {
        synchronized (this) {
            if (this.activeBridgeMode == null) {
                return null;
            }
            this.activeBridgeMode.notifyOfFlush(b);
            if (this.queue.isEmpty()) {
                return null;
            }
        }
        int capacity = 0;
        int n = 0;
        final Iterator<JsMessage> iterator = (Iterator<JsMessage>)this.queue.iterator();
        while (iterator.hasNext()) {
            final int calculatePackedMessageLength = this.calculatePackedMessageLength(iterator.next());
            if (n > 0 && capacity + calculatePackedMessageLength > NativeToJsMessageQueue.MAX_PAYLOAD_SIZE && NativeToJsMessageQueue.MAX_PAYLOAD_SIZE > 0) {
                break;
            }
            capacity += calculatePackedMessageLength;
            ++n;
        }
        final StringBuilder sb = new StringBuilder(capacity);
        for (int i = 0; i < n; ++i) {
            this.packMessage(this.queue.removeFirst(), sb);
        }
        if (!this.queue.isEmpty()) {
            sb.append('*');
        }
        // monitorexit(this)
        return sb.toString();
    }
    
    public void reset() {
        synchronized (this) {
            this.queue.clear();
            this.setBridgeMode(-1);
        }
    }
    
    public void setBridgeMode(final int i) {
        if (i >= -1 && i < this.registeredListeners.length) {
            while (true) {
                Label_0132: {
                    if (i >= 0) {
                        break Label_0132;
                    }
                    final BridgeMode activeBridgeMode = null;
                    if (activeBridgeMode == this.activeBridgeMode) {
                        return;
                    }
                    final StringBuilder sb = new StringBuilder("Set native->JS mode to ");
                    String simpleName;
                    if (activeBridgeMode == null) {
                        simpleName = "null";
                    }
                    else {
                        simpleName = activeBridgeMode.getClass().getSimpleName();
                    }
                    Log.d("JsMessageQueue", sb.append(simpleName).toString());
                    synchronized (this) {
                        this.activeBridgeMode = activeBridgeMode;
                        if (activeBridgeMode != null) {
                            activeBridgeMode.reset();
                            if (!this.paused && !this.queue.isEmpty()) {
                                activeBridgeMode.onNativeToJsMessageAvailable();
                            }
                        }
                        return;
                    }
                }
                final BridgeMode activeBridgeMode = this.registeredListeners[i];
                continue;
            }
        }
        Log.d("JsMessageQueue", "Invalid NativeToJsBridgeMode: " + i);
    }
    
    public void setPaused(final boolean paused) {
        if (this.paused && paused) {
            Log.e("JsMessageQueue", "nested call to setPaused detected.", new Throwable());
        }
        if (!(this.paused = paused)) {
            synchronized (this) {
                if (!this.queue.isEmpty() && this.activeBridgeMode != null) {
                    this.activeBridgeMode.onNativeToJsMessageAvailable();
                }
            }
        }
    }
    
    private abstract class BridgeMode
    {
        void notifyOfFlush(final boolean b) {
        }
        
        abstract void onNativeToJsMessageAvailable();
        
        void reset() {
        }
    }
    
    private static class JsMessage
    {
        final String jsPayloadOrCallbackId;
        final PluginResult pluginResult;
        
        JsMessage(final String jsPayloadOrCallbackId) {
            if (jsPayloadOrCallbackId == null) {
                throw new NullPointerException();
            }
            this.jsPayloadOrCallbackId = jsPayloadOrCallbackId;
            this.pluginResult = null;
        }
        
        JsMessage(final PluginResult pluginResult, final String jsPayloadOrCallbackId) {
            if (jsPayloadOrCallbackId == null || pluginResult == null) {
                throw new NullPointerException();
            }
            this.jsPayloadOrCallbackId = jsPayloadOrCallbackId;
            this.pluginResult = pluginResult;
        }
        
        int calculateEncodedLength() {
            if (this.pluginResult == null) {
                return 1 + this.jsPayloadOrCallbackId.length();
            }
            final int n = 1 + (1 + (2 + String.valueOf(this.pluginResult.getStatus()).length()) + this.jsPayloadOrCallbackId.length());
            switch (this.pluginResult.getMessageType()) {
                default: {
                    return n + this.pluginResult.getMessage().length();
                }
                case 4:
                case 5: {
                    return n + 1;
                }
                case 3: {
                    return n + (1 + this.pluginResult.getMessage().length());
                }
                case 1: {
                    return n + (1 + this.pluginResult.getStrMessage().length());
                }
                case 7: {
                    return n + (1 + this.pluginResult.getMessage().length());
                }
                case 6: {
                    return n + (1 + this.pluginResult.getMessage().length());
                }
            }
        }
        
        void encodeAsJsMessage(final StringBuilder sb) {
            if (this.pluginResult == null) {
                sb.append(this.jsPayloadOrCallbackId);
                return;
            }
            final int status = this.pluginResult.getStatus();
            sb.append("cordova.callbackFromNative('").append(this.jsPayloadOrCallbackId).append("',").append(status == PluginResult.Status.OK.ordinal() || status == PluginResult.Status.NO_RESULT.ordinal()).append(",").append(status).append(",[");
            switch (this.pluginResult.getMessageType()) {
                default: {
                    sb.append(this.pluginResult.getMessage());
                    break;
                }
                case 7: {
                    sb.append("atob('").append(this.pluginResult.getMessage()).append("')");
                    break;
                }
                case 6: {
                    sb.append("cordova.require('cordova/base64').toArrayBuffer('").append(this.pluginResult.getMessage()).append("')");
                    break;
                }
            }
            sb.append("],").append(this.pluginResult.getKeepCallback()).append(");");
        }
        
        void encodeAsMessage(final StringBuilder sb) {
            if (this.pluginResult == null) {
                sb.append('J').append(this.jsPayloadOrCallbackId);
                return;
            }
            final int status = this.pluginResult.getStatus();
            boolean b;
            if (status == PluginResult.Status.NO_RESULT.ordinal()) {
                b = true;
            }
            else {
                b = false;
            }
            boolean b2;
            if (status == PluginResult.Status.OK.ordinal()) {
                b2 = true;
            }
            else {
                b2 = false;
            }
            final boolean keepCallback = this.pluginResult.getKeepCallback();
            char c;
            if (b || b2) {
                c = 'S';
            }
            else {
                c = 'F';
            }
            final StringBuilder append = sb.append(c);
            char c2;
            if (keepCallback) {
                c2 = '1';
            }
            else {
                c2 = '0';
            }
            append.append(c2).append(status).append(' ').append(this.jsPayloadOrCallbackId).append(' ');
            switch (this.pluginResult.getMessageType()) {
                default: {
                    sb.append(this.pluginResult.getMessage());
                }
                case 4: {
                    sb.append(this.pluginResult.getMessage().charAt(0));
                }
                case 5: {
                    sb.append('N');
                }
                case 3: {
                    sb.append('n').append(this.pluginResult.getMessage());
                }
                case 1: {
                    sb.append('s');
                    sb.append(this.pluginResult.getStrMessage());
                }
                case 7: {
                    sb.append('S');
                    sb.append(this.pluginResult.getMessage());
                }
                case 6: {
                    sb.append('A');
                    sb.append(this.pluginResult.getMessage());
                }
            }
        }
    }
    
    private class LoadUrlBridgeMode extends BridgeMode
    {
        final Runnable runnable;
        
        private LoadUrlBridgeMode() {
            super((BridgeMode)null);
            this.runnable = new Runnable() {
                @Override
                public void run() {
                    final String access$0 = NativeToJsMessageQueue.this.popAndEncodeAsJs();
                    if (access$0 != null) {
                        NativeToJsMessageQueue.this.webView.loadUrlNow("javascript:" + access$0);
                    }
                }
            };
        }
        
        @Override
        void onNativeToJsMessageAvailable() {
            NativeToJsMessageQueue.this.cordova.getActivity().runOnUiThread(this.runnable);
        }
    }
    
    private class OnlineEventsBridgeMode extends BridgeMode
    {
        private boolean ignoreNextFlush;
        private boolean online;
        final Runnable resetNetworkRunnable;
        final Runnable toggleNetworkRunnable;
        
        private OnlineEventsBridgeMode() {
            super((BridgeMode)null);
            this.toggleNetworkRunnable = new Runnable() {
                @Override
                public void run() {
                    if (!NativeToJsMessageQueue.this.queue.isEmpty()) {
                        OnlineEventsBridgeMode.access$0(OnlineEventsBridgeMode.this, false);
                        NativeToJsMessageQueue.this.webView.setNetworkAvailable(OnlineEventsBridgeMode.this.online);
                    }
                }
            };
            this.resetNetworkRunnable = new Runnable() {
                @Override
                public void run() {
                    OnlineEventsBridgeMode.access$2(OnlineEventsBridgeMode.this, false);
                    OnlineEventsBridgeMode.access$0(OnlineEventsBridgeMode.this, true);
                    NativeToJsMessageQueue.this.webView.setNetworkAvailable(true);
                }
            };
        }
        
        static /* synthetic */ void access$0(final OnlineEventsBridgeMode onlineEventsBridgeMode, final boolean ignoreNextFlush) {
            onlineEventsBridgeMode.ignoreNextFlush = ignoreNextFlush;
        }
        
        static /* synthetic */ void access$2(final OnlineEventsBridgeMode onlineEventsBridgeMode, final boolean online) {
            onlineEventsBridgeMode.online = online;
        }
        
        @Override
        void notifyOfFlush(final boolean b) {
            if (b && !this.ignoreNextFlush) {
                this.online = !this.online;
            }
        }
        
        @Override
        void onNativeToJsMessageAvailable() {
            NativeToJsMessageQueue.this.cordova.getActivity().runOnUiThread(this.toggleNetworkRunnable);
        }
        
        @Override
        void reset() {
            NativeToJsMessageQueue.this.cordova.getActivity().runOnUiThread(this.resetNetworkRunnable);
        }
    }
    
    private class PollingBridgeMode extends BridgeMode
    {
        private PollingBridgeMode() {
            super((BridgeMode)null);
        }
        
        @Override
        void onNativeToJsMessageAvailable() {
        }
    }
    
    private class PrivateApiBridgeMode extends BridgeMode
    {
        private static final int EXECUTE_JS = 194;
        boolean initFailed;
        Method sendMessageMethod;
        Object webViewCore;
        
        private PrivateApiBridgeMode() {
            super((BridgeMode)null);
        }
        
        private void initReflection() {
            Object obj = NativeToJsMessageQueue.this.webView;
            Serializable class1 = WebView.class;
            while (true) {
                try {
                    final Field declaredField = ((Class)class1).getDeclaredField("mProvider");
                    declaredField.setAccessible(true);
                    obj = declaredField.get(NativeToJsMessageQueue.this.webView);
                    class1 = ((CordovaWebView)obj).getClass();
                    try {
                        final Field declaredField2 = ((Class)class1).getDeclaredField("mWebViewCore");
                        declaredField2.setAccessible(true);
                        this.webViewCore = declaredField2.get(obj);
                        if (this.webViewCore != null) {
                            (this.sendMessageMethod = this.webViewCore.getClass().getDeclaredMethod("sendMessage", Message.class)).setAccessible(true);
                        }
                    }
                    catch (Throwable t) {
                        this.initFailed = true;
                        Log.e("JsMessageQueue", "PrivateApiBridgeMode failed to find the expected APIs.", t);
                    }
                }
                catch (Throwable t2) {
                    continue;
                }
                break;
            }
        }
        
        @Override
        void onNativeToJsMessageAvailable() {
            if (this.sendMessageMethod == null && !this.initFailed) {
                this.initReflection();
            }
            if (this.sendMessageMethod == null) {
                return;
            }
            final Message obtain = Message.obtain((Handler)null, 194, (Object)NativeToJsMessageQueue.this.popAndEncodeAsJs());
            try {
                this.sendMessageMethod.invoke(this.webViewCore, obtain);
            }
            catch (Throwable t) {
                Log.e("JsMessageQueue", "Reflection message bridge failed.", t);
            }
        }
    }
}

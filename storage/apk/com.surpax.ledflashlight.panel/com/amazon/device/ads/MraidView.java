// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import java.util.ArrayList;
import android.os.Build$VERSION;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.content.Context;
import java.util.HashMap;
import android.annotation.SuppressLint;
import android.widget.FrameLayout;

@SuppressLint({ "ViewConstructor" })
class MraidView extends FrameLayout
{
    private static final String JAVASCRIPT_TEXT = "(function(){var mraidbridge=window.mraidbridge={};var listeners={};var nativeCallQueue=[];var nativeCallInFlight=false;mraidbridge.fireReadyEvent=function(){mraidbridge.fireEvent('ready')};mraidbridge.fireChangeEvent=function(properties){mraidbridge.fireEvent('change',properties)};mraidbridge.fireErrorEvent=function(message,action){mraidbridge.fireEvent('error',message,action)};mraidbridge.fireEvent=function(type){var ls=listeners[type];if(ls){var args=Array.prototype.slice.call(arguments);args.shift();var l=ls.length;for(var i=0;i<l;i++){ls[i].apply(null,args)}}};mraidbridge.nativeCallComplete=function(command){if(nativeCallQueue.length===0){nativeCallInFlight=false;return}var nextCall=nativeCallQueue.pop();window.location=nextCall};mraidbridge.executeNativeCall=function(command){var call='mraid://'+command;var key,value;var isFirstArgument=true;for(var i=1;i<arguments.length;i+=2){key=arguments[i];value=arguments[i+1];if(value===null)continue;if(isFirstArgument){call+='?';isFirstArgument=false}else{call+='&'}call+=key+'='+escape(value)}if(nativeCallInFlight){nativeCallQueue.push(call)}else{nativeCallInFlight=true;window.location=call}};mraidbridge.addEventListener=function(event,listener){var eventListeners;listeners[event]=listeners[event]||[];eventListeners=listeners[event];for(var l in eventListeners){if(listener===l)return}eventListeners.push(listener)};mraidbridge.removeEventListener=function(event,listener){if(listeners.hasOwnProperty(event)){var eventListeners=listeners[event];if(eventListeners){var idx=eventListeners.indexOf(listener);if(idx!==-1){eventListeners.splice(idx,1)}}}}}());(function(){var mraid=window.mraid={};var bridge=window.mraidbridge;var VERSION=mraid.VERSION='1.0';var STATES=mraid.STATES={LOADING:'loading',DEFAULT:'default',EXPANDED:'expanded',HIDDEN:'hidden',};var EVENTS=mraid.EVENTS={ERROR:'error',INFO:'info',READY:'ready',STATECHANGE:'stateChange',VIEWABLECHANGE:'viewableChange'};var PLACEMENT_TYPES=mraid.PLACEMENT_TYPES={UNKNOWN:'unknown',INLINE:'inline',INTERSTITIAL:'interstitial'};var LOG_LEVELS=mraid.LOG_LEVELS={INFO:4,DEBUG:3,VERBOSE:2,WARNING:5,ERROR:6};var expandProperties={width:-1,height:-1,useCustomClose:false,isModal:true,lockOrientation:true};var hasSetCustomSize=false;var hasSetCustomClose=false;var listeners={};var state=STATES.LOADING;var isViewable=false;var screenSize={width:-1,height:-1};var placementType=PLACEMENT_TYPES.UNKNOWN;var EventListeners=function(event){this.event=event;this.count=0;var listeners={};this.add=function(func){var id=String(func);if(!listeners[id]){listeners[id]=func;this.count++}};this.remove=function(func){var id=String(func);if(listeners[id]){listeners[id]=null;delete listeners[id];this.count--;return true}else{return false}};this.removeAll=function(){for(var id in listeners){if(listeners.hasOwnProperty(id))this.remove(listeners[id])}};this.broadcast=function(args){for(var id in listeners){if(listeners.hasOwnProperty(id))listeners[id].apply({},args)}};this.toString=function(){var out=[event,':'];for(var id in listeners){if(listeners.hasOwnProperty(id))out.push('|',id,'|')}return out.join('')}};var broadcastEvent=function(){var args=new Array(arguments.length);var l=arguments.length;for(var i=0;i<l;i++)args[i]=arguments[i];var event=args.shift();if(listeners[event])listeners[event].broadcast(args)};var contains=function(value,array){for(var i in array){if(array[i]===value)return true}return false};var clone=function(obj){if(obj===null)return null;var f=function(){};f.prototype=obj;return new f()};var stringify=function(obj){if(typeof obj==='object'){var out=[];if(obj.push){for(var p in obj)out.push(obj[p]);return'['+out.join(',')+']'}else{for(var p in obj)out.push(\"'\"+p+\"': \"+obj[p]);return'{'+out.join(',')+'}'}}else return String(obj)};var trim=function(str){return str.replace(/^\\s+|\\s+$/g,'')};var changeHandlers={state:function(val){if(state===STATES.LOADING){broadcastEvent(EVENTS.INFO,'Native SDK initialized.')}state=val;broadcastEvent(EVENTS.INFO,'Set state to '+stringify(val));broadcastEvent(EVENTS.STATECHANGE,state)},viewable:function(val){isViewable=val;broadcastEvent(EVENTS.INFO,'Set isViewable to '+stringify(val));broadcastEvent(EVENTS.VIEWABLECHANGE,isViewable)},placementType:function(val){broadcastEvent(EVENTS.INFO,'Set placementType to '+stringify(val));placementType=val},screenSize:function(val){broadcastEvent(EVENTS.INFO,'Set screenSize to '+stringify(val));for(var key in val){if(val.hasOwnProperty(key))screenSize[key]=val[key]}if(!hasSetCustomSize){expandProperties['width']=screenSize['width'];expandProperties['height']=screenSize['height']}},expandProperties:function(val){broadcastEvent(EVENTS.INFO,'Merging expandProperties with '+stringify(val));for(var key in val){if(val.hasOwnProperty(key))expandProperties[key]=val[key]}}};var validate=function(obj,validators,action,merge){if(!merge){if(obj===null){broadcastEvent(EVENTS.ERROR,'Required object not provided.',action);return false}else{for(var i in validators){if(validators.hasOwnProperty(i)&&obj[i]===undefined){broadcastEvent(EVENTS.ERROR,'Object is missing required property: '+i+'.',action);return false}}}}for(var prop in obj){var validator=validators[prop];var value=obj[prop];if(validator&&!validator(value)){broadcastEvent(EVENTS.ERROR,'Value of property '+prop+' is invalid.',action);return false}}return true};var expandPropertyValidators={width:function(v){return!isNaN(v)&&v>=0},height:function(v){return!isNaN(v)&&v>=0},useCustomClose:function(v){return(typeof v==='boolean')},lockOrientation:function(v){return(typeof v==='boolean')}};bridge.addEventListener('change',function(properties){for(var p in properties){if(properties.hasOwnProperty(p)){var handler=changeHandlers[p];handler(properties[p])}}});bridge.addEventListener('error',function(message,action){broadcastEvent(EVENTS.ERROR,message,action)});bridge.addEventListener('ready',function(){broadcastEvent(EVENTS.READY)});mraid.addEventListener=function(event,listener){if(!event||!listener){broadcastEvent(EVENTS.ERROR,'Both event and listener are required.','addEventListener')}else if(!contains(event,EVENTS)){broadcastEvent(EVENTS.ERROR,'Unknown MRAID event: '+event,'addEventListener')}else{if(!listeners[event])listeners[event]=new EventListeners(event);listeners[event].add(listener)}};mraid.close=function(){if(state===STATES.HIDDEN){broadcastEvent(EVENTS.ERROR,'Ad cannot be closed when it is already hidden.','close')}else bridge.executeNativeCall('close')};mraid.playVideo=function(URL,properties){if(state==STATES.DEFAULT||state==STATES.EXPANDED){var args=['playVideo'];if(URL){args=args.concat(['url',URL])}var audioMuted=false,autoPlay=true,controls=true,loop=false,position=[-1,-1,-1,-1],startStyle='normal',stopStyle='normal';if(properties){if((typeof properties.audio!=\"undefined\")&&(properties.audio!=null)){audioMuted=properties.audio}if((typeof properties.autoplay!=\"undefined\")&&(properties.autoplay!=null)){autoPlay=properties.autoplay}if((typeof properties.controls!=\"undefined\")&&(properties.controls!=null)){controls=properties.controls}if((typeof properties.loop!=\"undefined\")&&(properties.loop!=null)){loop=properties.loop}if((typeof properties.position!=\"undefined\")&&(properties.position!=null)){inline=new Array(4);inline[0]=properties.position.top;inline[1]=properties.position.left;if((typeof properties.position.width!=\"undefined\")&&(properties.position.width!=null)){inline[2]=properties.position.width}if((typeof properties.position.height!=\"undefined\")&&(properties.position.height!=null)){inline[3]=properties.position.height}position=inline}if((typeof properties.startStyle!=\"undefined\")&&(properties.startStyle!=null)){startStyle=properties.startStyle}if((typeof properties.stopStyle!=\"undefined\")&&(properties.stopStyle!=null)){stopStyle=properties.stopStyle}if(loop){stopStyle='normal';controls=true}if(!autoPlay){controls=true}if(!controls){stopStyle='exit'}if(position[0]==-1||position[1]==-1){startStyle='fullscreen';autoPlay=true}args=args.concat(['audioMuted',audioMuted]);args=args.concat(['autoPlay',autoPlay]);args=args.concat(['controls',controls]);args=args.concat(['loop',loop]);args=args.concat(['position',position]);args=args.concat(['startStyle',startStyle]);args=args.concat(['stopStyle',stopStyle])}bridge.executeNativeCall.apply(this,args)}};mraid.log=function(level,log){var args=['log','level',level,'log',log];bridge.executeNativeCall.apply(this,args)};mraid.expand=function(URL){if(state!==STATES.DEFAULT){broadcastEvent(EVENTS.ERROR,'Ad can only be expanded from the default state.','expand')}else{var args=['expand'];if(hasSetCustomClose){args=args.concat(['shouldUseCustomClose',expandProperties.useCustomClose?'true':'false'])}if(hasSetCustomSize){if(expandProperties.width>=0&&expandProperties.height>=0){args=args.concat(['w',expandProperties.width,'h',expandProperties.height])}}if(typeof expandProperties.lockOrientation!=='undefined'){args=args.concat(['lockOrientation',expandProperties.lockOrientation])}if(URL){args=args.concat(['url',URL])}bridge.executeNativeCall.apply(this,args)}};mraid.getExpandProperties=function(){var properties={width:expandProperties.width,height:expandProperties.height,useCustomClose:expandProperties.useCustomClose,isModal:expandProperties.isModal};return properties};mraid.getPlacementType=function(){return placementType};mraid.getState=function(){return state};mraid.getVersion=function(){return mraid.VERSION};mraid.isViewable=function(){return isViewable};mraid.open=function(URL){if(!URL)broadcastEvent(EVENTS.ERROR,'URL is required.','open');else bridge.executeNativeCall('open','url',URL)};mraid.removeEventListener=function(event,listener){if(!event)broadcastEvent(EVENTS.ERROR,'Event is required.','removeEventListener');else{if(listener&&(!listeners[event]||!listeners[event].remove(listener))){broadcastEvent(EVENTS.ERROR,'Listener not currently registered for event.','removeEventListener');return}else if(listeners[event])listeners[event].removeAll();if(listeners[event]&&listeners[event].count===0){listeners[event]=null;delete listeners[event]}}};mraid.setExpandProperties=function(properties){if(validate(properties,expandPropertyValidators,'setExpandProperties',true)){if(properties.hasOwnProperty('width')||properties.hasOwnProperty('height')){hasSetCustomSize=true}if(properties.hasOwnProperty('useCustomClose'))hasSetCustomClose=true;var desiredProperties=['width','height','useCustomClose','lockOrientation'];var length=desiredProperties.length;for(var i=0;i<length;i++){var propname=desiredProperties[i];if(properties.hasOwnProperty(propname))expandProperties[propname]=properties[propname]}}};mraid.useCustomClose=function(shouldUseCustomClose){expandProperties.useCustomClose=shouldUseCustomClose;hasSetCustomClose=true;bridge.executeNativeCall('usecustomclose','shouldUseCustomClose',shouldUseCustomClose)}}());";
    private static final String LOGTAG;
    private static HashMap mraidViewCache;
    protected AdView adView;
    private Context context_;
    private boolean mAttached;
    private MraidBrowserController mBrowserController;
    private MraidDisplayController mDisplayController;
    private boolean mGoingAway;
    private boolean mHasFiredReadyEvent;
    private int mLastVisibility;
    private MraidView$MraidListenerInfo mListenerInfo;
    private final MraidView$PlacementType mPlacementType;
    private WebChromeClient mWebChromeClient;
    private WebViewClient mWebViewClient;
    protected double scalingMultiplier_;
    protected boolean shouldForceRenderFailure;
    private WebView webView_;
    private int windowHeight_;
    private int windowWidth_;
    
    static {
        LOGTAG = MraidView.class.getSimpleName();
    }
    
    public MraidView(final AdView adView, final int n, final int n2, final double n3, final Context context, final WebView webView) {
        this(adView, n, n2, n3, context, webView, MraidView$ExpansionStyle.ENABLED, MraidView$NativeCloseButtonStyle.AD_CONTROLLED, MraidView$PlacementType.INLINE);
    }
    
    MraidView(final AdView adView, final int windowWidth_, final int windowHeight_, final double scalingMultiplier_, final Context context_, final WebView webView_, final MraidView$ExpansionStyle mraidView$ExpansionStyle, final MraidView$NativeCloseButtonStyle mraidView$NativeCloseButtonStyle, final MraidView$PlacementType mPlacementType) {
        super(context_);
        this.mAttached = false;
        this.mLastVisibility = 8;
        this.shouldForceRenderFailure = false;
        this.mGoingAway = false;
        this.adView = adView;
        this.mPlacementType = mPlacementType;
        this.windowHeight_ = windowHeight_;
        this.windowWidth_ = windowWidth_;
        this.scalingMultiplier_ = scalingMultiplier_;
        this.context_ = context_;
        this.webView_ = webView_;
        this.setWebViewHeightToAdHeight();
        this.addView((View)this.webView_);
        if (Build$VERSION.SDK_INT >= 11 && this.shouldDisableWebViewHardwareAcceleration()) {
            this.disableHardwareAcceleration();
        }
        this.initialize(mraidView$ExpansionStyle, mraidView$NativeCloseButtonStyle);
    }
    
    public MraidView(final AdView adView, final Context context, final WebView webView) {
        this(adView, 0, 0, 0.0, context, webView, MraidView$ExpansionStyle.DISABLED, MraidView$NativeCloseButtonStyle.ALWAYS_HIDDEN, MraidView$PlacementType.INLINE);
    }
    
    public static void cacheMraidView(final String key, final MraidView value) {
        getMraidViewCache().put(key, value);
    }
    
    public static MraidView getCachedMraidView(final String key) {
        return getMraidViewCache().get(key);
    }
    
    static HashMap getMraidViewCache() {
        if (MraidView.mraidViewCache == null) {
            MraidView.mraidViewCache = new HashMap();
        }
        return MraidView.mraidViewCache;
    }
    
    private void notifyOnFailureListener() {
        if (this.mListenerInfo.mOnFailureListener != null) {
            this.mListenerInfo.mOnFailureListener.onFailure(this);
        }
    }
    
    public static MraidView removeCachedMraidView(final String key) {
        return getMraidViewCache().remove(key);
    }
    
    private void setupAdWebViewClient() {
        final AdWebViewClient mWebViewClient = new AdWebViewClient(this.adView, this.context_);
        mWebViewClient.putUrlExecutor("mraid", this.createMraidExecutor());
        mWebViewClient.putUrlExecutor("amazonmobile", this.adView.getSpecialUrlExecutor());
        this.setWebViewsWebViewClient(this.mWebViewClient = mWebViewClient);
    }
    
    protected MraidView$MraidExecutor createMraidExecutor() {
        return new MraidView$MraidExecutor(this);
    }
    
    public void destroy() {
        this.mDisplayController.destroy();
        this.removeView((View)this.webView_);
        this.webView_.destroy();
    }
    
    protected void disableHardwareAcceleration() {
        AndroidTargetUtils.disableHardwareAcceleration((View)this);
    }
    
    protected void fireChangeEventForProperties(final ArrayList list) {
        final String string = list.toString();
        if (string.length() < 2) {
            return;
        }
        final String string2 = "{" + string.substring(1, -1 + string.length()) + "}";
        this.injectJavaScript("window.mraidbridge.fireChangeEvent(" + string2 + ");");
        Log.d(MraidView.LOGTAG, "Fire changes: %s", string2);
    }
    
    protected void fireChangeEventForProperty(final MraidProperty mraidProperty) {
        final String string = "{" + mraidProperty.toString() + "}";
        this.injectJavaScript("window.mraidbridge.fireChangeEvent(" + string + ");");
        Log.d(MraidView.LOGTAG, "Fire change: %s", string);
    }
    
    protected void fireErrorEvent(final String str, final String str2) {
        this.injectJavaScript("window.mraidbridge.fireErrorEvent('" + str + "', '" + str2 + "');");
    }
    
    protected void fireNativeCommandCompleteEvent(final String str) {
        this.injectJavaScript("window.mraidbridge.nativeCallComplete('" + str + "');");
    }
    
    protected void fireReadyEvent() {
        this.injectJavaScript("window.mraidbridge.fireReadyEvent();");
    }
    
    protected AdView getAdView() {
        return this.adView;
    }
    
    protected MraidBrowserController getBrowserController() {
        return this.mBrowserController;
    }
    
    protected MraidDisplayController getDisplayController() {
        return this.mDisplayController;
    }
    
    public MraidView$OnCloseButtonStateChangeListener getOnCloseButtonStateChangeListener() {
        return this.mListenerInfo.mOnCloseButtonListener;
    }
    
    public MraidView$OnCloseListener getOnCloseListener() {
        return this.mListenerInfo.mOnCloseListener;
    }
    
    public MraidView$OnExpandListener getOnExpandListener() {
        return this.mListenerInfo.mOnExpandListener;
    }
    
    public MraidView$OnFailureListener getOnFailureListener() {
        return this.mListenerInfo.mOnFailureListener;
    }
    
    public MraidView$OnOpenListener getOnOpenListener() {
        return this.mListenerInfo.mOnOpenListener;
    }
    
    public MraidView$OnReadyListener getOnReadyListener() {
        return this.mListenerInfo.mOnReadyListener;
    }
    
    public MraidView$OnSpecialUrlClickListener getOnSpecialUrlClickListener() {
        return this.mListenerInfo.mOnSpecialUrlClickListener;
    }
    
    protected double getScalingMultiplier() {
        return this.scalingMultiplier_;
    }
    
    public boolean getShouldForceRenderFailure() {
        return this.shouldForceRenderFailure;
    }
    
    public WebView getWebView() {
        return this.webView_;
    }
    
    protected int getWindowHeight() {
        return this.windowHeight_;
    }
    
    protected int getWindowWidth() {
        return this.windowWidth_;
    }
    
    protected void initialize(final MraidView$ExpansionStyle mraidView$ExpansionStyle, final MraidView$NativeCloseButtonStyle mraidView$NativeCloseButtonStyle) {
        boolean shouldForceRenderFailure = true;
        this.mBrowserController = new MraidBrowserController(this);
        this.mDisplayController = new MraidDisplayController(this, mraidView$ExpansionStyle, mraidView$NativeCloseButtonStyle);
        this.webView_.setScrollContainer(false);
        this.webView_.setBackgroundColor(0);
        this.webView_.setVerticalScrollBarEnabled(false);
        this.webView_.setHorizontalScrollBarEnabled(false);
        if (WebViewFactory.setJavaScriptEnabledForWebView(shouldForceRenderFailure, this.webView_, MraidView.LOGTAG)) {
            shouldForceRenderFailure = false;
        }
        this.shouldForceRenderFailure = shouldForceRenderFailure;
        this.setupAdWebViewClient();
        this.mWebChromeClient = new MraidView$MraidWebChromeClient(this);
        this.webView_.setWebChromeClient(this.mWebChromeClient);
        this.mListenerInfo = new MraidView$MraidListenerInfo();
    }
    
    protected void injectJavaScript(final String str) {
        if (str != null) {
            this.webView_.loadUrl("javascript:" + str);
        }
    }
    
    public boolean loadHtmlData(final String s) {
        return this.loadHtmlData(null, s);
    }
    
    public boolean loadHtmlData(final String s, String string) {
        if (string.indexOf("<html>") == -1) {
            string = "<html><meta name=\"viewport\" content=\"width=" + this.windowWidth_ + ", height=" + this.windowHeight_ + ", initial-scale=" + AdUtils.getViewportInitialScale(this.scalingMultiplier_) + ", minimum-scale=" + this.scalingMultiplier_ + ", maximum-scale=" + this.scalingMultiplier_ + "\"/><head></head><body style='margin:0;padding:0;'>" + string + "</body></html>";
        }
        this.webView_.loadDataWithBaseURL(s, string.replace("<head>", "<head><script type='text/javascript'>(function(){var mraidbridge=window.mraidbridge={};var listeners={};var nativeCallQueue=[];var nativeCallInFlight=false;mraidbridge.fireReadyEvent=function(){mraidbridge.fireEvent('ready')};mraidbridge.fireChangeEvent=function(properties){mraidbridge.fireEvent('change',properties)};mraidbridge.fireErrorEvent=function(message,action){mraidbridge.fireEvent('error',message,action)};mraidbridge.fireEvent=function(type){var ls=listeners[type];if(ls){var args=Array.prototype.slice.call(arguments);args.shift();var l=ls.length;for(var i=0;i<l;i++){ls[i].apply(null,args)}}};mraidbridge.nativeCallComplete=function(command){if(nativeCallQueue.length===0){nativeCallInFlight=false;return}var nextCall=nativeCallQueue.pop();window.location=nextCall};mraidbridge.executeNativeCall=function(command){var call='mraid://'+command;var key,value;var isFirstArgument=true;for(var i=1;i<arguments.length;i+=2){key=arguments[i];value=arguments[i+1];if(value===null)continue;if(isFirstArgument){call+='?';isFirstArgument=false}else{call+='&'}call+=key+'='+escape(value)}if(nativeCallInFlight){nativeCallQueue.push(call)}else{nativeCallInFlight=true;window.location=call}};mraidbridge.addEventListener=function(event,listener){var eventListeners;listeners[event]=listeners[event]||[];eventListeners=listeners[event];for(var l in eventListeners){if(listener===l)return}eventListeners.push(listener)};mraidbridge.removeEventListener=function(event,listener){if(listeners.hasOwnProperty(event)){var eventListeners=listeners[event];if(eventListeners){var idx=eventListeners.indexOf(listener);if(idx!==-1){eventListeners.splice(idx,1)}}}}}());(function(){var mraid=window.mraid={};var bridge=window.mraidbridge;var VERSION=mraid.VERSION='1.0';var STATES=mraid.STATES={LOADING:'loading',DEFAULT:'default',EXPANDED:'expanded',HIDDEN:'hidden',};var EVENTS=mraid.EVENTS={ERROR:'error',INFO:'info',READY:'ready',STATECHANGE:'stateChange',VIEWABLECHANGE:'viewableChange'};var PLACEMENT_TYPES=mraid.PLACEMENT_TYPES={UNKNOWN:'unknown',INLINE:'inline',INTERSTITIAL:'interstitial'};var LOG_LEVELS=mraid.LOG_LEVELS={INFO:4,DEBUG:3,VERBOSE:2,WARNING:5,ERROR:6};var expandProperties={width:-1,height:-1,useCustomClose:false,isModal:true,lockOrientation:true};var hasSetCustomSize=false;var hasSetCustomClose=false;var listeners={};var state=STATES.LOADING;var isViewable=false;var screenSize={width:-1,height:-1};var placementType=PLACEMENT_TYPES.UNKNOWN;var EventListeners=function(event){this.event=event;this.count=0;var listeners={};this.add=function(func){var id=String(func);if(!listeners[id]){listeners[id]=func;this.count++}};this.remove=function(func){var id=String(func);if(listeners[id]){listeners[id]=null;delete listeners[id];this.count--;return true}else{return false}};this.removeAll=function(){for(var id in listeners){if(listeners.hasOwnProperty(id))this.remove(listeners[id])}};this.broadcast=function(args){for(var id in listeners){if(listeners.hasOwnProperty(id))listeners[id].apply({},args)}};this.toString=function(){var out=[event,':'];for(var id in listeners){if(listeners.hasOwnProperty(id))out.push('|',id,'|')}return out.join('')}};var broadcastEvent=function(){var args=new Array(arguments.length);var l=arguments.length;for(var i=0;i<l;i++)args[i]=arguments[i];var event=args.shift();if(listeners[event])listeners[event].broadcast(args)};var contains=function(value,array){for(var i in array){if(array[i]===value)return true}return false};var clone=function(obj){if(obj===null)return null;var f=function(){};f.prototype=obj;return new f()};var stringify=function(obj){if(typeof obj==='object'){var out=[];if(obj.push){for(var p in obj)out.push(obj[p]);return'['+out.join(',')+']'}else{for(var p in obj)out.push(\"'\"+p+\"': \"+obj[p]);return'{'+out.join(',')+'}'}}else return String(obj)};var trim=function(str){return str.replace(/^\\s+|\\s+$/g,'')};var changeHandlers={state:function(val){if(state===STATES.LOADING){broadcastEvent(EVENTS.INFO,'Native SDK initialized.')}state=val;broadcastEvent(EVENTS.INFO,'Set state to '+stringify(val));broadcastEvent(EVENTS.STATECHANGE,state)},viewable:function(val){isViewable=val;broadcastEvent(EVENTS.INFO,'Set isViewable to '+stringify(val));broadcastEvent(EVENTS.VIEWABLECHANGE,isViewable)},placementType:function(val){broadcastEvent(EVENTS.INFO,'Set placementType to '+stringify(val));placementType=val},screenSize:function(val){broadcastEvent(EVENTS.INFO,'Set screenSize to '+stringify(val));for(var key in val){if(val.hasOwnProperty(key))screenSize[key]=val[key]}if(!hasSetCustomSize){expandProperties['width']=screenSize['width'];expandProperties['height']=screenSize['height']}},expandProperties:function(val){broadcastEvent(EVENTS.INFO,'Merging expandProperties with '+stringify(val));for(var key in val){if(val.hasOwnProperty(key))expandProperties[key]=val[key]}}};var validate=function(obj,validators,action,merge){if(!merge){if(obj===null){broadcastEvent(EVENTS.ERROR,'Required object not provided.',action);return false}else{for(var i in validators){if(validators.hasOwnProperty(i)&&obj[i]===undefined){broadcastEvent(EVENTS.ERROR,'Object is missing required property: '+i+'.',action);return false}}}}for(var prop in obj){var validator=validators[prop];var value=obj[prop];if(validator&&!validator(value)){broadcastEvent(EVENTS.ERROR,'Value of property '+prop+' is invalid.',action);return false}}return true};var expandPropertyValidators={width:function(v){return!isNaN(v)&&v>=0},height:function(v){return!isNaN(v)&&v>=0},useCustomClose:function(v){return(typeof v==='boolean')},lockOrientation:function(v){return(typeof v==='boolean')}};bridge.addEventListener('change',function(properties){for(var p in properties){if(properties.hasOwnProperty(p)){var handler=changeHandlers[p];handler(properties[p])}}});bridge.addEventListener('error',function(message,action){broadcastEvent(EVENTS.ERROR,message,action)});bridge.addEventListener('ready',function(){broadcastEvent(EVENTS.READY)});mraid.addEventListener=function(event,listener){if(!event||!listener){broadcastEvent(EVENTS.ERROR,'Both event and listener are required.','addEventListener')}else if(!contains(event,EVENTS)){broadcastEvent(EVENTS.ERROR,'Unknown MRAID event: '+event,'addEventListener')}else{if(!listeners[event])listeners[event]=new EventListeners(event);listeners[event].add(listener)}};mraid.close=function(){if(state===STATES.HIDDEN){broadcastEvent(EVENTS.ERROR,'Ad cannot be closed when it is already hidden.','close')}else bridge.executeNativeCall('close')};mraid.playVideo=function(URL,properties){if(state==STATES.DEFAULT||state==STATES.EXPANDED){var args=['playVideo'];if(URL){args=args.concat(['url',URL])}var audioMuted=false,autoPlay=true,controls=true,loop=false,position=[-1,-1,-1,-1],startStyle='normal',stopStyle='normal';if(properties){if((typeof properties.audio!=\"undefined\")&&(properties.audio!=null)){audioMuted=properties.audio}if((typeof properties.autoplay!=\"undefined\")&&(properties.autoplay!=null)){autoPlay=properties.autoplay}if((typeof properties.controls!=\"undefined\")&&(properties.controls!=null)){controls=properties.controls}if((typeof properties.loop!=\"undefined\")&&(properties.loop!=null)){loop=properties.loop}if((typeof properties.position!=\"undefined\")&&(properties.position!=null)){inline=new Array(4);inline[0]=properties.position.top;inline[1]=properties.position.left;if((typeof properties.position.width!=\"undefined\")&&(properties.position.width!=null)){inline[2]=properties.position.width}if((typeof properties.position.height!=\"undefined\")&&(properties.position.height!=null)){inline[3]=properties.position.height}position=inline}if((typeof properties.startStyle!=\"undefined\")&&(properties.startStyle!=null)){startStyle=properties.startStyle}if((typeof properties.stopStyle!=\"undefined\")&&(properties.stopStyle!=null)){stopStyle=properties.stopStyle}if(loop){stopStyle='normal';controls=true}if(!autoPlay){controls=true}if(!controls){stopStyle='exit'}if(position[0]==-1||position[1]==-1){startStyle='fullscreen';autoPlay=true}args=args.concat(['audioMuted',audioMuted]);args=args.concat(['autoPlay',autoPlay]);args=args.concat(['controls',controls]);args=args.concat(['loop',loop]);args=args.concat(['position',position]);args=args.concat(['startStyle',startStyle]);args=args.concat(['stopStyle',stopStyle])}bridge.executeNativeCall.apply(this,args)}};mraid.log=function(level,log){var args=['log','level',level,'log',log];bridge.executeNativeCall.apply(this,args)};mraid.expand=function(URL){if(state!==STATES.DEFAULT){broadcastEvent(EVENTS.ERROR,'Ad can only be expanded from the default state.','expand')}else{var args=['expand'];if(hasSetCustomClose){args=args.concat(['shouldUseCustomClose',expandProperties.useCustomClose?'true':'false'])}if(hasSetCustomSize){if(expandProperties.width>=0&&expandProperties.height>=0){args=args.concat(['w',expandProperties.width,'h',expandProperties.height])}}if(typeof expandProperties.lockOrientation!=='undefined'){args=args.concat(['lockOrientation',expandProperties.lockOrientation])}if(URL){args=args.concat(['url',URL])}bridge.executeNativeCall.apply(this,args)}};mraid.getExpandProperties=function(){var properties={width:expandProperties.width,height:expandProperties.height,useCustomClose:expandProperties.useCustomClose,isModal:expandProperties.isModal};return properties};mraid.getPlacementType=function(){return placementType};mraid.getState=function(){return state};mraid.getVersion=function(){return mraid.VERSION};mraid.isViewable=function(){return isViewable};mraid.open=function(URL){if(!URL)broadcastEvent(EVENTS.ERROR,'URL is required.','open');else bridge.executeNativeCall('open','url',URL)};mraid.removeEventListener=function(event,listener){if(!event)broadcastEvent(EVENTS.ERROR,'Event is required.','removeEventListener');else{if(listener&&(!listeners[event]||!listeners[event].remove(listener))){broadcastEvent(EVENTS.ERROR,'Listener not currently registered for event.','removeEventListener');return}else if(listeners[event])listeners[event].removeAll();if(listeners[event]&&listeners[event].count===0){listeners[event]=null;delete listeners[event]}}};mraid.setExpandProperties=function(properties){if(validate(properties,expandPropertyValidators,'setExpandProperties',true)){if(properties.hasOwnProperty('width')||properties.hasOwnProperty('height')){hasSetCustomSize=true}if(properties.hasOwnProperty('useCustomClose'))hasSetCustomClose=true;var desiredProperties=['width','height','useCustomClose','lockOrientation'];var length=desiredProperties.length;for(var i=0;i<length;i++){var propname=desiredProperties[i];if(properties.hasOwnProperty(propname))expandProperties[propname]=properties[propname]}}};mraid.useCustomClose=function(shouldUseCustomClose){expandProperties.useCustomClose=shouldUseCustomClose;hasSetCustomClose=true;bridge.executeNativeCall('usecustomclose','shouldUseCustomClose',shouldUseCustomClose)}}());</script>"), "text/html", "UTF-8", (String)null);
        return true;
    }
    
    public void loadUrlForTwoPartExpansionView(final String urlString) {
        final WebRequest newWebRequest = WebRequest.createNewWebRequest();
        newWebRequest.setUrlString(urlString);
        try {
            this.loadHtmlData(newWebRequest.makeCall().getBody());
        }
        catch (WebRequest$WebRequestException ex) {
            this.notifyOnFailureListener();
        }
    }
    
    protected void onAttachedToWindow() {
        if (!this.mGoingAway) {
            super.onAttachedToWindow();
            this.mAttached = true;
            if (this.mDisplayController != null) {
                this.mDisplayController.registerReceivers();
            }
        }
    }
    
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttached = false;
        if (this.mDisplayController != null) {
            this.mDisplayController.unregisterReceivers();
        }
    }
    
    protected void onPageFinished() {
        if (!this.mHasFiredReadyEvent) {
            this.mDisplayController.initializeJavaScriptState();
            this.fireChangeEventForProperty(MraidPlacementTypeProperty.createWithType(this.mPlacementType));
            this.fireReadyEvent();
            if (this.getOnReadyListener() != null) {
                this.getOnReadyListener().onReady(this);
            }
            this.mHasFiredReadyEvent = true;
            this.mDisplayController.surfaceAd();
        }
    }
    
    protected void onWindowVisibilityChanged(final int n) {
        if (this.mAttached && this.mLastVisibility != n && n != 0 && this.mDisplayController != null) {
            this.mDisplayController.unregisterReceivers();
        }
    }
    
    public void prepareToGoAway() {
        this.mGoingAway = true;
        if (this.mDisplayController != null) {
            this.mDisplayController.detachExpandedView();
        }
    }
    
    public void registerReceivers() {
        this.mDisplayController.registerReceivers();
    }
    
    public void setAdView(final AdView adView) {
        this.adView = adView;
        this.setWebViewHeightToAdHeight();
        this.setupAdWebViewClient();
    }
    
    protected void setMraidBrowserController(final MraidBrowserController mBrowserController) {
        this.mBrowserController = mBrowserController;
    }
    
    protected void setMraidDisplayController(final MraidDisplayController mDisplayController) {
        this.mDisplayController = mDisplayController;
    }
    
    protected void setMraidListenerInfo(final MraidView$MraidListenerInfo mListenerInfo) {
        this.mListenerInfo = mListenerInfo;
    }
    
    public void setOnCloseButtonStateChange(final MraidView$OnCloseButtonStateChangeListener mraidView$OnCloseButtonStateChangeListener) {
        this.mListenerInfo.mOnCloseButtonListener = mraidView$OnCloseButtonStateChangeListener;
    }
    
    public void setOnCloseListener(final MraidView$OnCloseListener mraidView$OnCloseListener) {
        this.mListenerInfo.mOnCloseListener = mraidView$OnCloseListener;
    }
    
    public void setOnExpandListener(final MraidView$OnExpandListener mraidView$OnExpandListener) {
        this.mListenerInfo.mOnExpandListener = mraidView$OnExpandListener;
    }
    
    public void setOnFailureListener(final MraidView$OnFailureListener mraidView$OnFailureListener) {
        this.mListenerInfo.mOnFailureListener = mraidView$OnFailureListener;
    }
    
    public void setOnOpenListener(final MraidView$OnOpenListener mraidView$OnOpenListener) {
        this.mListenerInfo.mOnOpenListener = mraidView$OnOpenListener;
    }
    
    public void setOnReadyListener(final MraidView$OnReadyListener mraidView$OnReadyListener) {
        this.mListenerInfo.mOnReadyListener = mraidView$OnReadyListener;
    }
    
    public void setOnSpecialUrlClickListener(final MraidView$OnSpecialUrlClickListener mraidView$OnSpecialUrlClickListener) {
        this.mListenerInfo.mOnSpecialUrlClickListener = mraidView$OnSpecialUrlClickListener;
    }
    
    protected void setWebChromeClient(final WebChromeClient mWebChromeClient) {
        this.mWebChromeClient = mWebChromeClient;
    }
    
    protected void setWebViewClient(final WebViewClient mWebViewClient) {
        this.mWebViewClient = mWebViewClient;
    }
    
    protected void setWebViewHeightToAdHeight() {
        final int n = (int)(this.adView.getHeight() * this.scalingMultiplier_ * InternalAdRegistration.getInstance().getDeviceInfo().getScalingFactorAsFloat());
        if (n > 0) {
            this.setWebViewLayoutParams(-1, n);
        }
    }
    
    protected void setWebViewLayoutParams(final int n, final int n2) {
        this.webView_.setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(n, n2));
    }
    
    protected void setWebViewsWebViewClient(final WebViewClient webViewClient) {
        this.webView_.setWebViewClient(webViewClient);
    }
    
    public boolean shouldDisableWebViewHardwareAcceleration() {
        return this.adView.shouldDisableWebViewHardwareAcceleration();
    }
    
    public void unregisterReceivers() {
        this.mDisplayController.unregisterReceivers();
    }
}

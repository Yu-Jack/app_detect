// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import android.util.Base64;
import org.json.JSONObject;
import org.json.JSONArray;

public class PluginResult
{
    public static final int MESSAGE_TYPE_ARRAYBUFFER = 6;
    public static final int MESSAGE_TYPE_BINARYSTRING = 7;
    public static final int MESSAGE_TYPE_BOOLEAN = 4;
    public static final int MESSAGE_TYPE_JSON = 2;
    public static final int MESSAGE_TYPE_NULL = 5;
    public static final int MESSAGE_TYPE_NUMBER = 3;
    public static final int MESSAGE_TYPE_STRING = 1;
    public static String[] StatusMessages;
    private String encodedMessage;
    private boolean keepCallback;
    private final int messageType;
    private final int status;
    private String strMessage;
    
    static {
        PluginResult.StatusMessages = new String[] { "No result", "OK", "Class not found", "Illegal access", "Instantiation error", "Malformed url", "IO error", "Invalid action", "JSON error", "Error" };
    }
    
    public PluginResult(final Status status) {
        this(status, PluginResult.StatusMessages[status.ordinal()]);
    }
    
    public PluginResult(final Status status, final float f) {
        this.keepCallback = false;
        this.status = status.ordinal();
        this.messageType = 3;
        this.encodedMessage = new StringBuilder().append(f).toString();
    }
    
    public PluginResult(final Status status, final int i) {
        this.keepCallback = false;
        this.status = status.ordinal();
        this.messageType = 3;
        this.encodedMessage = new StringBuilder().append(i).toString();
    }
    
    public PluginResult(final Status status, final String strMessage) {
        this.keepCallback = false;
        this.status = status.ordinal();
        int messageType;
        if (strMessage == null) {
            messageType = 5;
        }
        else {
            messageType = 1;
        }
        this.messageType = messageType;
        this.strMessage = strMessage;
    }
    
    public PluginResult(final Status status, final JSONArray jsonArray) {
        this.keepCallback = false;
        this.status = status.ordinal();
        this.messageType = 2;
        this.encodedMessage = jsonArray.toString();
    }
    
    public PluginResult(final Status status, final JSONObject jsonObject) {
        this.keepCallback = false;
        this.status = status.ordinal();
        this.messageType = 2;
        this.encodedMessage = jsonObject.toString();
    }
    
    public PluginResult(final Status status, final boolean b) {
        this.keepCallback = false;
        this.status = status.ordinal();
        this.messageType = 4;
        this.encodedMessage = Boolean.toString(b);
    }
    
    public PluginResult(final Status status, final byte[] array) {
        this(status, array, false);
    }
    
    public PluginResult(final Status status, final byte[] array, final boolean b) {
        this.keepCallback = false;
        this.status = status.ordinal();
        int messageType;
        if (b) {
            messageType = 7;
        }
        else {
            messageType = 6;
        }
        this.messageType = messageType;
        this.encodedMessage = Base64.encodeToString(array, 2);
    }
    
    @Deprecated
    public String getJSONString() {
        return "{\"status\":" + this.status + ",\"message\":" + this.getMessage() + ",\"keepCallback\":" + this.keepCallback + "}";
    }
    
    public boolean getKeepCallback() {
        return this.keepCallback;
    }
    
    public String getMessage() {
        if (this.encodedMessage == null) {
            this.encodedMessage = JSONObject.quote(this.strMessage);
        }
        return this.encodedMessage;
    }
    
    public int getMessageType() {
        return this.messageType;
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public String getStrMessage() {
        return this.strMessage;
    }
    
    public void setKeepCallback(final boolean keepCallback) {
        this.keepCallback = keepCallback;
    }
    
    @Deprecated
    public String toCallbackString(final String s) {
        if (this.status == Status.NO_RESULT.ordinal() && this.keepCallback) {
            return null;
        }
        if (this.status == Status.OK.ordinal() || this.status == Status.NO_RESULT.ordinal()) {
            return this.toSuccessCallbackString(s);
        }
        return this.toErrorCallbackString(s);
    }
    
    @Deprecated
    public String toErrorCallbackString(final String str) {
        return "cordova.callbackError('" + str + "', " + this.getJSONString() + ");";
    }
    
    @Deprecated
    public String toSuccessCallbackString(final String str) {
        return "cordova.callbackSuccess('" + str + "'," + this.getJSONString() + ");";
    }
    
    public enum Status
    {
        CLASS_NOT_FOUND_EXCEPTION("CLASS_NOT_FOUND_EXCEPTION", 2), 
        ERROR("ERROR", 9), 
        ILLEGAL_ACCESS_EXCEPTION("ILLEGAL_ACCESS_EXCEPTION", 3), 
        INSTANTIATION_EXCEPTION("INSTANTIATION_EXCEPTION", 4), 
        INVALID_ACTION("INVALID_ACTION", 7), 
        IO_EXCEPTION("IO_EXCEPTION", 6), 
        JSON_EXCEPTION("JSON_EXCEPTION", 8), 
        MALFORMED_URL_EXCEPTION("MALFORMED_URL_EXCEPTION", 5), 
        NO_RESULT("NO_RESULT", 0), 
        OK("OK", 1);
        
        private Status(final String name, final int ordinal) {
        }
    }
}

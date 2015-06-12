// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.globalization;

import org.json.JSONException;
import org.json.JSONObject;

public class GlobalizationError extends Exception
{
    public static final String FORMATTING_ERROR = "FORMATTING_ERROR";
    public static final String PARSING_ERROR = "PARSING_ERROR";
    public static final String PATTERN_ERROR = "PATTERN_ERROR";
    public static final String UNKNOWN_ERROR = "UNKNOWN_ERROR";
    private static final long serialVersionUID = 1L;
    int error;
    
    public GlobalizationError() {
        this.error = 0;
    }
    
    public GlobalizationError(final String s) {
        this.error = 0;
        if (s.equalsIgnoreCase("FORMATTING_ERROR")) {
            this.error = 1;
        }
        else {
            if (s.equalsIgnoreCase("PARSING_ERROR")) {
                this.error = 2;
                return;
            }
            if (s.equalsIgnoreCase("PATTERN_ERROR")) {
                this.error = 3;
            }
        }
    }
    
    public int getErrorCode() {
        return this.error;
    }
    
    public String getErrorString() {
        switch (this.error) {
            default: {
                return "";
            }
            case 0: {
                return "UNKNOWN_ERROR";
            }
            case 1: {
                return "FORMATTING_ERROR";
            }
            case 2: {
                return "PARSING_ERROR";
            }
            case 3: {
                return "PATTERN_ERROR";
            }
        }
    }
    
    public JSONObject toJson() {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("code", this.getErrorCode());
            jsonObject.put("message", (Object)this.getErrorString());
            return jsonObject;
        }
        catch (JSONException ex) {
            return jsonObject;
        }
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.spdy;

public enum ErrorCode
{
    CANCEL("CANCEL", 11, 8, 5, -1), 
    COMPRESSION_ERROR("COMPRESSION_ERROR", 12, 9, -1, -1), 
    FLOW_CONTROL_ERROR("FLOW_CONTROL_ERROR", 7, 3, 7, -1), 
    FRAME_TOO_LARGE("FRAME_TOO_LARGE", 9, 6, 11, -1), 
    INTERNAL_ERROR("INTERNAL_ERROR", 6, 2, 6, 2), 
    INVALID_CREDENTIALS("INVALID_CREDENTIALS", 13, -1, 10, -1), 
    INVALID_STREAM("INVALID_STREAM", 2, 1, 2, -1), 
    NO_ERROR("NO_ERROR", 0, 0, -1, 0), 
    PROTOCOL_ERROR("PROTOCOL_ERROR", 1, 1, 1, 1), 
    REFUSED_STREAM("REFUSED_STREAM", 10, 7, 3, -1), 
    STREAM_ALREADY_CLOSED("STREAM_ALREADY_CLOSED", 5, 1, 9, -1), 
    STREAM_CLOSED("STREAM_CLOSED", 8, 5, -1, -1), 
    STREAM_IN_USE("STREAM_IN_USE", 4, 1, 8, -1), 
    UNSUPPORTED_VERSION("UNSUPPORTED_VERSION", 3, 1, 4, -1);
    
    public final int httpCode;
    public final int spdyGoAwayCode;
    public final int spdyRstCode;
    
    private ErrorCode(final String name, final int ordinal, final int httpCode, final int spdyRstCode, final int spdyGoAwayCode) {
        this.httpCode = httpCode;
        this.spdyRstCode = spdyRstCode;
        this.spdyGoAwayCode = spdyGoAwayCode;
    }
    
    public static ErrorCode fromHttp2(final int n) {
        for (final ErrorCode errorCode : values()) {
            if (errorCode.httpCode == n) {
                return errorCode;
            }
        }
        return null;
    }
    
    public static ErrorCode fromSpdy3Rst(final int n) {
        for (final ErrorCode errorCode : values()) {
            if (errorCode.spdyRstCode == n) {
                return errorCode;
            }
        }
        return null;
    }
    
    public static ErrorCode fromSpdyGoAway(final int n) {
        for (final ErrorCode errorCode : values()) {
            if (errorCode.spdyGoAwayCode == n) {
                return errorCode;
            }
        }
        return null;
    }
}

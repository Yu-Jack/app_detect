// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

public enum WebRequest$WebRequestStatus
{
    INVALID_CLIENT_PROTOCOL("INVALID_CLIENT_PROTOCOL", 3), 
    MALFORMED_URL("MALFORMED_URL", 2), 
    NETWORK_FAILURE("NETWORK_FAILURE", 0), 
    NETWORK_TIMEOUT("NETWORK_TIMEOUT", 1), 
    UNSUPPORTED_ENCODING("UNSUPPORTED_ENCODING", 4);
    
    private WebRequest$WebRequestStatus(final String name, final int ordinal) {
    }
}

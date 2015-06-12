// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.common;

import com.google.android.gms.internal.gw;
import android.app.PendingIntent;

public final class a
{
    public static final a a;
    private final PendingIntent b;
    private final int c;
    
    static {
        a = new a(0, null);
    }
    
    public a(final int c, final PendingIntent b) {
        this.c = c;
        this.b = b;
    }
    
    private String a() {
        switch (this.c) {
            default: {
                return "unknown status code " + this.c;
            }
            case 0: {
                return "SUCCESS";
            }
            case 1: {
                return "SERVICE_MISSING";
            }
            case 2: {
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            }
            case 3: {
                return "SERVICE_DISABLED";
            }
            case 4: {
                return "SIGN_IN_REQUIRED";
            }
            case 5: {
                return "INVALID_ACCOUNT";
            }
            case 6: {
                return "RESOLUTION_REQUIRED";
            }
            case 7: {
                return "NETWORK_ERROR";
            }
            case 8: {
                return "INTERNAL_ERROR";
            }
            case 9: {
                return "SERVICE_INVALID";
            }
            case 10: {
                return "DEVELOPER_ERROR";
            }
            case 11: {
                return "LICENSE_CHECK_FAILED";
            }
            case 13: {
                return "CANCELED";
            }
            case 14: {
                return "TIMEOUT";
            }
            case 15: {
                return "INTERRUPTED";
            }
        }
    }
    
    @Override
    public String toString() {
        return gw.a(this).a("statusCode", this.a()).a("resolution", this.b).toString();
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import com.facebook.bq;
import java.util.Collection;

public final class ad
{
    public static final Collection a;
    public static final Collection b;
    
    static {
        a = aj.a((Object[])new String[] { "service_disabled", "AndroidAuthKillSwitchException" });
        b = aj.a((Object[])new String[] { "access_denied", "OAuthAccessDeniedException" });
    }
    
    public static final String a() {
        return String.format("m.%s", bq.c());
    }
    
    public static final String b() {
        return String.format("https://graph.%s", bq.c());
    }
    
    public static final String c() {
        return String.format("https://graph-video.%s", bq.c());
    }
    
    public static final String d() {
        if (bq.g()) {
            return "v1.0";
        }
        return "v2.1";
    }
}

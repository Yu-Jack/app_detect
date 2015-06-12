// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

public enum b
{
    a("kUnknown", 0, -1), 
    b("kSuccess", 1, 0), 
    c("kNoNetworkConnectivity", 2, 1), 
    d("kMissingAdUnit", 3, 2), 
    e("kNoContext", 4, 3), 
    f("kInvalidAdUnit", 5, 4), 
    g("kInvalidVASTAd", 6, 5), 
    h("kPrecachingDownloadFailed", 7, 6), 
    i("kPrecachingCopyFailed", 8, 7), 
    j("kPrecachingMissingAssets", 9, 8), 
    k("kPrerenderDownloadFailed", 10, 9), 
    l("kAdRequestTimeout", 11, 10), 
    m("kVASTResolveTimeout", 12, 11), 
    n("kCSRTBAuctionTimeout", 13, 12), 
    o("kPrerenderDownloadTimeout", 14, 13), 
    p("kPrepareFailed", 15, 14), 
    q("kAdDisplayError", 16, 15), 
    r("kVideoPlaybackError", 17, 16);
    
    private int s;
    
    private b(final String name, final int ordinal, final int s) {
        this.s = s;
    }
    
    public final int a() {
        return this.s;
    }
}

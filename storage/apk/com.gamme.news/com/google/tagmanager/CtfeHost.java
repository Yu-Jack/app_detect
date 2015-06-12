// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;

class CtfeHost
{
    private static final String CTFE_SERVER_ADDRESS = "https://www.googletagmanager.com";
    @VisibleForTesting
    static final String CTFE_URL_PATH_PREFIX = "/d?";
    static final String DEBUG_EVENT_NUMBER_QUERY = "&event_number=";
    private String mCtfeServerAddress;
    
    public CtfeHost() {
        this.mCtfeServerAddress = "https://www.googletagmanager.com";
    }
    
    String constructCtfeDebugUrl(final int i) {
        return this.mCtfeServerAddress + "/d?" + PreviewManager.getInstance().getCTFEUrlDebugQuery() + "&event_number=" + i;
    }
    
    public String getCtfeServerAddress() {
        return this.mCtfeServerAddress;
    }
    
    public void setCtfeServerAddress(final String s) {
        this.mCtfeServerAddress = s;
        Log.i("The Ctfe server endpoint was changed to: " + s);
    }
}

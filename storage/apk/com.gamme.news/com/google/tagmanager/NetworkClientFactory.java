// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import android.os.Build$VERSION;

class NetworkClientFactory
{
    public NetworkClient createNetworkClient() {
        if (this.getSdkVersion() < 8) {
            return new HttpNetworkClient();
        }
        return new HttpUrlConnectionNetworkClient();
    }
    
    @VisibleForTesting
    int getSdkVersion() {
        return Build$VERSION.SDK_INT;
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.os.Build$VERSION;

class WebRequest$WebRequestFactory
{
    public WebRequest createWebRequest() {
        if (Build$VERSION.SDK_INT < 8) {
            return new HttpClientWebRequest();
        }
        return new HttpURLConnectionWebRequest();
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import android.net.Uri;
import java.util.Map;
import android.content.Context;

class AdwordsClickReferrerListener implements Listener
{
    private final Context context;
    
    public AdwordsClickReferrerListener(final Context context) {
        this.context = context;
    }
    
    @Override
    public void changed(final Map<Object, Object> map) {
        Object o = map.get("gtm.url");
        if (o == null) {
            final Map<Object, Object> value = map.get("gtm");
            if (value != null && value instanceof Map) {
                o = value.get("url");
            }
        }
        if (o != null && o instanceof String) {
            final String queryParameter = Uri.parse((String)o).getQueryParameter("referrer");
            if (queryParameter != null) {
                InstallReferrerUtil.addClickReferrer(this.context, queryParameter);
            }
        }
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.content.Intent;
import android.content.Context;

class MraidBrowser$MraidBrowserBuilder
{
    private static final String LOGTAG;
    private Context context;
    private boolean showOpenExternalBrowserButton;
    private String url;
    
    static {
        LOGTAG = MraidBrowser$MraidBrowserBuilder.class.getSimpleName();
    }
    
    void show() {
        if (this.context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        if (Utils.isNullOrWhiteSpace(this.url)) {
            throw new IllegalArgumentException("Url must not be null or white space");
        }
        if (!Assets.getInstance().ensureAssetsCreated()) {
            Log.e(MraidBrowser$MraidBrowserBuilder.LOGTAG, "Could not load application assets, failed to open URI: %s", this.url);
            return;
        }
        final Intent intent = new Intent(this.context, (Class)AdActivity.class);
        intent.putExtra("adapter", MraidBrowser.class.getName());
        intent.putExtra("extra_url", this.url);
        intent.putExtra("extra_open_btn", this.showOpenExternalBrowserButton);
        intent.addFlags(268435456);
        this.context.startActivity(intent);
    }
    
    MraidBrowser$MraidBrowserBuilder withContext(final Context context) {
        this.context = context;
        return this;
    }
    
    MraidBrowser$MraidBrowserBuilder withExternalBrowserButton() {
        this.showOpenExternalBrowserButton = true;
        return this;
    }
    
    MraidBrowser$MraidBrowserBuilder withUrl(final String url) {
        this.url = url;
        return this;
    }
}

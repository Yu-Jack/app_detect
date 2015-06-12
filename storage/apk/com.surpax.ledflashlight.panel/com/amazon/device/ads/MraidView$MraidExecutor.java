// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;
import java.util.HashMap;
import org.apache.http.client.utils.URLEncodedUtils;
import java.net.URI;

class MraidView$MraidExecutor implements AdWebViewClient$UrlExecutor
{
    final /* synthetic */ MraidView this$0;
    
    MraidView$MraidExecutor(final MraidView this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public boolean execute(final String str) {
        final URI create = URI.create(str);
        final String host = create.getHost();
        final List parse = URLEncodedUtils.parse(create, "UTF-8");
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        for (final NameValuePair nameValuePair : parse) {
            hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
        }
        final MraidCommand command = MraidCommandRegistry.createCommand(host, hashMap, this.this$0);
        if (command == null) {
            this.this$0.fireNativeCommandCompleteEvent(host);
            return false;
        }
        command.execute();
        this.this$0.fireNativeCommandCompleteEvent(host);
        return true;
    }
}

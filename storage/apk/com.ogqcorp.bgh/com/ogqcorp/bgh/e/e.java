// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.e;

import com.ogqcorp.bgh.receiver.NotificationReceiver;
import com.ogqcorp.bgh.system.v;
import java.util.HashMap;
import android.content.Context;

public final class e implements f
{
    @Override
    public CharSequence a(final Context context) {
        return context.getText(2131427448);
    }
    
    @Override
    public void a(final Context context, final a a, final HashMap<String, Object> hashMap) {
        if (v.a().g(context)) {
            NotificationReceiver.a(context);
            return;
        }
        NotificationReceiver.b(context);
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.e;

import android.content.Intent;
import com.ogqcorp.bgh.receiver.AutoResizerReceiver;
import java.util.HashMap;
import android.content.Context;

public final class b implements f
{
    @Override
    public CharSequence a(final Context context) {
        return context.getText(2131427444);
    }
    
    @Override
    public void a(final Context context, final a a, final HashMap<String, Object> hashMap) {
        com.ogqcorp.bgh.system.f.a().a(context);
        new AutoResizerReceiver().onReceive(context, null);
    }
}

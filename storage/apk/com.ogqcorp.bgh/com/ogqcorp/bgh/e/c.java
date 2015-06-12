// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.e;

import java.io.File;
import com.ogqcorp.bgh.system.v;
import com.ogqcorp.bgh.system.o;
import java.util.HashMap;
import android.content.Context;

public final class c implements f
{
    @Override
    public CharSequence a(final Context context) {
        return context.getText(2131427445);
    }
    
    @Override
    public void a(final Context context, final a a, final HashMap<String, Object> hashMap) {
        o.b().m();
        new File(v.a().e(context)).mkdirs();
    }
}

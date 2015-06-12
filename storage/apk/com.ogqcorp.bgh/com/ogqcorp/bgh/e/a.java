// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.e;

import com.ogqcorp.bgh.system.ac;
import java.util.HashMap;
import android.content.Context;
import java.lang.ref.WeakReference;
import android.os.AsyncTask;

public abstract class a extends AsyncTask<f, CharSequence, Object>
{
    private final WeakReference<Context> a;
    
    public a(final Context referent) {
        this.a = new WeakReference<Context>(referent);
    }
    
    protected Object a(final f... array) {
        final long currentTimeMillis = System.currentTimeMillis();
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        final Context context = this.a.get();
        if (context != null) {
            for (final f f : array) {
                this.a(f.a(context));
                f.a(context, this, hashMap);
            }
        }
        final long max = Math.max(0L, currentTimeMillis + (2000L - System.currentTimeMillis()));
        if (max != 0L) {
            ac.a(max);
        }
        return null;
    }
    
    public void a(final CharSequence charSequence) {
        super.publishProgress((Object[])new CharSequence[] { charSequence });
    }
}

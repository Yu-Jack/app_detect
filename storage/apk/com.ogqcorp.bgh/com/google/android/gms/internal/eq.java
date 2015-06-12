// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.Intent;
import android.content.Context;
import android.app.Activity;
import android.content.MutableContextWrapper;

class eq extends MutableContextWrapper
{
    private Activity a;
    private Context b;
    
    public eq(final Context baseContext) {
        super(baseContext);
        this.setBaseContext(baseContext);
    }
    
    public void setBaseContext(final Context context) {
        this.b = context.getApplicationContext();
        Activity a;
        if (context instanceof Activity) {
            a = (Activity)context;
        }
        else {
            a = null;
        }
        this.a = a;
        super.setBaseContext(this.b);
    }
    
    public void startActivity(final Intent intent) {
        if (this.a != null) {
            this.a.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.b.startActivity(intent);
    }
}

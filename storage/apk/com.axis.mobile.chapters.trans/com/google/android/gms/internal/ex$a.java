// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import android.content.Intent;
import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;

class ex$a extends MutableContextWrapper
{
    private Context lz;
    private Activity sG;
    
    public ex$a(final Context baseContext) {
        super(baseContext);
        this.setBaseContext(baseContext);
    }
    
    public Context cf() {
        return (Context)this.sG;
    }
    
    public void setBaseContext(final Context context) {
        this.lz = context.getApplicationContext();
        Activity sg;
        if (context instanceof Activity) {
            sg = (Activity)context;
        }
        else {
            sg = null;
        }
        this.sG = sg;
        super.setBaseContext(this.lz);
    }
    
    public void startActivity(final Intent intent) {
        if (this.sG != null) {
            this.sG.startActivity(intent);
            return;
        }
        intent.setFlags(268435456);
        this.lz.startActivity(intent);
    }
}

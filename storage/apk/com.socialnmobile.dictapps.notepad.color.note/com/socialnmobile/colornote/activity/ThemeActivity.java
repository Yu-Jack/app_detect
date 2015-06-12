// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;

public class ThemeActivity extends Activity
{
    yd c;
    
    public final void a() {
        this.c.a(2);
        this.c.d = null;
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.c = new yd(this);
    }
    
    protected void onResume() {
        super.onResume();
        this.c.a();
    }
    
    protected void onStart() {
        super.onStart();
        eg.a((Context)this, "7WTGHNWSX5PSDGSHN65D");
    }
    
    protected void onStop() {
        super.onStop();
        eg.a((Context)this);
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

public class SendAsAttachment extends Activity
{
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final Intent intent = this.getIntent();
        gw.b(this, intent.getStringExtra("android.intent.extra.SUBJECT"), intent.getStringExtra("android.intent.extra.TEXT"));
        this.finish();
    }
}

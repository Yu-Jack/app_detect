// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.content.Intent;
import android.content.Context;
import android.widget.Toast;
import android.text.ClipboardManager;
import android.os.Bundle;
import android.app.Activity;

public class SendToClipboard extends Activity
{
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final Intent intent = this.getIntent();
        intent.getStringExtra("android.intent.extra.SUBJECT");
        ((ClipboardManager)this.getSystemService("clipboard")).setText((CharSequence)intent.getStringExtra("android.intent.extra.TEXT"));
        Toast.makeText((Context)this, 2131230849, 1).show();
        this.finish();
    }
}

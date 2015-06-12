// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

public class Search extends Activity
{
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final String action = this.getIntent().getAction();
        if ("android.intent.action.VIEW".equals(action)) {
            final Intent intent = new Intent("android.intent.action.VIEW", this.getIntent().getData());
            intent.putExtra("EXTRA_VIEW_FROM", "SEARCH");
            this.startActivity(intent);
        }
        else if ("android.intent.action.SEARCH".equals(action)) {
            final Intent intent2 = new Intent((Context)this, (Class)Main.class);
            intent2.setAction("android.intent.action.SEARCH");
            intent2.setFlags(603979776);
            intent2.putExtra("query", this.getIntent().getStringExtra("query"));
            this.startActivity(intent2);
        }
        this.finish();
    }
}

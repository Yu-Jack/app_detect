// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.androidlabs.base;

import android.content.Intent;
import android.content.Context;
import android.widget.Toast;
import android.os.Bundle;
import android.webkit.WebView;

public class ViewStatementActivity extends BankingActivity
{
    WebView mStatementDisplay;
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903048);
        this.setAppropriateVisibility();
        this.mStatementDisplay = (WebView)this.findViewById(2131165201);
        final Intent intent = this.getIntent();
        if (intent.hasExtra("statement_filename")) {
            this.mStatementDisplay.loadUrl("file://" + intent.getStringExtra("statement_filename"));
            return;
        }
        Toast.makeText((Context)this, 2131034146, 0).show();
    }
}

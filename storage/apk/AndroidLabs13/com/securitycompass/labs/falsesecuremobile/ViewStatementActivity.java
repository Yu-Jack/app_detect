// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.labs.falsesecuremobile;

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
        if (intent.hasExtra("statement_html")) {
            this.mStatementDisplay.loadData(intent.getStringExtra("statement_html"), "text/html", "utf-8");
            return;
        }
        Toast.makeText((Context)this, 2131034147, 0).show();
    }
}

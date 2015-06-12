// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import com.actionbarsherlock.view.MenuItem;
import android.os.Bundle;
import org.a.a.a.d;
import android.widget.TextView;
import android.content.Intent;
import android.content.Context;
import com.ogqcorp.bgh.activity.a.a;

public final class TextActivity extends a
{
    public static Intent a(final Context context, final String s) {
        final Intent intent = new Intent(context.getApplicationContext(), (Class)TextActivity.class);
        intent.putExtra("KEY_TEXT_PATH", s);
        return intent;
    }
    
    private void a() {
        final String b = this.b();
        final TextView textView = (TextView)this.findViewById(2131099765);
        textView.post((Runnable)new Runnable() {
            @Override
            public void run() {
                textView.setText((CharSequence)b);
            }
        });
    }
    
    private String b() {
        final String stringExtra = this.getIntent().getStringExtra("KEY_TEXT_PATH");
        try {
            return d.b(this.getAssets().open(stringExtra));
        }
        catch (Exception ex) {
            return "";
        }
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903069);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.a();
    }
    
    @Override
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
}

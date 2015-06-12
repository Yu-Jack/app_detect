// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import com.ogqcorp.bgh.system.c;
import android.support.v4.app.Fragment;
import com.ogqcorp.bgh.b.o;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;

public final class TagActivity extends b
{
    public static Intent a(final Context context, final String s) {
        final Intent intent = new Intent(context.getApplicationContext(), (Class)TagActivity.class);
        intent.putExtra("KEY_TAG", s);
        return intent;
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final String stringExtra = this.getIntent().getStringExtra("KEY_TAG");
        if (this.a() == null) {
            this.a(o.a(stringExtra));
        }
        this.getSupportActionBar().setLogo(2130837730);
        this.getSupportActionBar().setTitle(stringExtra);
        c.a().b((Context)this, stringExtra);
    }
}

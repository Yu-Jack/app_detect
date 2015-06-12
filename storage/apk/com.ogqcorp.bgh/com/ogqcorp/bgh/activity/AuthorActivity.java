// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import com.ogqcorp.bgh.system.c;
import android.support.v4.app.Fragment;
import com.ogqcorp.bgh.b.a;
import android.os.Bundle;
import android.os.Parcelable;
import android.content.Intent;
import com.ogqcorp.bgh.item.Author;
import android.content.Context;

public final class AuthorActivity extends b
{
    public static Intent a(final Context context, final Author author) {
        final Intent intent = new Intent(context.getApplicationContext(), (Class)AuthorActivity.class);
        intent.putExtra("KEY_AUTHOR", (Parcelable)author);
        return intent;
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final Author author = (Author)this.getIntent().getParcelableExtra("KEY_AUTHOR");
        if (this.a() == null) {
            this.a(a.a(author));
        }
        this.getSupportActionBar().setLogo(2130837728);
        this.getSupportActionBar().setTitle(author.getName());
        c.a().b((Context)this, author);
    }
}

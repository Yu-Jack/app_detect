// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import com.ogqcorp.bgh.system.c;
import android.support.v4.app.Fragment;
import com.ogqcorp.bgh.b.h;
import android.os.Bundle;
import android.os.Parcelable;
import android.content.Intent;
import com.ogqcorp.bgh.item.Category;
import android.content.Context;

public final class CategoryActivity extends b
{
    public static Intent a(final Context context, final Category category) {
        final Intent intent = new Intent(context.getApplicationContext(), (Class)CategoryActivity.class);
        intent.putExtra("KEY_CATEGORY", (Parcelable)category);
        return intent;
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        final Category category = (Category)this.getIntent().getParcelableExtra("KEY_CATEGORY");
        if (this.a() == null) {
            this.a(h.a(category));
        }
        this.getSupportActionBar().setLogo(2130837729);
        this.getSupportActionBar().setTitle(category.getName());
        c.a().a((Context)this, category);
    }
}

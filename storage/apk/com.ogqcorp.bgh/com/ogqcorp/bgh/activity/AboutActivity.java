// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import com.actionbarsherlock.view.MenuItem;
import android.os.Bundle;
import java.util.Locale;
import android.app.Activity;
import com.ogqcorp.commons.x;
import android.text.format.DateFormat;
import com.ogqcorp.bgh.system.v;
import android.view.View$OnClickListener;
import com.ogqcorp.bgh.system.u;
import com.ogqcorp.bgh.system.h;
import android.view.View;
import android.view.View$OnLongClickListener;
import android.content.Intent;
import android.content.Context;
import com.ogqcorp.bgh.activity.a.a;

public final class AboutActivity extends a
{
    public static Intent a(final Context context) {
        return new Intent(context.getApplicationContext(), (Class)AboutActivity.class);
    }
    
    private void a() {
        int i = 0;
        this.findViewById(2131099739).setOnLongClickListener((View$OnLongClickListener)new View$OnLongClickListener() {
            public boolean onLongClick(final View view) {
                if (h.a().b() <= 0) {
                    AboutActivity.this.findViewById(2131099812).setVisibility(0);
                    AboutActivity.this.d();
                }
                return false;
            }
        });
        final int[] array = { 2131099801, 2131099802, 2131099803, 2131099804, 2131099805, 2131099806, 2131099807, 2131099808, 2131099809, 2131099810, 2131099811 };
        final String[] array2 = { "ko", "fk", "nl", "us", "use", "jp", "aws", u.a, "summer", "autumn", "winter" };
        while (i < array.length) {
            this.findViewById(array[i]).setOnClickListener((View$OnClickListener)new View$OnClickListener() {
                public void onClick(final View view) {
                    v.a().b((Context)AboutActivity.this, array2[i]);
                    AboutActivity.this.c();
                }
            });
            ++i;
        }
        this.b();
        this.c();
    }
    
    private void b() {
        x.a(this, 2131099799, "NOTIFICATION_TIME: " + (String)DateFormat.format((CharSequence)"yyyy-MM-dd kk:mm:ss", v.a().b((Context)this)));
    }
    
    private void c() {
        String f = v.a().f((Context)this);
        if (f == null) {
            f = "@NULL";
        }
        x.a(this, 2131099800, "SERVER: " + f.toUpperCase(Locale.US));
    }
    
    private void d() {
        x.a(this, 2131099813, h.a().i());
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903061);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.a();
    }
    
    public void onIgnoreScrollableWallpaperIssues(final View view) {
        h.a().h();
        this.d();
    }
    
    public void onIgnoreWallpaperManagerSelectionPolicy(final View view) {
        h.a().f();
        this.d();
    }
    
    public void onLogo(final View view) {
        if (h.a().b() <= 0) {
            this.findViewById(2131099798).setVisibility(0);
        }
    }
    
    public void onOpenSource(final View view) {
        this.startActivity(TextActivity.a((Context)this, "text/open_source.txt"));
    }
    
    @Override
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
    
    public void onShowAds(final View view) {
        h.a().d();
        this.d();
    }
    
    public void onThanks(final View view) {
        this.startActivity(TextActivity.a((Context)this, "text/thanks.txt"));
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import com.ogqcorp.commons.x;
import java.io.File;
import com.ogqcorp.commons.u;
import android.support.v4.app.FragmentActivity;
import com.actionbarsherlock.view.MenuItem;
import com.ogqcorp.commons.t;
import com.ogqcorp.bgh.system.c;
import com.ogqcorp.bgh.system.ac;
import com.actionbarsherlock.view.Menu;
import android.view.View;
import android.app.Activity;
import android.support.v4.view.bl;
import com.ogqcorp.bgh.system.l;
import android.support.v4.view.af;
import android.os.Bundle;
import java.util.Collection;
import android.content.Intent;
import android.content.Context;
import android.support.v4.view.ViewPager;
import com.ogqcorp.bgh.item.Background;
import java.util.ArrayList;
import com.ogqcorp.bgh.activity.a.b;

public final class BackgroundActivity extends b
{
    private static ArrayList<Background> g;
    private ArrayList<Background> a;
    private int b;
    private int c;
    private int d;
    private ViewPager e;
    private com.ogqcorp.bgh.b.b f;
    
    public BackgroundActivity() {
        this.a = new ArrayList<Background>();
        this.b = 0;
        this.c = -1;
        this.d = 0;
    }
    
    public static Intent a(final Context context, final ArrayList<Background> c, final int n) {
        final Intent intent = new Intent(context.getApplicationContext(), (Class)BackgroundActivity.class);
        if (c != null) {
            if (BackgroundActivity.g == null) {
                BackgroundActivity.g = new ArrayList<Background>();
            }
            BackgroundActivity.g.clear();
            BackgroundActivity.g.addAll(c);
        }
        intent.putExtra("KEY_ITEM_INDEX", n);
        return intent;
    }
    
    private void a(final Bundle bundle) {
        if (BackgroundActivity.g != null) {
            this.a.addAll(BackgroundActivity.g);
            BackgroundActivity.g.clear();
            BackgroundActivity.g = null;
            this.b = this.getIntent().getIntExtra("KEY_ITEM_INDEX", 0);
            return;
        }
        if (bundle != null) {
            this.a = (ArrayList<Background>)bundle.getParcelableArrayList("KEY_BACKGROUNDS_LIST");
            this.b = bundle.getInt("KEY_ITEM_INDEX");
            return;
        }
        this.finish();
    }
    
    private boolean a(final int n) {
        if (n == 16908332) {
            return this.a();
        }
        if (n == 2131099863) {
            return this.b();
        }
        if (n == 2131099864) {
            return this.c();
        }
        return n == 2131099858 && this.d();
    }
    
    private boolean d() {
        this.setResult(2131099858);
        this.finish();
        return true;
    }
    
    private void e() {
        (this.e = (ViewPager)this.findViewById(2131099751)).setAdapter(new a(this, this.getSupportFragmentManager()));
        this.e.setPageMargin(10);
        this.e.setCurrentItem(this.b);
    }
    
    private void f() {
        try {
            if (this.f != null && this.f.isVisible()) {
                this.f.c();
            }
        }
        catch (Exception ex) {
            l.b(ex);
        }
    }
    
    private void g() {
        if (this.e != null) {
            this.e.setAdapter(null);
            this.e.setOnPageChangeListener(null);
            this.e = null;
        }
        if (this.a != null) {
            this.a.clear();
            this.a = null;
        }
        if (BackgroundActivity.g != null) {
            BackgroundActivity.g.clear();
            BackgroundActivity.g = null;
        }
        this.f = null;
    }
    
    protected boolean a() {
        this.finish();
        return true;
    }
    
    protected boolean b() {
        if (this.f != null) {
            final Background b = this.f.b();
            if (b != null) {
                com.ogqcorp.bgh.a.a.d(this, b);
            }
        }
        return true;
    }
    
    protected boolean c() {
        if (this.f != null) {
            final Background b = this.f.b();
            if (b != null) {
                com.ogqcorp.bgh.a.a.b((Activity)this, b);
            }
        }
        return true;
    }
    
    @Override
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n2 == 2131099858) {
            this.setResult(2131099858);
            this.finish();
        }
        else if (this.f != null) {
            final Background b = this.f.b();
            if (b != null) {
                com.ogqcorp.bgh.a.a.a(this, n, n2, intent, b);
            }
        }
    }
    
    public void onAuthorClick(final Background background, final View view) {
        com.ogqcorp.bgh.a.a.a(this, background.getAuthor());
    }
    
    public void onAuthorHomepageClick(final Background background, final View view) {
        com.ogqcorp.bgh.a.a.a((Activity)this, background);
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903063);
        this.a(bundle);
        this.e();
        com.ogqcorp.bgh.system.b.a().a(this, 2131099753);
    }
    
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        if (ac.f((Context)this)) {
            this.getSupportMenuInflater().inflate(2131623936, menu);
        }
        return true;
    }
    
    @Override
    protected void onDestroy() {
        com.ogqcorp.bgh.system.b.a().d(this, 2131099753);
        com.ogqcorp.bgh.system.c.a().a((Context)this, this.d);
        this.g();
        t.a(this);
        System.gc();
        super.onDestroy();
    }
    
    public void onFavoriteClick(final Background background, final View view) {
        com.ogqcorp.bgh.a.a.a(this, background, new Runnable() {
            @Override
            public void run() {
                BackgroundActivity.this.f();
            }
        });
    }
    
    public void onLicenseClick(final Background background, final View view) {
        com.ogqcorp.bgh.a.a.a(this, background.getLicense());
    }
    
    public void onLinkClick(final Background background, final View view) {
        com.ogqcorp.bgh.a.a.c(this, background);
    }
    
    @Override
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        return this.a(menuItem.getItemId());
    }
    
    public void onPause() {
        com.ogqcorp.bgh.system.b.a().c(this, 2131099753);
        super.onPause();
    }
    
    public void onPreviewClick(final Background background, final View view) {
        com.ogqcorp.bgh.a.a.a(this, background);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        com.ogqcorp.bgh.system.b.a().b(this, 2131099753);
    }
    
    public void onSaveClick(final Background background, final View view) {
        com.ogqcorp.bgh.a.a.a(this, background, true, null, null);
    }
    
    @Override
    protected void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelableArrayList("KEY_BACKGROUNDS_LIST", new ArrayList((Collection<? extends E>)this.a));
        bundle.putInt("KEY_ITEM_INDEX", this.b);
    }
    
    public void onScoreClick(final Background background, final View view) {
        com.ogqcorp.bgh.a.a.a(this, background, true, null, null);
    }
    
    public void onTagClick(final Background background, final View view) {
        com.ogqcorp.bgh.a.a.a(this, x.a(view).toString());
    }
    
    public void onWallpaperClick(final Background background, final View view) {
        com.ogqcorp.bgh.a.a.b(this, background);
    }
}

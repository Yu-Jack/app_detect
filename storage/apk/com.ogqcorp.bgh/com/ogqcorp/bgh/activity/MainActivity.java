// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import com.actionbarsherlock.view.MenuItem;
import com.ogqcorp.commons.t;
import com.ogqcorp.bgh.system.ac;
import com.actionbarsherlock.view.Menu;
import com.ogqcorp.bgh.system.o;
import com.ogqcorp.bgh.system.p;
import com.ogqcorp.bgh.system.v;
import android.os.Build$VERSION;
import com.ogqcorp.bgh.system.b;
import android.app.Activity;
import android.os.Bundle;
import com.ogqcorp.bgh.item.Background;
import java.util.ArrayList;
import com.ogqcorp.bgh.item.Category;
import com.ogqcorp.bgh.system.c;
import android.app.AlertDialog$Builder;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import com.ogqcorp.bgh.b.l;
import com.ogqcorp.bgh.b.k;
import com.ogqcorp.bgh.b.f;
import com.ogqcorp.bgh.b.m;
import com.ogqcorp.bgh.b.n;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.content.Context;
import com.ogqcorp.bgh.b.g;
import com.ogqcorp.bgh.b.e;
import com.ogqcorp.bgh.activity.a.d;

public final class MainActivity extends d implements e, g
{
    public static Intent a(final Context context) {
        return new Intent(context.getApplicationContext(), (Class)MainActivity.class);
    }
    
    private Fragment c(final int n) {
        if (n == 2131099757) {
            return new n();
        }
        if (n == 2131099758) {
            return new m();
        }
        if (n == 2131099759) {
            return new f();
        }
        if (n == 2131099760) {
            return new k();
        }
        if (n == 2131099761) {
            return new l();
        }
        return null;
    }
    
    private void d() {
        final int[] array = { 2131099757, 2131099758, 2131099759, 2131099760, 2131099761 };
        for (int length = array.length, i = 0; i < length; ++i) {
            this.b(array[i]);
        }
        this.findViewById(this.c()).performClick();
    }
    
    private boolean e() {
        this.startActivity(SettingsActivity.a((Context)this));
        return true;
    }
    
    private boolean f() {
        this.startActivity(AboutActivity.a((Context)this));
        return true;
    }
    
    private void g() {
        final DialogInterface$OnClickListener dialogInterface$OnClickListener = (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
            public void onClick(final DialogInterface dialogInterface, final int n) {
                MainActivity.this.onBackPressed();
            }
        };
        try {
            final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this);
            alertDialog$Builder.setIcon(17301659).setTitle(2131427464).setMessage(2131427463);
            alertDialog$Builder.setPositiveButton(17039379, (DialogInterface$OnClickListener)dialogInterface$OnClickListener).setNegativeButton(17039369, (DialogInterface$OnClickListener)null);
            alertDialog$Builder.show();
        }
        catch (Exception ex) {
            super.onBackPressed();
        }
    }
    
    @Override
    protected int a() {
        return 2131099757;
    }
    
    @Override
    protected Fragment a(final int n) {
        final Fragment c = this.c(n);
        com.ogqcorp.bgh.system.c.a().a((Context)this, c.getClass());
        return c;
    }
    
    @Override
    public void a(final Category category) {
        this.startActivityForResult(CategoryActivity.a((Context)this, category), 0);
    }
    
    @Override
    public void a(final ArrayList<Background> list, final int index) {
        final String a = PickerActivity.a();
        if ("android.intent.action.PICK".equals(a) || "android.intent.action.GET_CONTENT".equals(a)) {
            PickerActivity.a(list.get(index));
            this.finish();
            return;
        }
        this.startActivity(BackgroundActivity.a((Context)this, list, index));
    }
    
    @Override
    protected int b() {
        return 2131099754;
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (PickerActivity.b() != null) {
            this.finish();
        }
    }
    
    public void onBackPressed() {
        this.g();
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903066);
        this.d();
        SchemeActivity.a(this);
        com.ogqcorp.bgh.system.b.a().a(this, 2131099753);
        if (Build$VERSION.SDK_INT >= 19 && !v.a().e((Context)this).startsWith(p.p().getAbsolutePath())) {
            v.a().a((Context)this, o.b().c().getAbsolutePath());
            new AlertDialog$Builder((Context)this).setMessage(2131427492).setPositiveButton(17039370, (DialogInterface$OnClickListener)null).show();
        }
    }
    
    public boolean onCreateOptionsMenu(final Menu menu) {
        if (ac.f((Context)this)) {
            this.getSupportMenuInflater().inflate(2131623938, menu);
        }
        return true;
    }
    
    protected void onDestroy() {
        com.ogqcorp.bgh.system.b.a().d(this, 2131099753);
        t.a(this);
        System.gc();
        super.onDestroy();
    }
    
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        final int itemId = menuItem.getItemId();
        if (itemId == 2131099859) {
            return this.e();
        }
        return itemId == 2131099860 && this.f();
    }
    
    public void onPause() {
        com.ogqcorp.bgh.system.b.a().c(this, 2131099753);
        super.onPause();
    }
    
    protected void onResume() {
        super.onResume();
        com.ogqcorp.bgh.system.b.a().b(this, 2131099753);
    }
}

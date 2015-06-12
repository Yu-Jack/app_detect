// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import com.actionbarsherlock.view.MenuItem;
import com.ogqcorp.commons.t;
import com.actionbarsherlock.view.Menu;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
import com.ogqcorp.bgh.item.Background;
import java.util.ArrayList;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import com.ogqcorp.bgh.b.e;
import com.ogqcorp.bgh.activity.a.b;

public abstract class b extends com.ogqcorp.bgh.activity.a.b implements e
{
    protected Fragment a() {
        return this.getSupportFragmentManager().findFragmentByTag("TAG_FRAGMENT");
    }
    
    protected void a(final Fragment fragment) {
        final FragmentManager supportFragmentManager = this.getSupportFragmentManager();
        final FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.add(2131099754, fragment, "TAG_FRAGMENT");
        beginTransaction.commit();
        supportFragmentManager.executePendingTransactions();
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
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        if (n2 == 2131099858) {
            this.setResult(2131099858);
            this.finish();
        }
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903064);
        com.ogqcorp.bgh.system.b.a().a(this, 2131099753);
    }
    
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        this.getSupportMenuInflater().inflate(2131623937, menu);
        return true;
    }
    
    @Override
    protected void onDestroy() {
        com.ogqcorp.bgh.system.b.a().d(this, 2131099753);
        t.a(this);
        System.gc();
        super.onDestroy();
    }
    
    @Override
    public boolean onOptionsItemSelected(final MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            this.finish();
            return true;
        }
        if (menuItem.getItemId() == 2131099858) {
            this.setResult(2131099858);
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }
    
    public void onPause() {
        com.ogqcorp.bgh.system.b.a().c(this, 2131099753);
        super.onPause();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        com.ogqcorp.bgh.system.b.a().b(this, 2131099753);
    }
}

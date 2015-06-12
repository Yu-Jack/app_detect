// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.a;

import com.ogqcorp.bgh.cf.c.b.e;
import android.os.Bundle;
import android.widget.Toast;
import android.support.v4.view.af;
import com.ogqcorp.bgh.cf.d;
import java.util.Arrays;
import com.ogqcorp.bgh.cf.d.a;
import android.content.Context;
import com.ogqcorp.bgh.cf.f;
import com.a.a.x;
import java.util.regex.Matcher;
import java.util.Random;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.HashSet;
import android.app.ProgressDialog;
import android.support.v4.view.ViewPager;
import java.util.ArrayList;
import com.a.a.r;
import com.a.a.s;
import com.ogqcorp.bgh.cf.b.b;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class a extends SherlockFragmentActivity implements b
{
    private s<String> a;
    private r b;
    private ArrayList<String> c;
    private ViewPager d;
    private ProgressDialog e;
    private HashSet<String> f;
    private String g;
    private int h;
    
    public a() {
        this.a = new s<String>() {
            @Override
            public void a(final String input) {
                if (com.ogqcorp.bgh.cf.a.a.this.isFinishing()) {
                    return;
                }
                final Matcher matcher = Pattern.compile("\"([0-9]+)\"", 40).matcher(input);
                final int size = com.ogqcorp.bgh.cf.a.a.this.c.size();
                final HashSet<String> set = new HashSet<String>(com.ogqcorp.bgh.cf.a.a.this.c);
                while (matcher.find()) {
                    final String group = matcher.group(1);
                    if (group != null && Long.parseLong(group) > 100000L && !set.contains(group)) {
                        set.add(group);
                        com.ogqcorp.bgh.cf.a.a.this.c.add(group);
                    }
                }
                final Random random = new Random();
                for (int i = -1 + com.ogqcorp.bgh.cf.a.a.this.c.size(); i > size; --i) {
                    final int n = size + random.nextInt(com.ogqcorp.bgh.cf.a.a.this.c.size() - size);
                    com.ogqcorp.bgh.cf.a.a.this.c.set(n, com.ogqcorp.bgh.cf.a.a.this.c.set(i, com.ogqcorp.bgh.cf.a.a.this.c.get(n)));
                }
                com.ogqcorp.bgh.cf.a.a.this.h = com.ogqcorp.bgh.cf.a.a.this.c.indexOf(com.ogqcorp.bgh.cf.a.a.this.g);
                com.ogqcorp.bgh.cf.a.a.this.b();
                com.ogqcorp.bgh.cf.a.a.this.e.dismiss();
            }
        };
        this.b = new r() {
            @Override
            public void a(final x x) {
            }
        };
        this.c = new ArrayList<String>();
        this.f = new HashSet<String>();
    }
    
    private void a() {
        final String string = this.getString(com.ogqcorp.bgh.cf.f.bcf_loading);
        (this.e = new ProgressDialog((Context)this)).setCancelable(false);
        this.e.setMessage((CharSequence)string);
        this.e.show();
        this.f.clear();
        final String[] b = com.ogqcorp.bgh.cf.d.a.a().b((Context)this);
        if (b != null) {
            this.f.addAll((Collection<?>)Arrays.asList(b));
        }
        this.c.clear();
        final String[] a = com.ogqcorp.bgh.cf.d.a.a().a((Context)this);
        if (a != null) {
            this.c.addAll(Arrays.asList(a));
        }
        this.g = com.ogqcorp.bgh.cf.d.a.a().c((Context)this);
        com.ogqcorp.bgh.cf.c.a.a(this.a, this.b);
    }
    
    private void b() {
        (this.d = (ViewPager)this.findViewById(com.ogqcorp.bgh.cf.d.view_pager)).setAdapter(new com.ogqcorp.bgh.cf.a.b(this, this.getSupportFragmentManager()));
        this.d.setPageMargin(10);
        this.d.setCurrentItem(this.h);
    }
    
    @Override
    public void a(final String str, final String str2, final String str3) {
        Toast.makeText((Context)this, (CharSequence)(str + ", " + str2 + ", " + str3), 0).show();
    }
    
    @Override
    public void a(final String s, final boolean b) {
        if (b) {
            this.f.add(s);
            return;
        }
        this.f.remove(s);
    }
    
    @Override
    public void b(final String str, final String str2, final String str3) {
        Toast.makeText((Context)this, (CharSequence)(str + ", " + str2 + ", " + str3), 0).show();
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        com.ogqcorp.bgh.cf.c.b.e.a().a((Context)this);
        this.setContentView(com.ogqcorp.bgh.cf.e.bcf_activity_curating_flickr);
        this.a();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        com.ogqcorp.bgh.cf.d.a.a().a((Context)this, this.c.toArray(new String[0]));
        com.ogqcorp.bgh.cf.d.a.a().b((Context)this, this.f.toArray(new String[0]));
        com.ogqcorp.bgh.cf.d.a.a().a((Context)this, this.g);
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import android.app.Activity;
import com.ogqcorp.commons.t;
import android.os.Bundle;
import com.ogqcorp.bgh.e.d;
import com.ogqcorp.bgh.e.e;
import com.ogqcorp.bgh.e.c;
import com.ogqcorp.bgh.e.b;
import com.ogqcorp.bgh.e.f;
import android.os.Environment;
import com.ogqcorp.bgh.system.l;
import android.content.DialogInterface$OnCancelListener;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.content.Intent;
import android.content.Context;
import android.widget.TextView;
import com.ogqcorp.bgh.activity.a.a;

public final class SplashActivity extends a
{
    private TextView a;
    
    public static Intent a(final Context context) {
        return new Intent(context.getApplicationContext(), (Class)SplashActivity.class);
    }
    
    private void a() {
        this.a = (TextView)this.findViewById(2131099764);
    }
    
    private void a(final boolean b) {
        final View viewById = this.findViewById(2131099763);
        if (viewById != null) {
            if (b) {
                viewById.startAnimation(AnimationUtils.loadAnimation((Context)this, 2130968576));
                viewById.setVisibility(0);
            }
            else {
                viewById.setAnimation((Animation)null);
                viewById.setVisibility(8);
            }
        }
        if (b && this.a != null) {
            this.a.startAnimation(AnimationUtils.loadAnimation((Context)this, 2130968577));
        }
    }
    
    private void b() {
        try {
            final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this);
            alertDialog$Builder.setIcon(17301543).setTitle(17039380).setMessage(2131427460);
            alertDialog$Builder.setPositiveButton(17039370, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                public void onClick(final DialogInterface dialogInterface, final int n) {
                    SplashActivity.this.finish();
                }
            });
            alertDialog$Builder.setOnCancelListener((DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener() {
                public void onCancel(final DialogInterface dialogInterface) {
                    SplashActivity.this.finish();
                }
            });
            alertDialog$Builder.show();
        }
        catch (Exception ex) {
            l.c(ex);
        }
    }
    
    private void c() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            this.b();
            return;
        }
        new com.ogqcorp.bgh.e.a(this) {
            protected void a(final CharSequence... array) {
                if (SplashActivity.this.a != null) {
                    SplashActivity.this.a.setText(array[0]);
                }
            }
            
            protected void onPostExecute(final Object o) {
                SplashActivity.this.a(false);
                SplashActivity.this.d();
                SplashActivity.this.finish();
            }
            
            protected void onPreExecute() {
                SplashActivity.this.a(true);
            }
        }.execute((Object[])new f[] { new b(), new c(), new e(), new d() });
    }
    
    private void d() {
        if (this.isFinishing()) {
            return;
        }
        this.startActivity(MainActivity.a((Context)this));
        com.ogqcorp.bgh.system.c.a().a((Context)this);
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903068);
        this.a();
        this.c();
    }
    
    @Override
    protected void onDestroy() {
        this.a = null;
        t.a(this);
        System.gc();
        super.onDestroy();
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.util.Log;
import com.facebook.a.e;
import com.facebook.a.f;
import android.content.Intent;
import java.io.Serializable;
import android.os.Bundle;
import android.app.Activity;

public class LoginActivity extends Activity
{
    private static final String a;
    private String b;
    private m c;
    private p d;
    
    static {
        a = LoginActivity.class.getName();
    }
    
    static Bundle a(final p p) {
        final Bundle bundle = new Bundle();
        bundle.putSerializable("request", (Serializable)p);
        return bundle;
    }
    
    static /* synthetic */ void a(final LoginActivity loginActivity, final v v) {
        loginActivity.d = null;
        int n;
        if (v.a == w.b) {
            n = 0;
        }
        else {
            n = -1;
        }
        final Bundle bundle = new Bundle();
        bundle.putSerializable("com.facebook.LoginActivity:Result", (Serializable)v);
        final Intent intent = new Intent();
        intent.putExtras(bundle);
        loginActivity.setResult(n, intent);
        loginActivity.finish();
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        this.c.a(n, n2, intent);
    }
    
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(f.a);
        if (bundle != null) {
            this.b = bundle.getString("callingPackage");
            this.c = (m)bundle.getSerializable("authorizationClient");
        }
        else {
            this.b = this.getCallingPackage();
            this.c = new m();
            this.d = (p)this.getIntent().getSerializableExtra("request");
        }
        this.c.a(this);
        this.c.a(new u() {
            @Override
            public final void a(final v v) {
                LoginActivity.a(LoginActivity.this, v);
            }
        });
        this.c.a(new q() {
            @Override
            public final void a() {
                LoginActivity.this.findViewById(e.c).setVisibility(0);
            }
            
            @Override
            public final void b() {
                LoginActivity.this.findViewById(e.c).setVisibility(8);
            }
        });
    }
    
    public void onPause() {
        super.onPause();
        this.c.a();
        this.findViewById(e.c).setVisibility(8);
    }
    
    public void onResume() {
        super.onResume();
        if (this.b == null) {
            Log.e(LoginActivity.a, "Cannot call LoginActivity with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            this.finish();
            return;
        }
        this.c.a(this.d);
    }
    
    public void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("callingPackage", this.b);
        bundle.putSerializable("authorizationClient", (Serializable)this.c);
    }
}

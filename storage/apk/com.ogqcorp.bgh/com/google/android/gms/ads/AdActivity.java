// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.ads;

import android.view.ViewGroup$LayoutParams;
import android.view.View;
import com.google.android.gms.internal.cd;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.en;
import com.google.android.gms.internal.cg;
import android.app.Activity;

public final class AdActivity extends Activity
{
    private cg a;
    
    private void a() {
        if (this.a == null) {
            return;
        }
        try {
            this.a.j();
        }
        catch (RemoteException ex) {
            en.c("Could not forward setContentViewSet to ad overlay:", (Throwable)ex);
        }
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.a = cd.a(this);
        if (this.a == null) {
            en.e("Could not create ad overlay.");
            this.finish();
            return;
        }
        try {
            this.a.a(bundle);
        }
        catch (RemoteException ex) {
            en.c("Could not forward onCreate to ad overlay:", (Throwable)ex);
            this.finish();
        }
    }
    
    protected void onDestroy() {
        while (true) {
            try {
                if (this.a != null) {
                    this.a.i();
                }
                super.onDestroy();
            }
            catch (RemoteException ex) {
                en.c("Could not forward onDestroy to ad overlay:", (Throwable)ex);
                continue;
            }
            break;
        }
    }
    
    protected void onPause() {
        while (true) {
            try {
                if (this.a != null) {
                    this.a.g();
                }
                super.onPause();
            }
            catch (RemoteException ex) {
                en.c("Could not forward onPause to ad overlay:", (Throwable)ex);
                this.finish();
                continue;
            }
            break;
        }
    }
    
    protected void onRestart() {
        super.onRestart();
        try {
            if (this.a != null) {
                this.a.d();
            }
        }
        catch (RemoteException ex) {
            en.c("Could not forward onRestart to ad overlay:", (Throwable)ex);
            this.finish();
        }
    }
    
    protected void onResume() {
        super.onResume();
        try {
            if (this.a != null) {
                this.a.f();
            }
        }
        catch (RemoteException ex) {
            en.c("Could not forward onResume to ad overlay:", (Throwable)ex);
            this.finish();
        }
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        while (true) {
            try {
                if (this.a != null) {
                    this.a.b(bundle);
                }
                super.onSaveInstanceState(bundle);
            }
            catch (RemoteException ex) {
                en.c("Could not forward onSaveInstanceState to ad overlay:", (Throwable)ex);
                this.finish();
                continue;
            }
            break;
        }
    }
    
    protected void onStart() {
        super.onStart();
        try {
            if (this.a != null) {
                this.a.e();
            }
        }
        catch (RemoteException ex) {
            en.c("Could not forward onStart to ad overlay:", (Throwable)ex);
            this.finish();
        }
    }
    
    protected void onStop() {
        while (true) {
            try {
                if (this.a != null) {
                    this.a.h();
                }
                super.onStop();
            }
            catch (RemoteException ex) {
                en.c("Could not forward onStop to ad overlay:", (Throwable)ex);
                this.finish();
                continue;
            }
            break;
        }
    }
    
    public void setContentView(final int contentView) {
        super.setContentView(contentView);
        this.a();
    }
    
    public void setContentView(final View contentView) {
        super.setContentView(contentView);
        this.a();
    }
    
    public void setContentView(final View view, final ViewGroup$LayoutParams viewGroup$LayoutParams) {
        super.setContentView(view, viewGroup$LayoutParams);
        this.a();
    }
}

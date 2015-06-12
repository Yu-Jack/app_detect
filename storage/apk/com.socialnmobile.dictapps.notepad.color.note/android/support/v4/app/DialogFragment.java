// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.content.DialogInterface;
import android.view.View;
import android.view.LayoutInflater;
import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface$OnDismissListener;
import android.content.DialogInterface$OnCancelListener;

public class DialogFragment extends Fragment implements DialogInterface$OnCancelListener, DialogInterface$OnDismissListener
{
    int a;
    int b;
    boolean c;
    boolean d;
    int e;
    public Dialog f;
    boolean g;
    boolean h;
    boolean i;
    
    public DialogFragment() {
        this.a = 0;
        this.b = 0;
        this.c = true;
        this.d = true;
        this.e = -1;
    }
    
    @Override
    public final void a(final Activity activity) {
        super.a(activity);
        if (!this.i) {
            this.h = false;
        }
    }
    
    @Override
    public void a(final Bundle bundle) {
        super.a(bundle);
        this.d = (this.G == 0);
        if (bundle != null) {
            this.a = bundle.getInt("android:style", 0);
            this.b = bundle.getInt("android:theme", 0);
            this.c = bundle.getBoolean("android:cancelable", true);
            this.d = bundle.getBoolean("android:showsDialog", this.d);
            this.e = bundle.getInt("android:backStackId", -1);
        }
    }
    
    public final void a(final m m, final String s) {
        this.h = false;
        this.i = true;
        final u a = m.a();
        a.a(this, s);
        a.b();
    }
    
    public final void a(final boolean b) {
        if (this.h) {
            return;
        }
        this.h = true;
        this.i = false;
        if (this.f != null) {
            this.f.dismiss();
            this.f = null;
        }
        this.g = true;
        if (this.e >= 0) {
            super.B.b(this.e);
            this.e = -1;
            return;
        }
        final u a = super.B.a();
        a.a(this);
        if (b) {
            a.c();
            return;
        }
        a.b();
    }
    
    public Dialog b() {
        return new Dialog((Context)super.C, this.b);
    }
    
    @Override
    public final LayoutInflater b(final Bundle bundle) {
        if (!this.d) {
            return super.b(bundle);
        }
        this.f = this.b();
        switch (this.a) {
            case 3: {
                this.f.getWindow().addFlags(24);
            }
            case 1:
            case 2: {
                this.f.requestWindowFeature(1);
                break;
            }
        }
        if (this.f != null) {
            return (LayoutInflater)this.f.getContext().getSystemService("layout_inflater");
        }
        return (LayoutInflater)this.C.getSystemService("layout_inflater");
    }
    
    @Override
    public final void b_() {
        super.b_();
        if (!this.i && !this.h) {
            this.h = true;
        }
    }
    
    @Override
    public void c() {
        super.c();
        if (this.f != null) {
            this.g = false;
            this.f.show();
        }
    }
    
    @Override
    public final void c(final Bundle bundle) {
        super.c(bundle);
        if (this.d) {
            final View r = super.R;
            if (r != null) {
                if (r.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.f.setContentView(r);
            }
            this.f.setOwnerActivity((Activity)super.C);
            this.f.setCancelable(this.c);
            this.f.setOnCancelListener((DialogInterface$OnCancelListener)this);
            this.f.setOnDismissListener((DialogInterface$OnDismissListener)this);
            if (bundle != null) {
                final Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.f.onRestoreInstanceState(bundle2);
                }
            }
        }
    }
    
    @Override
    public void d() {
        super.d();
        if (this.f != null) {
            this.f.hide();
        }
    }
    
    @Override
    public final void d(final Bundle bundle) {
        super.d(bundle);
        if (this.f != null) {
            final Bundle onSaveInstanceState = this.f.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.a != 0) {
            bundle.putInt("android:style", this.a);
        }
        if (this.b != 0) {
            bundle.putInt("android:theme", this.b);
        }
        if (!this.c) {
            bundle.putBoolean("android:cancelable", this.c);
        }
        if (!this.d) {
            bundle.putBoolean("android:showsDialog", this.d);
        }
        if (this.e != -1) {
            bundle.putInt("android:backStackId", this.e);
        }
    }
    
    @Override
    public final void e() {
        super.e();
        if (this.f != null) {
            this.g = true;
            this.f.dismiss();
            this.f = null;
        }
    }
    
    public void onCancel(final DialogInterface dialogInterface) {
    }
    
    public void onDismiss(final DialogInterface dialogInterface) {
        if (!this.g) {
            this.a(true);
        }
    }
}

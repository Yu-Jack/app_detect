// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.a;

import com.ogqcorp.bgh.system.ac;
import com.ogqcorp.bgh.system.w;
import com.ogqcorp.bgh.system.y;
import android.app.Activity;
import com.ogqcorp.bgh.system.s;
import android.widget.Toast;
import com.ogqcorp.bgh.system.c;
import java.io.File;
import com.ogqcorp.commons.u;
import com.ogqcorp.commons.e;
import java.util.HashMap;
import android.os.AsyncTask;
import com.ogqcorp.bgh.system.n;
import com.ogqcorp.commons.l;
import com.ogqcorp.commons.o;
import android.content.Context;
import com.ogqcorp.bgh.b.i;
import com.ogqcorp.bgh.item.Background;
import android.support.v4.app.FragmentActivity;

class k extends d<FragmentActivity>
{
    k(final FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    
    private i a(final Background background) {
        final String title = background.getTitle();
        final i i = new i();
        i.a(title);
        return i;
    }
    
    protected static void a(final Context context, final Background background) {
        new o().a(background, "background");
        new AsyncTask<Object, Object, Object>() {
            final /* synthetic */ String a = com.ogqcorp.bgh.system.o.b().g(background.getId());
            final /* synthetic */ HashMap b = n.b(l.a(context));
            
            protected Object doInBackground(final Object... array) {
                try {
                    new e().a(this.a, this.b, 3000);
                    return null;
                }
                catch (Exception ex) {
                    com.ogqcorp.commons.n.c(ex);
                    return null;
                }
            }
        }.execute(new Object[0]);
    }
    
    private void a(final FragmentActivity fragmentActivity, final Background background, final boolean b, final u<File> u, final u<Exception> u2) {
        c.a().e((Context)fragmentActivity, background);
        final File a = com.ogqcorp.bgh.system.o.b().a((Context)fragmentActivity, background.getId(), b);
        if (a.exists()) {
            this.a(background, a, u, false);
            return;
        }
        this.a(background).a(fragmentActivity.getSupportFragmentManager(), com.ogqcorp.bgh.system.o.b().b((Context)fragmentActivity, background.getId(), b), a, new u<Exception>() {
            @Override
            public void a(final Exception ex) {
                if (ex == null) {
                    k.this.a(background, a, u, true);
                    return;
                }
                k.this.a(background, ex, u2);
            }
        });
    }
    
    protected void a(final Background background, final File file, final u<File> u, final boolean b) {
        final FragmentActivity fragmentActivity = this.a();
        if (fragmentActivity != null) {
            Toast.makeText((Context)fragmentActivity, 2131427484, 0).show();
            s.a(fragmentActivity);
            if (b) {
                w.a((Context)fragmentActivity, file, new y() {
                    @Override
                    public void a() {
                        if (u != null) {
                            u.a(file);
                        }
                    }
                });
                a((Context)fragmentActivity, background);
                return;
            }
            if (u != null) {
                u.a(file);
            }
        }
    }
    
    protected void a(final Background background, final Exception ex, final u<Exception> u) {
        final FragmentActivity fragmentActivity = this.a();
        if (fragmentActivity != null) {
            if (ex instanceof InterruptedException) {
                ac.a((Context)fragmentActivity, 0, 2131427482, new Object[0]).show();
            }
            else {
                ac.a((Context)fragmentActivity, 0, 2131427483, ex.toString()).show();
            }
            if (u != null) {
                u.a(ex);
            }
        }
    }
    
    void a(final Background background, final boolean b, final u<File> u, final u<Exception> u2) {
        new o().a(background, "background");
        final FragmentActivity fragmentActivity = this.a();
        if (fragmentActivity != null) {
            this.a(fragmentActivity, background, b, u, u2);
        }
    }
}

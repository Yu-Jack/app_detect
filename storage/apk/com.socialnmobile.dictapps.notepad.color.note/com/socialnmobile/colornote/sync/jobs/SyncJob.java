// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.sync.jobs;

import android.content.SharedPreferences$Editor;
import com.socialnmobile.colornote.ColorNote;
import android.database.ContentObserver;
import android.content.SharedPreferences;
import org.apache.http.client.HttpClient;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import java.util.concurrent.Semaphore;
import java.util.concurrent.Callable;
import android.preference.PreferenceManager;
import android.content.Context;

public class SyncJob extends AuthRequiredJob
{
    final Context context;
    final ug handler;
    final wf progressCallback;
    
    public SyncJob(final Context context, final rt rt, final xm xm, final SyncJob$Listener syncJob$Listener) {
        super(context, rt, xm, syncJob$Listener);
        this.progressCallback = new wy(this);
        this.context = context;
        this.handler = new ug(context);
    }
    
    @Override
    public Object callWithAccount(final rt rt) {
        final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        we we;
        xx xx;
        sh e;
        int f;
        td td;
        ug handler;
        Semaphore semaphore;
        wm b;
        Label_0090_Outer:Label_0106_Outer:
        while (true) {
            while (true) {
                Label_0391: {
                    while (true) {
                        try {
                            we = new we(rt, this.jsonrpc, defaultSharedPreferences.getInt("Sync.NOTES_PER_COMMIT", 20), this.progressCallback);
                            xx = new abq(new wx(), we).call();
                            if (xx == null) {
                                break Label_0391;
                            }
                            e = xx.e;
                            if (e != null) {
                                f = e.f;
                                jo.a(this.context, xx.i);
                                return new xb(f, we.l, we.m, we.n, we.o);
                            }
                        }
                        catch (xn xn) {
                            if (xn.a() == 447) {
                                rt.a((tw)tw.d.d(((xj)xn.b()).h("repository_built")));
                                continue Label_0090_Outer;
                            }
                            throw xn;
                        }
                        catch (uf uf) {
                            td = (td)rt.q.c();
                            handler = this.handler;
                            semaphore = new Semaphore(0);
                            handler.a.post((Runnable)new uh(handler, semaphore));
                            semaphore.acquire();
                            b = new tr(this.context).b();
                            b.addRequestInterceptor((HttpRequestInterceptor)new wl(this.context));
                            b.addRequestInterceptor((HttpRequestInterceptor)new xa(this, td));
                            new xm(new xp((HttpClient)b, (HttpHost)tz.a.a("JSONRPC_HOST", new wv().a()), (String)tz.a.a("JSONRPC_PATH", "/api/v1/jsonrpc"))).a(new xr("deviceWipeoutComplete", new xj()));
                            return new xb(0, 0, 0, 0, 0);
                        }
                        f = 0;
                        continue Label_0106_Outer;
                    }
                }
                f = 0;
                continue;
            }
        }
    }
    
    @Override
    public boolean onJobException(final Exception ex) {
        jp.a(this.context, System.currentTimeMillis(), ex);
        return super.onJobException(ex);
    }
    
    @Override
    public void onJobFinally() {
        this.context.getContentResolver().notifyChange(kf.a, (ContentObserver)null);
    }
    
    @Override
    public void onJobResult(final Object o) {
        final xb xb = (xb)o;
        final Context context = this.context;
        final long currentTimeMillis = System.currentTimeMillis();
        final SharedPreferences$Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putLong("LAST_SYNC_TIME_MILLIS", currentTimeMillis);
        edit.commit();
        if (xb != null) {
            final Context context2 = this.context;
            final int a = xb.a();
            final SharedPreferences$Editor edit2 = PreferenceManager.getDefaultSharedPreferences(context2).edit();
            edit2.putInt("SYNC_NOTE_COUNT", a);
            edit2.commit();
            if (xb.b() > 0) {
                final Context context3 = this.context;
                final long currentTimeMillis2 = System.currentTimeMillis();
                final SharedPreferences$Editor edit3 = PreferenceManager.getDefaultSharedPreferences(context3).edit();
                edit3.putLong("LAST_SYNC_CHECKOUT_TIME_MILLIS", currentTimeMillis2);
                edit3.commit();
            }
        }
        ColorNote.a();
        ColorNote.g();
        rq.a(this.context);
    }
}

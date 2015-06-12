// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.sync;

import org.apache.http.HttpHost;
import com.socialnmobile.colornote.data.NoteProvider;
import com.socialnmobile.colornote.ColorNote;
import android.os.IBinder;
import com.socialnmobile.colornote.sync.jobs.listeners.GoogleSignupListener;
import com.socialnmobile.colornote.sync.jobs.listeners.GoogleReloginListener;
import com.socialnmobile.colornote.sync.jobs.listeners.GoogleLoginListener;
import com.socialnmobile.colornote.sync.jobs.listeners.FacebookSignupListener;
import com.socialnmobile.colornote.sync.jobs.listeners.FacebookReloginListener;
import com.socialnmobile.colornote.sync.jobs.listeners.FacebookLoginListener;
import com.socialnmobile.colornote.sync.jobs.listeners.EmailLoginListener;
import com.socialnmobile.colornote.sync.jobs.listeners.EmailReloginListener;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import com.socialnmobile.colornote.sync.jobs.SyncJob;
import com.socialnmobile.colornote.sync.jobs.SyncJob$Listener;
import com.socialnmobile.util.service.ServiceJob;
import com.socialnmobile.colornote.sync.jobs.AuthJob;
import com.socialnmobile.colornote.sync.jobs.AuthJob$Listener;
import android.content.Context;
import com.socialnmobile.util.service.ServiceJob$JobListener;
import com.socialnmobile.util.service.JobService;

public class SyncService extends JobService
{
    public static final String a;
    xo b;
    xm c;
    sf d;
    
    static {
        a = SyncService.class.getSimpleName();
    }
    
    private void a(final RuntimeException ex, final ServiceJob$JobListener serviceJob$JobListener) {
        adl.a.a((Context)this, ex);
        this.g.post((Runnable)new vy(this, serviceJob$JobListener));
        this.g.post((Runnable)new vz(this, ex, serviceJob$JobListener));
        this.g.post((Runnable)new wa(this, serviceJob$JobListener));
    }
    
    private void a(final sl sl, final ss ss, final tt tt, final AuthJob$Listener authJob$Listener) {
        try {
            this.a(this.a(new AuthJob(this.d, this.c, sl, ss, tt, authJob$Listener)));
        }
        catch (RuntimeException ex) {
            this.a(ex, authJob$Listener);
        }
    }
    
    public final void a() {
        this.a(new SyncService$BackgroundSyncListener((Context)this, false, false));
    }
    
    public final void a(final SyncJob$Listener syncJob$Listener) {
        final rt a = this.d.a();
        if (a == null) {
            return;
        }
        try {
            final SyncJob syncJob = new SyncJob((Context)this, a, this.c, syncJob$Listener);
            final String string = this.getString(2131231017);
            final PendingIntent activity = PendingIntent.getActivity((Context)this, 0, new Intent(), 1073741824);
            final Notification notification = new Notification(17301628, (CharSequence)null, System.currentTimeMillis());
            notification.setLatestEventInfo((Context)this, this.getText(2131230728), (CharSequence)string, activity);
            notification.flags = 18;
            this.a(abo.a(this.a(notification), this.a(syncJob)));
        }
        catch (RuntimeException ex) {
            this.a(ex, syncJob$Listener);
        }
    }
    
    public final void a(final String s, final EmailReloginListener emailReloginListener) {
        this.a(sl.a, ss.c, new ui(null, s), emailReloginListener);
    }
    
    public final void a(final String s, final String s2, final EmailLoginListener emailLoginListener) {
        this.a(sl.a, ss.b, new ui(s, s2), emailLoginListener);
    }
    
    public final void a(final ur ur, final FacebookLoginListener facebookLoginListener) {
        this.a(sl.b, ss.b, ur, facebookLoginListener);
    }
    
    public final void a(final ur ur, final FacebookReloginListener facebookReloginListener) {
        this.a(sl.b, ss.c, ur, facebookReloginListener);
    }
    
    public final void a(final ur ur, final FacebookSignupListener facebookSignupListener) {
        this.a(sl.b, ss.a, ur, facebookSignupListener);
    }
    
    public final void a(final uu uu, final GoogleLoginListener googleLoginListener) {
        this.a(sl.c, ss.b, uu, googleLoginListener);
    }
    
    public final void a(final uu uu, final GoogleReloginListener googleReloginListener) {
        this.a(sl.c, ss.c, uu, googleReloginListener);
    }
    
    public final void a(final uu uu, final GoogleSignupListener googleSignupListener) {
        this.a(sl.c, ss.a, uu, googleSignupListener);
    }
    
    @Override
    protected final IBinder b() {
        return (IBinder)new wc(this);
    }
    
    @Override
    public void onCreate() {
        ColorNote.a();
        super.onCreate();
        final ki b = NoteProvider.b((Context)this);
        this.b = new xp(new ws((Context)this, b).c(), (HttpHost)tz.a.a("JSONRPC_HOST", new tr((Context)this).a().a()), (String)tz.a.a("JSONRPC_PATH", "/api/v1/jsonrpc"));
        this.c = new xm(this.b);
        this.d = new sg((Context)this, b);
    }
    
    @Override
    public void onDestroy() {
        ColorNote.a();
        super.onDestroy();
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.util.service;

import java.util.concurrent.Executors;
import android.os.IBinder;
import android.content.Context;
import android.content.Intent;
import com.socialnmobile.colornote.ColorNote;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import android.app.Notification;
import android.os.Handler;
import android.app.Service;

public abstract class JobService extends Service implements aca
{
    static String e;
    public final jm f;
    protected final Handler g;
    abx h;
    
    static {
        JobService.e = JobService.class.getSimpleName();
    }
    
    public JobService() {
        this.f = new jm(this);
        this.g = new Handler();
    }
    
    public final abk a(final Notification notification) {
        return new abl(new adn(this, notification), this.g);
    }
    
    public final Runnable a(final ServiceJob serviceJob) {
        return abo.a(new abl(new ado(this, serviceJob), this.g), new abw(serviceJob, new abs(new adp(this, serviceJob), this.g)));
    }
    
    public final Future a(final Runnable task) {
        ColorNote.a();
        this.startService(new Intent((Context)this, (Class)this.getClass()));
        return this.h.submit(task);
    }
    
    protected abstract IBinder b();
    
    public final void c() {
        ColorNote.a();
        this.stopSelf();
    }
    
    public IBinder onBind(final Intent intent) {
        ColorNote.a();
        return this.b();
    }
    
    public void onCreate() {
        super.onCreate();
        ColorNote.a();
        this.h = new abx(Executors.newSingleThreadExecutor(), this, this.g);
    }
    
    public void onDestroy() {
        ColorNote.a();
        this.h.shutdown();
        super.onDestroy();
    }
    
    public boolean onUnbind(final Intent intent) {
        ColorNote.a();
        return false;
    }
}

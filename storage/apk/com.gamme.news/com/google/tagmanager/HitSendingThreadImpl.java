// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.LinkedBlockingQueue;
import android.content.Context;

class HitSendingThreadImpl extends Thread implements HitSendingThread
{
    private static HitSendingThreadImpl sInstance;
    private volatile boolean mClosed;
    private final Context mContext;
    private volatile boolean mDisabled;
    private volatile HitStore mUrlStore;
    private final LinkedBlockingQueue<Runnable> queue;
    
    private HitSendingThreadImpl(final Context mContext) {
        super("GAThread");
        this.queue = new LinkedBlockingQueue<Runnable>();
        this.mDisabled = false;
        this.mClosed = false;
        if (mContext != null) {
            this.mContext = mContext.getApplicationContext();
        }
        else {
            this.mContext = mContext;
        }
        this.start();
    }
    
    HitSendingThreadImpl(final Context mContext, final HitStore mUrlStore) {
        super("GAThread");
        this.queue = new LinkedBlockingQueue<Runnable>();
        this.mDisabled = false;
        this.mClosed = false;
        if (mContext != null) {
            this.mContext = mContext.getApplicationContext();
        }
        else {
            this.mContext = mContext;
        }
        this.mUrlStore = mUrlStore;
        this.start();
    }
    
    static HitSendingThreadImpl getInstance(final Context context) {
        if (HitSendingThreadImpl.sInstance == null) {
            HitSendingThreadImpl.sInstance = new HitSendingThreadImpl(context);
        }
        return HitSendingThreadImpl.sInstance;
    }
    
    private String printStackTrace(final Throwable t) {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        final PrintStream s = new PrintStream(out);
        t.printStackTrace(s);
        s.flush();
        return new String(out.toByteArray());
    }
    
    @VisibleForTesting
    void close() {
        this.mClosed = true;
        this.interrupt();
    }
    
    @VisibleForTesting
    int getQueueSize() {
        return this.queue.size();
    }
    
    @VisibleForTesting
    HitStore getStore() {
        return this.mUrlStore;
    }
    
    @VisibleForTesting
    boolean isDisabled() {
        return this.mDisabled;
    }
    
    @Override
    public void queueToThread(final Runnable e) {
        this.queue.add(e);
    }
    
    @Override
    public void run() {
        while (!this.mClosed) {
            try {
                try {
                    final Runnable runnable = this.queue.take();
                    if (!this.mDisabled) {
                        runnable.run();
                        continue;
                    }
                    continue;
                }
                catch (InterruptedException ex) {
                    Log.i(ex.toString());
                }
            }
            catch (Throwable t) {
                Log.e("Error on GAThread: " + this.printStackTrace(t));
                Log.e("Google Analytics is shutting down.");
                this.mDisabled = true;
                continue;
            }
            break;
        }
    }
    
    @Override
    public void sendHit(final String s) {
        this.sendHit(s, System.currentTimeMillis());
    }
    
    @VisibleForTesting
    void sendHit(final String s, final long n) {
        this.queueToThread(new Runnable() {
            final /* synthetic */ HitSendingThread val$thread;
            
            @Override
            public void run() {
                if (HitSendingThreadImpl.this.mUrlStore == null) {
                    final ServiceManagerImpl instance = ServiceManagerImpl.getInstance();
                    instance.initialize(HitSendingThreadImpl.this.mContext, this.val$thread);
                    HitSendingThreadImpl.this.mUrlStore = instance.getStore();
                }
                HitSendingThreadImpl.this.mUrlStore.putHit(n, s);
            }
        });
    }
}

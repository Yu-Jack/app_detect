// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.sync.jobs;

import com.socialnmobile.util.service.ServiceJob$JobListener;
import java.util.concurrent.Callable;
import com.socialnmobile.colornote.sync.SyncServiceJob;

public class AuthJob extends SyncServiceJob
{
    final Callable callable;
    
    public AuthJob(final sf sf, final xm xm, final sl sl, final ss ss, final tt tt, final AuthJob$Listener jobListener) {
        super(xm);
        this.callable = ss.a(sf, xm, sl, tt);
        this.setJobListener(jobListener);
    }
    
    @Override
    public final rt call() {
        return this.callable.call();
    }
}

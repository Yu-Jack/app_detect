// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.sync.jobs;

import com.socialnmobile.colornote.sync.errors.AuthRequired;
import com.socialnmobile.util.service.ServiceJob$JobListener;
import android.content.Context;
import com.socialnmobile.colornote.sync.SyncServiceJob;

public abstract class AuthRequiredJob extends SyncServiceJob
{
    final rt currentAccount;
    
    public AuthRequiredJob(final Context context, final rt currentAccount, final xm xm, final AuthRequiredJob$Listener jobListener) {
        super(xm);
        this.currentAccount = currentAccount;
        if (currentAccount == null) {
            throw new IllegalArgumentException("account is null");
        }
        this.setJobListener(jobListener);
    }
    
    @Override
    public final Object call() {
        if (!this.currentAccount.r()) {
            throw new AuthRequired("AuthToken is required");
        }
        return this.callWithAccount(this.currentAccount);
    }
    
    public abstract Object callWithAccount(final rt p0);
    
    @Override
    public boolean onJobException(final Exception ex) {
        if (ex instanceof AuthRequired) {
            final AuthRequired authRequired = (AuthRequired)ex;
            final AuthRequiredJob$Listener authRequiredJob$Listener = (AuthRequiredJob$Listener)this.getJobListener();
            if (authRequiredJob$Listener != null) {
                authRequiredJob$Listener.onError(authRequired);
            }
            return true;
        }
        return super.onJobException(ex);
    }
}

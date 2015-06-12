// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.util.service;

import java.util.concurrent.Callable;

public abstract class ServiceJob implements Callable
{
    public ServiceJob$JobListener listener;
    
    public ServiceJob$JobListener getJobListener() {
        return this.listener;
    }
    
    public boolean onJobException(final Exception ex) {
        return false;
    }
    
    public void onJobFinally() {
    }
    
    public void onJobResult(final Object o) {
    }
    
    public void setJobListener(final ServiceJob$JobListener listener) {
        this.listener = listener;
    }
}

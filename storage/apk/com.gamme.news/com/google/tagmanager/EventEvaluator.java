// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

class EventEvaluator
{
    private final ResourceUtil.ExpandedResource mResource;
    private final Runtime mRuntime;
    
    public EventEvaluator(final Runtime mRuntime, final ResourceUtil.ExpandedResource expandedResource) {
        if (mRuntime == null) {
            throw new NullPointerException("runtime cannot be null");
        }
        this.mRuntime = mRuntime;
        if (expandedResource != mRuntime.getResource()) {
            throw new IllegalArgumentException("resource must be the same as the resource in runtime");
        }
        this.mResource = mRuntime.getResource();
    }
    
    void evaluateEvent(final String s) {
        throw new UnsupportedOperationException("this code not yet written");
    }
}

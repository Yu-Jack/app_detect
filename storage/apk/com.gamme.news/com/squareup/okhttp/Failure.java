// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp;

class Failure
{
    private final Throwable exception;
    private final Request request;
    
    private Failure(final Builder builder) {
        this.request = builder.request;
        this.exception = builder.exception;
    }
    
    public Throwable exception() {
        return this.exception;
    }
    
    public Request request() {
        return this.request;
    }
    
    public static class Builder
    {
        private Throwable exception;
        private Request request;
        
        public Failure build() {
            return new Failure(this, null);
        }
        
        public Builder exception(final Throwable exception) {
            this.exception = exception;
            return this;
        }
        
        public Builder request(final Request request) {
            this.request = request;
            return this;
        }
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.spdy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.CountDownLatch;

public final class Ping
{
    private final CountDownLatch latch;
    private long received;
    private long sent;
    
    Ping() {
        this.latch = new CountDownLatch(1);
        this.sent = -1L;
        this.received = -1L;
    }
    
    void cancel() {
        if (this.received != -1L || this.sent == -1L) {
            throw new IllegalStateException();
        }
        this.received = this.sent - 1L;
        this.latch.countDown();
    }
    
    void receive() {
        if (this.received != -1L || this.sent == -1L) {
            throw new IllegalStateException();
        }
        this.received = System.nanoTime();
        this.latch.countDown();
    }
    
    public long roundTripTime() throws InterruptedException {
        this.latch.await();
        return this.received - this.sent;
    }
    
    public long roundTripTime(final long timeout, final TimeUnit unit) throws InterruptedException {
        if (this.latch.await(timeout, unit)) {
            return this.received - this.sent;
        }
        return -2L;
    }
    
    void send() {
        if (this.sent != -1L) {
            throw new IllegalStateException();
        }
        this.sent = System.nanoTime();
    }
}

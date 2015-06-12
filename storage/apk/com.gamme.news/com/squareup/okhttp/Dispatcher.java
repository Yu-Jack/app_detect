// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp;

import java.io.IOException;
import com.squareup.okhttp.internal.http.ResponseHeaders;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.List;
import java.util.Map;

final class Dispatcher
{
    private final Map<Object, List<Job>> enqueuedJobs;
    private final ThreadPoolExecutor executorService;
    
    Dispatcher() {
        this.executorService = new ThreadPoolExecutor(8, 8, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        this.enqueuedJobs = new LinkedHashMap<Object, List<Job>>();
    }
    
    public void cancel(final Object o) {
        synchronized (this) {
            final List<Job> list = this.enqueuedJobs.remove(o);
            if (list != null) {
                final Iterator<Job> iterator = list.iterator();
                while (iterator.hasNext()) {
                    this.executorService.remove(iterator.next());
                }
            }
        }
    }
    
    public void enqueue(final OkHttpClient okHttpClient, final Request request, final Response.Receiver receiver) {
        synchronized (this) {
            final Job command = new Job(this, okHttpClient, request, receiver);
            List<Job> list = this.enqueuedJobs.get(request.tag());
            if (list == null) {
                list = new ArrayList<Job>(2);
                this.enqueuedJobs.put(request.tag(), list);
            }
            list.add(command);
            this.executorService.execute(command);
        }
    }
    
    void finished(final Job job) {
        synchronized (this) {
            final List<Job> list = this.enqueuedJobs.get(job.tag());
            if (list != null) {
                list.remove(job);
            }
        }
    }
    
    static class RealResponseBody extends Body
    {
        private final InputStream in;
        private final ResponseHeaders responseHeaders;
        
        RealResponseBody(final ResponseHeaders responseHeaders, final InputStream in) {
            this.responseHeaders = responseHeaders;
            this.in = in;
        }
        
        @Override
        public InputStream byteStream() throws IOException {
            return this.in;
        }
        
        @Override
        public long contentLength() {
            return this.responseHeaders.getContentLength();
        }
        
        @Override
        public MediaType contentType() {
            final String contentType = this.responseHeaders.getContentType();
            if (contentType != null) {
                return MediaType.parse(contentType);
            }
            return null;
        }
        
        @Override
        public boolean ready() throws IOException {
            return true;
        }
    }
}

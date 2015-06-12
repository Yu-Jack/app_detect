// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp;

import java.util.List;
import java.net.SocketException;
import com.squareup.okhttp.internal.Platform;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import com.squareup.okhttp.internal.Util;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Callable;
import java.util.LinkedList;

public class ConnectionPool
{
    private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 300000L;
    private static final int MAX_CONNECTIONS_TO_CLEANUP = 2;
    private static final ConnectionPool systemDefault;
    private final LinkedList<Connection> connections;
    private final Callable<Void> connectionsCleanupCallable;
    private final ExecutorService executorService;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;
    
    static {
        final String property = System.getProperty("http.keepAlive");
        final String property2 = System.getProperty("http.keepAliveDuration");
        final String property3 = System.getProperty("http.maxConnections");
        long long1;
        if (property2 != null) {
            long1 = Long.parseLong(property2);
        }
        else {
            long1 = 300000L;
        }
        if (property != null && !Boolean.parseBoolean(property)) {
            systemDefault = new ConnectionPool(0, long1);
            return;
        }
        if (property3 != null) {
            systemDefault = new ConnectionPool(Integer.parseInt(property3), long1);
            return;
        }
        systemDefault = new ConnectionPool(5, long1);
    }
    
    public ConnectionPool(final int maxIdleConnections, final long n) {
        this.connections = new LinkedList<Connection>();
        this.executorService = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), Util.daemonThreadFactory("OkHttp ConnectionPool"));
        this.connectionsCleanupCallable = new Callable<Void>() {
            @Override
            public Void call() throws Exception {
            Label_0103_Outer:
                while (true) {
                    final ArrayList<Connection> list = new ArrayList<Connection>(2);
                    int n = 0;
                    while (true) {
                        final Iterator<Object> iterator;
                        synchronized (ConnectionPool.this) {
                            final ListIterator<Connection> listIterator = (ListIterator<Connection>)ConnectionPool.this.connections.listIterator(ConnectionPool.this.connections.size());
                            while (listIterator.hasPrevious()) {
                                final Connection connection = listIterator.previous();
                                if (!connection.isAlive() || connection.isExpired(ConnectionPool.this.keepAliveDurationNs)) {
                                    listIterator.remove();
                                    list.add(connection);
                                    if (list.size() == 2) {
                                        break;
                                    }
                                    continue Label_0103_Outer;
                                }
                                else {
                                    if (!connection.isIdle()) {
                                        continue Label_0103_Outer;
                                    }
                                    ++n;
                                }
                            }
                            for (ListIterator<Connection> listIterator2 = (ListIterator<Connection>)ConnectionPool.this.connections.listIterator(ConnectionPool.this.connections.size()); listIterator2.hasPrevious() && n > ConnectionPool.this.maxIdleConnections; --n) {
                                final Connection connection2 = listIterator2.previous();
                                if (connection2.isIdle()) {
                                    list.add(connection2);
                                    listIterator2.remove();
                                }
                            }
                            // monitorexit(this.this$0)
                            iterator = list.iterator();
                            if (!iterator.hasNext()) {
                                return null;
                            }
                        }
                        Util.closeQuietly(iterator.next());
                        continue;
                    }
                }
            }
        };
        this.maxIdleConnections = maxIdleConnections;
        this.keepAliveDurationNs = 1000L * (n * 1000L);
    }
    
    public static ConnectionPool getDefault() {
        return ConnectionPool.systemDefault;
    }
    
    private void waitForCleanupCallableToRun() {
        try {
            this.executorService.submit(new Runnable() {
                @Override
                public void run() {
                }
            }).get();
        }
        catch (Exception ex) {
            throw new AssertionError();
        }
    }
    
    public void evictAll() {
        while (true) {
            while (true) {
                final Iterator<Object> iterator;
                synchronized (this) {
                    final ArrayList<Connection> list = (ArrayList<Connection>)new ArrayList<Object>(this.connections);
                    this.connections.clear();
                    // monitorexit(this)
                    iterator = list.iterator();
                    if (!iterator.hasNext()) {
                        return;
                    }
                }
                Util.closeQuietly(iterator.next());
                continue;
            }
        }
    }
    
    public Connection get(final Address address) {
        synchronized (this) {
            final ListIterator<Connection> listIterator = this.connections.listIterator(this.connections.size());
            Connection e;
            while (true) {
                final boolean hasPrevious = listIterator.hasPrevious();
                e = null;
                if (!hasPrevious) {
                    break;
                }
                final Connection connection = listIterator.previous();
                if (!connection.getRoute().getAddress().equals(address) || !connection.isAlive() || System.nanoTime() - connection.getIdleStartTimeNs() >= this.keepAliveDurationNs) {
                    continue;
                }
                listIterator.remove();
                Label_0154: {
                    if (connection.isSpdy()) {
                        break Label_0154;
                    }
                    try {
                        Platform.get().tagSocket(connection.getSocket());
                        e = connection;
                    }
                    catch (SocketException obj) {
                        Util.closeQuietly(connection);
                        Platform.get().logW("Unable to tagSocket(): " + obj);
                    }
                }
            }
            if (e != null && e.isSpdy()) {
                this.connections.addFirst(e);
            }
            this.executorService.submit(this.connectionsCleanupCallable);
            return e;
        }
    }
    
    public int getConnectionCount() {
        synchronized (this) {
            return this.connections.size();
        }
    }
    
    List<Connection> getConnections() {
        this.waitForCleanupCallableToRun();
        synchronized (this) {
            return new ArrayList<Connection>(this.connections);
        }
    }
    
    public int getHttpConnectionCount() {
        // monitorenter(this)
        int n = 0;
        try {
            final Iterator<Connection> iterator = (Iterator<Connection>)this.connections.iterator();
            while (iterator.hasNext()) {
                if (!iterator.next().isSpdy()) {
                    ++n;
                }
            }
            return n;
        }
        finally {
        }
        // monitorexit(this)
    }
    
    public int getSpdyConnectionCount() {
        // monitorenter(this)
        int n = 0;
        try {
            final Iterator<Connection> iterator = (Iterator<Connection>)this.connections.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().isSpdy()) {
                    ++n;
                }
            }
            return n;
        }
        finally {
        }
        // monitorexit(this)
    }
    
    public void maybeShare(final Connection e) {
        this.executorService.submit(this.connectionsCleanupCallable);
        if (!e.isSpdy() || !e.isAlive()) {
            return;
        }
        synchronized (this) {
            this.connections.addFirst(e);
        }
    }
    
    public void recycle(final Connection connection) {
        if (connection.isSpdy()) {
            return;
        }
        if (!connection.isAlive()) {
            Util.closeQuietly(connection);
            return;
        }
        try {
            Platform.get().untagSocket(connection.getSocket());
            // monitorenter(this)
            final ConnectionPool connectionPool = this;
            final LinkedList<Connection> list = connectionPool.connections;
            final Connection connection2 = connection;
            list.addFirst(connection2);
            final Connection connection3 = connection;
            connection3.resetIdleStartTime();
            final ConnectionPool connectionPool2 = this;
            // monitorexit(connectionPool2)
            final ConnectionPool connectionPool3 = this;
            final ExecutorService executorService = connectionPool3.executorService;
            final ConnectionPool connectionPool4 = this;
            final Callable<Void> callable = connectionPool4.connectionsCleanupCallable;
            executorService.submit((Callable<Object>)callable);
            return;
        }
        catch (SocketException obj) {
            Platform.get().logW("Unable to untagSocket(): " + obj);
            Util.closeQuietly(connection);
            return;
        }
        try {
            final ConnectionPool connectionPool = this;
            final LinkedList<Connection> list = connectionPool.connections;
            final Connection connection2 = connection;
            list.addFirst(connection2);
            final Connection connection3 = connection;
            connection3.resetIdleStartTime();
            final ConnectionPool connectionPool2 = this;
            // monitorexit(connectionPool2)
            final ConnectionPool connectionPool3 = this;
            final ExecutorService executorService = connectionPool3.executorService;
            final ConnectionPool connectionPool4 = this;
            final Callable<Void> callable = connectionPool4.connectionsCleanupCallable;
            executorService.submit((Callable<Object>)callable);
        }
        finally {
        }
        // monitorexit(this)
    }
}

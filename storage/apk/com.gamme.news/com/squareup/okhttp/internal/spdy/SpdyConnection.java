// 
// Decompiled by Procyon v0.5.29
// 

package com.squareup.okhttp.internal.spdy;

import java.util.Iterator;
import java.net.Socket;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.List;
import com.squareup.okhttp.internal.NamedRunnable;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import com.squareup.okhttp.internal.Util;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.io.Closeable;

public final class SpdyConnection implements Closeable
{
    private static final ExecutorService executor;
    final boolean client;
    private final FrameReader frameReader;
    private final FrameWriter frameWriter;
    private final IncomingStreamHandler handler;
    private final String hostName;
    private long idleStartTimeNs;
    private int lastGoodStreamId;
    private int nextPingId;
    private int nextStreamId;
    private Map<Integer, Ping> pings;
    Settings settings;
    private boolean shutdown;
    private final Map<Integer, SpdyStream> streams;
    final Variant variant;
    
    static {
        executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), Util.daemonThreadFactory("OkHttp SpdyConnection"));
    }
    
    private SpdyConnection(final Builder builder) {
        int nextPingId = 1;
        this.streams = new HashMap<Integer, SpdyStream>();
        this.idleStartTimeNs = System.nanoTime();
        this.variant = builder.variant;
        this.client = builder.client;
        this.handler = builder.handler;
        this.frameReader = this.variant.newReader(builder.in, this.client);
        this.frameWriter = this.variant.newWriter(builder.out, this.client);
        int nextStreamId;
        if (builder.client) {
            nextStreamId = nextPingId;
        }
        else {
            nextStreamId = 2;
        }
        this.nextStreamId = nextStreamId;
        if (!builder.client) {
            nextPingId = 2;
        }
        this.nextPingId = nextPingId;
        this.hostName = builder.hostName;
        new Thread(new Reader((Reader)null), "Spdy Reader " + this.hostName).start();
    }
    
    static /* synthetic */ void access$14(final SpdyConnection spdyConnection, final boolean shutdown) {
        spdyConnection.shutdown = shutdown;
    }
    
    static /* synthetic */ void access$7(final SpdyConnection spdyConnection, final int lastGoodStreamId) {
        spdyConnection.lastGoodStreamId = lastGoodStreamId;
    }
    
    private void close(final ErrorCode p0, final ErrorCode p1) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: getstatic       com/squareup/okhttp/internal/spdy/SpdyConnection.$assertionsDisabled:Z
        //     3: ifne            21
        //     6: aload_0        
        //     7: invokestatic    java/lang/Thread.holdsLock:(Ljava/lang/Object;)Z
        //    10: ifeq            21
        //    13: new             Ljava/lang/AssertionError;
        //    16: dup            
        //    17: invokespecial   java/lang/AssertionError.<init>:()V
        //    20: athrow         
        //    21: aconst_null    
        //    22: astore_3       
        //    23: aload_0        
        //    24: aload_1        
        //    25: invokevirtual   com/squareup/okhttp/internal/spdy/SpdyConnection.shutdown:(Lcom/squareup/okhttp/internal/spdy/ErrorCode;)V
        //    28: aload_0        
        //    29: monitorenter   
        //    30: aload_0        
        //    31: getfield        com/squareup/okhttp/internal/spdy/SpdyConnection.streams:Ljava/util/Map;
        //    34: invokeinterface java/util/Map.isEmpty:()Z
        //    39: istore          6
        //    41: aconst_null    
        //    42: astore          7
        //    44: iload           6
        //    46: ifne            94
        //    49: aload_0        
        //    50: getfield        com/squareup/okhttp/internal/spdy/SpdyConnection.streams:Ljava/util/Map;
        //    53: invokeinterface java/util/Map.values:()Ljava/util/Collection;
        //    58: aload_0        
        //    59: getfield        com/squareup/okhttp/internal/spdy/SpdyConnection.streams:Ljava/util/Map;
        //    62: invokeinterface java/util/Map.size:()I
        //    67: anewarray       Lcom/squareup/okhttp/internal/spdy/SpdyStream;
        //    70: invokeinterface java/util/Collection.toArray:([Ljava/lang/Object;)[Ljava/lang/Object;
        //    75: checkcast       [Lcom/squareup/okhttp/internal/spdy/SpdyStream;
        //    78: astore          7
        //    80: aload_0        
        //    81: getfield        com/squareup/okhttp/internal/spdy/SpdyConnection.streams:Ljava/util/Map;
        //    84: invokeinterface java/util/Map.clear:()V
        //    89: aload_0        
        //    90: iconst_0       
        //    91: invokespecial   com/squareup/okhttp/internal/spdy/SpdyConnection.setIdle:(Z)V
        //    94: aload_0        
        //    95: getfield        com/squareup/okhttp/internal/spdy/SpdyConnection.pings:Ljava/util/Map;
        //    98: astore          8
        //   100: aconst_null    
        //   101: astore          9
        //   103: aload           8
        //   105: ifnull          144
        //   108: aload_0        
        //   109: getfield        com/squareup/okhttp/internal/spdy/SpdyConnection.pings:Ljava/util/Map;
        //   112: invokeinterface java/util/Map.values:()Ljava/util/Collection;
        //   117: aload_0        
        //   118: getfield        com/squareup/okhttp/internal/spdy/SpdyConnection.pings:Ljava/util/Map;
        //   121: invokeinterface java/util/Map.size:()I
        //   126: anewarray       Lcom/squareup/okhttp/internal/spdy/Ping;
        //   129: invokeinterface java/util/Collection.toArray:([Ljava/lang/Object;)[Ljava/lang/Object;
        //   134: checkcast       [Lcom/squareup/okhttp/internal/spdy/Ping;
        //   137: astore          9
        //   139: aload_0        
        //   140: aconst_null    
        //   141: putfield        com/squareup/okhttp/internal/spdy/SpdyConnection.pings:Ljava/util/Map;
        //   144: aload_0        
        //   145: monitorexit    
        //   146: aload           7
        //   148: ifnull          166
        //   151: aload           7
        //   153: arraylength    
        //   154: istore          14
        //   156: iconst_0       
        //   157: istore          15
        //   159: iload           15
        //   161: iload           14
        //   163: if_icmplt       225
        //   166: aload           9
        //   168: ifnull          186
        //   171: aload           9
        //   173: arraylength    
        //   174: istore          12
        //   176: iconst_0       
        //   177: istore          13
        //   179: iload           13
        //   181: iload           12
        //   183: if_icmplt       256
        //   186: aload_0        
        //   187: getfield        com/squareup/okhttp/internal/spdy/SpdyConnection.frameReader:Lcom/squareup/okhttp/internal/spdy/FrameReader;
        //   190: invokeinterface com/squareup/okhttp/internal/spdy/FrameReader.close:()V
        //   195: aload_0        
        //   196: getfield        com/squareup/okhttp/internal/spdy/SpdyConnection.frameWriter:Lcom/squareup/okhttp/internal/spdy/FrameWriter;
        //   199: invokeinterface com/squareup/okhttp/internal/spdy/FrameWriter.close:()V
        //   204: aload_3        
        //   205: ifnull          290
        //   208: aload_3        
        //   209: athrow         
        //   210: astore          4
        //   212: aload           4
        //   214: astore_3       
        //   215: goto            28
        //   218: astore          5
        //   220: aload_0        
        //   221: monitorexit    
        //   222: aload           5
        //   224: athrow         
        //   225: aload           7
        //   227: iload           15
        //   229: aaload         
        //   230: astore          16
        //   232: aload           16
        //   234: aload_2        
        //   235: invokevirtual   com/squareup/okhttp/internal/spdy/SpdyStream.close:(Lcom/squareup/okhttp/internal/spdy/ErrorCode;)V
        //   238: iinc            15, 1
        //   241: goto            159
        //   244: astore          17
        //   246: aload_3        
        //   247: ifnull          238
        //   250: aload           17
        //   252: astore_3       
        //   253: goto            238
        //   256: aload           9
        //   258: iload           13
        //   260: aaload         
        //   261: invokevirtual   com/squareup/okhttp/internal/spdy/Ping.cancel:()V
        //   264: iinc            13, 1
        //   267: goto            179
        //   270: astore          10
        //   272: aload           10
        //   274: astore_3       
        //   275: goto            195
        //   278: astore          11
        //   280: aload_3        
        //   281: ifnonnull       204
        //   284: aload           11
        //   286: astore_3       
        //   287: goto            204
        //   290: return         
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  23     28     210    218    Ljava/io/IOException;
        //  30     41     218    225    Any
        //  49     94     218    225    Any
        //  94     100    218    225    Any
        //  108    144    218    225    Any
        //  144    146    218    225    Any
        //  186    195    270    278    Ljava/io/IOException;
        //  195    204    278    290    Ljava/io/IOException;
        //  220    222    218    225    Any
        //  232    238    244    256    Ljava/io/IOException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 133, Size: 133
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
        //     at java.util.ArrayList.get(ArrayList.java:411)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3305)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:114)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:314)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:235)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:120)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private SpdyStream getStream(final int i) {
        synchronized (this) {
            return this.streams.get(i);
        }
    }
    
    private Ping removePing(final int i) {
        synchronized (this) {
            Ping ping;
            if (this.pings != null) {
                ping = this.pings.remove(i);
            }
            else {
                ping = null;
            }
            return ping;
        }
    }
    
    private void setIdle(final boolean b) {
        // monitorenter(this)
        Label_0018: {
            if (!b) {
                break Label_0018;
            }
            try {
                long nanoTime = System.nanoTime();
                while (true) {
                    this.idleStartTimeNs = nanoTime;
                    return;
                    nanoTime = Long.MAX_VALUE;
                    continue;
                }
            }
            finally {
            }
            // monitorexit(this)
        }
    }
    
    private void writePing(final boolean b, final int n, final int n2, final Ping ping) throws IOException {
        final FrameWriter frameWriter = this.frameWriter;
        // monitorenter(frameWriter)
        Label_0019: {
            if (ping == null) {
                break Label_0019;
            }
            try {
                ping.send();
                this.frameWriter.ping(b, n, n2);
            }
            finally {
            }
            // monitorexit(frameWriter)
        }
    }
    
    private void writePingLater(final boolean b, final int i, final int j, final Ping ping) {
        SpdyConnection.executor.submit(new NamedRunnable("OkHttp SPDY Writer %s ping %08x%08x", new Object[] { this.hostName, i, j }) {
            public void execute() {
                try {
                    SpdyConnection.this.writePing(b, i, j, ping);
                }
                catch (IOException ex) {}
            }
        });
    }
    
    @Override
    public void close() throws IOException {
        this.close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }
    
    public void flush() throws IOException {
        this.frameWriter.flush();
    }
    
    public long getIdleStartTimeNs() {
        synchronized (this) {
            return this.idleStartTimeNs;
        }
    }
    
    public boolean isIdle() {
        synchronized (this) {
            return this.idleStartTimeNs != Long.MAX_VALUE;
        }
    }
    
    public SpdyStream newStream(final List<String> list, final boolean b, final boolean b2) throws IOException {
        // monitorexit(this)
        // monitorexit(frameWriter)
        while (true) {
            Label_0058: {
                if (!b) {
                    break Label_0058;
                }
                final boolean b3 = false;
                final boolean b4 = !b2;
                Label_0070: {
                    synchronized (this.frameWriter) {
                        synchronized (this) {
                            if (this.shutdown) {
                                throw new IOException("shutdown");
                            }
                            break Label_0070;
                        }
                    }
                    break Label_0058;
                }
                final int nextStreamId = this.nextStreamId;
                this.nextStreamId += 2;
                final SpdyStream spdyStream = new SpdyStream(nextStreamId, this, b3, b4, 0, list, this.settings);
                if (spdyStream.isOpen()) {
                    this.streams.put(nextStreamId, spdyStream);
                    this.setIdle(false);
                }
                this.frameWriter.synStream(b3, b4, nextStreamId, 0, 0, 0, list);
                return spdyStream;
            }
            final boolean b3 = true;
            continue;
        }
    }
    
    public void noop() throws IOException {
        this.frameWriter.noop();
    }
    
    public int openStreamCount() {
        synchronized (this) {
            return this.streams.size();
        }
    }
    
    public Ping ping() throws IOException {
        final Ping ping = new Ping();
        synchronized (this) {
            if (this.shutdown) {
                throw new IOException("shutdown");
            }
        }
        final int nextPingId = this.nextPingId;
        this.nextPingId += 2;
        if (this.pings == null) {
            this.pings = new HashMap<Integer, Ping>();
        }
        this.pings.put(nextPingId, ping);
        // monitorexit(this)
        this.writePing(false, nextPingId, 1330343787, ping);
        return ping;
    }
    
    public void readConnectionHeader() throws IOException {
        this.frameReader.readConnectionHeader();
    }
    
    SpdyStream removeStream(final int i) {
        synchronized (this) {
            final SpdyStream spdyStream = this.streams.remove(i);
            if (spdyStream != null && this.streams.isEmpty()) {
                this.setIdle(true);
            }
            return spdyStream;
        }
    }
    
    public void sendConnectionHeader() throws IOException {
        this.frameWriter.connectionHeader();
        this.frameWriter.settings(new Settings());
    }
    
    public void shutdown(final ErrorCode p0) throws IOException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: getfield        com/squareup/okhttp/internal/spdy/SpdyConnection.frameWriter:Lcom/squareup/okhttp/internal/spdy/FrameWriter;
        //     4: astore_2       
        //     5: aload_2        
        //     6: monitorenter   
        //     7: aload_0        
        //     8: monitorenter   
        //     9: aload_0        
        //    10: getfield        com/squareup/okhttp/internal/spdy/SpdyConnection.shutdown:Z
        //    13: ifeq            21
        //    16: aload_0        
        //    17: monitorexit    
        //    18: aload_2        
        //    19: monitorexit    
        //    20: return         
        //    21: aload_0        
        //    22: iconst_1       
        //    23: putfield        com/squareup/okhttp/internal/spdy/SpdyConnection.shutdown:Z
        //    26: aload_0        
        //    27: getfield        com/squareup/okhttp/internal/spdy/SpdyConnection.lastGoodStreamId:I
        //    30: istore          5
        //    32: aload_0        
        //    33: monitorexit    
        //    34: aload_0        
        //    35: getfield        com/squareup/okhttp/internal/spdy/SpdyConnection.frameWriter:Lcom/squareup/okhttp/internal/spdy/FrameWriter;
        //    38: iload           5
        //    40: aload_1        
        //    41: invokeinterface com/squareup/okhttp/internal/spdy/FrameWriter.goAway:(ILcom/squareup/okhttp/internal/spdy/ErrorCode;)V
        //    46: aload_2        
        //    47: monitorexit    
        //    48: return         
        //    49: astore_3       
        //    50: aload_2        
        //    51: monitorexit    
        //    52: aload_3        
        //    53: athrow         
        //    54: astore          4
        //    56: aload_0        
        //    57: monitorexit    
        //    58: aload           4
        //    60: athrow         
        //    Exceptions:
        //  throws java.io.IOException
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  7      9      49     54     Any
        //  9      18     54     61     Any
        //  18     20     49     54     Any
        //  21     34     54     61     Any
        //  34     48     49     54     Any
        //  50     52     49     54     Any
        //  56     58     54     61     Any
        //  58     61     49     54     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0021:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2592)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:314)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:235)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:120)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void writeData(final int n, final boolean b, final byte[] array, final int n2, final int n3) throws IOException {
        this.frameWriter.data(b, n, array, n2, n3);
    }
    
    void writeSynReply(final int n, final boolean b, final List<String> list) throws IOException {
        this.frameWriter.synReply(b, n, list);
    }
    
    void writeSynReset(final int n, final ErrorCode errorCode) throws IOException {
        this.frameWriter.rstStream(n, errorCode);
    }
    
    void writeSynResetLater(final int i, final ErrorCode errorCode) {
        SpdyConnection.executor.submit(new NamedRunnable("OkHttp SPDY Writer %s stream %d", new Object[] { this.hostName, i }) {
            public void execute() {
                try {
                    SpdyConnection.this.writeSynReset(i, errorCode);
                }
                catch (IOException ex) {}
            }
        });
    }
    
    void writeWindowUpdate(final int n, final int n2) throws IOException {
        this.frameWriter.windowUpdate(n, n2);
    }
    
    void writeWindowUpdateLater(final int i, final int n) {
        SpdyConnection.executor.submit(new NamedRunnable("OkHttp SPDY Writer %s stream %d", new Object[] { this.hostName, i }) {
            public void execute() {
                try {
                    SpdyConnection.this.writeWindowUpdate(i, n);
                }
                catch (IOException ex) {}
            }
        });
    }
    
    public static class Builder
    {
        private boolean client;
        private IncomingStreamHandler handler;
        private String hostName;
        private InputStream in;
        private OutputStream out;
        private Variant variant;
        
        public Builder(final String hostName, final boolean client, final InputStream in, final OutputStream out) {
            this.handler = IncomingStreamHandler.REFUSE_INCOMING_STREAMS;
            this.variant = Variant.SPDY3;
            this.hostName = hostName;
            this.client = client;
            this.in = in;
            this.out = out;
        }
        
        public Builder(final String s, final boolean b, final Socket socket) throws IOException {
            this(s, b, socket.getInputStream(), socket.getOutputStream());
        }
        
        public Builder(final boolean b, final InputStream inputStream, final OutputStream outputStream) {
            this("", b, inputStream, outputStream);
        }
        
        public Builder(final boolean b, final Socket socket) throws IOException {
            this("", b, socket.getInputStream(), socket.getOutputStream());
        }
        
        public SpdyConnection build() {
            return new SpdyConnection(this, null);
        }
        
        public Builder handler(final IncomingStreamHandler handler) {
            this.handler = handler;
            return this;
        }
        
        public Builder http20Draft06() {
            this.variant = Variant.HTTP_20_DRAFT_06;
            return this;
        }
        
        public Builder spdy3() {
            this.variant = Variant.SPDY3;
            return this;
        }
    }
    
    private class Reader implements Runnable, Handler
    {
        @Override
        public void data(final boolean b, final int n, final InputStream inputStream, final int n2) throws IOException {
            final SpdyStream access$3 = SpdyConnection.this.getStream(n);
            if (access$3 == null) {
                SpdyConnection.this.writeSynResetLater(n, ErrorCode.INVALID_STREAM);
                Util.skipByReading(inputStream, n2);
            }
            else {
                access$3.receiveData(inputStream, n2);
                if (b) {
                    access$3.receiveFin();
                }
            }
        }
        
        @Override
        public void goAway(final int n, final ErrorCode errorCode) {
            synchronized (SpdyConnection.this) {
                SpdyConnection.access$14(SpdyConnection.this, true);
                final Iterator<Map.Entry<Integer, V>> iterator = SpdyConnection.this.streams.entrySet().iterator();
                while (iterator.hasNext()) {
                    final Map.Entry<Integer, V> entry = iterator.next();
                    if (entry.getKey() > n && ((SpdyStream)entry.getValue()).isLocallyInitiated()) {
                        ((SpdyStream)entry.getValue()).receiveRstStream(ErrorCode.REFUSED_STREAM);
                        iterator.remove();
                    }
                }
            }
        }
        
        @Override
        public void headers(final boolean b, final boolean b2, final int n, final int n2, final int n3, final List<String> list, final HeadersMode headersMode) {
            // monitorexit(spdyConnection)
            final SpdyStream access$3;
            Label_0213: {
                synchronized (SpdyConnection.this) {
                    if (SpdyConnection.this.shutdown) {
                        return;
                    }
                    access$3 = SpdyConnection.this.getStream(n);
                    if (access$3 != null) {
                        break Label_0213;
                    }
                    if (headersMode.failIfStreamAbsent()) {
                        SpdyConnection.this.writeSynResetLater(n, ErrorCode.INVALID_STREAM);
                        return;
                    }
                }
                if (n <= SpdyConnection.this.lastGoodStreamId) {
                    // monitorexit(spdyConnection)
                    return;
                }
                if (n % 2 == SpdyConnection.this.nextStreamId % 2) {
                    // monitorexit(spdyConnection)
                    return;
                }
                final SpdyStream spdyStream = new SpdyStream(n, SpdyConnection.this, b, b2, n3, list, SpdyConnection.this.settings);
                SpdyConnection.access$7(SpdyConnection.this, n);
                SpdyConnection.this.streams.put(n, spdyStream);
                SpdyConnection.executor.submit(new NamedRunnable("OkHttp Callback %s stream %d", new Object[] { SpdyConnection.this.hostName, n }) {
                    public void execute() {
                        try {
                            SpdyConnection.this.handler.receive(spdyStream);
                        }
                        catch (IOException cause) {
                            throw new RuntimeException(cause);
                        }
                    }
                });
                return;
            }
            // monitorexit(spdyConnection)
            if (headersMode.failIfStreamPresent()) {
                access$3.closeLater(ErrorCode.PROTOCOL_ERROR);
                SpdyConnection.this.removeStream(n);
                return;
            }
            access$3.receiveHeaders(list, headersMode);
            if (b2) {
                access$3.receiveFin();
            }
        }
        
        @Override
        public void noop() {
        }
        
        @Override
        public void ping(final boolean b, final int n, final int n2) {
            if (b) {
                final Ping access$12 = SpdyConnection.this.removePing(n);
                if (access$12 != null) {
                    access$12.receive();
                }
                return;
            }
            SpdyConnection.this.writePingLater(true, n, n2, null);
        }
        
        @Override
        public void priority(final int n, final int n2) {
        }
        
        @Override
        public void rstStream(final int n, final ErrorCode errorCode) {
            final SpdyStream removeStream = SpdyConnection.this.removeStream(n);
            if (removeStream != null) {
                removeStream.receiveRstStream(errorCode);
            }
        }
        
        @Override
        public void run() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     0: getstatic       com/squareup/okhttp/internal/spdy/ErrorCode.INTERNAL_ERROR:Lcom/squareup/okhttp/internal/spdy/ErrorCode;
            //     3: astore_1       
            //     4: getstatic       com/squareup/okhttp/internal/spdy/ErrorCode.INTERNAL_ERROR:Lcom/squareup/okhttp/internal/spdy/ErrorCode;
            //     7: astore_2       
            //     8: aload_0        
            //     9: getfield        com/squareup/okhttp/internal/spdy/SpdyConnection$Reader.this$0:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;
            //    12: invokestatic    com/squareup/okhttp/internal/spdy/SpdyConnection.access$2:(Lcom/squareup/okhttp/internal/spdy/SpdyConnection;)Lcom/squareup/okhttp/internal/spdy/FrameReader;
            //    15: aload_0        
            //    16: invokeinterface com/squareup/okhttp/internal/spdy/FrameReader.nextFrame:(Lcom/squareup/okhttp/internal/spdy/FrameReader$Handler;)Z
            //    21: ifne            8
            //    24: getstatic       com/squareup/okhttp/internal/spdy/ErrorCode.NO_ERROR:Lcom/squareup/okhttp/internal/spdy/ErrorCode;
            //    27: astore_1       
            //    28: getstatic       com/squareup/okhttp/internal/spdy/ErrorCode.CANCEL:Lcom/squareup/okhttp/internal/spdy/ErrorCode;
            //    31: astore          8
            //    33: aload_0        
            //    34: getfield        com/squareup/okhttp/internal/spdy/SpdyConnection$Reader.this$0:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;
            //    37: aload_1        
            //    38: aload           8
            //    40: invokestatic    com/squareup/okhttp/internal/spdy/SpdyConnection.access$1:(Lcom/squareup/okhttp/internal/spdy/SpdyConnection;Lcom/squareup/okhttp/internal/spdy/ErrorCode;Lcom/squareup/okhttp/internal/spdy/ErrorCode;)V
            //    43: return         
            //    44: astore          5
            //    46: getstatic       com/squareup/okhttp/internal/spdy/ErrorCode.PROTOCOL_ERROR:Lcom/squareup/okhttp/internal/spdy/ErrorCode;
            //    49: astore_1       
            //    50: getstatic       com/squareup/okhttp/internal/spdy/ErrorCode.PROTOCOL_ERROR:Lcom/squareup/okhttp/internal/spdy/ErrorCode;
            //    53: astore          6
            //    55: aload_0        
            //    56: getfield        com/squareup/okhttp/internal/spdy/SpdyConnection$Reader.this$0:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;
            //    59: aload_1        
            //    60: aload           6
            //    62: invokestatic    com/squareup/okhttp/internal/spdy/SpdyConnection.access$1:(Lcom/squareup/okhttp/internal/spdy/SpdyConnection;Lcom/squareup/okhttp/internal/spdy/ErrorCode;Lcom/squareup/okhttp/internal/spdy/ErrorCode;)V
            //    65: return         
            //    66: astore          7
            //    68: return         
            //    69: astore_3       
            //    70: aload_0        
            //    71: getfield        com/squareup/okhttp/internal/spdy/SpdyConnection$Reader.this$0:Lcom/squareup/okhttp/internal/spdy/SpdyConnection;
            //    74: aload_1        
            //    75: aload_2        
            //    76: invokestatic    com/squareup/okhttp/internal/spdy/SpdyConnection.access$1:(Lcom/squareup/okhttp/internal/spdy/SpdyConnection;Lcom/squareup/okhttp/internal/spdy/ErrorCode;Lcom/squareup/okhttp/internal/spdy/ErrorCode;)V
            //    79: aload_3        
            //    80: athrow         
            //    81: astore          9
            //    83: return         
            //    84: astore          4
            //    86: goto            79
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                 
            //  -----  -----  -----  -----  ---------------------
            //  8      33     44     69     Ljava/io/IOException;
            //  8      33     69     81     Any
            //  33     43     81     84     Ljava/io/IOException;
            //  46     55     69     81     Any
            //  55     65     66     69     Ljava/io/IOException;
            //  70     79     84     89     Ljava/io/IOException;
            // 
            // The error that occurred was:
            // 
            // java.lang.IndexOutOfBoundsException: Index: 45, Size: 45
            //     at java.util.ArrayList.rangeCheck(ArrayList.java:635)
            //     at java.util.ArrayList.get(ArrayList.java:411)
            //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3305)
            //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:114)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:556)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
            //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
            //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:314)
            //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:235)
            //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:120)
            // 
            throw new IllegalStateException("An error occurred while decompiling this method.");
        }
        
        @Override
        public void settings(final boolean b, final Settings settings) {
            while (true) {
                SpdyStream[] array = null;
                int n = 0;
                Label_0132: {
                    synchronized (SpdyConnection.this) {
                        if (SpdyConnection.this.settings == null || b) {
                            SpdyConnection.this.settings = settings;
                        }
                        else {
                            SpdyConnection.this.settings.merge(settings);
                        }
                        final boolean empty = SpdyConnection.this.streams.isEmpty();
                        array = null;
                        if (!empty) {
                            array = (SpdyStream[])SpdyConnection.this.streams.values().toArray(new SpdyStream[SpdyConnection.this.streams.size()]);
                        }
                        // monitorexit(this.this$0)
                        if (array != null) {
                            final int length = array.length;
                            n = 0;
                            if (n < length) {
                                break Label_0132;
                            }
                        }
                        return;
                    }
                }
                final SpdyStream spdyStream = array[n];
                synchronized (spdyStream) {
                    synchronized (SpdyConnection.this) {
                        spdyStream.receiveSettings(SpdyConnection.this.settings);
                        // monitorexit(this.this$0)
                        // monitorexit(spdyStream)
                        ++n;
                    }
                }
            }
        }
        
        @Override
        public void windowUpdate(final int n, final int n2, final boolean b) {
            if (n != 0) {
                final SpdyStream access$3 = SpdyConnection.this.getStream(n);
                if (access$3 != null) {
                    access$3.receiveWindowUpdate(n2);
                }
            }
        }
    }
}

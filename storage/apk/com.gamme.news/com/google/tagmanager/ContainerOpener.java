// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.util.concurrent.Semaphore;
import java.util.TimerTask;
import java.util.Timer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainerOpener
{
    public static final long DEFAULT_TIMEOUT_IN_MILLIS = 2000L;
    private static final Map<String, List<Notifier>> mContainerIdNotifiersMap;
    private Clock mClock;
    private volatile Container mContainer;
    private final String mContainerId;
    private boolean mHaveNotified;
    private Notifier mNotifier;
    private final TagManager mTagManager;
    private final long mTimeoutInMillis;
    
    static {
        mContainerIdNotifiersMap = new HashMap<String, List<Notifier>>();
    }
    
    private ContainerOpener(final TagManager mTagManager, final String mContainerId, final Long n, final Notifier mNotifier) {
        this.mClock = new Clock() {
            @Override
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        };
        this.mTagManager = mTagManager;
        this.mContainerId = mContainerId;
        long max;
        if (n != null) {
            max = Math.max(1L, n);
        }
        else {
            max = 2000L;
        }
        this.mTimeoutInMillis = max;
        this.mNotifier = mNotifier;
    }
    
    private void callNotifiers(final Container p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     0: aload_0        
        //     1: monitorenter   
        //     2: aload_0        
        //     3: getfield        com/google/tagmanager/ContainerOpener.mHaveNotified:Z
        //     6: ifne            91
        //     9: ldc             Lcom/google/tagmanager/ContainerOpener;.class
        //    11: monitorenter   
        //    12: getstatic       com/google/tagmanager/ContainerOpener.mContainerIdNotifiersMap:Ljava/util/Map;
        //    15: aload_0        
        //    16: getfield        com/google/tagmanager/ContainerOpener.mContainerId:Ljava/lang/String;
        //    19: invokeinterface java/util/Map.remove:(Ljava/lang/Object;)Ljava/lang/Object;
        //    24: checkcast       Ljava/util/List;
        //    27: astore          4
        //    29: ldc             Lcom/google/tagmanager/ContainerOpener;.class
        //    31: monitorexit    
        //    32: aload           4
        //    34: ifnull          86
        //    37: aload           4
        //    39: invokeinterface java/util/List.iterator:()Ljava/util/Iterator;
        //    44: astore          5
        //    46: aload           5
        //    48: invokeinterface java/util/Iterator.hasNext:()Z
        //    53: ifeq            86
        //    56: aload           5
        //    58: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    63: checkcast       Lcom/google/tagmanager/ContainerOpener$Notifier;
        //    66: aload_1        
        //    67: invokeinterface com/google/tagmanager/ContainerOpener$Notifier.containerAvailable:(Lcom/google/tagmanager/Container;)V
        //    72: goto            46
        //    75: astore_2       
        //    76: aload_0        
        //    77: monitorexit    
        //    78: aload_2        
        //    79: athrow         
        //    80: astore_3       
        //    81: ldc             Lcom/google/tagmanager/ContainerOpener;.class
        //    83: monitorexit    
        //    84: aload_3        
        //    85: athrow         
        //    86: aload_0        
        //    87: iconst_1       
        //    88: putfield        com/google/tagmanager/ContainerOpener.mHaveNotified:Z
        //    91: aload_0        
        //    92: monitorexit    
        //    93: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  2      12     75     80     Any
        //  12     32     80     86     Any
        //  37     46     75     80     Any
        //  46     72     75     80     Any
        //  81     84     80     86     Any
        //  84     86     75     80     Any
        //  86     91     75     80     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0046:
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
    
    private void open(final Container.RefreshType refreshType) {
        while (true) {
            final long currentTimeMillis = this.mClock.currentTimeMillis();
            int n = 0;
            // monitorexit(ContainerOpener.class)
            Label_0223: {
                List<Notifier> list2;
                while (true) {
                    synchronized (ContainerOpener.class) {
                        this.mContainer = this.mTagManager.getContainer(this.mContainerId);
                        if (this.mContainer == null) {
                            final ArrayList<Notifier> list = new ArrayList<Notifier>();
                            list.add(this.mNotifier);
                            this.mNotifier = null;
                            ContainerOpener.mContainerIdNotifiersMap.put(this.mContainerId, list);
                            final TagManager mTagManager = this.mTagManager;
                            final String mContainerId = this.mContainerId;
                            Container.Callback callback;
                            if (refreshType == Container.RefreshType.SAVED) {
                                callback = new WaitForNonDefaultRefresh();
                            }
                            else {
                                callback = new WaitForFresh(currentTimeMillis - 43200000L);
                            }
                            this.mContainer = mTagManager.openContainer(mContainerId, callback);
                            // monitorexit(ContainerOpener.class)
                            if (n != 0) {
                                this.mNotifier.containerAvailable(this.mContainer);
                                this.mNotifier = null;
                                return;
                            }
                            break Label_0223;
                        }
                    }
                    list2 = ContainerOpener.mContainerIdNotifiersMap.get(this.mContainerId);
                    if (list2 == null) {
                        n = 1;
                        continue;
                    }
                    break;
                }
                list2.add(this.mNotifier);
                this.mNotifier = null;
                return;
            }
            this.setTimer(Math.max(1L, this.mTimeoutInMillis - (this.mClock.currentTimeMillis() - currentTimeMillis)));
        }
    }
    
    public static ContainerFuture openContainer(final TagManager tagManager, final String s, final OpenType openType, final Long n) {
        final ContainerFutureImpl containerFutureImpl = new ContainerFutureImpl();
        openContainer(tagManager, s, openType, n, (Notifier)new Notifier() {
            @Override
            public void containerAvailable(final Container container) {
                containerFutureImpl.setContainer(container);
            }
        });
        return (ContainerFuture)containerFutureImpl;
    }
    
    public static void openContainer(final TagManager tagManager, final String s, final OpenType openType, final Long n, final Notifier notifier) {
        if (tagManager == null) {
            throw new NullPointerException("TagManager cannot be null.");
        }
        if (s == null) {
            throw new NullPointerException("ContainerId cannot be null.");
        }
        if (openType == null) {
            throw new NullPointerException("OpenType cannot be null.");
        }
        if (notifier == null) {
            throw new NullPointerException("Notifier cannot be null.");
        }
        final ContainerOpener containerOpener = new ContainerOpener(tagManager, s, n, notifier);
        Container.RefreshType refreshType;
        if (openType == OpenType.PREFER_FRESH) {
            refreshType = Container.RefreshType.NETWORK;
        }
        else {
            refreshType = Container.RefreshType.SAVED;
        }
        containerOpener.open(refreshType);
    }
    
    private void setTimer(final long delay) {
        new Timer("ContainerOpener").schedule(new TimerTask() {
            @Override
            public void run() {
                Log.i("Timer expired.");
                ContainerOpener.this.callNotifiers(ContainerOpener.this.mContainer);
            }
        }, delay);
    }
    
    public interface ContainerFuture
    {
        Container get();
        
        boolean isDone();
    }
    
    private static class ContainerFutureImpl implements ContainerFuture
    {
        private volatile Container mContainer;
        private Semaphore mContainerIsReady;
        private volatile boolean mHaveGotten;
        
        private ContainerFutureImpl() {
            this.mContainerIsReady = new Semaphore(0);
        }
        
        @Override
        public Container get() {
            if (this.mHaveGotten) {
                return this.mContainer;
            }
            while (true) {
                try {
                    this.mContainerIsReady.acquire();
                    this.mHaveGotten = true;
                    return this.mContainer;
                }
                catch (InterruptedException ex) {
                    continue;
                }
                break;
            }
        }
        
        @Override
        public boolean isDone() {
            return this.mHaveGotten || this.mContainerIsReady.availablePermits() > 0;
        }
        
        public void setContainer(final Container mContainer) {
            this.mContainer = mContainer;
            this.mContainerIsReady.release();
        }
    }
    
    public interface Notifier
    {
        void containerAvailable(Container p0);
    }
    
    public enum OpenType
    {
        PREFER_FRESH, 
        PREFER_NON_DEFAULT;
    }
    
    private class WaitForFresh implements Callback
    {
        private final long mOldestTimeToBeFresh;
        
        public WaitForFresh(final long mOldestTimeToBeFresh) {
            this.mOldestTimeToBeFresh = mOldestTimeToBeFresh;
        }
        
        private boolean isFresh() {
            return this.mOldestTimeToBeFresh < ContainerOpener.this.mContainer.getLastRefreshTime();
        }
        
        @Override
        public void containerRefreshBegin(final Container container, final RefreshType refreshType) {
        }
        
        @Override
        public void containerRefreshFailure(final Container container, final RefreshType refreshType, final RefreshFailure refreshFailure) {
            if (refreshType == RefreshType.NETWORK) {
                ContainerOpener.this.callNotifiers(container);
            }
        }
        
        @Override
        public void containerRefreshSuccess(final Container container, final RefreshType refreshType) {
            if (refreshType == RefreshType.NETWORK || this.isFresh()) {
                ContainerOpener.this.callNotifiers(container);
            }
        }
    }
    
    private class WaitForNonDefaultRefresh implements Callback
    {
        @Override
        public void containerRefreshBegin(final Container container, final RefreshType refreshType) {
        }
        
        @Override
        public void containerRefreshFailure(final Container container, final RefreshType refreshType, final RefreshFailure refreshFailure) {
            if (refreshType == RefreshType.NETWORK) {
                ContainerOpener.this.callNotifiers(container);
            }
        }
        
        @Override
        public void containerRefreshSuccess(final Container container, final RefreshType refreshType) {
            ContainerOpener.this.callNotifiers(container);
        }
    }
}

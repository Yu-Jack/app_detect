// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.support.v4.c.c;
import android.support.v4.a.l;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.util.Log;
import android.os.Bundle;
import android.support.v4.c.m;

class LoaderManagerImpl extends LoaderManager
{
    static boolean DEBUG = false;
    static final String TAG = "LoaderManager";
    FragmentActivity mActivity;
    boolean mCreatingLoader;
    final m<LoaderManagerImpl$LoaderInfo> mInactiveLoaders;
    final m<LoaderManagerImpl$LoaderInfo> mLoaders;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    final String mWho;
    
    static {
        LoaderManagerImpl.DEBUG = false;
    }
    
    LoaderManagerImpl(final String mWho, final FragmentActivity mActivity, final boolean mStarted) {
        this.mLoaders = new m<LoaderManagerImpl$LoaderInfo>();
        this.mInactiveLoaders = new m<LoaderManagerImpl$LoaderInfo>();
        this.mWho = mWho;
        this.mActivity = mActivity;
        this.mStarted = mStarted;
    }
    
    private LoaderManagerImpl$LoaderInfo createAndInstallLoader(final int n, final Bundle bundle, final LoaderManager$LoaderCallbacks<Object> loaderManager$LoaderCallbacks) {
        try {
            this.mCreatingLoader = true;
            final LoaderManagerImpl$LoaderInfo loader = this.createLoader(n, bundle, loaderManager$LoaderCallbacks);
            this.installLoader(loader);
            return loader;
        }
        finally {
            this.mCreatingLoader = false;
        }
    }
    
    private LoaderManagerImpl$LoaderInfo createLoader(final int n, final Bundle bundle, final LoaderManager$LoaderCallbacks<Object> loaderManager$LoaderCallbacks) {
        final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = new LoaderManagerImpl$LoaderInfo(n, bundle, loaderManager$LoaderCallbacks);
        loaderManagerImpl$LoaderInfo.mLoader = loaderManager$LoaderCallbacks.onCreateLoader(n, bundle);
        return loaderManagerImpl$LoaderInfo;
    }
    
    @Override
    public void destroyLoader(final int i) {
        if (this.mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "destroyLoader in " + this + " of " + i);
        }
        final int g = this.mLoaders.g(i);
        if (g >= 0) {
            final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = this.mLoaders.f(g);
            this.mLoaders.d(g);
            loaderManagerImpl$LoaderInfo.destroy();
        }
        final int g2 = this.mInactiveLoaders.g(i);
        if (g2 >= 0) {
            final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo2 = this.mInactiveLoaders.f(g2);
            this.mInactiveLoaders.d(g2);
            loaderManagerImpl$LoaderInfo2.destroy();
        }
        if (this.mActivity != null && !this.hasRunningLoaders()) {
            this.mActivity.mFragments.startPendingDeferredFragments();
        }
    }
    
    void doDestroy() {
        if (!this.mRetaining) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (int i = -1 + this.mLoaders.b(); i >= 0; --i) {
                this.mLoaders.f(i).destroy();
            }
            this.mLoaders.c();
        }
        if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (int j = -1 + this.mInactiveLoaders.b(); j >= 0; --j) {
            this.mInactiveLoaders.f(j).destroy();
        }
        this.mInactiveLoaders.c();
    }
    
    void doReportNextStart() {
        for (int i = -1 + this.mLoaders.b(); i >= 0; --i) {
            this.mLoaders.f(i).mReportNextStart = true;
        }
    }
    
    void doReportStart() {
        for (int i = -1 + this.mLoaders.b(); i >= 0; --i) {
            this.mLoaders.f(i).reportStart();
        }
    }
    
    void doRetain() {
        if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (!this.mStarted) {
            final RuntimeException ex = new RuntimeException("here");
            ex.fillInStackTrace();
            Log.w("LoaderManager", "Called doRetain when not started: " + this, (Throwable)ex);
        }
        else {
            this.mRetaining = true;
            this.mStarted = false;
            for (int i = -1 + this.mLoaders.b(); i >= 0; --i) {
                this.mLoaders.f(i).retain();
            }
        }
    }
    
    void doStart() {
        if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.mStarted) {
            final RuntimeException ex = new RuntimeException("here");
            ex.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, (Throwable)ex);
        }
        else {
            this.mStarted = true;
            for (int i = -1 + this.mLoaders.b(); i >= 0; --i) {
                this.mLoaders.f(i).start();
            }
        }
    }
    
    void doStop() {
        if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (!this.mStarted) {
            final RuntimeException ex = new RuntimeException("here");
            ex.fillInStackTrace();
            Log.w("LoaderManager", "Called doStop when not started: " + this, (Throwable)ex);
            return;
        }
        for (int i = -1 + this.mLoaders.b(); i >= 0; --i) {
            this.mLoaders.f(i).stop();
        }
        this.mStarted = false;
    }
    
    @Override
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        int i = 0;
        if (this.mLoaders.b() > 0) {
            printWriter.print(s);
            printWriter.println("Active Loaders:");
            final String string = s + "    ";
            for (int j = 0; j < this.mLoaders.b(); ++j) {
                final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = this.mLoaders.f(j);
                printWriter.print(s);
                printWriter.print("  #");
                printWriter.print(this.mLoaders.e(j));
                printWriter.print(": ");
                printWriter.println(loaderManagerImpl$LoaderInfo.toString());
                loaderManagerImpl$LoaderInfo.dump(string, fileDescriptor, printWriter, array);
            }
        }
        if (this.mInactiveLoaders.b() > 0) {
            printWriter.print(s);
            printWriter.println("Inactive Loaders:");
            final String string2 = s + "    ";
            while (i < this.mInactiveLoaders.b()) {
                final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo2 = this.mInactiveLoaders.f(i);
                printWriter.print(s);
                printWriter.print("  #");
                printWriter.print(this.mInactiveLoaders.e(i));
                printWriter.print(": ");
                printWriter.println(loaderManagerImpl$LoaderInfo2.toString());
                loaderManagerImpl$LoaderInfo2.dump(string2, fileDescriptor, printWriter, array);
                ++i;
            }
        }
    }
    
    void finishRetain() {
        if (this.mRetaining) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.mRetaining = false;
            for (int i = -1 + this.mLoaders.b(); i >= 0; --i) {
                this.mLoaders.f(i).finishRetain();
            }
        }
    }
    
    @Override
    public <D> l<D> getLoader(final int n) {
        if (this.mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }
        final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = this.mLoaders.a(n);
        if (loaderManagerImpl$LoaderInfo == null) {
            return null;
        }
        if (loaderManagerImpl$LoaderInfo.mPendingLoader != null) {
            return (l<D>)loaderManagerImpl$LoaderInfo.mPendingLoader.mLoader;
        }
        return (l<D>)loaderManagerImpl$LoaderInfo.mLoader;
    }
    
    @Override
    public boolean hasRunningLoaders() {
        final int b = this.mLoaders.b();
        int i = 0;
        boolean b2 = false;
        while (i < b) {
            final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = this.mLoaders.f(i);
            b2 |= (loaderManagerImpl$LoaderInfo.mStarted && !loaderManagerImpl$LoaderInfo.mDeliveredData);
            ++i;
        }
        return b2;
    }
    
    @Override
    public <D> l<D> initLoader(final int n, final Bundle obj, final LoaderManager$LoaderCallbacks<D> mCallbacks) {
        if (this.mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }
        LoaderManagerImpl$LoaderInfo andInstallLoader = this.mLoaders.a(n);
        if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "initLoader in " + this + ": args=" + obj);
        }
        if (andInstallLoader == null) {
            andInstallLoader = this.createAndInstallLoader(n, obj, (LoaderManager$LoaderCallbacks<Object>)mCallbacks);
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Created new loader " + andInstallLoader);
            }
        }
        else {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Re-using existing loader " + andInstallLoader);
            }
            andInstallLoader.mCallbacks = (LoaderManager$LoaderCallbacks<Object>)mCallbacks;
        }
        if (andInstallLoader.mHaveData && this.mStarted) {
            andInstallLoader.callOnLoadFinished(andInstallLoader.mLoader, andInstallLoader.mData);
        }
        return (l<D>)andInstallLoader.mLoader;
    }
    
    void installLoader(final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo) {
        this.mLoaders.b(loaderManagerImpl$LoaderInfo.mId, loaderManagerImpl$LoaderInfo);
        if (this.mStarted) {
            loaderManagerImpl$LoaderInfo.start();
        }
    }
    
    @Override
    public <D> l<D> restartLoader(final int n, final Bundle obj, final LoaderManager$LoaderCallbacks<D> loaderManager$LoaderCallbacks) {
        if (this.mCreatingLoader) {
            throw new IllegalStateException("Called while creating a loader");
        }
        final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = this.mLoaders.a(n);
        if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "restartLoader in " + this + ": args=" + obj);
        }
        if (loaderManagerImpl$LoaderInfo != null) {
            final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo2 = this.mInactiveLoaders.a(n);
            if (loaderManagerImpl$LoaderInfo2 != null) {
                if (loaderManagerImpl$LoaderInfo.mHaveData) {
                    if (LoaderManagerImpl.DEBUG) {
                        Log.v("LoaderManager", "  Removing last inactive loader: " + loaderManagerImpl$LoaderInfo);
                    }
                    loaderManagerImpl$LoaderInfo2.mDeliveredData = false;
                    loaderManagerImpl$LoaderInfo2.destroy();
                    loaderManagerImpl$LoaderInfo.mLoader.e();
                    this.mInactiveLoaders.b(n, loaderManagerImpl$LoaderInfo);
                }
                else {
                    if (loaderManagerImpl$LoaderInfo.mStarted) {
                        if (loaderManagerImpl$LoaderInfo.mPendingLoader != null) {
                            if (LoaderManagerImpl.DEBUG) {
                                Log.v("LoaderManager", "  Removing pending loader: " + loaderManagerImpl$LoaderInfo.mPendingLoader);
                            }
                            loaderManagerImpl$LoaderInfo.mPendingLoader.destroy();
                            loaderManagerImpl$LoaderInfo.mPendingLoader = null;
                        }
                        if (LoaderManagerImpl.DEBUG) {
                            Log.v("LoaderManager", "  Enqueuing as new pending loader");
                        }
                        loaderManagerImpl$LoaderInfo.mPendingLoader = this.createLoader(n, obj, (LoaderManager$LoaderCallbacks<Object>)loaderManager$LoaderCallbacks);
                        return (l<D>)loaderManagerImpl$LoaderInfo.mPendingLoader.mLoader;
                    }
                    if (LoaderManagerImpl.DEBUG) {
                        Log.v("LoaderManager", "  Current loader is stopped; replacing");
                    }
                    this.mLoaders.b(n, null);
                    loaderManagerImpl$LoaderInfo.destroy();
                }
            }
            else {
                if (LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Making last loader inactive: " + loaderManagerImpl$LoaderInfo);
                }
                loaderManagerImpl$LoaderInfo.mLoader.e();
                this.mInactiveLoaders.b(n, loaderManagerImpl$LoaderInfo);
            }
        }
        return (l<D>)this.createAndInstallLoader(n, obj, (LoaderManager$LoaderCallbacks<Object>)loaderManager$LoaderCallbacks).mLoader;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        c.a(this.mActivity, sb);
        sb.append("}}");
        return sb.toString();
    }
    
    void updateActivity(final FragmentActivity mActivity) {
        this.mActivity = mActivity;
    }
}

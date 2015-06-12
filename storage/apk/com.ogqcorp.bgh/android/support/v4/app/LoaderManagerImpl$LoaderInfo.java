// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.support.v4.c.c;
import java.lang.reflect.Modifier;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.util.Log;
import android.support.v4.a.l;
import android.os.Bundle;
import android.support.v4.a.m;

final class LoaderManagerImpl$LoaderInfo implements m<Object>
{
    final Bundle mArgs;
    LoaderManager$LoaderCallbacks<Object> mCallbacks;
    Object mData;
    boolean mDeliveredData;
    boolean mDestroyed;
    boolean mHaveData;
    final int mId;
    boolean mListenerRegistered;
    l<Object> mLoader;
    LoaderManagerImpl$LoaderInfo mPendingLoader;
    boolean mReportNextStart;
    boolean mRetaining;
    boolean mRetainingStarted;
    boolean mStarted;
    final /* synthetic */ LoaderManagerImpl this$0;
    
    public LoaderManagerImpl$LoaderInfo(final LoaderManagerImpl this$0, final int mId, final Bundle mArgs, final LoaderManager$LoaderCallbacks<Object> mCallbacks) {
        this.this$0 = this$0;
        this.mId = mId;
        this.mArgs = mArgs;
        this.mCallbacks = mCallbacks;
    }
    
    void callOnLoadFinished(final l<Object> obj, final Object o) {
        if (this.mCallbacks == null) {
            return;
        }
        while (true) {
            Label_0164: {
                if (this.this$0.mActivity == null) {
                    break Label_0164;
                }
                final String mNoTransactionsBecause = this.this$0.mActivity.mFragments.mNoTransactionsBecause;
                this.this$0.mActivity.mFragments.mNoTransactionsBecause = "onLoadFinished";
                final String s = mNoTransactionsBecause;
                try {
                    if (LoaderManagerImpl.DEBUG) {
                        Log.v("LoaderManager", "  onLoadFinished in " + obj + ": " + obj.a(o));
                    }
                    this.mCallbacks.onLoadFinished(obj, o);
                    if (this.this$0.mActivity != null) {
                        this.this$0.mActivity.mFragments.mNoTransactionsBecause = s;
                    }
                    this.mDeliveredData = true;
                    return;
                }
                finally {
                    if (this.this$0.mActivity != null) {
                        this.this$0.mActivity.mFragments.mNoTransactionsBecause = s;
                    }
                }
            }
            final String s = null;
            continue;
        }
    }
    
    void destroy() {
        if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Destroying: " + this);
        }
        this.mDestroyed = true;
        final boolean mDeliveredData = this.mDeliveredData;
        this.mDeliveredData = false;
        while (true) {
            Label_0182: {
                if (this.mCallbacks == null || this.mLoader == null || !this.mHaveData || !mDeliveredData) {
                    break Label_0182;
                }
                if (LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.this$0.mActivity == null) {
                    break Label_0182;
                }
                final String mNoTransactionsBecause = this.this$0.mActivity.mFragments.mNoTransactionsBecause;
                this.this$0.mActivity.mFragments.mNoTransactionsBecause = "onLoaderReset";
                final String s = mNoTransactionsBecause;
                try {
                    this.mCallbacks.onLoaderReset(this.mLoader);
                    if (this.this$0.mActivity != null) {
                        this.this$0.mActivity.mFragments.mNoTransactionsBecause = s;
                    }
                    this.mCallbacks = null;
                    this.mData = null;
                    this.mHaveData = false;
                    if (this.mLoader != null) {
                        if (this.mListenerRegistered) {
                            this.mListenerRegistered = false;
                            this.mLoader.a(this);
                        }
                        this.mLoader.g();
                    }
                    if (this.mPendingLoader != null) {
                        this.mPendingLoader.destroy();
                    }
                    return;
                }
                finally {
                    if (this.this$0.mActivity != null) {
                        this.this$0.mActivity.mFragments.mNoTransactionsBecause = s;
                    }
                }
            }
            final String s = null;
            continue;
        }
    }
    
    public void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        printWriter.print(s);
        printWriter.print("mId=");
        printWriter.print(this.mId);
        printWriter.print(" mArgs=");
        printWriter.println(this.mArgs);
        printWriter.print(s);
        printWriter.print("mCallbacks=");
        printWriter.println(this.mCallbacks);
        printWriter.print(s);
        printWriter.print("mLoader=");
        printWriter.println(this.mLoader);
        if (this.mLoader != null) {
            this.mLoader.a(s + "  ", fileDescriptor, printWriter, array);
        }
        if (this.mHaveData || this.mDeliveredData) {
            printWriter.print(s);
            printWriter.print("mHaveData=");
            printWriter.print(this.mHaveData);
            printWriter.print("  mDeliveredData=");
            printWriter.println(this.mDeliveredData);
            printWriter.print(s);
            printWriter.print("mData=");
            printWriter.println(this.mData);
        }
        printWriter.print(s);
        printWriter.print("mStarted=");
        printWriter.print(this.mStarted);
        printWriter.print(" mReportNextStart=");
        printWriter.print(this.mReportNextStart);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.mDestroyed);
        printWriter.print(s);
        printWriter.print("mRetaining=");
        printWriter.print(this.mRetaining);
        printWriter.print(" mRetainingStarted=");
        printWriter.print(this.mRetainingStarted);
        printWriter.print(" mListenerRegistered=");
        printWriter.println(this.mListenerRegistered);
        if (this.mPendingLoader != null) {
            printWriter.print(s);
            printWriter.println("Pending Loader ");
            printWriter.print(this.mPendingLoader);
            printWriter.println(":");
            this.mPendingLoader.dump(s + "  ", fileDescriptor, printWriter, array);
        }
    }
    
    void finishRetain() {
        if (this.mRetaining) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Finished Retaining: " + this);
            }
            this.mRetaining = false;
            if (this.mStarted != this.mRetainingStarted && !this.mStarted) {
                this.stop();
            }
        }
        if (this.mStarted && this.mHaveData && !this.mReportNextStart) {
            this.callOnLoadFinished(this.mLoader, this.mData);
        }
    }
    
    public void onLoadComplete(final l<Object> l, final Object mData) {
        if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "onLoadComplete: " + this);
        }
        if (this.mDestroyed) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
            }
        }
        else if (this.this$0.mLoaders.a(this.mId) != this) {
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Ignoring load complete -- not active");
            }
        }
        else {
            final LoaderManagerImpl$LoaderInfo mPendingLoader = this.mPendingLoader;
            if (mPendingLoader != null) {
                if (LoaderManagerImpl.DEBUG) {
                    Log.v("LoaderManager", "  Switching to pending loader: " + mPendingLoader);
                }
                this.mPendingLoader = null;
                this.this$0.mLoaders.b(this.mId, null);
                this.destroy();
                this.this$0.installLoader(mPendingLoader);
                return;
            }
            if (this.mData != mData || !this.mHaveData) {
                this.mData = mData;
                this.mHaveData = true;
                if (this.mStarted) {
                    this.callOnLoadFinished(l, mData);
                }
            }
            final LoaderManagerImpl$LoaderInfo loaderManagerImpl$LoaderInfo = this.this$0.mInactiveLoaders.a(this.mId);
            if (loaderManagerImpl$LoaderInfo != null && loaderManagerImpl$LoaderInfo != this) {
                loaderManagerImpl$LoaderInfo.mDeliveredData = false;
                loaderManagerImpl$LoaderInfo.destroy();
                this.this$0.mInactiveLoaders.c(this.mId);
            }
            if (this.this$0.mActivity != null && !this.this$0.hasRunningLoaders()) {
                this.this$0.mActivity.mFragments.startPendingDeferredFragments();
            }
        }
    }
    
    void reportStart() {
        if (this.mStarted && this.mReportNextStart) {
            this.mReportNextStart = false;
            if (this.mHaveData) {
                this.callOnLoadFinished(this.mLoader, this.mData);
            }
        }
    }
    
    void retain() {
        if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Retaining: " + this);
        }
        this.mRetaining = true;
        this.mRetainingStarted = this.mStarted;
        this.mStarted = false;
        this.mCallbacks = null;
    }
    
    void start() {
        if (this.mRetaining && this.mRetainingStarted) {
            this.mStarted = true;
        }
        else if (!this.mStarted) {
            this.mStarted = true;
            if (LoaderManagerImpl.DEBUG) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            if (this.mLoader == null && this.mCallbacks != null) {
                this.mLoader = this.mCallbacks.onCreateLoader(this.mId, this.mArgs);
            }
            if (this.mLoader != null) {
                if (this.mLoader.getClass().isMemberClass() && !Modifier.isStatic(this.mLoader.getClass().getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.mLoader);
                }
                if (!this.mListenerRegistered) {
                    this.mLoader.a(this.mId, this);
                    this.mListenerRegistered = true;
                }
                this.mLoader.a();
            }
        }
    }
    
    void stop() {
        if (LoaderManagerImpl.DEBUG) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.mStarted = false;
        if (!this.mRetaining && this.mLoader != null && this.mListenerRegistered) {
            this.mListenerRegistered = false;
            this.mLoader.a(this);
            this.mLoader.c();
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(64);
        sb.append("LoaderInfo{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" #");
        sb.append(this.mId);
        sb.append(" : ");
        c.a(this.mLoader, sb);
        sb.append("}}");
        return sb.toString();
    }
}

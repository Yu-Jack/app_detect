// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import android.util.Log;
import android.content.Context;
import android.os.Parcel;
import android.os.Bundle;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

final class FragmentState implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    final String a;
    final int b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    Bundle j;
    Fragment k;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator() {};
    }
    
    public FragmentState(final Parcel parcel) {
        boolean h = true;
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.c = (parcel.readInt() != 0 && h);
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        this.g = (parcel.readInt() != 0 && h);
        if (parcel.readInt() == 0) {
            h = false;
        }
        this.h = h;
        this.i = parcel.readBundle();
        this.j = parcel.readBundle();
    }
    
    public FragmentState(final Fragment fragment) {
        this.a = fragment.getClass().getName();
        this.b = fragment.mIndex;
        this.c = fragment.mFromLayout;
        this.d = fragment.mFragmentId;
        this.e = fragment.mContainerId;
        this.f = fragment.mTag;
        this.g = fragment.mRetainInstance;
        this.h = fragment.mDetached;
        this.i = fragment.mArguments;
    }
    
    public final Fragment a(final FragmentActivity fragmentActivity, final Fragment fragment) {
        if (this.k != null) {
            return this.k;
        }
        if (this.i != null) {
            this.i.setClassLoader(fragmentActivity.getClassLoader());
        }
        this.k = Fragment.instantiate((Context)fragmentActivity, this.a, this.i);
        if (this.j != null) {
            this.j.setClassLoader(fragmentActivity.getClassLoader());
            this.k.mSavedFragmentState = this.j;
        }
        this.k.setIndex(this.b, fragment);
        this.k.mFromLayout = this.c;
        this.k.mRestored = true;
        this.k.mFragmentId = this.d;
        this.k.mContainerId = this.e;
        this.k.mTag = this.f;
        this.k.mRetainInstance = this.g;
        this.k.mDetached = this.h;
        this.k.mFragmentManager = fragmentActivity.b;
        if (android.support.v4.app.i.a) {
            Log.v("FragmentManager", "Instantiated fragment " + this.k);
        }
        return this.k;
    }
    
    public final int describeContents() {
        return 0;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        int n2 = 1;
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        int n3;
        if (this.c) {
            n3 = n2;
        }
        else {
            n3 = 0;
        }
        parcel.writeInt(n3);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
        int n4;
        if (this.g) {
            n4 = n2;
        }
        else {
            n4 = 0;
        }
        parcel.writeInt(n4);
        if (!this.h) {
            n2 = 0;
        }
        parcel.writeInt(n2);
        parcel.writeBundle(this.i);
        parcel.writeBundle(this.j);
    }
}

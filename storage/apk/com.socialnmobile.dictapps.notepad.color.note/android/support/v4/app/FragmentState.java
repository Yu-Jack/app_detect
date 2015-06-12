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

public final class FragmentState implements Parcelable
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
    public Bundle j;
    public Fragment k;
    
    static {
        CREATOR = (Parcelable$Creator)new t();
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
        this.b = fragment.o;
        this.c = fragment.x;
        this.d = fragment.F;
        this.e = fragment.G;
        this.f = fragment.H;
        this.g = fragment.K;
        this.h = fragment.J;
        this.i = fragment.q;
    }
    
    public final Fragment a(final FragmentActivity fragmentActivity, final Fragment fragment) {
        if (this.k != null) {
            return this.k;
        }
        if (this.i != null) {
            this.i.setClassLoader(fragmentActivity.getClassLoader());
        }
        this.k = Fragment.a((Context)fragmentActivity, this.a, this.i);
        if (this.j != null) {
            this.j.setClassLoader(fragmentActivity.getClassLoader());
            this.k.m = this.j;
        }
        this.k.a(this.b, fragment);
        this.k.x = this.c;
        this.k.z = true;
        this.k.F = this.d;
        this.k.G = this.e;
        this.k.H = this.f;
        this.k.K = this.g;
        this.k.J = this.h;
        this.k.B = fragmentActivity.b;
        if (o.a) {
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

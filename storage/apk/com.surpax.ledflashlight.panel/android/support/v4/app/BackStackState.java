// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.app;

import java.util.ArrayList;
import android.util.Log;
import android.text.TextUtils;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

final class BackStackState implements Parcelable
{
    public static final Parcelable$Creator CREATOR;
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    
    static {
        CREATOR = (Parcelable$Creator)new Parcelable$Creator() {};
    }
    
    public BackStackState(final Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
    }
    
    public BackStackState(final a a) {
        b b = a.b;
        int n = 0;
        while (b != null) {
            if (b.i != null) {
                n += b.i.size();
            }
            b = b.a;
        }
        this.a = new int[n + 7 * a.d];
        if (!a.k) {
            throw new IllegalStateException("Not on back stack");
        }
        b b2 = a.b;
        int n2 = 0;
        while (b2 != null) {
            final int[] a2 = this.a;
            final int n3 = n2 + 1;
            a2[n2] = b2.c;
            final int[] a3 = this.a;
            final int n4 = n3 + 1;
            int mIndex;
            if (b2.d != null) {
                mIndex = b2.d.mIndex;
            }
            else {
                mIndex = -1;
            }
            a3[n3] = mIndex;
            final int[] a4 = this.a;
            final int n5 = n4 + 1;
            a4[n4] = b2.e;
            final int[] a5 = this.a;
            final int n6 = n5 + 1;
            a5[n5] = b2.f;
            final int[] a6 = this.a;
            final int n7 = n6 + 1;
            a6[n6] = b2.g;
            final int[] a7 = this.a;
            final int n8 = n7 + 1;
            a7[n7] = b2.h;
            if (b2.i != null) {
                final int size = b2.i.size();
                final int[] a8 = this.a;
                int n9 = n8 + 1;
                a8[n8] = size;
                int n10;
                for (int i = 0; i < size; ++i, n9 = n10) {
                    final int[] a9 = this.a;
                    n10 = n9 + 1;
                    a9[n9] = b2.i.get(i).mIndex;
                }
                n2 = n9;
            }
            else {
                final int[] a10 = this.a;
                n2 = n8 + 1;
                a10[n8] = 0;
            }
            b2 = b2.a;
        }
        this.b = a.i;
        this.c = a.j;
        this.d = a.m;
        this.e = a.o;
        this.f = a.p;
        this.g = a.q;
        this.h = a.r;
        this.i = a.s;
    }
    
    public final a a(final i i) {
        final a a = new a(i);
        int j = 0;
        int n7;
        for (int k = 0; k < this.a.length; k = n7) {
            final b b = new b();
            final int[] a2 = this.a;
            final int n = k + 1;
            b.c = a2[k];
            if (i.a) {
                Log.v("FragmentManager", "Instantiate " + a + " op #" + j + " base fragment #" + this.a[n]);
            }
            final int[] a3 = this.a;
            final int n2 = n + 1;
            final int index = a3[n];
            if (index >= 0) {
                b.d = (Fragment)i.f.get(index);
            }
            else {
                b.d = null;
            }
            final int[] a4 = this.a;
            final int n3 = n2 + 1;
            b.e = a4[n2];
            final int[] a5 = this.a;
            final int n4 = n3 + 1;
            b.f = a5[n3];
            final int[] a6 = this.a;
            final int n5 = n4 + 1;
            b.g = a6[n4];
            final int[] a7 = this.a;
            final int n6 = n5 + 1;
            b.h = a7[n5];
            final int[] a8 = this.a;
            n7 = n6 + 1;
            final int initialCapacity = a8[n6];
            if (initialCapacity > 0) {
                b.i = new ArrayList(initialCapacity);
                int n8;
                for (int l = 0; l < initialCapacity; ++l, n7 = n8) {
                    if (i.a) {
                        Log.v("FragmentManager", "Instantiate " + a + " set remove fragment #" + this.a[n7]);
                    }
                    final ArrayList f = i.f;
                    final int[] a9 = this.a;
                    n8 = n7 + 1;
                    b.i.add(f.get(a9[n7]));
                }
            }
            a.a(b);
            ++j;
        }
        a.i = this.b;
        a.j = this.c;
        a.m = this.d;
        a.o = this.e;
        a.k = true;
        a.p = this.f;
        a.q = this.g;
        a.r = this.h;
        a.s = this.i;
        a.a(1);
        return a;
    }
    
    public final int describeContents() {
        return 0;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeIntArray(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e);
        parcel.writeInt(this.f);
        TextUtils.writeToParcel(this.g, parcel, 0);
        parcel.writeInt(this.h);
        TextUtils.writeToParcel(this.i, parcel, 0);
    }
}

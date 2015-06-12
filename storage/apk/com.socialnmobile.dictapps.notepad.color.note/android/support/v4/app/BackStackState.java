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

public final class BackStackState implements Parcelable
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
        CREATOR = (Parcelable$Creator)new d();
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
    
    public BackStackState(final b b) {
        c c = b.b;
        int n = 0;
        while (c != null) {
            if (c.i != null) {
                n += c.i.size();
            }
            c = c.a;
        }
        this.a = new int[n + 7 * b.d];
        if (!b.k) {
            throw new IllegalStateException("Not on back stack");
        }
        c c2 = b.b;
        int n2 = 0;
        while (c2 != null) {
            final int[] a = this.a;
            final int n3 = n2 + 1;
            a[n2] = c2.c;
            final int[] a2 = this.a;
            final int n4 = n3 + 1;
            int o;
            if (c2.d != null) {
                o = c2.d.o;
            }
            else {
                o = -1;
            }
            a2[n3] = o;
            final int[] a3 = this.a;
            final int n5 = n4 + 1;
            a3[n4] = c2.e;
            final int[] a4 = this.a;
            final int n6 = n5 + 1;
            a4[n5] = c2.f;
            final int[] a5 = this.a;
            final int n7 = n6 + 1;
            a5[n6] = c2.g;
            final int[] a6 = this.a;
            final int n8 = n7 + 1;
            a6[n7] = c2.h;
            if (c2.i != null) {
                final int size = c2.i.size();
                final int[] a7 = this.a;
                int n9 = n8 + 1;
                a7[n8] = size;
                int n10;
                for (int i = 0; i < size; ++i, n9 = n10) {
                    final int[] a8 = this.a;
                    n10 = n9 + 1;
                    a8[n9] = c2.i.get(i).o;
                }
                n2 = n9;
            }
            else {
                final int[] a9 = this.a;
                n2 = n8 + 1;
                a9[n8] = 0;
            }
            c2 = c2.a;
        }
        this.b = b.i;
        this.c = b.j;
        this.d = b.m;
        this.e = b.o;
        this.f = b.p;
        this.g = b.q;
        this.h = b.r;
        this.i = b.s;
    }
    
    public final b a(final o o) {
        final b b = new b(o);
        int i = 0;
        int n7;
        for (int j = 0; j < this.a.length; j = n7) {
            final c c = new c();
            final int[] a = this.a;
            final int n = j + 1;
            c.c = a[j];
            if (o.a) {
                Log.v("FragmentManager", "Instantiate " + b + " op #" + i + " base fragment #" + this.a[n]);
            }
            final int[] a2 = this.a;
            final int n2 = n + 1;
            final int index = a2[n];
            if (index >= 0) {
                c.d = (Fragment)o.f.get(index);
            }
            else {
                c.d = null;
            }
            final int[] a3 = this.a;
            final int n3 = n2 + 1;
            c.e = a3[n2];
            final int[] a4 = this.a;
            final int n4 = n3 + 1;
            c.f = a4[n3];
            final int[] a5 = this.a;
            final int n5 = n4 + 1;
            c.g = a5[n4];
            final int[] a6 = this.a;
            final int n6 = n5 + 1;
            c.h = a6[n5];
            final int[] a7 = this.a;
            n7 = n6 + 1;
            final int initialCapacity = a7[n6];
            if (initialCapacity > 0) {
                c.i = new ArrayList(initialCapacity);
                int n8;
                for (int k = 0; k < initialCapacity; ++k, n7 = n8) {
                    if (o.a) {
                        Log.v("FragmentManager", "Instantiate " + b + " set remove fragment #" + this.a[n7]);
                    }
                    final ArrayList f = o.f;
                    final int[] a8 = this.a;
                    n8 = n7 + 1;
                    c.i.add(f.get(a8[n7]));
                }
            }
            b.a(c);
            ++i;
        }
        b.i = this.b;
        b.j = this.c;
        b.m = this.d;
        b.o = this.e;
        b.k = true;
        b.p = this.f;
        b.q = this.g;
        b.r = this.h;
        b.s = this.i;
        b.b(1);
        return b;
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

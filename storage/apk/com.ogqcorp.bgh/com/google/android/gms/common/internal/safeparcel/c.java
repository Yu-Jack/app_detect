// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.common.internal.safeparcel;

import java.util.List;
import android.os.Parcelable;
import android.os.IBinder;
import android.os.Bundle;
import android.os.Parcel;

public class c
{
    public static int a(final Parcel parcel) {
        return b(parcel, 20293);
    }
    
    public static void a(final Parcel parcel, final int n) {
        c(parcel, n);
    }
    
    public static void a(final Parcel parcel, final int n, final byte b) {
        b(parcel, n, 4);
        parcel.writeInt((int)b);
    }
    
    public static void a(final Parcel parcel, final int n, final double n2) {
        b(parcel, n, 8);
        parcel.writeDouble(n2);
    }
    
    public static void a(final Parcel parcel, final int n, final float n2) {
        b(parcel, n, 4);
        parcel.writeFloat(n2);
    }
    
    public static void a(final Parcel parcel, final int n, final int n2) {
        b(parcel, n, 4);
        parcel.writeInt(n2);
    }
    
    public static void a(final Parcel parcel, final int n, final long n2) {
        b(parcel, n, 8);
        parcel.writeLong(n2);
    }
    
    public static void a(final Parcel parcel, final int n, final Bundle bundle, final boolean b) {
        if (bundle == null) {
            if (b) {
                b(parcel, n, 0);
            }
            return;
        }
        final int b2 = b(parcel, n);
        parcel.writeBundle(bundle);
        c(parcel, b2);
    }
    
    public static void a(final Parcel parcel, final int n, final IBinder binder, final boolean b) {
        if (binder == null) {
            if (b) {
                b(parcel, n, 0);
            }
            return;
        }
        final int b2 = b(parcel, n);
        parcel.writeStrongBinder(binder);
        c(parcel, b2);
    }
    
    public static void a(final Parcel parcel, final int n, final Parcel parcel2, final boolean b) {
        if (parcel2 == null) {
            if (b) {
                b(parcel, n, 0);
            }
            return;
        }
        final int b2 = b(parcel, n);
        parcel.appendFrom(parcel2, 0, parcel2.dataSize());
        c(parcel, b2);
    }
    
    public static void a(final Parcel parcel, final int n, final Parcelable parcelable, final int n2, final boolean b) {
        if (parcelable == null) {
            if (b) {
                b(parcel, n, 0);
            }
            return;
        }
        final int b2 = b(parcel, n);
        parcelable.writeToParcel(parcel, n2);
        c(parcel, b2);
    }
    
    public static void a(final Parcel parcel, final int n, final Boolean b, final boolean b2) {
        if (b == null) {
            if (b2) {
                b(parcel, n, 0);
            }
            return;
        }
        b(parcel, n, 4);
        final boolean booleanValue = b;
        int n2 = 0;
        if (booleanValue) {
            n2 = 1;
        }
        parcel.writeInt(n2);
    }
    
    public static void a(final Parcel parcel, final int n, final Integer n2, final boolean b) {
        if (n2 == null) {
            if (b) {
                b(parcel, n, 0);
            }
            return;
        }
        b(parcel, n, 4);
        parcel.writeInt((int)n2);
    }
    
    public static void a(final Parcel parcel, final int n, final String s, final boolean b) {
        if (s == null) {
            if (b) {
                b(parcel, n, 0);
            }
            return;
        }
        final int b2 = b(parcel, n);
        parcel.writeString(s);
        c(parcel, b2);
    }
    
    public static void a(final Parcel parcel, final int n, final List<String> list, final boolean b) {
        if (list == null) {
            if (b) {
                b(parcel, n, 0);
            }
            return;
        }
        final int b2 = b(parcel, n);
        parcel.writeStringList((List)list);
        c(parcel, b2);
    }
    
    public static void a(final Parcel parcel, final int n, final short n2) {
        b(parcel, n, 4);
        parcel.writeInt((int)n2);
    }
    
    public static void a(final Parcel parcel, final int n, final boolean b) {
        b(parcel, n, 4);
        int n2;
        if (b) {
            n2 = 1;
        }
        else {
            n2 = 0;
        }
        parcel.writeInt(n2);
    }
    
    public static void a(final Parcel parcel, final int n, final byte[] array, final boolean b) {
        if (array == null) {
            if (b) {
                b(parcel, n, 0);
            }
            return;
        }
        final int b2 = b(parcel, n);
        parcel.writeByteArray(array);
        c(parcel, b2);
    }
    
    public static void a(final Parcel parcel, final int n, final int[] array, final boolean b) {
        if (array == null) {
            if (b) {
                b(parcel, n, 0);
            }
            return;
        }
        final int b2 = b(parcel, n);
        parcel.writeIntArray(array);
        c(parcel, b2);
    }
    
    public static <T extends Parcelable> void a(final Parcel parcel, final int n, final T[] array, final int n2, final boolean b) {
        if (array == null) {
            if (b) {
                b(parcel, n, 0);
            }
            return;
        }
        final int b2 = b(parcel, n);
        final int length = array.length;
        parcel.writeInt(length);
        for (final Parcelable parcelable : array) {
            if (parcelable == null) {
                parcel.writeInt(0);
            }
            else {
                a(parcel, parcelable, n2);
            }
        }
        c(parcel, b2);
    }
    
    public static void a(final Parcel parcel, final int n, final String[] array, final boolean b) {
        if (array == null) {
            if (b) {
                b(parcel, n, 0);
            }
            return;
        }
        final int b2 = b(parcel, n);
        parcel.writeStringArray(array);
        c(parcel, b2);
    }
    
    public static void a(final Parcel parcel, final int n, final byte[][] array, final boolean b) {
        int i = 0;
        if (array == null) {
            if (b) {
                b(parcel, n, 0);
            }
            return;
        }
        final int b2 = b(parcel, n);
        final int length = array.length;
        parcel.writeInt(length);
        while (i < length) {
            parcel.writeByteArray(array[i]);
            ++i;
        }
        c(parcel, b2);
    }
    
    private static <T extends Parcelable> void a(final Parcel parcel, final T t, final int n) {
        final int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        final int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, n);
        final int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }
    
    private static int b(final Parcel parcel, final int n) {
        parcel.writeInt(0xFFFF0000 | n);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }
    
    private static void b(final Parcel parcel, final int n, final int n2) {
        if (n2 >= 65535) {
            parcel.writeInt(0xFFFF0000 | n);
            parcel.writeInt(n2);
            return;
        }
        parcel.writeInt(n | n2 << 16);
    }
    
    public static <T extends Parcelable> void b(final Parcel parcel, final int n, final List<T> list, final boolean b) {
        if (list == null) {
            if (b) {
                b(parcel, n, 0);
            }
            return;
        }
        final int b2 = b(parcel, n);
        final int size = list.size();
        parcel.writeInt(size);
        for (int i = 0; i < size; ++i) {
            final Parcelable parcelable = list.get(i);
            if (parcelable == null) {
                parcel.writeInt(0);
            }
            else {
                a(parcel, parcelable, 0);
            }
        }
        c(parcel, b2);
    }
    
    private static void c(final Parcel parcel, final int n) {
        final int dataPosition = parcel.dataPosition();
        final int n2 = dataPosition - n;
        parcel.setDataPosition(n - 4);
        parcel.writeInt(n2);
        parcel.setDataPosition(dataPosition);
    }
    
    public static void c(final Parcel parcel, final int n, final List list, final boolean b) {
        if (list == null) {
            if (b) {
                b(parcel, n, 0);
            }
            return;
        }
        final int b2 = b(parcel, n);
        parcel.writeList(list);
        c(parcel, b2);
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import org.a.a.a.b;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;

public final class p
{
    public static <T extends Parcelable> T a(final ClassLoader classLoader, final File file) {
        final Parcel obtain = Parcel.obtain();
        try {
            final byte[] d = b.d(file);
            obtain.unmarshall(d, 0, d.length);
            obtain.setDataPosition(0);
            return (T)obtain.readParcelable(classLoader);
        }
        finally {
            obtain.recycle();
        }
    }
    
    public static Set<String> a(final Parcel parcel) {
        final ArrayList<String> c = new ArrayList<String>();
        parcel.readStringList((List)c);
        return new HashSet<String>(c);
    }
    
    public static void a(final Parcel parcel, final Set<String> c) {
        ArrayList list;
        if (c != null) {
            list = new ArrayList((Collection<? extends E>)c);
        }
        else {
            list = null;
        }
        parcel.writeStringList((List)list);
    }
    
    public static void a(final Parcelable parcelable, final File file) {
        final Parcel obtain = Parcel.obtain();
        try {
            obtain.writeParcelable(parcelable, 0);
            b.a(file, obtain.marshall());
        }
        finally {
            obtain.recycle();
        }
    }
}

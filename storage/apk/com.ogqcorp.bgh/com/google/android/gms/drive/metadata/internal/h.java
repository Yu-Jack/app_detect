// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.metadata.internal;

import java.util.Collection;
import com.google.android.gms.drive.metadata.f;
import android.os.Parcelable;

public abstract class h<T extends Parcelable> extends f<T>
{
    public h(final String s, final int n) {
        super(s, n);
    }
    
    public h(final String s, final Collection<String> collection, final int n) {
        super(s, collection, n);
    }
}

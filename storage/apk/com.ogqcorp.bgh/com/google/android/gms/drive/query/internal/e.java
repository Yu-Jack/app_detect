// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.drive.query.internal;

import java.util.Set;
import com.google.android.gms.drive.metadata.a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

class e
{
    static a<?> a(final MetadataBundle metadataBundle) {
        final Set<a<?>> a = metadataBundle.a();
        if (a.size() != 1) {
            throw new IllegalArgumentException("bundle should have exactly 1 populated field");
        }
        return a.iterator().next();
    }
}

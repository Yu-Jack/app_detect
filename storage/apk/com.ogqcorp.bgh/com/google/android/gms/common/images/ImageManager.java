// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.common.images;

import java.util.Map;
import com.google.android.gms.internal.ft;
import java.util.concurrent.ExecutorService;
import android.os.Handler;
import android.content.Context;
import android.net.Uri;
import java.util.HashSet;

public final class ImageManager
{
    private static final Object a;
    private static HashSet<Uri> b;
    private final Context c;
    private final Handler d;
    private final ExecutorService e;
    private final b f;
    private final ft g;
    private final Map<e, ImageManager$ImageReceiver> h;
    private final Map<Uri, ImageManager$ImageReceiver> i;
    
    static {
        a = new Object();
        ImageManager.b = new HashSet<Uri>();
    }
}

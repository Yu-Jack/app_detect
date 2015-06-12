// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.internal.h;
import com.google.android.gms.drive.metadata.internal.i;
import com.google.android.gms.drive.metadata.internal.e;
import com.google.android.gms.drive.metadata.internal.j;
import android.graphics.Bitmap;
import com.google.android.gms.drive.metadata.g;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.a;

public class hy
{
    public static final a<String> A;
    public static final a<DriveId> a;
    public static final a<String> b;
    public static final a<String> c;
    public static final a<String> d;
    public static final a<String> e;
    public static final a<Long> f;
    public static final a<Boolean> g;
    public static final a<String> h;
    public static final a<Boolean> i;
    public static final a<Boolean> j;
    public static final a<Boolean> k;
    public static final hz l;
    public static final a<Boolean> m;
    public static final a<Boolean> n;
    public static final a<Boolean> o;
    public static final a<Boolean> p;
    public static final ia q;
    public static final a<String> r;
    public static final g<String> s;
    public static final ib t;
    public static final id u;
    public static final if v;
    public static final a<Bitmap> w;
    public static final ig x;
    public static final ii y;
    public static final a<String> z;
    
    static {
        a = ip.a;
        b = new j("alternateLink", 4300000);
        c = new j("description", 4300000);
        d = new j("embedLink", 4300000);
        e = new j("fileExtension", 4300000);
        f = new e("fileSize", 4300000);
        g = new com.google.android.gms.drive.metadata.internal.a("hasThumbnail", 4300000);
        h = new j("indexableText", 4300000);
        i = new com.google.android.gms.drive.metadata.internal.a("isAppData", 4300000);
        j = new com.google.android.gms.drive.metadata.internal.a("isCopyable", 4300000);
        k = new com.google.android.gms.drive.metadata.internal.a("isEditable", 4100000);
        l = new hz("isPinned", 4100000);
        m = new com.google.android.gms.drive.metadata.internal.a("isRestricted", 4300000);
        n = new com.google.android.gms.drive.metadata.internal.a("isShared", 4300000);
        o = new com.google.android.gms.drive.metadata.internal.a("isTrashable", 4400000);
        p = new com.google.android.gms.drive.metadata.internal.a("isViewed", 4300000);
        q = new ia("mimeType", 4100000);
        r = new j("originalFilename", 4300000);
        s = new i("ownerNames", 4300000);
        t = new ib("parents", 4100000);
        u = new id("quotaBytesUsed", 4300000);
        v = new if("starred", 4100000);
        w = new h<Bitmap>(4400000) {};
        x = new ig("title", 4100000);
        y = new ii("trashed", 4100000);
        z = new j("webContentLink", 4300000);
        A = new j("webViewLink", 4300000);
    }
}

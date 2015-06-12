// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.common.data;

import com.google.android.gms.internal.gz;
import java.util.HashMap;
import java.util.ArrayList;

public class a
{
    private final String[] a;
    private final ArrayList<HashMap<String, Object>> b;
    private final String c;
    private final HashMap<Object, Integer> d;
    private boolean e;
    private String f;
    
    private a(final String[] array, final String c) {
        this.a = gz.a(array);
        this.b = new ArrayList<HashMap<String, Object>>();
        this.c = c;
        this.d = new HashMap<Object, Integer>();
        this.e = false;
        this.f = null;
    }
}

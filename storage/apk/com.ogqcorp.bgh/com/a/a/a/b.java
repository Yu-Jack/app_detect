// 
// Decompiled by Procyon v0.5.29
// 

package com.a.a.a;

import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;

public class b
{
    protected static final Comparator<byte[]> a;
    private List<byte[]> b;
    private List<byte[]> c;
    private int d;
    private final int e;
    
    static {
        a = new Comparator<byte[]>() {
            public int a(final byte[] array, final byte[] array2) {
                return array.length - array2.length;
            }
        };
    }
    
    public b(final int e) {
        this.b = new LinkedList<byte[]>();
        this.c = new ArrayList<byte[]>(64);
        this.d = 0;
        this.e = e;
    }
    
    private void a() {
        synchronized (this) {
            while (this.d > this.e) {
                final byte[] array = this.b.remove(0);
                this.c.remove(array);
                this.d -= array.length;
            }
        }
    }
    // monitorexit(this)
    
    public void a(final byte[] key) {
        // monitorenter(this)
        if (key == null) {
            return;
        }
        try {
            if (key.length <= this.e) {
                this.b.add(key);
                int binarySearch = Collections.binarySearch(this.c, key, com.a.a.a.b.a);
                if (binarySearch < 0) {
                    binarySearch = -1 + -binarySearch;
                }
                this.c.add(binarySearch, key);
                this.d += key.length;
                this.a();
            }
        }
        finally {
        }
        // monitorexit(this)
    }
    
    public byte[] a(final int n) {
        // monitorenter(this)
        int i = 0;
        try {
            while (i < this.c.size()) {
                final byte[] array = this.c.get(i);
                if (array.length >= n) {
                    this.d -= array.length;
                    this.c.remove(i);
                    this.b.remove(array);
                    return array;
                }
                ++i;
            }
            return new byte[n];
        }
        finally {
        }
        // monitorexit(this)
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.c;

import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.Collection;
import java.util.ArrayList;

public final class b<T extends c>
{
    private ArrayList<T> a;
    
    public ArrayList<T> a(final String s, final ArrayList<T> c) {
        final String replaceAll = s.replaceAll("\\s+", "");
        if (this.a == null) {
            if (replaceAll.length() == 0) {
                return null;
            }
            this.a = new ArrayList<T>((Collection<? extends T>)c);
        }
        final ArrayList<c> list = (ArrayList<c>)new ArrayList<T>();
        if (replaceAll.length() == 0) {
            for (final c e : this.a) {
                e.a();
                list.add(e);
            }
            this.a = null;
        }
        else {
            final Pattern compile = Pattern.compile("(" + Pattern.quote(replaceAll) + ")", 2);
            for (final c e2 : this.a) {
                if (e2.a(compile)) {
                    e2.b(compile);
                    list.add(e2);
                }
                if (list.size() >= 200) {
                    break;
                }
            }
        }
        return (ArrayList<T>)list;
    }
}

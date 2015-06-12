// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.cf.commons;

import com.ogqcorp.bgh.cf.a;
import java.lang.reflect.Method;
import android.view.View$OnClickListener;
import android.view.View;

public final class b
{
    public static void a(final View view, final int n, final Object o, final String s) {
        a(view.findViewById(n), o, s);
    }
    
    public static void a(final View view, final Object o, final String s) {
        if (view == null) {
            return;
        }
        view.setOnClickListener((View$OnClickListener)new View$OnClickListener() {
            private Method c;
            
            public void onClick(final View view) {
                while (true) {
                    if (this.c != null) {
                        break Label_0034;
                    }
                    try {
                        this.c = o.getClass().getMethod(s, View.class);
                        try {
                            this.c.invoke(o, view);
                        }
                        catch (Exception ex) {
                            com.ogqcorp.bgh.cf.a.a(ex);
                        }
                    }
                    catch (Exception ex2) {
                        continue;
                    }
                    break;
                }
            }
        });
    }
}

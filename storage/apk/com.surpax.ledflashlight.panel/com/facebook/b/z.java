// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.b;

import android.content.pm.Signature;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Build;
import android.content.Context;
import java.util.HashSet;

abstract class z
{
    private static final HashSet a;
    
    static {
        final HashSet<String> a2 = new HashSet<String>();
        a2.add("8a3c4b262d721acd49a4bf97d5213199c86fa2b9");
        a2.add("a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc");
        a2.add("5e8f16062ea3cd2c4a0d547876baa6f38cabf625");
        a = a2;
    }
    
    public static boolean a(final Context context, final String s) {
        final String brand = Build.BRAND;
        final int flags = context.getApplicationInfo().flags;
        if (!brand.startsWith("generic") || (flags & 0x2) == 0x0) {
            while (true) {
                while (true) {
                    Signature[] signatures;
                    int n;
                    try {
                        signatures = context.getPackageManager().getPackageInfo(s, 64).signatures;
                        final int length = signatures.length;
                        n = 0;
                        if (n >= length) {
                            return false;
                        }
                    }
                    catch (PackageManager$NameNotFoundException ex) {
                        return false;
                    }
                    if (!z.a.contains(aj.a(signatures[n].toByteArray()))) {
                        ++n;
                        continue;
                    }
                    break;
                }
                break;
            }
        }
        return true;
    }
    
    protected abstract String a();
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.flurry.sdk;

import java.util.Iterator;
import java.nio.ByteBuffer;
import java.util.Map;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.FlurryAdModule;

public class ag
{
    private static final String a;
    private final FlurryAdModule b;
    
    static {
        a = ag.class.getSimpleName();
    }
    
    public ag(final FlurryAdModule b) {
        this.b = b;
    }
    
    private boolean a(final String str, final String s) {
        return s.equals("%{" + str + "}");
    }
    
    public String a(final e e, final AdUnit adUnit, final a a, final String s, final String target) {
        String s2;
        if (this.a("fids", target)) {
            final StringBuilder sb = new StringBuilder();
            final Iterator<Map.Entry<dr, V>> iterator = dn.a().l().entrySet().iterator();
            int n = 1;
            while (iterator.hasNext()) {
                final Map.Entry<dr, V> entry = iterator.next();
                if (n == 0) {
                    sb.append(",");
                }
                sb.append(entry.getKey().d).append(":");
                if (entry.getKey().e) {
                    sb.append(new String(((ByteBuffer)entry.getValue()).array()));
                    n = 0;
                }
                else {
                    sb.append(fe.a(((ByteBuffer)entry.getValue()).array()));
                    n = 0;
                }
            }
            eo.a(3, ag.a, "Replacing param fids with: " + sb.toString());
            s2 = s.replace(target, fe.b(sb.toString()));
        }
        else {
            if (this.a("sid", target)) {
                final String value = String.valueOf(this.b.h());
                eo.a(3, ag.a, "Replacing param sid with: " + value);
                return s.replace(target, fe.b(value));
            }
            if (this.a("lid", target)) {
                final String value2 = String.valueOf(e.a());
                eo.a(3, ag.a, "Replacing param lid with: " + value2);
                return s.replace(target, fe.b(value2));
            }
            if (this.a("guid", target)) {
                final String b = e.b();
                eo.a(3, ag.a, "Replacing param guid with: " + b);
                return s.replace(target, fe.b(b));
            }
            if (this.a("ats", target)) {
                final String value3 = String.valueOf(System.currentTimeMillis());
                eo.a(3, ag.a, "Replacing param ats with: " + value3);
                return s.replace(target, fe.b(value3));
            }
            if (this.a("apik", target)) {
                final String j = this.b.j();
                eo.a(3, ag.a, "Replacing param apik with: " + j);
                return s.replace(target, fe.b(j));
            }
            if (this.a("hid", target)) {
                final String string = adUnit.b().toString();
                eo.a(3, ag.a, "Replacing param hid with: " + string);
                return s.replace(target, fe.b(string));
            }
            if (this.a("eso", target)) {
                final String string2 = Long.toString(System.currentTimeMillis() - this.b.h());
                eo.a(3, ag.a, "Replacing param eso with: " + string2);
                return s.replace(target, fe.b(string2));
            }
            if (!this.a("uc", target)) {
                eo.a(3, ag.a, "Unknown param: " + target);
                return s.replace(target, "");
            }
            final Iterator<Map.Entry<String, V>> iterator2 = this.b.B().entrySet().iterator();
            String string3 = "";
            while (iterator2.hasNext()) {
                final Map.Entry<String, V> entry2 = iterator2.next();
                string3 = string3 + "c_" + fe.b(entry2.getKey()) + "=" + fe.b((String)entry2.getValue()) + "&";
            }
            eo.a(3, ag.a, "Replacing param uc with: " + string3);
            s2 = s.replace(target, string3);
            if (string3.equals("") && s2.length() > 0) {
                return s2.substring(0, -1 + s2.length());
            }
        }
        return s2;
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.text.TextUtils;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import com.facebook.b.aj;
import android.annotation.SuppressLint;
import com.facebook.b.al;
import android.os.Bundle;
import java.util.Collections;
import java.util.List;
import java.util.Date;
import java.io.Serializable;

public final class a implements Serializable
{
    private static final Date a;
    private static final Date b;
    private static final Date c;
    private static final Date d;
    private static final b e;
    private static final Date f;
    private final Date g;
    private final List h;
    private final List i;
    private final String j;
    private final b k;
    private final Date l;
    
    static {
        a = new Date(Long.MIN_VALUE);
        c = (b = new Date(Long.MAX_VALUE));
        d = new Date();
        e = com.facebook.b.b;
        f = com.facebook.a.a;
    }
    
    private a(final String j, final Date g, List emptyList, List emptyList2, final b k, final Date l) {
        if (emptyList == null) {
            emptyList = Collections.emptyList();
        }
        if (emptyList2 == null) {
            emptyList2 = Collections.emptyList();
        }
        this.g = g;
        this.h = Collections.unmodifiableList((List<?>)emptyList);
        this.i = Collections.unmodifiableList((List<?>)emptyList2);
        this.j = j;
        this.k = k;
        this.l = l;
    }
    
    static a a(final Bundle bundle) {
        final List a = a(bundle, "com.facebook.TokenCachingStrategy.Permissions");
        final List a2 = a(bundle, "com.facebook.TokenCachingStrategy.DeclinedPermissions");
        final String string = bundle.getString("com.facebook.TokenCachingStrategy.Token");
        final Date a3 = bs.a(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate");
        al.a(bundle, "bundle");
        b b;
        if (bundle.containsKey("com.facebook.TokenCachingStrategy.AccessTokenSource")) {
            b = (b)bundle.getSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource");
        }
        else if (bundle.getBoolean("com.facebook.TokenCachingStrategy.IsSSO")) {
            b = com.facebook.b.b;
        }
        else {
            b = com.facebook.b.e;
        }
        return new a(string, a3, a, a2, b, bs.a(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate"));
    }
    
    static a a(final Bundle bundle, final b b) {
        return a(bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS"), null, bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN"), a(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L)), b);
    }
    
    @SuppressLint({ "FieldGetter" })
    static a a(final a a, final Bundle bundle) {
        if (a.k != com.facebook.b.b && a.k != com.facebook.b.c && a.k != com.facebook.b.d) {
            throw new ab("Invalid token source: " + a.k);
        }
        return a(a.h, a.i, bundle.getString("access_token"), a(bundle, "expires_in", new Date(0L)), a.k);
    }
    
    static a a(final a a, final List list, final List list2) {
        return new a(a.j, a.g, list, list2, a.k, a.l);
    }
    
    static a a(List list, final Bundle bundle, final b b) {
        final Date a = a(bundle, "expires_in", new Date());
        final String string = bundle.getString("access_token");
        final String string2 = bundle.getString("granted_scopes");
        if (!aj.a(string2)) {
            list = new ArrayList(Arrays.asList(string2.split(",")));
        }
        final String string3 = bundle.getString("denied_scopes");
        final boolean a2 = aj.a(string3);
        List list2 = null;
        if (!a2) {
            list2 = new ArrayList(Arrays.asList(string3.split(",")));
        }
        return a(list, list2, string, a, b);
    }
    
    private static a a(final List list, final List list2, final String s, final Date date, final b b) {
        if (aj.a(s) || date == null) {
            return f();
        }
        return new a(s, date, list, list2, b, new Date());
    }
    
    private static Date a(final Bundle bundle, final String s, final Date date) {
        if (bundle == null) {
            return null;
        }
        final Object value = bundle.get(s);
        long n = 0L;
        Label_0028: {
            if (!(value instanceof Long)) {
                if (value instanceof String) {
                    try {
                        n = Long.parseLong((String)value);
                        break Label_0028;
                    }
                    catch (NumberFormatException ex) {
                        return null;
                    }
                }
                return null;
            }
            n = (long)value;
        }
        if (n == 0L) {
            return new Date(Long.MAX_VALUE);
        }
        return new Date(date.getTime() + n * 1000L);
    }
    
    private static List a(final Bundle bundle, final String s) {
        final ArrayList stringArrayList = bundle.getStringArrayList(s);
        if (stringArrayList == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList((List<?>)new ArrayList<Object>(stringArrayList));
    }
    
    static a f() {
        return new a("", com.facebook.a.f, null, null, com.facebook.b.a, com.facebook.a.d);
    }
    
    public final String a() {
        return this.j;
    }
    
    public final Date b() {
        return this.g;
    }
    
    public final List c() {
        return this.h;
    }
    
    public final b d() {
        return this.k;
    }
    
    public final Date e() {
        return this.l;
    }
    
    final Bundle g() {
        final Bundle bundle = new Bundle();
        bundle.putString("com.facebook.TokenCachingStrategy.Token", this.j);
        bs.a(bundle, "com.facebook.TokenCachingStrategy.ExpirationDate", this.g);
        bundle.putStringArrayList("com.facebook.TokenCachingStrategy.Permissions", new ArrayList(this.h));
        bundle.putStringArrayList("com.facebook.TokenCachingStrategy.DeclinedPermissions", new ArrayList(this.i));
        bundle.putSerializable("com.facebook.TokenCachingStrategy.AccessTokenSource", (Serializable)this.k);
        bs.a(bundle, "com.facebook.TokenCachingStrategy.LastRefreshDate", this.l);
        return bundle;
    }
    
    final boolean h() {
        return aj.a(this.j) || new Date().after(this.g);
    }
    
    @Override
    public final String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{AccessToken");
        final StringBuilder append = sb.append(" token:");
        String j;
        if (this.j == null) {
            j = "null";
        }
        else if (bq.a(ak.b)) {
            j = this.j;
        }
        else {
            j = "ACCESS_TOKEN_REMOVED";
        }
        append.append(j);
        sb.append(" permissions:");
        if (this.h == null) {
            sb.append("null");
        }
        else {
            sb.append("[");
            sb.append(TextUtils.join((CharSequence)", ", (Iterable)this.h));
            sb.append("]");
        }
        sb.append("}");
        return sb.toString();
    }
}

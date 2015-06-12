// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import java.util.Iterator;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.HashSet;
import java.util.Collection;
import android.content.Context;
import java.util.TreeSet;

public class j implements a
{
    private final TreeSet<String> a;
    
    public j(final Context context, final Collection<String> collection) {
        this.a = new TreeSet<String>();
        this.a(context, collection);
    }
    
    @Override
    public String a(final String s, final Throwable t) {
        return this.a(this.a(t), this.b(this.a(t)), s);
    }
    
    protected String a(final Throwable t, final StackTraceElement stackTraceElement, final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(t.getClass().getSimpleName());
        if (stackTraceElement != null) {
            final String[] split = stackTraceElement.getClassName().split("\\.");
            String s2 = "unknown";
            if (split != null && split.length > 0) {
                s2 = split[-1 + split.length];
            }
            sb.append(String.format(" (@%s:%s:%s)", s2, stackTraceElement.getMethodName(), stackTraceElement.getLineNumber()));
        }
        if (s != null) {
            sb.append(String.format(" {%s}", s));
        }
        return sb.toString();
    }
    
    protected Throwable a(Throwable cause) {
        while (cause.getCause() != null) {
            cause = cause.getCause();
        }
        return cause;
    }
    
    public void a(final Context context, final Collection<String> collection) {
        this.a.clear();
        final HashSet<String> set = new HashSet<String>();
        if (collection != null) {
            set.addAll((Collection<?>)collection);
        }
        if (context != null) {
            try {
                final String packageName = context.getApplicationContext().getPackageName();
                this.a.add(packageName);
                final ActivityInfo[] activities = context.getApplicationContext().getPackageManager().getPackageInfo(packageName, 15).activities;
                if (activities != null) {
                    for (int length = activities.length, i = 0; i < length; ++i) {
                        set.add(activities[i].packageName);
                    }
                }
            }
            catch (PackageManager$NameNotFoundException ex) {
                p.b("No package found");
            }
        }
        for (final String s : set) {
            final Iterator<String> iterator2 = this.a.iterator();
            int n = 1;
            while (iterator2.hasNext()) {
                final String s2 = iterator2.next();
                if (!s.startsWith(s2)) {
                    if (s2.startsWith(s)) {
                        this.a.remove(s2);
                        break;
                    }
                    break;
                }
                else {
                    n = 0;
                }
            }
            if (n != 0) {
                this.a.add(s);
            }
        }
    }
    
    protected StackTraceElement b(final Throwable t) {
        final StackTraceElement[] stackTrace = t.getStackTrace();
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        }
        for (final StackTraceElement stackTraceElement : stackTrace) {
            final String className = stackTraceElement.getClassName();
            final Iterator<String> iterator = this.a.iterator();
            while (iterator.hasNext()) {
                if (className.startsWith(iterator.next())) {
                    return stackTraceElement;
                }
            }
        }
        return stackTrace[0];
    }
}

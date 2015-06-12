// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Collection;
import android.content.Context;
import java.util.TreeSet;

public class StandardExceptionParser implements ExceptionParser
{
    private final TreeSet<String> includedPackages;
    
    public StandardExceptionParser(final Context context, final Collection<String> collection) {
        this.includedPackages = new TreeSet<String>();
        this.setIncludedPackages(context, collection);
    }
    
    protected StackTraceElement getBestStackTraceElement(final Throwable t) {
        final StackTraceElement[] stackTrace = t.getStackTrace();
        if (stackTrace == null || stackTrace.length == 0) {
            return null;
        }
        for (final StackTraceElement stackTraceElement : stackTrace) {
            final String className = stackTraceElement.getClassName();
            final Iterator<String> iterator = this.includedPackages.iterator();
            while (iterator.hasNext()) {
                if (className.startsWith(iterator.next())) {
                    return stackTraceElement;
                }
            }
        }
        return stackTrace[0];
    }
    
    protected Throwable getCause(final Throwable t) {
        Throwable cause;
        for (cause = t; cause.getCause() != null; cause = cause.getCause()) {}
        return cause;
    }
    
    @Override
    public String getDescription(final String s, final Throwable t) {
        return this.getDescription(this.getCause(t), this.getBestStackTraceElement(this.getCause(t)), s);
    }
    
    protected String getDescription(final Throwable t, final StackTraceElement stackTraceElement, final String s) {
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
    
    public void setIncludedPackages(final Context context, final Collection<String> collection) {
        this.includedPackages.clear();
        final HashSet<String> set = new HashSet<String>();
        if (collection != null) {
            set.addAll((Collection<?>)collection);
        }
        if (context != null) {
            try {
                final String packageName = context.getApplicationContext().getPackageName();
                this.includedPackages.add(packageName);
                final ActivityInfo[] activities = context.getApplicationContext().getPackageManager().getPackageInfo(packageName, 15).activities;
                if (activities != null) {
                    for (int length = activities.length, i = 0; i < length; ++i) {
                        set.add(activities[i].packageName);
                    }
                }
            }
            catch (PackageManager$NameNotFoundException ex) {
                Log.i("No package found");
            }
        }
        for (final String s : set) {
            int n = 1;
            for (final String s2 : this.includedPackages) {
                if (!s.startsWith(s2)) {
                    if (s2.startsWith(s)) {
                        this.includedPackages.remove(s2);
                        break;
                    }
                    break;
                }
                else {
                    n = 0;
                }
            }
            if (n != 0) {
                this.includedPackages.add(s);
            }
        }
    }
}

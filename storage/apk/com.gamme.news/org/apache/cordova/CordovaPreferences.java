// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import java.util.Locale;
import java.util.Map;
import java.util.Iterator;
import android.app.Activity;
import java.util.HashMap;
import android.os.Bundle;

public class CordovaPreferences
{
    private Bundle preferencesBundleExtras;
    private HashMap<String, String> prefs;
    
    public CordovaPreferences() {
        this.prefs = new HashMap<String, String>(20);
    }
    
    public void copyIntoIntentExtras(final Activity activity) {
        for (final String key : this.prefs.keySet()) {
            final String s = this.prefs.get(key);
            if (s != null) {
                if (key.equals("loglevel")) {
                    LOG.setLogLevel(s);
                }
                else if (key.equals("splashscreen")) {
                    activity.getIntent().putExtra(key, activity.getResources().getIdentifier(s, "drawable", activity.getClass().getPackage().getName()));
                }
                else if (key.equals("backgroundcolor")) {
                    activity.getIntent().putExtra(key, (int)(long)Long.decode(s));
                }
                else if (key.equals("loadurltimeoutvalue")) {
                    activity.getIntent().putExtra(key, (int)Integer.decode(s));
                }
                else if (key.equals("splashscreendelay")) {
                    activity.getIntent().putExtra(key, (int)Integer.decode(s));
                }
                else if (key.equals("keeprunning")) {
                    activity.getIntent().putExtra(key, Boolean.parseBoolean(s));
                }
                else if (key.equals("inappbrowserstorageenabled")) {
                    activity.getIntent().putExtra(key, Boolean.parseBoolean(s));
                }
                else if (key.equals("disallowoverscroll")) {
                    activity.getIntent().putExtra(key, Boolean.parseBoolean(s));
                }
                else {
                    activity.getIntent().putExtra(key, s);
                }
            }
        }
        if (this.preferencesBundleExtras == null) {
            this.preferencesBundleExtras = activity.getIntent().getExtras();
        }
    }
    
    public Map<String, String> getAll() {
        return this.prefs;
    }
    
    public boolean getBoolean(final String s, boolean boolean1) {
        final String lowerCase = s.toLowerCase(Locale.ENGLISH);
        final String s2 = this.prefs.get(lowerCase);
        if (s2 != null) {
            boolean1 = Boolean.parseBoolean(s2);
        }
        else if (this.preferencesBundleExtras != null) {
            final Object value = this.preferencesBundleExtras.get(lowerCase);
            if (value instanceof String) {
                return "true".equals(value);
            }
            return this.preferencesBundleExtras.getBoolean(lowerCase, boolean1);
        }
        return boolean1;
    }
    
    public double getDouble(final String s, double doubleValue) {
        final String lowerCase = s.toLowerCase(Locale.ENGLISH);
        final String s2 = this.prefs.get(lowerCase);
        if (s2 != null) {
            doubleValue = Double.valueOf(s2);
        }
        else if (this.preferencesBundleExtras != null) {
            final Object value = this.preferencesBundleExtras.get(lowerCase);
            if (value instanceof String) {
                return Double.valueOf((String)value);
            }
            return this.preferencesBundleExtras.getDouble(lowerCase, doubleValue);
        }
        return doubleValue;
    }
    
    public int getInteger(final String s, int n) {
        final String lowerCase = s.toLowerCase(Locale.ENGLISH);
        final String nm = this.prefs.get(lowerCase);
        if (nm != null) {
            n = (int)(long)Long.decode(nm);
        }
        else if (this.preferencesBundleExtras != null) {
            final Object value = this.preferencesBundleExtras.get(lowerCase);
            if (value instanceof String) {
                return Integer.valueOf((String)value);
            }
            return this.preferencesBundleExtras.getInt(lowerCase, n);
        }
        return n;
    }
    
    public String getString(final String s, final String s2) {
        final String lowerCase = s.toLowerCase(Locale.ENGLISH);
        final String s3 = this.prefs.get(lowerCase);
        if (s3 != null) {
            return s3;
        }
        if (this.preferencesBundleExtras != null && !"errorurl".equals(lowerCase)) {
            final Object value = this.preferencesBundleExtras.get(lowerCase);
            if (value != null) {
                return value.toString();
            }
        }
        return s2;
    }
    
    public void set(final String s, final double d) {
        this.set(s, new StringBuilder().append(d).toString());
    }
    
    public void set(final String s, final int i) {
        this.set(s, new StringBuilder().append(i).toString());
    }
    
    public void set(final String s, final String value) {
        this.prefs.put(s.toLowerCase(Locale.ENGLISH), value);
    }
    
    public void set(final String s, final boolean b) {
        this.set(s, new StringBuilder().append(b).toString());
    }
    
    public void setPreferencesBundle(final Bundle preferencesBundleExtras) {
        this.preferencesBundleExtras = preferencesBundleExtras;
    }
}

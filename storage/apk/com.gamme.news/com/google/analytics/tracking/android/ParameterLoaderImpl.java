// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import android.text.TextUtils;
import android.content.Context;

class ParameterLoaderImpl implements ParameterLoader
{
    private final Context mContext;
    private String mOverrideResourcePackageName;
    
    public ParameterLoaderImpl(final Context context) {
        if (context == null) {
            throw new NullPointerException("Context cannot be null");
        }
        this.mContext = context.getApplicationContext();
    }
    
    private int getResourceIdForType(final String s, final String s2) {
        if (this.mContext == null) {
            return 0;
        }
        String s3;
        if (this.mOverrideResourcePackageName != null) {
            s3 = this.mOverrideResourcePackageName;
        }
        else {
            s3 = this.mContext.getPackageName();
        }
        return this.mContext.getResources().getIdentifier(s, s2, s3);
    }
    
    @Override
    public boolean getBoolean(final String s) {
        final int resourceIdForType = this.getResourceIdForType(s, "bool");
        return resourceIdForType != 0 && "true".equalsIgnoreCase(this.mContext.getString(resourceIdForType));
    }
    
    @Override
    public Double getDoubleFromString(final String s) {
        final String string = this.getString(s);
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        try {
            return Double.parseDouble(string);
        }
        catch (NumberFormatException ex) {
            Log.w("NumberFormatException parsing " + string);
            return null;
        }
    }
    
    @Override
    public int getInt(final String s, final int n) {
        final int resourceIdForType = this.getResourceIdForType(s, "integer");
        if (resourceIdForType == 0) {
            return n;
        }
        try {
            return Integer.parseInt(this.mContext.getString(resourceIdForType));
        }
        catch (NumberFormatException ex) {
            Log.w("NumberFormatException parsing " + this.mContext.getString(resourceIdForType));
            return n;
        }
    }
    
    @Override
    public String getString(final String s) {
        final int resourceIdForType = this.getResourceIdForType(s, "string");
        if (resourceIdForType == 0) {
            return null;
        }
        return this.mContext.getString(resourceIdForType);
    }
    
    @Override
    public boolean isBooleanKeyPresent(final String s) {
        return this.getResourceIdForType(s, "bool") != 0;
    }
    
    @Override
    public void setResourcePackageName(final String mOverrideResourcePackageName) {
        this.mOverrideResourcePackageName = mOverrideResourcePackageName;
    }
}

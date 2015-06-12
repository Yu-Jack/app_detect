// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.view;

import android.view.InflateException;
import java.lang.reflect.Method;

class MenuInflater$InflatedOnMenuItemClickListener implements MenuItem$OnMenuItemClickListener
{
    private static final Class<?>[] PARAM_TYPES;
    private Method mMethod;
    private Object mRealOwner;
    
    static {
        PARAM_TYPES = new Class[] { MenuItem.class };
    }
    
    public MenuInflater$InflatedOnMenuItemClickListener(final Object mRealOwner, final String s) {
        this.mRealOwner = mRealOwner;
        final Class<?> class1 = mRealOwner.getClass();
        try {
            this.mMethod = class1.getMethod(s, MenuInflater$InflatedOnMenuItemClickListener.PARAM_TYPES);
        }
        catch (Exception ex2) {
            final InflateException ex = new InflateException("Couldn't resolve menu item onClick handler " + s + " in class " + class1.getName());
            ex.initCause((Throwable)ex2);
            throw ex;
        }
    }
    
    @Override
    public boolean onMenuItemClick(final MenuItem menuItem) {
        try {
            if (this.mMethod.getReturnType() == Boolean.TYPE) {
                return (boolean)this.mMethod.invoke(this.mRealOwner, menuItem);
            }
            this.mMethod.invoke(this.mRealOwner, menuItem);
            return true;
        }
        catch (Exception cause) {
            throw new RuntimeException(cause);
        }
    }
}

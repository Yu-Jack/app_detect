// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.util.ArrayList;
import java.util.Map;

abstract class MraidCommand
{
    protected Map mParams;
    protected MraidView mView;
    
    MraidCommand(final Map mParams, final MraidView mView) {
        this.mParams = mParams;
        this.mView = mView;
    }
    
    abstract void execute();
    
    protected boolean getBooleanFromParamsForKey(final String s) {
        return "true".equals(this.mParams.get(s));
    }
    
    protected float getFloatFromParamsForKey(final String s) {
        if (this.mParams.get(s) == null) {
            return 0.0f;
        }
        try {
            return Float.parseFloat(s);
        }
        catch (NumberFormatException ex) {
            return 0.0f;
        }
    }
    
    protected Integer[] getIntArrayFromParamsForKey(final String s) {
        final String s2 = this.mParams.get(s);
        if (s2 == null) {
            return null;
        }
        final String[] split = s2.split(",");
        final ArrayList<Integer> list = new ArrayList<Integer>();
        final int length = split.length;
        int i = 0;
    Label_0072_Outer:
        while (i < length) {
            final String s3 = split[i];
            while (true) {
                try {
                    list.add(Integer.parseInt(s3, 10));
                    ++i;
                    continue Label_0072_Outer;
                }
                catch (NumberFormatException ex) {
                    list.add(-1);
                    continue;
                }
                break;
            }
            break;
        }
        return list.toArray(new Integer[list.size()]);
    }
    
    protected int getIntFromParamsForKey(final String s) {
        final String s2 = this.mParams.get(s);
        if (s2 == null) {
            return -1;
        }
        try {
            return Integer.parseInt(s2, 10);
        }
        catch (NumberFormatException ex) {
            return -1;
        }
    }
    
    protected String getStringFromParamsForKey(final String s) {
        return this.mParams.get(s);
    }
}

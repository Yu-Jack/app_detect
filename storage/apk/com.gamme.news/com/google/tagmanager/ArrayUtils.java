// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import com.google.analytics.containertag.proto.Debug;

class ArrayUtils
{
    public static Debug.EventInfo[] appendToArray(final Debug.EventInfo[] array, final Debug.EventInfo eventInfo) {
        final Debug.EventInfo[] array2 = new Debug.EventInfo[1 + array.length];
        System.arraycopy(array, 0, array2, 0, array.length);
        array2[array.length] = eventInfo;
        return array2;
    }
    
    public static Debug.ResolvedFunctionCall[] appendToArray(final Debug.ResolvedFunctionCall[] array, final Debug.ResolvedFunctionCall resolvedFunctionCall) {
        final Debug.ResolvedFunctionCall[] array2 = new Debug.ResolvedFunctionCall[1 + array.length];
        System.arraycopy(array, 0, array2, 0, array.length);
        array2[array.length] = resolvedFunctionCall;
        return array2;
    }
    
    public static Debug.ResolvedProperty[] appendToArray(final Debug.ResolvedProperty[] array, final Debug.ResolvedProperty resolvedProperty) {
        final Debug.ResolvedProperty[] array2 = new Debug.ResolvedProperty[1 + array.length];
        System.arraycopy(array, 0, array2, 0, array.length);
        array2[array.length] = resolvedProperty;
        return array2;
    }
    
    public static Debug.ResolvedRule[] appendToArray(final Debug.ResolvedRule[] array, final Debug.ResolvedRule resolvedRule) {
        final Debug.ResolvedRule[] array2 = new Debug.ResolvedRule[1 + array.length];
        System.arraycopy(array, 0, array2, 0, array.length);
        array2[array.length] = resolvedRule;
        return array2;
    }
}

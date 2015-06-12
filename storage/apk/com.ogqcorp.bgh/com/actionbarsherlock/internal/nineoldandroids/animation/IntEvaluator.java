// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.nineoldandroids.animation;

public class IntEvaluator implements TypeEvaluator<Integer>
{
    @Override
    public Integer evaluate(final float n, final Integer n2, final Integer n3) {
        final int intValue = n2;
        return (int)(intValue + n * (n3 - intValue));
    }
}

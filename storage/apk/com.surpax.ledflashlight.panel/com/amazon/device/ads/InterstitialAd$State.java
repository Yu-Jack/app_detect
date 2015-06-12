// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

enum InterstitialAd$State
{
    DISMISSED("DISMISSED", 4), 
    LOADING("LOADING", 1), 
    READY_TO_LOAD("READY_TO_LOAD", 0), 
    READY_TO_SHOW("READY_TO_SHOW", 2), 
    SHOWING("SHOWING", 3);
    
    private InterstitialAd$State(final String name, final int ordinal) {
    }
}

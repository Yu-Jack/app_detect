// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;

public final class a
{
    public static Bundle a(final int n, final int n2, final long n3) {
        final Bundle bundle = new Bundle();
        bundle.putInt("min_automatch_players", n);
        bundle.putInt("max_automatch_players", n2);
        bundle.putLong("exclusive_bit_mask", n3);
        return bundle;
    }
}

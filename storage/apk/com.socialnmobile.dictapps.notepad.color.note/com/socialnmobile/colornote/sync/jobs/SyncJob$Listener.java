// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.sync.jobs;

import com.socialnmobile.colornote.sync.errors.UnsupportedClientVersion$Listener;

public interface SyncJob$Listener extends UnsupportedClientVersion$Listener, AuthRequiredJob$Listener
{
    void onProgress(int p0, int p1);
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.google.tagmanager;

import java.io.IOException;
import com.google.tagmanager.protobuf.nano.MessageNano;
import com.google.analytics.containertag.proto.Debug;
import com.google.android.gms.common.util.VisibleForTesting;

class CtfeDebugInformationHandler implements DebugInformationHandler
{
    @VisibleForTesting
    static final String CTFE_URL_PATH_PREFIX = "/d?";
    @VisibleForTesting
    static final int NUM_EVENTS_PER_SEND = 1;
    private int currentDebugEventNumber;
    private NetworkClient mClient;
    private CtfeHost mCtfeHost;
    private Debug.DebugEvents mDebugEvents;
    
    public CtfeDebugInformationHandler(final CtfeHost ctfeHost) {
        this(new NetworkClientFactory().createNetworkClient(), ctfeHost);
    }
    
    CtfeDebugInformationHandler(final NetworkClient mClient, final CtfeHost mCtfeHost) {
        this.mCtfeHost = mCtfeHost;
        this.mClient = mClient;
        this.mDebugEvents = new Debug.DebugEvents();
    }
    
    private byte[] getDebugEventsAsBytes() throws IOException {
        return MessageNano.toByteArray(this.mDebugEvents);
    }
    
    private boolean sendDebugInformationtoCtfe() {
        try {
            this.mClient.sendPostRequest(this.mCtfeHost.constructCtfeDebugUrl(this.currentDebugEventNumber++), this.getDebugEventsAsBytes());
            return true;
        }
        catch (IOException ex) {
            Log.e("CtfeDebugInformationHandler: Error sending information to server that handles debug information: " + ex.getMessage());
            return false;
        }
    }
    
    @Override
    public void receiveEventInfo(final Debug.EventInfo eventInfo) {
        synchronized (this) {
            this.mDebugEvents.event = ArrayUtils.appendToArray(this.mDebugEvents.event, eventInfo);
            if (this.mDebugEvents.event.length >= 1 && this.sendDebugInformationtoCtfe()) {
                this.mDebugEvents.clear();
            }
        }
    }
}

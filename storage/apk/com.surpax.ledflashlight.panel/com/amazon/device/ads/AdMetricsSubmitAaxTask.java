// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.os.AsyncTask;

class AdMetricsSubmitAaxTask extends AsyncTask
{
    private static final String LOG_TAG = "AdMetricsSubmitTask";
    
    public Void doInBackground(final WebRequest... array) {
        final int length = array.length;
        int i = 0;
    Label_0021_Outer:
        while (i < length) {
            final WebRequest webRequest = array[i];
            while (true) {
                try {
                    webRequest.makeCall();
                    ++i;
                    continue Label_0021_Outer;
                }
                catch (WebRequest$WebRequestException ex) {
                    switch (ex.getStatus()) {
                        default: {
                            continue;
                        }
                        case INVALID_CLIENT_PROTOCOL: {
                            Log.e("AdMetricsSubmitTask", "Unable to submit metrics for ad due to an Invalid Client Protocol, msg: %s", ex.getMessage());
                            continue;
                        }
                        case NETWORK_FAILURE: {
                            Log.e("AdMetricsSubmitTask", "Unable to submit metrics for ad due to Network Failure, msg: %s", ex.getMessage());
                            continue;
                        }
                        case MALFORMED_URL: {
                            Log.e("AdMetricsSubmitTask", "Unable to submit metrics for ad due to a Malformed Pixel URL, msg: %s", ex.getMessage());
                        }
                        case UNSUPPORTED_ENCODING: {
                            Log.e("AdMetricsSubmitTask", "Unable to submit metrics for ad because of unsupported character encoding, msg: %s", ex.getMessage());
                            continue;
                        }
                    }
                }
                break;
            }
            break;
        }
        return null;
    }
}

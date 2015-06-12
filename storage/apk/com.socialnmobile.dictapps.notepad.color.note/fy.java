import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.location.Location;
import android.location.LocationListener;

// 
// Decompiled by Procyon v0.5.29
// 

final class fy implements LocationListener
{
    final /* synthetic */ fx a;
    
    public fy(final fx a) {
        this.a = a;
    }
    
    public final void onLocationChanged(final Location location) {
        if (location != null) {
            this.a.h = location;
        }
    }
    
    public final void onProviderDisabled(final String s) {
    }
    
    public final void onProviderEnabled(final String s) {
    }
    
    public final void onStatusChanged(final String s, final int n, final Bundle bundle) {
    }
}

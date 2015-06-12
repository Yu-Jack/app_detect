// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v4.content.e;
import org.json.JSONException;
import org.json.JSONObject;
import com.facebook.b.ae;
import android.util.Log;
import java.util.Iterator;
import com.facebook.c.h;
import java.util.Map;
import com.facebook.c.c;
import com.facebook.c.b;
import android.os.Looper;
import java.util.ArrayList;
import com.facebook.b.al;
import java.util.HashSet;
import android.os.Handler;
import java.util.List;
import android.os.Bundle;
import java.util.Date;
import java.util.Set;
import java.io.Serializable;
import com.facebook.b.aj;
import android.content.Context;
import android.os.AsyncTask;

final class be extends AsyncTask
{
    final /* synthetic */ bc a;
    private final String b;
    private final Context c;
    
    public be(final bc a, final String b, final Context context) {
        this.a = a;
        this.b = b;
        this.c = context.getApplicationContext();
    }
    
    private Void a() {
        try {
            bq.a(this.c, this.b);
            return null;
        }
        catch (Exception ex) {
            aj.a("Facebook-publish", ex);
            return null;
        }
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.appsflyer;

import android.content.Intent;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Bundle;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;
import android.content.SharedPreferences$Editor;
import android.content.SharedPreferences;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;
import android.database.Cursor;
import android.util.Log;
import android.content.ContentResolver;
import android.net.Uri;
import android.content.BroadcastReceiver;
import android.content.Context;

final class b implements Runnable
{
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;
    
    private b(final Context a, final String e) {
        this.a = a;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = e;
    }
    
    @Override
    public final void run() {
        b(this.a, this.b, this.c, this.d, this.e);
    }
}

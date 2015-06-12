// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.activity;

import android.os.Bundle;
import android.content.Context;
import java.util.ArrayList;
import android.app.Activity;
import android.net.Uri;
import android.content.Intent;
import com.ogqcorp.bgh.system.l;
import com.ogqcorp.bgh.item.Background;
import com.ogqcorp.bgh.activity.a.a;

public final class SchemeActivity extends a
{
    private static String a;
    private static Background b;
    
    private void a() {
        try {
            final Intent intent = this.getIntent();
            if (!intent.getAction().equals("android.intent.action.VIEW")) {
                return;
            }
            final Uri data = intent.getData();
            SchemeActivity.a = data.getHost();
            if (SchemeActivity.a.equals("background")) {
                this.a(data);
            }
        }
        catch (Exception ex) {
            l.b(ex);
        }
    }
    
    public static void a(final Activity activity) {
        if ("background".equals(SchemeActivity.a)) {
            final ArrayList<Background> list = new ArrayList<Background>();
            list.add(SchemeActivity.b);
            activity.startActivity(BackgroundActivity.a((Context)activity, list, 0));
        }
        c();
    }
    
    private void a(final Uri uri) {
        (SchemeActivity.b = new Background()).setId(Integer.valueOf(uri.getQueryParameter("id")));
    }
    
    private void b() {
        this.startActivity(SplashActivity.a((Context)this));
    }
    
    private static void c() {
        SchemeActivity.a = null;
        SchemeActivity.b = null;
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.a();
        this.b();
        this.finish();
    }
}

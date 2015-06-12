// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.app.Dialog;
import android.database.Cursor;
import android.net.Uri;
import android.content.Context;
import android.widget.Toast;
import android.content.ContentUris;
import android.os.Bundle;
import android.content.Intent;
import android.content.DialogInterface$OnCancelListener;

public class SendToNoteByTitle extends ThemeActivity
{
    public String a;
    DialogInterface$OnCancelListener b;
    
    public SendToNoteByTitle() {
        this.b = (DialogInterface$OnCancelListener)new im(this);
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.a();
        final Uri data = this.getIntent().getData();
        final boolean startsWith = data.getPath().startsWith("/tempnotes");
        final Cursor query = this.getContentResolver().query(data, (String[])null, (String)null, (String[])null, (String)null);
        long long1;
        if (query != null && query.moveToFirst()) {
            long1 = query.getLong(query.getColumnIndex("_id"));
        }
        else {
            long1 = 0L;
        }
        if (query != null) {
            query.close();
        }
        if (long1 != 0L) {
            Uri uri;
            if (startsWith) {
                uri = ContentUris.withAppendedId(kf.d, long1);
            }
            else {
                uri = ContentUris.withAppendedId(kf.a, long1);
            }
            final Intent intent = new Intent("android.intent.action.VIEW", uri);
            intent.putExtra("EXTRA_VIEW_FROM", "NOTE");
            this.startActivity(intent);
            this.finish();
            return;
        }
        if (startsWith || data.getPathSegments().size() < 3) {
            Toast.makeText((Context)this, 2131230842, 1).show();
            this.finish();
            return;
        }
        this.a = (String)data.getPathSegments().get(2);
        final Dialog a = rh.a((Context)this, new in(this), null).a((Context)this);
        a.setOnCancelListener(this.b);
        a.show();
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.appwidget.AppWidgetProviderInfo;
import com.socialnmobile.colornote.fragment.ArchiveFragment;
import android.appwidget.AppWidgetManager;
import android.os.Bundle;
import android.content.ContentUris;
import android.net.Uri;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import com.socialnmobile.colornote.ColorNote;
import android.content.ContentValues;
import android.view.animation.AnimationUtils;
import android.content.Context;
import android.content.DialogInterface$OnCancelListener;
import android.view.View;
import android.app.Dialog;
import android.support.v4.app.Fragment;

public class NoteWidgetConfigure extends ThemeFragmentActivity implements rb
{
    Fragment n;
    public Dialog o;
    public View p;
    DialogInterface$OnCancelListener q;
    private int r;
    private int s;
    
    public NoteWidgetConfigure() {
        this.q = (DialogInterface$OnCancelListener)new hz(this);
    }
    
    public final void a(final long l) {
        if (l < 0L) {
            final Dialog a = rh.a((Context)this, new ia(this), null).a((Context)this);
            a.setOnCancelListener(this.q);
            (this.o = a).show();
            this.p.setVisibility(4);
            this.p.startAnimation(AnimationUtils.loadAnimation((Context)this, 17432577));
            return;
        }
        final ka a2 = ka.a((Context)this);
        final int r = this.r;
        final int s = this.s;
        final SQLiteDatabase writableDatabase = a2.a.getWritableDatabase();
        final ContentValues contentValues = new ContentValues();
        contentValues.put("_id", r);
        contentValues.put("note_id", l);
        contentValues.put("widget_type", s);
        if (writableDatabase.insert("widget", (String)null, contentValues) == -1L) {
            writableDatabase.update("widget", contentValues, "_id = ?", new String[] { String.valueOf(r) });
            ColorNote.a();
        }
        final kn kn = new kn();
        kn.a = this.r;
        kn.b = this.s;
        rq.a((Context)this, new kn[] { kn });
        final Intent intent = new Intent();
        intent.putExtra("appWidgetId", this.r);
        this.setResult(-1, intent);
        this.finish();
    }
    
    @Override
    public final void a(final rc rc) {
    }
    
    @Override
    public final boolean a(final Fragment fragment) {
        return true;
    }
    
    @Override
    public final abi e() {
        return null;
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        if (n == 1 && n2 == -1) {
            this.a(ContentUris.parseId(Uri.parse(intent.getAction())));
        }
        else {
            this.p.setVisibility(0);
            this.p.startAnimation(AnimationUtils.loadAnimation((Context)this, 17432576));
        }
        super.onActivityResult(n, n2, intent);
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        int s = 2;
        super.onCreate(bundle);
        this.a(s, null);
        this.setContentView(2130903045);
        final Bundle extras = this.getIntent().getExtras();
        this.p = this.findViewById(2131623959);
        if (extras != null) {
            this.r = extras.getInt("appWidgetId", 0);
            final AppWidgetProviderInfo appWidgetInfo = AppWidgetManager.getInstance((Context)this).getAppWidgetInfo(this.r);
            if (appWidgetInfo != null) {
                final String className = appWidgetInfo.provider.getClassName();
                if ("com.socialnmobile.colornote.receiver.NoteWidget".equals(className)) {
                    s = 1;
                }
                else if (!"com.socialnmobile.colornote.receiver.NoteWidget2x2".equals(className)) {
                    throw new RuntimeException("Invalid Widget Name");
                }
                this.s = s;
            }
        }
        if (this.r == 0 || this.s == 0) {
            this.finish();
        }
        else {
            this.n = super.b.a(2131623937);
            if (this.n == null) {
                this.n = ArchiveFragment.b();
                final u a = super.b.a();
                a.b(2131623937, this.n);
                a.a(0);
                a.b();
            }
        }
    }
}

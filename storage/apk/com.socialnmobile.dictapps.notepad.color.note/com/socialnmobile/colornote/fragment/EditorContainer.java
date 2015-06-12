// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.data.NoteProvider;
import android.view.View;
import android.view.LayoutInflater;
import android.os.Parcelable;
import android.os.Bundle;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;
import android.app.Activity;
import android.net.Uri;
import android.database.Cursor;
import android.support.v4.app.Fragment;

public class EditorContainer extends Fragment
{
    Cursor a;
    Uri b;
    String c;
    Activity d;
    private AbstractEditorViewer e;
    
    private void J() {
        Toast.makeText((Context)super.C, 2131230840, 1).show();
        this.a(0, (Intent)null);
    }
    
    public static EditorContainer b(final Intent intent) {
        final EditorContainer editorContainer = new EditorContainer();
        final Bundle bundle = new Bundle();
        bundle.putParcelable("INTENT", (Parcelable)intent);
        editorContainer.e(bundle);
        return editorContainer;
    }
    
    public final Cursor I() {
        return this.a;
    }
    
    @Override
    public final View a(final LayoutInflater layoutInflater, final Bundle bundle) {
        return null;
    }
    
    public final void a(final int n, final Intent intent) {
        super.C.setResult(n, intent);
        super.C.finish();
    }
    
    @Override
    public final void a(final Activity d) {
        super.a(d);
        this.d = d;
    }
    
    @Override
    public final void a(final Bundle bundle) {
        super.a(bundle);
        final Intent intent = (Intent)super.q.getParcelable("INTENT");
        final String action = intent.getAction();
        Uri b;
        if (bundle != null) {
            final String string = bundle.getString("uri");
            if (string != null) {
                final Uri parse = Uri.parse(string);
                this.b = parse;
                b = parse;
            }
            else {
                b = null;
            }
        }
        else {
            final String action2 = intent.getAction();
            final Uri data = intent.getData();
            if ("android.intent.action.EDIT".equals(action2)) {
                this.b = data;
            }
            else if ("android.intent.action.VIEW".equals(action2) && data != null && "content".equals(data.getScheme())) {
                this.b = data;
                this.c = intent.getStringExtra("EXTRA_VIEW_FROM");
            }
            else if ("android.intent.action.INSERT".equals(action2)) {
                if (NoteProvider.a(data) == 2) {
                    this.b = data;
                }
                else {
                    final String stringExtra = intent.getStringExtra("android.intent.extra.SUBJECT");
                    final String stringExtra2 = intent.getStringExtra("android.intent.extra.TEXT");
                    int n;
                    if (stringExtra2 != null) {
                        n = yg.c(stringExtra2);
                    }
                    else {
                        n = intent.getIntExtra("socialnmobile.intent.extra.TYPE", 0);
                    }
                    this.b = kg.a((Context)this.d, 0, n, intent.getIntExtra("socialnmobile.intent.extra.FOLDER", 0), intent.getIntExtra("socialnmobile.intent.extra.COLOR", jp.a((Context)this.d, "pref_default_color", 3)), stringExtra, stringExtra2);
                }
                if (intent.hasExtra("socialnmobile.intent.extra.REMINDER_DATE")) {
                    kg.a((Context)this.d, this.b, intent.getLongExtra("socialnmobile.intent.extra.REMINDER_DATE", 0L), intent.getIntExtra("socialnmobile.intent.extra.REMINDER_TYPE", 16), 0, 0L, true);
                }
            }
            b = this.b;
        }
        if (b == null || !b.getAuthority().equals("note.socialnmobile.provider.colornote")) {
            this.J();
        }
        else {
            this.a = this.d.managedQuery(this.b, (String[])null, (String)null, (String[])null, (String)null);
            final Cursor a = this.a;
            if (a == null) {
                this.J();
                return;
            }
            if (!a.moveToFirst()) {
                this.J();
                return;
            }
            final int columnIndex = a.getColumnIndex("type");
            final int columnIndex2 = a.getColumnIndex("note_type");
            final int columnIndex3 = a.getColumnIndex("encrypted");
            if (columnIndex == -1) {
                this.J();
                return;
            }
            final int int1 = a.getInt(columnIndex);
            final int int2 = a.getInt(columnIndex2);
            final int int3 = a.getInt(columnIndex3);
            int n2;
            if (int1 != 0 && int1 != 16 && int1 != 256) {
                n2 = 0;
            }
            else if (int2 > 0) {
                n2 = 0;
            }
            else if (int3 != 0 && int3 != 1 && int3 != 2) {
                n2 = 0;
            }
            else {
                n2 = 1;
            }
            if (n2 == 0) {
                Toast.makeText((Context)super.C, 2131231068, 1).show();
                this.a(5000, (Intent)null);
                return;
            }
            this.e = (AbstractEditorViewer)super.C.d().a(2131623953);
            if (this.e == null) {
                this.e = AbstractEditorViewer.a(int1, action, b, this.c);
                if (this.e == null) {
                    this.J();
                    return;
                }
                this.e.a(this);
                final u a2 = super.C.d().a();
                a2.b(2131623953, this.e);
                a2.a(0);
                a2.b();
            }
        }
    }
    
    public final AbstractEditorViewer b() {
        return this.e;
    }
    
    public final void b(final int n) {
        this.a(n, (Intent)null);
    }
    
    @Override
    public final void d(final Bundle bundle) {
        super.d(bundle);
        if (this.b != null) {
            bundle.putString("uri", this.b.toString());
        }
    }
}

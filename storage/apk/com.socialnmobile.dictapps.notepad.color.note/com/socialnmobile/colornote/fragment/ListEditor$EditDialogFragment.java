// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.fragment;

import android.widget.Adapter;
import java.util.Locale;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.AdapterView$AdapterContextMenuInfo;
import android.view.ContextMenu$ContextMenuInfo;
import android.view.ContextMenu;
import com.socialnmobile.colornote.dialog.DialogFactory;
import android.widget.Toast;
import android.text.ClipboardManager;
import com.socialnmobile.colornote.ColorNote;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.view.View$OnCreateContextMenuListener;
import android.support.v4.app.FragmentActivity;
import com.socialnmobile.colornote.menu.TopBarSubMenuInfo;
import android.app.Activity;
import android.widget.TextView$OnEditorActionListener;
import android.graphics.drawable.Drawable;
import java.util.Comparator;
import java.util.Collections;
import java.util.Iterator;
import android.widget.ListAdapter;
import java.util.List;
import android.widget.AdapterView$OnItemClickListener;
import android.view.View$OnClickListener;
import android.graphics.drawable.GradientDrawable;
import java.util.ArrayList;
import android.widget.TextView;
import com.socialnmobile.colornote.view.DragDropListView;
import android.widget.ListView;
import android.content.DialogInterface;
import android.view.inputmethod.InputMethodManager;
import android.view.View;
import android.content.DialogInterface$OnClickListener;
import android.os.Build;
import android.os.Build$VERSION;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.content.Context;
import android.app.AlertDialog$Builder;
import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.widget.EditText;
import android.support.v4.app.DialogFragment;

public class ListEditor$EditDialogFragment extends DialogFragment
{
    boolean Y;
    public EditText Z;
    public boolean aa;
    String ab;
    
    public static ListEditor$EditDialogFragment a(final boolean b, final String ab, final ListEditor listEditor) {
        final ListEditor$EditDialogFragment listEditor$EditDialogFragment = new ListEditor$EditDialogFragment();
        final Bundle bundle = new Bundle();
        bundle.putBoolean("additem", b);
        listEditor$EditDialogFragment.e(bundle);
        listEditor$EditDialogFragment.a(listEditor);
        listEditor$EditDialogFragment.ab = ab;
        return listEditor$EditDialogFragment;
    }
    
    public final String I() {
        return this.Z.getText().toString().trim();
    }
    
    @Override
    public final void a(final Bundle bundle) {
        super.a(bundle);
        this.o();
        if (super.q != null) {
            this.Y = super.q.getBoolean("additem");
        }
        if (bundle != null) {
            this.a(false);
        }
    }
    
    @Override
    public final Dialog b() {
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)super.C);
        Object o = jk.a(alertDialog$Builder);
        if (o == null) {
            o = super.C;
        }
        final View inflate = LayoutInflater.from((Context)o).inflate(2130903053, (ViewGroup)null);
        if (!jp.q((Context)o)) {
            jk.a(inflate);
        }
        this.Z = (EditText)inflate.findViewById(2131624032);
        if (Build$VERSION.SDK_INT == 15 && Build.BRAND.equals("NOOK") && jp.p((Context)super.C) == 1) {
            this.Z.setTextColor(-16777216);
        }
        this.Z.setText((CharSequence)this.ab);
        this.Z.setSelection(this.Z.length());
        if (this.Y) {
            alertDialog$Builder.setTitle(2131230769);
        }
        else {
            alertDialog$Builder.setTitle(2131230770);
        }
        final ListEditor listEditor = (ListEditor)super.r;
        alertDialog$Builder.setView(inflate);
        alertDialog$Builder.setPositiveButton(17039370, (DialogInterface$OnClickListener)new of(this, listEditor));
        if (this.Y) {
            alertDialog$Builder.setNeutralButton(2131230864, (DialogInterface$OnClickListener)new og(this, listEditor));
        }
        alertDialog$Builder.setNegativeButton(17039360, (DialogInterface$OnClickListener)new oh(this, listEditor));
        return (Dialog)alertDialog$Builder.create();
    }
    
    @Override
    public final void c() {
        super.c();
        final ListEditor listEditor = (ListEditor)super.r;
        listEditor.ar = false;
        listEditor.as = this;
        super.f.getWindow().setSoftInputMode(36);
        this.Z.postDelayed((Runnable)new oi(this), 100L);
    }
    
    @Override
    public final void d() {
        if (this.aa) {
            ((InputMethodManager)super.C.getSystemService("input_method")).hideSoftInputFromInputMethod(this.Z.getApplicationWindowToken(), 1);
        }
        final ListEditor listEditor = (ListEditor)super.r;
        if (!listEditor.ar && super.f != null) {
            super.f.dismiss();
            listEditor.ar = true;
        }
        super.d();
    }
    
    @Override
    public void onCancel(final DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        final ListEditor listEditor = (ListEditor)super.r;
        listEditor.a(ListEditor.a(listEditor), this.I());
        listEditor.ar = true;
    }
}

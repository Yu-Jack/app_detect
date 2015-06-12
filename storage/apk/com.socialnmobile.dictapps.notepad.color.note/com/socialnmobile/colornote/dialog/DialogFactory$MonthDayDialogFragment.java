// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.dialog;

import android.app.Dialog;
import android.text.format.DateUtils;
import android.widget.ListView;
import android.support.v4.app.FragmentActivity;
import android.view.View$OnCreateContextMenuListener;
import android.widget.ListAdapter;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import java.util.List;
import android.content.Context;
import android.text.format.Time;
import java.util.ArrayList;
import com.socialnmobile.colornote.fragment.CalendarFragment;
import android.app.AlertDialog;
import android.support.v4.app.DialogFragment;

public class DialogFactory$MonthDayDialogFragment extends DialogFragment
{
    AlertDialog Y;
    
    public DialogFactory$MonthDayDialogFragment(final CalendarFragment onCreateContextMenuListener, final ArrayList list, final Time time) {
        final FragmentActivity c = onCreateContextMenuListener.C;
        final aal a = aal.a((Context)c, new ArrayList(), 5, false);
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)c);
        alertDialog$Builder.setIcon(2130837584);
        alertDialog$Builder.setTitle(2131230786);
        if (jn.a()) {
            alertDialog$Builder.setPositiveButton(((Context)c).getText(2131230865), (DialogInterface$OnClickListener)new lk(onCreateContextMenuListener));
            alertDialog$Builder.setNegativeButton(((Context)c).getText(2131230864), (DialogInterface$OnClickListener)new ll(onCreateContextMenuListener));
        }
        else {
            alertDialog$Builder.setPositiveButton(((Context)c).getText(2131230864), (DialogInterface$OnClickListener)new lm(onCreateContextMenuListener));
            alertDialog$Builder.setNegativeButton(((Context)c).getText(2131230865), (DialogInterface$OnClickListener)new ln(onCreateContextMenuListener));
        }
        alertDialog$Builder.setNeutralButton(((Context)c).getText(2131230854), (DialogInterface$OnClickListener)new lo(onCreateContextMenuListener));
        alertDialog$Builder.setAdapter((ListAdapter)a, (DialogInterface$OnClickListener)new lp(onCreateContextMenuListener));
        final AlertDialog create = alertDialog$Builder.create();
        create.setCanceledOnTouchOutside(true);
        final ListView listView = create.getListView();
        listView.setAdapter((ListAdapter)a);
        listView.setDivider(onCreateContextMenuListener.C.getResources().getDrawable(2130837553));
        final int dimensionPixelSize = onCreateContextMenuListener.C.getResources().getDimensionPixelSize(2131361798);
        listView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        listView.setSelector(2130837654);
        listView.setDrawSelectorOnTop(true);
        listView.setBackgroundColor(gr.a((Context)c).n(3));
        create.getWindow().clearFlags(2);
        this.Y = create;
        this.Y.getListView().setOnCreateContextMenuListener((View$OnCreateContextMenuListener)onCreateContextMenuListener);
        this.o();
        if (list != null && time != null) {
            this.a(list, time);
        }
    }
    
    public final void a(final ArrayList list, final Time time) {
        final AlertDialog y = this.Y;
        y.setTitle((CharSequence)DateUtils.formatDateTime(y.getContext(), jk.a(time, true), 32786));
        ((aal)y.getListView().getAdapter()).a(list, time);
    }
    
    @Override
    public final Dialog b() {
        return (Dialog)this.Y;
    }
    
    @Override
    public final void w() {
        super.w();
        this.a(false);
    }
}

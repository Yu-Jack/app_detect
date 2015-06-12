// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons.a;

import android.widget.AdapterView;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.view.LayoutInflater;
import android.app.AlertDialog;
import android.widget.AdapterView$OnItemClickListener;
import android.view.ViewGroup;
import android.view.View;
import java.util.Iterator;
import android.widget.TextView;
import android.content.Context;
import java.io.File;
import android.widget.ArrayAdapter;

class c extends ArrayAdapter<File>
{
    final /* synthetic */ b a;
    
    public c(final b a, final Context context) {
        this.a = a;
        super(context, g.fcd_inc_row, 0);
        this.b();
    }
    
    private void a(final TextView textView, final File file) {
        textView.setText((CharSequence)this.a.a(file));
    }
    
    private void b() {
        if (this.a.a != null) {
            this.a.a.setTitle((CharSequence)this.a.b());
        }
        this.clear();
        final Iterator<File> iterator = this.a.c.b().iterator();
        while (iterator.hasNext()) {
            this.add((Object)iterator.next());
        }
        this.notifyDataSetChanged();
    }
    
    private void b(final TextView textView, final File file) {
        textView.setCompoundDrawablesWithIntrinsicBounds(this.a.a(file, textView.getTextColors().getDefaultColor() > -8947849), 0, 0, 0);
    }
    
    public void a() {
        this.a.c.c();
        this.b();
    }
    
    public void a(final File file) {
        this.a.c.a(file);
        this.b();
    }
    
    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        final TextView textView = (TextView)super.getView(n, view, viewGroup);
        final File file = (File)this.getItem(n);
        this.a(textView, file);
        this.b(textView, file);
        return (View)textView;
    }
}

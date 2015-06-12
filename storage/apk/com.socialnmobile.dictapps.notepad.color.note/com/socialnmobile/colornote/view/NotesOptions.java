// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.view;

import android.support.v4.app.FragmentActivity;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.content.Context;
import android.view.View$OnClickListener;
import android.widget.TextView;
import android.view.View;
import android.app.Dialog;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import android.widget.RelativeLayout;

public class NotesOptions extends RelativeLayout
{
    public NoteListFragment a;
    public Dialog b;
    public MyViewPager c;
    View[] d;
    TextView[] e;
    View$OnClickListener f;
    aac g;
    
    public NotesOptions(final Context context) {
        super(context, (AttributeSet)null);
        this.d = new View[2];
        this.e = new TextView[2];
        this.f = (View$OnClickListener)new aar(this);
        this.g = new aas(this);
    }
    
    public NotesOptions(final Context context, final AttributeSet set) {
        super(context, set, 0);
        this.d = new View[2];
        this.e = new TextView[2];
        this.f = (View$OnClickListener)new aar(this);
        this.g = new aas(this);
    }
    
    public NotesOptions(final Context context, final AttributeSet set, final int n) {
        super(context, set, n);
        this.d = new View[2];
        this.e = new TextView[2];
        this.f = (View$OnClickListener)new aar(this);
        this.g = new aas(this);
    }
    
    public final void a(final int n) {
        int i = 0;
        final int n2 = gr.a(this.getContext()).n(13);
        final View[] d = this.d;
        for (int length = d.length, j = 0; j < length; ++j) {
            d[j].setVisibility(4);
        }
        this.d[n].setVisibility(0);
        for (TextView[] e = this.e; i < e.length; ++i) {
            final TextView textView = e[i];
            textView.setTextColor(gw.a(85, n2));
            textView.setTypeface(Typeface.DEFAULT);
        }
        this.e[n].setTextColor(n2);
        this.e[n].setTypeface(Typeface.DEFAULT_BOLD);
    }
    
    public final void a(final NoteListFragment a, final Dialog b) {
        this.a = a;
        this.b = b;
        final FragmentActivity h = this.a.h();
        this.c = (MyViewPager)this.findViewById(2131623942);
        this.d[0] = this.findViewById(2131624125);
        this.d[1] = this.findViewById(2131624126);
        this.e[0] = (TextView)this.findViewById(2131624122);
        this.e[1] = (TextView)this.findViewById(2131624123);
        final TextView[] e = this.e;
        for (int length = e.length, i = 0; i < length; ++i) {
            ((View)e[i]).setOnClickListener(this.f);
        }
        this.c.setPageMargin(gw.c((Context)h, 10));
        this.c.setAdapter(new aat(this));
        this.c.setOnPageChangeListener(this.g);
        this.c.setCurrentItem(0);
        this.a(0);
    }
}

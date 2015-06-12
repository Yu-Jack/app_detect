// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.b;

import android.support.v4.app.FragmentActivity;
import com.ogqcorp.commons.c;
import com.ogqcorp.bgh.system.r;
import android.content.Context;
import com.ogqcorp.bgh.system.o;
import java.util.Locale;
import android.os.Parcelable;
import android.os.Bundle;
import com.ogqcorp.bgh.item.Background;
import java.util.ArrayList;
import com.ogqcorp.bgh.item.Author;

public final class a extends d
{
    private Author a;
    private ArrayList<Background> b;
    
    public static a a(final Author author) {
        final a a = new a();
        final Bundle arguments = new Bundle();
        arguments.putParcelable("KEY_AUTHOR", (Parcelable)author);
        a.setArguments(arguments);
        return a;
    }
    
    private String h() {
        return String.format(Locale.US, "AUTHOR_%d", this.a.getId());
    }
    
    @Override
    protected void a() {
        super.a();
        final FragmentActivity activity = this.getActivity();
        if (activity == null) {
            return;
        }
        com.ogqcorp.commons.c.a(activity, 0, this.h(), 43200000L, o.b().f((Context)activity, this.a.getId()), this.e(), r.d, this);
    }
    
    @Override
    protected void a(final ArrayList<Background> b) {
        this.b = b;
    }
    
    @Override
    protected ArrayList<Background> b() {
        return this.b;
    }
    
    @Override
    public void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.a = (Author)this.getArguments().getParcelable("KEY_AUTHOR");
    }
}

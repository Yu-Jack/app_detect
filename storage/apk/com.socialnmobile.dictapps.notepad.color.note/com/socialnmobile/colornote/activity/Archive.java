// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import com.socialnmobile.colornote.fragment.ArchiveFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class Archive extends ThemeFragmentActivity implements rb
{
    Fragment n;
    public abi o;
    ye p;
    
    public Archive() {
        this.p = new gz(this);
    }
    
    @Override
    public final void a(final rc rc) {
        this.o.a(rc);
    }
    
    @Override
    public final boolean a(final Fragment fragment) {
        return true;
    }
    
    @Override
    public final abi e() {
        return this.o;
    }
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903040);
        this.o = new abi(this.findViewById(2131623936));
        final abi o = this.o;
        o.a.findViewById(2131624085).setVisibility(8);
        o.d.setPadding(gw.c(o.a.getContext(), 8), 0, 0, 0);
        this.a(1, this.p);
        this.n = super.b.a(2131623937);
        if (this.n == null) {
            if ("note.socialnmobile.intent.action.VIEW_BACKUP_ARCHIVE".equals(this.getIntent().getAction())) {
                this.n = ArchiveFragment.a(this.getIntent().getLongExtra("EXTRA_BACKUP_TIME", 0L));
            }
            else {
                this.n = new ArchiveFragment();
            }
            final u a = super.b.a();
            a.b(2131623937, this.n);
            a.a(0);
            a.b();
        }
    }
}

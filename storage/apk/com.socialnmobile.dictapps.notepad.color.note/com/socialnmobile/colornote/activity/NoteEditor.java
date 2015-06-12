// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import com.socialnmobile.colornote.fragment.AbstractEditorViewer;
import android.view.KeyEvent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import com.socialnmobile.colornote.fragment.EditorContainer;

public class NoteEditor extends ThemeFragmentActivity
{
    private boolean n;
    private EditorContainer o;
    
    @Override
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.a(1, null);
        this.setContentView(2130903043);
        this.n = false;
        this.o = (EditorContainer)super.b.a("EDITOR_CONTAINER");
        if (this.o == null) {
            this.o = EditorContainer.b(this.getIntent());
            final u a = super.b.a();
            a.a(this.o, "EDITOR_CONTAINER");
            a.b();
        }
    }
    
    @Override
    public boolean onKeyDown(final int n, final KeyEvent keyEvent) {
        if (n == 4) {
            final AbstractEditorViewer b = this.o.b();
            if (b != null && b.U()) {
                return this.n = true;
            }
        }
        return super.onKeyDown(n, keyEvent);
    }
    
    public boolean onKeyUp(final int n, final KeyEvent keyEvent) {
        if (n == 4 && this.n) {
            this.n = false;
            final AbstractEditorViewer b = this.o.b();
            if (b != null && b.U()) {
                b.V();
            }
        }
        return super.onKeyUp(n, keyEvent);
    }
    
    public boolean onSearchRequested() {
        final AbstractEditorViewer b = this.o.b();
        return (b == null || b.T()) && super.onSearchRequested();
    }
}

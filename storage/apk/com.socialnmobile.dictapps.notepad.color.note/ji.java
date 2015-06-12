import android.view.ActionMode$Callback;
import android.widget.TextView;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ji implements jg
{
    @Override
    public final void a(final TextView textView, final yo yo) {
        textView.setCustomSelectionActionModeCallback((ActionMode$Callback)new jj(this, yo));
    }
}

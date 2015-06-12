import android.content.Context;
import android.view.MenuItem;
import android.widget.TextView;

// 
// Decompiled by Procyon v0.5.29
// 

final class zv
{
    public static boolean a(final TextView textView, final MenuItem menuItem) {
        if (menuItem.getItemId() != 2131624178) {
            return false;
        }
        final Context context = textView.getContext();
        try {
            context.startActivity(gw.f(textView.getText().subSequence(textView.getSelectionStart(), textView.getSelectionEnd()).toString()));
            return true;
        }
        catch (IndexOutOfBoundsException ex) {
            return true;
        }
    }
}

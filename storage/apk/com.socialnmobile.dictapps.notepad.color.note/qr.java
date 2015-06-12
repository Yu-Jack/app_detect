import android.view.KeyEvent;
import android.widget.AdapterView;
import android.graphics.drawable.Drawable;
import java.util.Iterator;
import com.socialnmobile.colornote.view.MyImageButton;
import android.widget.FrameLayout;
import android.view.View$MeasureSpec;
import android.widget.ListAdapter;
import android.view.ViewTreeObserver;
import android.view.LayoutInflater;
import android.widget.PopupWindow$OnDismissListener;
import android.widget.AdapterView$OnItemClickListener;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.View$OnKeyListener;
import android.widget.TextView;
import android.widget.ImageView;
import android.view.ViewGroup;
import android.view.View;
import java.util.List;
import java.util.ArrayList;
import android.content.Context;
import android.widget.ArrayAdapter;

// 
// Decompiled by Procyon v0.5.29
// 

final class qr extends ArrayAdapter
{
    final /* synthetic */ qq a;
    private int b;
    private boolean c;
    
    public qr(final qq a, final Context context, final ArrayList list, final boolean c) {
        this.a = a;
        super(context, 0, (List)list);
        this.b = -1;
        this.c = c;
    }
    
    public final View getView(final int n, View inflate, final ViewGroup viewGroup) {
        if (inflate == null) {
            inflate = this.a.b.inflate(2130903092, viewGroup, false);
        }
        final ImageView imageView = (ImageView)inflate.findViewById(2131624093);
        final TextView textView = (TextView)inflate.findViewById(2131624033);
        if (this.c) {
            textView.setTextColor(-16777216);
        }
        else {
            textView.setTextColor(-1);
        }
        final rf rf = (rf)this.getItem(n);
        textView.setText(rf.c);
        if (!rf.e) {
            imageView.setVisibility(8);
            return inflate;
        }
        imageView.setVisibility(0);
        if (rf.g) {
            imageView.setImageDrawable(rf.f);
            return inflate;
        }
        gw.a(imageView.getResources(), imageView, rf.b);
        return inflate;
    }
}

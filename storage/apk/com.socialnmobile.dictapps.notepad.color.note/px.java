import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import android.content.Context;
import com.socialnmobile.colornote.fragment.SideMenuFragment;
import android.widget.ArrayAdapter;

// 
// Decompiled by Procyon v0.5.29
// 

public final class px extends ArrayAdapter
{
    final /* synthetic */ SideMenuFragment a;
    
    public px(final SideMenuFragment a, final Context context, final ArrayList list) {
        this.a = a;
        super(context, 0, (List)list);
    }
    
    public final boolean areAllItemsEnabled() {
        return false;
    }
    
    public final int getItemViewType(final int n) {
        if (((HashMap)this.getItem(n)).get("MENUID") == 0) {
            return 0;
        }
        return 1;
    }
    
    public final View getView(final int n, View view, final ViewGroup viewGroup) {
        final yc a = gr.a(this.getContext());
        if (this.getItemViewType(n) == 0) {
            if (view == null) {
                view = LayoutInflater.from((Context)this.a.h()).inflate(2130903096, viewGroup, false);
            }
            return view;
        }
        if (view == null) {
            view = LayoutInflater.from((Context)this.a.h()).inflate(2130903095, viewGroup, false);
        }
        final TextView textView = (TextView)view.findViewById(2131624033);
        final ImageView imageView = (ImageView)view.findViewById(2131624093);
        final HashMap hashMap = (HashMap)this.getItem(n);
        final String text = hashMap.get("TEXT");
        final Integer n2 = (Integer)hashMap.get("ICON");
        final int intValue = (int)hashMap.get("MENUID");
        final int intValue2 = (int)hashMap.get("TEXTSIZE");
        textView.setText((CharSequence)text);
        gw.a(this.getContext().getResources(), imageView, n2);
        if (this.a.f.f() == intValue) {
            textView.setTextColor(a.a(4));
            view.setBackgroundColor(a.a(5));
        }
        else {
            textView.setTextColor(a.a(3));
            view.setBackgroundColor(0);
        }
        textView.setTextSize((float)intValue2);
        return view;
    }
    
    public final int getViewTypeCount() {
        return 2;
    }
    
    public final boolean isEnabled(final int n) {
        return ((HashMap)this.getItem(n)).get("MENUID") != 0;
    }
}

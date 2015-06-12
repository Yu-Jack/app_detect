// 
// Decompiled by Procyon v0.5.29
// 

package com.actionbarsherlock.internal.widget;

import android.util.Log;
import android.view.View;
import com.actionbarsherlock.R$drawable;
import android.widget.TextView;
import android.os.Build$VERSION;
import android.content.Context;
import android.widget.Toast;

public class IcsToast extends Toast
{
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    private static final String TAG = "Toast";
    
    public IcsToast(final Context context) {
        super(context);
    }
    
    public static Toast makeText(final Context context, final int n, final int n2) {
        return makeText(context, context.getResources().getString(n), n2);
    }
    
    public static Toast makeText(final Context context, final CharSequence text, final int duration) {
        if (Build$VERSION.SDK_INT >= 14) {
            return Toast.makeText(context, text, duration);
        }
        final IcsToast icsToast = new IcsToast(context);
        icsToast.setDuration(duration);
        final TextView view = new TextView(context);
        view.setText(text);
        view.setTextColor(-1);
        view.setGravity(17);
        view.setBackgroundResource(R$drawable.abs__toast_frame);
        icsToast.setView((View)view);
        return icsToast;
    }
    
    public void setText(final CharSequence charSequence) {
        if (Build$VERSION.SDK_INT >= 14) {
            super.setText(charSequence);
        }
        else if (this.getView() != null) {
            try {
                ((TextView)this.getView()).setText(charSequence);
            }
            catch (ClassCastException ex) {
                Log.e("Toast", "This Toast was not created with IcsToast.makeText", (Throwable)ex);
            }
        }
    }
}

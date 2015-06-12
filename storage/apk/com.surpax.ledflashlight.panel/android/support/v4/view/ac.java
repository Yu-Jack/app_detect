// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.view.View;
import android.content.Context;
import java.util.Locale;
import android.text.method.SingleLineTransformationMethod;

final class ac extends SingleLineTransformationMethod
{
    private Locale a;
    
    public ac(final Context context) {
        this.a = context.getResources().getConfiguration().locale;
    }
    
    public final CharSequence getTransformation(final CharSequence charSequence, final View view) {
        final CharSequence transformation = super.getTransformation(charSequence, view);
        if (transformation != null) {
            return transformation.toString().toUpperCase(this.a);
        }
        return null;
    }
}

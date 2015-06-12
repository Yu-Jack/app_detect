// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view;

import android.text.method.TransformationMethod;
import android.widget.TextView;

final class aa implements y
{
    @Override
    public final void a(final TextView textView) {
        textView.setTransformationMethod((TransformationMethod)new ac(textView.getContext()));
    }
}

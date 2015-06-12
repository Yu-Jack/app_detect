import android.util.AttributeSet;
import android.content.Context;
import android.widget.ListView;

// 
// Decompiled by Procyon v0.5.29
// 

final class qu extends ListView
{
    private boolean a;
    private boolean b;
    
    public qu(final Context context, final boolean b) {
        super(context, (AttributeSet)null, 2130771969);
        this.b = b;
        this.setCacheColorHint(0);
    }
    
    public final boolean hasFocus() {
        return this.b || super.hasFocus();
    }
    
    public final boolean hasWindowFocus() {
        return this.b || super.hasWindowFocus();
    }
    
    public final boolean isFocused() {
        return this.b || super.isFocused();
    }
    
    public final boolean isInTouchMode() {
        return (this.b && this.a) || super.isInTouchMode();
    }
}

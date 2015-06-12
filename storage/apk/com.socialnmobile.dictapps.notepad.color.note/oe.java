import java.util.Locale;
import com.socialnmobile.colornote.fragment.ListEditor;
import java.text.Collator;
import java.util.Comparator;

// 
// Decompiled by Procyon v0.5.29
// 

public final class oe implements Comparator
{
    Collator a;
    final /* synthetic */ ListEditor b;
    
    public oe(final ListEditor b) {
        this.b = b;
        (this.a = Collator.getInstance(Locale.getDefault())).setDecomposition(1);
        this.a.setStrength(3);
    }
    
    @Override
    public final int compare(final Object o, final Object o2) {
        return this.a.compare(((jx)o).a, ((jx)o2).a);
    }
}

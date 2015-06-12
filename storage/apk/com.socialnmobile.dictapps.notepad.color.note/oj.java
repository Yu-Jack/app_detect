import com.socialnmobile.colornote.fragment.ListEditor;
import java.util.Comparator;

// 
// Decompiled by Procyon v0.5.29
// 

public final class oj implements Comparator
{
    final /* synthetic */ ListEditor a;
    
    private oj(final ListEditor a) {
        this.a = a;
    }
    
    @Override
    public final int compare(final Object o, final Object o2) {
        return Boolean.valueOf(((jx)o).a()).compareTo(Boolean.valueOf(((jx)o2).a()));
    }
}

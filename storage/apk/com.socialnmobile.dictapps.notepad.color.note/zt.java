import android.view.View;
import android.os.Parcelable;
import android.view.ViewGroup;
import android.database.DataSetObservable;

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class zt
{
    public DataSetObservable e;
    
    public zt() {
        this.e = new DataSetObservable();
    }
    
    public Object a(final ViewGroup viewGroup, final int n) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }
    
    public void a() {
    }
    
    public void a(final Parcelable parcelable, final ClassLoader classLoader) {
    }
    
    public void a(final ViewGroup viewGroup, final int n, final Object o) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }
    
    public void a(final Object o) {
    }
    
    public abstract boolean a(final View p0, final Object p1);
    
    public Parcelable b() {
        return null;
    }
}

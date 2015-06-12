import java.util.NoSuchElementException;
import android.database.Cursor;
import java.util.Iterator;

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class ace implements Iterable, Iterator
{
    protected final Cursor b;
    
    public ace(final Cursor b) {
        this.b = b;
    }
    
    protected abstract Object a();
    
    @Override
    public boolean hasNext() {
        return 1 + this.b.getPosition() < this.b.getCount();
    }
    
    @Override
    public Iterator iterator() {
        this.b.moveToFirst();
        this.b.move(-1);
        return this;
    }
    
    @Override
    public Object next() {
        if (this.b.moveToNext()) {
            return this.a();
        }
        throw new NoSuchElementException();
    }
    
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}

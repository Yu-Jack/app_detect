import java.util.Iterator;
import android.database.Cursor;
import android.content.ContentValues;
import java.util.ArrayList;

// 
// Decompiled by Procyon v0.5.29
// 

public class acl implements ack
{
    final ArrayList a_;
    ContentValues b_;
    Cursor c_;
    
    public acl() {
        this.a_ = new ArrayList();
    }
    
    protected final acj a(final acn acn, final adk adk) {
        return new acj(this.a(acn), adk);
    }
    
    public final ack a(final ack e) {
        this.a_.add(e);
        return e;
    }
    
    protected final acm a(final acn acn) {
        final acm e = new acm(acn);
        this.a_.add(e);
        return e;
    }
    
    @Override
    public final Object b(final Cursor c_) {
        final Iterator<ack> iterator = this.a_.iterator();
        while (iterator.hasNext()) {
            iterator.next().b(c_);
        }
        this.c_ = c_;
        return this;
    }
    
    @Override
    public final Object d(final ContentValues b_) {
        final Iterator<ack> iterator = this.a_.iterator();
        while (iterator.hasNext()) {
            iterator.next().d(b_);
        }
        this.b_ = b_;
        return this;
    }
    
    public final ContentValues v() {
        if (this.b_ != null) {
            return this.b_;
        }
        throw new IllegalStateException();
    }
}

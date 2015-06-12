import com.socialnmobile.colornote.sync.errors.UnexpectedLocalAccountException;
import java.util.concurrent.Callable;

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class tc extends ss
{
    @Override
    public final Callable a(final sf sf, final xm xm, final sl sl, final tt tt) {
        final rt a = sf.a();
        if (a != null) {
            throw new UnexpectedLocalAccountException(a);
        }
        return ss.b(xm, this.a(sl, tt, sf.c(), null), new st(sf));
    }
}

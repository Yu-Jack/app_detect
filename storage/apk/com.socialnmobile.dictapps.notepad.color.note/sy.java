import com.socialnmobile.colornote.sync.errors.UnexpectedLocalAccountException;
import java.util.concurrent.Callable;

// 
// Decompiled by Procyon v0.5.29
// 

public final class sy extends ss
{
    @Override
    public final Callable a(final sf sf, final xm xm, final sl sl, final tt tt) {
        final rt a = sf.a();
        if (a == null) {
            throw new UnexpectedLocalAccountException();
        }
        return ss.b(xm, this.a(sl, tt, sf.c(), a), new su(a));
    }
    
    @Override
    public final xt a(final sl sl, final tt tt, final xj xj, final rv rv) {
        return new xt(ss.c, sl, sl.a(rv, tt), xj, (long)rv.m.c());
    }
}

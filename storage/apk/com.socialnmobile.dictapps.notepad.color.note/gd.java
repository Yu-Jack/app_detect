import java.util.Iterator;

// 
// Decompiled by Procyon v0.5.29
// 

final class gd implements UncaughtExceptionHandler
{
    final /* synthetic */ gc a;
    
    private gd(final gc a) {
        this.a = a;
    }
    
    @Override
    public final void uncaughtException(final Thread thread, final Throwable t) {
        for (final UncaughtExceptionHandler uncaughtExceptionHandler : this.a.b()) {
            try {
                uncaughtExceptionHandler.uncaughtException(thread, t);
            }
            catch (Throwable t2) {}
        }
        final gc a = this.a;
        if (a.a != null) {
            a.a.uncaughtException(thread, t);
        }
    }
}

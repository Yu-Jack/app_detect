import java.util.Date;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ty extends acx
{
    final Date a;
    
    public ty() {
        this.a = new Date(0L);
    }
    
    private String a(final tw tw) {
        synchronized (this) {
            this.a.setTime(tw.a);
            return (String)adc.b.c(this.a);
        }
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

final class qz implements Runnable
{
    final /* synthetic */ qs a;
    
    private qz(final qs a) {
        this.a = a;
    }
    
    @Override
    public final void run() {
        if (this.a.c != null && this.a.c.getCount() > this.a.c.getChildCount() && this.a.c.getChildCount() <= this.a.e) {
            this.a.a.setInputMethodMode(2);
            this.a.a();
        }
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

public abstract class bv
{
    private int a;
    
    public bv(final int a) {
        this.a = a;
    }
    
    @Override
    public boolean equals(final Object o) {
        final boolean equals = o.getClass().getName().equals(this.getClass().getName());
        boolean b = false;
        if (equals) {
            final int a = ((bv)o).a;
            final int a2 = this.a;
            b = false;
            if (a == a2) {
                b = true;
            }
        }
        return b;
    }
}

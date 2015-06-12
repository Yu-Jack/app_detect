// 
// Decompiled by Procyon v0.5.29
// 

public final class aco
{
    public String a;
    public String[] b;
    
    public aco() {
        this(null, (String[])null);
    }
    
    public aco(final String a, final Object... array) {
        this.a = a;
        if (array != null) {
            this.b = new String[array.length];
            for (int i = 0; i < array.length; ++i) {
                this.b[i] = array[i].toString();
            }
            return;
        }
        this.b = null;
    }
    
    public aco(final String a, final String... b) {
        this.a = a;
        this.b = b;
    }
    
    public static aco a(final String str, final aco... array) {
        final StringBuilder sb = new StringBuilder();
        int n = 1;
        int n2 = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i].a != null) {
                if (n != 0) {
                    n = 0;
                }
                else {
                    sb.append(str);
                }
                sb.append('(').append(array[i].a).append(')');
                if (array[i].b != null) {
                    n2 += array[i].b.length;
                }
            }
        }
        final String[] b = new String[n2];
        int j = 0;
        int n3 = 0;
        while (j < array.length) {
            if (array[j].a != null && array[j].b != null) {
                System.arraycopy(array[j].b, 0, b, n3, array[j].b.length);
                n3 += array[j].b.length;
            }
            ++j;
        }
        final aco aco = new aco();
        aco.a = sb.toString();
        aco.b = b;
        return aco;
    }
    
    public final aco a(final aco aco) {
        return a("AND", this, aco);
    }
}

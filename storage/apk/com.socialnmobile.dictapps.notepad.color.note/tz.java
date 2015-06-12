import java.lang.reflect.Field;

// 
// Decompiled by Procyon v0.5.29
// 

public final class tz
{
    public static final tz a;
    public final String b;
    
    static {
        a = new tz("com.socialnmobile.colornote.sync.DevConfigValues");
    }
    
    private tz(final String b) {
        this.b = b;
    }
    
    private Field b(final String name) {
        return this.getClass().getClassLoader().loadClass(this.b).getDeclaredField(name);
    }
    
    public final Object a(final String s, final Object o) {
        try {
            return this.b(s).get(null);
        }
        catch (IllegalArgumentException ex) {
            ex.printStackTrace();
            return o;
        }
        catch (IllegalAccessException ex2) {
            ex2.printStackTrace();
            return o;
        }
        catch (NoSuchFieldException ex3) {
            return o;
        }
        catch (ClassNotFoundException ex4) {
            return o;
        }
    }
    
    public final boolean a(final String s) {
        try {
            return this.b(s).getBoolean(null);
        }
        catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }
        catch (IllegalAccessException ex2) {
            ex2.printStackTrace();
            goto Label_0021;
        }
        catch (NoSuchFieldException ex3) {
            goto Label_0021;
        }
        catch (ClassNotFoundException ex4) {
            goto Label_0021;
        }
    }
}

import org.json.JSONException;
import org.json.JSONTokener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class add extends acx
{
    public static final add a;
    
    static {
        a = new add();
    }
    
    private static Object b(final String s) {
        final JSONTokener jsonTokener = new JSONTokener(s);
        try {
            return jsonTokener.nextValue();
        }
        catch (JSONException ex) {
            throw new ux((Throwable)ex);
        }
    }
}

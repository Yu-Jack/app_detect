// 
// Decompiled by Procyon v0.5.29
// 

package android.support.v4.view.a;

import android.os.Bundle;
import java.util.List;
import android.os.Build$VERSION;

public class j
{
    private static final k a;
    private final Object b;
    
    static {
        if (Build$VERSION.SDK_INT >= 19) {
            a = new m();
            return;
        }
        if (Build$VERSION.SDK_INT >= 16) {
            a = new l();
            return;
        }
        a = new n();
    }
    
    public j() {
        this.b = j.a.a(this);
    }
    
    public j(final Object b) {
        this.b = b;
    }
    
    public a a(final int n) {
        return null;
    }
    
    public Object a() {
        return this.b;
    }
    
    public List<a> a(final String s, final int n) {
        return null;
    }
    
    public boolean a(final int n, final int n2, final Bundle bundle) {
        return false;
    }
    
    public a b(final int n) {
        return null;
    }
}

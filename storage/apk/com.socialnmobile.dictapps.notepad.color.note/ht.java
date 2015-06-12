import java.util.Iterator;
import android.content.SharedPreferences$Editor;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.preference.PreferenceManager;
import com.socialnmobile.colornote.activity.Main;

// 
// Decompiled by Procyon v0.5.29
// 

public final class ht implements rg
{
    final /* synthetic */ Main a;
    
    public ht(final Main a) {
        this.a = a;
    }
    
    @Override
    public final boolean a(final int n, final String s) {
        final SharedPreferences$Editor edit = PreferenceManager.getDefaultSharedPreferences((Context)this.a).edit();
        edit.putString("PREF_THEME", s);
        edit.commit();
        gr.b((Context)this.a);
        rq.a((Context)this.a);
        rq.b((Context)this.a);
        this.a.l();
        this.a.z.b();
        if (this.a.q instanceof nc) {
            ((nc)this.a.q).J();
        }
        for (final Fragment fragment : ((zq)this.a.r.a()).b) {
            if (fragment != null && fragment.l() && fragment instanceof nc) {
                ((nc)fragment).J();
            }
        }
        this.a.j();
        return true;
    }
}

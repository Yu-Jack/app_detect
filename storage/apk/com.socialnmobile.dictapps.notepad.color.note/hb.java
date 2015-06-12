import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.activity.BackupLocal;

// 
// Decompiled by Procyon v0.5.29
// 

public final class hb implements lh
{
    final /* synthetic */ BackupLocal a;
    
    public hb(final BackupLocal a) {
        this.a = a;
    }
    
    @Override
    public final boolean a(final String s) {
        if (this.a.e) {
            return true;
        }
        if (this.a.a(s, this.a.d.e, this.a.d.f)) {
            ColorNote.a(this.a.getApplicationContext(), "BACKUP", "VIEW");
            final BackupLocal a = this.a;
            final BackupLocal a2 = this.a;
            new hk(a, s, this.a.d, 0).execute((Object[])new String[0]);
            return true;
        }
        return false;
    }
}

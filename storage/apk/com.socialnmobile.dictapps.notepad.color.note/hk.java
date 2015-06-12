import android.widget.Toast;
import android.content.Context;
import android.content.Intent;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.activity.BackupLocal;
import android.os.AsyncTask;

// 
// Decompiled by Procyon v0.5.29
// 

public final class hk extends AsyncTask implements hj
{
    int a;
    String b;
    int c;
    jv d;
    final /* synthetic */ BackupLocal e;
    
    hk(final BackupLocal e, final String b, final jv d, final int c) {
        this.e = e;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public final void a(final int a) {
        this.a = a;
    }
    
    public final void b(final int i) {
        this.publishProgress((Object[])new Integer[] { i });
    }
    
    protected final void onPreExecute() {
        this.e.e = true;
        this.e.a();
    }
}

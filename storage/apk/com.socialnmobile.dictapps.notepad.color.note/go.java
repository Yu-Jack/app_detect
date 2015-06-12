import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;

// 
// Decompiled by Procyon v0.5.29
// 

public final class go
{
    private static go b;
    int a;
    
    public static go a() {
        if (go.b == null) {
            go.b = new go();
        }
        return go.b;
    }
    
    public final void a(final Context context, final int n, final long n2, final PendingIntent pendingIntent) {
        final AlarmManager alarmManager = (AlarmManager)context.getSystemService("alarm");
        alarmManager.cancel(pendingIntent);
        alarmManager.set(n, n2, pendingIntent);
        this.b();
    }
    
    public final void a(final Context context, final long n, final PendingIntent pendingIntent) {
        final AlarmManager alarmManager = (AlarmManager)context.getSystemService("alarm");
        alarmManager.cancel(pendingIntent);
        jk.a(alarmManager, n, pendingIntent);
        this.b();
    }
    
    public final void b() {
        ++this.a;
        if (this.a == 450) {
            adl.a.a("ALARM SET EXCEED 450!!");
        }
        if (this.a == 2000) {
            adl.a.a("ALARM SET EXCEED 2000!!??");
        }
    }
}

import android.database.Cursor;
import com.socialnmobile.colornote.view.ScreenCalendar;
import android.content.Context;
import android.text.format.Time;

// 
// Decompiled by Procyon v0.5.29
// 

public final class aaz extends ad
{
    Time u;
    pg v;
    
    public aaz(final Context context, final ScreenCalendar screenCalendar) {
        super(context);
        this.v = screenCalendar.f;
        this.u = screenCalendar.e();
    }
    
    @Override
    public final Cursor e() {
        final pg v = this.v;
        final Context o = super.o;
        final Time u = this.u;
        final int c = this.v.c;
        final Time time = new Time();
        final Time time2 = new Time();
        time.set(u);
        time.monthDay = 1;
        jk.a(time);
        time2.set(time);
        ++time2.month;
        ++time2.monthDay;
        jk.a(time2);
        --time.monthDay;
        jk.a(time);
        gw.a(time);
        gw.a(time2);
        final long a = jk.a(time2, true);
        final long a2 = jk.a(time, true);
        String string = "";
        if (c > 0) {
            string = " AND color_index = " + c;
        }
        v.a = o.getContentResolver().query(kf.a, (String[])null, "(reminder_repeat = 0 AND reminder_base < " + a + " AND reminder_base > " + a2 + " AND space = 0 AND active_state = 0" + string + ") OR (reminder_repeat <> 0 AND reminder_base < " + a + " AND reminder_date <> 0 AND space = 0 AND active_state = 0" + string + ") OR (reminder_repeat <> 0 AND reminder_base < " + a + " AND reminder_last > " + a2 + " AND space = 0 AND active_state = 0" + string + ")", (String[])null, (String)null);
        return this.v.a;
    }
}

import com.socialnmobile.colornote.view.ScreenCalendar;
import android.text.format.Time;
import android.widget.DatePicker;
import com.socialnmobile.colornote.fragment.CalendarFragment;
import android.app.DatePickerDialog$OnDateSetListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class mz implements DatePickerDialog$OnDateSetListener
{
    final /* synthetic */ CalendarFragment a;
    
    public mz(final CalendarFragment a) {
        this.a = a;
    }
    
    public final void onDateSet(final DatePicker datePicker, final int year, final int month, final int n) {
        final Time time = new Time();
        time.year = year;
        time.month = month;
        time.monthDay = 1;
        jk.a(time);
        final ScreenCalendar s = this.a.S();
        s.setMonth(time);
        this.a.c = time;
        s.c();
    }
}

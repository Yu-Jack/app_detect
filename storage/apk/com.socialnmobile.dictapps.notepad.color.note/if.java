import android.widget.DatePicker;
import com.socialnmobile.colornote.activity.ReminderSettings;
import android.app.DatePickerDialog$OnDateSetListener;

// 
// Decompiled by Procyon v0.5.29
// 

public final class if implements DatePickerDialog$OnDateSetListener
{
    final /* synthetic */ ReminderSettings a;
    
    public if(final ReminderSettings a) {
        this.a = a;
    }
    
    public final void onDateSet(final DatePicker datePicker, final int year, final int month, final int monthDay) {
        this.a.e.year = year;
        this.a.e.month = month;
        this.a.e.monthDay = monthDay;
        this.a.e.hour = 23;
        this.a.e.minute = 59;
        this.a.e.second = 59;
        this.a.f = jk.a(this.a.e);
        this.a.c.set(this.a.f);
        this.a.a(this.a.f);
    }
}

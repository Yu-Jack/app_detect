import android.widget.DatePicker;
import android.app.DatePickerDialog$OnDateSetListener;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.view.KeyEvent;
import android.app.Dialog;
import android.content.ContentUris;
import android.widget.AdapterView$OnItemSelectedListener;
import android.os.Bundle;
import android.content.res.Resources;
import android.widget.SpinnerAdapter;
import java.util.List;
import android.widget.ArrayAdapter;
import android.text.format.DateFormat;
import android.widget.Toast;
import android.text.format.DateUtils;
import java.util.Calendar;
import android.content.Context;
import android.app.DatePickerDialog;
import android.widget.Spinner;
import android.widget.Button;
import android.text.format.Time;
import java.util.ArrayList;
import android.content.DialogInterface$OnClickListener;
import android.app.TimePickerDialog$OnTimeSetListener;
import android.view.View$OnClickListener;
import android.net.Uri;
import android.view.View;
import android.app.Activity;

public final class ig implements DatePickerDialog$OnDateSetListener
{
    final /* synthetic */ ReminderSettings a;
    
    public ig(final ReminderSettings a) {
        this.a = a;
    }
    
    public final void onDateSet(final DatePicker datePicker, final int year, final int month, final int monthDay) {
        this.a.c.year = year;
        this.a.c.month = month;
        this.a.c.monthDay = monthDay;
        ReminderSettings.a(this.a, this.a.c);
        this.a.c();
    }
}

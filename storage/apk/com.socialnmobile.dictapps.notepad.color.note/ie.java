import android.widget.TimePicker;
import android.app.TimePickerDialog$OnTimeSetListener;

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
import android.app.DatePickerDialog$OnDateSetListener;
import android.view.View$OnClickListener;
import android.net.Uri;
import android.view.View;
import android.app.Activity;

public final class ie implements TimePickerDialog$OnTimeSetListener
{
    final /* synthetic */ ReminderSettings a;
    
    public ie(final ReminderSettings a) {
        this.a = a;
    }
    
    public final void onTimeSet(final TimePicker timePicker, final int hour, final int minute) {
        this.a.c.hour = hour;
        this.a.c.minute = minute;
        this.a.c.second = 0;
        ReminderSettings.a(this.a, this.a.c);
        this.a.c();
    }
}

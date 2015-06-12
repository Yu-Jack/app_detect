import java.util.Calendar;
import android.content.DialogInterface;
import android.content.DialogInterface$OnClickListener;

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
import android.content.Context;
import android.app.DatePickerDialog;
import android.widget.Spinner;
import android.widget.Button;
import android.text.format.Time;
import java.util.ArrayList;
import android.app.DatePickerDialog$OnDateSetListener;
import android.app.TimePickerDialog$OnTimeSetListener;
import android.view.View$OnClickListener;
import android.net.Uri;
import android.view.View;
import android.app.Activity;

public final class ih implements DialogInterface$OnClickListener
{
    final /* synthetic */ ReminderSettings a;
    
    public ih(final ReminderSettings a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int index) {
        final long longValue = this.a.k.get(index);
        if (longValue != -1L && longValue == -2L) {
            if (this.a.d == -1L) {
                final Calendar instance = Calendar.getInstance();
                ReminderSettings.a(this.a, instance.get(1), instance.get(2), instance.get(5));
            }
            else {
                ReminderSettings.a(this.a, this.a.c.year, this.a.c.month, this.a.c.monthDay);
            }
        }
        else {
            this.a.b(longValue);
        }
        this.a.c();
        dialogInterface.dismiss();
    }
}

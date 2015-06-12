import android.widget.ListAdapter;
import java.util.List;
import android.widget.ArrayAdapter;
import android.app.AlertDialog$Builder;
import android.app.TimePickerDialog;
import android.text.format.DateFormat;
import java.util.Calendar;
import android.text.format.Time;
import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;

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
import android.widget.Toast;
import android.text.format.DateUtils;
import android.app.DatePickerDialog;
import android.widget.Spinner;
import android.widget.Button;
import java.util.ArrayList;
import android.content.DialogInterface$OnClickListener;
import android.app.DatePickerDialog$OnDateSetListener;
import android.app.TimePickerDialog$OnTimeSetListener;
import android.net.Uri;
import android.app.Activity;

public final class id implements View$OnClickListener
{
    final /* synthetic */ ReminderSettings a;
    
    public id(final ReminderSettings a) {
        this.a = a;
    }
    
    public final void onClick(final View view) {
        Label_1012: {
            switch (view.getId()) {
                case 2131623964: {
                    if (this.a.a == 128) {
                        ReminderSettings.a(this.a);
                        return;
                    }
                    this.a.A.setVisibility(8);
                    kg.a((Context)this.a, this.a.J, this.a.a);
                    this.a.a = 0;
                    this.a.a();
                    this.a.K = false;
                    this.a.setResult(-1);
                    this.a.finish();
                    return;
                }
                case 2131623971: {
                    if (Time.isEpoch(this.a.c)) {
                        final Calendar instance = Calendar.getInstance();
                        ReminderSettings.a(this.a, instance.get(1), instance.get(2), instance.get(5));
                        return;
                    }
                    ReminderSettings.a(this.a, this.a.c.year, this.a.c.month, this.a.c.monthDay);
                    return;
                }
                case 2131623972: {
                    new TimePickerDialog((Context)this.a, this.a.N, this.a.c.hour, this.a.c.minute, DateFormat.is24HourFormat((Context)this.a)).show();
                    return;
                }
                case 2131623970: {
                    final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this.a);
                    if (this.a.a == 16) {
                        alertDialog$Builder.setTitle(2131230872);
                        ReminderSettings.b(this.a);
                        alertDialog$Builder.setSingleChoiceItems((ListAdapter)new ArrayAdapter((Context)this.a, 2130903074, (List)this.a.l), -1, this.a.Q).show();
                        return;
                    }
                    if (this.a.a == 32) {
                        alertDialog$Builder.setTitle(2131230871);
                        alertDialog$Builder.setSingleChoiceItems((ListAdapter)new ArrayAdapter((Context)this.a, 2130903074, (Object[])this.a.m), -1, this.a.R).show();
                        return;
                    }
                    break;
                }
                case 2131623978: {
                    this.a.e.set(this.a.f);
                    if (this.a.f == 0L) {
                        final Calendar instance2 = Calendar.getInstance();
                        ReminderSettings.b(this.a, instance2.get(1), instance2.get(2), instance2.get(5));
                        return;
                    }
                    ReminderSettings.b(this.a, this.a.e.year, this.a.e.month, this.a.e.monthDay);
                    return;
                }
                case 2131623981: {
                    this.a.x.setSelection(this.a.b(16));
                    this.a.c(16);
                    this.a.j = true;
                    this.a.b(-1L);
                    return;
                }
                case 2131623982: {
                    final Calendar instance3 = Calendar.getInstance();
                    instance3.set(instance3.get(1), instance3.get(2), instance3.get(5), 6, 0, 0);
                    this.a.x.setSelection(this.a.b(16));
                    this.a.c(16);
                    this.a.j = true;
                    this.a.b(instance3.getTimeInMillis());
                    return;
                }
                case 2131623983: {
                    this.a.x.setSelection(this.a.b(32));
                    this.a.c(32);
                    this.a.j = true;
                    this.a.b(10000L + (900000L + System.currentTimeMillis()));
                    return;
                }
                case 2131623984: {
                    this.a.x.setSelection(this.a.b(32));
                    this.a.c(32);
                    this.a.j = true;
                    this.a.b(10000L + (1800000L + System.currentTimeMillis()));
                    return;
                }
                case 2131623985: {
                    this.a.x.setSelection(this.a.b(128));
                    this.a.a(false);
                    return;
                }
                case 2131623963: {
                    this.a.i = true;
                    final int b = this.a.B;
                    this.a.B = 0;
                    this.a.C = 0;
                    this.a.F = 0L;
                    this.a.D = 0L;
                    this.a.E = 0L;
                    this.a.c(b);
                    this.a.x.setEnabled(true);
                    this.a.t.setEnabled(true);
                    this.a.u.setEnabled(true);
                    this.a.v.setEnabled(true);
                    this.a.y.setEnabled(true);
                    this.a.z.setVisibility(8);
                    return;
                }
                case 2131623986: {
                    if (!jn.a()) {
                        ReminderSettings.d(this.a);
                        return;
                    }
                    break Label_1012;
                }
                case 2131623987: {
                    ReminderSettings.a(this.a);
                    return;
                }
                case 2131623988: {
                    if (jn.a()) {
                        ReminderSettings.d(this.a);
                        return;
                    }
                    break Label_1012;
                }
            }
            return;
        }
        ReminderSettings.c(this.a);
    }
}

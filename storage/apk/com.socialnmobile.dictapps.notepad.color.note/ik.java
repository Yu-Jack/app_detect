import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView$OnItemSelectedListener;

// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.view.KeyEvent;
import android.app.Dialog;
import android.content.ContentUris;
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
import android.app.TimePickerDialog$OnTimeSetListener;
import android.view.View$OnClickListener;
import android.net.Uri;
import android.app.Activity;

public final class ik implements AdapterView$OnItemSelectedListener
{
    final /* synthetic */ ReminderSettings a;
    
    public ik(final ReminderSettings a) {
        this.a = a;
    }
    
    public final void onItemSelected(final AdapterView adapterView, final View view, final int index, final long n) {
        int intValue;
        if (ReminderSettings.f(this.a) != null) {
            intValue = ReminderSettings.f(this.a).get(index);
        }
        else {
            intValue = 0;
        }
        if (intValue != 0) {
            this.a.s.setVisibility(0);
            return;
        }
        this.a.s.setVisibility(8);
        this.a.f = 0L;
        this.a.a(this.a.f);
    }
    
    public final void onNothingSelected(final AdapterView adapterView) {
    }
}

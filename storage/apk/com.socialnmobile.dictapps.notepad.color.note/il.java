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
import java.util.Calendar;
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

public final class il implements DialogInterface$OnClickListener
{
    final /* synthetic */ ReminderSettings a;
    
    public il(final ReminderSettings a) {
        this.a = a;
    }
    
    public final void onClick(final DialogInterface dialogInterface, final int n) {
        this.a.a(true);
    }
}

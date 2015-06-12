// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.dialogs;

import org.json.JSONObject;
import android.view.View;
import android.widget.EditText;
import org.json.JSONException;
import org.json.JSONArray;
import android.media.Ringtone;
import android.media.RingtoneManager;
import org.apache.cordova.PluginResult;
import android.content.DialogInterface$OnClickListener;
import android.app.AlertDialog$Builder;
import org.apache.cordova.CallbackContext;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface$OnCancelListener;
import org.apache.cordova.CordovaInterface;
import android.app.ProgressDialog;
import org.apache.cordova.CordovaPlugin;

public class Notification extends CordovaPlugin
{
    public int confirmResult;
    public ProgressDialog progressDialog;
    public ProgressDialog spinnerDialog;
    
    public Notification() {
        this.confirmResult = -1;
        this.spinnerDialog = null;
        this.progressDialog = null;
    }
    
    public void activityStart(final String s, final String s2) {
        synchronized (this) {
            if (this.spinnerDialog != null) {
                this.spinnerDialog.dismiss();
                this.spinnerDialog = null;
            }
            this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
                private final /* synthetic */ CordovaInterface val$cordova = Notification.this.cordova;
                
                @Override
                public void run() {
                    Notification.this.spinnerDialog = ProgressDialog.show((Context)this.val$cordova.getActivity(), (CharSequence)s, (CharSequence)s2, true, true, (DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener() {
                        public void onCancel(final DialogInterface dialogInterface) {
                            Notification.this.spinnerDialog = null;
                        }
                    });
                }
            });
        }
    }
    
    public void activityStop() {
        synchronized (this) {
            if (this.spinnerDialog != null) {
                this.spinnerDialog.dismiss();
                this.spinnerDialog = null;
            }
        }
    }
    
    public void alert(final String s, final String s2, final String s3, final CallbackContext callbackContext) {
        synchronized (this) {
            this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
                private final /* synthetic */ CordovaInterface val$cordova = Notification.this.cordova;
                
                @Override
                public void run() {
                    final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this.val$cordova.getActivity());
                    alertDialog$Builder.setMessage((CharSequence)s);
                    alertDialog$Builder.setTitle((CharSequence)s2);
                    alertDialog$Builder.setCancelable(true);
                    alertDialog$Builder.setPositiveButton((CharSequence)s3, (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                        public void onClick(final DialogInterface dialogInterface, final int n) {
                            dialogInterface.dismiss();
                            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
                        }
                    });
                    alertDialog$Builder.setOnCancelListener((DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener() {
                        public void onCancel(final DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
                        }
                    });
                    alertDialog$Builder.create();
                    alertDialog$Builder.show();
                }
            });
        }
    }
    
    public void beep(final long n) {
        final Ringtone ringtone = RingtoneManager.getRingtone(this.cordova.getActivity().getBaseContext(), RingtoneManager.getDefaultUri(2));
        if (ringtone != null) {
            for (long n2 = 0L; n2 < n; ++n2) {
                ringtone.play();
                long n3 = 5000L;
                while (ringtone.isPlaying() && n3 > 0L) {
                    n3 -= 100L;
                    try {
                        Thread.sleep(100L);
                    }
                    catch (InterruptedException ex) {}
                }
            }
        }
    }
    
    public void confirm(final String s, final String s2, final JSONArray jsonArray, final CallbackContext callbackContext) {
        synchronized (this) {
            this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
                private final /* synthetic */ CordovaInterface val$cordova = Notification.this.cordova;
                
                @Override
                public void run() {
                    final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this.val$cordova.getActivity());
                    alertDialog$Builder.setMessage((CharSequence)s);
                    alertDialog$Builder.setTitle((CharSequence)s2);
                    alertDialog$Builder.setCancelable(true);
                    while (true) {
                        if (jsonArray.length() <= 0) {
                            break Label_0076;
                        }
                        try {
                            alertDialog$Builder.setNegativeButton((CharSequence)jsonArray.getString(0), (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                                public void onClick(final DialogInterface dialogInterface, final int n) {
                                    dialogInterface.dismiss();
                                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 1));
                                }
                            });
                            Label_0112: {
                                if (jsonArray.length() <= 1) {
                                    break Label_0112;
                                }
                                try {
                                    alertDialog$Builder.setNeutralButton((CharSequence)jsonArray.getString(1), (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                                        public void onClick(final DialogInterface dialogInterface, final int n) {
                                            dialogInterface.dismiss();
                                            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 2));
                                        }
                                    });
                                    Label_0148: {
                                        if (jsonArray.length() <= 2) {
                                            break Label_0148;
                                        }
                                        try {
                                            alertDialog$Builder.setPositiveButton((CharSequence)jsonArray.getString(2), (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                                                public void onClick(final DialogInterface dialogInterface, final int n) {
                                                    dialogInterface.dismiss();
                                                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 3));
                                                }
                                            });
                                            alertDialog$Builder.setOnCancelListener((DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener() {
                                                public void onCancel(final DialogInterface dialogInterface) {
                                                    dialogInterface.dismiss();
                                                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, 0));
                                                }
                                            });
                                            alertDialog$Builder.create();
                                            alertDialog$Builder.show();
                                        }
                                        catch (JSONException ex) {}
                                    }
                                }
                                catch (JSONException ex2) {}
                            }
                        }
                        catch (JSONException ex3) {
                            continue;
                        }
                        break;
                    }
                }
            });
        }
    }
    
    @Override
    public boolean execute(final String s, final JSONArray jsonArray, final CallbackContext callbackContext) throws JSONException {
        if (!this.cordova.getActivity().isFinishing()) {
            if (s.equals("beep")) {
                this.beep(jsonArray.getLong(0));
            }
            else {
                if (s.equals("alert")) {
                    this.alert(jsonArray.getString(0), jsonArray.getString(1), jsonArray.getString(2), callbackContext);
                    return true;
                }
                if (s.equals("confirm")) {
                    this.confirm(jsonArray.getString(0), jsonArray.getString(1), jsonArray.getJSONArray(2), callbackContext);
                    return true;
                }
                if (s.equals("prompt")) {
                    this.prompt(jsonArray.getString(0), jsonArray.getString(1), jsonArray.getJSONArray(2), jsonArray.getString(3), callbackContext);
                    return true;
                }
                if (s.equals("activityStart")) {
                    this.activityStart(jsonArray.getString(0), jsonArray.getString(1));
                }
                else if (s.equals("activityStop")) {
                    this.activityStop();
                }
                else if (s.equals("progressStart")) {
                    this.progressStart(jsonArray.getString(0), jsonArray.getString(1));
                }
                else if (s.equals("progressValue")) {
                    this.progressValue(jsonArray.getInt(0));
                }
                else {
                    final boolean equals = s.equals("progressStop");
                    final boolean b = false;
                    if (!equals) {
                        return b;
                    }
                    this.progressStop();
                }
            }
            callbackContext.success();
            return true;
        }
        return true;
    }
    
    public void progressStart(final String s, final String s2) {
        synchronized (this) {
            if (this.progressDialog != null) {
                this.progressDialog.dismiss();
                this.progressDialog = null;
            }
            this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
                private final /* synthetic */ CordovaInterface val$cordova = Notification.this.cordova;
                
                @Override
                public void run() {
                    (Notification.this.progressDialog = new ProgressDialog((Context)this.val$cordova.getActivity())).setProgressStyle(1);
                    Notification.this.progressDialog.setTitle((CharSequence)s);
                    Notification.this.progressDialog.setMessage((CharSequence)s2);
                    Notification.this.progressDialog.setCancelable(true);
                    Notification.this.progressDialog.setMax(100);
                    Notification.this.progressDialog.setProgress(0);
                    Notification.this.progressDialog.setOnCancelListener((DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener() {
                        private final /* synthetic */ Notification val$notification = Notification.this;
                        
                        public void onCancel(final DialogInterface dialogInterface) {
                            this.val$notification.progressDialog = null;
                        }
                    });
                    Notification.this.progressDialog.show();
                }
            });
        }
    }
    
    public void progressStop() {
        synchronized (this) {
            if (this.progressDialog != null) {
                this.progressDialog.dismiss();
                this.progressDialog = null;
            }
        }
    }
    
    public void progressValue(final int progress) {
        synchronized (this) {
            if (this.progressDialog != null) {
                this.progressDialog.setProgress(progress);
            }
        }
    }
    
    public void prompt(final String s, final String s2, final JSONArray jsonArray, final String s3, final CallbackContext callbackContext) {
        synchronized (this) {
            this.cordova.getActivity().runOnUiThread((Runnable)new Runnable() {
                private final /* synthetic */ CordovaInterface val$cordova = Notification.this.cordova;
                
                @Override
                public void run() {
                    final EditText view = new EditText((Context)this.val$cordova.getActivity());
                    view.setHint((CharSequence)s3);
                    final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)this.val$cordova.getActivity());
                    alertDialog$Builder.setMessage((CharSequence)s);
                    alertDialog$Builder.setTitle((CharSequence)s2);
                    alertDialog$Builder.setCancelable(true);
                    alertDialog$Builder.setView((View)view);
                    final JSONObject jsonObject = new JSONObject();
                    while (true) {
                        if (jsonArray.length() <= 0) {
                            break Label_0123;
                        }
                        try {
                            alertDialog$Builder.setNegativeButton((CharSequence)jsonArray.getString(0), (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                                public void onClick(final DialogInterface dialogInterface, final int n) {
                                    dialogInterface.dismiss();
                                    while (true) {
                                        try {
                                            jsonObject.put("buttonIndex", 1);
                                            final JSONObject val$result = jsonObject;
                                            Object o;
                                            if (view.getText().toString().trim().length() == 0) {
                                                o = s3;
                                            }
                                            else {
                                                o = view.getText();
                                            }
                                            val$result.put("input1", o);
                                            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, jsonObject));
                                        }
                                        catch (JSONException ex) {
                                            ex.printStackTrace();
                                            continue;
                                        }
                                        break;
                                    }
                                }
                            });
                            Label_0166: {
                                if (jsonArray.length() <= 1) {
                                    break Label_0166;
                                }
                                try {
                                    alertDialog$Builder.setNeutralButton((CharSequence)jsonArray.getString(1), (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                                        public void onClick(final DialogInterface dialogInterface, final int n) {
                                            dialogInterface.dismiss();
                                            while (true) {
                                                try {
                                                    jsonObject.put("buttonIndex", 2);
                                                    final JSONObject val$result = jsonObject;
                                                    Object o;
                                                    if (view.getText().toString().trim().length() == 0) {
                                                        o = s3;
                                                    }
                                                    else {
                                                        o = view.getText();
                                                    }
                                                    val$result.put("input1", o);
                                                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, jsonObject));
                                                }
                                                catch (JSONException ex) {
                                                    ex.printStackTrace();
                                                    continue;
                                                }
                                                break;
                                            }
                                        }
                                    });
                                    Label_0209: {
                                        if (jsonArray.length() <= 2) {
                                            break Label_0209;
                                        }
                                        try {
                                            alertDialog$Builder.setPositiveButton((CharSequence)jsonArray.getString(2), (DialogInterface$OnClickListener)new DialogInterface$OnClickListener() {
                                                public void onClick(final DialogInterface dialogInterface, final int n) {
                                                    dialogInterface.dismiss();
                                                    while (true) {
                                                        try {
                                                            jsonObject.put("buttonIndex", 3);
                                                            final JSONObject val$result = jsonObject;
                                                            Object o;
                                                            if (view.getText().toString().trim().length() == 0) {
                                                                o = s3;
                                                            }
                                                            else {
                                                                o = view.getText();
                                                            }
                                                            val$result.put("input1", o);
                                                            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, jsonObject));
                                                        }
                                                        catch (JSONException ex) {
                                                            ex.printStackTrace();
                                                            continue;
                                                        }
                                                        break;
                                                    }
                                                }
                                            });
                                            alertDialog$Builder.setOnCancelListener((DialogInterface$OnCancelListener)new DialogInterface$OnCancelListener() {
                                                public void onCancel(final DialogInterface dialogInterface) {
                                                    dialogInterface.dismiss();
                                                    while (true) {
                                                        try {
                                                            jsonObject.put("buttonIndex", 0);
                                                            final JSONObject val$result = jsonObject;
                                                            Object o;
                                                            if (view.getText().toString().trim().length() == 0) {
                                                                o = s3;
                                                            }
                                                            else {
                                                                o = view.getText();
                                                            }
                                                            val$result.put("input1", o);
                                                            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, jsonObject));
                                                        }
                                                        catch (JSONException ex) {
                                                            ex.printStackTrace();
                                                            continue;
                                                        }
                                                        break;
                                                    }
                                                }
                                            });
                                            alertDialog$Builder.create();
                                            alertDialog$Builder.show();
                                        }
                                        catch (JSONException ex) {}
                                    }
                                }
                                catch (JSONException ex2) {}
                            }
                        }
                        catch (JSONException ex3) {
                            continue;
                        }
                        break;
                    }
                }
            });
        }
    }
}

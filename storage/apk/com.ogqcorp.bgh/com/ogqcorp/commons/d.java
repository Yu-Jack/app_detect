// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.commons;

import android.content.Context;
import android.app.ProgressDialog;
import android.os.AsyncTask;

public abstract class d<Params, Progress, Result> extends AsyncTask<Params, Progress, Result>
{
    private ProgressDialog a;
    
    public void a(final Context context, final int n, final Params... array) {
        if (n != 0) {
            final String string = context.getString(n);
            (this.a = new ProgressDialog(context)).setCancelable(false);
            this.a.setMessage((CharSequence)string);
        }
        super.execute((Object[])array);
    }
    
    protected void onCancelled() {
        try {
            if (this.a != null) {
                this.a.dismiss();
                this.a = null;
            }
        }
        catch (Exception ex) {
            n.c(ex);
        }
    }
    
    protected void onPostExecute(final Result result) {
        try {
            if (this.a != null) {
                this.a.dismiss();
                this.a = null;
            }
        }
        catch (Exception ex) {
            n.c(ex);
        }
    }
    
    protected void onPreExecute() {
        try {
            if (this.a != null) {
                this.a.show();
            }
        }
        catch (Exception ex) {
            n.c(ex);
        }
    }
}

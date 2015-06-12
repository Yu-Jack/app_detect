// 
// Decompiled by Procyon v0.5.29
// 

package com.ogqcorp.bgh.b;

import android.content.DialogInterface;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import android.content.DialogInterface$OnClickListener;
import android.content.Context;
import android.app.AlertDialog$Builder;
import android.view.ViewGroup;
import android.app.Dialog;
import android.os.Bundle;
import java.net.MalformedURLException;
import java.net.URL;
import com.ogqcorp.bgh.system.l;
import com.ogqcorp.commons.u;
import java.io.File;
import android.support.v4.app.FragmentManager;
import java.io.RandomAccessFile;
import java.io.InputStream;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.actionbarsherlock.app.SherlockDialogFragment;

public final class i extends SherlockDialogFragment
{
    private String a;
    private TextView b;
    private ProgressBar c;
    private TextView d;
    private j e;
    private boolean f;
    private long g;
    private long h;
    
    public i() {
        this.f = false;
        this.h = 0L;
    }
    
    private void a(final View view) {
        (this.b = (TextView)view.findViewById(2131099795)).setText((CharSequence)this.a);
        this.c = (ProgressBar)view.findViewById(2131099796);
        this.d = (TextView)view.findViewById(2131099797);
    }
    
    private boolean a(final InputStream inputStream, final RandomAccessFile randomAccessFile) {
        final byte[] array = new byte[30720];
        int n = 0;
        while (this.f) {
            final int read = inputStream.read(array);
            if (read == -1) {
                break;
            }
            randomAccessFile.write(array, 0, read);
            this.h += read;
            if (++n % 5 != 0) {
                continue;
            }
            this.e.a(Long.valueOf(this.g), Long.valueOf(this.h));
        }
        this.e.a(Long.valueOf(this.g), Long.valueOf(this.h));
        return this.f;
    }
    
    public void a(final FragmentManager fragmentManager, final String spec, final File file, final u<Exception> u) {
        file.delete();
        final File file2 = new File(file.getAbsolutePath() + ".ing");
        this.show(fragmentManager, "DOWNLOAD_FRAGMENT");
        this.e = new j() {
            protected void a(final Exception ex) {
                while (true) {
                    try {
                        if (i.this.isAdded() && i.this.isResumed()) {
                            i.this.dismiss();
                        }
                        if (ex == null) {
                            file2.renameTo(file);
                        }
                        if (u != null) {
                            u.a(ex);
                        }
                    }
                    catch (Exception ex2) {
                        l.b(ex2);
                        continue;
                    }
                    break;
                }
            }
        };
        try {
            this.f = true;
            this.e.execute(new Object[] { new URL(spec), file2 });
        }
        catch (MalformedURLException ex) {
            if (u != null) {
                u.a(ex);
            }
        }
    }
    
    public void a(final String a) {
        this.a = a;
        if (this.b != null) {
            this.b.setText((CharSequence)this.a);
        }
    }
    
    @Override
    public Dialog onCreateDialog(final Bundle bundle) {
        final SherlockFragmentActivity sherlockActivity = this.getSherlockActivity();
        final View inflate = sherlockActivity.getLayoutInflater().inflate(2130903080, (ViewGroup)null);
        this.a(inflate);
        return (Dialog)new AlertDialog$Builder((Context)sherlockActivity).setTitle(2131427437).setView(inflate).setNegativeButton(17039360, (DialogInterface$OnClickListener)null).create();
    }
    
    @Override
    public void onDismiss(final DialogInterface dialogInterface) {
        while (true) {
            try {
                this.f = false;
                this.e.get();
                super.onDismiss(dialogInterface);
            }
            catch (Exception ex) {
                l.b(ex);
                continue;
            }
            break;
        }
    }
}

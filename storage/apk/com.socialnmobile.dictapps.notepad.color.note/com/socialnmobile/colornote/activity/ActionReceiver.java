// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.activity;

import android.os.Bundle;
import java.util.regex.Matcher;
import android.text.Html;
import java.util.regex.Pattern;
import java.io.IOException;
import android.widget.Toast;
import java.io.File;
import com.socialnmobile.colornote.ColorNote;
import android.content.Intent;
import android.content.Context;
import android.net.Uri;
import android.app.Activity;

public class ActionReceiver extends Activity
{
    private Uri a(final int n, final String s, final String s2) {
        return kg.a((Context)this, 0, n, 0, jp.a((Context)this, "pref_default_color", 3), s, s2);
    }
    
    private boolean a(final Intent intent) {
        final String action = intent.getAction();
        final Uri data = intent.getData();
        final String type = intent.getType();
        Uri uri = null;
        String s = null;
        Label_0060: {
            if ("android.intent.action.SEND".equals(action)) {
                final String stringExtra = intent.getStringExtra("android.intent.extra.SUBJECT");
                final String stringExtra2 = intent.getStringExtra("android.intent.extra.TEXT");
                uri = this.a(yg.c(stringExtra2), stringExtra, stringExtra2);
                s = "android.intent.action.INSERT";
            }
            else {
                if ("android.intent.action.VIEW".equals(action) && data != null) {
                    while (true) {
                        final Matcher matcher;
                        Label_0492: {
                            int n;
                            String input;
                            if ("file".equals(data.getScheme())) {
                                new StringBuilder("load file:").append(intent.getType()).append("/").append(data.getPath()).toString();
                                ColorNote.a();
                                if (new File(data.getPath()).length() > 149500L) {
                                    Toast.makeText((Context)this, 2131231062, 1).show();
                                    this.finish();
                                    return false;
                                }
                                if (data.getPath().contains("bluetooth_content")) {
                                    n = 1;
                                }
                                else {
                                    n = 0;
                                }
                                input = gw.d(data.getPath());
                            }
                            else {
                                String a = null;
                                Label_0610: {
                                    try {
                                        a = gw.a(this.getContentResolver().openInputStream(data));
                                        if (a.length() > 149500) {
                                            Toast.makeText((Context)this, 2131231062, 1).show();
                                            this.finish();
                                            return false;
                                        }
                                        break Label_0610;
                                    }
                                    catch (IOException ex) {
                                        Toast.makeText((Context)this, (CharSequence)(String.valueOf(this.getString(2131230840)) + "\nIOException\nData:" + data.toString() + "\nType:" + type), 1).show();
                                        this.finish();
                                        return false;
                                    }
                                    break Label_0492;
                                }
                                input = a;
                                n = 0;
                            }
                            String group = null;
                            Label_0328: {
                                if (!"text/html".equals(type)) {
                                    "text/plain".equals(type);
                                    group = null;
                                    break Label_0328;
                                }
                                matcher = Pattern.compile("(?i)(?s)(<title.*?>)(.+?)(</title>)").matcher(input);
                                group = null;
                                if (matcher.find()) {
                                    break Label_0492;
                                }
                                final String replaceAll = input.replaceAll("(?i)(?s)(<title.*?>)(.+?)(</title>)", "");
                                if (n != 0) {
                                    final Matcher matcher2 = Pattern.compile("(?i)(?s)(<body><a.*?>)(.+?)(</a></p></body>)").matcher(replaceAll);
                                    if (matcher2.find()) {
                                        input = matcher2.group(2);
                                    }
                                    else {
                                        input = null;
                                    }
                                    if (input == null) {
                                        input = replaceAll.replaceAll("\\<[^>]*>", "");
                                    }
                                }
                                else {
                                    try {
                                        input = Html.fromHtml(replaceAll).toString();
                                    }
                                    catch (RuntimeException ex2) {
                                        input = gw.b(replaceAll.replaceAll("\\<[^>]*>", ""));
                                    }
                                }
                            }
                            final int c = yg.c(input);
                            if (c == 16 && "text/html".equals(type)) {
                                input = input.replaceAll("\\[ \\]", "\n[ ]").replaceAll("\\[V\\]", "\n[V]").replaceAll("^\n", "");
                            }
                            uri = this.a(c, group, input);
                            s = "android.intent.action.INSERT";
                            break Label_0060;
                        }
                        String group = matcher.group(2);
                        continue;
                    }
                }
                uri = null;
                s = null;
            }
        }
        if (s == null || uri == null) {
            Toast.makeText((Context)this, (CharSequence)(String.valueOf(this.getString(2131230840)) + "\nData:" + data.toString() + "\nType:" + type), 1).show();
            this.finish();
            return false;
        }
        final Intent intent2 = new Intent(s, uri);
        intent2.setFlags(intent.getFlags());
        this.startActivity(intent2);
        this.finish();
        return true;
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        this.a(this.getIntent());
    }
}

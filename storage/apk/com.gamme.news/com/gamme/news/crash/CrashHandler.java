// 
// Decompiled by Procyon v0.5.29
// 

package com.gamme.news.crash;

import android.os.Process;
import android.app.PendingIntent;
import android.app.AlarmManager;
import android.content.Intent;
import java.lang.reflect.Field;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.net.NetworkInfo;
import java.util.Iterator;
import android.util.Log;
import java.util.Date;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpEntity;
import java.util.List;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import android.provider.Settings$Secure;
import android.os.Build$VERSION;
import android.os.Build;
import org.apache.http.message.BasicNameValuePair;
import java.util.ArrayList;
import org.apache.http.client.methods.HttpPost;
import android.net.ConnectivityManager;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.StringWriter;
import android.widget.Toast;
import android.os.Looper;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import android.content.Context;
import java.util.Map;
import java.text.DateFormat;

public class CrashHandler implements UncaughtExceptionHandler
{
    private static CrashHandler INSTANCE;
    public static final String TAG = "CrashHandler";
    private DateFormat formatter;
    private Map<String, String> infos;
    private Context mContext;
    private UncaughtExceptionHandler mDefaultHandler;
    
    static {
        CrashHandler.INSTANCE = new CrashHandler();
    }
    
    private CrashHandler() {
        this.infos = new HashMap<String, String>();
        this.formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
    }
    
    public static CrashHandler getInstance() {
        return CrashHandler.INSTANCE;
    }
    
    private boolean handleException(final Throwable t) {
        if (t == null) {
            return false;
        }
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(CrashHandler.this.mContext, (CharSequence)"\u767c\u751f\u7570\u5e38\uff0c\u5373\u5c07\u91cd\u65b0\u555f\u52d5\uff0c\u9020\u6210\u4e0d\u4fbf\u6df1\u611f\u62b1\u6b49\u3002", 1).show();
                Looper.loop();
            }
        }.start();
        this.collectDeviceInfo(this.mContext);
        this.saveCrashInfo2File(t);
        return true;
    }
    
    private String saveCrashInfo2File(final Throwable t) {
        final StringBuffer sb = new StringBuffer();
        final Iterator<Map.Entry<String, String>> iterator = this.infos.entrySet().iterator();
    Label_0064_Outer:
        while (true) {
            Label_0374: {
                if (iterator.hasNext()) {
                    break Label_0374;
                }
                final StringWriter out = new StringWriter();
                final PrintWriter printWriter = new PrintWriter(out);
                t.printStackTrace(printWriter);
                Throwable t2 = t.getCause();
                while (true) {
                    Label_0449: {
                        if (t2 != null) {
                            break Label_0449;
                        }
                        printWriter.close();
                        sb.append(out.toString());
                        try {
                            final NetworkInfo activeNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
                            final HttpPost httpPost = new HttpPost("http://sch.gamme.com.tw/v2/mailer2.php");
                            final ArrayList<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
                            list.add(new BasicNameValuePair("model", String.valueOf(Build.MODEL) + "/" + Build.PRODUCT));
                            list.add(new BasicNameValuePair("systemInfoMachine", "Android"));
                            list.add(new BasicNameValuePair("systemVersion", Build$VERSION.RELEASE));
                            list.add(new BasicNameValuePair("uniqueIdentifier", Settings$Secure.getString(this.mContext.getContentResolver(), "android_id")));
                            list.add(new BasicNameValuePair("report", "<pre>" + sb.toString() + "</pre><BR/>\u7db2\u8def\u72c0\u614b:" + activeNetworkInfo.getTypeName()));
                            httpPost.setEntity((HttpEntity)new UrlEncodedFormEntity((List)list, "UTF-8"));
                            new DefaultHttpClient().execute((HttpUriRequest)httpPost);
                            return "crash-" + this.formatter.format(new Date()) + "-" + System.currentTimeMillis() + ".txt";
                            final Map.Entry<String, String> entry = iterator.next();
                            sb.append(String.valueOf(entry.getKey()) + "=" + entry.getValue() + "\n");
                            continue Label_0064_Outer;
                            t2.printStackTrace(printWriter);
                            t2 = t2.getCause();
                            continue;
                        }
                        catch (Exception ex) {
                            Log.e("CrashHandler", "an error occured while reporting ...", (Throwable)ex);
                            return null;
                        }
                    }
                    break;
                }
            }
        }
    }
    
    public void collectDeviceInfo(final Context context) {
    Label_0097_Outer:
        while (true) {
        Label_0205_Outer:
            while (true) {
                Field[] declaredFields;
                int n;
                while (true) {
                    try {
                        final PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 1);
                        if (packageInfo != null) {
                            String versionName;
                            if (packageInfo.versionName == null) {
                                versionName = "null";
                            }
                            else {
                                versionName = packageInfo.versionName;
                            }
                            final String string = new StringBuilder(String.valueOf(packageInfo.versionCode)).toString();
                            this.infos.put("versionName", versionName);
                            this.infos.put("versionCode", string);
                        }
                        declaredFields = Build.class.getDeclaredFields();
                        final int length = declaredFields.length;
                        n = 0;
                        if (n >= length) {
                            return;
                        }
                    }
                    catch (PackageManager$NameNotFoundException ex) {
                        Log.e("CrashHandler", "an error occured when collect package info", (Throwable)ex);
                        continue Label_0097_Outer;
                    }
                    break;
                }
                final Field field = declaredFields[n];
                while (true) {
                    try {
                        field.setAccessible(true);
                        this.infos.put(field.getName(), field.get(null).toString());
                        Log.d("CrashHandler", String.valueOf(field.getName()) + " : " + field.get(null));
                        ++n;
                        continue Label_0205_Outer;
                    }
                    catch (Exception ex2) {
                        Log.e("CrashHandler", "an error occured when collect crash info", (Throwable)ex2);
                        continue;
                    }
                    break;
                }
                break;
            }
        }
    }
    
    public void init(final Context mContext) {
        this.mContext = mContext;
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)this);
    }
    
    @Override
    public void uncaughtException(final Thread thread, final Throwable t) {
        if (!this.handleException(t) && this.mDefaultHandler != null) {
            this.mDefaultHandler.uncaughtException(thread, t);
            return;
        }
        while (true) {
            try {
                Thread.sleep(3000L);
                final Intent intent = new Intent();
                intent.setClassName(this.mContext.getPackageName(), "com.gamme.news.Workshop");
                ((AlarmManager)this.mContext.getSystemService("alarm")).set(1, 1000L + System.currentTimeMillis(), PendingIntent.getActivity(this.mContext.getApplicationContext(), 0, intent, 268435456));
                Process.killProcess(Process.myPid());
                System.exit(1);
            }
            catch (InterruptedException ex) {
                Log.e("CrashHandler", "error : ", (Throwable)ex);
                continue;
            }
            break;
        }
    }
}

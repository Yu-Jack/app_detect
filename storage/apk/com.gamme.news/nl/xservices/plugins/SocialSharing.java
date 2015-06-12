// 
// Decompiled by Procyon v0.5.29
// 

package nl.xservices.plugins;

import java.io.FileOutputStream;
import android.content.ActivityNotFoundException;
import android.os.Build$VERSION;
import android.text.Html;
import java.util.Collection;
import android.os.Build;
import java.util.regex.Matcher;
import java.net.URLConnection;
import android.util.Base64;
import java.util.regex.Pattern;
import java.net.URL;
import org.apache.http.util.ByteArrayBuffer;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import android.content.pm.ResolveInfo;
import android.content.ComponentName;
import org.apache.cordova.PluginResult;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;
import org.apache.cordova.CordovaInterface;
import java.io.File;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.content.Intent;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONArray;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

public class SocialSharing extends CordovaPlugin
{
    private static final String ACTION_AVAILABLE_EVENT = "available";
    private static final String ACTION_CAN_SHARE_VIA = "canShareVia";
    private static final String ACTION_CAN_SHARE_VIA_EMAIL = "canShareViaEmail";
    private static final String ACTION_SHARE_EVENT = "share";
    private static final String ACTION_SHARE_VIA = "shareVia";
    private static final String ACTION_SHARE_VIA_EMAIL_EVENT = "shareViaEmail";
    private static final String ACTION_SHARE_VIA_FACEBOOK_EVENT = "shareViaFacebook";
    private static final String ACTION_SHARE_VIA_SMS_EVENT = "shareViaSMS";
    private static final String ACTION_SHARE_VIA_TWITTER_EVENT = "shareViaTwitter";
    private static final String ACTION_SHARE_VIA_WHATSAPP_EVENT = "shareViaWhatsApp";
    private static final int ACTIVITY_CODE_SENDVIAEMAIL = 2;
    private CallbackContext callbackContext;
    
    private void cleanupOldFiles(final File file) {
        final File[] listFiles = file.listFiles();
        for (int length = listFiles.length, i = 0; i < length; ++i) {
            listFiles[i].delete();
        }
    }
    
    private void createOrCleanDir(final String pathname) throws IOException {
        final File file = new File(pathname);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new IOException("CREATE_DIRS_FAILED");
            }
        }
        else {
            this.cleanupOldFiles(file);
        }
    }
    
    private boolean doSendIntent(final String s, final String s2, final JSONArray jsonArray, final String s3, final String s4, final boolean b) {
        this.cordova.getThreadPool().execute(new Runnable() {
            private final /* synthetic */ CordovaInterface val$mycordova = SocialSharing.this.cordova;
            private final /* synthetic */ CordovaPlugin val$plugin;
            
            @Override
            public void run() {
                String obj = s;
            Label_0111:
                while (true) {
                    Intent intent = null;
                Label_0253_Outer:
                    while (true) {
                        String s = null;
                        Label_0025: {
                            while (true) {
                                int n = 0;
                                Label_0018: {
                                    if (jsonArray.length() > 1) {
                                        n = 1;
                                        break Label_0018;
                                    }
                                    Label_0248: {
                                        break Label_0248;
                                        while (true) {
                                            final ArrayList<Uri> list = new ArrayList<Uri>();
                                            Label_0404: {
                                                ActivityInfo access$3 = null;
                                            Label_0177_Outer:
                                                while (true) {
                                                    int n2 = 0;
                                                Label_0453:
                                                    while (true) {
                                                        Label_0345: {
                                                            try {
                                                                String access$2 = SocialSharing.this.getDownloadDir();
                                                                access$2 = null;
                                                                n2 = 0;
                                                                if (n2 >= jsonArray.length()) {
                                                                    if (!list.isEmpty()) {
                                                                        if (n != 0) {
                                                                            intent.putExtra("android.intent.extra.STREAM", (Serializable)list);
                                                                        }
                                                                        else {
                                                                            intent.putExtra("android.intent.extra.STREAM", (Parcelable)access$2);
                                                                        }
                                                                    }
                                                                    if (notEmpty(s2)) {
                                                                        intent.putExtra("android.intent.extra.SUBJECT", s2);
                                                                    }
                                                                    if (notEmpty(s3)) {
                                                                        if (!notEmpty(obj)) {
                                                                            break Label_0345;
                                                                        }
                                                                        obj = String.valueOf(obj) + " " + s3;
                                                                    }
                                                                    if (notEmpty(obj)) {
                                                                        intent.putExtra("android.intent.extra.TEXT", obj);
                                                                    }
                                                                    if (s4 != null) {
                                                                        access$3 = SocialSharing.this.getActivity(intent, s4);
                                                                        if (access$3 != null) {
                                                                            if (!b) {
                                                                                break Label_0177_Outer;
                                                                            }
                                                                            SocialSharing.this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
                                                                        }
                                                                        return;
                                                                    }
                                                                    break Label_0404;
                                                                }
                                                                else {
                                                                    access$2 = SocialSharing.this.getFileUriAndSetType(intent, access$2, jsonArray.getString(n2), s2);
                                                                    if (access$2 != null) {
                                                                        list.add(access$2);
                                                                    }
                                                                    break Label_0453;
                                                                }
                                                                s = "android.intent.action.SEND";
                                                                break Label_0025;
                                                                n = 0;
                                                                break;
                                                            }
                                                            catch (Exception ex) {
                                                                SocialSharing.this.callbackContext.error(ex.getMessage());
                                                                continue Label_0111;
                                                            }
                                                            continue Label_0111;
                                                        }
                                                        obj = s3;
                                                        continue Label_0253_Outer;
                                                    }
                                                    ++n2;
                                                    continue Label_0177_Outer;
                                                }
                                                intent.addCategory("android.intent.category.LAUNCHER");
                                                intent.setComponent(new ComponentName(access$3.applicationInfo.packageName, access$3.name));
                                                this.val$mycordova.startActivityForResult(this.val$plugin, intent, 0);
                                                return;
                                            }
                                            if (b) {
                                                SocialSharing.this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
                                                return;
                                            }
                                            this.val$mycordova.startActivityForResult(this.val$plugin, Intent.createChooser(intent, (CharSequence)null), 1);
                                            return;
                                        }
                                    }
                                }
                                if (n == 0) {
                                    continue;
                                }
                                break;
                            }
                            s = "android.intent.action.SEND_MULTIPLE";
                        }
                        intent = new Intent(s);
                        intent.addFlags(524288);
                        if (jsonArray.length() > 0) {
                            continue Label_0253_Outer;
                        }
                        break;
                    }
                    intent.setType("text/plain");
                    continue Label_0111;
                }
            }
        });
        return true;
    }
    
    private ActivityInfo getActivity(final Intent intent, final String s) {
        final List queryIntentActivities = this.webView.getContext().getPackageManager().queryIntentActivities(intent, 0);
        for (final ResolveInfo resolveInfo : queryIntentActivities) {
            if (resolveInfo.activityInfo.packageName.contains(s)) {
                return resolveInfo.activityInfo;
            }
        }
        this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, this.getShareActivities(queryIntentActivities)));
        return null;
    }
    
    private byte[] getBytes(final InputStream in) throws IOException {
        final BufferedInputStream bufferedInputStream = new BufferedInputStream(in);
        final ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(5000);
        while (true) {
            final int read = bufferedInputStream.read();
            if (read == -1) {
                break;
            }
            byteArrayBuffer.append((int)(byte)read);
        }
        return byteArrayBuffer.toByteArray();
    }
    
    private String getDownloadDir() throws IOException {
        final String string = this.webView.getContext().getExternalFilesDir((String)null) + "/socialsharing-downloads";
        this.createOrCleanDir(string);
        return string;
    }
    
    private String getFileName(final String s) {
        final int lastIndex = s.lastIndexOf(47);
        if (lastIndex == -1) {
            return s;
        }
        return s.substring(lastIndex + 1);
    }
    
    private Uri getFileUriAndSetType(final Intent intent, final String str, final String spec, final String s) throws IOException {
        String s2 = spec;
        intent.setType("image/*");
        if (spec.startsWith("http") || spec.startsWith("www/")) {
            String s3 = this.getFileName(spec);
            s2 = "file://" + str + "/" + s3;
            if (spec.startsWith("http")) {
                final URLConnection openConnection = new URL(spec).openConnection();
                final String headerField = openConnection.getHeaderField("Content-Disposition");
                if (headerField != null) {
                    final Matcher matcher = Pattern.compile("filename=([^;]+)").matcher(headerField);
                    if (matcher.find()) {
                        s3 = matcher.group(1).replaceAll("[^a-zA-Z0-9._-]", "");
                        s2 = "file://" + str + "/" + s3;
                    }
                }
                this.saveFile(this.getBytes(openConnection.getInputStream()), str, s3);
            }
            else {
                this.saveFile(this.getBytes(this.webView.getContext().getAssets().open(spec)), str, s3);
            }
        }
        else if (spec.startsWith("data:")) {
            if (!spec.contains(";base64,")) {
                intent.setType("text/plain");
                return null;
            }
            final String substring = spec.substring(8 + spec.indexOf(";base64,"));
            if (!spec.contains("data:image/")) {
                intent.setType(spec.substring(5 + spec.indexOf("data:"), spec.indexOf(";base64")));
            }
            final String substring2 = spec.substring(1 + spec.indexOf("/"), spec.indexOf(";base64"));
            String str2 = "file." + substring2;
            if (notEmpty(s)) {
                str2 = String.valueOf(sanitizeFilename(s)) + "." + substring2;
            }
            this.saveFile(Base64.decode(substring, 0), str, str2);
            s2 = "file://" + str + "/" + str2;
        }
        else if (!spec.startsWith("file://")) {
            throw new IllegalArgumentException("URL_NOT_SUPPORTED");
        }
        return Uri.parse(s2);
    }
    
    private static String getPhoneNumbersWithManufacturerSpecificSeparators(final String s) {
        if (notEmpty(s)) {
            char c;
            if (Build.MANUFACTURER.equalsIgnoreCase("samsung")) {
                c = ',';
            }
            else {
                c = ';';
            }
            return s.replace(';', c).replace(',', c);
        }
        return null;
    }
    
    private JSONArray getShareActivities(final List<ResolveInfo> list) {
        final ArrayList<String> list2 = new ArrayList<String>();
        final Iterator<ResolveInfo> iterator = list.iterator();
        while (iterator.hasNext()) {
            list2.add(iterator.next().activityInfo.packageName);
        }
        return new JSONArray((Collection)list2);
    }
    
    private boolean invokeEmailIntent(final String s, final String s2, final JSONArray jsonArray, final JSONArray jsonArray2, final JSONArray jsonArray3, final JSONArray jsonArray4) throws JSONException {
        this.cordova.getThreadPool().execute(new Runnable() {
            @Override
            public void run() {
                final Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
                Label_0258: {
                    if (notEmpty(s)) {
                        if (!s.matches(".*<[^>]+>.*")) {
                            break Label_0258;
                        }
                        intent.putExtra("android.intent.extra.TEXT", (CharSequence)Html.fromHtml(s));
                        intent.setType("text/html");
                    }
                Label_0227_Outer:
                    while (true) {
                        if (notEmpty(s2)) {
                            intent.putExtra("android.intent.extra.SUBJECT", s2);
                        }
                        while (true) {
                            try {
                                if (jsonArray != null && jsonArray.length() > 0) {
                                    intent.putExtra("android.intent.extra.EMAIL", toStringArray(jsonArray));
                                }
                                if (jsonArray2 != null && jsonArray2.length() > 0) {
                                    intent.putExtra("android.intent.extra.CC", toStringArray(jsonArray2));
                                }
                                if (jsonArray3 != null && jsonArray3.length() > 0) {
                                    intent.putExtra("android.intent.extra.BCC", toStringArray(jsonArray3));
                                }
                                if (jsonArray4.length() > 0) {
                                    final ArrayList<Uri> list = new ArrayList<Uri>();
                                    String access$2 = SocialSharing.this.getDownloadDir();
                                    for (int i = 0; i < jsonArray4.length(); ++i) {
                                        access$2 = SocialSharing.this.getFileUriAndSetType(intent, access$2, jsonArray4.getString(i), s2);
                                        if (access$2 != null) {
                                            list.add(access$2);
                                        }
                                    }
                                    if (!list.isEmpty()) {
                                        intent.putExtra("android.intent.extra.STREAM", (Serializable)list);
                                    }
                                }
                                intent.setType("application/octet-stream");
                                SocialSharing.this.cordova.startActivityForResult(SocialSharing.this, Intent.createChooser(intent, (CharSequence)"Choose Email App"), 2);
                                return;
                                intent.putExtra("android.intent.extra.TEXT", s);
                                intent.setType("text/plain");
                                continue Label_0227_Outer;
                            }
                            catch (Exception ex) {
                                SocialSharing.this.callbackContext.error(ex.getMessage());
                                continue;
                            }
                            break;
                        }
                        break;
                    }
                }
            }
        });
        return true;
    }
    
    private boolean invokeSMSIntent(final String s, final String s2) {
        String phoneNumbersWithManufacturerSpecificSeparators = getPhoneNumbersWithManufacturerSpecificSeparators(s2);
        while (true) {
            Intent intent = null;
            final StringBuilder sb;
            Label_0094: {
                if (Build$VERSION.SDK_INT < 19) {
                    break Label_0094;
                }
                intent = new Intent("android.intent.action.SENDTO");
                sb = new StringBuilder("smsto:");
                if (notEmpty(phoneNumbersWithManufacturerSpecificSeparators)) {
                    break Label_0094;
                }
                Label_0087: {
                    break Label_0087;
                Block_4_Outer:
                    while (true) {
                        intent.putExtra("sms_body", s);
                        try {
                            this.cordova.startActivityForResult(this, intent, 0);
                            return true;
                            phoneNumbersWithManufacturerSpecificSeparators = "";
                            break;
                            while (true) {
                                intent.putExtra("address", phoneNumbersWithManufacturerSpecificSeparators);
                                continue Block_4_Outer;
                                intent = new Intent("android.intent.action.VIEW");
                                intent.setType("vnd.android-dir/mms-sms");
                                continue;
                            }
                        }
                        // iftrue(Label_0062:, phoneNumbersWithManufacturerSpecificSeparators == null)
                        catch (ActivityNotFoundException ex) {
                            return false;
                        }
                    }
                }
            }
            intent.setData(Uri.parse(sb.append(phoneNumbersWithManufacturerSpecificSeparators).toString()));
            continue;
        }
    }
    
    private boolean isEmailAvailable() {
        return this.cordova.getActivity().getPackageManager().queryIntentActivities(new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", "someone@domain.com", (String)null)), 0).size() > 1;
    }
    
    private static boolean notEmpty(final String s) {
        return s != null && !"".equals(s) && !"null".equalsIgnoreCase(s);
    }
    
    public static String sanitizeFilename(final String s) {
        return s.replaceAll("[:\\\\/*?|<> ]", "_");
    }
    
    private void saveFile(final byte[] b, final String pathname, final String child) throws IOException {
        final FileOutputStream fileOutputStream = new FileOutputStream(new File(new File(pathname), child));
        fileOutputStream.write(b);
        fileOutputStream.flush();
        fileOutputStream.close();
    }
    
    private static String[] toStringArray(final JSONArray jsonArray) throws JSONException {
        final String[] array = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); ++i) {
            array[i] = jsonArray.getString(i);
        }
        return array;
    }
    
    @Override
    public boolean execute(final String str, final JSONArray jsonArray, final CallbackContext callbackContext) throws JSONException {
        this.callbackContext = callbackContext;
        if ("available".equals(str)) {
            this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
            return true;
        }
        if ("share".equals(str)) {
            return this.doSendIntent(jsonArray.getString(0), jsonArray.getString(1), jsonArray.getJSONArray(2), jsonArray.getString(3), null, false);
        }
        if ("shareViaTwitter".equals(str)) {
            return this.doSendIntent(jsonArray.getString(0), jsonArray.getString(1), jsonArray.getJSONArray(2), jsonArray.getString(3), "twitter", false);
        }
        if ("shareViaFacebook".equals(str)) {
            return this.doSendIntent(jsonArray.getString(0), jsonArray.getString(1), jsonArray.getJSONArray(2), jsonArray.getString(3), "com.facebook.katana", false);
        }
        if ("shareViaWhatsApp".equals(str)) {
            return this.doSendIntent(jsonArray.getString(0), jsonArray.getString(1), jsonArray.getJSONArray(2), jsonArray.getString(3), "whatsapp", false);
        }
        if ("canShareVia".equals(str)) {
            return this.doSendIntent(jsonArray.getString(0), jsonArray.getString(1), jsonArray.getJSONArray(2), jsonArray.getString(3), jsonArray.getString(4), true);
        }
        if ("canShareViaEmail".equals(str)) {
            if (this.isEmailAvailable()) {
                this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
                return true;
            }
            this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, "not available"));
            return false;
        }
        else {
            if ("shareVia".equals(str)) {
                return this.doSendIntent(jsonArray.getString(0), jsonArray.getString(1), jsonArray.getJSONArray(2), jsonArray.getString(3), jsonArray.getString(4), false);
            }
            if ("shareViaSMS".equals(str)) {
                return this.invokeSMSIntent(jsonArray.getString(0), jsonArray.getString(1));
            }
            if ("shareViaEmail".equals(str)) {
                final String string = jsonArray.getString(0);
                final String string2 = jsonArray.getString(1);
                final JSONArray jsonArray2 = jsonArray.getJSONArray(2);
                JSONArray jsonArray3;
                if (jsonArray.isNull(3)) {
                    jsonArray3 = null;
                }
                else {
                    jsonArray3 = jsonArray.getJSONArray(3);
                }
                JSONArray jsonArray4;
                if (jsonArray.isNull(4)) {
                    jsonArray4 = null;
                }
                else {
                    jsonArray4 = jsonArray.getJSONArray(4);
                }
                JSONArray jsonArray5;
                if (jsonArray.isNull(5)) {
                    jsonArray5 = null;
                }
                else {
                    jsonArray5 = jsonArray.getJSONArray(5);
                }
                return this.invokeEmailIntent(string, string2, jsonArray2, jsonArray3, jsonArray4, jsonArray5);
            }
            this.callbackContext.error("socialSharing." + str + " is not a supported function. Did you mean '" + "share" + "'?");
            return false;
        }
    }
    
    @Override
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        if (2 == n) {
            super.onActivityResult(n, n2, intent);
            this.callbackContext.success();
            return;
        }
        this.callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, n2 == -1));
    }
}

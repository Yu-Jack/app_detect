// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.Context;
import org.json.JSONObject;

class AppInfo
{
    private String applicationLabel;
    private JSONObject packageInfoUrlJSON;
    private String packageName;
    private String versionCode;
    private String versionName;
    
    protected AppInfo() {
    }
    
    public AppInfo(final Context context) {
        PackageManager packageManager;
        PackageInfo packageInfo;
        String versionName;
        String string;
        Label_0059_Outer:Label_0080_Outer:
        while (true) {
            this.packageName = context.getPackageName();
            packageManager = context.getPackageManager();
            this.applicationLabel = (String)packageManager.getApplicationLabel(context.getApplicationInfo());
            while (true) {
            Label_0164:
                while (true) {
                    while (true) {
                        try {
                            packageInfo = packageManager.getPackageInfo(this.packageName, 0);
                            if (packageInfo != null) {
                                versionName = packageInfo.versionName;
                                this.versionName = versionName;
                                if (packageInfo != null) {
                                    string = Integer.toString(packageInfo.versionCode);
                                    this.versionCode = string;
                                    JSONUtils.put(this.packageInfoUrlJSON = new JSONObject(), "lbl", this.applicationLabel);
                                    JSONUtils.put(this.packageInfoUrlJSON, "pn", this.packageName);
                                    JSONUtils.put(this.packageInfoUrlJSON, "v", this.versionCode);
                                    JSONUtils.put(this.packageInfoUrlJSON, "vn", this.versionName);
                                    return;
                                }
                                break Label_0164;
                            }
                        }
                        catch (PackageManager$NameNotFoundException ex) {
                            packageInfo = null;
                            continue Label_0059_Outer;
                        }
                        break;
                    }
                    versionName = "";
                    continue Label_0080_Outer;
                }
                string = "";
                continue;
            }
        }
    }
    
    public JSONObject getPackageInfoJSON() {
        return this.packageInfoUrlJSON;
    }
    
    public String getPackageInfoJSONString() {
        if (this.packageInfoUrlJSON != null) {
            return this.packageInfoUrlJSON.toString();
        }
        return null;
    }
}

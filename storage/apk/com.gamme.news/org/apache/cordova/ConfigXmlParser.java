// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;
import java.util.Locale;
import java.util.List;
import android.util.Log;
import android.content.res.XmlResourceParser;
import android.app.Activity;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class ConfigXmlParser
{
    private static String TAG;
    private Whitelist externalWhitelist;
    private Whitelist internalWhitelist;
    private String launchUrl;
    private ArrayList<PluginEntry> pluginEntries;
    private CordovaPreferences prefs;
    
    static {
        ConfigXmlParser.TAG = "ConfigXmlParser";
    }
    
    public ConfigXmlParser() {
        this.launchUrl = "file:///android_asset/www/index.html";
        this.prefs = new CordovaPreferences();
        this.internalWhitelist = new Whitelist();
        this.externalWhitelist = new Whitelist();
        this.pluginEntries = new ArrayList<PluginEntry>(20);
    }
    
    private void setStartUrl(String substring) {
        if (Pattern.compile("^[a-z-]+://").matcher(substring).find()) {
            this.launchUrl = substring;
            return;
        }
        if (substring.charAt(0) == '/') {
            substring = substring.substring(1);
        }
        this.launchUrl = "file:///android_asset/www/" + substring;
    }
    
    public Whitelist getExternalWhitelist() {
        return this.externalWhitelist;
    }
    
    public Whitelist getInternalWhitelist() {
        return this.internalWhitelist;
    }
    
    public String getLaunchUrl() {
        return this.launchUrl;
    }
    
    public ArrayList<PluginEntry> getPluginEntries() {
        return this.pluginEntries;
    }
    
    public CordovaPreferences getPreferences() {
        return this.prefs;
    }
    
    public void parse(final Activity activity) {
        int n = activity.getResources().getIdentifier("config", "xml", activity.getClass().getPackage().getName());
        if (n == 0) {
            n = activity.getResources().getIdentifier("config", "xml", activity.getPackageName());
            if (n == 0) {
                LOG.e(ConfigXmlParser.TAG, "res/xml/config.xml is missing!");
                return;
            }
        }
        this.parse(activity.getResources().getXml(n));
    }
    
    public void parse(final XmlResourceParser xmlResourceParser) {
        int i = -1;
        String str = "";
        String attributeValue = "";
        boolean equals = false;
        int n = 0;
        ArrayList<String> list = null;
        this.internalWhitelist.addWhiteListEntry("file:///*", false);
        this.internalWhitelist.addWhiteListEntry("content:///*", false);
        this.internalWhitelist.addWhiteListEntry("data:*", false);
        String name;
        String attributeValue2;
        String attributeValue3;
        String attributeValue4;
        boolean b;
        String attributeValue5;
        Label_0139_Outer:Block_15_Outer:
        while (i != 1) {
            Label_0558: {
                if (i != 2) {
                    break Label_0558;
                }
                name = xmlResourceParser.getName();
                Label_0153: {
                    if (!name.equals("url-filter")) {
                        break Label_0153;
                    }
                    Log.w(ConfigXmlParser.TAG, "Plugin " + str + " is using deprecated tag <url-filter>");
                    if (list == null) {
                        list = new ArrayList<String>(2);
                    }
                    list.add(xmlResourceParser.getAttributeValue((String)null, "value"));
                    try {
                        // iftrue(Label_0139:, !name.equals((Object)"content"))
                        // iftrue(Label_0384:, xmlResourceParser.getAttributeValue((String)null, "launch-external") == null)
                        // iftrue(Label_0139:, attributeValue3 == null)
                        // iftrue(Label_0291:, n == 0 || !name.equals((Object)"param"))
                        // iftrue(Label_0429:, !"*".equals((Object)attributeValue3))
                        // iftrue(Label_0139:, attributeValue2 == null)
                        // iftrue(Label_0179:, !name.equals((Object)"feature"))
                        // iftrue(Label_0471:, !name.equals((Object)"access"))
                        // iftrue(Label_0139:, i != 3 || !xmlResourceParser.getName().equals((Object)"feature"))
                        // iftrue(Label_0139:, !attributeValue5.equals((Object)"onload"))
                        // iftrue(Label_0523:, !name.equals((Object)"preference"))
                        // iftrue(Label_0228:, !attributeValue5.equals((Object)"service"))
                        // iftrue(Label_0262:, !attributeValue5.equals((Object)"package") && !attributeValue5.equals((Object)"android-package"))
                        while (true) {
                        Label_0248_Outer:
                            while (true) {
                                i = xmlResourceParser.next();
                                continue Label_0139_Outer;
                                Block_23_Outer:Block_9_Outer:Label_0338_Outer:
                                while (true) {
                                    attributeValue = xmlResourceParser.getAttributeValue((String)null, "value");
                                    continue Label_0248_Outer;
                                Label_0338:
                                    while (true) {
                                        Block_12_Outer:Block_11_Outer:
                                        while (true) {
                                            Block_8: {
                                                Block_18: {
                                                    while (true) {
                                                        while (true) {
                                                            while (true) {
                                                                Block_13: {
                                                                    while (true) {
                                                                        while (true) {
                                                                            Block_22: {
                                                                                break Block_22;
                                                                                this.setStartUrl(attributeValue2);
                                                                                continue Label_0248_Outer;
                                                                                str = xmlResourceParser.getAttributeValue((String)null, "value");
                                                                                continue Label_0248_Outer;
                                                                                attributeValue3 = xmlResourceParser.getAttributeValue((String)null, "origin");
                                                                                attributeValue4 = xmlResourceParser.getAttributeValue((String)null, "subdomains");
                                                                                break Block_13;
                                                                                n = 1;
                                                                                str = xmlResourceParser.getAttributeValue((String)null, "name");
                                                                                continue Label_0248_Outer;
                                                                                break Label_0248_Outer;
                                                                                Label_0179: {
                                                                                    break Block_8;
                                                                                }
                                                                                this.pluginEntries.add(new PluginEntry(str, attributeValue, equals, list));
                                                                                str = "";
                                                                                attributeValue = "";
                                                                                n = 0;
                                                                                equals = false;
                                                                                list = null;
                                                                                continue Label_0248_Outer;
                                                                                Label_0396:
                                                                                break Block_18;
                                                                            }
                                                                            attributeValue2 = xmlResourceParser.getAttributeValue((String)null, "src");
                                                                            continue Block_9_Outer;
                                                                        }
                                                                        equals = "true".equals(xmlResourceParser.getAttributeValue((String)null, "value"));
                                                                        continue Label_0248_Outer;
                                                                        continue Label_0338_Outer;
                                                                    }
                                                                }
                                                                b = true;
                                                                continue Label_0338;
                                                                Label_0291: {
                                                                    continue Label_0338_Outer;
                                                                }
                                                            }
                                                            this.externalWhitelist.addWhiteListEntry(attributeValue3, attributeValue4 != null && attributeValue4.compareToIgnoreCase("true") == 0);
                                                            continue Label_0248_Outer;
                                                            continue Block_11_Outer;
                                                        }
                                                        Label_0262: {
                                                            continue Block_15_Outer;
                                                        }
                                                    }
                                                    Label_0471: {
                                                        break Block_23_Outer;
                                                    }
                                                }
                                                this.internalWhitelist.addWhiteListEntry("http://*/*", false);
                                                this.internalWhitelist.addWhiteListEntry("https://*/*", false);
                                                continue Label_0248_Outer;
                                            }
                                            attributeValue5 = xmlResourceParser.getAttributeValue((String)null, "name");
                                            continue Block_12_Outer;
                                        }
                                        Label_0429: {
                                            this.internalWhitelist.addWhiteListEntry(attributeValue3, attributeValue4 != null && attributeValue4.compareToIgnoreCase("true") == 0);
                                        }
                                        continue Label_0248_Outer;
                                        Label_0384:
                                        b = false;
                                        continue Label_0338;
                                    }
                                    Label_0228: {
                                        continue Block_23_Outer;
                                    }
                                }
                                this.prefs.set(xmlResourceParser.getAttributeValue((String)null, "name").toLowerCase(Locale.ENGLISH), xmlResourceParser.getAttributeValue((String)null, "value"));
                                continue Label_0248_Outer;
                            }
                            continue;
                        }
                    }
                    // iftrue(Label_0396:, b == false)
                    catch (XmlPullParserException ex) {
                        ex.printStackTrace();
                    }
                    catch (IOException ex2) {
                        ex2.printStackTrace();
                    }
                }
            }
        }
    }
}

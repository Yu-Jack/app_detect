// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.globalization;

import org.apache.cordova.PluginResult;
import android.os.Build$VERSION;
import org.apache.cordova.CallbackContext;
import org.json.JSONException;
import java.util.Date;
import java.util.TimeZone;
import android.text.format.Time;
import android.content.Context;
import android.text.format.DateFormat;
import java.text.SimpleDateFormat;
import android.annotation.TargetApi;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;
import java.util.Map;
import java.util.Comparator;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Currency;
import java.text.NumberFormat;
import java.util.Locale;
import java.text.DecimalFormat;
import org.json.JSONObject;
import org.json.JSONArray;
import org.apache.cordova.CordovaPlugin;

public class Globalization extends CordovaPlugin
{
    public static final String CURRENCY = "currency";
    public static final String CURRENCYCODE = "currencyCode";
    public static final String DATE = "date";
    public static final String DATESTRING = "dateString";
    public static final String DATETOSTRING = "dateToString";
    public static final String DAYS = "days";
    public static final String FORMATLENGTH = "formatLength";
    public static final String FULL = "full";
    public static final String GETCURRENCYPATTERN = "getCurrencyPattern";
    public static final String GETDATENAMES = "getDateNames";
    public static final String GETDATEPATTERN = "getDatePattern";
    public static final String GETFIRSTDAYOFWEEK = "getFirstDayOfWeek";
    public static final String GETLOCALENAME = "getLocaleName";
    public static final String GETNUMBERPATTERN = "getNumberPattern";
    public static final String GETPREFERREDLANGUAGE = "getPreferredLanguage";
    public static final String ISDAYLIGHTSAVINGSTIME = "isDayLightSavingsTime";
    public static final String ITEM = "item";
    public static final String LONG = "long";
    public static final String MEDIUM = "medium";
    public static final String MONTHS = "months";
    public static final String NARROW = "narrow";
    public static final String NUMBER = "number";
    public static final String NUMBERSTRING = "numberString";
    public static final String NUMBERTOSTRING = "numberToString";
    public static final String OPTIONS = "options";
    public static final String PERCENT = "percent";
    public static final String SELECTOR = "selector";
    public static final String STRINGTODATE = "stringToDate";
    public static final String STRINGTONUMBER = "stringToNumber";
    public static final String TIME = "time";
    public static final String TYPE = "type";
    public static final String WIDE = "wide";
    
    private JSONObject getCurrencyPattern(final JSONArray jsonArray) throws GlobalizationError {
        final JSONObject jsonObject = new JSONObject();
        try {
            final String string = jsonArray.getJSONObject(0).getString("currencyCode");
            final DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getCurrencyInstance(Locale.getDefault());
            final Currency instance = Currency.getInstance(string);
            decimalFormat.setCurrency(instance);
            jsonObject.put("pattern", (Object)decimalFormat.toPattern());
            jsonObject.put("code", (Object)instance.getCurrencyCode());
            jsonObject.put("fraction", decimalFormat.getMinimumFractionDigits());
            jsonObject.put("rounding", (Object)0);
            jsonObject.put("decimal", (Object)String.valueOf(decimalFormat.getDecimalFormatSymbols().getDecimalSeparator()));
            jsonObject.put("grouping", (Object)String.valueOf(decimalFormat.getDecimalFormatSymbols().getGroupingSeparator()));
            return jsonObject;
        }
        catch (Exception ex) {
            throw new GlobalizationError("FORMATTING_ERROR");
        }
    }
    
    @TargetApi(9)
    private JSONObject getDateNames(final JSONArray jsonArray) throws GlobalizationError {
        while (true) {
            final JSONObject jsonObject = new JSONObject();
            final JSONArray jsonArray2 = new JSONArray();
            final ArrayList list = new ArrayList<String>();
            while (true) {
                int n4;
                try {
                    final int length = jsonArray.getJSONObject(0).length();
                    int n = 0;
                    int n2 = 0;
                    if (length > 0) {
                        final boolean null = ((JSONObject)jsonArray.getJSONObject(0).get("options")).isNull("type");
                        n2 = 0;
                        if (!null) {
                            final boolean equalsIgnoreCase = ((String)((JSONObject)jsonArray.getJSONObject(0).get("options")).get("type")).equalsIgnoreCase("narrow");
                            n2 = 0;
                            if (equalsIgnoreCase) {
                                n2 = 0 + 1;
                            }
                        }
                        final boolean null2 = ((JSONObject)jsonArray.getJSONObject(0).get("options")).isNull("item");
                        n = 0;
                        if (!null2) {
                            final boolean equalsIgnoreCase2 = ((String)((JSONObject)jsonArray.getJSONObject(0).get("options")).get("item")).equalsIgnoreCase("days");
                            n = 0;
                            if (equalsIgnoreCase2) {
                                n = 0 + 10;
                            }
                        }
                    }
                    final int n3 = n + n2;
                    Map<String, Integer> map;
                    if (n3 == 1) {
                        map = Calendar.getInstance().getDisplayNames(2, 1, Locale.getDefault());
                    }
                    else if (n3 == 10) {
                        map = Calendar.getInstance().getDisplayNames(7, 2, Locale.getDefault());
                    }
                    else if (n3 == 11) {
                        map = Calendar.getInstance().getDisplayNames(7, 1, Locale.getDefault());
                    }
                    else {
                        map = Calendar.getInstance().getDisplayNames(2, 2, Locale.getDefault());
                    }
                    final Iterator<String> iterator = map.keySet().iterator();
                    while (iterator.hasNext()) {
                        list.add(iterator.next());
                    }
                    Collections.sort((List<Object>)list, (Comparator<? super Object>)new Comparator<String>() {
                        @Override
                        public int compare(final String s, final String s2) {
                            return map.get(s).compareTo(map.get(s2));
                        }
                    });
                    n4 = 0;
                    if (n4 >= list.size()) {
                        return jsonObject.put("value", (Object)jsonArray2);
                    }
                }
                catch (Exception ex) {
                    throw new GlobalizationError("UNKNOWN_ERROR");
                }
                jsonArray2.put(list.get(n4));
                ++n4;
                continue;
            }
        }
    }
    
    private JSONObject getDatePattern(final JSONArray jsonArray) throws GlobalizationError {
        final JSONObject jsonObject = new JSONObject();
        try {
            SimpleDateFormat simpleDateFormat = (SimpleDateFormat)DateFormat.getDateFormat((Context)this.cordova.getActivity());
            final SimpleDateFormat simpleDateFormat2 = (SimpleDateFormat)DateFormat.getTimeFormat((Context)this.cordova.getActivity());
            String s = String.valueOf(simpleDateFormat.toLocalizedPattern()) + " " + simpleDateFormat2.toLocalizedPattern();
            if (jsonArray.getJSONObject(0).has("options")) {
                final JSONObject jsonObject2 = jsonArray.getJSONObject(0).getJSONObject("options");
                if (!jsonObject2.isNull("formatLength")) {
                    final String string = jsonObject2.getString("formatLength");
                    if (string.equalsIgnoreCase("medium")) {
                        simpleDateFormat = (SimpleDateFormat)DateFormat.getMediumDateFormat((Context)this.cordova.getActivity());
                    }
                    else if (string.equalsIgnoreCase("long") || string.equalsIgnoreCase("full")) {
                        simpleDateFormat = (SimpleDateFormat)DateFormat.getLongDateFormat((Context)this.cordova.getActivity());
                    }
                }
                s = String.valueOf(simpleDateFormat.toLocalizedPattern()) + " " + simpleDateFormat2.toLocalizedPattern();
                if (!jsonObject2.isNull("selector")) {
                    final String string2 = jsonObject2.getString("selector");
                    if (string2.equalsIgnoreCase("date")) {
                        s = simpleDateFormat.toLocalizedPattern();
                    }
                    else if (string2.equalsIgnoreCase("time")) {
                        s = simpleDateFormat2.toLocalizedPattern();
                    }
                }
            }
            final TimeZone timeZone = TimeZone.getTimeZone(Time.getCurrentTimezone());
            jsonObject.put("pattern", (Object)s);
            jsonObject.put("timezone", (Object)timeZone.getDisplayName(timeZone.inDaylightTime(Calendar.getInstance().getTime()), 0));
            jsonObject.put("utc_offset", timeZone.getRawOffset() / 1000);
            jsonObject.put("dst_offset", timeZone.getDSTSavings() / 1000);
            return jsonObject;
        }
        catch (Exception ex) {
            throw new GlobalizationError("PATTERN_ERROR");
        }
    }
    
    private JSONObject getDateToString(final JSONArray jsonArray) throws GlobalizationError {
        final JSONObject jsonObject = new JSONObject();
        try {
            return jsonObject.put("value", (Object)new SimpleDateFormat(this.getDatePattern(jsonArray).getString("pattern")).format(new Date((long)jsonArray.getJSONObject(0).get("date"))));
        }
        catch (Exception ex) {
            throw new GlobalizationError("FORMATTING_ERROR");
        }
    }
    
    private JSONObject getFirstDayOfWeek(final JSONArray jsonArray) throws GlobalizationError {
        final JSONObject jsonObject = new JSONObject();
        try {
            return jsonObject.put("value", Calendar.getInstance(Locale.getDefault()).getFirstDayOfWeek());
        }
        catch (Exception ex) {
            throw new GlobalizationError("UNKNOWN_ERROR");
        }
    }
    
    private JSONObject getIsDayLightSavingsTime(final JSONArray jsonArray) throws GlobalizationError {
        final JSONObject jsonObject = new JSONObject();
        try {
            return jsonObject.put("dst", TimeZone.getTimeZone(Time.getCurrentTimezone()).inDaylightTime(new Date((long)jsonArray.getJSONObject(0).get("date"))));
        }
        catch (Exception ex) {
            throw new GlobalizationError("UNKNOWN_ERROR");
        }
    }
    
    private JSONObject getLocaleName() throws GlobalizationError {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("value", (Object)this.toBcp47Language(Locale.getDefault()));
            return jsonObject;
        }
        catch (Exception ex) {
            throw new GlobalizationError("UNKNOWN_ERROR");
        }
    }
    
    private DecimalFormat getNumberFormatInstance(final JSONArray jsonArray) throws JSONException {
        final DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getInstance(Locale.getDefault());
        try {
            if (jsonArray.getJSONObject(0).length() > 1 && !((JSONObject)jsonArray.getJSONObject(0).get("options")).isNull("type")) {
                final String s = (String)((JSONObject)jsonArray.getJSONObject(0).get("options")).get("type");
                if (s.equalsIgnoreCase("currency")) {
                    return (DecimalFormat)NumberFormat.getCurrencyInstance(Locale.getDefault());
                }
                if (s.equalsIgnoreCase("percent")) {
                    return (DecimalFormat)NumberFormat.getPercentInstance(Locale.getDefault());
                }
            }
        }
        catch (JSONException ex) {}
        return decimalFormat;
    }
    
    private JSONObject getNumberPattern(final JSONArray jsonArray) throws GlobalizationError {
        final JSONObject jsonObject = new JSONObject();
        try {
            DecimalFormat decimalFormat = (DecimalFormat)NumberFormat.getInstance(Locale.getDefault());
            String s = String.valueOf(decimalFormat.getDecimalFormatSymbols().getDecimalSeparator());
            if (jsonArray.getJSONObject(0).length() > 0 && !((JSONObject)jsonArray.getJSONObject(0).get("options")).isNull("type")) {
                final String s2 = (String)((JSONObject)jsonArray.getJSONObject(0).get("options")).get("type");
                if (s2.equalsIgnoreCase("currency")) {
                    decimalFormat = (DecimalFormat)NumberFormat.getCurrencyInstance(Locale.getDefault());
                    s = decimalFormat.getDecimalFormatSymbols().getCurrencySymbol();
                }
                else if (s2.equalsIgnoreCase("percent")) {
                    decimalFormat = (DecimalFormat)NumberFormat.getPercentInstance(Locale.getDefault());
                    s = String.valueOf(decimalFormat.getDecimalFormatSymbols().getPercent());
                }
            }
            jsonObject.put("pattern", (Object)decimalFormat.toPattern());
            jsonObject.put("symbol", (Object)s);
            jsonObject.put("fraction", decimalFormat.getMinimumFractionDigits());
            jsonObject.put("rounding", (Object)0);
            jsonObject.put("positive", (Object)decimalFormat.getPositivePrefix());
            jsonObject.put("negative", (Object)decimalFormat.getNegativePrefix());
            jsonObject.put("decimal", (Object)String.valueOf(decimalFormat.getDecimalFormatSymbols().getDecimalSeparator()));
            jsonObject.put("grouping", (Object)String.valueOf(decimalFormat.getDecimalFormatSymbols().getGroupingSeparator()));
            return jsonObject;
        }
        catch (Exception ex) {
            throw new GlobalizationError("PATTERN_ERROR");
        }
    }
    
    private JSONObject getNumberToString(final JSONArray jsonArray) throws GlobalizationError {
        final JSONObject jsonObject = new JSONObject();
        try {
            return jsonObject.put("value", (Object)this.getNumberFormatInstance(jsonArray).format(jsonArray.getJSONObject(0).get("number")));
        }
        catch (Exception ex) {
            throw new GlobalizationError("FORMATTING_ERROR");
        }
    }
    
    private JSONObject getPreferredLanguage() throws GlobalizationError {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("value", (Object)this.toBcp47Language(Locale.getDefault()));
            return jsonObject;
        }
        catch (Exception ex) {
            throw new GlobalizationError("UNKNOWN_ERROR");
        }
    }
    
    private JSONObject getStringToNumber(final JSONArray jsonArray) throws GlobalizationError {
        final JSONObject jsonObject = new JSONObject();
        try {
            return jsonObject.put("value", (Object)this.getNumberFormatInstance(jsonArray).parse((String)jsonArray.getJSONObject(0).get("numberString")));
        }
        catch (Exception ex) {
            throw new GlobalizationError("PARSING_ERROR");
        }
    }
    
    private JSONObject getStringtoDate(final JSONArray jsonArray) throws GlobalizationError {
        final JSONObject jsonObject = new JSONObject();
        try {
            final Date parse = new SimpleDateFormat(this.getDatePattern(jsonArray).getString("pattern")).parse(jsonArray.getJSONObject(0).get("dateString").toString());
            final Time time = new Time();
            time.set(parse.getTime());
            jsonObject.put("year", time.year);
            jsonObject.put("month", time.month);
            jsonObject.put("day", time.monthDay);
            jsonObject.put("hour", time.hour);
            jsonObject.put("minute", time.minute);
            jsonObject.put("second", time.second);
            jsonObject.put("millisecond", (Object)0L);
            return jsonObject;
        }
        catch (Exception ex) {
            throw new GlobalizationError("PARSING_ERROR");
        }
    }
    
    private String toBcp47Language(final Locale locale) {
        String language = locale.getLanguage();
        String country = locale.getCountry();
        String variant = locale.getVariant();
        if (language.equals("no") && country.equals("NO") && variant.equals("NY")) {
            language = "nn";
            country = "NO";
            variant = "";
        }
        if (language.isEmpty() || !language.matches("\\p{Alpha}{2,8}")) {
            language = "und";
        }
        else if (language.equals("iw")) {
            language = "he";
        }
        else if (language.equals("in")) {
            language = "id";
        }
        else if (language.equals("ji")) {
            language = "yi";
        }
        if (!country.matches("\\p{Alpha}{2}|\\p{Digit}{3}")) {
            country = "";
        }
        if (!variant.matches("\\p{Alnum}{5,8}|\\p{Digit}\\p{Alnum}{3}")) {
            variant = "";
        }
        final StringBuilder sb = new StringBuilder(language);
        if (!country.isEmpty()) {
            sb.append('-').append(country);
        }
        if (!variant.isEmpty()) {
            sb.append('-').append(variant);
        }
        return sb.toString();
    }
    
    @Override
    public boolean execute(final String s, final JSONArray jsonArray, final CallbackContext callbackContext) {
        new JSONObject();
        try {
            JSONObject jsonObject;
            if (s.equals("getLocaleName")) {
                jsonObject = this.getLocaleName();
            }
            else if (s.equals("getPreferredLanguage")) {
                jsonObject = this.getPreferredLanguage();
            }
            else if (s.equalsIgnoreCase("dateToString")) {
                jsonObject = this.getDateToString(jsonArray);
            }
            else if (s.equalsIgnoreCase("stringToDate")) {
                jsonObject = this.getStringtoDate(jsonArray);
            }
            else if (s.equalsIgnoreCase("getDatePattern")) {
                jsonObject = this.getDatePattern(jsonArray);
            }
            else {
                if (s.equalsIgnoreCase("getDateNames") && Build$VERSION.SDK_INT < 9) {
                    throw new GlobalizationError("UNKNOWN_ERROR");
                }
                goto Label_0169;
            }
            callbackContext.success(jsonObject);
        }
        catch (GlobalizationError globalizationError) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.ERROR, globalizationError.toJson()));
        }
        catch (Exception ex) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.JSON_EXCEPTION));
        }
        return true;
    }
}

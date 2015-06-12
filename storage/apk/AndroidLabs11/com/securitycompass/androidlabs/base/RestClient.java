// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.androidlabs.base;

import java.util.Iterator;
import android.util.Log;
import java.io.DataOutputStream;
import java.util.Map;
import java.util.HashMap;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import android.accounts.AuthenticatorException;
import org.json.JSONArray;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;
import javax.net.ssl.TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import javax.net.ssl.HostnameVerifier;

public class RestClient
{
    public static final int ERROR_ACCOUNT_NOT_EXIST = 3;
    public static final int ERROR_BALANCE_TOO_LOW = 4;
    public static final int ERROR_CREDENTIALS = 1;
    public static final int ERROR_FORBIDDEN = 5;
    public static final int ERROR_PERMISSION_DENIED = 6;
    public static final int ERROR_SESSION_KEY = 2;
    public static final int NO_OP = -2;
    public static final int NULL_ERROR = -1;
    private static final String TAG = "RestClient";
    private BankingApplication mAppState;
    private HostnameVerifier mHostnameVerifier;
    private boolean mHttpsMode;
    
    public RestClient(final BankingApplication mAppState, final boolean mHttpsMode) throws NoSuchAlgorithmException, KeyManagementException {
        this.mAppState = mAppState;
        this.mHttpsMode = mHttpsMode;
        this.setLaxSSL();
    }
    
    private void setLaxSSL() throws NoSuchAlgorithmException, KeyManagementException {
        final TrustManager[] tm = { new X509TrustManager() {
                @Override
                public void checkClientTrusted(final X509Certificate[] array, final String s) throws CertificateException {
                }
                
                @Override
                public void checkServerTrusted(final X509Certificate[] array, final String s) throws CertificateException {
                }
                
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            } };
        final SSLContext instance = SSLContext.getInstance("TLS");
        instance.init(null, tm, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
        this.mHostnameVerifier = (HostnameVerifier)new AllowAllHostnameVerifier();
    }
    
    public List<Account> getAccounts(final String str, final String str2) throws JSONException, IOException, AuthenticatorException {
        final ArrayList<Account> list = new ArrayList<Account>();
        String str3;
        if (this.mHttpsMode) {
            str3 = "https://";
        }
        else {
            str3 = "http://";
        }
        final String string = str3 + str + ":" + str2 + "/accounts" + "?session_key=" + URLEncoder.encode(this.mAppState.getSessionKey());
        String s;
        if (this.mHttpsMode) {
            s = this.getHttpsContent(string);
        }
        else {
            s = this.getHttpContent(string);
        }
        final int error = this.parseError(s);
        if (error == -1) {
            final JSONArray jsonArray = new JSONArray(s);
            for (int i = 0; i < jsonArray.length(); ++i) {
                final JSONObject jsonObject = jsonArray.getJSONObject(i);
                list.add(new Account(jsonObject.getInt("account_number"), jsonObject.getString("type"), jsonObject.getDouble("balance")));
            }
        }
        else if (error == 2) {
            throw new AuthenticatorException("Session key invalid");
        }
        return list;
    }
    
    public String getHttpContent(final String spec) throws IOException {
        final StringBuilder sb = new StringBuilder();
        final HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(spec).openConnection();
        if (httpURLConnection.getResponseCode() == 200) {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while (true) {
                final String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
            httpURLConnection.disconnect();
        }
        return sb.toString();
    }
    
    public String getHttpsContent(final String spec) throws IOException {
        final StringBuilder sb = new StringBuilder();
        final HttpsURLConnection httpsURLConnection = (HttpsURLConnection)new URL(spec).openConnection();
        if (this.mHostnameVerifier != null) {
            httpsURLConnection.setHostnameVerifier(this.mHostnameVerifier);
        }
        if (httpsURLConnection.getResponseCode() == 200) {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            while (true) {
                final String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
            }
            httpsURLConnection.disconnect();
        }
        return sb.toString();
    }
    
    public String getStatement(final String str, final String str2) throws IOException, AuthenticatorException {
        String str3;
        if (this.mHttpsMode) {
            str3 = "https://";
        }
        else {
            str3 = "http://";
        }
        final String string = str3 + str + ":" + str2 + "/statement" + "?session_key=" + URLEncoder.encode(this.mAppState.getSessionKey());
        String s;
        if (this.mHttpsMode) {
            s = this.getHttpsContent(string);
        }
        else {
            s = this.getHttpContent(string);
        }
        final int error = this.parseError(s);
        if (error != -1 && error == 2) {
            throw new AuthenticatorException("Session key invalid");
        }
        return s;
    }
    
    public int parseError(final String s) {
        if (s == null || s.equals("")) {
            return -1;
        }
        try {
            return Integer.parseInt(new JSONObject(s).getString("error").trim().substring(1));
        }
        catch (JSONException ex) {
            return -1;
        }
    }
    
    public int performLogin(final String str, final String str2, final String s, final String s2) throws JSONException, IOException, HttpException {
        String str3;
        if (this.mHttpsMode) {
            str3 = "https://";
        }
        else {
            str3 = "http://";
        }
        final String string = str3 + str + ":" + str2 + "/login";
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("username", s);
        hashMap.put("password", s2);
        String s3;
        if (this.mHttpsMode) {
            s3 = this.postHttpsContent(string, hashMap);
        }
        else {
            s3 = this.postHttpContent(string, hashMap);
        }
        final int error = this.parseError(s3);
        if (error == -1) {
            final JSONObject jsonObject = new JSONObject(s3);
            this.mAppState.setSession(jsonObject.getString("key"), jsonObject.getString("created"));
        }
        return error;
    }
    
    public String postHttpContent(final String s, final Map<String, String> map) throws IOException, HttpException {
        String string = "";
        final HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(s).openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        String string2 = "";
        for (final String str : map.keySet()) {
            string2 = string2 + "&" + str + "=" + map.get(str);
        }
        final String substring = string2.substring(1);
        final DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.writeBytes(substring);
        dataOutputStream.flush();
        dataOutputStream.close();
        final int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while (true) {
                final String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                string += line;
            }
            return string;
        }
        Log.e("RestClient", "HTTP request failed on: " + s + " With error code: " + responseCode);
        throw new HttpException(responseCode);
    }
    
    public String postHttpsContent(final String s, final Map<String, String> map) throws IOException, HttpException {
        String string = "";
        final HttpsURLConnection httpsURLConnection = (HttpsURLConnection)new URL(s).openConnection();
        if (this.mHostnameVerifier != null) {
            httpsURLConnection.setHostnameVerifier(this.mHostnameVerifier);
        }
        httpsURLConnection.setDoInput(true);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setUseCaches(false);
        httpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        String string2 = "";
        for (final String str : map.keySet()) {
            string2 = string2 + "&" + str + "=" + map.get(str);
        }
        final String substring = string2.substring(1);
        final DataOutputStream dataOutputStream = new DataOutputStream(httpsURLConnection.getOutputStream());
        dataOutputStream.writeBytes(substring);
        dataOutputStream.flush();
        dataOutputStream.close();
        final int responseCode = httpsURLConnection.getResponseCode();
        if (responseCode == 200) {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
            while (true) {
                final String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                string += line;
            }
            return string;
        }
        Log.e("RestClient", "HTTPs request failed on: " + s + " With error code: " + responseCode);
        throw new HttpException(responseCode);
    }
    
    public int transfer(final String s, final String s2, final int i, final int j, final double d, final String s3) throws IOException, HttpException {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("from_account", Integer.toString(i));
        hashMap.put("to_account", Integer.toString(j));
        hashMap.put("amount", Double.toString(d));
        String s4;
        if (this.mHttpsMode) {
            s4 = this.postHttpsContent("https://" + s + ":" + s2 + "/transfer" + "?session_key=" + URLEncoder.encode(s3), hashMap);
        }
        else {
            s4 = this.postHttpContent("http://" + s + ":" + s2 + "/transfer" + "?session_key=" + URLEncoder.encode(s3), hashMap);
        }
        return this.parseError(s4);
    }
}

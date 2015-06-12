// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.androidlabs.base;

import android.content.SharedPreferences$Editor;
import java.security.SecureRandom;
import android.os.Environment;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import org.json.JSONException;
import java.util.Iterator;
import android.util.Log;
import java.util.List;
import android.accounts.AuthenticatorException;
import java.security.KeyManagementException;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import android.util.Base64;
import java.security.MessageDigest;
import android.os.Handler;
import android.app.Application;

public class BankingApplication extends Application
{
    private static final int HASH_ITERATIONS = 1000;
    public static final String PREF_FIRST_RUN = "firstrun";
    public static final String PREF_LOCALPASS_HASH = "localpasshash";
    public static final String PREF_LOCALPASS_SALT = "localpasssalt";
    public static final String PREF_REST_PASSWORD = "serverpass";
    public static final String PREF_REST_USER = "serveruser";
    public static final String SHARED_PREFS = "preferences";
    public static final String TAG = "BankingApplication";
    public Runnable checkBackgroundTask;
    private int foregroundedActivities;
    private boolean locked;
    private String mStatementDir;
    private String sessionCreateDate;
    private String sessionKey;
    private Handler timingHandler;
    
    public BankingApplication() {
        this.checkBackgroundTask = new Runnable() {
            @Override
            public void run() {
                BankingApplication.this.checkIfBackgrounded();
            }
        };
    }
    
    private String hash(final String s, final byte[] array) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        final byte[] bytes = s.getBytes("UTF-8");
        final MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.reset();
        instance.update(array);
        byte[] input = instance.digest(bytes);
        for (int i = 0; i < 1000; ++i) {
            instance.reset();
            instance.update(array);
            input = instance.digest(input);
        }
        return new String(Base64.encode(input, 0));
    }
    
    public void checkIfBackgrounded() {
        if (this.foregroundedActivities == 0) {
            this.lockApplication();
        }
    }
    
    public boolean checkPassword(final String s) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return this.hash(s, Base64.decode(this.getSharedPrefs().getString("localpasssalt", ""), 0)).equals(this.getSharedPrefs().getString("localpasshash", ""));
    }
    
    public void clearStatements() {
        final File[] listFiles = new File(this.mStatementDir).listFiles();
        if (listFiles != null) {
            for (int length = listFiles.length, i = 0; i < length; ++i) {
                listFiles[i].delete();
            }
        }
    }
    
    public void downloadStatement() throws IOException, NoSuchAlgorithmException, KeyManagementException, AuthenticatorException {
        final String statement = new RestClient(this, this.isHttpsEnabled()).getStatement(this.getRestServer(), this.getPort());
        final File file = new File(this.mStatementDir, Long.toString(System.currentTimeMillis()) + ".html");
        new File(this.mStatementDir).mkdirs();
        final FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(statement);
        fileWriter.flush();
        fileWriter.close();
    }
    
    public List<Account> getAccounts() throws JSONException, IOException, AuthenticatorException, NoSuchAlgorithmException, KeyManagementException {
        final RestClient restClient = new RestClient(this, this.isHttpsEnabled());
        List<Account> accounts;
        String string;
        try {
            accounts = restClient.getAccounts(this.getRestServer(), this.getPort());
            string = "Accounts:\n";
            final Iterator<Account> iterator = accounts.iterator();
            while (iterator.hasNext()) {
                string = string + iterator.next().toString() + "\n";
            }
        }
        catch (AuthenticatorException ex) {
            this.lockApplication();
            throw ex;
        }
        Log.i("BankingApplication", string);
        return accounts;
    }
    
    public String getPort() {
        if (this.isHttpsEnabled()) {
            return PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext()).getString("httpsport", "8443");
        }
        return PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext()).getString("httpport", "8080");
    }
    
    public String getRestPassword() {
        return this.getSharedPrefs().getString("serverpass", "");
    }
    
    public String getRestServer() {
        return PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext()).getString("bankserviceaddress", "10.0.2.2");
    }
    
    public String getRestUsername() {
        return this.getSharedPrefs().getString("serveruser", "");
    }
    
    public String getSessionCreateDate() {
        return this.sessionCreateDate;
    }
    
    public String getSessionKey() {
        return this.sessionKey;
    }
    
    public SharedPreferences getSharedPrefs() {
        return this.getSharedPreferences("preferences", 1);
    }
    
    public String getStatementDir() {
        return this.mStatementDir;
    }
    
    public boolean isHttpsEnabled() {
        return PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext()).getBoolean("httpsenabled", false);
    }
    
    public boolean isLocked() {
        return this.locked;
    }
    
    public void lockApplication() {
        this.locked = true;
    }
    
    public void onCreate() {
        super.onCreate();
        this.timingHandler = new Handler();
        this.foregroundedActivities = 0;
        this.locked = true;
        Log.i("BankingApplication", this.mStatementDir = Environment.getExternalStorageDirectory().toString() + "/androidlabs/");
    }
    
    public int performLogin(final String s, final String s2) throws JSONException, IOException, KeyManagementException, HttpException, NoSuchAlgorithmException {
        return new RestClient(this, this.isHttpsEnabled()).performLogin(this.getRestServer(), this.getPort(), s, s2);
    }
    
    public void registerActivityBackgrounded() {
        --this.foregroundedActivities;
        this.timingHandler.removeCallbacks(this.checkBackgroundTask);
        this.timingHandler.postDelayed(this.checkBackgroundTask, 2000L);
    }
    
    public void registerActivityForegrounded() {
        ++this.foregroundedActivities;
    }
    
    public void setLocalPassword(final String s) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        final SecureRandom instance = SecureRandom.getInstance("SHA1PRNG");
        final byte[] bytes = new byte[32];
        instance.nextBytes(bytes);
        final String hash = this.hash(s, bytes);
        final String s2 = new String(Base64.encode(bytes, 0));
        final SharedPreferences$Editor edit = this.getSharedPrefs().edit();
        edit.putString("localpasshash", hash);
        edit.putString("localpasssalt", s2);
        edit.commit();
    }
    
    public void setServerCredentials(final String s, final String s2) {
        final SharedPreferences$Editor edit = this.getSharedPrefs().edit();
        edit.putString("serveruser", s);
        edit.putString("serverpass", s2);
        edit.commit();
    }
    
    public void setSession(final String sessionKey, final String sessionCreateDate) {
        this.sessionKey = sessionKey;
        this.sessionCreateDate = sessionCreateDate;
    }
    
    public int transferFunds(final int n, final int n2, final double n3) throws IOException, NoSuchAlgorithmException, KeyManagementException, HttpException {
        return new RestClient(this, this.isHttpsEnabled()).transfer(this.getRestServer(), this.getPort(), n, n2, n3, this.sessionKey);
    }
    
    public int unlockApplication(final String s) throws UnsupportedEncodingException, NoSuchAlgorithmException, IOException, JSONException, KeyManagementException, HttpException {
        if (this.checkPassword(s)) {
            final int performLogin = this.performLogin(this.getRestUsername(), this.getRestPassword());
            if (performLogin == -1) {
                this.locked = false;
                return performLogin;
            }
        }
        return -2;
    }
}

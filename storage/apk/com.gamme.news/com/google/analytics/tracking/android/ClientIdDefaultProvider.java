// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import java.io.FileInputStream;
import java.util.UUID;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import com.google.android.gms.common.util.VisibleForTesting;
import android.content.Context;

class ClientIdDefaultProvider implements DefaultProvider
{
    private static ClientIdDefaultProvider sInstance;
    private static final Object sInstanceLock;
    private String mClientId;
    private boolean mClientIdLoaded;
    private final Object mClientIdLock;
    private final Context mContext;
    
    static {
        sInstanceLock = new Object();
    }
    
    protected ClientIdDefaultProvider(final Context mContext) {
        this.mClientIdLoaded = false;
        this.mClientIdLock = new Object();
        this.mContext = mContext;
        this.asyncInitializeClientId();
    }
    
    private void asyncInitializeClientId() {
        new Thread("client_id_fetcher") {
            @Override
            public void run() {
                synchronized (ClientIdDefaultProvider.this.mClientIdLock) {
                    ClientIdDefaultProvider.this.mClientId = ClientIdDefaultProvider.this.initializeClientId();
                    ClientIdDefaultProvider.this.mClientIdLoaded = true;
                    ClientIdDefaultProvider.this.mClientIdLock.notifyAll();
                }
            }
        }.start();
    }
    
    private String blockingGetClientId() {
        Label_0042: {
            if (this.mClientIdLoaded) {
                break Label_0042;
            }
            synchronized (this.mClientIdLock) {
                Label_0040: {
                    if (this.mClientIdLoaded) {
                        break Label_0040;
                    }
                    Log.v("Waiting for clientId to load");
                    try {
                        do {
                            this.mClientIdLock.wait();
                        } while (!this.mClientIdLoaded);
                        // monitorexit(this.mClientIdLock)
                        Log.v("Loaded clientId");
                        return this.mClientId;
                    }
                    catch (InterruptedException obj) {
                        Log.e("Exception while waiting for clientId: " + obj);
                    }
                }
            }
        }
    }
    
    @VisibleForTesting
    static void dropInstance() {
        synchronized (ClientIdDefaultProvider.sInstanceLock) {
            ClientIdDefaultProvider.sInstance = null;
        }
    }
    
    public static ClientIdDefaultProvider getProvider() {
        synchronized (ClientIdDefaultProvider.sInstanceLock) {
            return ClientIdDefaultProvider.sInstance;
        }
    }
    
    public static void initializeProvider(final Context context) {
        synchronized (ClientIdDefaultProvider.sInstanceLock) {
            if (ClientIdDefaultProvider.sInstance == null) {
                ClientIdDefaultProvider.sInstance = new ClientIdDefaultProvider(context);
            }
        }
    }
    
    private boolean storeClientId(final String s) {
        try {
            Log.v("Storing clientId.");
            final FileOutputStream openFileOutput = this.mContext.openFileOutput("gaClientId", 0);
            openFileOutput.write(s.getBytes());
            openFileOutput.close();
            return true;
        }
        catch (FileNotFoundException ex) {
            Log.e("Error creating clientId file.");
            return false;
        }
        catch (IOException ex2) {
            Log.e("Error writing to clientId file.");
            return false;
        }
    }
    
    protected String generateClientId() {
        String lowerCase = UUID.randomUUID().toString().toLowerCase();
        if (!this.storeClientId(lowerCase)) {
            lowerCase = "0";
        }
        return lowerCase;
    }
    
    @Override
    public String getValue(final String anObject) {
        if ("&cid".equals(anObject)) {
            return this.blockingGetClientId();
        }
        return null;
    }
    
    @VisibleForTesting
    String initializeClientId() {
        String generateClientId = null;
        while (true) {
            FileInputStream openFileInput = null;
            String s = null;
            try {
                openFileInput = this.mContext.openFileInput("gaClientId");
                final byte[] array = new byte[128];
                final int read = openFileInput.read(array, 0, 128);
                if (openFileInput.available() > 0) {
                    Log.e("clientId file seems corrupted, deleting it.");
                    openFileInput.close();
                    this.mContext.deleteFile("gaClientId");
                }
                else if (read <= 0) {
                    Log.e("clientId file seems empty, deleting it.");
                    openFileInput.close();
                    this.mContext.deleteFile("gaClientId");
                    generateClientId = null;
                }
                else {
                    s = new String(array, 0, read);
                    final FileInputStream fileInputStream = openFileInput;
                    fileInputStream.close();
                    final String s2 = generateClientId = s;
                }
                if (generateClientId == null) {
                    generateClientId = this.generateClientId();
                }
                return generateClientId;
            }
            catch (IOException ex) {}
            catch (FileNotFoundException ex2) {
                generateClientId = null;
                continue;
            }
            try {
                final FileInputStream fileInputStream = openFileInput;
                fileInputStream.close();
                generateClientId = s;
                continue;
            }
            catch (IOException ex3) {}
            catch (FileNotFoundException ex4) {}
            break;
        }
    }
    
    @Override
    public boolean providesField(final String anObject) {
        return "&cid".equals(anObject);
    }
}

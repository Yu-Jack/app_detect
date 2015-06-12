// 
// Decompiled by Procyon v0.5.29
// 

package com.google.android.gms.analytics;

import java.io.FileInputStream;
import java.util.UUID;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import android.content.Context;

class al implements ar
{
    private static al a;
    private static final Object b;
    private final Context c;
    private String d;
    private boolean e;
    private final Object f;
    
    static {
        b = new Object();
    }
    
    protected al(final Context c) {
        this.e = false;
        this.f = new Object();
        this.c = c;
        this.e();
    }
    
    public static al a() {
        synchronized (al.b) {
            return al.a;
        }
    }
    
    public static void a(final Context context) {
        synchronized (al.b) {
            if (al.a == null) {
                al.a = new al(context);
            }
        }
    }
    
    private boolean b(final String s) {
        try {
            p.c("Storing clientId.");
            final FileOutputStream openFileOutput = this.c.openFileOutput("gaClientId", 0);
            openFileOutput.write(s.getBytes());
            openFileOutput.close();
            return true;
        }
        catch (FileNotFoundException ex) {
            p.a("Error creating clientId file.");
            return false;
        }
        catch (IOException ex2) {
            p.a("Error writing to clientId file.");
            return false;
        }
    }
    
    private String d() {
        Label_0042: {
            if (this.e) {
                break Label_0042;
            }
            synchronized (this.f) {
                Label_0040: {
                    if (this.e) {
                        break Label_0040;
                    }
                    p.c("Waiting for clientId to load");
                    try {
                        do {
                            this.f.wait();
                        } while (!this.e);
                        // monitorexit(this.f)
                        p.c("Loaded clientId");
                        return this.d;
                    }
                    catch (InterruptedException obj) {
                        p.a("Exception while waiting for clientId: " + obj);
                    }
                }
            }
        }
    }
    
    private void e() {
        new Thread("client_id_fetcher") {
            @Override
            public void run() {
                synchronized (al.this.f) {
                    al.this.d = al.this.c();
                    al.this.e = true;
                    al.this.f.notifyAll();
                }
            }
        }.start();
    }
    
    @Override
    public String a(final String anObject) {
        if ("&cid".equals(anObject)) {
            return this.d();
        }
        return null;
    }
    
    protected String b() {
        String lowerCase = UUID.randomUUID().toString().toLowerCase();
        try {
            if (!this.b(lowerCase)) {
                lowerCase = "0";
            }
            return lowerCase;
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    String c() {
        String b = null;
        while (true) {
            FileInputStream openFileInput = null;
            String s = null;
            try {
                openFileInput = this.c.openFileInput("gaClientId");
                final byte[] array = new byte[128];
                final int read = openFileInput.read(array, 0, 128);
                if (openFileInput.available() > 0) {
                    p.a("clientId file seems corrupted, deleting it.");
                    openFileInput.close();
                    this.c.deleteFile("gaClientId");
                }
                else if (read <= 0) {
                    p.a("clientId file seems empty, deleting it.");
                    openFileInput.close();
                    this.c.deleteFile("gaClientId");
                    b = null;
                }
                else {
                    s = new String(array, 0, read);
                    final FileInputStream fileInputStream = openFileInput;
                    fileInputStream.close();
                    final String s2 = b = s;
                }
                if (b == null) {
                    b = this.b();
                }
                return b;
            }
            catch (IOException ex) {}
            catch (FileNotFoundException ex2) {
                b = null;
                continue;
            }
            try {
                final FileInputStream fileInputStream = openFileInput;
                fileInputStream.close();
                b = s;
                continue;
            }
            catch (IOException ex3) {}
            catch (FileNotFoundException ex4) {}
            break;
        }
    }
}

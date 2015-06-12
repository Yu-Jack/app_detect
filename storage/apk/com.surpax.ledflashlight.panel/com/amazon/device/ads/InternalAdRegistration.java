// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import java.io.File;
import android.content.Context;

class InternalAdRegistration implements IInternalAdRegistration
{
    public static final String LOG_TAG;
    private static IInternalAdRegistration instance;
    private AppInfo appInfo;
    protected Context applicationContext;
    private boolean contextReceived;
    private DeviceInfo deviceInfo;
    private File filesDirectory;
    private boolean isAppDisabled;
    private boolean isRegistered;
    private long noRetryTtlExpiresMillis;
    private int noRetryTtlMillis;
    private RegistrationInfo registrationInfo;
    private SISRegistration sisRegistration;
    
    static {
        LOG_TAG = InternalAdRegistration.class.getSimpleName();
        InternalAdRegistration.instance = new InternalAdRegistration();
    }
    
    protected InternalAdRegistration() {
        this.isAppDisabled = false;
        DebugProperties.readDebugProperties();
        Version.getSDKVersion();
        this.registrationInfo = new RegistrationInfo();
    }
    
    public static IInternalAdRegistration getInstance() {
        return InternalAdRegistration.instance;
    }
    
    protected static void setInstance(final IInternalAdRegistration instance) {
        InternalAdRegistration.instance = instance;
    }
    
    @Override
    public void contextReceived(final Context context) {
        synchronized (this) {
            if (!this.contextReceived) {
                this.contextReceived = true;
                this.setApplicationContextFromContext(context);
                this.setFilesDirectory(context);
                Settings.getInstance().contextReceived(context);
                this.createAppInfo(context);
                this.createDeviceInfo(context);
                this.createSISRegistration();
            }
        }
    }
    
    protected void createAppInfo(final Context context) {
        this.appInfo = new AppInfo(context);
    }
    
    protected void createDeviceInfo(final Context context) {
        this.deviceInfo = new DeviceInfo(context);
    }
    
    protected void createSISRegistration() {
        this.sisRegistration = new SISRegistration();
    }
    
    @Override
    public AppInfo getAppInfo() {
        return this.appInfo;
    }
    
    @Override
    public Context getApplicationContext() {
        return this.applicationContext;
    }
    
    @Override
    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }
    
    @Override
    public File getFilesDir() {
        return this.filesDirectory;
    }
    
    @Override
    public boolean getIsAppDisabled() {
        return this.isAppDisabled;
    }
    
    @Override
    public int getNoRetryTtlRemainingMillis() {
        if (this.noRetryTtlMillis == 0 || this.noRetryTtlExpiresMillis == 0L) {
            return 0;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= this.noRetryTtlExpiresMillis) {
            this.noRetryTtlMillis = 0;
            this.noRetryTtlExpiresMillis = 0L;
            return 0;
        }
        return (int)(this.noRetryTtlExpiresMillis - currentTimeMillis);
    }
    
    @Override
    public RegistrationInfo getRegistrationInfo() {
        return this.registrationInfo;
    }
    
    protected SISRegistration getSISRegistration() {
        return this.sisRegistration;
    }
    
    public boolean isContextReceived() {
        return this.contextReceived;
    }
    
    @Override
    public boolean isRegistered() {
        return this.isRegistered;
    }
    
    @Override
    public void register() {
        this.getSISRegistration().registerApp();
        this.isRegistered = true;
    }
    
    protected void setApplicationContextFromContext(final Context context) {
        this.applicationContext = context.getApplicationContext();
    }
    
    protected void setFilesDirectory(final Context context) {
        this.filesDirectory = context.getFilesDir();
    }
    
    @Override
    public void setIsAppDisabled(final boolean isAppDisabled) {
        this.isAppDisabled = isAppDisabled;
    }
    
    @Override
    public void setNoRetryTtl(int n) {
        final int maxNoRetryTtl = Configuration.getMaxNoRetryTtl();
        if (maxNoRetryTtl < n) {
            n = maxNoRetryTtl;
        }
        if (n == 0) {
            this.noRetryTtlMillis = 0;
            this.noRetryTtlExpiresMillis = 0L;
            return;
        }
        this.noRetryTtlMillis = n * 1000;
        this.noRetryTtlExpiresMillis = System.currentTimeMillis() + this.noRetryTtlMillis;
    }
}

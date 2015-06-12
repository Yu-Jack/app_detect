// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.deviceorientation;

import java.util.List;
import android.hardware.SensorEvent;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import android.os.Handler;
import android.os.Looper;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.hardware.SensorManager;
import android.hardware.Sensor;
import org.apache.cordova.CallbackContext;
import android.hardware.SensorEventListener;
import org.apache.cordova.CordovaPlugin;

public class CompassListener extends CordovaPlugin implements SensorEventListener
{
    public static int ERROR_FAILED_TO_START;
    public static int RUNNING;
    public static int STARTING;
    public static int STOPPED;
    public long TIMEOUT;
    int accuracy;
    private CallbackContext callbackContext;
    float heading;
    long lastAccessTime;
    Sensor mSensor;
    private SensorManager sensorManager;
    int status;
    long timeStamp;
    
    static {
        CompassListener.STOPPED = 0;
        CompassListener.STARTING = 1;
        CompassListener.RUNNING = 2;
        CompassListener.ERROR_FAILED_TO_START = 3;
    }
    
    public CompassListener() {
        this.TIMEOUT = 30000L;
        this.heading = 0.0f;
        this.timeStamp = 0L;
        this.setStatus(CompassListener.STOPPED);
    }
    
    private JSONObject getCompassHeading() throws JSONException {
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("magneticHeading", (double)this.getHeading());
        jsonObject.put("trueHeading", (double)this.getHeading());
        jsonObject.put("headingAccuracy", 0);
        jsonObject.put("timestamp", this.timeStamp);
        return jsonObject;
    }
    
    private void setStatus(final int status) {
        this.status = status;
    }
    
    private void timeout() {
        if (this.status == CompassListener.STARTING) {
            this.setStatus(CompassListener.ERROR_FAILED_TO_START);
            if (this.callbackContext != null) {
                this.callbackContext.error("Compass listener failed to start.");
            }
        }
    }
    
    @Override
    public boolean execute(final String s, final JSONArray jsonArray, final CallbackContext callbackContext) throws JSONException {
        if (s.equals("start")) {
            this.start();
            return true;
        }
        if (s.equals("stop")) {
            this.stop();
            return true;
        }
        if (s.equals("getStatus")) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, this.getStatus()));
            return true;
        }
        if (s.equals("getHeading")) {
            if (this.status != CompassListener.RUNNING) {
                if (this.start() == CompassListener.ERROR_FAILED_TO_START) {
                    callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, CompassListener.ERROR_FAILED_TO_START));
                    return true;
                }
                new Handler(Looper.getMainLooper()).postDelayed((Runnable)new Runnable() {
                    @Override
                    public void run() {
                        CompassListener.this.timeout();
                    }
                }, 2000L);
            }
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, this.getCompassHeading()));
            return true;
        }
        if (s.equals("setTimeout")) {
            this.setTimeout(jsonArray.getLong(0));
            return true;
        }
        if (s.equals("getTimeout")) {
            callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, this.getTimeout()));
            return true;
        }
        return false;
    }
    
    public float getHeading() {
        this.lastAccessTime = System.currentTimeMillis();
        return this.heading;
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public long getTimeout() {
        return this.TIMEOUT;
    }
    
    @Override
    public void initialize(final CordovaInterface cordovaInterface, final CordovaWebView cordovaWebView) {
        super.initialize(cordovaInterface, cordovaWebView);
        this.sensorManager = (SensorManager)cordovaInterface.getActivity().getSystemService("sensor");
    }
    
    public void onAccuracyChanged(final Sensor sensor, final int n) {
    }
    
    @Override
    public void onDestroy() {
        this.stop();
    }
    
    @Override
    public void onReset() {
        this.stop();
    }
    
    public void onSensorChanged(final SensorEvent sensorEvent) {
        final float heading = sensorEvent.values[0];
        this.timeStamp = System.currentTimeMillis();
        this.heading = heading;
        this.setStatus(CompassListener.RUNNING);
        if (this.timeStamp - this.lastAccessTime > this.TIMEOUT) {
            this.stop();
        }
    }
    
    public void setTimeout(final long timeout) {
        this.TIMEOUT = timeout;
    }
    
    public int start() {
        if (this.status == CompassListener.RUNNING || this.status == CompassListener.STARTING) {
            return this.status;
        }
        final List sensorList = this.sensorManager.getSensorList(3);
        if (sensorList != null && sensorList.size() > 0) {
            this.mSensor = sensorList.get(0);
            this.sensorManager.registerListener((SensorEventListener)this, this.mSensor, 3);
            this.lastAccessTime = System.currentTimeMillis();
            this.setStatus(CompassListener.STARTING);
        }
        else {
            this.setStatus(CompassListener.ERROR_FAILED_TO_START);
        }
        return this.status;
    }
    
    public void stop() {
        if (this.status != CompassListener.STOPPED) {
            this.sensorManager.unregisterListener((SensorEventListener)this);
        }
        this.setStatus(CompassListener.STOPPED);
    }
}

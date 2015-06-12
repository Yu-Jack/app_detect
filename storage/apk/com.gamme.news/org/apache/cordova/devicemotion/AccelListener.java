// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova.devicemotion;

import android.hardware.SensorEvent;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import java.util.List;
import android.os.Looper;
import org.json.JSONException;
import org.apache.cordova.PluginResult;
import org.json.JSONObject;
import android.hardware.SensorManager;
import android.os.Handler;
import android.hardware.Sensor;
import org.apache.cordova.CallbackContext;
import android.hardware.SensorEventListener;
import org.apache.cordova.CordovaPlugin;

public class AccelListener extends CordovaPlugin implements SensorEventListener
{
    public static int ERROR_FAILED_TO_START;
    public static int RUNNING;
    public static int STARTING;
    public static int STOPPED;
    private int accuracy;
    private CallbackContext callbackContext;
    private Sensor mSensor;
    private Handler mainHandler;
    private Runnable mainRunnable;
    private SensorManager sensorManager;
    private int status;
    private long timestamp;
    private float x;
    private float y;
    private float z;
    
    static {
        AccelListener.STOPPED = 0;
        AccelListener.STARTING = 1;
        AccelListener.RUNNING = 2;
        AccelListener.ERROR_FAILED_TO_START = 3;
    }
    
    public AccelListener() {
        this.accuracy = 0;
        this.mainHandler = null;
        this.mainRunnable = new Runnable() {
            @Override
            public void run() {
                AccelListener.this.timeout();
            }
        };
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.timestamp = 0L;
        this.setStatus(AccelListener.STOPPED);
    }
    
    private void fail(final int n, final String s) {
        final JSONObject jsonObject = new JSONObject();
        while (true) {
            try {
                jsonObject.put("code", n);
                jsonObject.put("message", (Object)s);
                final PluginResult pluginResult = new PluginResult(PluginResult.Status.ERROR, jsonObject);
                pluginResult.setKeepCallback(true);
                this.callbackContext.sendPluginResult(pluginResult);
            }
            catch (JSONException ex) {
                ex.printStackTrace();
                continue;
            }
            break;
        }
    }
    
    private JSONObject getAccelerationJSON() {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("x", (double)this.x);
            jsonObject.put("y", (double)this.y);
            jsonObject.put("z", (double)this.z);
            jsonObject.put("timestamp", this.timestamp);
            return jsonObject;
        }
        catch (JSONException ex) {
            ex.printStackTrace();
            return jsonObject;
        }
    }
    
    private void setStatus(final int status) {
        this.status = status;
    }
    
    private int start() {
        if (this.status == AccelListener.RUNNING || this.status == AccelListener.STARTING) {
            return this.status;
        }
        this.setStatus(AccelListener.STARTING);
        final List sensorList = this.sensorManager.getSensorList(1);
        if (sensorList != null && sensorList.size() > 0) {
            this.mSensor = sensorList.get(0);
            this.sensorManager.registerListener((SensorEventListener)this, this.mSensor, 2);
            this.setStatus(AccelListener.STARTING);
            this.stopTimeout();
            (this.mainHandler = new Handler(Looper.getMainLooper())).postDelayed(this.mainRunnable, 2000L);
            return this.status;
        }
        this.setStatus(AccelListener.ERROR_FAILED_TO_START);
        this.fail(AccelListener.ERROR_FAILED_TO_START, "No sensors found to register accelerometer listening to.");
        return this.status;
    }
    
    private void stop() {
        this.stopTimeout();
        if (this.status != AccelListener.STOPPED) {
            this.sensorManager.unregisterListener((SensorEventListener)this);
        }
        this.setStatus(AccelListener.STOPPED);
        this.accuracy = 0;
    }
    
    private void stopTimeout() {
        if (this.mainHandler != null) {
            this.mainHandler.removeCallbacks(this.mainRunnable);
        }
    }
    
    private void timeout() {
        if (this.status == AccelListener.STARTING) {
            this.setStatus(AccelListener.ERROR_FAILED_TO_START);
            this.fail(AccelListener.ERROR_FAILED_TO_START, "Accelerometer could not be started.");
        }
    }
    
    private void win() {
        final PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, this.getAccelerationJSON());
        pluginResult.setKeepCallback(true);
        this.callbackContext.sendPluginResult(pluginResult);
    }
    
    @Override
    public boolean execute(final String s, final JSONArray jsonArray, final CallbackContext callbackContext) {
        if (s.equals("start")) {
            this.callbackContext = callbackContext;
            if (this.status != AccelListener.RUNNING) {
                this.start();
            }
        }
        else {
            if (!s.equals("stop")) {
                return false;
            }
            if (this.status == AccelListener.RUNNING) {
                this.stop();
            }
        }
        final PluginResult pluginResult = new PluginResult(PluginResult.Status.NO_RESULT, "");
        pluginResult.setKeepCallback(true);
        callbackContext.sendPluginResult(pluginResult);
        return true;
    }
    
    @Override
    public void initialize(final CordovaInterface cordovaInterface, final CordovaWebView cordovaWebView) {
        super.initialize(cordovaInterface, cordovaWebView);
        this.sensorManager = (SensorManager)cordovaInterface.getActivity().getSystemService("sensor");
    }
    
    public void onAccuracyChanged(final Sensor sensor, final int accuracy) {
        if (sensor.getType() == 1 && this.status != AccelListener.STOPPED) {
            this.accuracy = accuracy;
        }
    }
    
    @Override
    public void onDestroy() {
        this.stop();
    }
    
    @Override
    public void onReset() {
        if (this.status == AccelListener.RUNNING) {
            this.stop();
        }
    }
    
    public void onSensorChanged(final SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1 && this.status != AccelListener.STOPPED) {
            this.setStatus(AccelListener.RUNNING);
            if (this.accuracy >= 2) {
                this.timestamp = System.currentTimeMillis();
                this.x = sensorEvent.values[0];
                this.y = sensorEvent.values[1];
                this.z = sensorEvent.values[2];
                this.win();
            }
        }
    }
}

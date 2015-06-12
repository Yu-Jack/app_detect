// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.model;

public interface GraphLocation extends GraphObject
{
    String getCity();
    
    String getCountry();
    
    double getLatitude();
    
    double getLongitude();
    
    String getState();
    
    String getStreet();
    
    String getZip();
    
    void setCity(String p0);
    
    void setCountry(String p0);
    
    void setLatitude(double p0);
    
    void setLongitude(double p0);
    
    void setState(String p0);
    
    void setStreet(String p0);
    
    void setZip(String p0);
}

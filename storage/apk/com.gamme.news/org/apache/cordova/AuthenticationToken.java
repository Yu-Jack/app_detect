// 
// Decompiled by Procyon v0.5.29
// 

package org.apache.cordova;

public class AuthenticationToken
{
    private String password;
    private String userName;
    
    public String getPassword() {
        return this.password;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public void setUserName(final String userName) {
        this.userName = userName;
    }
}

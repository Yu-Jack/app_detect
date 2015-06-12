// 
// Decompiled by Procyon v0.5.29
// 

package com.securitycompass.labs.falsesecuremobile;

public class Account
{
    private int accountNumber;
    private String accountType;
    private double balance;
    
    public Account(final int accountNumber, final String accountType, final double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }
    
    public int getAccountNumber() {
        return this.accountNumber;
    }
    
    public String getAccountType() {
        return this.accountType;
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public void setAccountNumber(final int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }
    
    public void setBalance(final double balance) {
        this.balance = balance;
    }
    
    @Override
    public String toString() {
        return this.accountNumber + " (" + this.accountType + "): " + this.balance;
    }
}

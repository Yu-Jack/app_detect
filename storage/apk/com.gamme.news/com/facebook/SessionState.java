// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

public enum SessionState
{
    CLOSED("CLOSED", 6, Category.CLOSED_CATEGORY), 
    CLOSED_LOGIN_FAILED("CLOSED_LOGIN_FAILED", 5, Category.CLOSED_CATEGORY), 
    CREATED("CREATED", 0, Category.CREATED_CATEGORY), 
    CREATED_TOKEN_LOADED("CREATED_TOKEN_LOADED", 1, Category.CREATED_CATEGORY), 
    OPENED("OPENED", 3, Category.OPENED_CATEGORY), 
    OPENED_TOKEN_UPDATED("OPENED_TOKEN_UPDATED", 4, Category.OPENED_CATEGORY), 
    OPENING("OPENING", 2, Category.CREATED_CATEGORY);
    
    private final Category category;
    
    private SessionState(final String name, final int ordinal, final Category category) {
        this.category = category;
    }
    
    public boolean isClosed() {
        return this.category == Category.CLOSED_CATEGORY;
    }
    
    public boolean isOpened() {
        return this.category == Category.OPENED_CATEGORY;
    }
    
    private enum Category
    {
        CLOSED_CATEGORY("CLOSED_CATEGORY", 2), 
        CREATED_CATEGORY("CREATED_CATEGORY", 0), 
        OPENED_CATEGORY("OPENED_CATEGORY", 1);
        
        private Category(final String name, final int ordinal) {
        }
    }
}

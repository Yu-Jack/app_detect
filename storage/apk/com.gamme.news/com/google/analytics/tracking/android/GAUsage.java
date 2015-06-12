// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.tracking.android;

import java.io.ObjectInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.TreeSet;
import java.util.SortedSet;

class GAUsage
{
    private static final String BASE_64_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";
    private static final GAUsage INSTANCE;
    private boolean mDisableUsage;
    private StringBuilder mSequence;
    private SortedSet<Field> mUsedFields;
    
    static {
        INSTANCE = new GAUsage();
    }
    
    private GAUsage() {
        this.mUsedFields = new TreeSet<Field>();
        this.mSequence = new StringBuilder();
        this.mDisableUsage = false;
    }
    
    public static GAUsage getInstance() {
        return GAUsage.INSTANCE;
    }
    
    @VisibleForTesting
    static GAUsage getPrivateInstance() {
        return new GAUsage();
    }
    
    public String getAndClearSequence() {
        synchronized (this) {
            if (this.mSequence.length() > 0) {
                this.mSequence.insert(0, ".");
            }
            final String string = this.mSequence.toString();
            this.mSequence = new StringBuilder();
            return string;
        }
    }
    
    public String getAndClearUsage() {
        synchronized (this) {
            final StringBuilder sb = new StringBuilder();
            int n = 0;
            int n2 = 6;
            while (this.mUsedFields.size() > 0) {
                final Field field = this.mUsedFields.first();
                this.mUsedFields.remove(field);
                while (field.ordinal() >= n2) {
                    sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(n));
                    n2 += 6;
                    n = 0;
                }
                n += 1 << field.ordinal() % 6;
            }
            if (n > 0 || sb.length() == 0) {
                sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(n));
            }
            this.mUsedFields.clear();
            return sb.toString();
        }
    }
    
    public void setDisableUsage(final boolean mDisableUsage) {
        synchronized (this) {
            this.mDisableUsage = mDisableUsage;
        }
    }
    
    public void setUsage(final Field field) {
        synchronized (this) {
            if (!this.mDisableUsage) {
                this.mUsedFields.add(field);
                this.mSequence.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(field.ordinal()));
            }
        }
    }
    
    public enum Field
    {
        BLANK_04, 
        BLANK_05, 
        BLANK_06, 
        BLANK_07, 
        BLANK_08, 
        BLANK_12, 
        BLANK_13, 
        BLANK_14, 
        BLANK_15, 
        BLANK_16, 
        BLANK_17, 
        BLANK_18, 
        BLANK_19, 
        BLANK_20, 
        BLANK_21, 
        BLANK_22, 
        BLANK_23, 
        BLANK_24, 
        BLANK_25, 
        BLANK_26, 
        BLANK_27, 
        BLANK_28, 
        BLANK_29, 
        BLANK_37, 
        BLANK_38, 
        BLANK_46, 
        BLANK_52, 
        BLANK_53, 
        CLOSE_TRACKER, 
        CONSTRUCT_APP_VIEW, 
        CONSTRUCT_EVENT, 
        CONSTRUCT_EXCEPTION, 
        CONSTRUCT_ITEM, 
        CONSTRUCT_RAW_EXCEPTION, 
        CONSTRUCT_SOCIAL, 
        CONSTRUCT_TIMING, 
        CONSTRUCT_TRANSACTION, 
        DISPATCH, 
        EASY_TRACKER_ACTIVITY_START, 
        EASY_TRACKER_ACTIVITY_STOP, 
        GET, 
        GET_APP_OPT_OUT, 
        GET_DEFAULT_TRACKER, 
        GET_DRY_RUN, 
        GET_EXCEPTION_PARSER, 
        GET_TRACKER, 
        GET_TRACKER_NAME, 
        MAP_BUILDER_GET, 
        MAP_BUILDER_SET, 
        MAP_BUILDER_SET_ALL, 
        MAP_BUILDER_SET_CAMPAIGN_PARAMS, 
        REPORT_UNCAUGHT_EXCEPTIONS, 
        SEND, 
        SET, 
        SET_APP_OPT_OUT, 
        SET_AUTO_ACTIVITY_TRACKING, 
        SET_DEFAULT_TRACKER, 
        SET_DISPATCH_PERIOD, 
        SET_DRY_RUN, 
        SET_EXCEPTION_PARSER, 
        SET_FORCE_LOCAL_DISPATCH, 
        SET_LOGGER, 
        SET_SESSION_TIMEOUT;
    }
}

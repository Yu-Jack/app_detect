// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.sync;

import android.provider.BaseColumns;

public interface AccountColumns extends BaseColumns
{
    public static final String AUTH_TOKEN = "auth_token";
    public static final String BASE_REVISION = "base_revision";
    public static final String CLIENT_UUID = "client_uuid";
    public static final String COLORNOTE_ID = "colornote_id";
    public static final acb[] COLUMNS = { new act("_id"), new acv("client_uuid"), new act("repository_built"), new acr("base_revision"), new acv("auth_token"), new acv("email"), new acv("colornote_id"), new acv("fb_access"), new acv("fb_user_name") };
    public static final String EMAIL = "email";
    public static final String FACEBOOK_ACCESS_TOKEN = "fb_access";
    public static final String FACEBOOK_USER_NAME = "fb_user_name";
    public static final String REPOSITORY_BUILT = "repository_built";
}

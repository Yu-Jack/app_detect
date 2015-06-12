// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook.widget;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.SessionState;
import java.util.Date;
import android.content.Context;
import com.facebook.Session;
import com.facebook.internal.SessionAuthorizationType;
import com.facebook.SessionLoginBehavior;
import java.util.List;
import com.facebook.internal.SessionTracker;
import android.support.v4.app.Fragment;

class FacebookFragment extends Fragment
{
    private SessionTracker sessionTracker;
    
    private void openSession(final String applicationId, final List<String> permissions, final SessionLoginBehavior loginBehavior, final int requestCode, final SessionAuthorizationType other) {
        if (this.sessionTracker != null) {
            Session session = this.sessionTracker.getSession();
            if (session == null || session.getState().isClosed()) {
                final Session build = new Session.Builder((Context)this.getActivity()).setApplicationId(applicationId).build();
                Session.setActiveSession(build);
                session = build;
            }
            if (!session.isOpened()) {
                final Session.OpenRequest setRequestCode = new Session.OpenRequest(this).setPermissions(permissions).setLoginBehavior(loginBehavior).setRequestCode(requestCode);
                if (!SessionAuthorizationType.PUBLISH.equals(other)) {
                    session.openForRead(setRequestCode);
                    return;
                }
                session.openForPublish(setRequestCode);
            }
        }
    }
    
    protected final void closeSession() {
        if (this.sessionTracker != null) {
            final Session openSession = this.sessionTracker.getOpenSession();
            if (openSession != null) {
                openSession.close();
            }
        }
    }
    
    protected final void closeSessionAndClearTokenInformation() {
        if (this.sessionTracker != null) {
            final Session openSession = this.sessionTracker.getOpenSession();
            if (openSession != null) {
                openSession.closeAndClearTokenInformation();
            }
        }
    }
    
    protected final String getAccessToken() {
        final SessionTracker sessionTracker = this.sessionTracker;
        String accessToken = null;
        if (sessionTracker != null) {
            final Session openSession = this.sessionTracker.getOpenSession();
            accessToken = null;
            if (openSession != null) {
                accessToken = openSession.getAccessToken();
            }
        }
        return accessToken;
    }
    
    protected final Date getExpirationDate() {
        final SessionTracker sessionTracker = this.sessionTracker;
        Date expirationDate = null;
        if (sessionTracker != null) {
            final Session openSession = this.sessionTracker.getOpenSession();
            expirationDate = null;
            if (openSession != null) {
                expirationDate = openSession.getExpirationDate();
            }
        }
        return expirationDate;
    }
    
    protected final Session getSession() {
        if (this.sessionTracker != null) {
            return this.sessionTracker.getSession();
        }
        return null;
    }
    
    protected final List<String> getSessionPermissions() {
        final SessionTracker sessionTracker = this.sessionTracker;
        List<String> permissions = null;
        if (sessionTracker != null) {
            final Session session = this.sessionTracker.getSession();
            permissions = null;
            if (session != null) {
                permissions = session.getPermissions();
            }
        }
        return permissions;
    }
    
    protected final SessionState getSessionState() {
        final SessionTracker sessionTracker = this.sessionTracker;
        SessionState state = null;
        if (sessionTracker != null) {
            final Session session = this.sessionTracker.getSession();
            state = null;
            if (session != null) {
                state = session.getState();
            }
        }
        return state;
    }
    
    protected final boolean isSessionOpen() {
        final SessionTracker sessionTracker = this.sessionTracker;
        boolean b = false;
        if (sessionTracker != null) {
            final Session openSession = this.sessionTracker.getOpenSession();
            b = false;
            if (openSession != null) {
                b = true;
            }
        }
        return b;
    }
    
    @Override
    public void onActivityCreated(final Bundle bundle) {
        super.onActivityCreated(bundle);
        this.sessionTracker = new SessionTracker((Context)this.getActivity(), new DefaultSessionStatusCallback((DefaultSessionStatusCallback)null));
    }
    
    @Override
    public void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        this.sessionTracker.getSession().onActivityResult(this.getActivity(), n, n2, intent);
    }
    
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.sessionTracker.stopTracking();
    }
    
    protected void onSessionStateChange(final SessionState sessionState, final Exception ex) {
    }
    
    protected final void openSession() {
        this.openSessionForRead(null, null);
    }
    
    protected final void openSessionForPublish(final String s, final List<String> list) {
        this.openSessionForPublish(s, list, SessionLoginBehavior.SSO_WITH_FALLBACK, 64206);
    }
    
    protected final void openSessionForPublish(final String s, final List<String> list, final SessionLoginBehavior sessionLoginBehavior, final int n) {
        this.openSession(s, list, sessionLoginBehavior, n, SessionAuthorizationType.PUBLISH);
    }
    
    protected final void openSessionForRead(final String s, final List<String> list) {
        this.openSessionForRead(s, list, SessionLoginBehavior.SSO_WITH_FALLBACK, 64206);
    }
    
    protected final void openSessionForRead(final String s, final List<String> list, final SessionLoginBehavior sessionLoginBehavior, final int n) {
        this.openSession(s, list, sessionLoginBehavior, n, SessionAuthorizationType.READ);
    }
    
    public void setSession(final Session session) {
        if (this.sessionTracker != null) {
            this.sessionTracker.setSession(session);
        }
    }
    
    private class DefaultSessionStatusCallback implements StatusCallback
    {
        @Override
        public void call(final Session session, final SessionState sessionState, final Exception ex) {
            FacebookFragment.this.onSessionStateChange(sessionState, ex);
        }
    }
}

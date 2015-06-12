// 
// Decompiled by Procyon v0.5.29
// 

package com.socialnmobile.colornote.sync;

import com.socialnmobile.util.service.ServiceJob$JobListener;
import com.socialnmobile.colornote.sync.errors.UnsupportedClientVersion;
import com.socialnmobile.colornote.sync.errors.UnsupportedClientVersion$Listener;
import com.socialnmobile.colornote.sync.errors.RepositoryRebuildRequired;
import com.socialnmobile.colornote.sync.errors.RepositoryRebuildRequired$Listener;
import com.socialnmobile.colornote.sync.errors.AuthRequired;
import com.socialnmobile.colornote.sync.errors.AuthRequired$Listener;
import com.socialnmobile.colornote.sync.errors.UserNotFound;
import com.socialnmobile.colornote.sync.errors.UserNotFound$Listener;
import com.socialnmobile.colornote.sync.errors.PasswordNotMatch;
import com.socialnmobile.colornote.sync.errors.PasswordNotMatch$Listener;
import com.socialnmobile.colornote.sync.errors.ExternalAuthFailed;
import com.socialnmobile.colornote.sync.errors.ExternalAuthFailed$Listener;
import com.socialnmobile.colornote.sync.errors.BadFields;
import com.socialnmobile.colornote.sync.errors.BadFields$Listener;
import com.socialnmobile.colornote.sync.errors.AlreadyInUse;
import com.socialnmobile.colornote.sync.errors.AlreadyInUse$Listener;
import com.socialnmobile.colornote.sync.errors.AccountNotMatch;
import com.socialnmobile.colornote.sync.errors.AccountNotMatch$Listener;
import com.socialnmobile.util.service.ServiceJob;

public abstract class SyncServiceJob extends ServiceJob
{
    protected xm jsonrpc;
    
    public SyncServiceJob(final xm jsonrpc) {
        this.jsonrpc = jsonrpc;
    }
    
    static Object cast(final Object obj, final Class clazz) {
        try {
            return clazz.cast(obj);
        }
        catch (ClassCastException ex) {
            throw new wd();
        }
    }
    
    static boolean dispatchError(final Object o, final xn xn) {
        try {
            switch (xn.a()) {
                case 440: {
                    ((AccountNotMatch$Listener)cast(o, AccountNotMatch$Listener.class)).onError(new AccountNotMatch(xn));
                    break;
                }
                case 441: {
                    ((AlreadyInUse$Listener)cast(o, AlreadyInUse$Listener.class)).onError(new AlreadyInUse(xn));
                    break;
                }
                case 442: {
                    ((BadFields$Listener)cast(o, BadFields$Listener.class)).onError(new BadFields(xn));
                    break;
                }
                case 443: {
                    ((ExternalAuthFailed$Listener)cast(o, ExternalAuthFailed$Listener.class)).onError(new ExternalAuthFailed(xn));
                    break;
                }
                case 444: {
                    ((PasswordNotMatch$Listener)cast(o, PasswordNotMatch$Listener.class)).onError(new PasswordNotMatch(xn));
                    break;
                }
                case 445: {
                    ((UserNotFound$Listener)cast(o, UserNotFound$Listener.class)).onError(new UserNotFound(xn));
                    break;
                }
                case 446: {
                    ((AuthRequired$Listener)cast(o, AuthRequired$Listener.class)).onError(new AuthRequired(xn));
                    break;
                }
                case 447: {
                    ((RepositoryRebuildRequired$Listener)cast(o, RepositoryRebuildRequired$Listener.class)).onError(new RepositoryRebuildRequired(xn));
                    break;
                }
                case 448: {
                    ((UnsupportedClientVersion$Listener)cast(o, UnsupportedClientVersion$Listener.class)).onError(new UnsupportedClientVersion(xn));
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
        catch (wd wd) {
            return false;
        }
    }
    
    @Override
    public boolean onJobException(final Exception ex) {
        if (ex instanceof xn) {
            final xn xn = (xn)ex;
            final ServiceJob$JobListener jobListener = this.getJobListener();
            if (jobListener != null) {
                return dispatchError(jobListener, xn);
            }
        }
        return false;
    }
}

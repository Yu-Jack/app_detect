// 
// Decompiled by Procyon v0.5.29
// 

package com.facebook;

import java.util.Date;
import com.facebook.model.GraphObjectList;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import android.text.TextUtils;
import java.util.Iterator;
import com.facebook.model.GraphObject;
import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import com.facebook.internal.Utility;
import android.os.Bundle;
import com.facebook.internal.Validate;
import android.content.Context;
import android.app.Activity;
import java.util.List;
import java.util.Map;

public class TestSession extends Session
{
    private static final String LOG_TAG = "FacebookSDK.TestSession";
    private static Map<String, TestAccount> appTestAccounts;
    private static final long serialVersionUID = 1L;
    private static String testApplicationId;
    private static String testApplicationSecret;
    private final Mode mode;
    private final List<String> requestedPermissions;
    private final String sessionUniqueUserTag;
    private String testAccountId;
    private String testAccountUserName;
    private boolean wasAskedToExtendAccessToken;
    
    TestSession(final Activity activity, final List<String> requestedPermissions, final TokenCachingStrategy tokenCachingStrategy, final String sessionUniqueUserTag, final Mode mode) {
        super((Context)activity, TestSession.testApplicationId, tokenCachingStrategy);
        Validate.notNull(requestedPermissions, "permissions");
        Validate.notNullOrEmpty(TestSession.testApplicationId, "testApplicationId");
        Validate.notNullOrEmpty(TestSession.testApplicationSecret, "testApplicationSecret");
        this.sessionUniqueUserTag = sessionUniqueUserTag;
        this.mode = mode;
        this.requestedPermissions = requestedPermissions;
    }
    
    public static TestSession createSessionWithPrivateUser(final Activity activity, final List<String> list) {
        return createTestSession(activity, list, Mode.PRIVATE, null);
    }
    
    public static TestSession createSessionWithSharedUser(final Activity activity, final List<String> list) {
        return createSessionWithSharedUser(activity, list, null);
    }
    
    public static TestSession createSessionWithSharedUser(final Activity activity, final List<String> list, final String s) {
        return createTestSession(activity, list, Mode.SHARED, s);
    }
    
    private TestAccount createTestAccountAndFinishAuth() {
        final Bundle bundle = new Bundle();
        bundle.putString("installed", "true");
        bundle.putString("permissions", this.getPermissionsString());
        bundle.putString("access_token", getAppAccessToken());
        if (this.mode == Mode.SHARED) {
            bundle.putString("name", String.format("Shared %s Testuser", this.getSharedTestAccountIdentifier()));
        }
        final Response executeAndWait = new Request(null, String.format("%s/accounts/test-users", TestSession.testApplicationId), bundle, HttpMethod.POST).executeAndWait();
        final FacebookRequestError error = executeAndWait.getError();
        final TestAccount testAccount = executeAndWait.getGraphObjectAs(TestAccount.class);
        if (error != null) {
            this.finishAuthOrReauth(null, error.getException());
            return null;
        }
        assert testAccount != null;
        if (this.mode == Mode.SHARED) {
            testAccount.setName(bundle.getString("name"));
            storeTestAccount(testAccount);
        }
        this.finishAuthWithTestAccount(testAccount);
        return testAccount;
    }
    
    private static TestSession createTestSession(final Activity activity, List<String> list, final Mode mode, final String s) {
        synchronized (TestSession.class) {
            if (Utility.isNullOrEmpty(TestSession.testApplicationId) || Utility.isNullOrEmpty(TestSession.testApplicationSecret)) {
                throw new FacebookException("Must provide app ID and secret");
            }
        }
        if (Utility.isNullOrEmpty((Collection<Object>)list)) {
            list = Arrays.asList("email", "publish_actions");
        }
        // monitorexit(TestSession.class)
        return new TestSession(activity, list, new TestTokenCachingStrategy(null), s, mode);
    }
    
    private void deleteTestAccount(final String s, final String s2) {
        final Bundle bundle = new Bundle();
        bundle.putString("access_token", s2);
        final Response executeAndWait = new Request(null, s, bundle, HttpMethod.DELETE).executeAndWait();
        final FacebookRequestError error = executeAndWait.getError();
        final GraphObject graphObject = executeAndWait.getGraphObject();
        if (error != null) {
            Log.w("FacebookSDK.TestSession", String.format("Could not delete test account %s: %s", s, error.getException().toString()));
        }
        else if (graphObject.getProperty("FACEBOOK_NON_JSON_RESULT") == Boolean.valueOf(false)) {
            Log.w("FacebookSDK.TestSession", String.format("Could not delete test account %s: unknown reason", s));
        }
    }
    
    private void findOrCreateSharedTestAccount() {
        final TestAccount testAccountMatchingIdentifier = findTestAccountMatchingIdentifier(this.getSharedTestAccountIdentifier());
        if (testAccountMatchingIdentifier != null) {
            this.finishAuthWithTestAccount(testAccountMatchingIdentifier);
            return;
        }
        this.createTestAccountAndFinishAuth();
    }
    
    private static TestAccount findTestAccountMatchingIdentifier(final String s) {
        synchronized (TestSession.class) {
            retrieveTestAccountsForAppIfNeeded();
            for (final TestAccount testAccount : TestSession.appTestAccounts.values()) {
                if (testAccount.getName().contains(s)) {
                    return testAccount;
                }
            }
            return null;
        }
    }
    
    private void finishAuthWithTestAccount(final TestAccount testAccount) {
        this.testAccountId = testAccount.getId();
        this.testAccountUserName = testAccount.getName();
        this.finishAuthOrReauth(AccessToken.createFromString(testAccount.getAccessToken(), this.requestedPermissions, AccessTokenSource.TEST_USER), null);
    }
    
    static final String getAppAccessToken() {
        return String.valueOf(TestSession.testApplicationId) + "|" + TestSession.testApplicationSecret;
    }
    
    private String getPermissionsString() {
        return TextUtils.join((CharSequence)",", (Iterable)this.requestedPermissions);
    }
    
    private String getSharedTestAccountIdentifier() {
        final long n = 0xFFFFFFFFL & this.getPermissionsString().hashCode();
        long n2;
        if (this.sessionUniqueUserTag != null) {
            n2 = (0xFFFFFFFFL & this.sessionUniqueUserTag.hashCode());
        }
        else {
            n2 = 0L;
        }
        return this.validNameStringFromInteger(n ^ n2);
    }
    
    public static String getTestApplicationId() {
        synchronized (TestSession.class) {
            return TestSession.testApplicationId;
        }
    }
    
    public static String getTestApplicationSecret() {
        synchronized (TestSession.class) {
            return TestSession.testApplicationSecret;
        }
    }
    
    private static void populateTestAccounts(final Collection<TestAccount> collection, final Collection<UserAccount> collection2) {
        while (true) {
            while (true) {
                final Iterator<UserAccount> iterator2;
                synchronized (TestSession.class) {
                    final Iterator<TestAccount> iterator = collection.iterator();
                    while (iterator.hasNext()) {
                        storeTestAccount(iterator.next());
                    }
                    iterator2 = collection2.iterator();
                    if (!iterator2.hasNext()) {
                        return;
                    }
                }
                final UserAccount userAccount = iterator2.next();
                final TestAccount testAccount = TestSession.appTestAccounts.get(userAccount.getUid());
                if (testAccount != null) {
                    testAccount.setName(userAccount.getName());
                    continue;
                }
                continue;
            }
        }
    }
    
    private static void retrieveTestAccountsForAppIfNeeded() {
        while (true) {
            Response response2 = null;
            Label_0161: {
                final String format;
                final Bundle bundle;
                synchronized (TestSession.class) {
                    if (TestSession.appTestAccounts != null) {
                        return;
                    }
                    TestSession.appTestAccounts = new HashMap<String, TestAccount>();
                    format = String.format("SELECT id,access_token FROM test_account WHERE app_id = %s", TestSession.testApplicationId);
                    bundle = new Bundle();
                    final JSONObject jsonObject = new JSONObject();
                    final JSONObject jsonObject3;
                    final JSONObject jsonObject2 = jsonObject3 = jsonObject;
                    final String s = "test_accounts";
                    final String s2 = format;
                    jsonObject3.put(s, (Object)s2);
                    final JSONObject jsonObject4 = jsonObject2;
                    final String s3 = "users";
                    final String s4 = "SELECT uid,name FROM user WHERE uid IN (SELECT id FROM #test_accounts)";
                    jsonObject4.put(s3, (Object)s4);
                    final Bundle bundle2 = bundle;
                    final String s5 = "q";
                    final JSONObject jsonObject5 = jsonObject2;
                    final String s6 = jsonObject5.toString();
                    bundle2.putString(s5, s6);
                    final Bundle bundle3 = bundle;
                    final String s7 = "access_token";
                    final String s8 = getAppAccessToken();
                    bundle3.putString(s7, s8);
                    final Session session = null;
                    final String s9 = "fql";
                    final Bundle bundle4 = bundle;
                    final HttpMethod httpMethod = null;
                    final Request request = new Request(session, s9, bundle4, httpMethod);
                    final Response response = request.executeAndWait();
                    final Response response3;
                    response2 = (response3 = response);
                    final FacebookRequestError facebookRequestError = response3.getError();
                    if (facebookRequestError != null) {
                        final Response response4 = response2;
                        final FacebookRequestError facebookRequestError2 = response4.getError();
                        throw facebookRequestError2.getException();
                    }
                    break Label_0161;
                }
                try {
                    final JSONObject jsonObject = new JSONObject();
                    final JSONObject jsonObject3;
                    final JSONObject jsonObject2 = jsonObject3 = jsonObject;
                    final String s = "test_accounts";
                    final String s2 = format;
                    jsonObject3.put(s, (Object)s2);
                    final JSONObject jsonObject4 = jsonObject2;
                    final String s3 = "users";
                    final String s4 = "SELECT uid,name FROM user WHERE uid IN (SELECT id FROM #test_accounts)";
                    jsonObject4.put(s3, (Object)s4);
                    final Bundle bundle2 = bundle;
                    final String s5 = "q";
                    final JSONObject jsonObject5 = jsonObject2;
                    final String s6 = jsonObject5.toString();
                    bundle2.putString(s5, s6);
                    final Bundle bundle3 = bundle;
                    final String s7 = "access_token";
                    final String s8 = getAppAccessToken();
                    bundle3.putString(s7, s8);
                    final Session session = null;
                    final String s9 = "fql";
                    final Bundle bundle4 = bundle;
                    final HttpMethod httpMethod = null;
                    final Request request = new Request(session, s9, bundle4, httpMethod);
                    final Response response = request.executeAndWait();
                    final Response response3;
                    response2 = (response3 = response);
                    final FacebookRequestError facebookRequestError = response3.getError();
                    if (facebookRequestError != null) {
                        final Response response4 = response2;
                        final FacebookRequestError facebookRequestError2 = response4.getError();
                        throw facebookRequestError2.getException();
                    }
                }
                catch (JSONException ex2) {
                    throw new FacebookException((Throwable)ex2);
                }
            }
            final GraphObjectList<FqlResult> data = response2.getGraphObjectAs(FqlResponse.class).getData();
            if (data == null || data.size() != 2) {
                break;
            }
            populateTestAccounts(((FqlResult)data.get(0)).getFqlResultSet().castToListOf(TestAccount.class), ((FqlResult)data.get(1)).getFqlResultSet().castToListOf(UserAccount.class));
            return;
        }
        throw new FacebookException("Unexpected number of results from FQL query");
    }
    
    public static void setTestApplicationId(final String s) {
        synchronized (TestSession.class) {
            if (TestSession.testApplicationId != null && !TestSession.testApplicationId.equals(s)) {
                throw new FacebookException("Can't have more than one test application ID");
            }
        }
        TestSession.testApplicationId = s;
    }
    // monitorexit(TestSession.class)
    
    public static void setTestApplicationSecret(final String s) {
        synchronized (TestSession.class) {
            if (TestSession.testApplicationSecret != null && !TestSession.testApplicationSecret.equals(s)) {
                throw new FacebookException("Can't have more than one test application secret");
            }
        }
        TestSession.testApplicationSecret = s;
    }
    // monitorexit(TestSession.class)
    
    private static void storeTestAccount(final TestAccount testAccount) {
        synchronized (TestSession.class) {
            TestSession.appTestAccounts.put(testAccount.getId(), testAccount);
        }
    }
    
    private String validNameStringFromInteger(final long i) {
        final String string = Long.toString(i);
        final StringBuilder sb = new StringBuilder("Perm");
        char c = '\0';
        for (char c2 : string.toCharArray()) {
            if (c2 == c) {
                c2 += '\n';
            }
            sb.append((char)(-48 + (c2 + 'a')));
            c = c2;
        }
        return sb.toString();
    }
    
    @Override
    void authorize(final AuthorizationRequest authorizationRequest) {
        if (this.mode == Mode.PRIVATE) {
            this.createTestAccountAndFinishAuth();
            return;
        }
        this.findOrCreateSharedTestAccount();
    }
    
    @Override
    void extendAccessToken() {
        this.wasAskedToExtendAccessToken = true;
        super.extendAccessToken();
    }
    
    void fakeTokenRefreshAttempt() {
        this.setCurrentTokenRefreshRequest(new TokenRefreshRequest(this));
    }
    
    void forceExtendAccessToken(final boolean b) {
        final AccessToken tokenInfo = this.getTokenInfo();
        this.setTokenInfo(new AccessToken(tokenInfo.getToken(), new Date(), tokenInfo.getPermissions(), tokenInfo.getDeclinedPermissions(), AccessTokenSource.TEST_USER, new Date(0L)));
        this.setLastAttemptedTokenExtendDate(new Date(0L));
    }
    
    public final String getTestUserId() {
        return this.testAccountId;
    }
    
    public final String getTestUserName() {
        return this.testAccountUserName;
    }
    
    boolean getWasAskedToExtendAccessToken() {
        return this.wasAskedToExtendAccessToken;
    }
    
    @Override
    void postStateChange(final SessionState sessionState, final SessionState sessionState2, final Exception ex) {
        final String testAccountId = this.testAccountId;
        super.postStateChange(sessionState, sessionState2, ex);
        if (sessionState2.isClosed() && testAccountId != null && this.mode == Mode.PRIVATE) {
            this.deleteTestAccount(testAccountId, getAppAccessToken());
        }
    }
    
    @Override
    boolean shouldExtendAccessToken() {
        final boolean shouldExtendAccessToken = super.shouldExtendAccessToken();
        this.wasAskedToExtendAccessToken = false;
        return shouldExtendAccessToken;
    }
    
    @Override
    public final String toString() {
        return "{TestSession" + " testUserId:" + this.testAccountId + " " + super.toString() + "}";
    }
    
    private interface FqlResponse extends GraphObject
    {
        GraphObjectList<FqlResult> getData();
    }
    
    private interface FqlResult extends GraphObject
    {
        GraphObjectList<GraphObject> getFqlResultSet();
    }
    
    private enum Mode
    {
        PRIVATE("PRIVATE", 0), 
        SHARED("SHARED", 1);
        
        private Mode(final String name, final int ordinal) {
        }
    }
    
    private interface TestAccount extends GraphObject
    {
        String getAccessToken();
        
        String getId();
        
        String getName();
        
        void setName(String p0);
    }
    
    private static final class TestTokenCachingStrategy extends TokenCachingStrategy
    {
        private Bundle bundle;
        
        @Override
        public void clear() {
            this.bundle = null;
        }
        
        @Override
        public Bundle load() {
            return this.bundle;
        }
        
        @Override
        public void save(final Bundle bundle) {
            this.bundle = bundle;
        }
    }
    
    private interface UserAccount extends GraphObject
    {
        String getName();
        
        String getUid();
        
        void setName(String p0);
    }
}

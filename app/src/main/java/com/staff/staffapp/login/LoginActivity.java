package com.staff.staffapp.login;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.microsoft.aad.adal.ADALError;
import com.microsoft.aad.adal.AuthenticationCallback;
import com.microsoft.aad.adal.AuthenticationContext;
import com.microsoft.aad.adal.AuthenticationException;
import com.microsoft.aad.adal.AuthenticationResult;
import com.microsoft.aad.adal.IDispatcher;
import com.microsoft.aad.adal.Logger;
import com.microsoft.aad.adal.PromptBehavior;
import com.microsoft.aad.adal.Telemetry;
import com.staff.staffapp.Constants;
import com.staff.staffapp.R;
import com.staff.staffapp.ui.MainActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressWarnings("ALL")
public class LoginActivity extends AppCompatActivity {

    /* UI & Debugging Variables */
    private static final String TAG = LoginActivity.class.getSimpleName();
    Button callGraphButton;
    Button signOutButton;
    // ImageView profile_image;
    /* Azure AD Variables */
    public AuthenticationContext mAuthContext;
    public AuthenticationResult mAuthResult;

    /* Handler to do an interactive sign in and acquire token */
    private Handler mAcquireTokenHandler;
    /* Boolean variable to ensure invocation of interactive sign-in only once in case of multiple  acquireTokenSilent call failures */
    private static AtomicBoolean sIntSignInInvoked = new AtomicBoolean();
    /* Telemetry dispatcher registration */
    static {
        Telemetry.getInstance().registerDispatcher(new IDispatcher() {
            @Override
            public void dispatchEvent(Map<String, String> events) {
                // Events from ADAL will be sent to this callback
                for(Map.Entry<String, String> entry: events.entrySet()) {
                    Log.d(TAG, entry.getKey() + ": " + entry.getValue());
                }
            }
        }, Constants.sTelemetryAggregationIsRequired);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        callGraphButton = findViewById(R.id.callGraph);
        signOutButton = findViewById(R.id.clearCache);
        callGraphButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onCallGraphClicked();
            }
        });

        mAuthContext = new AuthenticationContext(getApplicationContext(), Constants.AUTHORITY, false);

        /* Instantiate handler which can invoke interactive sign-in to get the Resource
         * sIntSignInInvoked ensures interactive sign-in is invoked one at a time */

        mAcquireTokenHandler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(Message msg) {
                if( sIntSignInInvoked.compareAndSet(false, true)) {
                    if (msg.what == Constants.MSG_INTERACTIVE_SIGN_IN_PROMPT_AUTO){
                        mAuthContext.acquireToken(getActivity(), Constants.RESOURCE_ID, Constants.CLIENT_ID, Constants.REDIRECT_URI, PromptBehavior.Auto, getAuthInteractiveCallback());
                    }else if(msg.what ==Constants.MSG_INTERACTIVE_SIGN_IN_PROMPT_ALWAYS){
                        mAuthContext.acquireToken(getActivity(), Constants.RESOURCE_ID, Constants.CLIENT_ID, Constants.REDIRECT_URI, PromptBehavior.Always, getAuthInteractiveCallback());
                    }
                }
            }
        };
        /* ADAL Logging callback setup */
        Logger.getInstance().setExternalLogger(new Logger.ILogger() {
            @Override
            public void Log(String tag, String message, String additionalMessage, Logger.LogLevel level, ADALError errorCode) {
                // You can filter the logs  depending on level or errorcode.
                Log.d(TAG, message + " " + additionalMessage);
            }
        });
        /*Attempt an acquireTokenSilent call to see if we're signed in*/
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String userId = preferences.getString(Constants.USER_ID, "");
        if(!TextUtils.isEmpty(userId)){
            mAuthContext.acquireTokenSilentAsync(Constants.RESOURCE_ID, Constants.CLIENT_ID, userId, getAuthSilentCallback());
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mAuthContext.onActivityResult(requestCode, resultCode, data);
    }
    /*
     * End user clicked call Graph API button, time for Auth
     * Use ADAL to get an Access token for the Microsoft Graph API
     */
    private void onCallGraphClicked() {
        mAcquireTokenHandler.sendEmptyMessage(Constants.MSG_INTERACTIVE_SIGN_IN_PROMPT_AUTO);
    }
    private void callGraphAPI() {
//        Log.d(TAG, "Starting volley request to graph");
        Intent activityIntent;
//        /* Make sure we have a token to send to graph */
        if (mAuthResult.getAccessToken() == null)
        {
            return;
        }
        activityIntent = new Intent(this, MainActivity.class);
        activityIntent.putExtra("Given Name", mAuthResult.getUserInfo().getGivenName());
        activityIntent.putExtra("Family Name",mAuthResult.getUserInfo().getFamilyName());

        try {

            startActivity(activityIntent);

        } catch (Exception e)
        {
            Log.d(TAG, "Failed to put parameters: " + e.toString());
        }
    }
    public Activity getActivity() {
        return this;
    }

    /* Callback used in for silent acquireToken calls.
     * Looks if tokens are in the cache (refreshes if necessary and if we don't forceRefresh)
     * else errors that we need to do an interactive request.
     */
    private AuthenticationCallback<AuthenticationResult> getAuthSilentCallback() {
        return new AuthenticationCallback<AuthenticationResult>() {
            @Override
            public void onSuccess(AuthenticationResult authenticationResult) {
                if(authenticationResult==null || TextUtils.isEmpty(authenticationResult.getAccessToken())
                        || authenticationResult.getStatus()!= AuthenticationResult.AuthenticationStatus.Succeeded){
                    Log.d(TAG, "Silent acquire token Authentication Result is invalid, retrying with interactive");
                    /* retry with interactive */
                    mAcquireTokenHandler.sendEmptyMessage(Constants.MSG_INTERACTIVE_SIGN_IN_PROMPT_AUTO);
                    return;
                }
                /* Successfully got a token, call graph now */
                Log.d(TAG, "Successfully authenticated");
                /* Store the mAuthResult */
                mAuthResult = authenticationResult;
                /* call graph */
                callGraphAPI();
            }

            @Override
            public void onError(Exception exception) {
                /* Failed to acquireToken */
                Log.e(TAG, "Authentication failed: " + exception.toString());
                if (exception instanceof AuthenticationException) {
                    AuthenticationException authException = ((AuthenticationException) exception);
                    ADALError error = authException.getCode();
                    logHttpErrors(authException);
                    /*  Tokens expired or no session, retry with interactive */
                    if (error == ADALError.AUTH_REFRESH_FAILED_PROMPT_NOT_ALLOWED ) {
                        mAcquireTokenHandler.sendEmptyMessage(Constants.MSG_INTERACTIVE_SIGN_IN_PROMPT_AUTO);
                    }else if(error == ADALError.NO_NETWORK_CONNECTION_POWER_OPTIMIZATION){
                        /* Device is in Doze mode or App is in stand by mode.
                           Wake up the app or show an appropriate prompt for the user to take action
                           More information on this : https://github.com/AzureAD/azure-activedirectory-library-for-android/wiki/Handle-Doze-and-App-Standby */
                        Log.e(TAG, "Device is in doze mode or the app is in standby mode");
                    }
                    return;
                }
                /* Attempt an interactive on any other exception */
                mAcquireTokenHandler.sendEmptyMessage(Constants.MSG_INTERACTIVE_SIGN_IN_PROMPT_AUTO);
            }
        };
    }
    private void logHttpErrors(AuthenticationException authException){
        int httpResponseCode = authException.getServiceStatusCode();
        Log.d(TAG , "HTTP Response code: " + authException.getServiceStatusCode());
        if(httpResponseCode< 200 || httpResponseCode >300) {
            // logging http response headers in case of a http error.
            HashMap<String, List<String>> headers = authException.getHttpResponseHeaders();
            if (headers != null) {
                StringBuilder sb = new StringBuilder();
                for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
                    sb.append(entry.getKey());
                    sb.append(":");
                    sb.append(entry.getValue().toString());
                    sb.append("; ");
                }
                Log.e(TAG, "HTTP Response headers: " + sb.toString());
            }
        }
    }

    /* Callback used for interactive request.  If succeeds we use the access
     * token to call the Microsoft Graph. Does not check cache
     */
    private AuthenticationCallback<AuthenticationResult> getAuthInteractiveCallback() {
        return new AuthenticationCallback<AuthenticationResult>() {
            @Override
            public void onSuccess(AuthenticationResult authenticationResult) {
                if(authenticationResult==null || TextUtils.isEmpty(authenticationResult.getAccessToken())
                        || authenticationResult.getStatus()!= AuthenticationResult.AuthenticationStatus.Succeeded){
                    Log.e(TAG, "Authentication Result is invalid");
                    return;
                }
                /* Successfully got a token, call graph now */
                Log.d(TAG, "Successfully authenticated");
                Log.d(TAG, "ID Token: " + authenticationResult.getIdToken());

                /* Store the auth result */
                mAuthResult = authenticationResult;

                /* Store User id to SharedPreferences to use it to acquire token silently later */
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                preferences.edit().putString(Constants.USER_ID, authenticationResult.getUserInfo().getUserId()).apply();

                /* call graph */
                callGraphAPI();

                sIntSignInInvoked.set(false);
            }
            @Override
            public void onError(Exception exception) {
                /* Failed to acquireToken */
                Log.e(TAG, "Authentication failed: " + exception.toString());
                if (exception instanceof AuthenticationException) {
                    ADALError  error = ((AuthenticationException)exception).getCode();
                    if(error==ADALError.AUTH_FAILED_CANCELLED){
                        Log.e(TAG, "The user cancelled the authorization request");
                    }else if(error== ADALError.AUTH_FAILED_NO_TOKEN){
                        // In this case ADAL has found a token in cache but failed to retrieve it.
                        // Retry interactive with Prompt.Always to ensure we do an interactive sign in
                        mAcquireTokenHandler.sendEmptyMessage(Constants.MSG_INTERACTIVE_SIGN_IN_PROMPT_ALWAYS);
                    }else if(error == ADALError.NO_NETWORK_CONNECTION_POWER_OPTIMIZATION){
                        /* Device is in Doze mode or App is in stand by mode.
                           Wake up the app or show an appropriate prompt for the user to take action
                           More information on this : https://github.com/AzureAD/azure-activedirectory-library-for-android/wiki/Handle-Doze-and-App-Standby */
                        Log.e(TAG, "Device is in doze mode or the app is in standby mode");
                    }
                }
                /* set the sIntSignInInvoked boolean back to false  */
                sIntSignInInvoked.set(false);
            }
        };
    }
}

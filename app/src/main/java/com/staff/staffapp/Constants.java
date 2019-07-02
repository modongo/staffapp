package com.staff.staffapp;

public class Constants {
    public static final String BUSINESS_PRODUCTS_URL="https://fathomless-tor-95579.herokuapp.com/api/businesses";
    public static final String PERSONAL_PRODUCTS_URL="https://fathomless-tor-95579.herokuapp.com/api/personals";
    public static final String BUSINESS_SCHOOL_URL="https://e-class-portal.herokuapp.com/";
    /* Azure AD Constants */
    /* Authority is in the form of https://login.microsoftonline.com/yourtenant.onmicrosoft.com */
    public static final String AUTHORITY = "https://login.microsoftonline.com/19a4db07-607d-475f-a518-0e3b699ac7d0";
    /* The clientID of your application is a unique identifier which can be obtained from the app registration portal */
    public static final String CLIENT_ID = "d86666b7-b3a0-46e9-aa57-4a161025d768";
    /* Resource URI of the endpoint which will be accessed */
    public static final String RESOURCE_ID = "https://graph.microsoft.com/";
    /* The Redirect URI of the application (Optional) */
    public static final String REDIRECT_URI = "https://login.microsoftonline.com/common/oauth2/nativeclient";

    /* Microsoft Graph Constants */
    public static final String MSGRAPH_URL = "https://graph.microsoft.com/v1.0/me";

    /* Constant to send message to the mAcquireTokenHandler to do acquire token with Prompt.Auto*/
    public static final int MSG_INTERACTIVE_SIGN_IN_PROMPT_AUTO = 1;
    /* Constant to send message to the mAcquireTokenHandler to do acquire token with Prompt.Always */
    public static final int MSG_INTERACTIVE_SIGN_IN_PROMPT_ALWAYS = 2;

    /* Constant to store user id in shared preferences */
    public static final String USER_ID = "user_id";
    /* Telemetry variables */
    // Flag to turn event aggregation on/off
    public static final boolean sTelemetryAggregationIsRequired = true;
}

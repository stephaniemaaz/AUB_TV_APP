package com.example.myapplication;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.vimeo.networking.Configuration;
import com.vimeo.networking.VimeoClient;
import com.vimeo.networking.callbacks.AuthCallback;
import com.vimeo.networking.model.error.VimeoError;

public class TestApp extends Application {

    private static final String SCOPE = "private public create edit delete interact";

    private static final String TAG = "TestApp";

    private VimeoClient mApiClient;

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");

        sContext = this;

        Configuration.Builder configBuilder = getClientIdAndClientSecretBuilder();
        VimeoClient.initialize(configBuilder.build());
        mApiClient = VimeoClient.getInstance();
//        authenticateWithClientCredentials();
    }

    public Configuration.Builder getClientIdAndClientSecretBuilder() {
        String clientId = "dc62dc72e8c7cf4d0b7bb025d41e2a7649ddc0a4";
        String clientSecret = "SRbzt7mLfbA0l5aEV8lXINE54nRGkSp8S2i+wOp9paOqQsEKkwC5MtdwFPHiVqX7DTCooPVWAxPVjG8/pjjPbl+7LNTXTuSDit1oZGtCjkBYFqahb95J4pAHzEumdNhs";
        return new Configuration.Builder(clientId, clientSecret, SCOPE);
    }

//    private void authenticateWithClientCredentials() {
//        VimeoClient.getInstance().authorizeWithClientCredentialsGrant(new AuthCallback() {
//            @Override
//            public void success() {
//                String accessToken = VimeoClient.getInstance().getVimeoAccount().getAccessToken();
//                Log.i(TAG, "get success.");
////                toast("Client Credentials Authorization Success with Access Token: " + accessToken);
//            }
//
//            @Override
//            public void failure(VimeoError error) {
//                String errorMessage = error.getDeveloperMessage();
//                Log.i(TAG, error.getErrorMessage());
////                toast("Client Credentials Authorization Failure: " + errorMessage);
//            }
//        });
//    }

    public VimeoClient getmApiClient() {
        return mApiClient;
    }

    private void toast(String string) {
        Toast.makeText(getBaseContext(), string, Toast.LENGTH_SHORT).show();
    }
}

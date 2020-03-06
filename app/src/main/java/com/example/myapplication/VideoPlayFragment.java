package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.leanback.app.VideoSupportFragment;
import androidx.leanback.app.VideoSupportFragmentGlueHost;
import androidx.leanback.media.MediaPlayerAdapter;
import androidx.leanback.media.PlaybackTransportControlGlue;
import androidx.leanback.widget.PlaybackControlsRow;

import com.vimeo.networking.VimeoClient;
import com.vimeo.networking.callbacks.AuthCallback;
import com.vimeo.networking.callbacks.VimeoCallback;
import com.vimeo.networking.model.User;
import com.vimeo.networking.model.VideoList;
import com.vimeo.networking.model.error.VimeoError;

import okhttp3.CacheControl;

public class VideoPlayFragment extends VideoSupportFragment {

    private PlaybackTransportControlGlue<MediaPlayerAdapter> mTransportControlGlue;
    private static final String TAG = "VideoPlayFragment";

    public static final String STAFF_PICKS_VIDEO_URI = "/channels/927/videos"; // 927 == staffpicks

    // todo: last thing done: commented the following line
//    private final VimeoClient mApiClient = VimeoClient.getInstance();
    private ProgressDialog mProgressDialog;

    private TextView mRequestOutputTv;

    private TextView mStaffPicksRequestTime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        final Video video = VideoPlayActivity.video;

//        TestApp d = new TestApp();
//        d.onCreate();

        mProgressDialog = ProgressDialog.show(getActivity(), "", "Loading...", true);
        mProgressDialog.setCancelable(true);

//        try {
//
//            VideoSupportFragmentGlueHost glueHost =
//                    new VideoSupportFragmentGlueHost(VideoPlayFragment.this);
//
//            MediaPlayerAdapter mediaPlayerAdapter = new MediaPlayerAdapter(getActivity());
//            mediaPlayerAdapter.setRepeatAction(PlaybackControlsRow.RepeatAction.INDEX_NONE);
//
//            mTransportControlGlue = new PlaybackTransportControlGlue<>(getActivity(), mediaPlayerAdapter);
//            mTransportControlGlue.setHost(glueHost);
//            mTransportControlGlue.setTitle(video.getTitle());
//            mTransportControlGlue.setSubtitle(video.getDescription());
//            mTransportControlGlue.playWhenPrepared();
//
//            mediaPlayerAdapter.setDataSource(video.getVideoUri());
//            mProgressDialog.dismiss();
//
//        } catch (Exception e) {
//            Log.i("````error````: ", e.getMessage());
//        }

//        mProgressDialog = new ProgressDialog(getContext());
//        mProgressDialog.setMessage("All of your API are belong to us...");


    }

//    @Override
//    public void onClick(View v) {
////        switch (v.getId()) {
////            case R.id.staff_picks_gson_btn:
////                fetchStaffPicksWithGson();
////                break;
////            case R.id.staff_picks_moshi_btn:
////                fetchStaffPicksWithMoshi();
////                break;
////            case R.id.account_type_btn:
////                fetchAccountType();
////                break;
////            case R.id.logout_btn:
////                logout();
////                break;
////            case R.id.code_grant_btn:
////            case R.id.fab:
////                toast("Authenticate on Web");
////                goToWebForCodeGrantAuth();
////                break;
////        }
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // </editor-fold>

    // <editor-fold desc="Requests">

    private void fetchStaffPicksWithGson() {
        final long initialTime = System.currentTimeMillis();
        mProgressDialog.show();
//        mApiClient.getContent(STAFF_PICKS_VIDEO_URI, CacheControl.FORCE_NETWORK, GetRequestCaller.VIDEO_LIST, null, null, null, new VimeoCallback<VideoList>() {
//            @Override
//            public void success(VideoList videoList) {
//                final long finalTime = System.currentTimeMillis();
//                final long totalLoadTime = finalTime - initialTime;
//
//                if (videoList != null && videoList.getData() != null) {
//                    String videoTitlesString = "";
//                    boolean addNewLine = false;
//                    for (Video video : videoList.getData()) {
//                        if (addNewLine) {
//                            videoTitlesString += "\n";
//                        }
//                        addNewLine = true;
//                        videoTitlesString += video.mName;
//                    }
//                    mRequestOutputTv.setText(videoTitlesString);
//                }
//                mStaffPicksRequestTime.setText(getString(R.string.request_time, "Gson", totalLoadTime));
//
//                toast("Staff Picks Success ");
//                mProgressDialog.hide();
//            }
//
//            @Override
//            public void failure(VimeoError error) {
//                toast("Staff Picks Failure");
//                mRequestOutputTv.setText(error.getDeveloperMessage());
//                mProgressDialog.hide();
//            }
//        });
    }

    private void fetchStaffPicksWithMoshi() {
        final long initialTime = System.currentTimeMillis();
        mProgressDialog.show();
//        mApiClient.getContent(STAFF_PICKS_VIDEO_URI, CacheControl.FORCE_NETWORK, MoshiGetRequestCaller.VIDEO_LIST, null, null, null, new VimeoCallback<com.vimeo.networking2.VideoList>() {
//            @Override
//            public void success(com.vimeo.networking2.VideoList videoList) {
//                final long finalTime = System.currentTimeMillis();
//                final long totalLoadTime = finalTime - initialTime;
//
//                if (videoList != null && videoList.getData() != null) {
//                    String videoTitlesString = "";
//                    boolean addNewLine = false;
//                    for (com.vimeo.networking2.Video video : videoList.getData()) {
//                        if (addNewLine) {
//                            videoTitlesString += "\n";
//                        }
//                        addNewLine = true;
//                        videoTitlesString += video.getName();
//                    }
//                    mRequestOutputTv.setText(videoTitlesString);
//                }
//                mStaffPicksRequestTime.setText(getString(R.string.request_time, "Moshi", totalLoadTime));
//                toast("Staff Picks Success");
//                mProgressDialog.hide();
//            }
//
//            @Override
//            public void failure(VimeoError error) {
//                toast("Staff Picks Failure");
//                mRequestOutputTv.setText(error.getDeveloperMessage());
//                mProgressDialog.hide();
//            }
//        });
    }

    private void fetchAccountType() {
        mProgressDialog.show();
//        mApiClient.getCurrentUser(new VimeoCallback<User>() {
//            @Override
//            public void success(User user) {
//                if (user != null) {
//                    mRequestOutputTv.setText("Current account type: " + user.getMembership().getDisplay());
//                    toast("Account Check Success");
//                } else {
//                    toast("Account Check Failure");
//                }
//                mProgressDialog.hide();
//            }
//
//            @Override
//            public void failure(VimeoError error) {
//                toast("Account Check Failure");
//                mRequestOutputTv.setText(error.getDeveloperMessage());
//                mProgressDialog.hide();
//            }
//        });
    }

    private void logout() {
        mProgressDialog.show();
//        mApiClient.logOut(new VimeoCallback<Object>() {
//            @Override
//            public void success(Object o) {
//                AccountPreferenceManager.removeClientAccount();
//                toast("Logout Success");
//                mProgressDialog.hide();
//            }
//
//            @Override
//            public void failure(VimeoError error) {
//                AccountPreferenceManager.removeClientAccount();
//                toast("Logout Failure");
//                mRequestOutputTv.setText(error.getDeveloperMessage());
//                mProgressDialog.hide();
//            }
//        });
    }
    // </editor-fold>

    // <editor-fold desc="Code Grant">


    private void goToWebForCodeGrantAuth() {
//        String uri = mApiClient.getCodeGrantAuthorizationURI();
//        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
//        startActivity(browserIntent);
    }

    // </editor-fold>

    // <editor-fold desc="Helpers">

    private void toast(String string) {
        Toast.makeText(getContext(), string, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onPause() {
        super.onPause();
        if (mTransportControlGlue != null) {
            mTransportControlGlue.pause();
        }
    }

//
}
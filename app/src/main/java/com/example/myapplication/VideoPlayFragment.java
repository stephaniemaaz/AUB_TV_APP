package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.JsonReader;
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
import com.vimeo.networking.callbacks.ModelCallback;
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
    private VimeoClient mApiClient;
    private ProgressDialog mProgressDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        final Video video = VideoPlayActivity.video;

        TestApp d = new TestApp();
        d.onCreate();
        mApiClient = d.getmApiClient();

        String uri = video.getVideoUri().toString();
        mApiClient.getInstance().fetchNetworkContent(uri, new ModelCallback<Video>(Video.class) {
            @Override
            public void success(Video video) {
                Log.i(TAG, "get success.");
                // use the video
            }

            @Override
            public void failure(VimeoError error) {
                Log.i(TAG, error.getErrorMessage());
                // voice the error
            }
        });


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


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
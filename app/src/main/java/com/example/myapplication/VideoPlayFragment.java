package com.example.myapplication;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import androidx.leanback.app.VideoSupportFragment;
import androidx.leanback.app.VideoSupportFragmentGlueHost;
import androidx.leanback.media.MediaPlayerAdapter;
import androidx.leanback.media.PlaybackTransportControlGlue;
import androidx.leanback.widget.PlaybackControlsRow;

public class VideoPlayFragment extends VideoSupportFragment {

    private static ProgressDialog progressDialog;
    private PlaybackTransportControlGlue<MediaPlayerAdapter> mTransportControlGlue;
    private static final String TAG = "VideoPlayFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        final Video video = VideoPlayActivity.video;

        progressDialog = ProgressDialog.show(getActivity(), "", "Loading...", true);
        progressDialog.setCancelable(true);

        try {

            VideoSupportFragmentGlueHost glueHost =
                    new VideoSupportFragmentGlueHost(VideoPlayFragment.this);

            MediaPlayerAdapter mediaPlayerAdapter = new MediaPlayerAdapter(getActivity());
            mediaPlayerAdapter.setRepeatAction(PlaybackControlsRow.RepeatAction.INDEX_NONE);

            mTransportControlGlue = new PlaybackTransportControlGlue<>(getActivity(), mediaPlayerAdapter);
            mTransportControlGlue.setHost(glueHost);
            mTransportControlGlue.setTitle(video.getTitle());
            mTransportControlGlue.setSubtitle(video.getDescription());
            mTransportControlGlue.playWhenPrepared();

            mediaPlayerAdapter.setDataSource(video.getVideoUri());
            progressDialog.dismiss();

        } catch (Exception e) {
            Log.i("````error````: ", e.getMessage());
        }
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
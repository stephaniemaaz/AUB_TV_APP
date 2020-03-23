package com.example.myapplication;

import androidx.fragment.app.FragmentActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.List;

public class VideoPlayActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    public static final String API_KEY = "AIzaSyDZT-PBgFGHYw5Xcn-JIoaSSvp0g-ToJL0";
    public static final String VIDEO_ID = "RWnBUFKWQds";

    public static Video video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_play);

        Intent intent = getIntent();
        video = (Video) intent.getSerializableExtra("video");

//        YouTubePlayer uu = new YouTubePlayer() {
//            @Override
//            public void release() {
//
//            }
//
//            @Override
//            public void cueVideo(String s) {
//
//            }
//
//            @Override
//            public void cueVideo(String s, int i) {
//
//            }
//
//            @Override
//            public void loadVideo(String s) {
//
//            }
//
//            @Override
//            public void loadVideo(String s, int i) {
//
//            }
//
//            @Override
//            public void cuePlaylist(String s) {
//
//            }
//
//            @Override
//            public void cuePlaylist(String s, int i, int i1) {
//
//            }
//
//            @Override
//            public void loadPlaylist(String s) {
//
//            }
//
//            @Override
//            public void loadPlaylist(String s, int i, int i1) {
//
//            }
//
//            @Override
//            public void cueVideos(List<String> list) {
//
//            }
//
//            @Override
//            public void cueVideos(List<String> list, int i, int i1) {
//
//            }
//
//            @Override
//            public void loadVideos(List<String> list) {
//
//            }
//
//            @Override
//            public void loadVideos(List<String> list, int i, int i1) {
//
//            }
//
//            @Override
//            public void play() {
//
//            }
//
//            @Override
//            public void pause() {
//
//            }
//
//            @Override
//            public boolean isPlaying() {
//                return false;
//            }
//
//            @Override
//            public boolean hasNext() {
//                return false;
//            }
//
//            @Override
//            public boolean hasPrevious() {
//                return false;
//            }
//
//            @Override
//            public void next() {
//
//            }
//
//            @Override
//            public void previous() {
//
//            }
//
//            @Override
//            public int getCurrentTimeMillis() {
//                return 0;
//            }
//
//            @Override
//            public int getDurationMillis() {
//                return 0;
//            }
//
//            @Override
//            public void seekToMillis(int i) {
//
//            }
//
//            @Override
//            public void seekRelativeMillis(int i) {
//
//            }
//
//            @Override
//            public void setFullscreen(boolean b) {
//
//            }
//
//            @Override
//            public void setOnFullscreenListener(OnFullscreenListener onFullscreenListener) {
//
//            }
//
//            @Override
//            public void setFullscreenControlFlags(int i) {
//
//            }
//
//            @Override
//            public int getFullscreenControlFlags() {
//                return 0;
//            }
//
//            @Override
//            public void addFullscreenControlFlag(int i) {
//
//            }
//
//            @Override
//            public void setPlayerStyle(PlayerStyle playerStyle) {
//
//            }
//
//            @Override
//            public void setShowFullscreenButton(boolean b) {
//
//            }
//
//            @Override
//            public void setManageAudioFocus(boolean b) {
//
//            }
//
//            @Override
//            public void setPlaylistEventListener(PlaylistEventListener playlistEventListener) {
//
//            }
//
//            @Override
//            public void setPlayerStateChangeListener(PlayerStateChangeListener playerStateChangeListener) {
//
//            }
//
//            @Override
//            public void setPlaybackEventListener(PlaybackEventListener playbackEventListener) {
//
//            }
//        };

        YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_player);
        try {
            youTubePlayerView.initialize(API_KEY, this);
        } catch (Exception e) {
            Log.i("Error", e.getMessage());
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }


//        if (savedInstanceState == null) {
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(android.R.id.content, new VideoPlayFragment())
//                    .commit();
//        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(playbackEventListener);
/** Start buffering **/
        if (!b) {
            Toast.makeText(this, video.getYouTubeID(), Toast.LENGTH_LONG).show();

            youTubePlayer.cueVideo(video.getYouTubeID());
//            youTubePlayer.setFullscreen(true);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "erorr!", Toast.LENGTH_LONG).show();
    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onBuffering(boolean arg0) {
        }
        @Override
        public void onPaused() {
        }
        @Override
        public void onPlaying() {
        }
        @Override
        public void onSeekTo(int arg0) {
        }
        @Override
        public void onStopped() {
        }
    };

    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onAdStarted() {
        }
        @Override
        public void onError(YouTubePlayer.ErrorReason arg0) {
        }
        @Override
        public void onLoaded(String arg0) {
        }
        @Override
        public void onLoading() {
        }
        @Override
        public void onVideoEnded() {
        }
        @Override
        public void onVideoStarted() {
        }
    };
}

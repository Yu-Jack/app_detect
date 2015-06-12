// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.MediaController;
import android.view.ViewGroup;
import android.widget.VideoView;
import android.view.ViewGroup$LayoutParams;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer$OnErrorListener;
import android.media.MediaPlayer$OnCompletionListener;

final class AdVideoPlayer implements MediaPlayer$OnCompletionListener, MediaPlayer$OnErrorListener
{
    private static String LOG_TAG;
    private AudioManager audioManager_;
    private String contentUrl_;
    private Context context_;
    private ViewGroup$LayoutParams layoutParams_;
    private AdVideoPlayer$AdVideoPlayerListener listener_;
    private Controller$PlayerProperties playerProperties_;
    private boolean released_;
    private VideoView videoView_;
    private ViewGroup viewGroup_;
    private int volumeBeforeMuting_;
    
    static {
        AdVideoPlayer.LOG_TAG = "AdVideoPlayer";
    }
    
    public AdVideoPlayer(final Context context_) {
        this.released_ = false;
        this.videoView_ = null;
        this.layoutParams_ = null;
        this.viewGroup_ = null;
        this.context_ = context_;
        this.playerProperties_ = new Controller$PlayerProperties();
        this.audioManager_ = (AudioManager)this.context_.getSystemService("audio");
    }
    
    private void displayPlayerControls() {
        Log.d(AdVideoPlayer.LOG_TAG, "in displayPlayerControls");
        if (this.playerProperties_.showControl()) {
            final MediaController mediaController = new MediaController(this.context_);
            this.videoView_.setMediaController(mediaController);
            mediaController.setAnchorView((View)this.videoView_);
            mediaController.requestFocus();
        }
    }
    
    private void initializeVideoView() {
        final VideoView videoView_ = new VideoView(this.context_);
        videoView_.setOnCompletionListener((MediaPlayer$OnCompletionListener)this);
        videoView_.setOnErrorListener((MediaPlayer$OnErrorListener)this);
        videoView_.setLayoutParams(this.layoutParams_);
        this.videoView_ = videoView_;
        this.viewGroup_.addView((View)this.videoView_);
    }
    
    private void loadPlayerContent() {
        this.videoView_.setVideoURI(Uri.parse(this.contentUrl_));
    }
    
    private void removePlayerFromParent() {
        Log.d(AdVideoPlayer.LOG_TAG, "in removePlayerFromParent");
        this.viewGroup_.removeView((View)this.videoView_);
    }
    
    public final void mutePlayer() {
        Log.d(AdVideoPlayer.LOG_TAG, "in mutePlayer");
        this.volumeBeforeMuting_ = this.audioManager_.getStreamVolume(3);
        this.audioManager_.setStreamVolume(3, 0, 4);
    }
    
    public final void onCompletion(final MediaPlayer mediaPlayer) {
        if (this.playerProperties_.doLoop()) {
            this.videoView_.start();
        }
        else if (this.playerProperties_.exitOnComplete() || this.playerProperties_.inline) {
            this.releasePlayer();
            if (this.listener_ != null) {
                this.listener_.onComplete();
            }
        }
    }
    
    public final boolean onError(final MediaPlayer mediaPlayer, final int n, final int n2) {
        this.removePlayerFromParent();
        if (this.listener_ != null) {
            this.listener_.onError();
        }
        return false;
    }
    
    public final void playAudio() {
        Log.d(AdVideoPlayer.LOG_TAG, "in playAudio");
        this.loadPlayerContent();
    }
    
    public final void playVideo() {
        Log.d(AdVideoPlayer.LOG_TAG, "in playVideo");
        if (this.playerProperties_.doMute()) {
            this.mutePlayer();
        }
        this.initializeVideoView();
        this.loadPlayerContent();
        this.startPlaying();
    }
    
    public final void releasePlayer() {
        Log.d(AdVideoPlayer.LOG_TAG, "in releasePlayer");
        if (!this.released_) {
            this.released_ = true;
            this.videoView_.stopPlayback();
            this.removePlayerFromParent();
            if (this.playerProperties_.doMute()) {
                this.unmutePlayer();
            }
        }
    }
    
    public final void setLayoutParams(final ViewGroup$LayoutParams layoutParams_) {
        this.layoutParams_ = layoutParams_;
    }
    
    public final void setListener(final AdVideoPlayer$AdVideoPlayerListener listener_) {
        this.listener_ = listener_;
    }
    
    public final void setPlayData(final Controller$PlayerProperties playerProperties_, final String contentUrl_) {
        this.released_ = false;
        if (playerProperties_ != null) {
            this.playerProperties_ = playerProperties_;
        }
        this.contentUrl_ = contentUrl_;
    }
    
    public final void setViewGroup(final ViewGroup viewGroup_) {
        this.viewGroup_ = viewGroup_;
    }
    
    public final void startPlaying() {
        Log.d(AdVideoPlayer.LOG_TAG, "in startPlaying");
        this.displayPlayerControls();
        if (this.playerProperties_.isAutoPlay()) {
            this.videoView_.start();
        }
    }
    
    public final void unmutePlayer() {
        Log.d(AdVideoPlayer.LOG_TAG, "in unmutePlayer");
        this.audioManager_.setStreamVolume(3, this.volumeBeforeMuting_, 4);
    }
}

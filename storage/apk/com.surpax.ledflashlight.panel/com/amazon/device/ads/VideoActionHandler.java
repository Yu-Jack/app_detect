// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.widget.RelativeLayout$LayoutParams;
import android.content.Context;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.app.Activity;

class VideoActionHandler implements IAdActivityAdapter
{
    private Activity activity;
    private RelativeLayout layout;
    private AdVideoPlayer player;
    
    private void initPlayer(final Bundle bundle) {
        final Controller$PlayerProperties controller$PlayerProperties = (Controller$PlayerProperties)bundle.getParcelable("player_properties");
        final Controller$Dimensions controller$Dimensions = (Controller$Dimensions)bundle.getParcelable("player_dimensions");
        (this.player = new AdVideoPlayer((Context)this.activity)).setPlayData(controller$PlayerProperties, bundle.getString("url"));
        RelativeLayout$LayoutParams layoutParams;
        if (controller$Dimensions == null) {
            layoutParams = new RelativeLayout$LayoutParams(-1, -1);
            layoutParams.addRule(13);
        }
        else {
            layoutParams = new RelativeLayout$LayoutParams(controller$Dimensions.width, controller$Dimensions.height);
            layoutParams.topMargin = controller$Dimensions.y;
            layoutParams.leftMargin = controller$Dimensions.x;
        }
        this.player.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.player.setViewGroup((ViewGroup)this.layout);
        this.setPlayerListener(this.player);
    }
    
    private void setPlayerListener(final AdVideoPlayer adVideoPlayer) {
        adVideoPlayer.setListener(new AdVideoPlayer$AdVideoPlayerListener() {
            @Override
            public void onComplete() {
                VideoActionHandler.this.activity.finish();
            }
            
            @Override
            public void onError() {
                VideoActionHandler.this.activity.finish();
            }
        });
    }
    
    @Override
    public void onCreate() {
        final Bundle extras = this.activity.getIntent().getExtras();
        (this.layout = new RelativeLayout((Context)this.activity)).setLayoutParams(new ViewGroup$LayoutParams(-1, -1));
        this.activity.setContentView((View)this.layout);
        this.initPlayer(extras);
        this.player.playVideo();
    }
    
    @Override
    public void onPause() {
    }
    
    @Override
    public void onResume() {
    }
    
    @Override
    public void onStop() {
        this.player.releasePlayer();
        this.player = null;
        this.activity.finish();
    }
    
    @Override
    public void preOnCreate() {
    }
    
    @Override
    public void setActivity(final Activity activity) {
        this.activity = activity;
    }
}

// 
// Decompiled by Procyon v0.5.29
// 

package com.amazon.device.ads;

import org.json.JSONException;
import org.json.JSONArray;

public class AdProperties
{
    private static final String LOG_TAG = "AdProperties";
    private AdProperties$AdType adType_;
    private boolean canExpand_;
    private boolean canPlayAudio_;
    private boolean canPlayVideo_;
    
    protected AdProperties() {
        this.canExpand_ = false;
        this.canPlayAudio_ = false;
        this.canPlayVideo_ = false;
    }
    
    AdProperties(final JSONArray jsonArray) {
        this.canExpand_ = false;
        this.canPlayAudio_ = false;
        this.canPlayVideo_ = false;
        if (jsonArray != null) {
            for (int i = 0; i < jsonArray.length(); ++i) {
                Label_0201: {
                    Label_0191: {
                        Label_0183: {
                            Label_0173: {
                                Label_0163: {
                                    Label_0155: {
                                        try {
                                            switch (jsonArray.getInt(i)) {
                                                case 1003:
                                                case 1004: {
                                                    break Label_0155;
                                                }
                                                case 1007: {
                                                    break Label_0163;
                                                }
                                                case 1008: {
                                                    break Label_0173;
                                                }
                                                case 1014: {
                                                    break Label_0183;
                                                }
                                                case 1016: {
                                                    break Label_0191;
                                                }
                                                case 1017: {
                                                    break Label_0201;
                                                }
                                                case 1001:
                                                case 1002: {
                                                    this.canPlayAudio_ = true;
                                                    break;
                                                }
                                            }
                                        }
                                        catch (JSONException ex) {
                                            Log.w("AdProperties", "Unable to parse creative type: %s", ex.getMessage());
                                        }
                                        continue;
                                    }
                                    this.canExpand_ = true;
                                    continue;
                                }
                                this.adType_ = AdProperties$AdType.IMAGE_BANNER;
                                continue;
                            }
                            this.adType_ = AdProperties$AdType.INTERSTITIAL;
                            continue;
                        }
                        this.canPlayVideo_ = true;
                        continue;
                    }
                    this.adType_ = AdProperties$AdType.MRAID_1;
                    continue;
                }
                this.adType_ = AdProperties$AdType.MRAID_2;
            }
        }
    }
    
    public boolean canExpand() {
        return this.canExpand_;
    }
    
    public boolean canPlayAudio() {
        return this.canPlayAudio_;
    }
    
    public boolean canPlayVideo() {
        return this.canPlayVideo_;
    }
    
    public AdProperties$AdType getAdType() {
        return this.adType_;
    }
    
    void setAdType(final AdProperties$AdType adType_) {
        this.adType_ = adType_;
    }
    
    void setCanExpand(final boolean canExpand_) {
        this.canExpand_ = canExpand_;
    }
    
    void setCanPlayAudio(final boolean canPlayAudio_) {
        this.canPlayAudio_ = canPlayAudio_;
    }
    
    void setCanPlayVideo(final boolean canPlayVideo_) {
        this.canPlayVideo_ = canPlayVideo_;
    }
}

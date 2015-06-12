// 
// Decompiled by Procyon v0.5.29
// 

package com.google.analytics.containertag.common;

public enum FunctionType
{
    ADROLL_SMART_PIXEL("_asp"), 
    ADVERTISER_ID("_aid"), 
    ADVERTISING_TRACKING_ENABLED("_ate"), 
    ADWORDS_CLICK_REFERRER("_awcr"), 
    ADWORDS_CONVERSION("_awct"), 
    AJAX_SUBMIT_LISTENER("_ajl"), 
    APP_ID("_ai"), 
    APP_NAME("_an"), 
    APP_VERSION("_av"), 
    ARBITRARY_HTML("_html"), 
    ARBITRARY_JAVASCRIPT("_jsm"), 
    ARBITRARY_PIXEL("_img"), 
    BIZO_INSIGHT("_bzi"), 
    CLICK_LISTENER("_cl"), 
    CLICK_TALE_STANDARD("_cts"), 
    COMSCORE_MEASUREMENT("_csm"), 
    CONFIGURATION_VALUE("_cv"), 
    CONSTANT("_c"), 
    CONTAINER_VERSION("_ctv"), 
    CONTAINS("_cn"), 
    COOKIE("_k"), 
    CRITEO("_crt"), 
    CUSTOM_VAR("_v"), 
    DATA_LAYER_WRITE("_dlw"), 
    DEBUG_MODE("_dbg"), 
    DEVICE_ID("_did"), 
    DEVICE_NAME("_dn"), 
    DEVICE_TYPE("_dt"), 
    DOM_ELEMENT("_d"), 
    ELEMENT_TEXT("_et"), 
    ENCODE("_enc"), 
    ENDS_WITH("_ew"), 
    EQUALS("_eq"), 
    EVENT("_e"), 
    FLOODLIGHT_COUNTER("_flc"), 
    FLOODLIGHT_SALES("_fls"), 
    FORM_SUBMIT_LISTENER("_fsl"), 
    FUNCTION_CALL("_func"), 
    GOOGLE_AFFILIATE_NETWORK("_gan"), 
    GOOGLE_ANALYTICS("_ga"), 
    GOOGLE_TAG_MANAGER("_gtm"), 
    GREATER_EQUALS("_ge"), 
    GREATER_THAN("_gt"), 
    GTM_VERSION("_gtmv"), 
    HASH("_hsh"), 
    HISTORY_LISTENER("_hl"), 
    INSTALL_REFERRER("_ir"), 
    JOINER("_jn"), 
    JS_ERROR_LISTENER("_jel"), 
    JS_GLOBAL("_j"), 
    LANGUAGE("_l"), 
    LESS_EQUALS("_le"), 
    LESS_THAN("_lt"), 
    LINK_CLICK_LISTENER("_lcl"), 
    MARIN_SOFTWARE("_ms"), 
    MEDIA6DEGREES_UNIVERSAL_PIXEL("_m6d"), 
    MEDIAPLEX_MCT("_mpm"), 
    MEDIAPLEX_ROI("_mpr"), 
    MOBILE_ADWORDS_UNIQUE_ID("_awid"), 
    OS_VERSION("_ov"), 
    PLATFORM("_p"), 
    QUANTCAST_MEASUREMENT("_qcm"), 
    RANDOM("_r"), 
    REFERRER("_f"), 
    REGEX("_re"), 
    REGEX_GROUP("_reg"), 
    RESOLUTION("_rs"), 
    RUNTIME_VERSION("_rv"), 
    SDK_VERSION("_sv"), 
    SIMPLE_MAP("_smm"), 
    SMART_PIXEL("_sp"), 
    STARTS_WITH("_sw"), 
    TARGUS_ADVISOR("_ta"), 
    TIME("_t"), 
    TIMER_LISTENER("_tl"), 
    TRUSTED_STORES("_ts"), 
    TURN_CONVERSION("_tc"), 
    TURN_DATA_COLLECTION("_tdc"), 
    UNIVERSAL_ANALYTICS("_ua"), 
    URL("_u"), 
    VISUAL_DNA_CONVERSION("_vdc");
    
    private final String name;
    
    private FunctionType(final String name2) {
        this.name = name2;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}

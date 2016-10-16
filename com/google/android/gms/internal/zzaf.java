package com.google.android.gms.internal;

public enum zzaf {
    ADVERTISER_ID("_aid"),
    ADVERTISING_TRACKING_ENABLED("_ate"),
    APP_ID("_ai"),
    APP_NAME("_an"),
    APP_VERSION("_av"),
    ARBITRARY_JAVASCRIPT("_jsm"),
    CONSTANT("_c"),
    COOKIE("_k"),
    CUSTOM_VAR("_v"),
    CONTAINER_VERSION("_ctv"),
    DEBUG_MODE("_dbg"),
    DEVICE_NAME("_dn"),
    DEVICE_TYPE("_dt"),
    DOM_ELEMENT("_d"),
    ELEMENT_ATTRIBUTE("_eam"),
    ELEMENT_TEXT("_et"),
    ELEMENT_URL("_eu"),
    EVENT("_e"),
    FUNCTION_CALL("_func"),
    HTML_ID("_hid"),
    JS_GLOBAL("_j"),
    LANGUAGE("_l"),
    MERGE_QUERY_PARAMS("_mqp"),
    OS_VERSION("_ov"),
    PLATFORM("_p"),
    RANDOM("_r"),
    REFERRER("_f"),
    RESOLUTION("_rs"),
    RUNTIME_VERSION("_rv"),
    SDK_VERSION("_sv"),
    SIMPLE_MAP("_smm"),
    TIME("_t"),
    URL("_u"),
    ADWORDS_CLICK_REFERRER("_awcr"),
    DEVICE_ID("_did"),
    ENCODE("_enc"),
    GTM_VERSION("_gtmv"),
    HASH("_hsh"),
    INSTALL_REFERRER("_ir"),
    JOINER("_jn"),
    MOBILE_ADWORDS_UNIQUE_ID("_awid"),
    REGEX_GROUP("_reg"),
    DATA_LAYER_WRITE("_dlw"),
    LOWERCASE_STRING("_ls"),
    UPPERCASE_STRING("_us"),
    EXPERIMENT_ENABLED("_ee"),
    IN_EXPERIMENT("_ie"),
    EXPERIMENT_VARIATION_INDEX("_evi"),
    EXPERIMENT_UID("_euid"),
    AUDIENCE_LISTS("_aud"),
    CSS_SELECTOR("_sel"),
    GA_CLIENT_ID("_gacid"),
    GEO_IP("_geo"),
    USER_AGENT("_uagt"),
    GA_FIRST_PAGE("_gafp"),
    EXPERIMENT_EXPIRATION_DATES("_xxd"),
    UNDEFINED_VALUE("_uv"),
    EXPERIMENT_STATE("_exs"),
    PRODUCT_SETTING_PROPERTY("_prodset"),
    GA_OPT_OUT_CLIENT("_gaoo_c"),
    GA_OPT_OUT_SERVER("_gaoo_s"),
    REGEX("_re"),
    STARTS_WITH("_sw"),
    ENDS_WITH("_ew"),
    CONTAINS("_cn"),
    EQUALS("_eq"),
    LESS_THAN("_lt"),
    LESS_EQUALS("_le"),
    GREATER_THAN("_gt"),
    GREATER_EQUALS("_ge"),
    CSS_SELECTOR_PREDICATE("_css"),
    URL_MATCHES("_um"),
    ARBITRARY_PIXEL("_img"),
    ARBITRARY_HTML("_html"),
    GOOGLE_TAG_MANAGER("_gtm"),
    GOOGLE_ANALYTICS("_ga"),
    ADWORDS_CONVERSION("_awct"),
    SMART_PIXEL("_sp"),
    FLOODLIGHT_COUNTER("_flc"),
    FLOODLIGHT_SALES("_fls"),
    BIZO_INSIGHT("_bzi"),
    QUANTCAST_MEASUREMENT("_qcm"),
    TARGUS_ADVISOR("_ta"),
    MEDIAPLEX_ROI("_mpr"),
    COMSCORE_MEASUREMENT("_csm"),
    TURN_CONVERSION("_tc"),
    TURN_DATA_COLLECTION("_tdc"),
    MEDIA6DEGREES_UNIVERSAL_PIXEL("_m6d"),
    UNIVERSAL_ANALYTICS("_ua"),
    MEDIAPLEX_MCT("_mpm"),
    VISUAL_DNA_CONVERSION("_vdc"),
    GOOGLE_AFFILIATE_NETWORK("_gan"),
    MARIN_SOFTWARE("_ms"),
    ADROLL_SMART_PIXEL("_asp"),
    CONFIGURATION_VALUE("_cv"),
    CRITEO("_crt"),
    TRUSTED_STORES("_ts"),
    CLICK_TALE_STANDARD("_cts"),
    LINK_CLICK_LISTENER("_lcl"),
    FORM_SUBMIT_LISTENER("_fsl"),
    TIMER_LISTENER("_tl"),
    CLICK_LISTENER("_cl"),
    JS_ERROR_LISTENER("_jel"),
    HISTORY_LISTENER("_hl"),
    AJAX_SUBMIT_LISTENER("_ajl"),
    YOU_TUBE_LISTENER("_ytl"),
    CHANGE_ELEMENT_ATTRIBUTE("_ea"),
    ELEMENT_CONTENT("_ec"),
    ELEMENT_MOVE("_em"),
    ELEMENT_SCRIPT("_esc"),
    ELEMENT_STYLE("_est"),
    ELEMENT_TEXT_TAG("_etx"),
    ORDERED_LIST("_ol"),
    DOM_TREATMENT("_dr"),
    UNIVERSAL_ANALYTICS_EXPERIMENT("_uae"),
    GOOGLE_ANALYTICS_GLOBAL("_gag"),
    ADOMETRY("_adm"),
    ADWORDS_APP_USAGE_TRACKING("_awut"),
    PAGE_REDIRECT("_pr"),
    APP_VERSION_NAME("_avn"),
    EXPERIMENT_STATE_UPDATE("_exsu");
    
    private final String name;

    private zzaf(String str) {
        this.name = str;
    }

    public String toString() {
        return this.name;
    }
}

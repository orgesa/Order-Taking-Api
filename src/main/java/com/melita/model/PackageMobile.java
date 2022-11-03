package com.melita.model;

import lombok.Getter;

@Getter
public enum PackageMobile {

    INTERNET_250 ("INTERNET_250", "Internet 250Mbps"),
    INTERNET_1 ("INTERNET_1", "Internet 1Gbps"),
    TV_90("TV_90", "TV with 90 Channels"),
    TV_140("TV_140", "TV with 140 Channels"),
    TELEPHONY_FREE("TELEPHONY_FREE", "Free on net calls"),
    TELEPHONY_UNLIMITED("TELEPHONY_UNLIMITED", "Unlimited Calls"),
    MOBILE_POST_PAID("MOBILE", "Post paid"),
    MOBILE_PRE_PAID("MOBILE", "Pree paid");

    private final String key;
    private final String value;

    PackageMobile(String key, String value) {
        this.key = key;
        this.value=value;
    }



    public static Boolean getTypePakage(String key, String value) {

        for (PackageMobile e : PackageMobile.values()) {

            if (key.equalsIgnoreCase(e.getKey()) && value.equalsIgnoreCase(e.getValue())) {
                return true;
            }
        }
        return false;
    }

}

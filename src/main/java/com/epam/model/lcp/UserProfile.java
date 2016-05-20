package com.epam.model.lcp;

/**
 * Created by Sahak on 2/21/16.
 */
public enum UserProfile {

    USER    (1, "User", "label.user.profile.user"),
    ADMIN   (2, "Administrator", "label.user.profile.admin");

    UserProfile(int value, String title, String msgKey) {
        this.value = value;
        this.title = title;
        this.msgKey = msgKey;
    }

    public static UserProfile valueOf(int value) {
        for (UserProfile e : UserProfile.values()) {
            if (e.value == value) {
                return e;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    public String getMsgKey() {
        return msgKey;
    }

    private final int value;

    private final String title;

    private final String msgKey;
}

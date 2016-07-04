package com.example.headfirst.utils;

import android.text.TextUtils;

/**
 */
public class SomeUtils {

    public static String getRandomString() {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        return String.valueOf(chars.charAt((int) (Math.random() * 26)));
    }

    public static String getNotNullString(String input) {
        return TextUtils.isEmpty(input) ? "" : input;
    }

}

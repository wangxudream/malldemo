package com.kataer.mall.common.util;

public class StringUtils {
    public static boolean isEmpty(String str) {
        if (str != null) {
            if (!str.trim().equals("")) {
                return false;
            }
        }
        return true;
    }
}

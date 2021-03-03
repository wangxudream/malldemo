package com.kataer.mall.common.model;

public class UserVoThreadLocal {
    private static final ThreadLocal<UserVo> userVoThreadLocal = new ThreadLocal<>();

    public static void set(UserVo userVo) {
        userVoThreadLocal.set(userVo);
    }

    public static UserVo get() {
        return userVoThreadLocal.get();
    }

    public static void remove() {
        userVoThreadLocal.remove();
    }

}

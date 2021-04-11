package com.lwang.smilejetpack.utils;

import android.util.Log;

/**
 * @Author lwang
 * @Date 2021/4/10
 * @Description log 工具类
 */
public class LogUtils {
    /**
     * 日志输出级别NONE
     */
    public static final int LEVEL_NONE = 0;//上线级别

    /**
     * 日志输出级别V
     */
    private static final int LEVEL_VERBOSE = 1;

    /**
     * 日志输出级别D
     */
    private static final int LEVEL_DEBUG = 2;

    /**
     * 日志输出级别I
     */
    private static final int LEVEL_INFO = 3;

    /**
     * 日志输出级别W
     */
    private static final int LEVEL_WARN = 4;

    /**
     * 日志输出级别E
     */
    private static final int LEVEL_ERROR = 5;

    /**
     * 日志输出时的TAG
     */
    private static final String M_TAG = "mmmm";

    /* 是否允许输出log LEVEL_NONE时候不输出日志 */
    public static int mDebuggable = LEVEL_ERROR;

    /**
     * 以级别为 d 的形式输出LOG
     */
    public static void v(Object msg) {
        if (mDebuggable >= LEVEL_VERBOSE) {
            Log.v(M_TAG, msg + "");
        }
    }

    /**
     * 以级别为 d 的形式输出LOG
     */
    public static void d(Object msg) { //(可以list,map等数据类型)
        if (mDebuggable >= LEVEL_DEBUG) {
            Log.d(M_TAG, msg + "");
        }
    }

    /**
     * 以级别为 i 的形式输出LOG
     */
    public static void i(Object msg) {
        if (mDebuggable >= LEVEL_INFO) {
            Log.i(M_TAG, msg + "");
        }
    }

    /**
     * 以级别为 w 的形式输出LOG
     */
    public static void w(Object msg) {
        if (mDebuggable >= LEVEL_WARN) {
            Log.w(M_TAG, msg + "");
        }
    }

    /**
     * 以级别为 e 的形式输出LOG
     */
    public static void e(Object msg) {
        if (mDebuggable >= LEVEL_ERROR) {
            Log.e(M_TAG, msg + "");
        }
    }
}

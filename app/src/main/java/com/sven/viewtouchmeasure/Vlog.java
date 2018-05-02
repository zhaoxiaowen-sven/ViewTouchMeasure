package com.sven.viewtouchmeasure;

import android.util.Log;

import java.lang.reflect.Method;


/**
 * Created by bruce on 2017/10/14.
 *
 */

public class Vlog {

    public static final boolean DEBUG = getSystemProperties("persist.sys.log.ctrl", "no").equals("yes");

    private static final String PRE_TAG = "";

    // 图片下载分析开关 TAG:AppStore.ImageLoader
    public static final boolean IS_DUMP_IMG_LOADER_INFO = false;

    private static final boolean ERROR = true;

    private static final boolean WARN = true;

    private static final boolean INFO = true;

    public static void d(String tag, String msg) {
        if (DEBUG) {
            Log.d(PRE_TAG + tag, String.valueOf(msg));
        }
    }

    public static void d(String tag, String msg, Exception e) {
        if (DEBUG) {
            Log.d(PRE_TAG + tag, String.valueOf(msg), e);
        }
    }

    public static void d(String tag, String msg, Throwable throwable) {
        if (DEBUG) {
            Log.d(PRE_TAG + tag, String.valueOf(msg), throwable);
        }
    }

    public static void w(String tag, String msg) {
        if (WARN) {
            Log.w(PRE_TAG + tag, String.valueOf(msg));
        }
    }

    public static void w(String tag, String msg, Throwable t) {
        if (WARN) {
            Log.w(PRE_TAG + tag, String.valueOf(msg), t);
        }
    }

    public static void w(String tag, String msg, Exception e) {
        if (WARN) {
            Log.w(PRE_TAG + tag, String.valueOf(msg), e);
        }
    }

    public static void v(String tag, String msg) {
        if (DEBUG) {
            Log.v(PRE_TAG + tag, String.valueOf(msg));
        }
    }

    public static void i(String tag, String msg) {
        if (INFO) {
            Log.i(PRE_TAG + tag, String.valueOf(msg));
        }
    }

    public static void i(String tag, String msg, Throwable throwable) {
        if (INFO) {
            Log.i(PRE_TAG + tag, String.valueOf(msg), throwable);
        }
    }

    public static void e(String tag, String msg, Exception e) {
        if (ERROR) {
            Log.e(PRE_TAG + tag, String.valueOf(msg), e);
        //    recordStringInfo(tag, msg, e, null);
        }
    }

    public static void e(String tag, String msg, Throwable throwable) {
        if (ERROR) {
            Log.e(PRE_TAG + tag, String.valueOf(msg), throwable);
        //    recordStringInfo(tag, msg, null, throwable);
        }
    }

    /**
     * 记录日志信息。遵守单一原则，如果后续添加发log邮件等需求，可以另外添加方法，Vlog不添加其他任何业务变量
     * 比如WriteLogThread里面的sLogQueue，不应该在该类声明
     */
    private static void recordStringInfo(String tag, String msg, Exception e, Throwable throwable) {
        if (!DEBUG) {
            return;
        }
//        WriteLogRunnable.getInstance().setLogInfo(PRE_TAG + tag, msg, e, throwable);

    }

    private static String getSystemProperties(String key, String def) {
        Method method = null;
        String value = def;
        try {
            method = Class.forName("android.os.SystemProperties").getMethod("get", String.class);
            value = (String) method.invoke(null, key);
        } catch (Exception e) {
            // nothing we can do
            // 老机器上没有这个值，所以在老机器上无法通过开启log录制来让debug生效
        }
        if (value == null || value.length() == 0) {
            value = def;
        }
        return value;
    }
}

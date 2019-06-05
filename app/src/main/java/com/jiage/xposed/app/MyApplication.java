package com.jiage.xposed.app;

import android.app.Application;

import org.xutils.x;


/**
 * 作者：李忻佳
 * 时间：2017/11/26/026
 * 说明：MyApplication
 */

public class MyApplication extends Application {
    private static MyApplication myApplication;
    public static boolean isDebug = false;//是否是debug模式
    public static String DbVersion = "4";//数据库版本
    public static String IP;

    /**
     * 初始化Application
     *
     * @return
     */
    public static MyApplication getApplication() {
        if (myApplication == null) {
            synchronized (MyApplication.class) {
                if (myApplication == null) {
                    myApplication = new MyApplication();
                }
            }
        }
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //xUtils3
        x.Ext.init(this);
        x.Ext.setDebug(isDebug); //输出debug日志，开启会影响性能
    }
}

package com.jiage.xposed.utile;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * 其他util
 */
public class OtherUtil {

    public static int getBuildVersion() {
        return Build.VERSION.SDK_INT;
    }

    /**
     * B 转
     * @param size
     * @return
     */
    public static String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;

        if (size >= gb) {
            return String.format("%.1f GB", (float) size / gb);
        } else if (size >= mb) {
            float f = (float) size / mb;
            return String.format(f > 100 ? "%.0f MB" : "%.1f MB", f);
        } else if (size >= kb) {
            float f = (float) size / kb;
            return String.format(f > 100 ? "%.0f KB" : "%.1f KB", f);
        } else
            return String.format("%d B", size);
    }

    /**
     * 获取随机数   start - end
     * @param start
     * @param end
     * @return
     */
    public static int getRandom(int start ,int end){
        Random random = new Random();
        return random.nextInt(end)%(end-start+1) + start;
    }

    /**
     * 去掉小数点后面的0
     *
     * @param str
     * @return
     */
    public static String format(double str) {
        DecimalFormat df = new DecimalFormat("###.####");
        return df.format(str);
    }
    /**
     * DecimalFormat转换最简便
     */
    public static String formatMoney(double str) {
        DecimalFormat df = new DecimalFormat("0.00");
        return  String.valueOf(df.format(str));
    }
    /**
     * 设置手机号中间用*表示
     *
     * @param mobile
     * @return
     */
    public static String hideMobile(String mobile) {
        String result = null;
        if (!TextUtils.isEmpty(mobile) && TextUtils.isDigitsOnly(mobile) && mobile.length() == 11) {
            result = mobile.substring(0, 3) + "****" + mobile.substring(7);
        }
        return result;
    }


    /*public static boolean isId_Card(CharSequence str) {
        final int len = str.length();
        for (int i = 0; i < len-1; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
            if(x X){}
        }
        return true;
    }*/

    public static Type[] getType(Class<?> clazz) {
        Type[] types = null;
        if (clazz != null) {
            Type type = clazz.getGenericSuperclass();
            ParameterizedType parameterizedType = (ParameterizedType) type;
            types = parameterizedType.getActualTypeArguments();
        }
        return types;
    }

    public static Type getType(Class<?> clazz, int index) {
        Type type = null;
        Type[] types = getType(clazz);
        if (types != null && index >= 0 && types.length > index) {
            type = types[index];
        }
        return type;
    }

    public static String build(Object... content) {
        return build(",", content);
    }

    public static String build(String separator, Object... content) {
        if (separator == null) {
            separator = "";
        }
        StringBuilder sb = new StringBuilder();
        if (content != null && content.length > 0) {
            for (Object obj : content) {
                if (obj != null) {
                    sb.append(obj.toString()).append(separator);
                }
            }
        }
        return sb.toString();
    }
}

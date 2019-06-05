package com.jiage.xposed.http;

import android.text.TextUtils;
import android.util.Log;

import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.xutils.common.Callback;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class RequestCallBackProxy implements Callback.CacheCallback<String> {
    private static final String STRING_NULL = "\":null";
    private static final String STRING_FALSE = "\":false";
    private static final String STRING_EMPTY_ARRAY = "\":[]";
    private RequestCallBack<String> mOriginalCallBack;

    public RequestCallBackProxy(RequestCallBack<String> originalCallBack) {
        this.mOriginalCallBack = originalCallBack;
        if (mOriginalCallBack != null) {
            mOriginalCallBack.onStart();
        }
    }

    @Override
    public boolean onCache(String result) {
        return false;
    }

    @Override
    public void onSuccess(String result) {
        Log.e("YMYHTTP", "原始结果:" + result);
        try {
            result = beforeOnSuccessBack(result);
            if (mOriginalCallBack != null) {
                mOriginalCallBack.onSuccessBack(result);
            }
        } catch (Exception e) {
            showErrorTip(e);
        }
        if (beforeOnSuccess(result)) {
        } else {
            try {
                if (mOriginalCallBack != null) {
                    mOriginalCallBack.onSuccess(result);
                }
            } catch (Exception e) {
                showErrorTip(e);
            }
        }
    }

    /**
     * @param responseInfo
     * @return true:回调不继续执行，false:回调继续执行
     */
    private boolean beforeOnSuccess(String responseInfo) {
        if (checkLoginState()) {
            return true;
        }
        return false;
    }

    private boolean checkLoginState() {
        return false;
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        showErrorTip(ex);
        if (mOriginalCallBack != null) {
            mOriginalCallBack.onFailure(0, ex.getMessage());
            mOriginalCallBack.onFinish();
        }
    }

    @Override
    public void onCancelled(CancelledException cex) {
        if (mOriginalCallBack != null) {
            mOriginalCallBack.onCancelled();
        }
    }

    @Override
    public void onFinished() {
        if (mOriginalCallBack != null) {
            mOriginalCallBack.onFinish();
        }
    }

    private void showErrorTip(Throwable error) {
        if (error != null) {
            if (error instanceof JSONException) {
                showErrorToast(true,"数据解析异常!");
            } else if (error instanceof UnknownHostException) {
                showErrorToast(true,"无法访问的服务器地址!");
            } else if (error instanceof ConnectException) {
                showErrorToast(true,"连接服务器失败!");
            } else if (error instanceof SocketTimeoutException || error instanceof ConnectTimeoutException) {
                showErrorToast(true,"连接超时!");
            } else if (error instanceof SocketException) {
                showErrorToast(true,"连接服务器失败!");
            } else {
				showErrorToast(false,error.getMessage());
            }
        }
    }

    private void showErrorToast(boolean isShow,String text) {
        if(isShow)
        Log.e("onError",text);
    }

    private String beforeOnSuccessBack(String content) {
        if (!TextUtils.isEmpty(content)) {
//            // 替换false为null
//            if (content.contains(STRING_FALSE)) {
//                content = content.replace(STRING_FALSE, STRING_NULL);
//            }
            // 替换[]为null
            if (content.contains(STRING_EMPTY_ARRAY)) {
                content = content.replace(STRING_EMPTY_ARRAY, STRING_NULL);
            }
        }
        return content;
    }
}

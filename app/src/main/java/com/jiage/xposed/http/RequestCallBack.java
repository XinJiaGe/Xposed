package com.jiage.xposed.http;

/**
 * 作者：李忻佳.
 * 时间：2017/2/25.
 * 说明：
 */

public abstract class RequestCallBack<T> {
    private String requestUrl;
    protected Object userTag;
    private int rate;

    public RequestCallBack() {
        this.rate = 1000;
    }

    public RequestCallBack(int rate) {
        this.rate = rate;
    }

    public RequestCallBack(Object userTag) {
        this.rate = 1000;
        this.userTag = userTag;
    }

    public RequestCallBack(int rate, Object userTag) {
        this.rate = rate;
        this.userTag = userTag;
    }

    public final int getRate() {
        return this.rate < 200 ? 200 : this.rate;
    }

    public final void setRate(int rate) {
        this.rate = rate;
    }

    public Object getUserTag() {
        return this.userTag;
    }

    public void setUserTag(Object userTag) {
        this.userTag = userTag;
    }

    public final String getRequestUrl() {
        return this.requestUrl;
    }

    public final void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public void onStart() {
    }

    public void onCancelled() {
    }

    public void onLoading(long total, long current, boolean isUploading) {
    }

    public abstract void onSuccess(String var1);

    public void onSuccessBack(String responseInfo) {
    }

    public void onFailure(int code, String msg) {
    }

    public void onFinish() {
    }
}

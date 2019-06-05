package com.jiage.xposed.model;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者：李忻佳
 * 日期：2017/11/28/028.
 * 说明：
 */

public class RequestModel {

    private Map<String, Object> mData = new HashMap<>();
    private Map<String, File> mUploadFile = new HashMap<>();

    private String api = "";
    private String downloadUrl = "";
    private String uploadUrl = "";

    public RequestModel(Map<String, Object> data) {
        super();
        this.mData = data;
    }

    public RequestModel() {
        super();
    }

    public void remove(String rem) {
        mData.remove(rem);
    }

    public void put(String key, Object value) {
        mData.put(key, value);
    }

    public void putDownload(String url) {
        this.downloadUrl = url;
    }

    public void putUpload(String url) {
        this.uploadUrl = url;
    }

    public void putUploadFile(String key, File file) {
        mUploadFile.put(key, file);
    }

    public Map<String, Object> getData() {
        return mData;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public String getUploadUrl() {
        return uploadUrl;
    }

    public Map<String, File> getmUploadFile() {
        return mUploadFile;
    }
}

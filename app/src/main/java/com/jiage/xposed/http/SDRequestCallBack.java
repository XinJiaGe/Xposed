package com.jiage.xposed.http;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.jiage.xposed.model.RequestBase;
import com.jiage.xposed.utile.OtherUtil;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class SDRequestCallBack<E> extends RequestCallBack<String> {
    private boolean mToast = true;
    public String responseInfo;
    private E actModel;
    private List<E> actListModel;
    private RequestBase baseActModel;

    public SDRequestCallBack(boolean toast) {
        this.mToast = toast;
    }

    public SDRequestCallBack() {
    }

    @Override
    public void onSuccessBack(String responseInfo) {
        this.responseInfo = responseInfo;
        parseActModel();
        isSingleModel();
        super.onSuccessBack(responseInfo);
    }

    @Override
    public void onSuccess(String responseInfo) {
        if (baseActModel != null ) {
            int code = baseActModel.getCode();
            if (code == 200) {
                onSuccess(actModel);
            }else {
                onFailure(code, baseActModel.getMsg());
            }
        } else {
            onSuccess(actModel);
        }
    }

    public abstract void onSuccess(E entity);

    protected void parseActModel() {
        Class<E> clazz = null;
        Type type = OtherUtil.getType(getClass(), 0);
        if (type instanceof Class) {
            clazz = (Class<E>) type;
            try {
                actModel = JSON.parseObject(this.responseInfo, clazz);
                Log.e("MYHTTP", "RESOUT:   " + responseInfo);
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("MYHTTP", "解析出错:" + e.getMessage());
                actModel = JSON.parseObject("{\"code\": 0,\"msg\": \"APP解析出错" + e.getMessage() + "\"}", clazz);
            }
        }else {
            try {
                actListModel = JSON.parseArray(this.responseInfo, clazz);
                Log.e("MYHTTP", "RESOUT:   " + responseInfo);
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("MYHTTP", "解析出错:" + e.getMessage());
                actModel = JSON.parseObject("{\"code\": 0,\"msg\": \"APP解析出错" + e.getMessage() + "\"}", clazz);
            }
        }
    }

    private void isSingleModel() {
        if(actModel!=null) {
            if (actModel instanceof RequestBase) {
                baseActModel = (RequestBase) actModel;
            }
        }else{
            baseActModel = new RequestBase();
            baseActModel.setCode(200);
            baseActModel.setData(actListModel);
        }
    }
}

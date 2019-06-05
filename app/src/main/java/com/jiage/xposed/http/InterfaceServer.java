package com.jiage.xposed.http;


import android.util.Log;

import com.jiage.xposed.JsonUtil;
import com.jiage.xposed.model.RequestModel;

import org.xutils.common.Callback;
import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.Map;

import de.robv.android.xposed.XposedBridge;

/**
 * 接口请求类
 */
public class InterfaceServer {
    private Callback.Cancelable cancelable;

    private static final class Holder {
        static final InterfaceServer mInstance = new InterfaceServer();
    }

    private InterfaceServer() {
    }

    public static InterfaceServer getInstance() {
        return Holder.mInstance;
    }
    /**
     * Get请求
     *
     * @param setParams
     */
    public void InterfaceGet(RequestSetGetParamsBack setParams, RequestCallBack<String> requestCallBack) {
        requestInterface(null,HttpMethod.GET, setParams, requestCallBack);
    }
    /**
     * Get请求
     *
     * @param setParams
     */
    public void InterfaceGet(String url,RequestSetGetParamsBack setParams, RequestCallBack<String> requestCallBack) {
        requestInterface(url,HttpMethod.GET, setParams, requestCallBack);
    }

    /**
     * GET  POST  请求
     *
     * @param httpMethod 请求方法
     * @param setParams  请求参数
     */
    private void requestInterface(String url,HttpMethod httpMethod, RequestSetGetParamsBack setParams, RequestCallBack<String> requestCallBack) {
        RequestModel requestModel = new RequestModel();
        RequestModel requestParamsModel = setParams.setParams(requestModel);
        if (requestParamsModel != null) {
            RequestParams requestParams = getRequestParams(url,httpMethod, requestParamsModel);
            x.http().request(httpMethod, requestParams, new RequestCallBackProxy(requestCallBack));
        } else {
            if (requestCallBack != null) {
                requestCallBack.onFailure(0, "没带参数");
                requestCallBack.onFinish();
            }
        }
    }

    public interface RequestSetGetParamsBack {
        RequestModel setParams(RequestModel requestModel);
    }
    public RequestParams getRequestParams(String url, HttpMethod method, RequestModel model) {
        StringBuffer urlBuff = new StringBuffer();
        RequestParams requestParams = new RequestParams(url==null?("http://lovegood.zicp.vip/text_war_exploded/"+model.getApi()+"?"):(url+"?"));

        Map<String, Object> data = model.getData();
        if (data != null) {
            if (method == HttpMethod.GET) {
                for (Map.Entry<String, Object> item : data.entrySet()) {
                    if (item != null) {
                        urlBuff.append(item.getKey() + "=" + item.getValue() + "&");
                        requestParams.addQueryStringParameter(item.getKey(), String.valueOf(item.getValue()));
                    }
                }
                Log.e("MYHTTP", "URL:   " + requestParams.getUri() + urlBuff.toString());
                XposedBridge.log("------URL:   " + requestParams.getUri() + urlBuff.toString());
            } else {
                String jsonString = JsonUtil.object2Json(data);
                requestParams.setAsJsonContent(true);
                requestParams.setBodyContent(jsonString);
                Log.e("MYHTTP", "URL:   " + requestParams.getUri() + " " + jsonString);
                XposedBridge.log("------URL:   " + requestParams.getUri() + urlBuff.toString());
            }
        }
        return requestParams;
    }
}

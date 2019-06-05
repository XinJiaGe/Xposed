package com.jiage.xposed;

import com.alibaba.fastjson.JSON;

import java.util.Map;

public class JsonUtil {

    private JsonUtil() {
    }

    public static <T> T json2Object(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    public static String object2Json(Object obj) {
        return JSON.toJSONString(obj);
    }

    public static <T> T map2Object(Map map, Class<T> clazz) {
        T t = null;
        if (map != null) {
            String json = object2Json(map);
            t = json2Object(json, clazz);
        }
        return t;
    }

    public static Map<String, Object> json2Map(String json) {
        return JSON.parseObject(json, Map.class);
    }


}

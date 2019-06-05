package com.jiage.xposed;

import android.app.AndroidAppHelper;
import android.content.Intent;
import android.os.Bundle;

import com.jiage.xposed.model.Book;

import java.lang.reflect.Field;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

/**
 * Created by JiaGe on 2019/5/21.
 */

public class Hook implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        String packageName = lpparam.packageName;
        if(packageName.equals("com.reader.ikanxs")){
            XposedBridge.log("爱看免费小说");
            Class<?> sensor = XposedHelpers.findClass("com.reader.hailiangxs.page.detail.BookDetailActivity", lpparam.classLoader);
            XposedBridge.hookAllMethods(sensor, "A", new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    super.beforeHookedMethod(param);
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    super.afterHookedMethod(param);
                    //获取全局变量的值
                    XposedBridge.log("开始获取全局变量的值");
                    Class clazz = param.thisObject.getClass();
                    XposedBridge.log("class name:"+clazz.getName());
                    //通过类的字节码得到该类中声明的所有属性，无论私有或公有
                    Field fieldv = clazz.getDeclaredField("v");
                    //设置访问权限(这点对于有过Android开发经验的可以说很熟悉)
                    fieldv.setAccessible(true);
                    Object vm = fieldv.get(param.thisObject);
                    if(vm != null){
                        String json = JsonUtil.object2Json(vm);
                        XposedBridge.log("-----json:"+json);
                        if(json!=null){
                            Book book = JsonUtil.json2Object(json, Book.class);
                            XposedBridge.log("-----book:"+book);
                            if(book!=null){
                                Intent intent = new Intent();
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("model",book);
                                intent.putExtras(bundle);
                                intent.setAction(MainActivity.ACTION_NAME);
                                AndroidAppHelper.currentApplication().sendBroadcast(intent);
                            }
                        }
                    }
                }
            });
        }
    }
}

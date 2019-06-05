package com.jiage.xposed;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jiage.xposed.http.InterfaceServer;
import com.jiage.xposed.http.SDRequestCallBack;
import com.jiage.xposed.model.Book;
import com.jiage.xposed.model.ChapterListModel;
import com.jiage.xposed.model.RequestBase;
import com.jiage.xposed.model.RequestModel;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String ACTION_NAME = "com.jiage.xposed.MainActivity";
    private StringBuffer stringBuffer = new StringBuffer();
    private TextView textView;
    private Button bt;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.act_main_text);
        bt = findViewById(R.id.act_main_bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setChapter_list("http://zr-cpt-cdn.zrjhwenhua.com/book_4%2F14354%2Flist.txt?OSSAccessKeyId=LTAIGyykPxSXIFXf&Expires=1559728800&Signature=IoZ0hoQNUU8AxK391gPGKyrEk2Y%3D");
                addChapter(1,book);
            }
        });
        registerBoradcastReceiver();
    }

    private void set(String s){
        stringBuffer.append(s);
        stringBuffer.append("\n");
        textView.setText(stringBuffer.toString());
    }

    public void registerBoradcastReceiver(){
        IntentFilter myIntentFilter = new IntentFilter();
        myIntentFilter.addAction(ACTION_NAME);
        //注册广播
        registerReceiver(mBroadcastReceiver, myIntentFilter);
    }
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            if(action.equals(ACTION_NAME)){
                if (intent != null) {
                    Bundle bundle = intent.getExtras();
                    if (bundle != null) {
                        Book model = (Book) bundle.getSerializable("model");
                        if(model!=null&&id!=model.getBook_id()){
                            id = model.getBook_id();
                            set("《"+model.getBook_name()+"》");
                            addBook(model);
                        }
                    }
                }
            }
        }
    };

    /**
     * 添加图书
     * @param model
     */
    private void addBook(final Book model){
        InterfaceServer.getInstance().InterfaceGet(new InterfaceServer.RequestSetGetParamsBack() {
            @Override
            public RequestModel setParams(RequestModel requestModel) {
                requestModel.setApi("AddNovel");
                requestModel.put("type", "3");
                requestModel.put("name", model.getBook_name());
                requestModel.put("simple", model.getBook_brief());
                requestModel.put("content", "");
                requestModel.put("label", "");
                requestModel.put("isfolder", "1");
                requestModel.put("thumbnail", model.getBook_cover());
                requestModel.put("j", "0");
                return requestModel;
            }
        }, new SDRequestCallBack<RequestBase>() {
            @Override
            public void onSuccess(RequestBase entity) {
                set("发送数据成功："+model.getBook_name());
                addChapter(entity.getData(),model);
            }

            @Override
            public void onFailure(int code, String msg) {
                if(code == 100){
                    set("数据已存在："+model.getBook_name());
                }else{
                    set("发送数据失败："+msg);
                }
            }
        });
    }

    private void addChapter(Object id, final Book model){
        if(id!=null)
        InterfaceServer.getInstance().InterfaceGet(model.getChapter_list(),new InterfaceServer.RequestSetGetParamsBack() {
            @Override
            public RequestModel setParams(RequestModel requestModel) {
                return requestModel;
            }
        }, new SDRequestCallBack<List<ChapterListModel>>() {
            @Override
            public void onSuccess(List<ChapterListModel> entity) {
                set("获取章节成功");
//                InterfaceServer.getInstance().InterfaceGet(model.getChapter_list(),new InterfaceServer.RequestSetGetParamsBack() {
//                    @Override
//                    public RequestModel setParams(RequestModel requestModel) {
//                        requestModel.setApi("AddNovel");
//                        requestModel.put("type", "id");
//                        requestModel.put("name", model.getBook_name());
//                        requestModel.put("simple", model.getBook_brief());
//                        requestModel.put("content", "");
//                        requestModel.put("label", "");
//                        requestModel.put("isfolder", "1");
//                        requestModel.put("thumbnail", model.getBook_cover());
//                        requestModel.put("j", "0");
//                        return requestModel;
//                    }
//                }, new SDRequestCallBack<RequestBase>() {
//                    @Override
//                    public void onSuccess(RequestBase entity) {
//                        set("发送数据成功："+model.getBook_name());
//                    }
//
//                    @Override
//                    public void onFailure(int code, String msg) {
//                        if(code == 100){
//                            set("数据已存在："+model.getBook_name());
//                        }else{
//                            set("发送数据失败："+msg);
//                        }
//                    }
//                });
            }

            @Override
            public void onFailure(int code, String msg) {
                    set("获取章节失败："+msg);

            }
        });
    }

    @Override
    public void onDetachedFromWindow() {
        unregisterReceiver(mBroadcastReceiver);
    }
}

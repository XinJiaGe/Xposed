package com.jiage.xposed;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jiage.xposed.http.InterfaceServer;
import com.jiage.xposed.http.SDRequestCallBack;
import com.jiage.xposed.model.Book;
import com.jiage.xposed.model.RequestBase;
import com.jiage.xposed.model.RequestModel;

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
                book.setChapter_list("http://zr-cpt-cdn.zrjhwenhua.com/book_4%2F14354%2Flist.txt?OSSAccessKeyId=LTAIGyykPxSXIFXf&Expires=1559828211&Signature=FSglBRzf5sL5z4KAO0TU6dIXq0s%3D");
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
                        Book model = (Book) bundle.getSerializable("book");
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
                set("小说添加成功："+model.getBook_name());
            }

            @Override
            public void onFailure(int code, String msg) {
                if(code == 100){
                    set("小说已存在："+model.getBook_name());
                }else{
                    set("小说添加失败："+msg);
                }
            }
        });
    }

    @Override
    public void onDetachedFromWindow() {
        unregisterReceiver(mBroadcastReceiver);
    }
}

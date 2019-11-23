package com.example.chapter_02;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NormalActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.normal_layout);

        Button btn_destory = (Button)findViewById(R.id.btn_destory);
        btn_destory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCollector.finishAll();
                //杀掉当前进程的代码，以保证程序完全退出
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });
    }

    //最好的启动方法，建议使用，养成良好的代码习惯
    //actionStart()用于启动NormalActivity并向它传递数据
    public static void actionStart(Context context, String data1, String data2){
        Intent intent = new Intent(context, NormalActivity.class);
        intent.putExtra("param1", data1);
        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }
}

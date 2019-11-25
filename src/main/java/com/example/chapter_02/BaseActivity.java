package com.example.chapter_02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * BaseActivity继承自AppCompatActivity用来显示当前运行的活动
 */
public class BaseActivity extends AppCompatActivity{

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("BaseActivity", getClass().getSimpleName());
        //将当前创建的活动添加到活动管理器
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //将当前活动从活动管理器中移除
        ActivityCollector.removeActivity(this);
    }
}

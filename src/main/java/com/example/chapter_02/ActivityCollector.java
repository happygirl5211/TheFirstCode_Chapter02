package com.example.chapter_02;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * ActivityCollector作为活动管理器
 */

public class ActivityCollector {

    public static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }

    //finishAll()方法用于将List中存储的活动全部销毁掉
    public static void finishAll(){
        for(Activity activity : activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }

}

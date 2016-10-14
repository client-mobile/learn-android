package com.example.luo_0412.learnmore;

/**
 * Created by Luo_0412 on 2016/10/14.
 */

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class ActivityCollector {

    private static List<Activity> activities = new ArrayList<Activity>();

    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

}

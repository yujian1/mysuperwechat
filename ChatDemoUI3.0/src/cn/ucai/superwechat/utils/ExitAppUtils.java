package cn.ucai.superwechat.utils;

import android.app.Activity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Angela on 2016/11/5.
 */

public class ExitAppUtils  {
    List<Activity> mActivityList= new LinkedList<>();
    private static ExitAppUtils inatance = new ExitAppUtils();

    private ExitAppUtils(){}
    public static ExitAppUtils getInatance(){
         return inatance;
     }
    public void addActivity(Activity activity){
        mActivityList.add(activity);
    }
    public void delActivity(Activity activity){
        mActivityList.remove(activity);
    }
    public void exit(){
        for (Activity activity:mActivityList){
            activity.finish();
        }
    }
}

package cn.ucai.superwechat.utils;

import android.widget.Toast;

import cn.ucai.superwechat.I;
import cn.ucai.superwechat.R;
import cn.ucai.superwechat.widget.SuperChatApplication;

/**
 * Created by clawpo on 16/9/20.
 */
public class CommonUtils {
    public static void showLongToast(String msg){
        Toast.makeText(SuperChatApplication.applicationContext,msg,Toast.LENGTH_LONG).show();
    }
    public static void showShortToast(String msg){
        Toast.makeText(SuperChatApplication.applicationContext,msg,Toast.LENGTH_LONG).show();
  }
    public static void showLongToast(int rId){
        showLongToast(SuperChatApplication.applicationContext.getString(rId));
    }
    public static void showShortToast(int rId){
        showShortToast(SuperChatApplication.applicationContext.getString(rId));
    }
   public  static void showmsgShortToast(int msgId){
       if (msgId>0){
           showShortToast(SuperChatApplication.getInstance().getResources()
           .getIdentifier(I.MSG_PREFIX_MSG+msgId,"string",
                   SuperChatApplication.getInstance().getPackageName()));
       }else {
           showShortToast(R.string.msg_1);
       }
   }

}

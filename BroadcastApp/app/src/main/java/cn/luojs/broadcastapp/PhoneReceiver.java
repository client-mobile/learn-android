package cn.luojs.broadcastapp;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

/**
 * Created by Luo_0412 on 2016/11/11.
 */

public class PhoneReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent){
        // TODO Auto-generated method stub
        System.out.println("action"+intent.getAction());
        if(intent.getAction().equals(Intent.ACTION_NEW_OUTGOING_CALL)){
            //如果是去电（拨出）
            System.out.println("拨出");
            Log.d("MainActivity", "拔出");
        }else{
            //查了下android文档，貌似没有专门用于接收来电的action,所以，非去电即来电
            System.out.println("来电");
            Log.d("MainActivity", "来电");
            TelephonyManager tm = (TelephonyManager)context.getSystemService(Service.TELEPHONY_SERVICE);
            tm.listen(listener, PhoneStateListener.LISTEN_CALL_STATE);
            //设置一个监听器
        }
    }
    PhoneStateListener listener=new PhoneStateListener(){

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            // TODO Auto-generated method stub
            //state 当前状态 incomingNumber,貌似没有去电的API
            super.onCallStateChanged(state, incomingNumber);
            switch(state){
                case TelephonyManager.CALL_STATE_IDLE:
                    System.out.println("挂断");
                    Log.d("MainActivity", "挂断");
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    System.out.println("接听");
                    Log.d("MainActivity", "接听");
                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                    System.out.println("响铃:来电号码"+incomingNumber);
                    Log.d("MainActivity", incomingNumber);
                    //输出来电号码
                    break;
            }
        }
    };
}
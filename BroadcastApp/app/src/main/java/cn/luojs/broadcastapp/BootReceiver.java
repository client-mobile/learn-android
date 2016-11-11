package cn.luojs.broadcastapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Luo_0412 on 2016/11/11.
 */

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub

        Toast.makeText(context, "监听到开机完成", Toast.LENGTH_LONG).show();

        Intent intent1 = new Intent(context,MainActivity.class);
        //必须要添加这个标签 否则启动失败
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //跳转
        context.startActivity(intent1);
    }

}



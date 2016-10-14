package com.example.luo_0412.broadcasttest2;

/**
 * Created by Luo_0412 on 2016/10/14.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AnotherBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "received in AnotherBroadcastReceiver",
                Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }

}
package com.android.settings;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;

import com.android.settings.utils.MyHandler;
import com.google.android.collect.Sets;

import java.util.Arrays;
import java.util.Set;

public class MyFileReceiver extends BroadcastReceiver {

    private static final String TAG = "qll_receiver";
    @Override
    public void onReceive(Context context, Intent intent) {

        MyHandler handler = new MyHandler(context);

        String action = intent.getAction();


        if (action == null || action.equals("")) {
            Log.i(TAG, "onReceive: 没有接收到任何广播");
            return;
        }
        
        switch (action) {
            case Intent.ACTION_MEDIA_MOUNTED:
                Log.i(TAG, "onReceive: 设备挂载成功");
                handler.sendEmptyMessage(MyHandler.STORAGE_MOUNTED);
                break;
            case Intent.ACTION_MEDIA_UNMOUNTED:
                Log.i(TAG, "onReceive: 设备卸载成功");
                handler.sendEmptyMessage(MyHandler.STORAGE_UNMOUNTED);
                break;
        }
    }
}

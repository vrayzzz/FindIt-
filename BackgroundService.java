package com.example.vrayz.finalproject;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by Vrayz on 22-07-2015.
 */
public class BackgroundService extends Service {
    MyBroadcastReciever brHello;

    // public boolean isServicenotrunning=true;
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        //Toast.makeText(getApplicationContext(), "onCreate of service", Toast.LENGTH_SHORT).show();

        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        brHello = new MyBroadcastReciever();
        // Toast.makeText(getApplicationContext(), "onStart of service", Toast.LENGTH_SHORT).show();
        registerReceiver(brHello, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(brHello);

    }
}

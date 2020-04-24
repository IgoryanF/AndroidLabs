package com.example.lab5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    //receivers for action between user and features

    private final BroadcastReceiver broadcastReceiverForCam = new BroadcastReceiver() {

        @Override
        public void onReceive(Context c, Intent intent) {
            NoticeCamera();
        }
    };

    private final BroadcastReceiver broadcastReceiverForBatt = new BroadcastReceiver() {

        @Override
        public void onReceive(Context c, Intent intent) {
            if (intent.getAction().equals("android.intent.action.BATTERY_LOW")) {
                NoticeBattery();
            }
        }
    };

    private final BroadcastReceiver broadcastReceiverForAir = new BroadcastReceiver() {

        @Override
        public void onReceive(Context c, Intent intent) {
            boolean isAirplaneModeOn = intent.getBooleanExtra("state", false);
            Log.e("e","WW");
            NoticeAirplaneMode(isAirplaneModeOn);
        }
    };

    //launched notifications

    private void NoticeCamera() {
        NotificationForCamera notice = new NotificationForCamera();
        notice.show(getSupportFragmentManager(),"cam");
    }

    private void NoticeBattery() {
        NotificationForBattery notice = new NotificationForBattery();
        notice.show(getSupportFragmentManager(),"battery");
    }

    private void NoticeAirplaneMode(boolean AirplaneModeOn) {
        NotificationForAirplaneMode notice = new NotificationForAirplaneMode(AirplaneModeOn);
        notice.show(getSupportFragmentManager(),"airmode");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // intents for notifications about actions that started

        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_CAMERA_BUTTON);
        Intent intent1 = registerReceiver(broadcastReceiverForCam, intentFilter);
        IntentFilter intentFilter1 = new IntentFilter(Intent.ACTION_BATTERY_LOW);
        Intent intent = registerReceiver(broadcastReceiverForBatt, intentFilter1);
        IntentFilter intentFilter2 = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        Intent intent2 = registerReceiver(broadcastReceiverForAir, intentFilter2);
    }

    @Override
    protected void onStop() {
        super.onStop();

      // stopped notifications about actions

    if (broadcastReceiverForCam != null)
            unregisterReceiver(broadcastReceiverForCam);
        if (broadcastReceiverForBatt != null)
                 unregisterReceiver(broadcastReceiverForBatt);
             if (broadcastReceiverForAir != null)
                      unregisterReceiver(broadcastReceiverForAir);
    }
}
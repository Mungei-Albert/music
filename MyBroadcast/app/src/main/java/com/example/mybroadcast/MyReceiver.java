package com.example.mybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

class myReceiver extends BroadcastReceiver {
    public myReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // Handle the received broadcast here
        Toast.makeText(context, "Action: " + intent.getAction(), Toast.LENGTH_SHORT).show();
    }
}
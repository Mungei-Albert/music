package com.example.mybroadcast;


import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private IntentFilter intentFilter;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectionReceiver receiver = new ConnectionReceiver();
        intentFilter = new IntentFilter("com.dots.broadcast.SOME_ACTION");
        intentFilter = new IntentFilter("com.dots.broadcast.SOME_ACTION");

        button = findViewById(R.id.button); // Replace your_button_id with the actual ID from your layout
        button.setOnClickListener(view -> someMethod());
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReceiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }

    void someMethod() {
        Intent intent = new Intent("com.dots.broadcast.SOME_ACTION");
        sendBroadcast(intent);
    }
}
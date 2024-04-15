package com.example.receiver;




import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private receiver receiver;
    private IntentFilter intentFilter;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new receiver();
        intentFilter = new IntentFilter("com.example.receiver.SOME_ACTION");

        button = findViewById(R.id.button); // Replace your_button_id with the actual ID from your layout
        button.setOnClickListener(view -> someMethod());
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }

    void someMethod() {
        Intent intent = new Intent("com.example.receiver.SOME_ACTION");
        sendBroadcast(intent);
    }
}
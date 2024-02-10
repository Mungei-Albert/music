package com.example.surname;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextSurname;
    private EditText editTextPassword;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextSurname = findViewById(R.id.editTextSurname);
        editTextPassword = findViewById(R.id.editTextPassword);
        textViewResult = findViewById(R.id.textViewResult);
    }

    public void checkDetails(View view) {
        String surname = editTextSurname.getText().toString();
        String password = editTextPassword.getText().toString();

        // Replace the condition with your actual validation logic
        if ("correctSurname".equals(surname) && "correctPassword".equals(password)) {
            textViewResult.setText("Details are correct!");
        } else {
            textViewResult.setText("Incorrect details. Try again.");
        }
    }
}

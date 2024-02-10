package com.example.project1;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextAge;
    Button checkEligibilityButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        checkEligibilityButton = findViewById(R.id.checkEligibilityButton);
        resultTextView = findViewById(R.id.resultTextView);

        checkEligibilityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                int age = Integer.parseInt(editTextAge.getText().toString());

                String eligibilityMessage;

                if (age < 18) {
                    eligibilityMessage = name + ", you are not eligible for a driving license.";
                } else if (age >= 18 && age < 24) {
                    eligibilityMessage = name + ", you are eligible for a driving license for private vehicles only.";
                } else if (age >= 24 && age < 60) {
                    eligibilityMessage = name + ", you are eligible for a driving license for both private and public vehicles.";
                } else {
                    eligibilityMessage = name + ", you are eligible for a driving license for private vehicles only.";
                }

                resultTextView.setText(eligibilityMessage);
            }
        });
    }
}
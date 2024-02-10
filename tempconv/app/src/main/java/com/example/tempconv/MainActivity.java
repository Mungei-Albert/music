package com.example.tempconv;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextCelsius, editTextFahrenheit;
    Button celsiusToFahrenheitButton, fahrenheitToCelsiusButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextCelsius = findViewById(R.id.editTextCelsius);
        editTextFahrenheit = findViewById(R.id.editTextFahrenheit);
        celsiusToFahrenheitButton = findViewById(R.id.celsiusToFahrenheitButton);
        fahrenheitToCelsiusButton = findViewById(R.id.fahrenheitToCelsiusButton);
        resultTextView = findViewById(R.id.resultTextView);

        celsiusToFahrenheitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsiusText = editTextCelsius.getText().toString();
                if (!celsiusText.isEmpty()) {
                    double celsius = Double.parseDouble(celsiusText);
                    double fahrenheit = celsius * 9/5 + 32;
                    resultTextView.setText(celsius + "°C is " + fahrenheit + "°F");
                }
            }
        });

        fahrenheitToCelsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fahrenheitText = editTextFahrenheit.getText().toString();
                if (!fahrenheitText.isEmpty()) {
                    double fahrenheit = Double.parseDouble(fahrenheitText);
                    double celsius = (fahrenheit - 32) * 5/9;
                    resultTextView.setText(fahrenheit + "°F is " + celsius + "°C");
                }
            }
        });
    }
}
package com.example.mobileapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);
        Button buttonFetch = findViewById(R.id.buttonFetch);

        buttonFetch.setOnClickListener(v -> fetchData());
    }

    private void fetchData() {
        new Thread(() -> {
            ApiClient apiClient = new ApiClient();
            String response = apiClient.getDataFromApi();

            runOnUiThread(() -> {
                if (response != null) {
                    textViewResult.setText(response);
                } else {
                    Toast.makeText(MainActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            });
        }).start();
    }
}

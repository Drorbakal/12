// LoadingActivity.java
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loadingpage);

        // Delay the transition to the main activity for 1 second (1000 milliseconds)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the main activity
                Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Close the loading activity
            }
        }, 1000);
    }
}

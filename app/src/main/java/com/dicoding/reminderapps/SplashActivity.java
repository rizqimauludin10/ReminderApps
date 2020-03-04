package com.dicoding.reminderapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.dicoding.reminderapps.activity.LoginActivity;
import com.dicoding.reminderapps.activity.MainActivity;
import com.dicoding.reminderapps.utils.SharedPreferences;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        sharedPreferences = new SharedPreferences(this);

        new Handler().postDelayed(() -> {
            if (sharedPreferences.getSPSudahLogin().equals(true)){
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            } else {
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }

        }, 3000);
    }
}

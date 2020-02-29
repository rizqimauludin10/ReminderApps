package com.dicoding.reminderapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.dicoding.reminderapps.DietDM.DM1100PagiActivity;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        ImageView imageView = findViewById(R.id.nextSet);
        ImageView back = findViewById(R.id.backsetting);
        imageView.setOnClickListener(v -> {
            Intent intent = new Intent(this, Setting2Activity.class);
            startActivity(intent);
        });

        back.setOnClickListener(v -> {
        onBackPressed();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

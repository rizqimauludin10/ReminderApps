package com.dicoding.reminderapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.dicoding.reminderapps.DietDM.DM1100PagiActivity;
import com.dicoding.reminderapps.activity.InfoDM;

public class Infodm extends AppCompatActivity {
    LinearLayout infodm1, infodm2, infodm3, infodm4, infodm5, infodm6, infodm7, infodm8;
    ImageView infodmback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infodm);

        infodm1 = findViewById(R.id.infodm1);
        infodm2 = findViewById(R.id.infodm2);
        infodm3 = findViewById(R.id.infodm3);
        infodm4 = findViewById(R.id.infodm4);
        infodm5 = findViewById(R.id.infodm5);
        infodm6 = findViewById(R.id.infodm6);
        infodm7 = findViewById(R.id.infodm7);
        infodm8 = findViewById(R.id.infodm8);

        infodmback = findViewById(R.id.infodmback);

        infodmback.setOnClickListener(v -> {
            onBackPressed();
        });

        infodm1.setOnClickListener(v -> {
            Intent intent = new Intent(this, InfoDM.class);
            startActivity(intent);
        });

        infodm2.setOnClickListener(v -> {
            Intent intent = new Intent(this, Infodm1300Activity.class);
            startActivity(intent);
        });

        infodm3.setOnClickListener(v -> {
            Intent intent = new Intent(this, Infodm1500Activity.class);
            startActivity(intent);
        });

        infodm4.setOnClickListener(v -> {
            Intent intent = new Intent(this, Infodm1700Activity.class);
            startActivity(intent);
        });

        infodm5.setOnClickListener(v -> {
            Intent intent = new Intent(this, Infodm1900Activity.class);
            startActivity(intent);
        });

        infodm6.setOnClickListener(v -> {
            Intent intent = new Intent(this, Infodm2100Activity.class);
            startActivity(intent);
        });

        infodm7.setOnClickListener(v -> {
            Intent intent = new Intent(this, Infodm2300Activity.class);
            startActivity(intent);
        });

        infodm8.setOnClickListener(v -> {
            Intent intent = new Intent(this, Infodm2500Activity.class);
            startActivity(intent);
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

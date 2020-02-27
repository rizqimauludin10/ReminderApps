package com.dicoding.reminderapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.dicoding.reminderapps.DietDM.DM1100PagiActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        LinearLayout linearLayout1 = findViewById(R.id.dm1);
        linearLayout1.setOnClickListener(v -> {
            Intent intent = new Intent(this, DM1100PagiActivity.class);
            startActivity(intent);
        });
    }
}

package com.dicoding.reminderapps.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.dicoding.reminderapps.R;

public class InfoDM extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_dm);

        ImageView back = findViewById(R.id.dm1back);
        back.setOnClickListener(v -> {
            onBackPressed();
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

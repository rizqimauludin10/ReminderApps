package com.dicoding.reminderapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MateriActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        ImageView imageView = findViewById(R.id.backMain);

        imageView.setOnClickListener(v -> {
            onBackPressed();
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

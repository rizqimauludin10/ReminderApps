package com.dicoding.reminderapps;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.dicoding.reminderapps.DietDM.DM1100PagiActivity;
import com.dicoding.reminderapps.DietDM.DM1100SiangActivity;
import com.dicoding.reminderapps.DietDM.DM1100SoreActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Calendar now = Calendar.getInstance();

        int hour = now.get(Calendar.HOUR_OF_DAY); // Get hour in 24 hour format
        int minute = now.get(Calendar.MINUTE);

        Log.e("Day", "Jam : " + hour);
        Log.e("Day", "Menit : " + minute);



        LinearLayout linearLayout1 = findViewById(R.id.dm1);



        if (5 <= hour && 10 >= hour) {
            linearLayout1.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1100PagiActivity.class);
                startActivity(intent);
            });
        }
        if (10 <= hour && 16 >= hour) {
            linearLayout1.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1100SiangActivity.class);
                startActivity(intent);
            });
        }
        if (16 <= hour && 5 <= hour) {
            linearLayout1.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1100SoreActivity.class);
                startActivity(intent);
            });
        }

    }
}

package com.dicoding.reminderapps;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.dicoding.reminderapps.DietDM.DM1100PagiActivity;
import com.dicoding.reminderapps.DietDM.DM1100SiangActivity;
import com.dicoding.reminderapps.DietDM.DM1100SoreActivity;
import com.dicoding.reminderapps.DietDM.DM1300PagiActivity;
import com.dicoding.reminderapps.DietDM.DM1300SiangActivity;
import com.dicoding.reminderapps.DietDM.DM1300SoreActivity;
import com.dicoding.reminderapps.DietDM.DM1500PagiActivity;
import com.dicoding.reminderapps.DietDM.DM1500SiangActivity;
import com.dicoding.reminderapps.DietDM.DM1500SoreActivity;
import com.dicoding.reminderapps.DietDM.DM1700PagiActivity;
import com.dicoding.reminderapps.DietDM.DM1700SiangActivity;
import com.dicoding.reminderapps.DietDM.DM1700SoreActivity;
import com.dicoding.reminderapps.DietDM.DM1900PagiActivity;
import com.dicoding.reminderapps.DietDM.DM1900SiangActivity;
import com.dicoding.reminderapps.DietDM.DM1900SoreActivity;
import com.dicoding.reminderapps.DietDM.DM2100PagiActivity;
import com.dicoding.reminderapps.DietDM.DM2100SiangActivity;
import com.dicoding.reminderapps.DietDM.DM2100SoreActivity;
import com.dicoding.reminderapps.DietDM.DM2300PagiActivity;
import com.dicoding.reminderapps.DietDM.DM2300SiangActivity;
import com.dicoding.reminderapps.DietDM.DM2300SoreActivity;
import com.dicoding.reminderapps.DietDM.DM2500PagiActivity;
import com.dicoding.reminderapps.DietDM.DM2500SiangActivity;
import com.dicoding.reminderapps.DietDM.DM2500SoreActivity;

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


        ImageView backMain2 = findViewById(R.id.backMain2);

        backMain2.setOnClickListener(v -> {
            onBackPressed();
        });

        LinearLayout linearLayout1 = findViewById(R.id.dm1);
        LinearLayout linearLayout2 = findViewById(R.id.dm2);
        LinearLayout linearLayout3 = findViewById(R.id.dm3);
        LinearLayout linearLayout4 = findViewById(R.id.dm4);
        LinearLayout linearLayout5 = findViewById(R.id.dm5);
        LinearLayout linearLayout6 = findViewById(R.id.dm6);
        LinearLayout linearLayout7 = findViewById(R.id.dm7);
        LinearLayout linearLayout8 = findViewById(R.id.dm8);



        if (5 <= hour && 10 >= hour) {
            linearLayout1.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1100PagiActivity.class);
                startActivity(intent);
            });
            linearLayout2.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1300PagiActivity.class);
                startActivity(intent);
            });
            linearLayout3.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1500PagiActivity.class);
                startActivity(intent);
            });
            linearLayout4.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1700PagiActivity.class);
                startActivity(intent);
            });
            linearLayout5.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1900PagiActivity.class);
                startActivity(intent);
            });
            linearLayout6.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM2100PagiActivity.class);
                startActivity(intent);
            });
            linearLayout7.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM2300PagiActivity.class);
                startActivity(intent);
            });
            linearLayout8.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM2500PagiActivity.class);
                startActivity(intent);
            });
        }
        if (10 <= hour && 16 >= hour) {
            linearLayout1.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1100SiangActivity.class);
                startActivity(intent);
            });

            linearLayout2.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1300SiangActivity.class);
                startActivity(intent);
            });
            linearLayout3.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1500SiangActivity.class);
                startActivity(intent);
            });
            linearLayout4.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1700SiangActivity.class);
                startActivity(intent);
            });
            linearLayout5.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1900SiangActivity.class);
                startActivity(intent);
            });
            linearLayout6.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM2100SiangActivity.class);
                startActivity(intent);
            });
            linearLayout7.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM2300SiangActivity.class);
                startActivity(intent);
            });
            linearLayout8.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM2500SiangActivity.class);
                startActivity(intent);
            });
        }
        if (16 <= hour && 5 <= hour) {
            linearLayout1.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1100SoreActivity.class);
                startActivity(intent);
            });

            linearLayout2.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1300SoreActivity.class);
                startActivity(intent);
            });
            linearLayout3.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1500SoreActivity.class);
                startActivity(intent);
            });
            linearLayout4.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1700SoreActivity.class);
                startActivity(intent);
            });
            linearLayout5.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM1900SoreActivity.class);
                startActivity(intent);
            });
            linearLayout6.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM2100SoreActivity.class);
                startActivity(intent);
            });
            linearLayout7.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM2300SoreActivity.class);
                startActivity(intent);
            });
            linearLayout8.setOnClickListener(v -> {
                Intent intent = new Intent(this, DM2500SoreActivity.class);
                startActivity(intent);
            });
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

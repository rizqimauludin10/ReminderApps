package com.dicoding.reminderapps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.judemanutd.autostarter.AutoStartPermissionHelper;

public class Setting2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting2);

        AutoStartPermissionHelper.getInstance().getAutoStartPermission(this);
    }
}

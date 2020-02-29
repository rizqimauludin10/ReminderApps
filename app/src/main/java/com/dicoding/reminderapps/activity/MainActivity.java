package com.dicoding.reminderapps.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.dicoding.reminderapps.apihelper.BaseAPIService;
import com.dicoding.reminderapps.apihelper.UtilsAPI;
import com.dicoding.reminderapps.utils.BroadcastReminder;
import com.dicoding.reminderapps.fragment.AddFragment;
import com.dicoding.reminderapps.fragment.BerandaFragment;
import com.dicoding.reminderapps.fragment.ProfilFragment;
import com.dicoding.reminderapps.R;
import com.dicoding.reminderapps.utils.BroadcastReminder2;
import com.dicoding.reminderapps.utils.BroadcastReminder3;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BroadcastReminder broadcastReminder;
    BroadcastReminder2 broadcastReminder2;
    BroadcastReminder3 broadcastReminder3;
    private Fragment fragment1 = new BerandaFragment();
    final Fragment fragment2 = new AddFragment();
    final Fragment fragment3 = new ProfilFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;

    private BaseAPIService baseAPIService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //baseAPIService = UtilsAPI.getApiService();

        broadcastReminder = new BroadcastReminder();
        broadcastReminder2 = new BroadcastReminder2();
        broadcastReminder3 = new BroadcastReminder3();
        broadcastReminder.setRepeatingAlarm(this);
        broadcastReminder2.setRepeatingAlarmm(this);
        broadcastReminder3.setRepeatingAlarmm(this);

       /* Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);*/


        BottomNavigationView bottomNavigationView = findViewById(R.id.btmNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        fm.beginTransaction().add(R.id.mainacv, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.mainacv, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.mainacv, fragment1, "1").commit();




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.home_menu:
                fm.beginTransaction().hide(active).show(fragment1).commit();
                active = fragment1;
                return true;
            case R.id.tambah_menu:
                fm.beginTransaction().hide(active).show(fragment2).commit();
                active = fragment2;
                return true;
            case R.id.profil_menu:
                fm.beginTransaction().hide(active).show(fragment3).commit();
                active = fragment3;
                return true;
        }
        return false;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

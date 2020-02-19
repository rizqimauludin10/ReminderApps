package com.dicoding.reminderapps.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.dicoding.reminderapps.BroadcastReminder;
import com.dicoding.reminderapps.fragment.AddFragment;
import com.dicoding.reminderapps.fragment.BerandaFragment;
import com.dicoding.reminderapps.fragment.ProfilFragment;
import com.dicoding.reminderapps.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BroadcastReminder broadcastReminder;
    private Fragment fragment1 = new BerandaFragment();
    final Fragment fragment2 = new AddFragment();
    final Fragment fragment3 = new ProfilFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        broadcastReminder = new BroadcastReminder();
        broadcastReminder.setRepeatingAlarm(this);

       /* Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);*/


        BottomNavigationView bottomNavigationView = findViewById(R.id.btmNav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        fm.beginTransaction().add(R.id.mainacv, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.mainacv, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.mainacv, fragment1, "1").commit();


        //AutoStartPermissionHelper.getInstance().getAutoStartPermission(this);

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

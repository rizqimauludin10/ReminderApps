package com.dicoding.reminderapps.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.dicoding.reminderapps.SettingActivity;
import com.dicoding.reminderapps.SplashActivity;
import com.dicoding.reminderapps.activity.ProfilActivity;
import com.dicoding.reminderapps.R;
import com.dicoding.reminderapps.utils.SharedPreferences;

import java.util.Objects;

public class ProfilFragment extends Fragment {

    private Toolbar toolbarMv;
    private RelativeLayout pribadi, setting, keluar;
    SharedPreferences sharedPreferences;
    private TextView profilName, profilEmail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sharedPreferences = new SharedPreferences(Objects.requireNonNull(getContext()));
        toolbarMv = view.findViewById(R.id.toolbarr);
        pribadi = view.findViewById(R.id.toPribadi);
        setting = view.findViewById(R.id.toSetting);
        keluar = view.findViewById(R.id.keluar);
        profilEmail = view.findViewById(R.id.myProfilName);
        profilName = view.findViewById(R.id.myEmail);
        //setToolbarTitle("Profile");

        profilEmail.setText(sharedPreferences.getSp_Email());
        profilName.setText(sharedPreferences.getSp_Name());

        pribadi.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), ProfilActivity.class);
            startActivity(intent);
        });

        setting.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), SettingActivity.class);
            startActivity(intent);
        });

        keluar.setOnClickListener(v -> {
            sharedPreferences.saveSPBoolean(SharedPreferences.SP_SudahLogin, false);
            sharedPreferences.remove("guladarah");
            sharedPreferences.remove("guladarah2");
            sharedPreferences.remove("usia");
            sharedPreferences.remove("spPhone");
            sharedPreferences.remove("kelamin");
            sharedPreferences.remove("lamadm");
            sharedPreferences.remove("tinggi");
            sharedPreferences.remove("berat");

            startActivity(new Intent(getContext(), SplashActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        });

    }
}

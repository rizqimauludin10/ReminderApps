package com.dicoding.reminderapps.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

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
        //setToolbarTitle("Profile");

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
            startActivity(new Intent(getContext(), SplashActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        });

    }

    /*private void setToolbarTitle(String title) {
        toolbarMv.setTitle(title);
        toolbarMv.setTitleTextColor((ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.text)));
        ((MainActivity) getActivity()).setSupportActionBar(toolbarMv);
    }*/
}

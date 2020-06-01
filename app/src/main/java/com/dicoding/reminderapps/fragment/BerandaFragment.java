package com.dicoding.reminderapps.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dicoding.reminderapps.Infodm;
import com.dicoding.reminderapps.Materi2Activity;
import com.dicoding.reminderapps.Materi3Activity;
import com.dicoding.reminderapps.Materi4Activity;
import com.dicoding.reminderapps.MateriActivity;
import com.dicoding.reminderapps.R;
import com.dicoding.reminderapps.utils.SharedPreferences;

import java.util.Objects;

public class BerandaFragment extends Fragment {
    SharedPreferences sharedPreferences;
    TextView mainName, dietDM;
    String id;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_beranda, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPreferences = new SharedPreferences(Objects.requireNonNull(getContext()));
        ImageView wa = view.findViewById(R.id.wa);
        LinearLayout info1 = view.findViewById(R.id.info1);
        LinearLayout info2 = view.findViewById(R.id.info2);
        LinearLayout info3 = view.findViewById(R.id.info3);
        LinearLayout info4 = view.findViewById(R.id.info4);
        LinearLayout info5 = view.findViewById(R.id.info5);
        mainName = view.findViewById(R.id.mainName);
        dietDM = view.findViewById(R.id.myDm);

        mainName.setText(sharedPreferences.getSp_Name());

        dietDM.setText(String.valueOf(sharedPreferences.getSP_DietDM()));
        id = sharedPreferences.getSP_UserId();
        Log.e("debug", "Shared Preference UserId> " + id);
        info1.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MateriActivity.class);
            startActivity(intent);
        });

        info2.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Materi2Activity.class);
            startActivity(intent);
        });

        info3.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Materi3Activity.class);
            startActivity(intent);
        });

        info4.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Materi4Activity.class);
            startActivity(intent);
        });

        info5.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), Infodm.class);
            startActivity(intent);
        });

        wa.setOnClickListener(v -> {
            String phone = "6289629455243";
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://api.whatsapp.com/send?phone=" + phone + "&text=Saya%20perlu%20bantuan%20Admin%20Sipen%20Diabetes"));
            startActivity(intent);
        });
    }


}

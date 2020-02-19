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

import com.dicoding.reminderapps.activity.ProfilActivity;
import com.dicoding.reminderapps.R;

public class ProfilFragment extends Fragment {

    private Toolbar toolbarMv;
    private RelativeLayout pribadi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profil, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbarMv = view.findViewById(R.id.toolbarr);
        pribadi = view.findViewById(R.id.toPribadi);
        //setToolbarTitle("Profile");

        pribadi.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), ProfilActivity.class);
            startActivity(intent);
        });

    }

    /*private void setToolbarTitle(String title) {
        toolbarMv.setTitle(title);
        toolbarMv.setTitleTextColor((ContextCompat.getColor(Objects.requireNonNull(getActivity()), R.color.text)));
        ((MainActivity) getActivity()).setSupportActionBar(toolbarMv);
    }*/
}

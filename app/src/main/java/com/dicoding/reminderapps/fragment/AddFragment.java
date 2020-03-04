package com.dicoding.reminderapps.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dicoding.reminderapps.R;
import com.dicoding.reminderapps.apihelper.BaseAPIService;
import com.dicoding.reminderapps.apihelper.UtilsAPI;
import com.dicoding.reminderapps.model.LoginResponse;
import com.dicoding.reminderapps.utils.SharedPreferences;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddFragment extends Fragment {
    EditText minggu1, minggu2;
    Button simpan, update;
    SharedPreferences sharedPreferences;
    String idUser;
    String q = "add_diet";
    BaseAPIService baseAPIService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sharedPreferences = new SharedPreferences(Objects.requireNonNull(getContext()));
        baseAPIService = UtilsAPI.getApiService();

        idUser = sharedPreferences.getSP_UserId();

        minggu1 = view.findViewById(R.id.gd1);
        minggu2 = view.findViewById(R.id.gd2);
        simpan = view.findViewById(R.id.diet_button);
        update = view.findViewById(R.id.update_button);

        if (!sharedPreferences.getSp_Minggu1().equals("")) {
            minggu1.setText(sharedPreferences.getSp_Minggu1());
        }


        simpan.setOnClickListener(v -> {
            simpan();
        });
    }

    private void simpan() {
        baseAPIService.add_diet(
                q,
                String.valueOf(idUser),
                minggu1.getText().toString()
        )
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.body().getError().equals("false")) {
                            String m1 = minggu1.getText().toString();
                            sharedPreferences.saveSPString(SharedPreferences.SP_UserId, m1);

                        } else if (response.body().getError().equals("true")) {

                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });

    }


}

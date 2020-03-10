package com.dicoding.reminderapps.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dicoding.reminderapps.R;
import com.dicoding.reminderapps.activity.LoginActivity;
import com.dicoding.reminderapps.apihelper.BaseAPIService;
import com.dicoding.reminderapps.apihelper.UtilsAPI;
import com.dicoding.reminderapps.model.DietResponse;
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
    String idUser, idDiet;
    String minggu2SP;
    String q = "add_diet";
    String w = "update_diet";

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
        idDiet = sharedPreferences.getSP_DietId();

        minggu1 = view.findViewById(R.id.gd1);
        minggu2 = view.findViewById(R.id.gd2);
        simpan = view.findViewById(R.id.diet_button);
        update = view.findViewById(R.id.update_button);


        if (!sharedPreferences.getSp_Minggu1().equals("")) {
            minggu1.setText(sharedPreferences.getSp_Minggu1());
            minggu2.setText(sharedPreferences.getSp_Minggu2());
        }

        simpan.setOnClickListener(v -> {
            simpan();
        });

        update.setOnClickListener(v -> {
            updateDiet();
        });
    }

    private void simpan() {
        baseAPIService.add_diet(
                q,
                String.valueOf(idUser),
                minggu1.getText().toString()
        )
                .enqueue(new Callback<DietResponse>() {
                    @Override
                    public void onResponse(Call<DietResponse> call, Response<DietResponse> response) {
                        if (response.body().getError().equals("false")) {
                            String m1 = minggu1.getText().toString();
                            idDiet = String.valueOf(response.body().getIdDiet());
                            sharedPreferences.saveSPString(SharedPreferences.SP_MINGGU1, m1);
                            sharedPreferences.saveSPString(SharedPreferences.SP_DietId, idDiet);

                            Toast.makeText(getActivity(), "Berhasil Update Data Diet Minggu Pertama", Toast.LENGTH_SHORT).show();
                            Log.e("IdDiet" , "IdDiet" + idDiet);

                        } else if (response.body().getError().equals("true")) {
                            Toast.makeText(getActivity(), "Gagal Update Data Diet Minggu Pertama", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<DietResponse> call, Throwable t) {

                    }
                });

    }

    private void updateDiet(){
        baseAPIService.update_diet(
                w,
                idDiet,
                minggu2.getText().toString()

        ) .enqueue(new Callback<DietResponse>() {
            @Override
            public void onResponse(Call<DietResponse> call, Response<DietResponse> response) {
                if (response.body().getError().equals("false")) {
                    String m2 = minggu2.getText().toString();
                    sharedPreferences.saveSPString(SharedPreferences.SP_MINGGU2, m2);
                    Toast.makeText(getActivity(), "Berhasil Update Data Diet Minggu Terakhir " + m2, Toast.LENGTH_SHORT).show();

                } else if (response.body().getError().equals("true")) {
                    Toast.makeText(getActivity(), "Gagal Update Data Diet Minggu Terakhir", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DietResponse> call, Throwable t) {

            }
        });
    }


}

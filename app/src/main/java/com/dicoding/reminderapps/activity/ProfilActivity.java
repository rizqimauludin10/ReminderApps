package com.dicoding.reminderapps.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.dicoding.reminderapps.R;
import com.dicoding.reminderapps.apihelper.BaseAPIService;
import com.dicoding.reminderapps.apihelper.UtilsAPI;
import com.dicoding.reminderapps.model.Login;
import com.dicoding.reminderapps.model.LoginResponse;
import com.dicoding.reminderapps.utils.SharedPreferences;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilActivity extends AppCompatActivity {

    int rumus;
    int hasil;
    String rgjkjk = "0";
    String jnsKelamin;

    private String[] aktivitass = {
            "Sangat Ringan",
            "Ringan",
            "Sedang",
            "Berat"
    };

    private String[] pendidikann = {
            "Tidak Sekolah",
            "SD",
            "SMP",
            "SMA",
            "Perguruan Tinggi"
    };
    private String[] statuss = {
            "Belum Menikah",
            "Menikah"
    };

    private String[] pekerjaann = {
            "Tidak Bekerja",
            "PNS/Pensiunan",
            "Swasta",
            "Petani",
            "Buruh",
            "Rumah Tangga"

    };


    double aktivitasVal;
    SharedPreferences sharedPreferences;
    String idUser;
    String usiaStr;
    String namaStr, emailStr, noHpStr;
    String q = "update_profil";
    BaseAPIService baseAPIService;
    EditText no_hp, lamaDm, usia, tinggi, berat;
    Spinner pendidikan, status, aktivitas, pekerjaan;
    String pendidikanTampung, statusTampung, pekerjaanTampung, aktivitasTampung;
    Login loginResponse;
    RadioGroup jk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        sharedPreferences = new SharedPreferences(this.getApplicationContext());
        baseAPIService = UtilsAPI.getApiService();

        idUser = sharedPreferences.getSP_UserId();
        EditText nama = findViewById(R.id.nama_user);
        EditText email = findViewById(R.id.email_user);


        nama.setText(sharedPreferences.getSp_Name());
        email.setText(sharedPreferences.getSp_Email());

        namaStr = nama.getText().toString();
        emailStr = email.getText().toString();




        jk = findViewById(R.id.rg_jk);
        RadioButton lk = findViewById(R.id.lk);
        RadioButton pr = findViewById(R.id.pr);
        tinggi = findViewById(R.id.tinggi);
        berat = findViewById(R.id.berat);
        usia = findViewById(R.id.usia);
        lamaDm = findViewById(R.id.lamadm);
        no_hp = findViewById(R.id.no_hp);
        pendidikan = findViewById(R.id.pendidikan);
        status = findViewById(R.id.status);
        pekerjaan = findViewById(R.id.pekerjaan);

        Button simpan = findViewById(R.id.profile_button);
        aktivitas = findViewById(R.id.aktivitas);

        if (!sharedPreferences.getSP_Phone().equals("")) {
           no_hp.setText(sharedPreferences.getSP_Phone());
           usia.setText(sharedPreferences.getSP_Usia());
           lamaDm.setText(sharedPreferences.getSP_Lamadm());
           tinggi.setText(sharedPreferences.getSP_Tinggi());
           berat.setText(sharedPreferences.getSP_Berat());
           if (sharedPreferences.getSP_Kelamin().equals(1)){
               jk.setOnCheckedChangeListener((group, checkedId) -> {
                   lk.isChecked();
               });
           } else if (sharedPreferences.getSP_Kelamin().equals(0)){
               jk.setOnCheckedChangeListener((group, checkedId) -> {
                   pr.isChecked();
               });
           }
        }



        noHpStr = no_hp.getText().toString();

        ImageView back = findViewById(R.id.backProfile);
        back.setOnClickListener(v -> {
            onBackPressed();
        });


        jk.setOnCheckedChangeListener((group, checkedId) -> {
            if (lk.isChecked()) {
                rgjkjk = "1";
                jnsKelamin = "Laki-laki";
                sharedPreferences.saveSPString(SharedPreferences.SP_KELAMIN, rgjkjk);
            } else if (pr.isChecked()) {
                rgjkjk = "0";
                jnsKelamin = "Perempuan";
                sharedPreferences.saveSPString(SharedPreferences.SP_KELAMIN, rgjkjk);
            }
        });


        ArrayAdapter<String> pekerjaanarrayAdapter = new ArrayAdapter<>(this, R.layout.spinerlist, pekerjaann);
        pekerjaan.setAdapter(pekerjaanarrayAdapter);

        ArrayAdapter<String> pendidikanarrayAdapter = new ArrayAdapter<>(this, R.layout.spinerlist, pendidikann);
        pendidikan.setAdapter(pendidikanarrayAdapter);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.spinerlist, aktivitass);
        aktivitas.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(this, R.layout.spinerlist, statuss);
        status.setAdapter(arrayAdapter1);

        pekerjaan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        pekerjaanTampung = "Tidak Bekerja";
                        break;
                    case 1:
                        pekerjaanTampung = "PNS/Pensiunan";
                        break;
                    case 2:
                        pekerjaanTampung = "Swasta";
                        break;
                    case 3:
                        pekerjaanTampung = "Petani";
                        break;
                    case 4:
                        pekerjaanTampung = "Buruh";
                        break;
                    case 5:
                        pekerjaanTampung = "Rumah Tangga";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        statusTampung = "Belum Menikah";
                        break;
                    case 1:
                        statusTampung = "Menikah";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        pendidikan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        pendidikanTampung = "Tidak Sekolah";
                        break;
                    case 1:
                        pendidikanTampung = "SD";
                        break;
                    case 2:
                        pendidikanTampung = "SMP";
                        break;
                    case 3:
                        pendidikanTampung = "SMA";
                        break;
                    case 4:
                        pendidikanTampung = "Perguruan Tinggi";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        aktivitas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (rgjkjk.equals("1")) {
                    switch (position) {
                        case 0:
                            aktivitasVal = (1.30);
                            aktivitasTampung = "Sangat Ringan";
                            break;
                        case 1:
                            aktivitasVal = (1.65);
                            aktivitasTampung = "Ringan";
                            break;
                        case 2:
                            aktivitasVal = (1.78);
                            aktivitasTampung = "Sedang";
                            break;
                        case 3:
                            aktivitasVal = (2.10);
                            aktivitasTampung = "Berat";
                            break;
                    }

                } else {
                    switch (position) {
                        case 0:
                            aktivitasVal = (1.30);
                            aktivitasTampung = "Sangat Ringan";
                            break;
                        case 1:
                            aktivitasVal = (1.56);
                            aktivitasTampung = "Ringan";
                            break;
                        case 2:
                            aktivitasVal = (1.64);
                            aktivitasTampung = "Sedang";
                            break;
                        case 3:
                            aktivitasVal = (2.00);
                            aktivitasTampung = "Berat";
                            break;
                    }
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        simpan.setOnClickListener(v -> {
            if (rgjkjk.equals("1")) {
                String tinggii = tinggi.getText().toString();
                int tinggiVal = Integer.parseInt(tinggii);
                String beratt = berat.getText().toString();
                int beratVal = Integer.parseInt(beratt);
                String usiaa = usia.getText().toString();
                int usiaVal = Integer.parseInt(usiaa);


                int sum1 = (int) (13.7 * beratVal);
                int sum2 = (5 * tinggiVal);
                int sum3 = (int) (6.8 * usiaVal);

                rumus = (66 + sum1) + (sum2 - sum3);
                hasil = (int) (rumus * aktivitasVal);
                Log.e("RUMUS", "Laki-laki" + hasil);
                sharedPreferences.saveSPInt(SharedPreferences.SP_DietDM, hasil);
                update_profil();
            } else {
                String tinggii = tinggi.getText().toString();
                int tinggiVal = Integer.parseInt(tinggii);
                String beratt = berat.getText().toString();
                int beratVal = Integer.parseInt(beratt);
                String usiaa = usia.getText().toString();
                int usiaVal = Integer.parseInt(usiaa);


                int sum4 = (int) (9.6 * beratVal);
                int sum5 = (int) (1.8 * tinggiVal);
                int sum6 = (int) (4.7 * usiaVal);
                rumus = (655 + sum4) + (sum5 - sum6);
                hasil = (int) (rumus * aktivitasVal);
                Log.e("RUMUS", "Perempuan" + hasil);
                sharedPreferences.saveSPInt(SharedPreferences.SP_DietDM, hasil);
                update_profil();
            }
        });

    }

    private void update_profil() {

        sharedPreferences.saveSPString(SharedPreferences.SP_Phone, no_hp.getText().toString());
        sharedPreferences.saveSPString(SharedPreferences.SP_USIA, usia.getText().toString());
        sharedPreferences.saveSPString(SharedPreferences.SP_LAMADM, lamaDm.getText().toString());
        sharedPreferences.saveSPString(SharedPreferences.SP_TINGGI, tinggi.getText().toString());
        sharedPreferences.saveSPString(SharedPreferences.SP_BERAT, berat.getText().toString());
        Log.d("Phone" , "Phone => " + sharedPreferences.getSP_Phone());

        baseAPIService.update_profil(
                q,
                String.valueOf(idUser),
                namaStr,
                emailStr,
                no_hp.getText().toString(),
                jnsKelamin,
                usia.getText().toString(),
                pendidikanTampung,
                statusTampung,
                pekerjaanTampung,
                lamaDm.getText().toString(),
                tinggi.getText().toString(),
                berat.getText().toString(),
                aktivitasTampung
        )
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.body().getError().equals("false")){

                            assert response.body() != null;
                            loginResponse = response.body().getData();
                            //Integer DietDMNilai = sharedPreferences.getSP_DietDM();



                            Toast.makeText(ProfilActivity.this, "Berhasil Mengupdate Data", Toast.LENGTH_SHORT).show();

                        } else if (response.body().getError().equals("true")){
                            String error = response.body().getMsg();
                            Toast.makeText(ProfilActivity.this, error, Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                    }
                });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

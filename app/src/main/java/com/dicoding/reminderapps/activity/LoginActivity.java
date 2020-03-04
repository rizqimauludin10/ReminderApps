package com.dicoding.reminderapps.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.dicoding.reminderapps.R;
import com.dicoding.reminderapps.apihelper.BaseAPIService;
import com.dicoding.reminderapps.apihelper.UtilsAPI;
import com.dicoding.reminderapps.model.Login;
import com.dicoding.reminderapps.model.LoginResponse;
import com.dicoding.reminderapps.utils.SharedPreferences;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity {

    private Button loginButon, registerButton, btn1, btn2;
    private ImageView closeLogin, closeRegister;
    public static final String TAG = "bottom_sheet";
    private EditText username, password;
    private EditText username_register, email_register, password_register, nohp_register;
    BaseAPIService baseAPIService;
    String q = "login";
    String a = "register";
    Login loginResponse;
    SharedPreferences sharedPreferences;
    BottomSheetDialog bottomSheetDialog;
    View bottSheetView;
    View bottomSheetView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = new SharedPreferences(this);
        baseAPIService = UtilsAPI.getApiService();

        bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.bottom_sheet,
                        findViewById(R.id.bottomsheet_login)
                );

        bottSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(R.layout.bottom_sheet_register, findViewById(R.id.bottomsheet_register));

        loginButon = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.register_button);
        username = bottomSheetView.findViewById(R.id.username_login);
        password = bottomSheetView.findViewById(R.id.password_login);
        closeLogin = bottomSheetView.findViewById(R.id.closeLogin);
        btn1 = bottomSheetView.findViewById(R.id.btn1);

        username_register = bottSheetView.findViewById(R.id.username_register);
        email_register = bottSheetView.findViewById(R.id.email_register);
        password_register = bottSheetView.findViewById(R.id.password_register);
        nohp_register = bottSheetView.findViewById(R.id.nohp_register);
        closeRegister = bottSheetView.findViewById(R.id.closeRegister);
        btn2 = bottSheetView.findViewById(R.id.btn2);

       bottomSheetDialog = new BottomSheetDialog(
                LoginActivity.this, R.style.BottomSheetDialogTheme
        );

        loginButon.setOnClickListener(v -> {

            closeLogin.setOnClickListener(v1 -> {
                bottomSheetDialog.dismiss();
            });

            btn1.setOnClickListener(v1 -> {
               login();
            });
            bottomSheetDialog.setCanceledOnTouchOutside(false);
            bottomSheetDialog.setContentView(bottomSheetView);
            bottomSheetDialog.show();

        });

        /*-------------Register-------------*/

        registerButton.setOnClickListener(v -> {

           btn2.setOnClickListener(v1 -> {
                register();
            });

            closeRegister.setOnClickListener(v1 -> {
                bottomSheetDialog.dismiss();
            });

            bottomSheetDialog.setCanceledOnTouchOutside(false);
            bottomSheetDialog.setContentView(bottSheetView);
            bottomSheetDialog.show();
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    private void dialogClick(){

    }

    private void login(){
        baseAPIService.login(
                q,
                username.getText().toString(),
                password.getText().toString()
        )
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<LoginResponse> call, @NonNull Response<LoginResponse> response) {
                        if (response.isSuccessful()){
                            if (response.body().getError().equals("false")){

                                assert response.body() != null;
                                loginResponse = response.body().getData();

                                String id = loginResponse.getIdUser();
                                String email = loginResponse.getEmail();
                                String name = loginResponse.getName();

                                sharedPreferences.saveSPString(SharedPreferences.SP_UserId, id);
                                sharedPreferences.saveSPString(SharedPreferences.SP_Email, email);
                                sharedPreferences.saveSPString(SharedPreferences.SP_Name, name);
                                Log.d("Username", "Username" + loginResponse.getName());
                                Log.d("Email", "Email" + loginResponse.getEmail());


                                sharedPreferences.saveSPBoolean(SharedPreferences.SP_SudahLogin, true);

                                Intent intent = new Intent(LoginActivity.this, MainActivity.class)
                                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                                finish();
                                startActivity(intent);
                            } else if (response.body().getError().equals("true")){
                                String error = response.body().getMsg();
                                Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();

                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.e("Login", "OnFailure: ERROR > " + t.toString());
                    }
                });
    }

    private void register(){
        baseAPIService.register(
                a,
                username_register.getText().toString(),
                email_register.getText().toString(),
                password_register.getText().toString(),
                nohp_register.getText().toString()
        )
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()){
                            if (response.body().getError().equals("false")){
                                Toast.makeText(LoginActivity.this, "Register Sukses", Toast.LENGTH_SHORT).show();
                                bottomSheetDialog.dismiss();
                                Log.d("Register", "Username");
                            } else if (response.body().getError().equals("true")){
                                Toast.makeText(LoginActivity.this, "Register Gagal", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.e("Register", "OnFailure: ERROR > " + t.toString());
                    }
                });

    }
}

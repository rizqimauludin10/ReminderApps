package com.dicoding.reminderapps.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.dicoding.reminderapps.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity {

    private Button loginButon, registerButton;
    public static final String TAG = "bottom_sheet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        loginButon = findViewById(R.id.login_button);
        registerButton = findViewById(R.id.register_button);

        loginButon.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                    LoginActivity.this, R.style.BottomSheetDialogTheme
            );

            View bottomSheetView = LayoutInflater.from(getApplicationContext())
                    .inflate(R.layout.bottom_sheet,
                            findViewById(R.id.bottomsheet_login)
                    );
            bottomSheetView.findViewById(R.id.closeLogin).setOnClickListener(v1 -> {
                bottomSheetDialog.dismiss();
            });

            bottomSheetView.findViewById(R.id.btn1).setOnClickListener(v1 -> {
                /*Toast.makeText(LoginActivity.this, "Tekan", Toast.LENGTH_SHORT).show();*/

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            });
            bottomSheetDialog.setCanceledOnTouchOutside(false);
            bottomSheetDialog.setContentView(bottomSheetView);
            bottomSheetDialog.show();

        });

        /*-------------Register-------------*/

        registerButton.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                    LoginActivity.this, R.style.BottomSheetDialogTheme
            );

            View bottSheetView = LayoutInflater.from(getApplicationContext())
                    .inflate(R.layout.bottom_sheet_register, findViewById(R.id.bottomsheet_register));

            bottSheetView.findViewById(R.id.closeRegister).setOnClickListener(v1 -> {
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
}

package com.dicoding.reminderapps.utils;


import android.content.Context;

public class SharedPreferences {

    public static final String SP_Reminder = "spNyuciin";

    public static final String SP_Name = "spName";
    public static final String SP_Email = "spEmail";
    public static final String SP_Phone = "spPhone";
    public static final String SP_UserId = "user";
    public static final String SP_DietDM = "diet";
    public static final String SP_MINGGU1 = "guladarah";
    public static final String SP_MINGGU2 = "guladarah2";

    public static final String SP_SudahLogin = "spSudahLogin";

   android.content.SharedPreferences sharedPreferences;
    android.content.SharedPreferences.Editor spEditor;

    public SharedPreferences(Context context) {
        sharedPreferences = context.getSharedPreferences(SP_Reminder, Context.MODE_PRIVATE);
        spEditor = sharedPreferences.edit();
    }


    public void saveSPString(String keySp, String value) {
        spEditor.putString(keySp, value);
        spEditor.commit();
    }

    public void saveSPInt(String keySp, int value) {
        spEditor.putInt(keySp, value);
        spEditor.commit();
    }

    public void saveSPIntUser(String keySp, int value) {
        spEditor.putInt(keySp, value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySp, boolean value) {
        spEditor.putBoolean(keySp, value);
        spEditor.commit();
    }



    public String getSP_Phone() {
        return sharedPreferences.getString(SP_Phone, "");
    }

    public String getSp_Email() {
        return sharedPreferences.getString(SP_Email, "");
    }

    public String getSp_Name() {
        return sharedPreferences.getString(SP_Name, "");
    }

    public String getSp_Minggu1() {
        return sharedPreferences.getString(SP_MINGGU1, "");
    }

    public String getSp_Minggu2() {
        return sharedPreferences.getString(SP_MINGGU2, "");
    }

    public String getSP_UserId() {
        return sharedPreferences.getString((SP_UserId), "");
    }

    public Integer getSP_DietDM() {
        return sharedPreferences.getInt(SP_DietDM, 0);
    }

    public Boolean getSPSudahLogin() {
        return sharedPreferences.getBoolean(SP_SudahLogin, false);
    }
}

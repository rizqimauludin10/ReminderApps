package com.dicoding.reminderapps.apihelper;

import com.dicoding.reminderapps.model.DietResponse;
import com.dicoding.reminderapps.model.Login;
import com.dicoding.reminderapps.model.LoginResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface BaseAPIService {

    @FormUrlEncoded
    @POST("reminder_api.php")
    Call<LoginResponse> login (
            @Field("q") String q,
            @Field("email") String email,
            @Field("password") String password
            );

    @FormUrlEncoded
    @POST("reminder_api.php")
    Call<LoginResponse> register (
      @Field("q") String q,
      @Field("name") String name,
      @Field("email") String email,
      @Field("password") String password,
      @Field("no_hp") String no_hp
    );

    @FormUrlEncoded
    @POST("reminder_api.php")
    Call<LoginResponse> update_profil(
            @Field("q") String q,
            @Field("id_user") String id_user,
            @Field("name") String name,
            @Field("email") String email,
            @Field("no_hp") String no_hp,
            @Field("jk") String jk,
            @Field("usia") String usia,
            @Field("pendidikan") String pendidikan,
            @Field("status") String status,
            @Field("pekerjaan") String pekerjaan,
            @Field("lamadm") String lamadm,
            @Field("tinggi") String tinggi,
            @Field("berat") String berat,
            @Field("aktivitas") String aktivitas
    );

    @FormUrlEncoded
    @POST("reminder_api.php")
    Call<DietResponse> add_diet(
            @Field("q") String q,
            @Field("id_user") String id_user,
            @Field("minggu1") String minggu1
    );

    @FormUrlEncoded
    @POST("reminder_api.php")
    Call<DietResponse> update_diet(
            @Field("q") String q,
            @Field("id_diet") String id_diet,
            @Field("minggu2") String minggu2
    );


}

package com.dicoding.reminderapps.apihelper;


public class UtilsAPI {

    private static final String BASE_URL_API = "";

    public static BaseAPIService getApiService() {
        return RetrofitClient.getRetrofit(BASE_URL_API).create(BaseAPIService.class);
    }
}

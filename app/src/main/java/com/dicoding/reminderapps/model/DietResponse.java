package com.dicoding.reminderapps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DietResponse {

    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("id_diet")
    @Expose
    private Integer idDiet;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getIdDiet() {
        return idDiet;
    }

    public void setIdDiet(Integer idDiet) {
        this.idDiet = idDiet;
    }
}

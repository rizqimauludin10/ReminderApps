package com.dicoding.reminderapps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataDiet {
    @SerializedName("id_diet")
    @Expose
    private String idDiet;
    @SerializedName("minggu1")
    @Expose
    private String minggu1;
    @SerializedName("minggu2")
    @Expose
    private Object minggu2;

    public String getIdDiet() {
        return idDiet;
    }

    public void setIdDiet(String idDiet) {
        this.idDiet = idDiet;
    }

    public String getMinggu1() {
        return minggu1;
    }

    public void setMinggu1(String minggu1) {
        this.minggu1 = minggu1;
    }

    public Object getMinggu2() {
        return minggu2;
    }

    public void setMinggu2(Object minggu2) {
        this.minggu2 = minggu2;
    }
}

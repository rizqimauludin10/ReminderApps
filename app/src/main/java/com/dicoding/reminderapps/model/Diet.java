package com.dicoding.reminderapps.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Diet {
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("dataDiet")
    @Expose
    private List<DataDiet> dataDiet = null;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<DataDiet> getDataDiet() {
        return dataDiet;
    }

    public void setDataDiet(List<DataDiet> dataDiet) {
        this.dataDiet = dataDiet;
    }
}

package com.example.pavan.kmtabalavidyalaya.Models;

/**
 * Created by kai on 21/4/16.
 */
import com.google.gson.annotations.SerializedName;

public class GuruModel extends BaseModel {






    private String title;

    public GuruModel(String title){
        this.title = title;

    }




    public String getTitle() {
        return title;
    }




}

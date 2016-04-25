package com.example.pavan.kmtabalavidyalaya.Models;

/**
 * Created by kai on 21/4/16.
 */
import com.google.gson.annotations.SerializedName;

public class GuruModel extends BaseModel {




    private String desc;
    private int imageId;
    private String title;


    public GuruModel(String title, int imageId, String desc){
        this.title = title;
        this.imageId = imageId;
        this.desc = desc;
    }

    public String getDesc(){return desc;}
    public int getImage(){
        return imageId;
    }

    public String getTitle() {
        return title;
    }




}

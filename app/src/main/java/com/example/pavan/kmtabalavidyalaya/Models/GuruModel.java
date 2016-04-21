package com.example.pavan.kmtabalavidyalaya.Models;

/**
 * Created by kai on 21/4/16.
 */
import com.google.gson.annotations.SerializedName;

public class GuruModel extends BaseModel {




    private String overview;


    private String release_date;


    private String title;



    public String getOverview() {
        return overview;
    }



    public String getRelease_date() {
        return release_date;
    }

    public String getTitle() {
        return title;
    }



    public void setOverview(String overview) {
        this.overview = overview;
    }


    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

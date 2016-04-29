package com.example.pavan.kmtabalavidyalaya.Models;

/**
 * Created by kai on 28/4/16.
 */
public class RowPostData {
    private String imagefile;
    private String message;
    public RowPostData(String imageFile, String message) {
        this.imagefile = imageFile;
        this.message = message;
    }

    public String getImagefile(){
        return imagefile;
    }

    public String getMessage(){
        return message;
    }
}

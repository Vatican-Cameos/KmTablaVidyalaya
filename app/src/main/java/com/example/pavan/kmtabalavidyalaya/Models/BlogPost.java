package com.example.pavan.kmtabalavidyalaya.Models;

/**
 * Created by kai on 28/4/16.
 */
public class BlogPost {
    private String imagefile;
    private String message;

    public BlogPost(){

    }

    public String getImagefile(){
        return imagefile;
    }
    public void setImagefile(String imageFile){this.imagefile = imageFile;}

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}

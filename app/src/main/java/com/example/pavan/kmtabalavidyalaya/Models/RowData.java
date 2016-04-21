package com.example.pavan.kmtabalavidyalaya.Models;

import pl.droidsonroids.gif.GifImageView;

/**
 * Created by kai on 21/4/16.
 */
public class RowData {
    private String text;
    private int imageUrl;

    public RowData(String s1, int i){
        text = s1;
        imageUrl = i;
    }

    public int getImage(){
        return this.imageUrl;
    }
    public void setImage(int image){
        this.imageUrl = image;
    }

    public String getText(){
        return this.text;
    }
    public void setText(String text){
        this.text = text;
    }
}

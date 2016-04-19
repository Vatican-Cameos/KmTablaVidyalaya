package com.example.pavan.kmtabalavidyalaya.Models;

/**
 * Created by Pavan on 14-03-2016.
 */
public class RowData {
    private String text;

    private int imageUrl;

    public RowData(String s1, int i){
       text = s1;
       imageUrl  = i;
    }
    public String getText(){return text;}
    public int getImage(){return imageUrl;}
    public void setDate(String text){this.text = text;}
    public void setImage(int image){this.imageUrl = image;}


}

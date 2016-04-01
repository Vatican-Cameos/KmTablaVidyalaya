package com.example.pavan.kmtabalavidyalaya;

/**
 * Created by Pavan on 14-03-2016.
 */
public class RowData {
    private String text;

    private int imageUrl;

    RowData(String s1 , int i){
       text = s1;
       imageUrl  = i;
    }
    public String getText(){return text;}
    public int getImage(){return imageUrl;}
    public void setDate(String text){this.text = text;}
    public void setImage(int image){this.imageUrl = image;}


}

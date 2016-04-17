package com.example.pavan.kmtabalavidyalaya.aboutGuru;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.widget.GridView;

import com.example.pavan.kmtabalavidyalaya.R;

import java.util.ArrayList;

/**
 * Created by Pavan on 02-04-2016.
 */
public class AboutGuru extends AppCompatActivity {
    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String [] prgmNameList={"Guruji's Achievement","History","example text", "example", "example", "example", "example"};
    public static int [] prgmImages={R.drawable.kmtv, R.drawable.kmtv ,R.drawable.kmtv , R.drawable.kmtv, R.drawable.kmtv, R.drawable.kmtv, R.drawable.kmtv  };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_guru);


        gv=(GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));
    }
}

package com.example.pavan.kmtabalavidyalaya.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.pavan.kmtabalavidyalaya.R;
import com.example.pavan.kmtabalavidyalaya.Adapters.CustomAdapter;

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
        setContentView(R.layout.activity_about_guru);
        init();


    }

        private void init() {

    }

}

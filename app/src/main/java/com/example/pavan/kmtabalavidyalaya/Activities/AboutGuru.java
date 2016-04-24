package com.example.pavan.kmtabalavidyalaya.Activities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.pavan.kmtabalavidyalaya.Adapters.GuruDetailsAdapter;
import com.example.pavan.kmtabalavidyalaya.Models.GuruModel;
import com.example.pavan.kmtabalavidyalaya.R;
import com.example.pavan.kmtabalavidyalaya.Adapters.CustomAdapter;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by Pavan on 02-04-2016.
 */
public class AboutGuru extends BaseActivity {
    GridLayoutManager gridLayoutManager;

    @Bind(R.id.rvGuruList)
    RecyclerView rvGuruList;

    ArrayList<GuruModel> mGuruModels = new ArrayList<>();


    private GuruDetailsAdapter mGuruListingAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();


    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_about_guru;
    }

    private void init() {

        mGuruListingAdapter = new GuruDetailsAdapter(getApplicationContext(), new GuruDetailsAdapter.CardTapListener() {
            @Override
            public void onTap(View v, GuruModel movieModel) {

            }


        });


        mGuruModels.add(new GuruModel("KMTV"));
        mGuruModels.add(new GuruModel("Hello"));
        mGuruListingAdapter.setDataSet(mGuruModels);
        mGuruListingAdapter.notifyDataSetChanged();

        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);

        rvGuruList.setHasFixedSize(true);
        rvGuruList.setLayoutManager(gridLayoutManager);
        rvGuruList.setAdapter(mGuruListingAdapter);

    }

}

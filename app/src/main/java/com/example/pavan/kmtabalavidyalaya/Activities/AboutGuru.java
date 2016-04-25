package com.example.pavan.kmtabalavidyalaya.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.pavan.kmtabalavidyalaya.Adapters.GuruDetailsAdapter;
import com.example.pavan.kmtabalavidyalaya.Models.GuruModel;
import com.example.pavan.kmtabalavidyalaya.R;

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
                Intent intent = new Intent(getApplicationContext(), GuruDetails.class);

                intent.putExtra("image", movieModel.getImage());
                intent.putExtra("name", movieModel.getTitle());
                intent.putExtra("desc", movieModel.getDesc());
                Pair<View,String> why  = Pair.create((View)v,getApplication().getResources().getString(R.string.thumbnail_transition));
                Pair<View,String> kai  = Pair.create((View)v,getApplication().getResources().getString(R.string.tvTitle_transition));
                //ActivityOptionsCompat options = ActivityOptionsCompat].
                  //      makeSceneTransitionAnimation(AboutGuru.this, v, getApplication().getResources().getString(R.string.thumbnail_transition));

                ActivityOptionsCompat options = ActivityOptionsCompat.
                     makeSceneTransitionAnimation(AboutGuru.this, why);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    startActivity(intent, options.toBundle());
                }

            }


        });


        mGuruModels.add(new GuruModel("About Guruji",R.drawable.kmtv,getApplication().getResources().getString(R.string.guru_about)));
        mGuruModels.add(new GuruModel("Achievements",R.drawable.abc,getApplication().getResources().getString(R.string.guru_achievements)));
        mGuruModels.add(new GuruModel("Awards",R.drawable.news, getApplication().getResources().getString(R.string.guru_awards)));
        mGuruModels.add(new GuruModel("Info",R.drawable.sir, "some random information"));
        mGuruListingAdapter.setDataSet(mGuruModels);
        mGuruListingAdapter.notifyDataSetChanged();

        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);

        rvGuruList.setHasFixedSize(true);
        rvGuruList.setLayoutManager(gridLayoutManager);
        rvGuruList.setAdapter(mGuruListingAdapter);

    }

}

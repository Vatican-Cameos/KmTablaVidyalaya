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
            public void onTap(View v, GuruModel guruModel) {
                Intent intent = new Intent(getApplicationContext(), GuruDetails.class);

                intent.putExtra("image", guruModel.getImage());
                intent.putExtra("name", guruModel.getTitle());
                intent.putExtra("desc", guruModel.getDesc());
                intent.putExtra("backdrop", guruModel.getBackdrop());
                Pair<View,String> why  = Pair.create((View)v,getApplication().getResources().getString(R.string.thumbnail_transition));
                Pair<View,String> kai  = Pair.create((View)v,getApplication().getResources().getString(R.string.tvTitle_transition));
                //ActivityOptionsCompat options = ActivityOptionsCompat].
                  //      makeSceneTransitionAnimation(AboutGuru.this, v, getApplication().getResources().getString(R.string.thumbnail_transition));

                ActivityOptionsCompat options = ActivityOptionsCompat.
                     makeSceneTransitionAnimation(AboutGuru.this, why,kai);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    startActivity(intent, options.toBundle());
                }

            }


        });


        mGuruModels.add(new GuruModel("About Guruji",R.drawable.about_guru_early_life,getApplication().getResources().getString(R.string.guru_about),R.drawable.zakeerbig));
        mGuruModels.add(new GuruModel("Achievements",R.drawable.about_guru_sir,getApplication().getResources().getString(R.string.guru_achievements), R.drawable.about_guru_sir_btin));
        mGuruModels.add(new GuruModel("Awards",R.drawable.about_guru_sir_c, getApplication().getResources().getString(R.string.guru_awards), R.drawable.sir));
        mGuruModels.add(new GuruModel("Info",R.drawable.about_guru_sir_d, "some random information", R.drawable.book));
        mGuruListingAdapter.setDataSet(mGuruModels);
        mGuruListingAdapter.notifyDataSetChanged();

        gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);

        rvGuruList.setHasFixedSize(true);
        rvGuruList.setLayoutManager(gridLayoutManager);
        rvGuruList.setAdapter(mGuruListingAdapter);

    }

}

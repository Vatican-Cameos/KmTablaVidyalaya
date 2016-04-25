package com.example.pavan.kmtabalavidyalaya.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pavan.kmtabalavidyalaya.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by kai on 20/4/16.
 */
public class GuruDetails extends AppCompatActivity {
    @Bind(R.id.ivBackDrop)
    ImageView backDrop;

    @Bind(R.id.ivPoster)
    ImageView ivPoster;

    @Bind(R.id.tv_overview)
    TextView tvOverview;

    @Bind(R.id.tv_original_title)
    TextView tvTitle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_guru_details);
        ButterKnife.bind(this);
        populateViews();
    }

    private void populateViews() {

        Intent intent = getIntent();
       int image = intent.getIntExtra("image",1);
        String name = intent.getStringExtra("name");
        String desc  = intent.getStringExtra("desc");



        if (tvOverview.length() > 15) {
            tvTitle.setTextSize(22);
        }

        if (tvTitle.length() > 22) {
            tvTitle.setTextSize(16);
        }

        Typeface robotocondensedlight = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/robotomedium.ttf");
        Typeface robotocondensedbold = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/robotocondensedbold.ttf");
        tvTitle.setTypeface(robotocondensedbold);
        tvOverview.setTypeface(robotocondensedlight);
        tvTitle.setText(name);
        tvOverview.setText(desc);
        ivPoster.setImageResource(image);
    }
}

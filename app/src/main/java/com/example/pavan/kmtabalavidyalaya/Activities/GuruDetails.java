package com.example.pavan.kmtabalavidyalaya.Activities;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.pavan.kmtabalavidyalaya.R;
import com.example.pavan.kmtabalavidyalaya.Utils.AnimationHelperUtils;
import com.example.pavan.kmtabalavidyalaya.Utils.PaletteTransformation;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by kai on 20/4/16.
 */
public class GuruDetails extends AppCompatActivity {
    @Bind(R.id.ivBackDrop)
    ImageView ivBackDrop;

    @Bind(R.id.ivPoster)
    ImageView ivPoster;

    @Bind(R.id.tv_overview)
    TextView tvOverview;

    @Bind(R.id.container)
    RelativeLayout container;

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
        int image = intent.getIntExtra("image", 1);
        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("desc");
        int backdrop = intent.getIntExtra("backdrop", 1);


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
        ivPoster.setImageResource(image);
        tvTitle.setText(name);
        tvOverview.setText(desc);
        Picasso.with(this)
                .load(backdrop)
                .transform(PaletteTransformation.instance())

                .into(ivBackDrop, new Callback.EmptyCallback() {
                    @Override
                    public void onSuccess() {
                        Bitmap bitmap = ((BitmapDrawable) ivBackDrop.getDrawable()).getBitmap();
                        Palette palette = PaletteTransformation.getPalette(bitmap);
                        // apply palette to text views, backgrounds, etc.

                        setPaletteColors(palette);
                    }
                });








        }



    private void setPaletteColors(Palette palette) {
        Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();

        int vibrantDark = palette.getDarkVibrantColor(0xff000000);

        if (vibrantSwatch != null) {
            container.setBackgroundColor(vibrantSwatch.getRgb());
            tvOverview.setTextColor(vibrantSwatch.getBodyTextColor());
            tvTitle.setTextColor(vibrantSwatch.getBodyTextColor());
            /*ActionBar bar = getActionBar();
            bar.setBackgroundDrawable(new ColorDrawable(vibrantSwatch.getRgb()))*/;
            /*tv_rating.setTextColor(vibrantSwatch.getBodyTextColor());
            tv_release_date.setTextColor(vibrantSwatch.getBodyTextColor());*/
        }

        //Not sure why getDarkVibrantColor() returns 0 sometimes.
        if (vibrantDark == 0) {
            tvTitle.setTextColor(0xff000000);
        } else {
            tvTitle.setTextColor(vibrantDark);
        }
        AnimationHelperUtils.statusBarColorTransition(vibrantDark, 400, GuruDetails.this);

    }
}

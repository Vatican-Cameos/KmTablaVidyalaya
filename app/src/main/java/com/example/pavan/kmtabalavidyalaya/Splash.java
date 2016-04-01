package com.example.pavan.kmtabalavidyalaya;

import android.app.ActionBar;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.skyfishjy.library.RippleBackground;

/**
 * Created by Pavan on 31-03-2016.
 */
public class Splash extends AppCompatActivity {
    MediaPlayer ringSplash;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        android.support.v7.app.ActionBar actionBar =  getSupportActionBar();
        actionBar.hide();
        ringSplash = MediaPlayer.create(this, R.raw.ringtaal);
        ringSplash.start();

        final RippleBackground rippleBackground=(RippleBackground)findViewById(R.id.content);
        ImageView imageView=(ImageView)findViewById(R.id.centerImage);

        rippleBackground.startRippleAnimation();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ringSplash.stop();
                Intent i = new Intent(Splash.this , MainActivity.class);
                finish();
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        ringSplash.stop();
    }
}

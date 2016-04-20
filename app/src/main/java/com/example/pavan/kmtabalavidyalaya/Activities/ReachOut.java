package com.example.pavan.kmtabalavidyalaya.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.pavan.kmtabalavidyalaya.R;

import java.util.Locale;

/**
 * Created by Pavan on 16-03-2016.
 */
public class ReachOut extends AppCompatActivity {
    private Button bMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reach_out);
        init();
        listeners();

    }

    private void init() {
        bMap = (Button) findViewById(R.id.bMap);
    }


    private void listeners() {
        bMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Kallur Mahalaxmi Tabala Vidyalaya
                // 12.929715, 77.554366
                String uri = String.format(Locale.ENGLISH, "geo:12.929715, 77.554366?z=17&q=12.929715, 77.554366");
                // String uri = String.format(Locale.ENGLISH, "geo:12.902846, 77.504452");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
    }

}

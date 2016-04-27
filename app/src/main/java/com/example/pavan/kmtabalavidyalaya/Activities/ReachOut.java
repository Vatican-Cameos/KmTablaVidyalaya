package com.example.pavan.kmtabalavidyalaya.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.pavan.kmtabalavidyalaya.R;

import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Pavan on 16-03-2016.
 */
public class ReachOut extends AppCompatActivity {
    @Bind(R.id.bMap)
    Button bMap;
    @Bind(R.id.bRajCall)
    Button bRajCall;
    @Bind(R.id.bCoCall)
    Button bCoCall;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reach_out);
        ButterKnife.bind(this);
        listeners();

    }


    private void listeners() {

        bRajCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse("tel:08026758623");
                Intent callIntent = new Intent(Intent.ACTION_CALL, number);
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(callIntent);
            }
        });






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

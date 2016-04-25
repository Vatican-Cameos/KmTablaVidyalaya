package com.example.pavan.kmtabalavidyalaya.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.pavan.kmtabalavidyalaya.R;
import com.firebase.client.Firebase;

/**
 * Created by kai on 25/4/16.
 */
public class NewsFeed extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_news_feed);
        Firebase myFirebaseRef = new Firebase("https://kmtv.firebaseio.com/");
        myFirebaseRef.child("message").setValue("Do you have data? You'll love Firebase.");
    }
}

package com.example.pavan.kmtabalavidyalaya.Activities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;

import com.example.pavan.kmtabalavidyalaya.Adapters.MyRecyclerViewAdapter;
import com.example.pavan.kmtabalavidyalaya.Adapters.PostAdapter;
import com.example.pavan.kmtabalavidyalaya.Helpers.DividerItemDecoration;
import com.example.pavan.kmtabalavidyalaya.Models.BlogPost;
import com.example.pavan.kmtabalavidyalaya.Models.RowData;
import com.example.pavan.kmtabalavidyalaya.Models.RowPostData;
import com.example.pavan.kmtabalavidyalaya.R;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kai on 25/4/16.
 */
public class NewsFeed extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList results;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_news_feed);
        Firebase myFirebaseRef = new Firebase("https://kmtv.firebaseio.com/");

        recyclerViewInit();

     /*   Bitmap bmp =  BitmapFactory.decodeResource(getResources(), R.drawable.about_guru_early_life);//your image
        ByteArrayOutputStream bYtE = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, bYtE);
        bmp.recycle();
        byte[] byteArray = bYtE.toByteArray();
        String imageFile = Base64.encodeToString(byteArray, Base64.DEFAULT);

        Map<String, String> post = new HashMap<String, String>();
        post.put("imagefile", imageFile);
        post.put("message", "This is a message");
        myFirebaseRef.push().setValue(post);*/

    }

    private void recyclerViewInit() {
        mRecyclerView = (RecyclerView)findViewById(R.id.rvPost);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new PostAdapter(getDataSet());
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);

    }

    private ArrayList<RowPostData> getDataSet() {
        results = new ArrayList<RowPostData>();


        Firebase ref = new Firebase("https://kmtv.firebaseio.com/");

        // Attach an listener to read the data at our posts reference

        ref.addChildEventListener(new ChildEventListener() {
            // Retrieve new posts as they are added to the database
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                BlogPost newPost = snapshot.getValue(BlogPost.class);
                Log.e("snap2", "" + newPost.getMessage());
                RowPostData obj;

                obj = new RowPostData(newPost.getImagefile(), newPost.getMessage());

                mAdapter.notifyDataSetChanged();
                results.add(0, obj);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
            //... ChildEventListener also defines onChildChanged, onChildRemoved,
            //    onChildMoved and onCanceled, covered in later sections.
        });
        return results;
    }
    }
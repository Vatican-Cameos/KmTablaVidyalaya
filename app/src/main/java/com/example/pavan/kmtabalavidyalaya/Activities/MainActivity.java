package com.example.pavan.kmtabalavidyalaya.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.pavan.kmtabalavidyalaya.Helpers.DividerItemDecoration;
import com.example.pavan.kmtabalavidyalaya.Adapters.MyRecyclerViewAdapter;
import com.example.pavan.kmtabalavidyalaya.Models.RowData;
import com.example.pavan.kmtabalavidyalaya.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList results;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        setContentView(R.layout.activity_main_menu);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.kmtv_toolbar_icon_hd);

        init();
        rowDataInitialization();
        recyclerViewInit();
        listeners();




    }




    private void init() {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);




    }

    private void rowDataInitialization() {
        // this is data fro recycler view
        RowData itemsData[] = {
                new RowData("About Guruji",R.drawable.sir),
                new RowData("The Vidyalaya",R.drawable.roopu),
                new RowData("News Feed",R.drawable.news_resized),
                new RowData("Reach Us",R.drawable.location),
        };
        results = new ArrayList<RowData>();
        for(int i = 0 ; i < itemsData.length ; i++)
            results.add(itemsData[i]);
    }

    private void recyclerViewInit() {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(results);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
    }

    private void listeners() {

        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter.MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Log.i("clicked", " Clicked on Item " + position);
                if(position == 3){
                    Intent i = new Intent(MainActivity.this , ReachOut.class);
                    startActivity(i);
                }
                if(position == 0){
                    Intent i = new Intent (MainActivity.this, AboutGuru.class);
                    startActivity(i);
                }
                if(position == 2){
                    Intent i = new Intent (MainActivity.this, NewsFeed.class);
                    startActivity(i);
                }
            }
        });
    }
}

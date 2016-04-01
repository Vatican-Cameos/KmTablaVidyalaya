package com.example.pavan.kmtabalavidyalaya;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList results;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        setContentView(R.layout.mainmenu);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.kmtv_toolbar_icon_hd);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // this is data fro recycler view
        RowData itemsData[] = { new RowData("The Vidyalaya",R.drawable.sir),
                new RowData("About Guruji",R.drawable.roopu),
                new RowData("News Feed",R.drawable.news_resized),
                new RowData("Reach Us",R.drawable.location),
               };
        results = new ArrayList<RowData>();
        for(int i = 0 ; i < itemsData.length ; i++)
            results.add(itemsData[i]);


        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new MyRecyclerViewAdapter(results);
        mRecyclerView.setAdapter(mAdapter);
        RecyclerView.ItemDecoration itemDecoration =
                new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);


      /*  // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 3. create an adapter
        MyAdapter mAdapter = new MyAdapter(itemsData);
        mAdapter.notifyDataSetChanged();
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());*/

        ((MyRecyclerViewAdapter) mAdapter).setOnItemClickListener(new MyRecyclerViewAdapter.MyClickListener() {
            @Override
             public void onItemClick(int position, View v) {
              Log.i("clicked", " Clicked on Item " + position);
                if(position == 3){
                    Intent i = new Intent(MainActivity.this , ReachOut.class);
                    startActivity(i);
                }
               }
             });


    }
}

package com.example.pavan.kmtabalavidyalaya.Adapters;

/**
 * Created by Pavan on 02-04-2016.
 */
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pavan.kmtabalavidyalaya.Activities.AboutGuru;
import com.example.pavan.kmtabalavidyalaya.Activities.GuruDetails;
import com.example.pavan.kmtabalavidyalaya.R;

import butterknife.Bind;

public class CustomAdapter extends BaseAdapter{

    String [] result;
    Context context;
    int [] imageId;

    private static LayoutInflater inflater=null;
    public CustomAdapter(AboutGuru mainActivity, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;

        rowView = inflater.inflate(R.layout.item_about_guru, null);
        holder.tv=(TextView) rowView.findViewById(R.id.tvTitle);
        holder.img=(ImageView) rowView.findViewById(R.id.ivThumbnail);

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);

        /*rowView.setOnClickListener(new OnClickListener() {

            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub


            }
        });*/

        return rowView;
    }

}
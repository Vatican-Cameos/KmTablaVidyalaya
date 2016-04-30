package com.example.pavan.kmtabalavidyalaya.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pavan.kmtabalavidyalaya.Models.GuruModel;
import com.example.pavan.kmtabalavidyalaya.Models.RowData;
import com.example.pavan.kmtabalavidyalaya.Models.RowPostData;
import com.example.pavan.kmtabalavidyalaya.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by kai on 28/4/16.
 */
public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private Context mContext;
    private CardTapListener mCardTapListener;
    private List<RowPostData> mDataSet = new ArrayList<>();
    Typeface robotobold;


    public PostAdapter(Context context, CardTapListener cardTapListener) {
        this.mContext = context;
        this.mCardTapListener = cardTapListener;

        robotobold = Typeface.createFromAsset(mContext.getAssets(), "fonts/robotomedium.ttf");
    }

    public PostAdapter(ArrayList<RowPostData> dataSet) {
        mDataSet = dataSet;

    }


    public void setDataSet(List<RowPostData> movies) {
        mDataSet = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post_list, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final RowPostData row = mDataSet.get(position);

        holder.tvPost.setTypeface(robotobold);


        if (row.getMessage() != null)
            holder.tvPost.setText(row.getMessage());
        String strBase64 = mDataSet.get(position).getImagefile();

        byte[] decodedString = Base64.decode(strBase64, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        holder.ivPost.setImageBitmap(decodedByte);


        holder.cvPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCardTapListener != null) {
                    mCardTapListener.onTap(v, row);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public interface CardTapListener {
        void onTap(View v, RowPostData movieModel);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.ivPost)
        ImageView ivPost;

        @Bind(R.id.tvPost)
        TextView tvPost;

        @Bind(R.id.cvPost)
        CardView cvPost;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

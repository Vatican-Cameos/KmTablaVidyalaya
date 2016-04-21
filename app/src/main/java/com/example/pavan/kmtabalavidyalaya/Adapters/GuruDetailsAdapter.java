package com.example.pavan.kmtabalavidyalaya.Adapters;

/**
 * Created by kai on 21/4/16.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pavan.kmtabalavidyalaya.Models.GuruModel;
import com.example.pavan.kmtabalavidyalaya.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Chirag Shenoy on 17-Feb-16.
 */
public class GuruDetailsAdapter extends RecyclerView.Adapter<GuruDetailsAdapter.ViewHolder> {

    private final Context mContext;
    private final CardTapListener mCardTapListener;
    private List<GuruModel> mDataSet = new ArrayList<>();
    Typeface robotobold;


    public GuruDetailsAdapter(Context context, CardTapListener cardTapListener) {
        this.mContext = context;
        this.mCardTapListener = cardTapListener;

        robotobold = Typeface.createFromAsset(mContext.getAssets(), "fonts/robotomedium.ttf");
    }


    public void setDataSet(List<GuruModel> movies) {
        mDataSet = movies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_about_guru, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final GuruModel guruModelItem = mDataSet.get(position);

        holder.tvMovieTitle.setTypeface(robotobold);

        if (guruModelItem.getTitle() != null)
            holder.tvMovieTitle.setText(guruModelItem.getTitle());



        holder.cvMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCardTapListener != null) {
                    mCardTapListener.onTap(v, guruModelItem);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public interface CardTapListener {
        void onTap(View v, GuruModel movieModel);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.ivThumbnail)
        ImageView ivMovieThumbnail;

        @Bind(R.id.tvTitle)
        TextView tvMovieTitle;

        @Bind(R.id.cvDetails)
        CardView cvMovie;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

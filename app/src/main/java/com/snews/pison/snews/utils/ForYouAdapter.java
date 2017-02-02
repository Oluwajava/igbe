package com.snews.pison.snews.utils;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.snews.pison.snews.R;

import java.util.ArrayList;

/**
 * Created by Olusegun Olaosebikan on 10/31/2016.
 */

public class ForYouAdapter  extends RecyclerView.Adapter<ForYouAdapter.ForYouViewHolder> {
    ArrayList<News> news = new ArrayList<News>();
    public static Context ctx;

    public ForYouAdapter(ArrayList<News> news, Context ctx){
        this.news = news;
        this.ctx = ctx;
    }

    @Override
    public ForYouAdapter.ForYouViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int listViewItemType = getItemViewType(viewType);

        Log.d("ListViewItemType", "Value: "+listViewItemType);

        View view;
        if(listViewItemType == 0){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.for_you_big_card, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.for_you_small_card, parent, false);
        }
        ForYouAdapter.ForYouViewHolder connectViewHolder = new ForYouAdapter.ForYouViewHolder(view);

        return connectViewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onViewRecycled(ForYouAdapter.ForYouViewHolder holder) {
        super.onViewRecycled(holder);
        holder.setIsRecyclable(false);
    }

    @Override
    public void onBindViewHolder(ForYouAdapter.ForYouViewHolder holder, int position) {
        News newsId = news.get(position);
        if(position > 0)
            Glide.with(ctx).load(newsId.getThumbnailId()).centerCrop().into(holder.thumbnailImage);
        else
            Glide.with(ctx).load(newsId.getThumbnailId()).centerCrop().into(holder.thumbnailImage);
        holder.title.setText(newsId.getTitle());
        if (position == 0)
            holder.content.setText(newsId.getContent());

        Glide.with(ctx).load(newsId.getSourceId()).centerCrop().into(holder.sourceImage);
//        holder.thumbnailImage.setBackgroundResource(newsId.getThumbnailId());


    }


    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class ForYouViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        RelativeLayout relView;
        CardView cardView;
        ImageView thumbnailImage, sourceImage;
        TextView title, source, time, content;
        public ForYouViewHolder(View view){
            super(view);
            thumbnailImage = (ImageView)view.findViewById(R.id.thumbnail);
            title = (TextView)view.findViewById(R.id.title);
            source = (TextView)view.findViewById(R.id.source);
            time = (TextView)view.findViewById(R.id.time);
            content = (TextView)view.findViewById(R.id.content);
            relView = (RelativeLayout)view.findViewById(R.id.relView);
            cardView = (CardView)view.findViewById(R.id.card_view);
            sourceImage = (ImageView)view.findViewById(R.id.source_icon);

            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            int position = view.getId();



        }
    }
}

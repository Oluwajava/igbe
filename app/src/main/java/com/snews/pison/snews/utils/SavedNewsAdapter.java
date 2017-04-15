package com.snews.pison.snews.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.snews.pison.snews.R;

import java.util.ArrayList;

/**
 * Created by Olusegun Olaosebikan on 11/3/2016.
 */

public class SavedNewsAdapter extends RecyclerView.Adapter<SavedNewsAdapter.SavedNewsViewHolder> {
    public static ArrayList<String> favourites = new ArrayList<>();
    ArrayList<News> news = new ArrayList<News>();
    public static Context ctx;
    public static AssetManager assetManager;

    public SavedNewsAdapter(ArrayList<News> news, Context ctx){
        this.news = news;
        this.assetManager = assetManager;
        this.ctx = ctx;
    }

    @Override
    public SavedNewsAdapter.SavedNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.saved_card_news, parent, false);
        SavedNewsAdapter.SavedNewsViewHolder connectViewHolder = new SavedNewsAdapter.SavedNewsViewHolder(view);

        return connectViewHolder;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public void onViewRecycled(SavedNewsAdapter.SavedNewsViewHolder holder) {
        super.onViewRecycled(holder);
        holder.setIsRecyclable(false);
    }

    @Override
    public void onBindViewHolder(SavedNewsAdapter.SavedNewsViewHolder holder, int position) {
        //set values of card
        News newsId = news.get(position);
        String url = "http://192.168.253.1/disciples/img.jpg";
        if(position > 0)
            Glide.with(ctx).load(newsId.getSourceId()).thumbnail(0.1f).into(holder.thumbnailImage);
        else
            Glide.with(ctx).load(newsId.getSourceId()).into(holder.thumbnailImage);
        holder.title.setText(newsId.getTitle());
        holder.content.setText(newsId.getContent());
        holder.source.setText(newsId.getSource());
        holder.time.setText(newsId.getTime());
    }


    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class SavedNewsViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout relView;
        CardView cardView;
        ImageView thumbnailImage;
        TextView title, content, source, time;
        public SavedNewsViewHolder(View view){
            super(view);
            thumbnailImage = (ImageView)view.findViewById(R.id.thumbnail);
            title = (TextView)view.findViewById(R.id.title);
            content = (TextView)view.findViewById(R.id.content);
            source = (TextView)view.findViewById(R.id.source);
            time = (TextView)view.findViewById(R.id.time);
            relView = (RelativeLayout)view.findViewById(R.id.relView);
            cardView = (CardView)view.findViewById(R.id.card_view);
        }

    }
}

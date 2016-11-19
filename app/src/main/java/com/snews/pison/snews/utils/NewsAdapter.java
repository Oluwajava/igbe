package com.snews.pison.snews.utils;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.snews.pison.snews.R;

import java.util.ArrayList;

/**
 * Created by Olusegun Olaosebikan on 10/31/2016.
 */

public class NewsAdapter  extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    public static ArrayList<String> favourites = new ArrayList<>();
    ArrayList<News> news = new ArrayList<News>();
    public static Context ctx;

    public NewsAdapter(ArrayList<News> news, Context ctx){
        this.news = news;
        this.ctx = ctx;
    }

    @Override
    public NewsAdapter.NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_card_news, parent, false);
        NewsAdapter.NewsViewHolder connectViewHolder = new NewsAdapter.NewsViewHolder(view);

        return connectViewHolder;
    }

    @Override
    public void onViewRecycled(NewsAdapter.NewsViewHolder holder) {
        super.onViewRecycled(holder);
        holder.setIsRecyclable(false);
    }

    @Override
    public void onBindViewHolder(NewsAdapter.NewsViewHolder holder, int position) {
        News newsId = news.get(position);
        holder.thumbnailImage.setImageResource(newsId.getSourceId());
        holder.sourceImage.setImageResource(newsId.getThumbnailId());
        holder.title.setText(newsId.getTitle());

    }


    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout relView;
        CardView cardView;
        ImageView thumbnailImage, sourceImage;
        TextView title;
        public NewsViewHolder(View view){
            super(view);
//            thumbnailImage = (ImageView)view.findViewById(R.id.thumbnailImage);
//            sourceImage = (ImageView)view.findViewById(R.id.sourceImage);
//            title = (TextView)view.findViewById(R.id.title);
//            relView = (RelativeLayout)view.findViewById(R.id.relView);
//            cardView = (CardView)view.findViewById(R.id.card_view);


        }
    }
}

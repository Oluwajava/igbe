package com.snews.pison.snews.utils;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.AppCompatImageView;
import android.widget.ImageView;
import android.widget.TextView;

import com.snews.pison.snews.R;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by lami on 1/16/2017.
 */

public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.SearchViewHolder> {

    private List<News> mNewsList;

    public SearchResultsAdapter(List<News> newsList) {
        mNewsList = newsList;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.search_result_item, parent,false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        News news = mNewsList.get(position);
        holder.mImageView.setImageResource(R.drawable.mg);
        holder.mNewsTitleTextView.setText(news.getTitle());
        holder.mNewsSummaryTextView.setText(news.getContent());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mNewsTitleTextView;
        TextView mNewsSummaryTextView;

        public SearchViewHolder(View itemView) {
            super(itemView);
            mImageView = ButterKnife.findById(itemView, R.id.news_thumb);
            mNewsTitleTextView = ButterKnife.findById(itemView, R.id.news_title_brief);
            mNewsSummaryTextView = ButterKnife.findById(itemView, R.id.news_title_summary);
        }
    }
}

package com.snews.pison.snews;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.snews.pison.snews.utils.News;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Mayokun on 2/24/2017.
 */

public class NewsActivity extends AppCompatActivity {
    @BindView(R.id.thumbnail) ImageView newsImage;
    @BindView(R.id.title) TextView newsTitle;
    @BindView(R.id.sub_title) TextView newsSubTitle;
    @BindView(R.id.news_content) TextView newsContent;
    @BindView(R.id.favourite) ImageView addToFavourite;
    @BindView(R.id.share) ImageView shareNews;
    @BindView(R.id.save) ImageView saveNews;
    private News news;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content_page);
        ButterKnife.bind(this);
        getBundledInformation();

        Glide.with(this).load(news.getThumbnailId()).centerCrop().into(new GlideDrawableImageViewTarget(newsImage));
        newsTitle.setText(news.getTitle());
        newsSubTitle.setText(news.getContent());
    }

    private void getBundledInformation() {
        if(getIntent().hasExtra("news")) {
            news = (News) getIntent().getSerializableExtra("news");
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

package com.snews.pison.snews;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.view.View.inflate;

/**
 * Created by Mayokun on 3/23/2017.
 */

public class Loading extends AppCompatActivity {

    AnimationDrawable rocketAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);

        ImageView logo_view = (ImageView) findViewById(R.id.logo_view);

        AnimationDrawable animationDrawable = (AnimationDrawable) logo_view.getBackground();
        animationDrawable.start();



    }


}

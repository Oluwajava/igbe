package com.snews.pison.snews;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import static java.lang.Thread.sleep;

/**
 * Created by Mayokun on 2/11/2017.
 */

public class Intro extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(Intro.this, MenuActivity.class));
                }

            }
        });

        timer.start();
    }
}

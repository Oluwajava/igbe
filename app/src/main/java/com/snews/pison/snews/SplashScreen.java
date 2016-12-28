package com.snews.pison.snews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Olusegun Olaosebikan on 11/21/2016.
 */

public class SplashScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent i = new Intent(SplashScreen.this, MenuFragment.class);
                    startActivity(i);
                }
            }
        };

        thread.start();
    }
}

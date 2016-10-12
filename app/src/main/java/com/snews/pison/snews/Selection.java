package com.snews.pison.snews;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;


public class Selection extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Connect> list = new ArrayList<Connect>();
    Button btnContinue;
    String[] name;
    int[] image_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_activity);

        //populating data from NewsContent
        name = NewsContent.getName();
        image_id = NewsContent.getImageId();

        initializeCard();

        btnContinue.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    Log.d("Test", NewsContent.getFavouritesSources().toString());
               }
           }
        );
    }

    public void initializeCard() {

        int count = 0;

        //loops through the array and add it to an ArrayList
        for(String Name: name){
            Connect connect = new Connect(image_id[count], Name);
            count++;
            list.add(connect);
        }

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridAutofitLayoutManager(this, 180));
        recyclerView.setHasFixedSize(true);
        adapter = new ConnectAdapter(list, this);
        recyclerView.setAdapter(adapter);

        btnContinue = (Button)findViewById(R.id.button);
    }
}

package com.snews.pison.snews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.snews.pison.snews.utils.Connect;
import com.snews.pison.snews.utils.ConnectAdapter;
import com.snews.pison.snews.utils.GridAutofitLayoutManager;
import com.snews.pison.snews.utils.NewsContent;

import java.util.ArrayList;


public class Selection extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Connect> list = new ArrayList<Connect>();
    Button btnContinue;
    String[] name;
    int[] image_id;
    private PrefManager pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selection_activity);

        pref = new PrefManager(this);
        //populating data from NewsContent
        name = NewsContent.getName();
        image_id = NewsContent.getImageId();

        initializeCard();

        btnContinue.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {

                                               pref.setSelectionMade(true);
                                               pref.setFavourites(NewsContent.getFavouritesSources());
                                               Log.d("Test", "Array: "+ NewsContent.getFavouritesSources().toArray().toString());
                                               Log.d("Test", "Pref: "+pref.isSelectionMade());
                                               startActivity(new Intent(Selection.this, MenuFragment.class));
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
        //the value passed to the layout manager determines the size of each card
        recyclerView.setLayoutManager(new GridAutofitLayoutManager(this, 160));
        recyclerView.setHasFixedSize(true);
        adapter = new ConnectAdapter(list, this);
        recyclerView.setAdapter(adapter);

        btnContinue = (Button)findViewById(R.id.button);
    }
}

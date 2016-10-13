package com.snews.pison.snews;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.snews.pison.snews.utils.Connect;
import com.snews.pison.snews.utils.ConnectAdapter;
import com.snews.pison.snews.utils.GridAutofitLayoutManager;
import com.snews.pison.snews.utils.NewsContent;

import java.util.ArrayList;

/**
 * Created by Olusegun Olaosebikan on 10/12/2016.
 */

public class MenuActivity extends Activity {

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
        setContentView(R.layout.menu_activity);

        name = NewsContent.getName();
        image_id = NewsContent.getImageId();

//        initializeCard();
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
        recyclerView.setLayoutManager(new GridAutofitLayoutManager(this, 150));
        recyclerView.setHasFixedSize(true);
        adapter = new ConnectAdapter(list, this);
        recyclerView.setAdapter(adapter);

        btnContinue = (Button)findViewById(R.id.button);
    }
}

package com.snews.pison.snews.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.snews.pison.snews.MenuActivity;
import com.snews.pison.snews.PrefManager;
import com.snews.pison.snews.R;
import com.snews.pison.snews.Selection;
import com.snews.pison.snews.utils.NewsContent;
import com.snews.pison.snews.utils.SelectionAdapter;
import com.snews.pison.snews.utils.SelectionItem;

import java.util.ArrayList;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Mayokun on 1/25/2017.
 */

public class SelectionFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<SelectionItem> list = new ArrayList<SelectionItem>();
    Button btnContinue;
    String[] name;
    int[] image_id, background_id;
    private PrefManager pref;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selection, container, false);

        pref = new PrefManager(getActivity());
        //populating data from NewsContent
        name = NewsContent.getName();
        image_id = NewsContent.getImageId();
        background_id = NewsContent.getBackgroundId();
        initializeCard(view);
//
//        btnContinue.setOnClickListener(new View.OnClickListener() {
//                                           @Override
//                                           public void onClick(View v) {
//
//                                               pref.setSelectionMade(true);
//                                               pref.setFavourites(NewsContent.getFavouritesSources());
//                                               Log.d("Test", "Array: "+ NewsContent.getFavouritesSources().toArray().toString());
//                                               Log.d("Test", "Pref: "+pref.isSelectionMade());
//                                               startActivity(new Intent(getActivity(), MenuActivity.class));
//                                           }
//                                       }
//        );

        initilizeToolbars(view);

        return view;
    }

    public void initializeCard(View view) {

        int count = 0;

        //loops through the array and add it to an ArrayList
        for(String Name: name){
            SelectionItem selectionItem = new SelectionItem(image_id[count], Name, background_id[count]);
            count++;
            list.add(selectionItem);
        }

        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
        //the value passed to the layout manager determines the size of each card
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerView.setHasFixedSize(true);
        adapter = new SelectionAdapter(list, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
//        btnContinue = (Button)view.findViewById(R.id.button);
    }

    private void initilizeToolbars(View view) {

        // Setup the toolbar
        Toolbar toolbar = (Toolbar)view.findViewById(R.id.toolbar);
        TextView toolBarTitle = (TextView)view.findViewById(R.id.toolbar_title);
        TextView toolBarSubTitle = (TextView)view.findViewById(R.id.sub_title);
        ImageButton next = (ImageButton)view.findViewById(R.id.next);

        next.setVisibility(View.VISIBLE);
        toolBarTitle.setText(R.string.pick_favourites);
        toolBarSubTitle.setText(R.string.tap_one);
//        AppCompatActivity activity = (AppCompatActivity) getActivity();

//        getActivity().setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }
}


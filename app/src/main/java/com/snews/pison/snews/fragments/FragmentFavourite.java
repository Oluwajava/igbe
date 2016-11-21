package com.snews.pison.snews.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.snews.pison.snews.PrefManager;
import com.snews.pison.snews.R;
import com.snews.pison.snews.utils.Connect;
import com.snews.pison.snews.utils.ConnectAdapter;
import com.snews.pison.snews.utils.GridAutofitLayoutManager;
import com.snews.pison.snews.utils.NewsContent;

import org.w3c.dom.Text;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * This class shows the list of sources
 * selected by the user as favourites
 */

public class FragmentFavourite extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Connect> list = new ArrayList<Connect>();
    private PrefManager pref;

    @BindView(R.id.toolbar) Toolbar toolBar;

    /** Required empty constructor */
    public FragmentFavourite() {}

    public static FragmentFavourite newInstance() {
        return new FragmentFavourite();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_favourite, container, false);

        // Setup the toolbar
        Toolbar toolbar = ButterKnife.findById(rootView, R.id.toolbar);
        TextView toolBarTitle = ButterKnife.findById(toolbar, R.id.toolbar_title);
        toolBarTitle.setText(R.string.favorites_tab);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);

        pref = new PrefManager(getActivity());
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycler_view);

        initializeCard();
        return rootView;
    }

    private void initializeCard() {
        // get list of favourites news sources from shared preference
        String[] fav = pref.getFavourites().split(" ");
        String[] name = new String[fav.length-1];
        int[] image = new int[fav.length-1];

        for(int i = 0; i < fav.length-1; i++) {
            name[i] = NewsContent.getName(Integer.parseInt(fav[i+1]));
            image[i] = NewsContent.getImageId(Integer.parseInt(fav[i+1]));

        }

        int count = 0;

        //loops through the array and add it to an ArrayList
        for(String Name: name){
            Connect connect = new Connect(image[count], Name);
            count++;
            list.add(connect);
        }

        //the value passed to the layout manager determines the size of each card
        recyclerView.setLayoutManager(new GridAutofitLayoutManager(getActivity(), 140));
        recyclerView.setHasFixedSize(true);
        adapter = new ConnectAdapter(list, getActivity());
        recyclerView.setAdapter(adapter);
    }

}

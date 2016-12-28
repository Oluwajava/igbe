package com.snews.pison.snews.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.snews.pison.snews.R;
import com.snews.pison.snews.utils.ForYouAdapter;
import com.snews.pison.snews.utils.News;
import com.snews.pison.snews.utils.SavedNewsAdapter;

import java.util.ArrayList;

/**
 * User can search for article using certain keywords
 */
public class FragmentSearch extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);




        return rootView;
    }


}

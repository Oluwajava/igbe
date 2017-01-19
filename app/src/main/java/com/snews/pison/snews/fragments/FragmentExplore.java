package com.snews.pison.snews.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.snews.pison.snews.R;

import butterknife.ButterKnife;

/**
 * Explore shows the list of sources with two different cards
 * One for the sources selected by the user as favourites and
 * The other news sources
 */
public class FragmentExplore extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    /** Required empty constructor */
    public FragmentExplore() {}

    public static FragmentExplore newInstance() {
        return new FragmentExplore();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_explore, container, false);

        //initializing swipeview layouts
        viewPager = (ViewPager) rootView.findViewById(R.id.pager);
        tabLayout = (TabLayout) rootView.findViewById(R.id.view_pager);

        

        initializeToolbar(rootView);

        return rootView;
    }

    private void initializeToolbar(View rootView) {

        // Setup the toolbar
        Toolbar toolbar = ButterKnife.findById(rootView, R.id.toolbar);
        TextView toolBarTitle = ButterKnife.findById(toolbar, R.id.toolbar_title);
        toolBarTitle.setText(R.string.explore_tab);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);

    }


}

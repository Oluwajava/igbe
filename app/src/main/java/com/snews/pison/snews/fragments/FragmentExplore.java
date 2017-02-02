package com.snews.pison.snews.fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.snews.pison.snews.R;
import com.snews.pison.snews.utils.TabFragmentPage;
import com.snews.pison.snews.utils.TabbedFragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Explore shows the list of sources with two different cards
 * One for the sources selected by the user as favourites and
 * The other news sources
 */
public class FragmentExplore extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    private View view;
    private TabbedFragmentPagerAdapter pagerAdapter;
    protected List<TabFragmentPage<? extends Fragment>> tabFragmentPages;
    /** Required empty constructor */
    public FragmentExplore() {}

    public static FragmentExplore newInstance() {
        return new FragmentExplore();
    }

    @Override
    public void onResume() {
        super.onResume();
        tabFragmentPages.clear();
        initializeTabs(view);
        Log.d("Test", "Resumption");
    }

    @Override
    public void onPause() {
        super.onPause();
        tabFragmentPages.clear();
        Log.d("Test", "Paused");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_explore, container, false);
        this.view = rootView;

        initilizeToolbars(rootView);

        initializeTabs(rootView);


        return rootView;


    }

    private void initializeTabs(View view) {
        // Swipe tab initialization
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.pager);

        tabFragmentPages = new ArrayList<>();
        tabFragmentPages.add(new TabFragmentPage<NewsPage>(R.string.trending, NewsPage.class));
        tabFragmentPages.add(new TabFragmentPage<NewsPage>(R.string.world, NewsPage.class));
        tabFragmentPages.add(new TabFragmentPage<NewsPage>(R.string.politics, NewsPage.class));
        tabFragmentPages.add(new TabFragmentPage<NewsPage>(R.string.sports, NewsPage.class));
        tabFragmentPages.add(new TabFragmentPage<NewsPage>(R.string.EUROPE, NewsPage.class));
        tabFragmentPages.add(new TabFragmentPage<NewsPage>(R.string.africa, NewsPage.class));

        pagerAdapter = new TabbedFragmentPagerAdapter(getChildFragmentManager(), getContext(), tabFragmentPages);

        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initilizeToolbars(View view) {

        // Setup the toolbar
        Toolbar toolbar = ButterKnife.findById(view, R.id.toolbar);
        TextView toolBarTitle = ButterKnife.findById(toolbar, R.id.toolbar_title);
        TextView toolBarSubTitle = ButterKnife.findById(toolbar, R.id.sub_title);

        toolBarTitle.setText(R.string.explore_tab);
        toolBarSubTitle.setText(R.string.explore_sub_title);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

}

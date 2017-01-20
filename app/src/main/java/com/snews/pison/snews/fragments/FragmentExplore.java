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
    /** Required empty constructor */
    public FragmentExplore() {}

    public static FragmentExplore newInstance() {
        return new FragmentExplore();
    }

    @Override
    public void onResume() {
        super.onResume();
        initializeTabs(view);
        Log.d("Test", "Resumption");
    }

    @Override
    public void onPause() {
        super.onPause();
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


        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
            }
        });

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {

            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };

        return rootView;


    }

    private void initializeTabs(View view) {
        // Swipe tab initialization
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        viewPager = (ViewPager) view.findViewById(R.id.pager);



        // Setup swipe view
        viewPager.setAdapter(new FragmentExplore.CustomTabAdapter(getActivity().getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initilizeToolbars(View view) {

        // Setup the toolbar
        Toolbar toolbar = ButterKnife.findById(view, R.id.toolbar);
        TextView toolBarTitle = ButterKnife.findById(toolbar, R.id.toolbar_title);

        toolBarTitle.setText(R.string.explore_tab);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    private class CustomTabAdapter extends FragmentStatePagerAdapter {

        String[] headers = {"TRENDING", "WORLD", "POLITICS", "TRENDING", "WORLD", "POLITICS", "TRENDING", "WORLD", "POLITICS"};
        public CustomTabAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment frag = null;

            switch (position) {
                case 0:
                    frag = new NewsPage();
                    break;
                case 1:
                    frag = new NewsPage();
                    break;
                case 2:
                    frag = new NewsPage();
                    break;
                default:
                    frag = new NewsPage();
                    break;
            }
            return frag;
        }

        @Override
        public int getCount() {
            return headers.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return headers[position];
        }

    }

}

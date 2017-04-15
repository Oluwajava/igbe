package com.snews.pison.snews.fragments;

import android.content.Context;
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
import com.snews.pison.snews.utils.TabAdapter;
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
public class FragmentExplore extends AbstractFragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    private View view;
    private TabbedFragmentPagerAdapter pagerAdapter;
    protected List<? super Fragment> tabFragmentPages;
    /** Required empty constructor */
    public FragmentExplore() {}

    public static FragmentExplore newInstance() {
        return new FragmentExplore();
    }

    @Override
    public void onResume() {
        super.onResume();
        initializeTab(view);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_explore, container, false);
        this.view = rootView;

        initializeToolbars(rootView);

        return rootView;


    }

    private void initializeTab(View rootView) {
        tabFragmentPages = new ArrayList<>();
        tabFragmentPages.add(new FragmentForYou());
        tabFragmentPages.add(new FragmentForYou());
        tabFragmentPages.add(new FragmentForYou());

        viewPager = (ViewPager) rootView.findViewById(R.id.pager);
        viewPager.setAdapter(new TabAdapter(getChildFragmentManager(),getActivity().getApplicationContext(), (List<? extends Fragment>) tabFragmentPages));

        tabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });

    }


    private void initializeToolbars(View view) {
        super.initilizeToolbars(view, R.string.explore_tab, R.string.explore_sub_title, true);
    }


}

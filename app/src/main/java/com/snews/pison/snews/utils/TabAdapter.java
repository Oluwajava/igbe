package com.snews.pison.snews.utils;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Mayokun on 3/11/2017.
 */

public class TabAdapter extends FragmentPagerAdapter {


    private List<? extends Fragment> tabFragmentPages;
    private String fragments [] = {"Previous Week","This Week", "Next Week"};
    private Context context;

    public TabAdapter(FragmentManager supportFragmentManager, Context context, List<? extends Fragment> tabFragmentPages) {
        super(supportFragmentManager);
        this.context = context;
        this.tabFragmentPages = tabFragmentPages;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();

        Fragment frag;

        frag = tabFragmentPages.get(position);
        frag.setArguments(bundle);
        return frag;

    }

    @Override
    public int getCount() {
        return tabFragmentPages.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return fragments[position];
    }
}

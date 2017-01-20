package com.snews.pison.snews.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.snews.pison.snews.fragments.FragmentForYou;

/**
 * Created by root on 1/17/17.
 */
public class ExploreCollectionPagerAdapter extends FragmentStatePagerAdapter{

    String[] title = {"Trending", "World", "Technology", "Sport"};

    public ExploreCollectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag = new FragmentForYou();
        return frag;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}

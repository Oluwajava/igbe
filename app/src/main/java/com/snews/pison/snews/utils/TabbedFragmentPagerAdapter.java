package com.snews.pison.snews.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Mayokun on 1/19/2017.
 */

public class TabbedFragmentPagerAdapter extends FragmentStatePagerAdapter {

    protected Context context;

    public TabbedFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}

package com.snews.pison.snews.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.snews.pison.snews.fragments.AbstractFragment;

import java.util.List;

/**
 * the purpose of this class is to be used as
 * a pager adapter for all classes that needs to use a viewpager
 * like explore and the selection page
 * Created by Mayokun on 1/19/2017.
 */

public class TabbedFragmentPagerAdapter extends FragmentStatePagerAdapter {

    protected Context context;
    protected List<? extends TabFragmentPage<? extends AbstractFragment>> tabFragmentPages;

    public TabbedFragmentPagerAdapter(FragmentManager fm, Context context, List<? extends TabFragmentPage<? extends AbstractFragment>> tabFragmentPages) {
        super(fm);

        this.context = context;
        this.tabFragmentPages = tabFragmentPages;
    }


    @Override
    public Fragment getItem(int position) {
        TabFragmentPage<?> tabFragmentPage = tabFragmentPages.get(position);

        Fragment fragment = tabFragmentPage.getFragment();
        if (fragment == null) {
            fragment = tabFragmentPage.createFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return tabFragmentPages.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        TabFragmentPage<?> tabFragmentPage = tabFragmentPages.get(position);
        return context.getString(tabFragmentPage.getTitleRes());
    }

    public <T extends Fragment> T getFragment(int position) {
        return (T) getItem(position);
    }
}

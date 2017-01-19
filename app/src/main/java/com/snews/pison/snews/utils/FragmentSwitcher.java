package com.snews.pison.snews.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.snews.pison.snews.R;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by lami on 11/2/2016.
 */
public class FragmentSwitcher {
    private Map<String, Fragment> mFragments;
    private FragmentManager mFragmentManager;

    @IdRes
    private int mFragmentContainerId;
    private String mCurrentFragmentTag;

    private FragmentSwitcher() {}
    private FragmentSwitcher(final Activity activity, @IdRes int mFragmentContainerId) {
        mFragments = new HashMap<>();
        AppCompatActivity compatActivity = (AppCompatActivity) activity;
        mFragmentManager = compatActivity.getSupportFragmentManager();
        this.mFragmentContainerId = mFragmentContainerId;
    }

    public void addFragment(String fragName, Fragment fragment) {
        mFragments.put(fragName, fragment);
    }

    public void addFragmentWithBundle(String fragName, Fragment fragment, Bundle saveInstanceState) {
        fragment.setArguments(saveInstanceState);
        mFragments.put(fragName, fragment);
    }

    public void switchFragment(String fragName) {
        // Get the fragment with the given tag
        Fragment fragment = mFragments.get(fragName);
        if (mCurrentFragmentTag.equalsIgnoreCase(fragName)) { return; }

        mCurrentFragmentTag = fragName;
        if (fragment != null) {
            mFragmentManager.beginTransaction()
                    .setCustomAnimations(R.anim.fade_in,R.anim.fade_out)
                    .replace(mFragmentContainerId, fragment, fragment.getClass().getSimpleName())
                    .commit();
        }
    }

    /**
     * No fragment has been attached so call this method to make
     * one visible fragment.
     */
    public void showAsFirst(String fragTag) {
        Fragment fragment = mFragments.get(fragTag);
        mCurrentFragmentTag = fragTag;
        if (fragment != null) {
            mFragmentManager.beginTransaction()
                    .add(mFragmentContainerId, fragment, fragment.getClass().getSimpleName())
                    .commit();
        }
    }

    public static FragmentSwitcher getNewInstance(Activity activity, @IdRes int containerId) {
        return new FragmentSwitcher(activity, containerId);
    }

}

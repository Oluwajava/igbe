package com.snews.pison.snews.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.io.Serializable;

/**
 * Created by Mayokun on 1/21/2017.
 */

public class TabFragmentPage<T extends Fragment> implements Serializable {
    private int titleRes;
    private Bundle args;
    private Class<T> fragmentClass;
    private T fragment;

    public TabFragmentPage(int titleRes, Class<T> fragmentClass, Bundle args) {
        this.args = args;
        this.titleRes = titleRes;
        this.fragmentClass = fragmentClass;
    }

    public TabFragmentPage(int titleRes, Class<T> fragmentClass) {
        this(titleRes, fragmentClass, new Bundle());
    }



    public int getTitleRes() {
        return titleRes;
    }

    public void setTitleRes(int titleRes) {
        this.titleRes = titleRes;
    }

    public Bundle getArgs() {
        return args;
    }

    public void setArgs(Bundle args) {
        this.args = args;
    }

    public Class<T> getFragmentClass() {
        return fragmentClass;
    }

    public void setFragmentClass(Class<T> fragmentClass) {
        this.fragmentClass = fragmentClass;
    }

    public T createFragment() {
        T fragment = null;

        try {
            fragment = fragmentClass.newInstance();
            fragment.setArguments(args);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.fragment = fragment;
        return fragment;
    }

    public T getFragment() {
        return fragment;
    }
}

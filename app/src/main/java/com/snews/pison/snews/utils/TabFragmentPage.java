package com.snews.pison.snews.utils;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.io.Serializable;

/**
 * Created by Mayokun on 1/21/2017.
 */

public class TabFragmentPage<T extends Fragment> implements Serializable {

    private int titleResource;
    private Bundle args;
    private Class<T> fragmentClass;
    private T fragment;

    public TabFragmentPage(int titleResource, Class<T> fragmentClass, Bundle args) {
        this.setArgs(args);
        this.setTitleResource(titleResource);
        this.setFragmentClass(fragmentClass);
    }

    public TabFragmentPage(int titleResource, Class<T> fragmentClass) {
        this(titleResource, fragmentClass, new Bundle());
    }


    public int getTitleResource() {
        return titleResource;
    }

    public void setTitleResource(int titleResource) {
        this.titleResource = titleResource;
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

    public T getFragment() {
        return fragment;
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
}

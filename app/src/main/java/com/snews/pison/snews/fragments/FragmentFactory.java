package com.snews.pison.snews.fragments;

import android.support.v4.app.Fragment;

/**
 * Created by Olusegun Olaosebikan on 10/13/2016.
 */

public class FragmentFactory {

    public static Fragment getFragment(String frag) {
        if (frag.equalsIgnoreCase("For You")) {
            return new FragmentForYou();
        } else if (frag.equalsIgnoreCase("Favourites")) {
            return new FragmentFavourite();
        } else if (frag.equalsIgnoreCase("Saved")) {
            return new FragmentSaved();
        } else if (frag.equalsIgnoreCase("Search")) {
            return new FragmentSearch();
        } else if (frag.equalsIgnoreCase("Explore")) {
            return new FragmentExplore();
        }

        return null;
    }
}

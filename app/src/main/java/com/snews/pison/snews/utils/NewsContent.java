package com.snews.pison.snews.utils;

import com.snews.pison.snews.R;

import java.util.ArrayList;

/**
 * Created by Olusegun Olaosebikan on 10/12/2016.
 */
public class NewsContent {

    private static int[] image_id = {R.drawable.goal, R.drawable.espn, R.drawable.skynews, R.drawable.aj,
            R.drawable.cnn, R.drawable.nyt, R.drawable.bbc, R.drawable.nbc,
            R.drawable.cnn, R.drawable.nyt, R.drawable.bbc, R.drawable.nbc,
            R.drawable.cnn, R.drawable.nyt, R.drawable.bbc, R.drawable.nbc,
            R.drawable.cnn, R.drawable.nyt, R.drawable.bbc, R.drawable.nbc,
            R.drawable.cnn, R.drawable.nyt, R.drawable.bbc, R.drawable.nbc,
            R.drawable.cnn, R.drawable.nyt, R.drawable.bbc, R.drawable.nbc,
            R.drawable.cnn, R.drawable.nyt, R.drawable.bbc, R.drawable.nbc,
            R.drawable.cnn, R.drawable.nyt, R.drawable.bbc, R.drawable.nbc};

    private static String[] name = {"Goal", "ESPN", "Sky News", "Al jazeera",
            "Cable News Network", "The New York Times", "BBC News", "NBC News",
            "Goal", "ESPN", "Sky News", "Al jazeera",
            "Cable News Network", "The New York Times", "BBC News", "NBC News",
            "Goal", "ESPN", "Sky News", "Al jazeera",
            "Cable News Network", "The New York Times", "BBC News", "NBC News",
            "Goal", "ESPN", "Sky News", "Al jazeera",
            "Cable News Network", "The New York Times", "BBC News", "NBC News",
            "Goal", "ESPN", "Sky News", "Al jazeera"
            };

    private static int[] background_id = {R.drawable.a, R.drawable.aa, R.drawable.aaa, R.drawable.aaaa,
            R.drawable.aaaaa, R.drawable.b, R.drawable.bb, R.drawable.bbb,
            R.drawable.bbbb, R.drawable.bbbbb, R.drawable.c, R.drawable.cc,
            R.drawable.ccc, R.drawable.cccc, R.drawable.ccccc, R.drawable.d,
            R.drawable.dd, R.drawable.a, R.drawable.aa, R.drawable.aaa,
            R.drawable.bbb, R.drawable.b, R.drawable.c, R.drawable.aa,
            R.drawable.cc, R.drawable.d, R.drawable.d, R.drawable.nbc,
            R.drawable.aaaa, R.drawable.aa, R.drawable.bbbbb, R.drawable.aaaaa,
            R.drawable.aaa, R.drawable.ccccc, R.drawable.cccc, R.drawable.bbbbb};
    private static ArrayList<String> favouritesSources;

    public static int[] getImageId() { return image_id; }

    public static int getImageId( int position ) { return image_id[position]; }

    public static String[] getName() { return name; }

    public static String getName( int position ) { return name[position]; }

    public static void setFavouritesSources(ArrayList<String> fav) {
        favouritesSources = fav;
    }

    public static ArrayList<String> getFavouritesSources() { return favouritesSources; }

    public static int[] getBackgroundId() {
        return background_id;
    }

    public static void setBackgroundId(int[] background_id) {
        NewsContent.background_id = background_id;
    }
}

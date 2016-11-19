package com.snews.pison.snews.utils;

import com.snews.pison.snews.R;

import java.util.ArrayList;

/**
 * Created by Olusegun Olaosebikan on 10/12/2016.
 */
public class NewsContent {

    private static int[] image_id = {R.drawable.icon_adventure, R.drawable.icon_atlantic, R.drawable.icon_bloomberg, R.drawable.icon_cnn,
            R.drawable.icon_entertainment, R.drawable.icon_espn, R.drawable.icon_food, R.drawable.icon_hiking,
            R.drawable.icon_news, R.drawable.icon_photo, R.drawable.icon_quartz, R.drawable.icon_top,
            R.drawable.icon_adventure, R.drawable.icon_atlantic, R.drawable.icon_bloomberg, R.drawable.icon_cnn,
            R.drawable.icon_entertainment, R.drawable.icon_espn, R.drawable.icon_food, R.drawable.icon_hiking,
            R.drawable.icon_news, R.drawable.icon_photo, R.drawable.icon_quartz, R.drawable.icon_top,
            R.drawable.icon_adventure, R.drawable.icon_atlantic, R.drawable.icon_bloomberg, R.drawable.icon_cnn,
            R.drawable.icon_entertainment, R.drawable.icon_espn, R.drawable.icon_food, R.drawable.icon_hiking,
            R.drawable.icon_news, R.drawable.icon_photo, R.drawable.icon_quartz, R.drawable.icon_top};

    private static String[] name = {"Adventure", "Atlantic", "Bloomberg", "CNN", "Entertainment", "ESPN", "Food", "Hiking",
            "News", "Photo", "Quartz", "Top",
            "Adventure", "Atlantic", "Bloomberg", "CNN", "Entertainment", "ESPN", "Food", "Hiking",
            "News", "Photo", "Quartz", "Top",
            "Adventure", "Atlantic", "Bloomberg", "CNN", "Entertainment", "ESPN", "Food", "Hiking",
            "News", "Photo", "Quartz", "Top"};

    private static ArrayList<String> favouritesSources;

    public static int[] getImageId() { return image_id; }

    public static int getImageId( int position ) { return image_id[position]; }

    public static String[] getName() { return name; }

    public static String getName( int position ) { return name[position]; }

    public static void setFavouritesSources(ArrayList<String> fav) {
        favouritesSources = fav;
    }

    public static ArrayList<String> getFavouritesSources() { return favouritesSources; }
}

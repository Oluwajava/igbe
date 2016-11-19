package com.snews.pison.snews;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * Created by Olusegun Olaosebikan on 10/11/2016.
 */
public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;

    int PRIVATE = 0;

    //Share preferences file name
    private static final String PREF_NAME = "snews_welcome";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    private static final String IS_SELECTION_MADE = "boolSelection";
    public PrefManager(Context context) {
        this.context = context;

        //creates shared preference
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        //changes the value when called after the launch
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public void setSelectionMade(Boolean isSelectionMande) {
        //changes the value when selection is made
        editor.putBoolean(IS_SELECTION_MADE, isSelectionMande);
        editor.commit();
    }
    public void setFavourites(ArrayList<String> favourites) {
        //add list of favourites news sources selected by user to sharedpref
        String fav = "";
        for(String val: favourites) {
            fav = fav+" "+val;
        }
        editor.putString("favourites", fav);
        editor.commit();

    }

    public String getFavourites() {
        return pref.getString("favourites", "");
    }

    //used to check to know if the application is launched for the first time
    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public boolean isSelectionMade() { return pref.getBoolean(IS_SELECTION_MADE, false); }
}

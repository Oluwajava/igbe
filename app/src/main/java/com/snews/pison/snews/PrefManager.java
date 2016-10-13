package com.snews.pison.snews;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.Set;

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
        editor.putBoolean(IS_SELECTION_MADE, isSelectionMande);
        editor.commit();
    }
    public void setFavourites(ArrayList<String> favourites) {

        editor.putString("favourites", favourites.toArray().toString());
        editor.commit();

        Log.d("Test", "Val: "+favourites.toArray().toString());
    }

    //used to check to know if the application is launched for the first time
    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public boolean isSelectionMade() { return pref.getBoolean(IS_SELECTION_MADE, true); }
}

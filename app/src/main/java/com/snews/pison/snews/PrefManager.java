package com.snews.pison.snews;

import android.content.Context;
import android.content.SharedPreferences;

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

    //used to check to know if the application is launched for the first time
    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

}
